# -*- coding: utf-8 -*-

import socket, select, sys
import threading
import time

import os
import pathlib

#HOST = '127.0.0.1'
#PORT = 5000
HOST = "mini.alunos.di.uevora.pt"
PORT = 143

teste=''
lista=[]
mensagemServidor=[]
temp1 = []
start1 = True
ficheiros = []
receptor = []

#caracteres possiveis para os nicks
valid_chars = set("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_([{)]}")

valid_passChars = set('0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~ ')


def startChat():
    global lista
    global teste
    global start1
    inpute = input('Bem vindo ao chat dos Bosses (Pimenta e Calhau) :P!!!\n' +
            'Caso tenha já conta criada neste chat, escreva "LOGIN",\n' +
            'Caso contrário insira "NOVO":\n')
    while start1:
        if (inpute == "LOGIN"):
            inpute2 = input('Insira o seu nick:\n')
            inpute3 = input('Insira agora a sua password\n')
            s.send("NICK ".encode() + inpute2.encode() + " ".encode() + inpute3.encode() +"\n".encode())
            time.sleep(0.5)
            if (lista[0] == "OK_NICK"):
                print('LOGIN realizado!\n')
                s.send("ENTER ".encode() +"@DEFAULTCenas".encode()  + "\n".encode())
                start1 = False
            elif(lista[0] == "ERR_NICK_INUSE"):
                print('Nick já escolhido por outro utlizador não registado!\n')
                inpute = input('Escreva "LOGIN" ou "NOVO"\n')
            elif(lista[0] == "ERR_NICK_ISREG"):
                print('Não foi fornecida nenhuma palavra pass!\n')
                inpute = input('Escreva "LOGIN" ou "NOVO"\n')
            elif(lista[0] == "ERR_NICK_WRONGPASS"):
                print('Palavra pass incorrecta para o nickname!\n')
                inpute = input('Escreva "LOGIN" ou "NOVO"\n')
            elif(lista[0]== "ERR_NICK"):
                print('O nick é inválido ou aconteceu outro erro\n')
                inpute = input('Escreva "LOGIN" ou "NOVO"\n')
        elif (inpute == "NOVO"):
            inpute2= input('Insira o seu nick desejado:\n')
            if (len(inpute2)<33):
                if all(char in valid_chars for char in inpute2):
                    s.send("NICK ".encode() + inpute2.encode() +"\n".encode())
                    time.sleep(1)
                    if (lista[0] == "OK_NICK"):
                        print('Nick válido!\n')
                        s.send("ENTER ".encode() +"@DEFAULTCenas".encode()  + "\n".encode())
                        start1 = False
                    elif (lista[0] == "ERR_NICK_INUSE"):
                        print('Nick já em uso, por favor insira novo nick!\n')
                        inpute = input('Escreva "LOGIN" ou "NOVO"\n')
                    elif(lista[0]== "ERR_NICK"):
                        print('O nick é inválido ou aconteceu outro erro\n')
                        inpute = input('Escreva "LOGIN" ou "NOVO"\n')
                    elif(lista[0] == "ERR_NICK_ISREG"):
                        print('O nick é inválido porque já está registado!\n')
                        inpute = input('Escreva "LOGIN" ou "NOVO"\n')
                else:
                    print('NICK contém caracteres inválidos,\n'+
                        'Por favor insira apenas letras, números, hífens, underscores e parêntesis ou chavetas!\n')
                    inpute = input('Escreva "LOGIN" ou "NOVO"\n')
            else:
                print('NICK contém mais do que 32 caracteres no total\n')
                inpute = input('Escreva "LOGIN" ou "NOVO"\n')
        else:
            print('Input incorrecto!\n')
            inpute = input('Escreva "LOGIN" ou "NOVO"\n')
            

