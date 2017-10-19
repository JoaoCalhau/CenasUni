# -*- coding: utf-8 -*-
import socket, select
  
if __name__ == "__main__":
      
    SOCKET_LIST = []    # lista de sockets abertos
    RECV_BUFFER = 4096  # valor recomendado na doc. do python
    PORT = 5000
         
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(("0.0.0.0", PORT))  # aceita ligações de qualquer lado
    server_socket.listen(10)
    server_socket.setblocking(0)
    
    # Add server socket to the list of readable connections
    SOCKET_LIST.append(server_socket)
 
    print("Server started on port %d" % (PORT,))
 
    while True:  # ciclo infinito

        rsocks,wsocks,esocks = select.select(SOCKET_LIST,[],[])
 
        for sock in rsocks:  # percorrer os sockets com nova informação
             
            if sock == server_socket: # há uma nova ligação
                newsock, addr = server_socket.accept()
                newsock.setblocking(0)
                SOCKET_LIST.append(newsock)
                print("New client - %s" % (addr,))
                 
            else: # há dados num socket ligado a um cliente
                try:
                    data = sock.recv(RECV_BUFFER)
                    if data:
                        sock.send('OK ... '.encode() + data)
                    else: # não há dados, o cliente fechou o socket
                        print("Client disconnected 1")
                        sock.close()
                        SOCKET_LIST.remove(sock)
                        
                except Exception as e: # excepção ao ler o socket, o cliente fechou ou morreu
                    print("Client disconnected")
                    print("Exception -> %s" % (e,))
                    sock.close()
                    SOCKET_LIST.remove(sock)

                    
