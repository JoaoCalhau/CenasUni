import socket, select, sys
import threading
import time

HOST = 'mini.alunos.di.uevora.pt'
PORT = 143


def socket_read_thread(socket):
    while True:
        rsocks, wsocks, esocks = select.select([socket], [], [])

        data = socket.recv(4096)
        if not data:
            print('Disconnected from server')
            sys.exit()
        else:
            print(data.decode())


if __name__ == '__main__':
    # ligar ao servidor

    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    try :
        s.connect((HOST, PORT))
        s.setblocking(0)
    except :
        print('Unable to connect')
        sys.exit()

    # criar a thread para o socket
    t = threading.Thread(target=socket_read_thread, args=(s,))

    t.start()

    # esperar por input do stdin

    while True:
        command = input('')

        s.send(command.encode())
        time.sleep(1)