def mudarNick():
    inpute = input('Por favor insira o nick desejado:\n')
    if (len(inpute)<33):
        if all(char in valid_chars for char in inpute):
            s.send("NICK ".encode() + inpute.encode()+"\n".encode())
        else:
            print('Nickname contém caracteres inválidos,\n'+
                'Por favor insira apenas letras, números, hífens,\n' +
                'underscores e parêntesis ou chavetas!\n')
    else:
        print('Nickname contém mais do que 32 caracteres no total\n')


def registarNick():
    inpute = input('Por favor insira o nick para Registar:\n')
    if (len(inpute)<33):
        if all(char in valid_chars for char in inpute):
            teste = True
            email = True
            inpute2= input('Pretende inserir email? Se sim digite "y", se não, digite "n":\n')
            while(teste):
                if(inpute2 == 'y'):
                    teste = False
                    email = True
                elif(inpute2 == 'n'):
                    teste = False
                    email = False
                else:
                    inpute2=input('Por favor insira "y" caso pretenda inserir email,\n'+
                        'Ou insira "n" caso não queira inserir email.\n')
            if (email == True):
                inpute3= input("Insira o email para recuperar conta caso ocorra problema!\n")
            inpute4 = input('Insira a palavra pass desejada\n')
            if(len(inpute4)> 7):
                if all(char in valid_passChars for char in inpute):
                    if (email == True):
                        s.send("REGISTER ".encode() + inpute.encode() + " ".encode() +
                         inpute3.encode()+ " \\".encode() +
                         inpute4.encode()+"\n".encode())
                    else:
                         s.send("REGISTER ".encode() + inpute.encode() + " ".encode() +
                            " \\".encode() +
                          inpute4.encode()+"\n".encode())
                else:
                    print('Inseriu caracter não válido!\nTente registar novamente!\n')
            else:
                print('Insira pelo menos 8 caracteres!\nTente registar novamente\n')                 
        else:
            print('Nickname contém caracteres inválidos,\n'+
                'Por favor insira apenas letras, números, hífens,\n' +
                'underscores e parêntesis ou chavetas!\n'+
                'Tente registar novamente!\n')
    else:
        print('Nickname contém mais do que 32 caracteres no total\n'+
            'Tente registar novamente!\n')


def recuperarNick():
    inpute = input('Por favor insira o nick para recuperar password:\n')
    if (len(inpute)<33):
        if all(char in valid_chars for char in inpute):
            s.send("RECOVER ".encode() + inpute.encode() +"\n".encode())
        else:
            print('Nickname contém caracteres inválidos,\n'+
                'Por favor insira apenas letras, números, hífens,\n' +
                'underscores e parêntesis ou chavetas!\n'+
                'Tente novamente!\n')
    else:
        print('Nickname contém mais do que 32 caracteres no total\n'+
            'Tente novamente!\n')


def enviarMensagem():
    inpute = input('Por favor insira o nome para quem quer enviar mensagem:\n')
    if (len(inpute)<33):
        if all(char in valid_chars for char in inpute):
            teste = True
            sala = True
            utilizador = True
            inpute2= input('Pretende enviar mensagem para utilizador ou sala?\n'+
                'Se para utilizador digite "u", se para sala digite "s":\n')
            while(teste):
                if(inpute2 == 'u'):
                    teste = False
                    sala = False
                    utilizador = True
                elif(inpute2 == 's'):
                    teste = False
                    utilizador = False
                    sala = True
                else:
                    inpute2=input('Por favor insira "u" caso pretenda enviar mensagem para utilizador,\n'+
                        'Ou insira "s" caso pretenda enviar mensagem para sala.\n')
            inpute2 = input('Insira a mensagem desejada\n')
            if (sala):
                s.send("MSG ".encode() + "@".encode() + inpute.encode() + " ".encode() +
                            " \\".encode() +
                          inpute2.encode()+"\n".encode())
            if (utilizador):
                s.send("MSG ".encode() + inpute.encode() + " ".encode() +
                            " \\".encode() +
                          inpute2.encode()+"\n".encode())
        else:
            print('Nickname contém caracteres inválidos,\n'+
                'Por favor insira apenas letras, números, hífens,\n' +
                'underscores e parêntesis ou chavetas!\n'+
                'Tente novamente!\n')
    else:
        print('Nickname contém mais do que 32 caracteres no total\n'+
            'Tente novamente!\n')


