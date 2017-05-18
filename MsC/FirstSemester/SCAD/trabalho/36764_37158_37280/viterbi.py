from __future__ import print_function
from numpy import *
from random import *
from fractions import Fraction
import numpy as np

bikes_stolen_by_day = []													# number of bikes stolen by day									
															
def viterbi(obv_prob, obv_seq, markov_prob,state0):							# viterbi algorithm	

	updated = state0														# previous state

	for i in obv_seq:														# for every observation
		
		predict = 	np.amax(np.array(markov_prob * updated),axis = 1)		# prediction step
		updated = np.array((obv_prob[i] * predict))							# update step

		solution = np.argwhere(updated == np.amax(updated)) 				# arg(s) of max value(s)
		bikes_stolen_by_day.append(solution.flatten().tolist())				# 

# generate random sequence for t = 15 (two weeks) (and output the sequence)
def genSeq():

	j = randint(0,1)
	if j == 1:
		print('\nReports: yes',end='')
	else:
		print('\nReports: no', end='')

	seq = [j]	

	for i in range(1,15,1):	

		j = randint(0,1)											
		if j == 1:
			print(', yes',end='')
		else:
			print(', no', end ='')
		seq.append(j)

	print('\n')
	return seq 																	

# output format
def bikesStolen():			

	if len(bikes_stolen_by_day[0]) == 1:									# remove the rect parentesis if only one element in sub list
		print('\nBikes Stolen: {0}'.format(bikes_stolen_by_day[0][0]),end='')
	else:
		print('\nBikes Stolen: {0}'.format(bikes_stolen_by_day[0]),end='')

	for i in range(1,len(bikes_stolen_by_day),1):
		if len(bikes_stolen_by_day[i]) == 1:								# remove the rect parentesis if only one element in sub list
			print(' ,{0}'.format(bikes_stolen_by_day[i][0]),end='')	
		else:
			print(' ,{0}'.format(bikes_stolen_by_day[i]),end='')
	print('\n')

def main():	

	x = Fraction(1,3)	
	y = Fraction(5,9)	
	z = Fraction(2,9)	

	obv_prob = np.array(
			[[Fraction(4,5),Fraction(17,30),Fraction(17,30),Fraction(17,30)],
			[Fraction(1,5),Fraction(13,30),Fraction(13,30),Fraction(13,30)]])				# observation probabilities
	obv_seq = np.array(genSeq())															# obv sequence 
	state0 = np.array([1,0,0,0])															# initial probabilities
	markov_prob = np.array([[x,y,z,z],[x,z,z,z],[x,z,z,z],[0,0,x,x]])						# hidden markov probabilities

	viterbi(obv_prob, obv_seq, markov_prob, state0)											# viterbi
	bikesStolen()																			# number of bikes stolen

if __name__ == "__main__":
    main()