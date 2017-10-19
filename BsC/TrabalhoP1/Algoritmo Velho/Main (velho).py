import Inputs
import Algorithm

if __name__ == '__main__':
    Opção=str(input('Pretende abrir um ficheiro ou inserir uma matriz? (f/m)'))
    if Opção=='f':
        ficheiro=str(input('Qual o nome do ficheiro?'))
        f=open(ficheiro, 'r') #Lê o ficheiro
        vila=[]
        for line in f:
            L=list(line)
            vila.append(L[:len(L)-1]) #Remove o caracter de nova linha
        DCaminhos={} #dicionário vazio para guardar os caminhos
        print("[1] Generating paths...") #Tirar mais tarde
        for linha in range(0, len(vila)):
            for coluna in range(0, len(vila[linha])):
                if vila[linha][coluna]=='.': continue
                if vila[linha][coluna] in DCaminhos: continue
                DCaminhos[vila[linha][coluna]]=Algorithm.FindPath(vila, vila[linha][coluna], linha, coluna)
                print(str(vila[linha][coluna])+ " done") #tirar mais tarde
        for k in list(DCaminhos.keys()): #retirar mais tarde
            print(str(k)+": "+str(len(DCaminhos[k])))
        print("[2] Finding Set Cover...") #retirar mais tarde
        y=[]
        solução=Algorithm.CaminhoReal(DCaminhos, vila, y)
        if solução==False:
            print('Toutatis')
            Chaves=list(DCaminhos.keys())
            for i in range(0, len(Chaves)):
                print(Chaves[i])
                print(DCaminhos[Chaves[i]][y[i]])
        else:
            if solução==True:
                print('Alesia')
    else:
        if Opção=='m':
            pass
        else:
            print("insira um valor correcto. Não se esqueça que tem de ser uma string 'f' ou 'm'")
