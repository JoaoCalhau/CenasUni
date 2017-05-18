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
		return "2 a 3 dias"


def desconto():
	x = randint(1,13)
	if x<=3:
		return "Metade"
	else:
		return "Normal"


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
	for i in range(200):
			linha = []

			linha.append(i)

			linha.append(diasFolga())

			linha.append(chamarAmigo())

			linha.append(disponibilidade())

			linha.append(desconto())

			linha.append(maoDeObra())

			linha.append(perder())
			
			arrayFinal.append(linha)



arrayFinal = []
somethingUseful()

myfile = open('data.csv', 'wb')
wr = csv.writer(myfile, quoting=csv.QUOTE_ALL)
for i in arrayFinal:
	wr.writerow(i)