import Algorithm
import Inputs

if __name__ == '__main__':
    opçao=str(input('Pretende inserir coordenadas (1), ou inserir ficheiro(2)? ')) #Seleção de método
    if opçao=='1':
        vila=Inputs.matriz(Inputs.e_digito(input('Inserir a dimensao da aldeia: '))) #Recebe um input, vê se é digito e constroi a matriz atravez da função 'matrix'
        while len(vila)<2 or len(vila)>7: #Verificação dos limites da matriz
            print('A dimensão da sua aldeia não está no dominio de [2,7]')
            vila=Inputs.matriz(Inputs.e_digito(input('Inserir a dimensao da aldeia: ')))
        else:
            Inputs.habitantes(vila)
            Inputs.ImprimirVila(vila)
        D={}
        for linha in range(0, len(vila)):
           for coluna in range(0, len(vila[linha])):
                if vila[linha][coluna]== 0: continue
                if vila[linha][coluna] in D: continue
                D[vila[linha][coluna]]=Algorithm.Vizinhos(vila, vila[linha][coluna], linha, coluna) #Encontra todos os caminhos possiveis atravez da função 'Vizinhos'
        print(' ')
        print('Dicionário com os caminhos: ')
        for k in list(D.keys()): #Um print simples para mostrar o que está no dicionário
            print(' ')
            print(k,': ',D[k])


    else:
        if opçao=='2':
            ficheiro=str(input('Qual o nome do ficheiro? '))
            f=open(ficheiro, 'r') #Ler o ficheiro
            L=f.read().split('\n') #Passar todos os elementos do ficheiro para uma lista
            l=L[2:] #Divide as coordenadas numa lista, e a dimensão e os habitates noutra lista
            del L[2:]
            vila=Inputs.matriz(int(L[0]))
            if len(vila)<2 or len(vila)>7: #Verificação dos limites da matriz
                print('A dimensão da sua vila não está no dimino de [2,7], verifique o ficheiro')
            else:
                habitantes=int(L[1])
                if habitantes>=len(vila) or habitantes<0: #Verificação do número de habitantes
                    print('Erro no numero de habitantes, verifique ficheiro')
                else:
                    for i in range(habitantes):
                        coordenadas=l[i]
                        coordeCasa=coordenadas[0]+coordenadas[1]+coordenadas[2]
                        coordeDestino=coordenadas[4]+coordenadas[5]+coordenadas[6]
                        coordeHabitante=Inputs.int_coord(coordeCasa,vila)
                        Inputs.insert(coordeHabitante, vila, i)
                        coordePoçao=Inputs.int_coord(coordeDestino,vila)
                        Inputs.insert(coordePoçao, vila, i)
                    
                    Inputs.ImprimirVila(vila) #Imprime a vila
                    D={} 
                    L=[]
                    l=[]
                    for linha in range(0, len(vila)): #percorre todos os pares (linha, coluna) e insere-os na função 'Vizinhos' para encontrar todos os caminhos
                        for coluna in range(0, len(vila[linha])):
                            if vila[linha][coluna]== 0: continue
                            if vila[linha][coluna] in D: continue
                            D[vila[linha][coluna]]=Algorithm.Vizinhos(vila, vila[linha][coluna], linha, coluna)
                    print(' ')
                    print('Dicionário com os caminhos: ')
                    for k in list(D.keys()):
                        print(' ')
                        print(k,': ',D[k])


    print(' ')       
    fim=input('deseja repetir? (S/N) ')
    if fim=='N' or fim=='n':
        print('o programa irá encerrar')

    while fim =='S' or fim=='s': #Mesmo que em cima, mas com um ciclo while para o programa correr outra vez caso seja inserido o valor 's' na variavel acima definida
        opçao=str(input('Pretende inserir coordenadas (1), ou inserir ficheiro(2)? '))
        if opçao=='1':
            vila=Inputs.matriz(Inputs.e_digito(input('Inserir a dimensao da aldeia: ')))
            while len(vila)<2 or len(vila)>7:
                print('A dimensao da sua aldeia nao esta dominio de [2,7]')
                vila=Inputs.matriz(Inputs.e_digito(input('Inserir a dimensao da aldeia: ')))
            else:
                Inputs.habitantes(vila)
                Inputs.ImprimirVila(vila)
            D={}
            L=[]
            for linha in range(0, len(vila)):
               for coluna in range(0, len(vila[linha])):
                    if vila[linha][coluna]== 0: continue
                    if vila[linha][coluna] in D: continue
                    D[vila[linha][coluna]]=Algorithm.Vizinhos(vila, vila[linha][coluna], linha, coluna)
            print('Dicionário com os caminhos: ')
            for k in list(D.keys()):
                print(' ')
                print(k,': ',D[k])

            print(' ')
            fim=input('deseja repetir? (S/N) ')

          

        else:
            if opçao=='2':
                ficheiro=str(input('Qual o nome do ficheiro? '))
                f=open(ficheiro, 'r')
                L=f.read().split('\n')
                l=L[2:]
                del L[2:]
                vila=Inputs.matriz(int(L[0]))
                if len(vila)<2 or len(vila)>7:
                    print('A dimensão da sua vila não está no dimino de [2,7], verifique o ficheiro')
                else:
                    habitantes=int(L[1])
                    if habitantes>=len(vila) or habitantes<0:
                        print('Erro no numero de habitantes, verifique ficheiro')
                    else:
                        
                        for i in range(habitantes):
                            coordenadas=l[i]
                            coordeCasa=coordenadas[0]+coordenadas[1]+coordenadas[2]
                            coordeDestino=coordenadas[4]+coordenadas[5]+coordenadas[6]
                            coordeHabitante=Inputs.int_coord(coordeCasa,vila)
                            Inputs.insert(coordeHabitante, vila, i)
                            coordePoçao=Inputs.int_coord(coordeDestino,vila)
                            Inputs.insert(coordePoçao, vila, i)
                        
                        Inputs.ImprimirVila(vila)
                        D={}
                        L=[]
                        l=[]
                        for linha in range(0, len(vila)):
                            for coluna in range(0, len(vila[linha])):
                                if vila[linha][coluna]== 0: continue
                                if vila[linha][coluna] in D: continue
                                D[vila[linha][coluna]]=Algorithm.Vizinhos(vila, vila[linha][coluna], linha, coluna)
                        print(' ')
                        print('Dicionário com os caminhos: ')
                        for k in list(D.keys()):
                            print(' ')
                            print(k,': ',D[k])

                print(' ')
             
'''             
retomamos a dizer, como dito no relatorio, este programa nao encontra
intersecta os caminhos,dando origem a um dicionario com os caminhos correctos,
este codigo entao imprime os dicionarios e a posiçao onde se encontra os habitantes/poçao
'''
