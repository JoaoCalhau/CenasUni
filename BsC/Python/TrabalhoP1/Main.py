'''
Created on 09/01/2014

@author: Joao
'''

import Inputs
import Algorithm

if __name__ == '__main__':
    Op��o=str(input('Pretende abrir um ficheiro ou inserir uma matriz? (f/m)'))
    if Op��o=='f':
        ficheiro=str(input('Qual o nome do ficheiro?'))
        f=open(ficheiro, 'r') #L� o ficheiro
        vila=[]
        for line in f:
            L=list(line)
            vila.append(L[:len(L)-1]) #Remove o caracter de nova linha
        DCaminhos={} #dicion�rio vazio para guardar os caminhos
        for linha in range(0, len(vila)):
            for coluna in range(0, len(vila[linha])):
                if vila[linha][coluna]=='.': continue
                if vila[linha][coluna] in DCaminhos: continue
                DCaminhos[vila[linha][coluna]]=Algorithm.FindPath(vila, vila[linha][coluna], linha, coluna)
        y=[]
        solu��o=Algorithm.CaminhoReal(DCaminhos, vila, y)
        print(solu��o)
        Chaves=DCaminhos.keys()
        for i in range(0, len(Chaves)):
            print(Chaves[i])
            print(DCaminhos[Chaves[i]][y[i]])
    else:
        if Op��o=='m':
            pass
        else:
            print("insira um valor correcto. N�o se esque�a que tem de ser uma string 'f' ou 'm'")