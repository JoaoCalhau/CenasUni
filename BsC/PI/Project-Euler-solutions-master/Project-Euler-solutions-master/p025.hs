{- 
 - Solution to Project Euler problem 25
 - By Nayuki Minase
 - 
 - http://nayuki.eigenstate.org/page/project-euler-solutions
 - https://github.com/nayuki/Project-Euler-solutions
 -}


digits = 1000
main = putStrLn (show ans)
ans = length (takeWhile (< 10 ^ (digits - 1)) fibonacci)

fibonacci = 0 : 1 : (zipWith (+) fibonacci (tail fibonacci)) :: [Integer]
