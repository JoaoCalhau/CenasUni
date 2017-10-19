#Este algoritmo foi baseado num algoritmo, cujo nome não sabemos, mas sabemos o nome do autor: Collin J. Simpson

dirs=[(1,0),(0,1),(-1,0),(0,-1)] #Todas as direcções que por um caminho pode seguir

def isValid(vila,linha,coluna): #Verifica se a coordenada (linha, coluna) se encontra dentro da matriz em uso
        return linha>=0 and coluna>=0 and linha<len(vila) and coluna<len(vila[linha])

def Vizinhos(vila, nodo, linha, coluna):
    Caminho=[] #Lista de todos os caminhos utilizados
    Vizinhos2(vila, nodo, linha, coluna, Caminho, [], linha, coluna)
    return Caminho

def Vizinhos2(vila, nodo, linha, coluna, Caminho, CaminhoActual, initL, initC):
        if vila[linha][coluna] == '#': return #Verificação de coordenadas já percorridas
        CaminhoActual.append((linha,coluna))
        if vila[linha][coluna] == 0 or (linha == initL and coluna == initC):
                lastVal = vila[linha][coluna]
                vila[linha][coluna] = '#'
                for d in dirs: #Explorar todas as direcções
                        if not isValid(vila, linha+d[0], coluna+d[1]): continue
                        Vizinhos2(vila, nodo, linha+d[0], coluna+d[1], Caminho, CaminhoActual, initL, initC)
                vila[linha][coluna] = lastVal
        elif vila[linha][coluna] == nodo:
                Caminho.append(list(CaminhoActual))
        CaminhoActual.pop()
