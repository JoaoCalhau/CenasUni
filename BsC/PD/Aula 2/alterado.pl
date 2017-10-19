num(z).
num(s(X)) :- num(X).

mais1(X, s(X)) :- num(X).

%soma usado recursao simples
soma(z, Y, Y).
soma(s(X), Y, s(Z)) :- soma(X, Y, Z).

%subtracao usando a soma
subtr(X, Y, Z) :- soma(Z, Y, X).

%dobro usando a soma
dobro(X, Y) :- soma(X, X, Y).

%multiplicacao usando soma
mult(z, _, z).
mult(s(X), N, M) :-
   mult(X, N, K),
   soma(N, K, M).

%divisao
div(A, B, C) :- mult(B, C, A).

%potencia com a mult
pot(_, z, s(z)):-!.
pot(A, s(B), C) :-
	pot(A, B, K),
	mult(K, A, C).

%quadrado com a potencia
quadrado(X, Y) :- pot(X, s(s(z)), Y).

%less or equal
le(z, _).
le(s(A), s(B)) :- le(A, B).

%less than
lt(z, s(_)).
lt(s(A), s(B)) :- lt(A, B).

%divisao com o less than
divi(A, B, Q, R) :-
	mult(B, Q, X),
	soma(X, R, A),
	lt(R, B).

lista([]).
lista([_|T]) :- lista(T).

membro(M, [M|_]).
membro(M, [_|L]) :- membro(M, L).

prefixo([], _).
prefixo([X|P], [X|L]) :- prefixo(P, L).

sufixo(S, S).
sufixo(S, [_|L]) :- sufixo(S, L).

sublista(S, L) :- 
	prefixo(X, L),
	sufixo(S, X).

sublistax(S, L) :- prefixo(S, L).
sublistax(S, [_|L]) :- sublistax(S, L).

concatena([], L, L).
concatena([X|Xs], L, [X|Y]) :-
	concatena(Xs, L, Y).

nrev([], []).
nrev([A|R], B) :-
	nrev(R, RR),
	append(RR, [A], B).

length([], z).
length([_|T], s(x)) :- length(T, X).

sel(M, [M|Y], Y).
sel(M, [N|X], [N|Y]) :- sel(M, X, Y).