def entrarSala():
    inpute = input('Por favor insira o nome da sala em que pretende entrar:\n')
    s.send("ENTER ".encode() +"@".encode() + inpute.encode() + "\n".encode())


def sairSala():
    inpute = input('Por favor insira o nome da sala que pretende sair:\n')
    inpute2= input('Pretende uma mensagem de despedida?\nSe sim digite "y", se não, digite "n":\n')
    teste = True
    mensagem = True
    while(teste):
        if(inpute2 == 'y'):
            teste = False
            mensagem = True
        elif(inpute2 == 'n'):
            teste = False
            mensagem = False
        else:
            inpute2=input('Por favor insira "y" caso pretenda deixar mensagem de despedida,\n'+
                'Ou insira "n" caso não queira deixar mensagem.\n')
    if (mensagem == True):
        inpute3= input("Insira a mensagem que quer deixar de despedida da sala!\n")
        s.send("LEAVE ".encode() + "@".encode() + inpute.encode() + " ".encode() +
                 " \\".encode() +
                 inpute3.encode()+"\n".encode())
    else:
        s.send("LEAVE ".encode() + "@".encode() +  inpute.encode()  +"\n".encode())


def alterarTopico():
    inpute = input('Por favor insira o nome da sala que pretende alterar o tópico:\n')
    inpute2= input('Pretende escrever novo tópico?\nSe sim digite "y", se não, digite "n":\n')
    teste = True
    topico = True
    while(teste):
        if(inpute2 == 'y'):
            teste = False
            topico = True
        elif(inpute2 == 'n'):
            teste = False
            topico = False
        else:
            inpute2=input('Por favor insira "y" caso pretenda escrever tópico,\n'+
                'Ou insira "n" caso não queira escrever tópico.\n')
    if (topico == True):
        inpute3= input("Insira o novo tópico!\n")
        s.send("TOPIC ".encode() + "@".encode() +  inpute.encode() + " ".encode() +
                 " \\".encode() +
                 inpute3.encode()+"\n".encode())
    else:
        s.send("TOPIC ".encode() + inpute.encode() +"\n".encode())


def listarUtilSala():
    inpute = input('Por favor insira o nome da sala da qual pretente listar Utilizadores:\n')
    s.send("WHO ".encode() + "@".encode() + inpute.encode() + "\n".encode())


def listarUtilChat():
    print("Lista dos Utilizadores do chat:\n")
    s.send("ULIST".encode() +  "\n".encode())


def listarSalas():
    print("Lista de Salas do chat:\n")
    s.send("RLIST".encode() +  "\n".encode())


def sair():
    inpute2= input('Pretende escrever mensagem de despedida?\nSe sim digite "y", se não, digite "n":\n')
    teste = True
    mensagem = True
    while(teste):
        if(inpute2 == 'y'):
            teste = False
            mensagem = True
        elif(inpute2 == 'n'):
            teste = False
            mensagem = False
        else:
            inpute2=input('Por favor insira "y" caso pretenda deixar mensagem de despedida,\n'+
                'Ou insira "n" caso não queira deixar mensagem de despedida.\n')
    if (mensagem == True):
        inpute3= input("Insira a mensagem de Despedida\n")
        s.send("QUIT ".encode() + " \\".encode() +
                 inpute3.encode()+"\n".encode())
    else:
        s.send("QUIT".encode() + "\n".encode())
    print("Até à próxima :D\n")



