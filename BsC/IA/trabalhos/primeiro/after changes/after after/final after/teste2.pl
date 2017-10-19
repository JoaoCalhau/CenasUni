:- dynamic(visited/1).
visited((2, 2)).

%largura(Y)
largura(8).

%profundidade(X)
profundidade(8).

%estado_inicial((agente, sala inicial))
estado_inicial((2,2)).

%estado_final((agente, sala final)).
estado_final((8,8)).

%not_possible(casa_inicial, casa_final)
not_possible((1,2), (1,3)).
not_possible((1,3), (1,2)).
not_possible((2,3), (2,2)).
not_possible((2,2), (2,3)).
not_possible((3,4), (4,4)).
not_possible((4,4), (3,4)).
not_possible((4,5), (3,5)).
not_possible((3,5), (4,5)).


%not_possible((2,2), (3,2)).
%not_possible((3,2), (2,2)).

%op(Estado_atual, operador, estado_seguinte, custo)

op((X, Y), desce, (Z, Y), 1) :- 
		profundidade(Prof),
		X < Prof,
		Z is X+1,
		( visited((Z,Y))
			-> fail	
			; ( not_possible((X, Y), (Z, Y))
				-> fail
				; asserta(visited((Z,Y)))
			  )
		).


op((X, Y), dir, (X, Z), 1) :- 
		largura(Larg),
		Z is Y+1,
		Y < Larg,
		( visited((X,Z))
			-> fail
		  	;(not_possible((X, Y), (X, Z))
		  		-> fail
		  		; asserta(visited((X,Z)))
		  	)
		).


op((X, Y), sobe, (Z, Y), 1) :- 
		X > 1,
		Z is X-1,
		( visited((Z,Y))
			-> fail
		  	; ( not_possible((X, Y), (Z, Y))
				-> fail
				; asserta(visited((Z,Y)))
			  )
		).


op((X, Y), esq, (X, Z), 1) :- 
		Y > 1,
		Z is Y-1,
		( visited((X,Z))
			-> fail
			 ; ( not_possible((X, Y), (X, Z))
		 		-> fail
		 		; asserta(visited((X,Z)))
			   )
		 ).



%HEURISTICA DISTANCIA DO FIM
%Somando a diferença entre X inicial e X final E diferença ente Y inicial e Y final
%Neste Caso direita e baixo devem ter prioridades iguais, e assim expandir ambos

h((Cx,Cy),C):-
	estado_final((Fx,Fy)),
	(Cx>=Fx
		-> K1 is Cx-Fx,
		(Cy>=Fy
			-> K2 is Cy-Fy,
				C is K1 + K2
			;  K2 is Fy-Cy,
				C is K1 + K2
			)
		; K1 is Fx-Cx,
		 (Cy>=Fy
			-> K2 is Cy-Fy,
				C is K1 + K2
			;  K2 is Fy-Cy,
				C is K1 + K2
			)
		).


% Compara apenas valor de Y inicial e Y final, dando assim prioridade
% às operações de direita e esquerda, conforme a posição
h2((Cx,Cy),C):-
	estado_final((Fx,Fy)),
	(Cy>=Fy
		-> C is Cy-Fy
		; C is Fy-Cy
	).