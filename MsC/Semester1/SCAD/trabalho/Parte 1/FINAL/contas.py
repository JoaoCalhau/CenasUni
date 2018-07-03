import csv

c = 800
s = 3

array = []


def conta():
	E = 100
	S = 1
	N = 0.5
	C = 200
	for i in range(c+1):
		x = []
		x.append(i)
		for j in range(1,s+3):
			if j == s+2:
				x.append(max(x[1:s+2]))
			else:
				y =  -E*(j-1) - N*max(0, i-C*(j-1)) + S*min(i, C*(j-1))
				x.append(y)
		array.append(x)



def printList():
	for i in array:
		print(i)


conta()
printList()


myfile = open('teste1.csv', 'wb')
wr = csv.writer(myfile, quoting=csv.QUOTE_ALL)
for i in array:
	wr.writerow(i)