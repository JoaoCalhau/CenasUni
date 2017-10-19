abp(X) :- var(X), !.
abp(n(L, _, R)) :- abp(L), abp(R).

ins(A, V) :- var(A), !, A = n(_, V, _).
ins(n(L, Y, R), V) :- V<Y, !, ins(V, L).
ins(n(L, Y, R), V) :- V>Y, !, ins(V, R).