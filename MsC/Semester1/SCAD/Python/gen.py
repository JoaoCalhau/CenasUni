import numpy as np
import math

n = 10

def nCr(n, r):
	f = math.factorial
	return f(n) / f(r) / f(n-r)

def gen(n):
	a = n + 1
	t = ()
	for i in range(a):
		t = t +(matrix_gen(i), )

	return np.dstack(t)

d = gen(n)

def matrix_gen(a):
	matrix = []

	for j in range(n):
		line = []
		for i in range(n):
			line.append(prob(i, j, a))
		matrix.append(line)

	return matrix

def prob(l, c, a):
	if l > a:
		return 0
	elif c >= a:
		if l == a:
			if a == 0:
				return 1
			else:
				return ((0.99) ** a)
		else:
			if c > a:
				return ((0.01) ** a)
			else:
				return (nCr(c, l) * ((0.01) ** (c-l)) * ((0.99) ** l))
	else:
		if l == a:
			return (((0.9) ** (a-c)) * ((0.99) ** c))
		else:
			if c > l:
				return (a * ((0.01) ** (c-l)) * ((0.1) ** (a-l)))
			elif c == l:
				if c == 0:
					return (((0.99) ** l) * ((0.1) ** (a-l)))
				else:
					return (a * ((0.99) ** l) * ((0.1) ** (a-l)))
			else:
				return (a * ((0.9) ** l) * ((0.1) ** (a-l)))