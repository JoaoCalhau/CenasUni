from __future__ import print_function
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










def prob(l, c, a):
	'''
	print('c: ', end="")
	print(c)
	print('l: ', end="")
	print(l)
	print('a: ', end="")
	print(a)
	print("\n")
	'''

	#DONE
	if c > a:
		#certo
		if l > a:			
			return 0
		#certo
		elif l == a:
			if a == 0:
				return 1
			else:
				return ((0.99) ** a)
		#certo
		else:
			if l == 0:
				return float (((0.01) ** (a-l)) * ((0.99)**l))
			else:
				return float (nCr(a, l)  * (((0.01) ** (a-l)) * ((0.99)**l)))



	#DONE
	elif c == a:
		#certo
		if l > a:
			return 0
		#certo
		elif l == a:
			if a == 0:
				return 1
			else:
				return ((0.99) ** a)
		#certo
		else:
			return float(nCr(c, l)) * ((0.01) ** (c-l)) * ((0.99) ** l)




	# c < a
	else:
		# certo
		if l > a:
			return 0
		# certo
		elif l == a:
			return float(((0.9) ** (a-c)) * ((0.99) ** c))

		# l < a
		else:
			if c > l:
				if l > 0:
					result = 0.0
					boot = a-c
					on = 0
					for i in range(c-l,c+1):
						# nCr(c-i, l)* nCr(i, l))
						if boot < 0:
							break
						result = result + float((nCr(l, c-i) * nCr(l, on) * nCr(a-c, boot) * nCr(c, i))*(((0.01) ** i) * ((0.99) ** (c-i)) * ((0.1) ** boot) * ((0.9) ** on)))
						on = on + 1
						boot = boot -1
					return result
				else:
					return float(((0.01) ** (c-l)) * ((0.1) ** (a-c)))
			#certo
			elif c == l:
				# certo
				if c == 0:			
					return float(((0.1) ** a))
				# certo
				else:
					result = 0.0
					
					for i in range(l+1):
						if a-c-i < 0:
							break
						result = result + (nCr(l,i) * nCr(a-c,i) * (((0.01)** i) * ((0.9)**i) * ((0.1)** (a-c-i)) * ((0.99) ** (c-i))))
					return result
			else:

				result = 0.0

				func = c
				ligar = l-c
				falhaLigar = a-l

				for i in range(c+1):
					if a-c < ligar:
						break
					result = result + (nCr(a-c,ligar) * nCr(c,i) *( ((0.99) ** func) * ((0.9) ** ligar) * ((0.1) ** falhaLigar) * ((0.01) ** i)))
					func = func -1
					ligar = ligar + 1
					falhaLigar = falhaLigar -1
				return result




				#return float(a * ((0.9) ** l) * ((0.1) ** (a-l)))
































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


def prob3(l, c, a):
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


	#APAGAR
	result = 0


	for j in range(n+1):
		line = []
		for i in range(n+1):
			line.append(prob(i, j, a))
			result = result + (prob(i,j,a))

		print(result)
		result = 0	
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
