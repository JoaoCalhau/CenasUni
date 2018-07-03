import numpy as np
import math

n = 10

def reward(x, t):
	E = 100
	S = 1
	N = 0.5
	C = 200
	Q = 500 * (sin(2 * pi * t / 24) + 1)/2
	return -E*x - N*max(0, Q-C*x) + S*min(Q, C*x)


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

def utility(x):
	if t == 24:
		return (numpy.array([reward(1, 24), reward(2, 24), reward(3, 24)]), None)
	else:
		(U, d) = utility(t+1)
		r = numpy.array([reward(0, t), reward(1, t), reward(2, t)])
		U0 = r + max(numpy.tensordot(d, U1, (0, 0)), axis=1)
		return (U0, None)

for t in range(24, 0, -1):
	print(utility(t))
