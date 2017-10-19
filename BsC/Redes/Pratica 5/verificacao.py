SIZE_MAX = 20
lista = []

cenas = input("Insert Nickmane: ") 
loop = True

while loop:
	if (len(cenas) > SIZE_MAX | len(cenas)==0):
		print("nome invalido (maximo 20 caracteres)")
	else if (lista.size() == 0):
		list.append(cenas)
		loop = False
	else if (lista.size() > 0):
		for x in lista:
			if (x == cenas):
				print("nome existente insira outra vez")
				g
			else:
				continue
		list.append(cenas)
		loop = False
	else:
