mais1(X, Y) :- Y is X+1.

dobro(X, Y) :- Y is X*X.

map(_, [], []) :- !.
map(p, [X|L1], [Z|L2]) :- assertz(p(X, Z)), !, map(p, L1, L2).