def enviarFicheiro():
    inpute = input('Por favor insira o nome do utilizador para quem quer enviar o ficheiro:\n')
    inpute2= input('Insira a path do ficheiro que pretende enviar:\n')
    path = pathlib.Path(inpute2)
    if path.is_file():
        print('Ficheiro válido!\n') 
        b = os.path.getsize(inpute2)
        tamanho = str(b)
        s.send("SENDFILE ".encode() + inpute.encode() + " ".encode() + tamanho.encode() + 
            " \\".encode() +  inpute2.encode() + "\n".encode())
    else:
        print('Ficheiro inválido/Path errada do ficheiro!\n')


def aceitarFicheiro():
    inpute = input("Insira o identificador do ficheiro que pretende receber:\n")
    s.send("ACCEPTFILE ".encode() + inpute.encode() + "\n".encode())


def rejeitarFicheiro():
    global receptor
    inpute = input("Insira o identificador do ficheiro que pretende rejeitar:\n")
    for i in range (len(receptor)):
        if (receptor[i][0] == inpute):
            del receptor[i]
    s.send("REFUSEFILE ".encode() + inpute.encode() + "\n".encode())


def enviarParte():
    global ficheiros
    inpute = input("Insira o identificador do ficheiro que pretende enviar parte:\n")
    s.send("SENDPART ".encode() + inpute.encode() + " \\".encode() +  "\n".encode())


def cancelarTransferencia():
    inpute = input("Insira o identificador do ficheiro que pretende cancelar transferencia\n")
    inpute2= input('Pretende escrever mensagem com motivo?\nSe sim digite "y", se não, digite "n":\n')
    teste = True
    mensagem = True
    while(teste):
        if(inpute2 == 'y'):
            teste = False
            mensagem = True
        elif(inpute2 == 'n'):
            teste = False
            mensagem = False
        else:
            inpute2=input('Por favor insira "y" caso pretenda deixar mensagem com motivo,\n'+
                'Ou insira "n" caso não queira deixar mensagem com motivo.\n')
    if (mensagem == True):
        inpute3= input("Insira a mensagem com motivo de cancelar:\n")
        s.send("ABORTFILE ".encode() + inpute.encode() + " \\".encode() +
                 inpute3.encode()+"\n".encode())
    else:
        s.send("ABORTFILE ".encode() + inpute.encode() + "\n".encode())


def confirmarEnvio():
    inpute = input("Insira o identificador do ficheiro que pretende dar como terminado envio:\n")
    s.send("ENDFILE ".encode() + inpute.encode() + "\n".encode())


