mais1(X, Y) :- Y is X+1.

dobro(X, Y) :- Y is X*X.

%1
map(_, [], []).
map(P, [X|L1], [Y|L2]) :-
	Z =.. [P, X, Y],
	Z,
	map(P, L1, L2).

%3
:- dynamic(calc/0).
process(A) :- format("-> ~w~n", [A]).

process(A) :- integer(A), asserta(i(A)).

process(add) :- 
	retract(i(A)),
	retract(i(B)),
	!,
	C is A+B,
	asserta(i(C)),
	!.

process(sub) :-
	retract(i(A)),
	retract(i(B)),
	!,
	C is A-B,
	asserta(i(C)),
	!.

process(mult) :-
	retract(i(A)),
	retract(i(B)),
	!,
	C is A*B,
	asserta(i(C)),
	!.

process(div) :-
	retract(i(A)),
	retract(i(B)),
	!,
	C is B/A,
	asserta(i(C)),
	!.

process(dump) :-
	retract(i(A)),
	format("-> ~w~n", [A]),
	assertz(i(A)).

process(print) :-
	retract(i(A)),
	format("-> ~w~n", [A]),
	asserta(i(A)).

process(clear) :-
	retractall(i(A)).

calc :-
	repeat, read(A), process(A), fail.