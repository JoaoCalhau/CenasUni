ver_restricoes(E) :-
	ver_tudo(E),
	ver_linhas(E),
	ver_colunas(E).

ver_tudo(e(_, Afect)) :-
	findall(V, member(v(p(_, _), _, V), Afect), L),
	all_diff(L).

ver_linhas(e(_, Afect)) :-
	findall(V1, member(v(p(1, Y), _, V1), Afect), R1),
	findall(V2, member(v(p(2, Y), _, V2), Afect), R2),
	findall(v3, member(v(p(3, Y), _, V3), Afect), R3),
	sum_list(R1, S1), sum_list(R2, S2), sum_list(R3, S3),
	S1 = 6, S2 = 15, S3 = 24.

ver_colunas(e(_, Afect)) :-
	findall(V1, member(v(p(X, 1), _, V1), Afect), R1),
	findall(V2, member(v(p(X, 2), _, V2), Afect), R2),
	findall(v3, member(v(p(X, 3), _, V3), Afect), R3),
	sum_list(R1, S1), sum_list(R2, S2), sum_list(R3, S3),
	S1 = 6, S2 = 15, S3 = 24.


all_diff([]).
all_diff([H|T]) :-
	\+member(H, T),
	all_diff(T).