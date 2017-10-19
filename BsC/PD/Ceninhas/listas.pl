%lista/1
lista([]).
lista([_|L]) :- lista(L).

%nesimo/3
nesimo(L, N, X) :- nesimo(L, N, 1, X).
nesimo([X|_], N, N, X) :- !.
nesimo([_|L], N, V, X) :-
	C is V+1,
	nesimo(L, N, C, X).

%subst/4
subst(_, _, [], []).
subst(X, Y, [X|L1], [Y|L2]) :- subst(X, Y, L1, L2),!.
subst(X, Y, [K|L1], [K|L2]) :- subst(X, Y, L1, L2).

%mix/3
mix([], [], []).
mix([X|L1], [Y|L2], [X|Y]) :- mix(L1, L2, L3).
mix([X|L1], [], [X|L3]) :- mix(L1, [], L3).
mix([], [Y|L2], [Y|L3]) :- mix([], L2, L3).


%prefixo
prefixo([], _).
prefixo([X|P], [X|L]) :- prefixo(P, L).

%sufixo
sufixo(S, S).
sufixo(S, [_|L]) :-sufixo(S, L).


%subconj/2
subconj(S, L) :- prefixo(X, L), sufixo(S, X).