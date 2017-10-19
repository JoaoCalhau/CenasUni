
import string
matriz = []
n = 0
p = 0
c = 1
dic = dict()
l_nodes = []
l_busy = []
cmnew = dict()
n_caminhos = dict()
teste = dict()
final_path = dict()

def dados():
    n = 0
    tipo = str(input('Manual "1", por ficheiro "2"?: '))
    if tipo == '2':
        filename = input('Nome do ficheiro: ')
        return ficheiro(filename)
    elif tipo == '1':
        while n < 2 or n > 7:
            n = int(input('Tamanho da aldeia: '))
        for lat in range(n):
            matriz.append(n * [0])
        for linha in matriz:#Desenha o tabuleiro
            print (linha)
        p = 0
        while p < 1 or p > n:
            p = int(input('Número de habitantes: '))
        return casas(n,p,1)
    else:
        import main

def ficheiro(filename):
    fin = open(filename)
    l_fich = []
    new_l = []
    for line in fin:
        l_fich.append(line)
    for elemento in l_fich:#Filtrar o documento
        elemento = elemento.strip(string.whitespace)
        elemento = elemento.replace(' ', '')
        new_l.append(elemento)
    i = 2
    n = int(new_l[0])
    p = int(new_l[1])
    for lat in range(n):
        matriz.append(n * [0])
    for linha in matriz:#Desenha o tabuleiro
        print (linha)
    while i < len(new_l):
        l = list(new_l[i])
        matriz[int(l[0])][int(l[1])] = i-1
        matriz[int(l[2])][int(l[3])] = i-1
        d[i] = dados# Guardar os dados num dic.
        i+=1
    for linha in matriz:#Desenha o Tabuleiro com coordenadas
        print (linha)
    fin.close()

def casas(n,p, i = 1):
    while i <= p:
        dados = input('Insira as coordenadas: ')
        l = list(dados)
        for coordenada in l:#Verificar se as coordenadas sao numeros
            try:
                int(coordenada)
            except:
                pass
                print('Coordenadas inválidas!')
                return casas(n,p,i)
        if len(l) != 4 or l[0:2] == l[2:4]:#Comparar coordenadas do input
            print('Coordenadas Inválidas!')
            return casas(n,p,i)
        elif int(l[0]) >= n or int(l[1]) >= n:#Verif. se nao excede
            print('Coordenadas Inválidas!')
            return casas(n,p,i)
        elif int(l[2]) >= n or int(l[3]) >= n:#Verif. se nao excede
            print('Coordenadas Inválidas!')
            return casas(n,p,i) 
        elif matriz[int(l[0])][int(l[1])] != 0:#Verif. se é possivel
            print('Coordenadas Inválidas!')
            return casas(n,p,i)
        elif matriz[int(l[2])][int(l[3])] != 0:#Verif. se é possivel
            print('Coordenadas Inválidas!')
            return casas(n,p,i)
        else:
            matriz[int(l[0])][int(l[1])] = i
            matriz[int(l[2])][int(l[3])] = i
            dic[i] = (int(l[0]),int(l[1]))
            dic[i] = (int(l[2]),int(l[3]))
            l_busy.append((int(l[0]),int(l[1])))
            l_busy.append((int(l[2]),int(l[3])))
            

            # Guardar os dados num dic. e numa lista
        i+=1
        
    for linha in matriz:#Desenha o Tabuleiro com coordenadas
        print (linha)


def find_path(graph, start, end, path=[]):
    path = path + [start]
    if start == end:
        return path
    if not (start in graph):
        return None
    for node in graph[start]:
        if node not in path:
            newpath = find_path(graph, node, end, path)
            if newpath:
                return newpath
    return None

def find_nodes(n):
    for r in range(0, len(matriz)):
        for c in range(0, len(matriz[r])):
            if matriz[r][c] == 0:
                l_nodes.append((r,c))
        
    #print(l_nodes)
#descobrir por onde cada coordenada pode andar
#descobrir qual deve usar o caminho
dirs= [(1,0), (0,1), (-1,0), (0,-1)]


D = {}
#por cada linha da matriz

def funçao():
    for linha in range(0, len(matriz)):
        for coluna in range(0, len(matriz[linha])):
            if matriz[linha][coluna] == 0: #Se for um node
                continue
            if matriz[linha][coluna] in D:#Volta acima no loop do for, if done
                continue
            #Caso ache um numero, faz a funçao vizinhos
            D[matriz[linha][coluna]] = Vizinhos(matriz, matriz[linha][coluna], linha, coluna)
    #print(D)
    return filtro(dic)

def isValid(matriz,linha,coluna):
        if linha >= 0 and coluna >= 0 and linha<len(matriz) and coluna<len(matriz[linha]):
            return True

def Vizinhos(matriz, node, linha, coluna):
    Caminho = [] # lista para ser construida
    Vizinhos2(matriz, node, linha, coluna, Caminho, [], linha, coluna)
    return Caminho

