num(z).
num(s(X)) :- num(X).

mais1(X, s(X)) :- num(X).

soma(z, Y, Y).
soma(s(X), Y, s(Z)) :- soma(X, Y, Z).

subtr(X, Y, Z) :- soma(Z, Y, X).

dobro(X, Y) :- soma(X, X, Y).

mult(z, _, z).
mult(s(X), N, M) :- mult(X, N, K), soma(N, K, M).

div(A, B, C) :- mult(B, C, A).

pot(_, z, s(z)) :- !.
pot(A, s(B), C) :- pot(A, B, K), mult(K, A, C).

quadrado(X, Y) :- pot(X, X, Y).

div(A, B, Q, R) :- mult(Q, B, K), soma(K, R, A).