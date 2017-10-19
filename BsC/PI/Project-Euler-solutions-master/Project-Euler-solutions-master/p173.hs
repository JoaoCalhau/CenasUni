{- 
 - Solution to Project Euler problem 173
 - By Nayuki Minase
 - 
 - http://nayuki.eigenstate.org/page/project-euler-solutions
 - https://github.com/nayuki/Project-Euler-solutions
 -}


tiles = 10^6
main = putStrLn (show ans)
ans = sum [length $ takeWhile (\b -> a*a - b*b <= tiles) [(a-2),(a-4)..1] | a <- ([3..(div tiles 4)+1]::[Integer])]
