import csv

Q = 800
s = 5

array = []

# each line contains: number of clientes, 0 to N reward for that number of clients, max reward
# for example: 500 clients, equals to 500 lines
# with 5 servers, each line contains:
# 1 colum number of clients, 5+1 columns with rewards by n servers, 1 colum max reward

def conta():
	E = 100
	S = 1
	N = 0.5
	C = 200
	for i in range(Q):
		x = []
		x.append(i) 			# adds number of clients to the first position of x
		for j in range(1,s+3):			# add reward of 0 - N servers (s+1) and include max reward = s+1 including
			if j == s+2:	# last position contains max reward
				x.append(max(x[1:s+2])) 
			else:				# 0 - N servers with y reward
				y =  -E*(j-1) - N*max(0, i-C*(j-1)) + S*min(i, C*(j-1))
				x.append(y)
		array.append(x)



def printList():
	for i in array:
		print(i)


conta()
printList()

myfile = open('graph.csv', 'wb')
wr = csv.writer(myfile, quoting=csv.QUOTE_ALL)
for i in array:
	wr.writerow(i)