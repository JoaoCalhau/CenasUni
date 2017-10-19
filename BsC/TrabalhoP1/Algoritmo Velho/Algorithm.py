def verificação(vila, linha, coluna):
    return (linha>=0 and coluna>=0 and linha<len(vila) and coluna<len(vila[linha]))


def FindPath(vila, Coordenada, linha, coluna):
    caminhos=[]
    FindPath2(vila, Coordenada, linha, coluna, linha, coluna, caminhos, [])
    return caminhos

def FindPath2(vila, Coordenada, linha, coluna,  InicioLinha, InicioColuna, caminhos, stack):
    if vila[linha][coluna]=='#':
        return
    stack.append((linha, coluna))
    if vila[linha][coluna]=='.' or (linha==InicioLinha and coluna==InicioColuna):
        UltimoValor=vila[linha][coluna]
        vila[linha][coluna]='#'
        for index in direcções: #percorrer os caminhos
            if not verificação(vila, linha+index[0], coluna+index[1]): continue
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
    

def CaminhoReal(DCaminhos, vila, solução): #Solução vai ser uma lista em branco
    return CaminhoReal2(DCaminhos, vila, list(DCaminhos.keys()), 0, [], solução)

def CaminhoReal2(DCaminhos, vila, ChavesD, IndexChave, Lista, solução):
    global VQ
    if len(Lista)>VQ:
        VQ=len(Lista)
    if IndexChave==len(ChavesD):
        return len(Lista)==(len(vila)*len(vila[linha]))
    for i in range(0, len(DCaminhos[ChavesD[IndexChave]])):
        caminho=DCaminhos[ChavesD[IndexChave]][i]
        if Intersect(caminho, Lista)==True: continue
        solução.append(i)
        if CaminhoReal2(DCaminhos, vila, ChavesD, IndexChave+1, Lista+caminho, solução)==True:
            return True
        solução.pop
    return False



direcções=[(1,0),(-1,0),(0,1),(0,-1)] #as varias direcções para percorrer
VQ=-1 #é uma varialvel qualquer que irá ajudar na funcção CaminhoReal2
