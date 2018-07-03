from __future__ import print_function
from numpy import *
import csv
import numpy as np
import math

set_printoptions(suppress=True)				# remove scientific notations

a = []										
t = array([[0.1, 0.9], [0.01, 0.99]])		#  initial probability matrix
transitions = []							# transitions (computed with convolutions)

# reward function
def reward(x, t):
	E = 100
	S = 1
	N = 0.5
	C = 200
	Q = 800 * (math.sin(2 * math.pi * t / 24) + 1)/2
	return -E*x - N*max(0, Q-C*x) + S*min(Q, C*x)

# based on implementation made in class
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
			r.append(reward(i, t))		# rewards for all actions

		r = np.array(r)	
		a2 = np.argmax(tensordot(getDstack(), U1,(1,0)),axis=1)		# chooses the best action for utility being calculated
		U0 = r + np.max(tensordot(getDstack(), U1, (1,0)), axis=1)	
		return (U0, a2) 											

# generates initial matrix for ctaction0
def matrix(n):
	for i in range(n+1):
		b = [1]
		for j in range(0,n,1):
			b.append(0)
		a.append(b)

# make convolutions	
def makeConvolve(prev,action,n):
	temp = []
	index = 0		# starting point
	for i in range(n+1): 

		# gets the correct probabilities from "t" matrix to convolve with the previous matrix
		if action > i:	
			index = 0
		else:
			index = 1

		# convolution with previous matriz and corresponding probability from "t"
		conv = convolve(prev[i],t[index], mode	='some')	
		temp.append(conv)

	return temp

# generate the transition matrices given number of servers (n) and given previous matrix
def genTransitions(n):
	z = []
	matrix(n)			
	prev = a 		
	transitions.append(prev)
	for i in range(n):
		prev = makeConvolve(prev,i+1,n)		# make convolutions
		transitions.append(prev)	

# dstack of all transitions 
def getDstack():
	tuplo = ()
	for i in transitions:
		tuplo = tuplo + (i, )

	return dstack(tuplo)

# creates the .csv file for the graphs in the report
def graph(n):
	arrayFinal = []					# array with hours, best utility and best path given the N
	horas = []						# contains hours (0-23)

	for i in range (24):
		horas.append(i)

	maximus = [] 					# contains  every actions
 	util = []						# contain the highest utility for given t

	for t in range(24, 0, -1):		
		maximus.append(utility(t, n)[1]) 
		util.append(amax(utility(t,n)[0], axis=None, out=None, keepdims=False))

	maximus = list(reversed( maximus ))
	util = list(reversed(util))

	listaFinal = graphAux(n, maximus) 


	# instead of having per columns, inverts it and now its per line
	'''
	In the loop we transform the array of hours, the array of max utilities 
	and the array of best path based on on many servers we chose to begin with, 
	(2 array + Nservers + 1 arrays), into 24 arrays, each with the current hour, 
	max utility, and best action for the current hour
	'''
	
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

# choose best path given the server
def graphAux(n, maximus):
	
	listaTotal = []

	for i in range(n+1):		# all actions 
		lista = []
		k = i 			
		lista.append(k)

		for j in range(23): 	# choose best transition path based on the first action
			k = maximus[j][k]
			lista.append(k)
		listaTotal.append(lista)

	return listaTotal

if __name__ == '__main__':

	n = 3										# number of servers
	genTransitions(n)			# generate matriz with all transitions 0-N

	for t in range(24, 0, -1):	# output the utility with best actions
		print(utility(t, n))
	
	graph(n)					# creates a .csv file
