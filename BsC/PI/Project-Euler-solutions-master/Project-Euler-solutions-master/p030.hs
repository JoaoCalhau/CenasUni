{- 
 - Solution to Project Euler problem 30
 - By Nayuki Minase
 - 
 - http://nayuki.eigenstate.org/page/project-euler-solutions
 - https://github.com/nayuki/Project-Euler-solutions
 -}


main = putStrLn (show ans)
ans = sum [i | i <- [2..10^6 - 1], i == fifthPowerDigitSum i]

fifthPowerDigitSum 0 = 0
fifthPowerDigitSum n = (mod n 10)^5 + (fifthPowerDigitSum (div n 10))
