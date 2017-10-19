{- 
 - Solution to Project Euler problem 116
 - By Nayuki Minase
 - 
 - http://nayuki.eigenstate.org/page/project-euler-solutions
 - https://github.com/nayuki/Project-Euler-solutions
 -}


{- 
 - How many ways can a row n units long be filled with black squares 1 unit long
 - and colored tiles m units long? Denote this quantity as ways[n].
 - Compute n = 0 manually as a base case.
 - 
 - Now assume n >= 1. Look at the leftmost item and sum up the possibilities.
 - * If the item is a black square, then the rest of the row
 -   is allowed to be anything of length n-1. Add ways[n-1].
 - * If the item is a colored tile of length m where m <= n, then the
 -   rest of the row can be anything of length n-m. Add ways[n-m].
 - 
 - At the end, return ways[length]-1 to exclude the case where the row is all black squares.
 -}
len = 50
main = putStrLn (show ans)
ans = sum [(ways m len) - 1 | m <- [2..4]]

ways _ 0 = 1
ways m n = (waysMemo !! m !! (n-1)) + (if n >= m then (waysMemo !! m !! (n-m)) else 0)
waysMemo = [[ways m n | n <- [0..]] | m <- [0..]]
