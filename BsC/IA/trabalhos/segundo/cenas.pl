size(9).

estado_inicial(Estado) :-
	gerar_estado(Estado1),
	fill_pos(Estado1, Estado).

gerar_estado(Estado) :-
	functor(Estado, estado, 2), arg(1, Estado, Tab), arg(2, Estado, []),
	size(S),
	gerar_tab(Tab2, S),
	flatten(Tab2, Tab).


fill_pos(Estado, NovoEstado) :-
	Lista = [v(p(9,9),[1,2,3,4,5,6,7,8,9],9)],
	Estado = e(NAfect, []),
	NovoEstado = e(NAfect2, Afect),
	fill(NAfect, Lista, NAfect2, Afect).

fill([H], Lista, [H], []) :-
	H = v(P, D, V),
	\+member(v(P, D, V), Lista).

fill([H], Lista, [], [v(P, D, V)]) :-
	H = v(P, D, V),
	member(v(P, D, V), L).

fill([H|T], Lista, [H|T2], Resto) :-
	H = v(P, D, V),
	\+member(v(P, D, V), Lista),
	fill(T, Lista, T2, Resto).

fill([H|T], Lista, T2, [v(P, D, V)|Resto]) :-
	H = v(P, D, V),
	member(v(P, D, V), Lista),
	fill(T, Lista, T2, Resto).


gerar_tab(Lista, Size) :-
	gerar_tab(Lista, 1, Size).

gerar_tab([H], N, N) :-
	gerar_coluna(H, N, N).

gerar_tab(H)
