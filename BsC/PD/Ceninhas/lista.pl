lista([]).
lista([_|T]) :- lista(T).

nesimo(L, N, X) :- nesimo(L, N, 1, X).
nesimo([X|_], N, N, X) :- !.
nesimo([_|L], N, V, X) :- C is V+1, nesimo(L, N, C, X).

subst(_, _, [], []).
subst(X, Y, [Y|L1], [X|L2]) :- subst(X, Y, L1, L2), !.
subst(X, Y, [_|L1], [_|L2]) :- subst(X, Y, L1, L2).

mix([], [], []).
mix([X|L1], [Y|L2], [X, Y|L3]) :- mix(L1, L2, L3).
mix([X|L1], [], [X|L3]) :- mix(L1, [], L3).
mix([], [Y|L2], [Y|L3]) :- mix([], L2, L3).