def Vizinhos2(matriz, node, linha, coluna, Caminho, CaminhoActual, initL, initC):
        if matriz[linha][coluna] == '#':
            return None
        CaminhoActual.append((linha,coluna))
        if matriz[linha][coluna] == 0 or (linha == initL and coluna == initC):
                lastVal = matriz[linha][coluna]
                matriz[linha][coluna] = '#'
                for d in dirs:
                        if not isValid(matriz, linha+d[0], coluna+d[1]):
                            continue # se direçao nao for valido continua o for
                        Vizinhos2(matriz, node, linha+d[0], coluna+d[1], Caminho, CaminhoActual, initL, initC)
                matriz[linha][coluna] = lastVal
        elif matriz[linha][coluna] == node:
            Caminho.append(list(CaminhoActual))
        CaminhoActual.pop()
        


def filtro(dic, l_busy=l_busy):
    l_guarda = []
    l_teste = []
    l_fine = []
    for key in D:
        for caminho_possivel in D[key]:
            l_teste = caminho_possivel
            l_fine = l_teste[1:-1]
            #print(l_fine)
            l_guarda.append(l_fine)
        cmnew[key] = l_guarda
        l_guarda = []
    return sum_path(cmnew)

def sum_path(cmnew):
    dr = cmnew
    for key in dr:
        i = 0
        while i < len(dr[key]):
            #print('alegria' + str(i))
            i+=1
        n_caminhos[key] = i
    return list_path(cmnew)

def list_path(cmnew):
    dr = cmnew
    lista1 = []
    lista2 = []
    lista3 = []
    for key in dr:
        if key < len(dr):
            lista1.append(dr[key])
            lista2.append(dr[key+1])
        for item1 in lista1:
            for item2 in lista2:
                i = 0
                while i < 1:
                    if item1 != item2:
                        teste[key]= item1
                        teste[key+1] = item2
                        i+=2
                    else:
                        continue
                print (lista1)
        lista1 = []
        lista2 = []
    return unique_path()

def unique_path():
    lista = [1,2,3,4,5,6,7,8,9,0,3,2,1,2,3]
    for key in teste:
        for conjunto in teste[key]:
            if len(conjunto) < len(lista):
                lista = conjunto
        final_path[key] = lista
        lista = [1,2,3,4,5,6,7,8,9,0,3,2,1,2,3]
    return desenha_matriz()

def desenha_matriz():
    lista = []
    for key in final_path:
        #for conjunto in final_path[key]:
            i= 0
            while i < 1:
                for coords in final_path[key]:
                    a = list(coords)
                    if matriz[int(a[0])][int(a[1])] == 0:
                        matriz[int(a[0])][int(a[1])] = key
                i+=1
                print(list(coords))
    for linha in matriz:#Desenha o Tabuleiro com coordenadas
        print (linha)

def unfinished(matriz):
    soma = dict()
    for linha in matriz:
        for c in linha:
            if c in soma:
                soma[c] += 1
            else:
                soma[c] = 1
    #print(soma)
    for key in soma:
        if key != 0 and soma[key]:
            print('lol')



#caminhos comuns
#prioridades
#caminhos mais longo
#escrever na matriz

        
            
                        
                

'''
Tentativa de descobrir distancia minima
def check_sur(xy):
    i = 0
    while i < len(d):
        x = xy[0]
        y = xy[1]
        min_dist = 100
        for key in d:
            ndist = 0
            x1 = d[key][0]
            y1 = d[key][1]
            x2 = d[key][2]
            y2 = d[key][3] 
            if x < x1:
                ndist += x1-x
            else:
                ndist += x-x1
            if y < y1:
                ndist += y1-y
            else:
                ndist += y-y1
            if ndist < min_dist:
                min_dist = ndist
    return min_dist


def resolve(p):
    first = 0
    for key in d:
        check_sur(d[key][0:2])
    i = 1
    while i <= p:
            a = d[i]
            a_l = list(a)
            l = list()
            for coordenada in a_l:
                l.append(int(coordenada))
            x_i = l[1]
            y_i = l[0]
            x_c = l[3]
            y_c = l[2]

            search(x_i, y_i, i, x_c, y_c)
            print(a)
            print(a_l)
            print(l)
            i+=1
    for linha in matriz:#Desenha o Tabuleiro com coordenadas
        print (linha)

def search(x, y, i, x_c, y_c):
    a = str(i)
    matriz[x_c][y_c] = a
    if matriz[x][y] == a:
        print ('Feito)
        return True
    elif (matriz[x][y] != i and matriz[x][y]!= 0):
        return False

    # marcar ponto local
    matriz[x][y] = a

    if x-xc == 0:
        if x < xc and search(x, y+1,i,x_c, y_c)
            search(x, y+1,i,x_c, y_c)

    # explorar o que esta a volta
    if ((x < len(matriz)-1 and search(x+1, y,i,x_c, y_c))
        or (y > 0 and search(x, y-1,i,x_c, y_c))
        or (x > 0 and search(x-1, y,i,x_c, y_c))
        or (y < len(matriz)-1 and search(x, y+1,i,x_c, y_c))):
        return True
               
    print('')
    return False'''

dados()
funçao()



    


