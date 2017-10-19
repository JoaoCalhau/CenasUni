def main():
    vila=matrix(int(input('inserir a dimensão da aldeia: ')))
    while len(vila)<=2 or len(vila)>=7:
        print('A dimensão da sua vila não esta dominio de [2,7]')
        vila=matrix(int(input('inserir a dimensão da aldeia: ')))
    else:
        habitantes(vila)
        ImprimirVila(vila)
        
def habitantes(vila):
    habitantes=int(input('Numero de habitantes: '))
    while habitantes>len(vila):
        print('Tem mais habitantes que colunas')
        habitantes=int(input('Numero de habitantes: '))
    for i in range(habitantes):
        coordenadas=(input('Coordenadas do '+str(i+1)+' habitante: '))
        coordeHabitante=list(coordenadas)[0]+list(coordenadas)[1]+list(coordenadas)[2]
        coordePoçao=list(coordenadas)[4]+list(coordenadas)[5]+list(coordenadas)[6]
        insert(coordeHabitante, vila, i)
        insert(coordePoçao,vila,i)



                        
def matrix(n):
    colunas=list()
    for i in range(n):
        linhas=list()
        for t in range(n):
            linhas.append(());
        colunas.append(linhas)
    return colunas

def get_linha(x,vila):
    return vila[x]
    
def get_coluna(x,y,vila):
    linhas=get_linha(x,vila)
    return (linhas[y])


def insert(coord, vila, i):
    posiçoes=coord.split(' ')
    
    elem=str(get_coluna(int(posiçoes[1]),int(posiçoes[0]),vila))
    while elem != '()':                                                          
        print('A casa já esta ocupada')
        coord=(input('insira de novo as coordenadas da Poçao: '))
        posiçoes=coord.split(' ')
        elem=str(get_coluna(int(posiçoes[1]),int(posiçoes[0]),vila))
    else:
        vila=posições_vila(vila,coord,i+1)


def posições_vila(vila,coordeHabitante,numeroHabitantes):
    posiçoes=coordeHabitante.split(' ')
    vila[int(posiçoes[1])][int(posiçoes[0])]=numeroHabitantes
    return vila      

def ImprimirVila(vila):
    for i in range(len(vila)):
        print(vila[i])


main()
