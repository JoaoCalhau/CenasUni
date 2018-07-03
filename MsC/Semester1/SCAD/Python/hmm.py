from numpy import *
from fractions import Fraction
import numpy as np

forwarding_probs = []
# two drunk states
# state0 -> previous state

def forwarding(obv_prob, obv_seq, markov_prob,state0):
	prev_prob = state0										# declare previous state
	for i in obv_seq:
		predict = np.array(np.dot(markov_prob,prev_prob))	# prediction step
		print(predict)
		print('\n')
		update = np.array(obv_prob[i] * predict)			# update step 1 (for some reason, tensordot and dot dont work)
		prev_prob = update / sum(update)					# update step 2	
		forwarding_probs.append(prev_prob)

		print(np.argmax(prev_prob))
		print('\n')
		for i in prev_prob:
			print(float(i))
			print(' ')
		print('\n')	


# obv_seq observed sequence
# no - 0
# yes - 1
def main():	
	x = Fraction(1,3)
	y = Fraction(5,9)
	z = Fraction(2,9)
#	mult = np.dot(np.array([[0,0,1],[Fraction(1,3),0,Fraction(2,3)],[0,Fraction(1,3),Fraction(2,3)],[0,Fraction(1,3),Fraction(2,3)]]), np.array([[0.9,0.1],[0.9,0.1],[0.2,0.8]]))
	obv_prob = np.array([[Fraction(4,5),Fraction(17,30),Fraction(17,30),Fraction(17,30)],[Fraction(1,5),Fraction(13,30),Fraction(13,30),Fraction(13,30)]])
	obv_seq = np.array([1,1,1,1])									# obv sequence
																	# obv prob
	state0 = np.array([1,0,0,0])									# state0 probs
#	markov_prob = np.array([[x,x,x,0],[y,z,z,0],[z,z,z,x],[z,z,z,x]])			# markov chain
	markov_prob = np.array([[x,y,z,z],[x,z,z,z],[x,z,z,z],[0,0,x,x]])
	forwarding(obv_prob, obv_seq, markov_prob, state0)		


	#####

	#####

if __name__ == "__main__":
    main()
