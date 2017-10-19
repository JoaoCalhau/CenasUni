import random
import socket, select, sys
import threading
import time

HOST = "mini.alunos.di.uevora.pt"
PORT = 143

command = []
players = dict()

def socket_read_thread(socket):
	global command

	while True:
		rsocks, wsocks, esocks = select.select([socket], [], [])


		data = socket.recv(4096)

		if not data:
			print('Disconnected from server')
			sys.exit()
		else:
			recieved =  data.decode()
			del command[:]
			command = command + recieved.split()

def criarSala(socket):
	global command

	socket.send("NICK botCenas\n".encode())
	time.sleep(0.5)

	if(command[0] == "OK_NICK"):
		socket.send("ENTER @TicTacCenas\n".encode())


#Jogo------------------------------------------------------------------------------------------

def checkLine(matrix):
	if (matrix[0][0] == 'X' and matrix[0][1] == 'X' and matrix[0][2] == 'X'):
		return True
	elif (matrix[0][0] == 'O' and matrix[0][1] == 'O' and matrix[0][2] == 'O'):
		return True
	elif (matrix[1][0] == 'X' and matrix[1][1] == 'X' and matrix[1][2] == 'X'):
		return True
	elif (matrix[1][0] == 'O' and matrix[1][1] == 'O' and matrix[1][2] == 'O'):
		return True
	elif (matrix[2][0] == 'X' and matrix[2][1] == 'X' and matrix[2][2] == 'X'):
		return True
	elif (matrix[2][0] == 'O' and matrix[2][1] == 'O' and matrix[2][2] == 'O'):
		return True
	else:
		return False

def checkColumn(matrix):
	if (matrix[0][0] == 'X' and matrix[1][0] == 'X' and matrix[2][0] == 'X'):
		return True
	elif (matrix[0][0] == 'O' and matrix[1][0] == 'O' and matrix[2][0] == 'O'):
		return True
	elif (matrix[0][1] == 'X' and matrix[1][1] == 'X' and matrix[2][1] == 'X'):
		return True
	elif (matrix[0][1] == 'O' and matrix[1][1] == 'O' and matrix[2][1] == 'O'):
		return True
	elif (matrix[0][2] == 'X' and matrix[1][2] == 'X' and matrix[2][2] == 'X'):
		return True
	elif (matrix[0][2] == 'O' and matrix[1][2] == 'O' and matrix[2][2] == 'O'):
		return True
	else:
		return False

def checkDiagonal(matrix):
	if (matrix[0][0] == 'X' and matrix[1][1] == 'X' and matrix[2][2] == 'X'):
		return True
	elif (matrix[0][0] == 'O' and matrix[1][1] == 'O' and matrix[2][2] == 'O'):
		return True
	elif (matrix[0][2] == 'X' and matrix[1][1] == 'X' and matrix[2][0] == 'X'):
		return True
	elif (matrix[0][2] == 'O' and matrix[1][1] == 'O' and matrix[2][0] == 'O'):
		return True
	else:
		return False

def checkDraw(matrix):
	for i in matrix:
		for j in i:
			if (j != 'X' or j != 'O'):
				return False
	return True

#O bot é sempre o X
def botPlay(matrix):
	line = checkLine(matrix)
	column = checkColumn(matrix)
	diagonal = checkDiagonal(matrix)

	if (line):
		return matrix
	elif (column):
		return matrix
	elif (diagonal):
		return matrix

	rn1 = random.randint(0, 2)
	rn2 = random.randint(0, 2)
	while(matrix[rn1][rn2] == 'X' or matrix[rn1][rn2] == 'O'):
		rn1 = random.randint(0, 2)
		rn1 = random.randint(0, 2)

	matrix[rn1][rn2] = 'X'	

	return matrix

def playerPlay(line, column, matrix):
	lineCheck = checkLine(matrix)
	columnCheck = checkColumn(matrix)
	diagonalCheck = checkDiagonal(matrix)

	if (lineCheck):
		return matrix
	elif (columnCheck):
		return matrix
	elif (diagonalCheck):
		return matrix

	if (matrix[line][column] == 'X' or matrix[line][column] == 'O'):
		return matrix
	else:
		matrix[line][column] = 'O'
		return matrix

def initialize():
	matrix = [['0' for x in range(3)] for x in range(3)]
	matrix[0][0] = '1'
	matrix[0][1] = '2'
	matrix[0][2] = '3'
	matrix[1][0] = '4'
	matrix[1][1] = '5'
	matrix[1][2] = '6'
	matrix[2][0] = '7'
	matrix[2][1] = '8'
	matrix[2][2] = '9'
	return matrix

