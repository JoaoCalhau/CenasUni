import socket

clientsocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
clientsocket.connect(('localhost', 8089))

#Send the input of the user
buff = input('Enter something: \n')
clientsocket.send(buff.encode())

#recieve the input and check if it's the same
buf = clientsocket.recv(128)
print(buff == buf.decode())
