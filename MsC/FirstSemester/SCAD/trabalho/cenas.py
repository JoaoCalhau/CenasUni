from numpy import *
set_printoptions(suppress=True)

a = []


a0 = array([[1, 0, 0], [1, 0, 0], [1, 0, 0]])
t = array([[0.1, 0.9], [0.01, 0.99]])
x = []

x.append(convolve(convolve(a0[0], t[0], mode='some'), t[0], mode='some'))
x.append(convolve(convolve(a0[1], t[1], mode='some'), t[0], mode='some'))
x.append(convolve(convolve(a0[2], t[1], mode='some'), t[1], mode='some'))

print array(x)

'''
x0 = convolve(a0[0], t[0], mode='some')
x1 = convolve(a0[1], t[1], mode='some')
x2 = convolve(a0[2], t[1], mode='some')
#x3 = convolve(a0[3], t[1], mode='some')

x = array([x0, x1, x2])
print x

y0 = convolve(x[0], t[0], mode='some')
y1 = convolve(x[1], t[0], mode='some')
y2 = convolve(x[2], t[1], mode='some')
#y3 = convolve(x[3], t[1], mode='some')

y = array([y0, y1, y2])
print y
'''
#z0 = convolve(y[0], t[0], mode='some')
#z1 = convolve(y[1], t[0], mode='some')
#z2 = convolve(y[2], t[0], mode='some')
#z3 = convolve(y[3], t[1], mode='some')

#z = array([z0, z1, z2])
#print z
'''
# initial matrix 
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

#	print 'TEMP Matrix: '
#	print temp
#	print '\n'
	return temp

def numpyEsUmSonho(n):
	z = []
	matrix(n)
	prev = a
	transitions.append(prev)
	for i in range(n):	
		prev = makeConvolve(prev,i+1,n)
#		print 'Previous: '
#		print prev
#		print '\n'
		transitions.append(prev)

numpyEsUmSonho(3)
print 'Transitions: \n'
counter = 0
for i in transitions:
	print 'Transition {0}:'.format(counter)
	for j in i:
		print '\t{0}'.format(j)
	print '\n'
	counter = counter + 1
print '\n'



def 
'''	