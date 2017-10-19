abp(X) :- var(X), !.
abp(n(L,_,R)) :- abp(L), abp(R).

%1.ins/2
ins(X, A) :- var(A), !, A = n(_, X, _).
ins(X, n(L, Y, R)) :- X<Y, !, ins(X, L).
ins(X, n(L, Y, R)) :- X>Y, !, ins(X, R).

%2.look/2
look(X, A) :- var(A), !, A = n(_, A, _).
look(X, n(L, Y, R)) :- X<Y, !, look(X, L).
look(X, n(L, Y, R)) :- X>Y, !, look(X, R).
look(X, n(_, X, _)) :- !.

%3.all/2
allp(A, []) :- var(A). %pre-ordem
allp(n(L, V, R), L) :- allp(L, Ls), allp(R, Rs), append([V|Ls], Rs, L).

alli(A, []) :- var(A). %in-order
alli(n(L, V, R), L) :- alli(L, Ls), alli(R, Rs), append(Ls, [V|Rs], L).