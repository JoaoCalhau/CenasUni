import socket, select, sys

def prompt():
    sys.stdout.write('command? ')
    sys.stdout.flush()

if __name__ == "__main__":

    if(len(sys.argv) < 3):
        print('Usage : python %s hostname port' %(sys.argv[0],))
        sys.exit()

    host = sys.argv[1]
    port = int(sys.argv[2])

    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.settimeout(2)

    try:
        s.connect((host, port))
    except:
        print('Unable to connect')
        sys.exit()

    print('Connected to remote host. Start sending messages')
    prompt()

    while True:
        socket_list = [sys.stdin, s]

        read_sockets, write_sockets, error_sockets = select.select(socket_list, [], [])

        for sock in read_sockets:
            if sock == s:
                data = sock.recv(4096)
                if not data:
                    print('\nDIsconnected from chat server')
                    sys.exit()
                else:
                    sys.stdout.write(data)
                    prompt()
