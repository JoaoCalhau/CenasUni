filhos(1, [2, 5]).
filhos(2, [3, 4]).
filhos(3, []).
filhos(4, []).
filhos(5, [6, 7]).
filhos(6, []).
filhos(7, []).

:- dynamic(counter/1).
counter(0).

filho(Node, Child) :-
	filhos(Node, List),
	member(Child, List).

depthFirstSearch(Node) :-
	write(Node), nl,
	incNodes,
	filho(Node, Child),
	depthFirstSearch(Child).

incNodes :-
	retract(counter(X)),
	Xs is X+1,
	assertz(counter(Xs)).

p_largura(X) :-
	( counter(_)
		-> retract(counter(_)), assertz(counter(0))
		; assertz(counter(0))
	),
	breadthFirstSearch([X]).

breadthFirstSearch([]) :- 
	counter(X), nl, 
	write('Numero de nodes visitados: '), write(X), nl.

breadthFirstSearch([Node|L]) :-
	write(Node), nl,
	incNodes,
	filhos(Node, Ls),
	append(L, Ls, Lss),
	breadthFirstSearch(Lss).

