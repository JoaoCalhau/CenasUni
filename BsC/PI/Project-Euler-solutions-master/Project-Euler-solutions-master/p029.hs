{- 
 - Solution to Project Euler problem 29
 - By Nayuki Minase
 - 
 - http://nayuki.eigenstate.org/page/project-euler-solutions
 - https://github.com/nayuki/Project-Euler-solutions
 -}

import List (nub)


main = putStrLn (show ans)
ans = length (nub [a^b | a <- [2..100], b <- [2..100]])
