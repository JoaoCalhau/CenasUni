from numpy import *
import numpy as np
import math

n = 3

def reward(x, t):
	E = 100
	S = 1
	N = 0.5
	C = 200
	Q = 500 * (math.sin(2 * math.pi * t / 24) + 1)/2
	return -E*x - N*max(0, Q-C*x) + S*min(Q, C*x)

def nCr(n, r):
	f = math.factorial
	return f(n) / f(r) / f(n-r)

def prob2(l, c, a):
	if c > a:
		if l > a:			
			# certo
			return 0
		elif l == a:
			if a == 0:
				# certo
				return 1
			else:
				return ((0.99) ** a)
		elif l < a:
			return ((0.01) ** a)
	elif c == a:
		if l > a:
			return 0
		elif l == a:
			if a == 0:
				return 1
			else:
				return ((0.99) ** a)
		else:
			return float(nCr(c, l)) * ((0.01) ** (c-l)) * ((0.99) ** l)
	else:
		if l > a:
			# certo
			return 0
		elif l == a:
			# certo
			return float(((0.9) ** (a-c)) * ((0.99) ** c))
		else:
			if c > l:
				if l > 0:
					return float(a * ((0.01) ** (c-l)) * ((0.1) ** (a-l)))
				else:
					return float(((0.01) ** (c-l)) * ((0.1) ** (a-l)))
			elif c == l:
				if c == 0:			
					# certo
					return float(((0.99) ** l) * ((0.1) ** (a-l)))
				else:
					#certo
					return float(((0.99 *0.1) ** l) + ((0.01 * 0.9) ** (a-l)))
			else:
				return float(a * ((0.9) ** l) * ((0.1) ** (a-l)))


def prob(l, c, a):
	if l > a:
		return 0
	elif c >= a:
		if l == a:
			if a == 0:
				return 1
			else:
				return float((0.99) ** a)
		else:
			if c > a:
				return float((0.01) ** a)
			else:
				return float(float(nCr(c, l)) * ((0.01) ** (c-l)) * ((0.99) ** l))
	else: 
		if l == a:
			return float(((0.9) ** (a-c)) * ((0.99) ** c))
		else:
			if c > l:
				if l > 0:
					return float(a * ((0.01) ** (c-l)) * ((0.1) ** (a-l)))
				else:
					return float(((0.01) ** (c-l)) * ((0.1) ** (a-l)))
			elif c == l:
				if c == 0:
					return float(((0.99) ** l) * ((0.1) ** (a-l)))
				else:
					return float(((0.99 *0.1) ** l) + ((0.01 * 0.9) ** (a-l)))
			else:
				return float((a-c) * ((0.9) ** l) * ((0.1) ** (a-l)))


def matrix_gen(a):
	matrix = []

	for j in range(n+1):
		line = []
		for i in range(n+1):
			line.append(prob(i, j, a))
		matrix.append(line)

	print(matrix)
	return matrix



def gen(n):
	a = n +1
	t = ()
	for i in range(a):
		t = t +(np.array(matrix_gen(i)), )

	return np.dstack(t)

d = gen(n)
print(':V ')
print(d)
print('\n')

def utility(t):
	if t == 24:
		return (np.array([reward(0, 24), reward(1, 24), reward(2, 24)]), None)
	else:
		(U1, action) = utility(t+1)
		r = np.array([reward(0, t), reward(1, t), reward(2, t)])
		U0 = r + np.max(np.tensordot(d, U1, (0, 0)), axis=1)

		return (U0, None)

for t in range(24, 0, -1):
	utility(t)
