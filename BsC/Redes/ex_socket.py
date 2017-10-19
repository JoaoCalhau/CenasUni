import socket

clientsocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
clientsocket.connect(('localhost', 8089))
clientsocket.send(b'Hello Motherfucker!\n')
#clientsocket.connect(('time.nist.gov', 13))
#result = clientsocket.recv(128)
#print(result.decode())