if __name__ == '__main__':

	s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

	try:
		s.connect((HOST, PORT))
		s.setblocking(0)
		print('Connected')
	except:
		print('Unable to connect')
		sys.exit()

	t = threading.Thread(target = socket_read_thread, args = (s,))

	t.start()

	criarSala(s)

	while True:

		time.sleep(0.5)

		if (len(command) == 0):
			continue
		elif (command[0] == "USERENTER" and command[1] != "@TicTacCenas"):
			s.send(("MSG " + command[1] + "\\Olá utilizador " + command[1] + ". Se quiseres jogar, escreve \"play\"!\n").encode())
			del command[:]
			continue
		elif (command[0] == "MSGFROM" and command[1] != "@TicTacCenas"):
			if (command[2].startswith('\\')):
				if (command[2] == "\\play"):
					if (players.get(command[1]) == None):

						print('Novo jogador: ' + command[1])

						matrix = initialize()

						matrix = botPlay(matrix)

						players[command[1]] = matrix


						s.send(("MSG " + command[1] + " \\O primeiro a jogar sou eu, e com um X\n").encode())
						#s.send(("MSG " + command[1] + " \\" + printMatrix(tuplo[0])).encode())

						s.send(("MSG " + command[1] + " \\O bot joga:\n").encode())
						s.send(("MSG " + command[1] + " \\Board:\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(matrix[0][0]) + " | " + str(matrix[0][1]) + " | " + str(matrix[0][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(matrix[1][0]) + " | " + str(matrix[1][1]) + " | " + str(matrix[1][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(matrix[2][0]) + " | " + str(matrix[2][1]) + " | " + str(matrix[2][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\  \n").encode())

						del command[:]
					else:
						s.send(("MSG " + command[1] + " \\Jogo já a decorrer\n").encode())
						del command[:]
				elif (command[2] == "\\move"):
					if (players.get(command[1]) == None):
						s.send(("MSG " + command[1] + " \\Por favor escreva \"play\" para jogar um novo jogo...\n").encode())
						del command[:]
					else:
						matrix = players[command[1]]

						if (checkDraw(matrix)):
							s.send(("MSG " + command[1] + " \\Jogo empatado...\n").encode())
							s.send(("MSG " + command[1] + " \\Board:\n").encode())
							s.send(("MSG " + command[1] + " \\" + str(newMatrix[0][0]) + " | " + str(newMatrix[0][1]) + " | " + str(newMatrix[0][2]) + "\n").encode())
							s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
							s.send(("MSG " + command[1] + " \\" + str(newMatrix[1][0]) + " | " + str(newMatrix[1][1]) + " | " + str(newMatrix[1][2]) + "\n").encode())
							s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
							s.send(("MSG " + command[1] + " \\" + str(newMatrix[2][0]) + " | " + str(newMatrix[2][1]) + " | " + str(newMatrix[2][2]) + "\n").encode())
							s.send(("MSG " + command[1] + " \\  \n").encode())

							print('Jogo acabado com o Jogador: ' + command[1])
							players.pop(command[1], None)

							del command[:]
							continue

						if (len(command) > 3):
							if (command[3] == '1'):
								newMatrix = playerPlay(0, 0, matrix)
							elif (command[3] == '2'):
								newMatrix = playerPlay(0, 1, matrix)
							elif (command[3] == '3'):
								newMatrix = playerPlay(0, 2, matrix)
							elif (command[3] == '4'):
								newMatrix = playerPlay(1, 0, matrix)
							elif (command[3] == '5'):
								newMatrix = playerPlay(1, 1, matrix)
							elif (command[3] == '6'):
								newMatrix = playerPlay(1, 2, matrix)
							elif (command[3] == '7'):
								newMatrix = playerPlay(2, 0, matrix)
							elif (command[3] == '8'):
								newMatrix = playerPlay(2, 1, matrix)
							elif (command[3] == '9'):
								newMatrix = playerPlay(2, 2, matrix)
							else:
								s.send(("MSG " + command[1] + " \\Jogada invalida...(Só numeros de 1 a 9)\n").encode())
								del command[:]
								continue
			
						else:
							s.send(("MSG " + command[1] + " \\Jogada invalida...(Só numeros de 1 a 9)\n").encode())
							del command[:]
							continue

						#s.send(("MSG " + command[1] + " \\" + printMatrix(tuplo[0]) + "\n").encode())

						s.send(("MSG " + command[1] + " \\O jogador joga:\n").encode())
						s.send(("MSG " + command[1] + " \\Board:\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(newMatrix[0][0]) + " | " + str(newMatrix[0][1]) + " | " + str(newMatrix[0][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(newMatrix[1][0]) + " | " + str(newMatrix[1][1]) + " | " + str(newMatrix[1][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(newMatrix[2][0]) + " | " + str(newMatrix[2][1]) + " | " + str(newMatrix[2][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\  \n").encode())

						if (checkLine(newMatrix) or checkColumn(newMatrix) or checkDiagonal(newMatrix)):
							s.send(("MSG " + command[1] + "\\O jogador ganha! Bolas, bom jogo...\n").encode())
							print('Jogo acabado com o Jogador: ' + command[1])
							players.pop(command[1], None)
							del command[:]
						else:
							newestMatrix = botPlay(newMatrix)

							if (checkLine(newestMatrix) or checkColumn(newestMatrix) or checkDiagonal(newestMatrix)):
								#s.send(("MSG " + command[1] + " \\" + printMatrix(newestTuplo[0] + "\n")).encode())

								s.send(("MSG " + command[1] + " \\Board:\n").encode())
								s.send(("MSG " + command[1] + " \\" + str(newestMatrix[0][0]) + " | " + str(newestMatrix[0][1]) + " | " + str(newestMatrix[0][2]) + "\n").encode())
								s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
								s.send(("MSG " + command[1] + " \\" + str(newestMatrix[1][0]) + " | " + str(newestMatrix[1][1]) + " | " + str(newestMatrix[1][2]) + "\n").encode())
								s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
								s.send(("MSG " + command[1] + " \\" + str(newestMatrix[2][0]) + " | " + str(newestMatrix[2][1]) + " | " + str(newestMatrix[2][2]) + "\n").encode())
								s.send(("MSG " + command[1] + " \\  \n").encode())

								s.send(("MSG " + command[1] + "\\O bot ganha! Talvez com mais sorte, nabo...\n").encode())

								print('Jogo acabado com o Jogador: ' + command[1])
								players.pop(command[1], None)

								del command[:]
							else:
								#s.send(("MSG " + command[1] + " \\" + printMatrix(newestTuplo[0] + "\n")).encode())

								s.send(("MSG " + command[1] + " \\O bot joga:\n").encode())
								s.send(("MSG " + command[1] + " \\Board:\n").encode())
								s.send(("MSG " + command[1] + " \\" + str(newestMatrix[0][0]) + " | " + str(newestMatrix[0][1]) + " | " + str(newestMatrix[0][2]) + "\n").encode())
								s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
								s.send(("MSG " + command[1] + " \\" + str(newestMatrix[1][0]) + " | " + str(newestMatrix[1][1]) + " | " + str(newestMatrix[1][2]) + "\n").encode())
								s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
								s.send(("MSG " + command[1] + " \\" + str(newestMatrix[2][0]) + " | " + str(newestMatrix[2][1]) + " | " + str(newestMatrix[2][2]) + "\n").encode())
								s.send(("MSG " + command[1] + " \\  \n").encode())

								players[command[1]] = newestMatrix

								del command[:]
				elif (command[2] == "\\show"):

					if(players.get(command[1]) == None):
						s.send(("MSG " + command[1] + "\\Não há nenhum jogo a decorrer contigo...").encode())
						del command[:]
						continue
					else:
						newestMatrix = players.get(command[1])

						s.send(("MSG " + command[1] + " \\Board:\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(newestMatrix[0][0]) + " | " + str(newestMatrix[0][1]) + " | " + str(newestMatrix[0][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(newestMatrix[1][0]) + " | " + str(newestMatrix[1][1]) + " | " + str(newestMatrix[1][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\--+---+--\n").encode())
						s.send(("MSG " + command[1] + " \\" + str(newestMatrix[2][0]) + " | " + str(newestMatrix[2][1]) + " | " + str(newestMatrix[2][2]) + "\n").encode())
						s.send(("MSG " + command[1] + " \\  \n").encode())

						del command[:]
						continue

				else:
					s.send(("MSG " + command[1] + "\\Não sei o que queres dizer...\n").encode())
					del command[:]
					continue
			else:
				del command[:]
				continue
		else:
			del command[:]
			continue