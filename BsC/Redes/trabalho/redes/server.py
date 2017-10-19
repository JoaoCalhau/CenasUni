# -*- coding: utf-8 -*-
import socket, select
  
if __name__ == "__main__":


    

    # NICKNAMES tem só nicks a usar no momento
    NICKNAMES = []

    #NICKNAMEREG tem os nicks registados com a password em tuplos
    NICKNAMESREG = []
      
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
                    
                    
                    
                    #data, addr1 = sock.recvfrom(RECV_BUFFER)
                    data = sock.recv(RECV_BUFFER)


                    

                    if data:

                        teste= data.decode()
                        lista= teste.split( )
                        
                        boleano1= False
                        boleano2 = False
                        boleano3 = False
                        boleano4 = False
                        tuplotemp = None
                        remove = -1
                        remove2 = -1

                        if (lista[0] == 'PRINTNOME'):
                            for endr in NICKNAMES:
                                if (sock== endr[0]):
                                    print(endr[1])
                                    print("\n este é o teu nick")



                        
                        if (lista[0] == 'PRINTLISTA'):
                            for cena in NICKNAMES:
                                print(cena[1])
                                print("\n este é o teu nick ")
                                print("\n")






                        if (lista[0] == 'NICK'):
                            if(len(lista) == 1):
                                #escreveu só NICK sem mais informaçao
                                sock.send('NIC_ERR'.encode())


                            elif(len(lista) > 3):
                                #escreveu mais coisas do que devia
                                sock.send('NIC_ERR'.encode())

                            #se escreveu NICK + o seu nick, n insere password    
                            elif(len(lista) == 2):

                                #vê na lista dos NICKNAMES sem registo (sock, nick), se o nick está lá
                                for nick in NICKNAMES:
                                    if (lista[1]== nick[1]):
                                        boleano1 = True

                                #vê na lista dos NICKNAMESREG com registo (sock, nick, password, mail), se o nick está lá
                                for nicks in NICKNAMESREG:
                                    if(lista[1] == nicks[1]):
                                        boleano2 = True

                                #vê se tem um socket ja registado, e se sim aponta o valor de remove para saber qual alterar
                                #removendo o valor dos nicks e adicionado com o socket e o novo nick
                                #maneira de modificar o nick
                                for sock1 in NICKNAMES:
                                    remove += 1
                                    if (sock== sock1[0]):
                                        tuplotemp =sock1
                                        boleano3 = True
                                        break
                                    

                                for sock2 in NICKNAMESREG:
                                    remove2 += 1
                                    if (sock== sock2[0]):
                                        tuplotemp=sock2
                                        boleano4 = True 
                                        break         
                                    
                                #boleano é verdadeiro caso encontre o nick na lista dos nao registados        
                                if boleano1:
                                    sock.send('\nERR_NICK_INUSE  '.encode()+ lista[1].encode() + '\n'.encode())


                                #boleano é verdadeiro caso encontre o nick na lista dos nao registados        
                                elif boleano2:
                                    sock.send('\nERR_NICK_ISREG  '.encode()+ lista[1].encode() + '\n'.encode())
                                    

                                #se nick não estiver a ser utilizado, e este cliente ja tinha nick substitui na lista
                                #na lista de nicknames
                                elif boleano3:
                                    del NICKNAMES[remove]
                                    print(lista[1])
                                    NICKNAMES = NICKNAMES + [(sock,lista[1])]
                                    sock.send('\nOK_NICK  '.encode()+ lista[1].encode() + '\n'.encode())


                                 #se nick não estiver a ser utilizado, e este cliente ja tinha nick substitui na lista
                                 #na lista de nicknamesRegistados
                                elif boleano4:
                                    del NICKNAMESREG[remove2]
                                    NICKNAMESREG = NICKNAMESREG + [(sock,lista[1], tuplotemp[2], tuplotemp[3])]
                                    sock.send('\nOK_NICK  '.encode()+ lista[1].encode() + '\n'.encode())



                              
                                #caso nao tivesse nick, é adicionado
                                else:
                                    NICKNAMES = NICKNAMES + [(sock,lista[1])]
                                    sock.send('\nOK_NICK  '.encode()+ lista[1].encode() + '\n'.encode())
                            


                            #se escreveu NICK + o seu nick e uma password 
                            elif(len(lista) == 3):


                                #procura pelos nicks registados, ja que escreveu nick e password
                                 #vê na lista dos NICKNAMES sem registo (sock, nick, password, mail), se o nick está lá
                                 #boleano1 fica true se encontra nome igual
                                 #boleano2 fica true se encotra pass igual no nome igual
                                 #se encontrar nome e pass igual, boleano2 fica false e sai do ciclo for
                                 #caso a pass seja diferente boleano2 fica a true
                                 #ou seja se boleano1 tiver False é porque nao encontrou o nome, logo dá erro de nick
                                for nicks in NICKNAMESREG:
                                    remove = remove + 1
                                    if(lista[1] == nicks[1]):
                                        boleano1 = True
                                        if(lista[2]== nicks[2]):
                                            tuplotemp = nicks
                                            sock.send('\nOK_NICK  '.encode()+ lista[1].encode() + '\n'.encode())
                                            bolean2 = False
                                            break
                                        else:   
                                            boleano2 = True
                                            break


                                #se nao encontrou nick nos registados, mesmo dando nick e password
                                #dá erro de nick pois só devia ter dado o nick e nao dar um nick que nao existe e uma password
                                #para isso registava-se e nao fazia isto!
                                if (boleano1==False):
                                    sock.send('\nERR_NICK  '.encode()+ lista[1].encode() + '\n'.encode())

                                

                                #se nick existe registado, e a pass está errada
                                elif boleano2:
                                    sock.send('\nERR_NICK_WRONGPASS  '.encode()+ lista[1].encode() + '\n'.encode())


                                #caso em que fez login, faz update ao sock
                                elif(boleano1 and (boleano2==False)):
                                    del NICKNAMESREG[remove]
                                    NICKNAMESREG = NICKNAMESREG + [(sock,tuplotemp[1], tuplotemp[2], tuplotemp[3])]


                        


                        #sock.send('OK ... '.encode() + lista[0].strip)



                        #sock.send('OK ... '.encode() + data)
                    else: # não há dados, o cliente fechou o socket
                        print("Client disconnected 1")
                        sock.close()
                        SOCKET_LIST.remove(sock)
                        
                except Exception as e: # excepção ao ler o socket, o cliente fechou ou morreu
                    print("Client disconnected")
                    print("Exception -> %s" % (e,))
                    sock.close()
                    SOCKET_LIST.remove(sock)

                    
