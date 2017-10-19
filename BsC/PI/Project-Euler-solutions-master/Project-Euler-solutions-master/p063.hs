{- 
 - Solution to Project Euler problem 63
 - By Nayuki Minase
 - 
 - http://nayuki.eigenstate.org/page/project-euler-solutions
 - https://github.com/nayuki/Project-Euler-solutions
 -}


{- 
 - Let's examine n^k for different values of n and k and see which
 - choices cannot possibly work (i.e. not being exactly k digits long).
 - 
 - When n = 10, for each k, n^k has exactly k+1 digits, so these are excluded.
 - By extension, when n > 10, for each k, n^k has at least k+1 digits, so these are excluded.
 - Thus we should only consider 1 <= n <= 9.
 - 
 - When n = 9, k = 22, then n^k has 21 digits which is insufficient.
 - Extending this, when n = 9 and k > 22, n^k has fewer than k digits.
 - Furthermore, when n < 9, n^k will have start to have
 - fewer than k digits at some value of k with k < 22.
 - Therefore we should only consider 1 <= k <= 21.
 - 
 - We handle the rest of the testing by brute force.
 -}
main = putStrLn (show ans)
ans = sum [1 | n <- [1..9], k <- [1..21], (numLength (n^k :: Integer)) == k]

numLength :: Integer -> Int
numLength n | n < 10    = 1
            | otherwise = (numLength (div n 10)) + 1
