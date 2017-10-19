'''
Created on 07/01/2014

@author: Joao
'''

def main():
    vila=matrix(int(input('inserir a dimens�o da aldeia: ')))
    while len(vila)<=2 or len(vila)>=7:
        print('A dimens�o da sua vila n�o esta dominio de [2,7]')
        vila=matrix(int(input('inserir a dimens�o da aldeia: ')))
    else:
        habitantes(vila)
        
def habitantes(vila):
    habitantes=int(input('Numero de habitantes: '))
    while habitantes>len(vila):
        print('Tem mais habitantes que colunas')
        habitantes=int(input('Numero de habitantes: '))
    for i in range(habitantes):
        coordeHabitante=(input('Casa do '+str(i+1)+' habitante: '))
        insert(coordeHabitante, vila, i)
        coordePo�ao=(input('local da '+str(i+1)+' po��o: '))
        insert(coordePo�ao, vila, i) 


                        
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
    posi�oes=coord.split(' ')
    elem=str(get_coluna(int(posi�oes[1]),int(posi�oes[0]),vila))
    while elem != '()':                                                          
        print('A casa j� esta ocupada')
        coord=(input('insira de novo as coordenadas: '))
        posi�oes=coord.split(' ')
        elem=str(get_coluna(int(posi�oes[1]),int(posi�oes[0]),vila))
    else:
        vila=posi��es_vila(vila,coord,i+1)


def posi��es_vila(vila,coordeHabitante,numeroHabitantes):
    posi�oes=coordeHabitante.split(' ')
    vila[int(posi�oes[1])][int(posi�oes[0])]=numeroHabitantes
    ImprimirVila(vila)
    return vila      

def ImprimirVila(vila):
    for i in range(len(vila)):
        print(vila[i])