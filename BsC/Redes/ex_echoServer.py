import socket

serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serversocket.bind(('localhost', 8089))
serversocket.listen(5)

while True:
    sock, adress = serversocket.accept()
    buf = sock.recv(64)
    if len(buf) > 0:
        sock.send(buf)
        break

serversocket.close()
