nesimo(1, [X|_], X).
nesimo(N, [_|L], X) :- nesimo(N1, L, X), N is N1+1.