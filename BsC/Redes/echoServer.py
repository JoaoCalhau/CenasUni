import socket

serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serversocket.bind(('localhost', 8089))
serversocket.listen(5)

while True:
	sock, address = serversocket.accept()
	buf = sock.recv(64)
	if len(buf) > 0:
		sock.send(buf + 'és tu?\n'.encode()) #python 3
		#print((buf + ' és tu!'.encode()).decode()) #python2
		break

serversocket.close()
