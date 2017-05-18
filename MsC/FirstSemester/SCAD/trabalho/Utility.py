from numpy import *
import matplotlib.pyplot as plt
import numpy as np
import math

a = []
t = array([[0.1, 0.9], [0.01, 0.99]])
transitions = []

def reward(x, t):
	E = 100
	S = 1
	N = 0.5
	C = 200
	Q = 500 * (math.sin(2 * math.pi * t / 24) + 1)/2
	return -E*x - N*max(0, Q-C*x) + S*min(Q, C*x)

def utility(t, n):
	if t == 24:
		final = []
		for i in range(n+1):
			final.append(reward(i, 24))
		return (array(final), None)
	else:
		(U1, action) = utility(t+1, n)
		r = []
		for i in range(n+1):
			r.append(reward(i, t))
		r = array(r)
		a2 = np.max(tensordot(getDstack(), U1, (0, 0)), axis=1)
		U0 = r + a2
		
		return (U0, a2)

def matrix(n):
	for i in range(n+1):
		b = [1]
		for j in range(0,n,1):
			b.append(0)
		a.append(b)


def makeConvolve(prev,action,n):
	temp = []
	index = 0		# decremental index for t
	for i in range(n+1): 
		if action > i:		# 1 < 0
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

if __name__ == '__main__':
	n = 2
	genTransitions(n)

	maximus = []
	maximius = []
	counter = 0
	for t in range(24, 0, -1):
		maximus.append(utility(t, n)[1])
		if counter == 0:
			counter = counter + 1
		else:
			maximius.append(np.max(maximus[counter]))
			counter = counter + 1


	
	x = []
	xx = []
	counter = 0

	for i in array(maximus)[1:]:
		x.append(i[0])
		counter = counter + 1
		xx.append(counter)


	y = []
	yy = []
	counter = 0
	for i in array(maximus)[1:]:
		y.append(i[1])
		counter = counter + 1
		yy.append(counter)

	z = []
	zz = []
	counter = 0
	for i in array(maximus)[1:]:
		z.append(i[2])
		counter = counter + 1
		zz.append(counter)


	print z
	print zz

	linex = plt.plot(x, xx)
	plt.setp(linex, color='r', linewidth=2.0)
	liney = plt.plot(y, yy)
	plt.setp(liney, color='b', linewidth=2.0)
	linez = plt.plot(z, zz)
	plt.setp(linez, color='g', linewidth=2.0)
	plt.axis([0, 200, 0, len(maximius)-1])
	plt.show()
	
