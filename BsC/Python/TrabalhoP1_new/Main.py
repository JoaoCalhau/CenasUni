if __name__ == '__main__':
    import Bfs
    import Algorithm
    import Inputs

    vila=[[1,0,0,1],
          [2,0,0,2],
          [3,0,0,3],
          [4,0,0,4]]

    D={}
    DR={}
    L=[]
    for linha in range(0, len(vila)):
        for coluna in range(0, len(vila[linha])):
            if vila[linha][coluna]==0: continue
            if vila[linha][coluna] in D: continue
            D[vila[linha][coluna]]=Algorithm.Vizinhos(vila, vila[linha][coluna], linha, coluna)
    for k in list(D.keys()):
        for index in D[k]:
            L.append(index)
            for index in L:
                a=index.pop[0][0]
                b=index.pop()
                print(Bfs.bfs(D, a, b))
                del L[:]