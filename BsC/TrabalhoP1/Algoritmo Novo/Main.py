import Algorithm
import Inputs

if __name__ == '__main__':
    opçao=str(input('Pretende inserir coordenadas (1), ou inserir ficheiro(2)? ')) #Selecção simples
    if opçao=='1': #Opção para inserção de coordenadas
        vila=Inputs.matriz(Inputs.e_digito(input('Inserir a dimensao da aldeia: '))) #Recebe um input, vê se é digito e controi a matriz atravez da função 'matrix'
        while len(vila)<2 or len(vila)>7: #Verificação dos limites da matriz
            print('A dimensão da sua vila não está no dominio de [2,7]')
            vila=Inputs.matriz(Inputs.e_digito(input('Inserir a dimensao da aldeia: ')))
        else:
            Inputs.habitantes(vila)
            Inputs.ImprimirVila(vila)
        D={}
        DR={}
        L=[]
        l=[]
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
        if opçao=='2': #Opção para ficheiros
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
                if habitantes>len(vila):
                    print('Tem mais habitantes que o permitido, verifique o ficheiro') #Verificação do número de habitantes
                for i in range(habitantes):
                    coordenadas=l[i]
                    coordeCasa=list(coordenadas)[0]+list(coordenadas)[1]+list(coordenadas)[2]
                    coordeDestino=list(coordenadas)[4]+list(coordenadas)[5]+list(coordenadas)[6]
                    coordeHabitante=Inputs.int_coord(coordeCasa,vila)
                    Inputs.insert(coordeHabitante, vila, i)
                    coordePoçao=Inputs.int_coord(coordeDestino,vila)
                    Inputs.insert(coordePoçao, vila, i)
                Inputs.ImprimirVila(vila)
            D={} #Criação de um dicionário
            L=[] #Criação de duas listas
            l=[]
            for linha in range(0, len(vila)):
                for coluna in range(0, len(vila[linha])):
                    if vila[linha][coluna]== 0: continue
                    if vila[linha][coluna] in D: continue
                    D[vila[linha][coluna]]=Algorithm.Vizinhos(vila, vila[linha][coluna], linha, coluna) #O mesmo que em cima, encontra todos os caminhos possiveis atravez da função 'Vizinhos'
            print(' ')
            print('Dicionário com os caminhos: ')
            for k in list(D.keys()): #Um print simples para mostrar o que está no dicionário
                print(k,': ',D[k])
                print(' ')
        else:
            print('Insira apenas 1 ou 2')
            
