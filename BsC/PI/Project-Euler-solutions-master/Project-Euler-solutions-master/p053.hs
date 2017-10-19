{- 
 - Solution to Project Euler problem 53
 - By Nayuki Minase
 - 
 - http://nayuki.eigenstate.org/page/project-euler-solutions
 - https://github.com/nayuki/Project-Euler-solutions
 -}


main = putStrLn (show ans)
ans = sum [1 | n <- [1..100], r <- [0..n], binomial n r > 10^6]

binomial n r = div (product [n-r+1..n]) (product [1..r])
