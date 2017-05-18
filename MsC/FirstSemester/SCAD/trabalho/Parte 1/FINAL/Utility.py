from __future__ import print_function
from numpy import *
import csv
import numpy as np
import math




n = 3
a = []
t = array([[0.1, 0.9], [0.01, 0.99]])
transitions = []

def reward(x, t):
	E = 100
	S = 1
	N = 0.5
	C = 200
	Q = 800 * (math.sin(2 * math.pi * t / 24) + 1)/2
	return -E*x - N*max(0, Q-C*x) + S*min(Q, C*x)


def utility(t, n):
	if t == 24:
		final = []
		for i in range(n+1):
			final.append(reward(i, 24))

		return (array(final), None)
	else:
		(U1, _) = utility(t+1, n)

		r = []
		for i in range(n+1):
			r.append(reward(i, t))

		r = np.array(r)
		a2 = np.argmax(tensordot(getDstack(), U1,(1,0)),axis=1)
		U0 = r + np.max(tensordot(getDstack(), U1, (1,0)), axis=1)
		return (U0, a2)

def matrix(n):
	for i in range(n+1):
		b = [1]
		for j in range(0,n,1):
			b.append(0)
		a.append(b)

def makeConvolve(prev,action,n):
	temp = []
	index = 0	
	for i in range(n+1): 
		if action > i:	
			index = 0
		else:
			index = 1

		conv = convolve(prev[i],t[index], mode='some')
		temp.append(conv)

	return temp

def genTransitions(n):
	z = []
	matrix(n)
	prev = a
	transitions.append(prev)
	for i in range(n):	
		prev = makeConvolve(prev,i+1,n)
		transitions.append(prev)

def getDstack():
	tuplo = ()
	for i in transitions:
		tuplo = tuplo + (i, )

	return dstack(tuplo)


def graph(n):
	arrayFinal = []

	horas = []
	for i in range (24):
		horas.append(i)

	maximus = []
	util = []
	for t in range(24, 0, -1):
		maximus.append(utility(t, n)[1])
		util.append(amax(utility(t,n)[0], axis=None, out=None, keepdims=False))
	maximus = list(reversed( maximus ))
	util = list(reversed(util))

	listaFinal = something(n, maximus)

	for i in range(24):
			x = []
			x.append(horas[i])
			x.append(util[i])
			for j in listaFinal:
				x.append(j[i])
			arrayFinal.append(x)

	myfile = open('utility.csv', 'wb')
	wr = csv.writer(myfile, quoting=csv.QUOTE_ALL)
	for i in arrayFinal:
		wr.writerow(i)



def something(n, maximus):
	listaTotal = []
	for i in range(n+1):
		lista = []
		k = i
		lista.append(k)
		for j in range(23):
			k = maximus[j][k]
			lista.append(k)
		listaTotal.append(lista)

	return listaTotal





if __name__ == '__main__':


	genTransitions(n)

	for t in range(24, 0, -1):
		print(utility(t, n))
	
	graph(n)
