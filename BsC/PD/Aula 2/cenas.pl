num(z).
num(s(X)) :- num(X).

mais1(X, s(X)) :- num(X).

soma(z, Y, Y).
soma(s(X), Y, s(Z)) :- soma(X, Y, Z).

subtr(X, Y, Z) :- soma(Z, Y, X).

dobro(X, Y) :- soma(X, X, Y).

mult(z, _, z).
mult(s(X), N, M) :-
mult(X, N, K),
soma(N, K, M).

div(A, B, C) :- mult(B, C, A).