def mensagensServidor(temp):
    global lista
    global mensagemServidor


    #MENSAGENS DE INFORMAÇAO

    if (temp[0] == "NICKCHANGE"):
        print("O utilizador " + temp[1] + " mudou o seu nick para "+ temp[2] + "\n")
    
    elif (temp[0] == "MSGFROM"):
        if (temp[2].startswith( '\\')):
            mensagem = ' '.join(temp[2: ])
            mensagem1 = mensagem[1:]
            print("Recebeu mensagem de "+ temp[1] + ": " + mensagem1 + "\n")
        else:
            mensagem = ' '.join(temp[3: ])
            mensagem1 = mensagem[1:]
            print("Recebeu mensagem na sala "+ temp[1] + " do utilizador "+ temp[2] +
                ": " + mensagem1+ "\n")

    elif (temp[0] == "ROOMINFO"):
        if(len(temp)==2):
            print ("Está na sala : " + temp[1] + "\n")
        else:
            mensagem = ' '.join(temp[2: ])
            mensagem1 = mensagem[1:]
            print ("Está na sala : " + temp[1] + " com o tópico: " + mensagem1 + "\n")

    elif (temp[0] == "INROOM"):
        print ("Na sala " + temp[1] + ", encontram-se os seguintes utilizadores:\n")
        for utilizadores in temp[2:]:
            print(utilizadores + "\n")

    elif (temp[0] == "USERENTER"):
        print ("O utilizador " + temp[2] + " entrou na sala " + temp[1] +"\n")

    elif (temp[0] == "USERLEFT"):
        if(len(temp)== 3):
            print("O utilizador " + temp[2] + " deixou a sala " + temp[1] + "\n")
        else:
            mensagem = ' '.join(temp[3: ])
            mensagem1 = mensagem[1:]
            print("O utilizador " + temp[2] + " deixou a sala " + temp[1] + "\n"+
                "e deixou a seguinte mensagem:\n" + mensagem1 + "\n")

    elif (temp[0] == "TOPICSET"):
        if (len(temp)== 3):
            print("O utilizador " + temp[2] + " mudou o tópico da sala " + temp[1] + "\n" +
                "A sala neste momento não tem tópico definido\n")
        else:
            mensagem = ' '.join(temp[3: ])
            mensagem1 = mensagem[1:]
            print("O utilizador " + temp[2] + " mudou o tópico da sala " + temp[1] + "\n" +
                "O tópico da sala é agora: "+ mensagem1 + "\n")

    elif (temp[0] == "USERQUIT"):
        if (len(temp)== 2):
            print("O utilizador " + temp[1] + " deixou o Chat\n")
        else:
            mensagem = ' '.join(temp[2: ])
            mensagem1 = mensagem[1:]
            print("O utilizador " + temp[1] + " deixou o Chat\n" +
                "E deixou a mensagem: " + mensagem1 + "\n")

    elif (temp[0] == "USERLIST"):
        print ("No Chat, encontram-se os seguintes utilizadores:\n")
        for utilizadores in temp[1:]:
            print(utilizadores)
        print("\n\n")

    elif(temp[0] == "ROOM"):
        if(len(temp) == 3):
            print("Na Sala " + temp[1]+ " encontram-se " + temp[2] + " utilizadores.\n")
        else:
            mensagem = ' '.join(temp[3: ])
            mensagem1 = mensagem[1:]
            print("Na Sala " + temp[1]+ " encontram-se " + temp[2] + " utilizadores.\n"+
            "O tópico da sala é: " +  mensagem1 + "\n")

    elif(temp[0] == "NEWTRANSFER"):
        global ficheiros
        mensagem = ' '.join(temp[3: ])
        mensagem1 = mensagem[1:]
        binario = b''
        with open(mensagem1, "rb") as f:
            byte = f.read(1)
            while byte != b"":
                binario = binario + byte
                byte = f.read(1)
            binario = binario + byte
        ficheiros = ficheiros + [[temp[2], mensagem1, binario ]]
        s.send("REFUSEFILE ".encode() + temp[2].encode() + "\n".encode())
        print("A Transferência para o utlizador " + temp[1] +" do ficheiro " +  mensagem1 +
            " foi aceite pelo servidor\n" + "O identificador do ficheiro é: " + temp[2] + "\n")

    elif(temp[0] == "FILETRANSFER"):
        global receptor
        mensagem = ' '.join(temp[4: ])
        mensagem1 = mensagem[1:]
        receptor = receptor + [[temp[3], mensagem1, b'' ]]
        print("O utilizador " + temp[1] + " prentende enviar-lhe o ficheiro " + mensagem1 + 
            "\nO ficheiro tem de tamanho " + temp[2] + " bytes" +
            "\nO identificador do ficheiro é: " + temp[3] + "\n")

    elif(temp[0] == "FILEACCEPT"):
        print("O ficheiro com o identificador " + temp[1] + " foi aceite pelo receptor!\n")

    elif(temp[0] == "FILEREFUSE"):
        for i in range (len(ficheiros)):
            if (ficheiros[i][0] == temp[1]):
                del ficheiros[i]         
        print("O ficheiro com o identificador " + temp[1] + " foi rejeitado pelo receptor!\n")

    elif(temp[0] == "FILEPART"):
        print("Recebeu parte do ficheiro com o identificador " + temp[1] + "\n")       

    elif(temp[0] == "FILEABORT"):
        if len(temp>2):
            mensagem = ' '.join(temp[4: ])
            mensagem1 = mensagem[1:]
            print("O outro utilizador cancelou o envio do ficheido com identificador " + temp[1] + 
                "\nCom o seguinte motivo: " + mensagem1 + "\n")
        else:
            print("O outro utilizador cancelou o envio do ficheido com identificador " + temp[1] + "\n")

    elif(temp[0] == "FILEEND"):
        print("A transferência do ficheiro com identificador " + temp[1] + " terminou com sucesso!\n")



    #MENSAGENS DE SUCESSO

    elif(temp[0] == "OK_NICK"):
        print("O nickname que inseriu, " + temp[1] + ", foi aceite pelo Chat!\n")

    elif(temp[0] == "OK_NICKREGISTERED"):
        print("O nickname que registou, " + temp[1] + ", foi registado no Chat!\n")

    elif(temp[0] == "OK_RECOVER"):
        print("Um email foi enviado para o email registado, com a pass deste nickname!\n")

    elif(temp[0] == "ABORTED"):
        print("A transferência do ficheiro com identificador " + temp[1] + " foi cancelada!\n")



    #MENSAGENS DE ERRO

    elif(temp[0] == "ERR_NICK_INUSE"):
        print("O nickname que inseriu, " + temp[1] + ", já está em uso por outro cliente!\n")

    elif(temp[0] == "ERR_NICK_ISREG"):
        print("O nickname que inseriu, " + temp[1] + ", já se encontra registado,\n"+
            "e por isso necessita de inserir password!\n") 

    elif(temp[0] == "ERR_NICK_WRONGPASS"):
        print("Foi fornecida uma password incorrecta para o nickname " + temp[1] + "\n")

    elif(temp[0] == "ERR_NICK"):
       print("O nickname " + temp[1]+ " é inválido ou aconteceu outro erro!\n")

    elif(temp[0] == "ERR_NONICK"):
        print("Precisa de ter um nickname antes de poder executar outros comandos!\n")

    elif(temp[0] == "ERR_NOUSER"):
        print("Não existe nenhum utilizador com o nickname " + temp[1] + "!\n")

    elif(temp[0] == "ERR_NOROOM"):
        print("Não existe nenhuma sala com o nome " + temp[1] + "!\n")

    elif(temp[0]== "ERR_UNDELIVERED"):
        mensagem = ' '.join(temp[2: ])
        mensagem1 = mensagem[1:]
        print("A mensagem não foi entregue a " + temp[1] + ", devido a: " + mensagem1 + "!\n")

    elif(temp[0] == "ERR_ALREADYREGISTERED"):
        print("O nickname " + temp[1] + " já foi registado previamente, não podendo ser re-registado!\n")

    elif(temp[0] == "ERR_NOTALLOWED"):
        print("o nickname " + temp[1] + " é inválido, ou está reservado pelo sistema!\n")

    elif(temp[0] == "ERR_NOTREGISTERED"):
        print("o nickname " + temp[1] + " não está registado!\n")

    elif(temp[0] == "ERR_NOEMAIL"):
        print("Não foi fornecido email quando se registou o nickname " + temp[1] + 
            "\ne por isso, não é possivel recuperar password!\n")

    elif(temp[0] == "ERR_NOTINROOM"):
        print("Não é possivel sair da sala " + temp[1] + ", pois o utilizador não se encontra nessa sala!\n")

    elif(temp[0] == "ERR_NOROOM"):
        print("A sala " + temp[1] + " não existe/ não tem utilizadores!\n")

    elif(temp[0] == "ERR_ROOMNAME"):
        print("A sala que referiu é inválida!\n")

    elif(temp[0] == "ERR_NOTRANSFER"):
        print("Não existe nenhuma transferência com o identificador " + temp[1] + "\n")

    elif(temp[0] == "ERR_TXT"):
        mensagem = ' '.join(temp[1: ])
        mensagem1 = mensagem[1:]
        print("Aconteceu um erro: " + mensagem1 + "\n")




