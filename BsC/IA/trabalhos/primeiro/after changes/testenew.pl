:- dynamic(error/1).

error(n).


%largura(X)
largura(8).

%profundidade(X)
profundidade(8).

%estado_inicial((agente, sala inicial))
estado_inicial((a, (2,2))).

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


not_possible((2,2), (3,2)).
not_possible((3,2), (2,2)).






%op(Estado_atual, operador, estado_seguinte, custo)



op((S, (X, Y)), desce, (S, (Z, Y)), 1) :- largura(Larg),
											estado_final((a,(A,B))),
											K is Y+1,
											(error(y)
										->
										  	
											X < Larg, 

										(not_possible((X, Y), (Z, Y))
											-> (retract(error(_)), asserta(error(y)),
											op((S, (X, Y)), dir, (S, (X, K)), 1))
											;retract(error(_)), asserta(error(n)), Z is X+1
											)
										;X < A,
										X < Larg, 

										(not_possible((X, Y), (Z, Y))
											-> (retract(error(_)), asserta(error(y)),
											op((S, (X, Y)), dir, (S, (X, K)), 1))
											;retract(error(_)), asserta(error(n)),Z is X+1
											)
										)
											.






op((S, (X, Y)), sobe, (S, (Z, Y)), 1) :- estado_final((a,(A,B))),
											K is Y-1,
										(error(y)
										->
										  	
											X > 1, 

										(not_possible((X, Y), (Z, Y))
											->(retract(error(_)), asserta(error(y)),
											 op((S, (X, Y)), esq, (S, (X, K)), 1))
										;retract(error(_)), asserta(error(n)),Z is X-1
										)

										; X > A,
											X > 1, 

										(not_possible((X, Y), (Z, Y))
											->(retract(error(_)), asserta(error(y)),
											 op((S, (X, Y)), esq, (S, (X, K)), 1))
										;retract(error(_)), asserta(error(n)),Z is X-1
										)
										).


op((S, (X, Y)), esq, (S, (X, Z)), 1) :- estado_final((a,(A,B))),
										K is X+1,
										(error(y)
										->
										  	
											Y > 1, 

										 (not_possible((X, Y), (X, Z))
										 	-> (retract(error(_)), asserta(error(y)),
										 		op((S, (X, Y)), desce, (S, (K, Y)), 1))
										 ;retract(error(_)), asserta(error(n)),Z is Y-1
										 )

										 ;
										 Y > B,
										  Y > 1, 

										 (not_possible((X, Y), (X, Z))
										 	-> (retract(error(_)), asserta(error(y)),
										 		op((S, (X, Y)), desce, (S, (K, Y)), 1))
										 ;retract(error(_)), asserta(error(n)),Z is Y-1
										 )
										 )
										 .



op((S, (X, Y)), dir, (S, (X, Z)), 1) :- profundidade(Prof),
										estado_final((a,(A,B))),
										K is X-1,
										(error(y)
										->
										  	
										 	Y < Prof, 

										  (not_possible((X, Y), (X, Z))
										  	-> (retract(error(_)), asserta(error(y)), 
										  		op((S, (X, Y)), sobe, (S, (K, Y)), 1))
										  ;retract(error(_)), asserta(error(n)), Z is Y+1
										  )
										  ;Y < B,
										  Y < Prof, 

										  (not_possible((X, Y), (X, Z))
										  	-> (retract(error(_)), asserta(error(y)), 
										  		op((S, (X, Y)), sobe, (S, (K, Y)), 1))
										  ; retract(error(_)), asserta(error(n)),Z is Y+1
										  )
										  )
										  .