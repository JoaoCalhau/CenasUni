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
        if vila[linha][coluna] == '.' or (linha == initL and coluna == initC):
                lastVal = vila[linha][coluna]
                vila[linha][coluna] = '#'
                for d in dirs:
                        if not isValid(vila, linha+d[0], coluna+d[1]): continue
                        Vizinhos2(vila, node, linha+d[0], coluna+d[1], Caminho, CaminhoActual, initL, initC)
                vila[linha][coluna] = lastVal
        elif vila[linha][coluna] == node:
                Caminho.append(list(CaminhoActual))
        CaminhoActual.pop()


def EncontrarCaminhos(DCaminhos, vila, solução, linha):
        return EncontrarCaminhos2(DCaminhos, vila, list(DCaminhos.keys()), 0, [], solução, linha)
 
def intersects(A, B):
        for x in A:
                if x in B:
                        return True
        return False
 
QQ = -1
def EncontrarCaminhos2(DCaminhos, vila, ChavesD, IndexChaves, Lista, solucao, linha):
        global QQ
        if len(Lista) > QQ:
                QQ = len(Lista)
        if IndexChaves == len(ChavesD):
                return len(Lista) == len(vila)*len(vila[linha])
        for i in range(0, len(DCaminhos[ChavesD[IndexChaves]])):
                path = DCaminhos[ChavesD[IndexChaves]][i]
                if intersects(path, Lista) == True: continue
                solucao.append(i)
                if EncontrarCaminhos2(DCaminhos, vila, ChavesD, IndexChaves+1, Lista+path, solucao, linha) == True:
                        return True
                solucao.pop()
        return False
        

if __name__ == "__main__":
        Choice=str(input('Pretende utilizar um ficheiro ou inserir a matriz? (f/m) '))
        if Choice=='f':
                ficheiro=str(input('Qual o nome do ficheiro? '))
                f = open(ficheiro, 'r')
                vila = []
                for line in f:
                        L = list(line)
                        vila.append(L[:len(L)-1])
                DCaminhos = {}
                print("[1] Generating paths...")
                for linha in range(0,len(vila)):
                        for coluna in range(0, len(vila[linha])):
                                if vila[linha][coluna] == '.': continue
                                if vila[linha][coluna] in DCaminhos: continue
                                DCaminhos[vila[linha][coluna]] = Vizinhos(vila, vila[linha][coluna], linha, coluna)
                                print(str(vila[linha][coluna]) + " done") 
        for Chaves in list(DCaminhos.keys()):
            print(str(Chaves) + ": " + str(len(DCaminhos[Chaves])))
        print("[2] Finding set cover...")
        y = []
        for linha in range(0, len(vila)):
                sol = EncontrarCaminhos(DCaminhos, vila, y, linha)
        if sol==False:
                print('Alesia')
        if sol==True:
                print('Toutatis')
                Chaves = list(DCaminhos.keys())
                for i in range(0, len(Chaves)):
                        print(Chaves[i])
                        print(DCaminhos[Chaves[i]][y[i]])
        else:
            if Choice=='m':
                pass
            else:
                print('Verifique se inseriu um dos dois valores seguintes: f/m')
