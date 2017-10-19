%largura(X)
largura(8).

%profundidade(X)
profundidade(8).

%estado_inicial((agente, sala inicial))
estado_inicial((a, (2, 2))).

%estado_final((agente, sala final)).
estado_final((a, (8,8))).

%not_possible(casa_inicial, casa_final)
not_possible((1,2), (1,3)).
not_possible((1,3), (1,2)).
not_possible((2,3), (2,2)).
not_possible((2,2), (2,3)).
not_possible((3,4), (4,4)).
not_possible((4,4), (3,4)).
not_possible((4,5), (3,5)).
not_possible((3,5), (4,5)).


%op(Estado_atual, operador, estado_seguinte, custo)
op((A, (X, Y)), desce, (A, (X, Z)), 1) :- profundidade(Prof),
										 Y < Prof+1, Z is Y+1,
										 not_possible((C1, C2), (C3, C4)),
										 ( C1 == X, C2 == Y, C3 == X, C4 == Z
										 	-> !
										 	; Z is Y+1
										 ).

/*op((A, (X, Y)), sobe, (A, (X, Z)), 1) :- Y > 0, Z is Y-1,
										 not_possible((C1, C2), (C3, C4)),
										 ( C1 == X, C2 == Y, C3 == X, C4 == Z
										  	-> !
										  	; Z is Y-1
										 ).


op((A, (X, Y)), esq, (A, (Z, Y)), 1) :- X > 0, Z is X-1,
										not_possible((C1, C2), (C3, C4)),
										( C1 == X, C2 == Y, C3 == Z, C4 == Y
											-> !
											; Z is X-1
										).

*/
op((A, (X, Y)), dir, (A, (Z, Y)), 1) :- largura(Larg),
										X < Larg+1, Z is X+1,
										not_possible((C1, C2), (C3, C4)),
										( C1 == X, C2 == Y, C3 == Z, C4 == Y
											-> !
											;  Z is X+1
										).