def socket_read_thread(socket):
    #global teste
    global lista
    global temp1

    while True:
        rsocks, wsocks, esocks = select.select([socket], [], [])

        data = socket.recv(4096)

        if not data:
            print('Disconnected from server')
            sys.exit()

        else:
            if(start1):
                teste1 = data.decode() 
                del lista[:]
                lista = lista + teste1.split( )
            else:
                if len(temp1)> 0:
                    teste = temp1[0] + data.decode()
                else:
                    teste = data.decode()
                del temp1[:]
                temp2 = []
                k = 0
                i = 0
                for coisa in teste:
                    i = i +1
                    if (coisa=="\n"):
                        temp2.append(teste[k:i])
                        alfa = teste[k:i].split()
                        mensagensServidor(alfa)
                        k = i
                temp1.append(teste[k:])

                



if __name__ == '__main__':
    # ligar ao servidor

    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    try :
        s.connect((HOST, PORT))
        s.setblocking(0)
        print('Connected')
    except :
        print('Unable to connect')
        sys.exit()

    # criar a thread para o socket
    t = threading.Thread(target=socket_read_thread, args=(s,))

    t.start()




    #COMEÇA AQUI AS MENSAGENS PARA O UTILIZADOR


    stringInicial = ('Está agora ligado no servidor e pode agora falar com os seus amigos\n'+
        'Para poder executar várias funções por favor veja a lista de ações possiveis:\n\n')

    stringOpcoes = ('\nMenu de Opções (este Menu) - Digite 0\n\n' +

        'Alterar Nickname - Digite 1\n\n'+

        'Registar Nickname - Digite 2\n\n'+

        'Recuperar Nickname - Digite 3\n\n'+

        'Enviar Mensagem - Digite 4\n\n'+

        'Entrar numa Sala - Digite 5\n\n'+

        'Sair de uma Sala - Digite 6\n\n'+

        'Alterar Tópico de uma Sala - Digite 7\n\n'+
        
        'Lista Utilizadores de uma Sala - Digite 8\n\n'+

        'Listar Utlizadores de Todo o Chat - Digite 9\n\n'+

        'Listar Todas as Salas e os seus Tópicos - Digite 10\n\n'+
        
        'Sair do Chat - Digite 11\n\n'+

        'Pedido para Enviar Ficheiro - Digite 12\n\n'+

        'Aceitar Recepção de Ficheiro - Digite 13\n\n'+

        'Rejeitar Recepção de Ficheiro - Digite 14\n\n'+

        'Enviar Parte de Ficheiro - Digite 15\n\n'+

        'Cancelar Transferência - Digite 16\n\n'+

        'Confirmar Envio Total de Ficheiro - Digite 17\n\n')

    startChat()

    print(stringInicial)
    print(stringOpcoes)

    # esperar por input do stdin
    
    while True:
        
        command = input('\n\nInsira o número conforme a ação desejada:\n')

        if(command == "0"):
            print(stringOpcoes)

        if(command == "1"):
            mudarNick()

        elif(command == "2"):
            registarNick()

        elif(command == "3"):
            recuperarNick()  

        elif(command == "4"):
            enviarMensagem()  

        elif(command == "5"):
            entrarSala()
        
        elif(command == "6"):
            sairSala()
       
        elif(command == "7"):
            alterarTopico()

        elif(command == "8"):
            listarUtilSala()

        elif(command == "9"):
            listarUtilChat()

        elif(command == "10"):
            listarSalas()

        elif(command == "11"):
            sair()

        elif(command == "12"):
            enviarFicheiro()

        elif(command == "13"):
            aceitarFicheiro()

        elif(command == "14"):
            rejeitarFicheiro()

        elif(command == "15"):
            enviarParte()

        elif(command == "16"): 
            cancelarTransferencia()

        elif(command == "17"): 
            confirmarEnvio()    

        else:
            print('Comando Inválido!\nCaso pretenda ver Menu de Opções, digite "0"')    

        time.sleep(1)
