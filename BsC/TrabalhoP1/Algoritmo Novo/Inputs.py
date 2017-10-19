def habitantes(vila):
    # recebe um imput e verifica se e digito
    habitantes=e_digito(input('Numero de habitantes: '))
    while habitantes>len(vila):
    # se o digito nao for menor que o tamanho de linhas da vila
        print('Tem mais habitantes que o permitido')
        habitantes=e_digito(input('Numero de habitantes: '))
    for i in range(habitantes):
    # 'for' passa pelo numero de habitantes #
        coordenadas=(input('Coordenadas do '+str(i+1)+' habitante: '))
        coordeCasa=list(coordenadas)[0]+list(coordenadas)[1]+list(coordenadas)[2]
        coordeDestino=list(coordenadas)[4]+list(coordenadas)[5]+list(coordenadas)[6]
        coordeHabitante=int_coord(coordeCasa,vila)
        # 'str(i+1) atribui o numero do habitante#
        insert(coordeHabitante, vila, i)
        coordePoçao=int_coord(coordeDestino,vila)
        insert(coordePoçao, vila, i) 

                        
def matriz(n):
    colunas=list()
    for i in range(n):   # faz contagem 0 ate n-1 
        linhas=list()   #cria list()
        for t in range(n): # para cada i adiciona n*() adiciona a linhas
            linhas.append(0);
        colunas.append(linhas) #adiciona n*(n*()) 
    return colunas


def get_linha(x,vila):
    return vila[x] # encontra uma linha

def get_coluna(x,y,vila):
    linhas=get_linha(x,vila)
    return (linhas[y]) # encontra um coluna na linha


def insert(coord, vila, i):
    posicoes=coord.split(' ') # separa str pelo espaço
    elem=str(get_coluna(int(posicoes[1]),int(posicoes[0]),vila))
    # localiza na matriz o ponto
    while elem != '0': # se ocupado                                                          
        print('A casa ja esta ocupada')
        coord=(input('insira de novo as coordenadas: '))
        posicoes=coord.split(' ')
        elem=str(get_coluna(int(posicoes[1]),int(posicoes[0]),vila))
    else:
        vila=posicoes_vila(vila,coord,i+1)


def posicoes_vila(vila,coordeHabitante,numeroHabitantes):
    posicoes=coordeHabitante.split(' ') # separa a str pelo espaço
    vila[int(posicoes[1])][int(posicoes[0])]=numeroHabitantes
    # com a casa por ocupar insere no ponto o numero do habitante
    return vila      

def ImprimirVila(vila):
    for i in range(len(vila)): #Imprime linha a linha a matriz
        print(vila[i])


def e_digito(valor):
    while (valor.isdigit())==False: 
        # se nao for numero 
        valor=input('Insira um numero inteiro: ')
        #pede novo valor
    else:
        return int(valor)
        # atribui o type int ao valor

def int_coord(valor,vila):
    if valor!='':
        while(valor[0]).isdigit()==False or (valor[2]).isdigit()==False:
            # se houver pelo nao forem os dois digito pede novas coordenada
            print('Coordenadas introduzidas de forma incorrecta')
            print('ou com coordenadas fora do limite da matriz.')
            valor=input('Insira de novo as coordenadas: ')
        else:
            return valor
    else:
        print('Coordenadas introduzidas de forma incorrecta')
