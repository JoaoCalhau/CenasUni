# cliente exemplo 
import socket, select, sys
 
def prompt() :
    sys.stdout.write('command? ')
    sys.stdout.flush()
 
#main function
if __name__ == "__main__":
     
    if(len(sys.argv) < 3) :
        print('Usage : python %s hostname port' % (sys.argv[0],))
        sys.exit()
     
    host = sys.argv[1]
    port = int(sys.argv[2])
     
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.settimeout(2)
     
    # liga ao host remoto
    try :
        s.connect((host, port))
    except :
        print('Unable to connect')
        sys.exit()
     
    print('Connected to remote host. Start sending messages')
    prompt()

    
    while True:
        message = sys.stdin.readline()
        s.send(message.encode())
        
        socket_list = [s]
         
        # Espera por um socket com dados
        read_sockets, write_sockets, error_sockets = select.select(socket_list , [], [])
         
        for sock in read_sockets:
            #chegou uma mensagem no socket
            if sock == s:
                data = sock.recv(4096)
                if not data :
                    print('\nDisconnected from server')
                    sys.exit()
                else :
                    sys.stdout.write(data.decode())
             
                    
        prompt()
