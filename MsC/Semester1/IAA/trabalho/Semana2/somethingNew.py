#!/usr/bin/env python
# -*- coding: utf-8 -*-

from random import *
import csv

def diasFolga():
	x = randint(1,4)
	if x == 1:
		return "Segunda e Terça"
	elif x == 2:
		return "Terça e Quarta"
	elif x == 3:
		return "Quarta e Quinta"
	else:
		return "Quinta e Sexta"



def chamarAmigo():
	x = randint(1,2)
	if x == 1:
		return "Sim"
	else:
		return "Não"


def disponibilidade():
	x = randint(1,2)
	if x == 1:
		return "Imediata"
	else:
		return "3 dias"





def desconto():
	x = randint(1,13)
	if x<=3:
		return "Sim"
	else:
		return "Não"


def novaDisponibilidade(disp, desc):
        x = randint(1,10)
        if disp == "Imediata" and desc == "Não":
                if x<=1:
                        return "3 dias"
                else:
                        return "Imediata"
        if disp == "Imediata" and desc == "Sim":
                if x<=3:
                        return "3 dias"
                else:
                        return "Imediata"
        if disp == "3 dias" and desc == "Não":
                if x<=1:
                        return "5 dias"
                else:
                        return "3 dias"
        if disp == "3 dias" and desc == "Sim":
                if x<=3:
                        return "5 dias"
                else:
                        return "3 dias"
                
        

def maoDeObra():
	x = randint(1,10)
	if x==1:
		return "Em falta"
	else:
		return "Suficiente"


def perder():
	x = randint(1,20)
	if x==1:
		return "Extraviada"
	else:
		return "Encaminhada"






def somethingUseful():
	for i in range(300):
			linha = []

			linha.append(i)

			linha.append(diasFolga())

			linha.append(chamarAmigo())

                        disp = disponibilidade()
			linha.append(disp)

                        desc = desconto()
			linha.append(desc)

			linha.append(novaDisponibilidade(disp, desc))

			linha.append(maoDeObra())

			linha.append(perder())
			
			arrayFinal.append(linha)



arrayFinal = []
somethingUseful()

myfile = open('data.csv', 'wb')
wr = csv.writer(myfile, quoting=csv.QUOTE_ALL)
for i in arrayFinal:
	wr.writerow(i)
