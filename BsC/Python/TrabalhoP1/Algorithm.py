'''
Created on 07/01/2014

@author: Joao
'''

def verifica��o(vila, linha, coluna):
    return (linha>=2 and coluna>=2 and linha<len(vila) and coluna<len(vila[linha]))


def FindPath(vila, Coordenada, linha, coluna):
    caminhos=[]
    FindPath2(vila, Coordenada, linha, coluna, linha, coluna, caminhos, [])
    return caminhos

def FindPath2(vila, Coordenada, linha, coluna,  InicioLinha, InicioColuna, caminhos, stack):
    if vila[linha][coluna]=='#': return
    stack.append((linha, coluna))
    if vila[linha][coluna]=='.' or (linha==InicioLinha and coluna==InicioColuna):
        UltimoValor=vila[linha][coluna]
        vila[linha][coluna]='#'
        for index in direc��es: #percorrer as 4 direc��es
            if not verifica��o(vila, linha+index[0], coluna+index[1]): continue
            FindPath2(vila, Coordenada, linha+index[0], coluna+index[1], InicioLinha, InicioColuna, caminhos, stack)
        vila[linha][coluna]=UltimoValor
    elif vila[linha][coluna]==Coordenada:
        caminhos.append(list(stack))
    stack.pop()
    

def Intersect(A, B): #para ver se os caminhos se intersectam
    for i in A:
        if i in B:
            return True
    return False
    

def CaminhoReal(DCaminhos, vila, solu��o): #Solu��o vai ser uma lista em branco
    return CaminhoReal2(DCaminhos, vila, DCaminhos.keys(), 0, [], solu��o)

def CaminhoReal2(DCaminhos, vila, ChavesD, IndexChave, Lista, solu��o):
    global VQ
    if len(Lista)>VQ:
        VQ=len(Lista)
    if IndexChave==len(ChavesD):
        return len(Lista)==(len(vila)*len(vila[linha])) #Fazer qualquercoisa em relaz��o a isto
    for i in range(0, len(DCaminhos[ChavesD[IndexChave]])):
        caminho=DCaminhos[ChavesD[IndexChave]][i]
        if Intersect(caminho, Lista)==True: continue
        solu��o.append(i)
        if CaminhoReal2(DCaminhos, vila, ChavesD, IndexChave+1, Lista+caminho, solu��o)==True:
            return True
        solu��o.pop
    return False



direc��es=[(1,0),(-1,0),(0,1),(0,-1)] #as varias direc��es para percorrer
VQ=-1 #� uma varialvel qualquer que ir� ajudar na func��o CaminhoReal2