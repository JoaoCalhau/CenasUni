{- 
 - Solution to Project Euler problem 162
 - By Nayuki Minase
 - 
 - http://nayuki.eigenstate.org/page/project-euler-solutions
 - https://github.com/nayuki/Project-Euler-solutions
 -}

import Data.Char (toUpper)
import Numeric (showHex)


{- 
 - Among the set of n-digit hexadecimal numbers, how many of them:
 -   
 -   Are there in total?: 15*16^(n-1).
 -   
 -   Have no 0?: 15^n.
 -   Have no 1?: 14*15^(n-1).
 -   Have no A?: 14*15^(n-1).
 -   
 -   Have some 0?: 15*16^(n-1) - 15^n.
 -   Have some 1?: 15*16^(n-1) - 14*15^(n-1).
 -   Have some A?: 15*16^(n-1) - 14*15^(n-1).
 -   
 -   Have no 0 and have no 1?: 14^n.
 -   Have no 0 and have no A?: 14^n.
 -   Have no 1 and have no A?: 13*14^(n-1).
 -   
 -   Have some 0 or have some 1: 15*16^(n-1) - 14^n.
 -   Have some 0 or have some A: 15*16^(n-1) - 14^n.
 -   Have some 1 or have some A: 15*16^(n-1) - 13*14^(n-1).
 -   
 -   Note: (Have X) + (Have Y) = (Have X or have Y) + (Have X and have Y).
 -   Have some 0 and have some 1: (15*16^(n-1) - 15^n) + (15*16^(n-1) - 14*15^(n-1)) - (15*16^(n-1) - 14^n) = 15*16^(n-1) - 29*15^(n-1) + 14^n.
 -   Have some 0 and have some A: (15*16^(n-1) - 15^n) + (15*16^(n-1) - 14*15^(n-1)) - (15*16^(n-1) - 14^n) = 15*16^(n-1) - 29*15^(n-1) + 14^n.
 -   Have some 1 and have some A: (15*16^(n-1) - 14*15^(n-1)) + (15*16^(n-1) - 14*15^(n-1)) - (15*16^(n-1) - 13*14^(n-1)) = 15*16^(n-1) - 28*15^(n-1) + 13*14^(n-1).
 -   
 -   Have no 0 and have no 1 and have no A?    : 13^n.
 -   Have some 0 or have some 1 or have some A?: 15*16^(n-1) - 13^n.
 -   
 -   Note: (Have 0 or have 1 or have A) = (Have 0) + (Have 1) + (Have A) - (Have 0 and have 1) - (Have 0 and have A) - (Have 1 and have A) + (Have 0 and have 1 and have A).
 -   Therefore:
 -     Have 0 and have 1 and have A
 -     = (15*16^(n-1) - 13^n) - (15*16^(n-1) - 15^n) - (15*16^(n-1) - 14*15^(n-1)) - (15*16^(n-1) - 14*15^(n-1)) + (15*16^(n-1) - 29*15^(n-1) + 14^n) + (15*16^(n-1) - 29*15^(n-1) + 14^n) + (15*16^(n-1) - 28*15^(n-1) + 13*14^(n-1))
 -     = 15*16^(n-1) - 43*15^(n-1) + 41*14^(n-1) - 13^n.
 -}
main = putStrLn (map toUpper (showHex ans ""))
ans = sum [15*16^(n-1) - 43*15^(n-1) + 41*14^(n-1) - 13^n | n <- [1..16]]
