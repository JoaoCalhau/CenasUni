dirs=[(1,0),(0,1),(-1,0),(0,-1)]

def isValid(vila,linha,coluna):
        return linha>=0 and coluna>=0 and linha<len(vila) and coluna<len(vila[linha])

def Vizinhos(vila, node, linha, coluna):
    Caminho=[]
    Vizinhos2(vila, node, linha, coluna, Caminho, [], linha, coluna)
    return Caminho

def Vizinhos2(vila, node, linha, coluna, Caminho, CaminhoActual, initL, initC):
        if vila[linha][coluna] == '#': return
        CaminhoActual.append((linha,coluna))
        if vila[linha][coluna] == 0 or (linha == initL and coluna == initC):
                lastVal = vila[linha][coluna]
                vila[linha][coluna] = '#'
                for d in dirs:
                        if not isValid(vila, linha+d[0], coluna+d[1]): continue
                        Vizinhos2(vila, node, linha+d[0], coluna+d[1], Caminho, CaminhoActual, initL, initC)
                vila[linha][coluna] = lastVal
        elif vila[linha][coluna] == node:
                Caminho.append(list(CaminhoActual))
        CaminhoActual.pop()