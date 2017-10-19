:- dynamic(visited/1).




%largura(Y)
largura(30).

%profundidade(X)
profundidade(30).

%estado_inicial((agente, sala inicial))
estado_inicial((18,18)).

%estado_final((agente, sala final)).
estado_final((26,26)).

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
		K is X+1,
		(visited((K,Y))
			-> fail	
			;(not_possible((X, Y), (K, Y))
				-> fail
				; asserta(visited((K,Y))),
				Z is X+1
			)
		).


op((X, Y), dir, (X, Z), 1) :- 
		largura(Larg),
		K is Y+1,
		Y < Larg,
		(visited((X,K))
			-> fail
		  	;(not_possible((X, Y), (X, K))
		  		-> fail
		  		;asserta(visited((X,K))),
		  		Z is Y+1
		  	)
		).


op((X, Y), sobe, (Z, Y), 1) :- 
		X > 1,
		K is X-1,
		(visited((K,Y))
			-> fail
		  	;(not_possible((X, Y), (K, Y))
				->fail
				;asserta(visited((K,Y))),
				Z is X-1
			)
		).


op((X, Y), esq, (X, Z), 1) :- 
		Y > 1,
		K is Y-1,
		(visited((X,K))
			-> fail
			 ;(not_possible((X, Y), (X, K))
		 		-> fail
		 		;asserta(visited((X,K))),
		 		Z is Y-1
			)
		 ).




%heuristica

%h1((_,E),Val):- estado_final((_,Ef)), distancia_Npecas(E,Ef,0,Val).


%distancia_Npecas([],[],Nc,Nc). 
%distancia_Npecas([X|Ec],[X|Ef],Nc,Nf):- !,distancia_Npecas(Ec,Ef,Nc,Nf). 
%distancia_Npecas([X|Ec],[Y|Ef],Nc,Nf):- distintas(X,Y,Nc,Nf0),
%                                        distancia_Npecas(Ec,Ef,Nf0,Nf). 
%distintas([],[],Nc,Nc).
%distintas([b|R],[_|S],Nc,Nf):- !,distintas(R,S,Nc,Nf).
%distintas([X|R],[X|S],Nc,Nf):- distintas(R,S,Nc,Nf).
%distintas([X|R],[Y|S],Nc,Nf):- X\=Y, Nc1 is Nc + 1, distintas(R,S,Nc1,Nf).



%HEURISTICA DISTANCIA DO FIM
%h1(E, C):-
%	estado_final(EF),
%	posicao_comboio(Y, EF),
%	posicao_comboio(X, E),
%	nth(2, E, AreaB),
%	nth(3, AreaB, Agulha),
%	c(X, Y, C, Agulha).


%h1(C):-
%	estado_final(Ef),







h2((_,E),Val):- estado_final((_,Ef)), distancia_Manh(E,Ef,Val).



distancia_Manh(Ec,Ef,Nf):-transf((1,1),Ec,Ect),transf((1,1),Ef,Eft),
                            sort(Ect,Ect1),sort(Eft,Eft1),
                            distManh(Ect1,Eft1,0,Nf).


distManh([],[],Dc,Dc).
distManh([b-(X,Y)|R],[b-(W,Z)|S],Dc,Df):- distManh(R,S,Dc,Df). 
distManh([A-(X,Y)|R],[A-(W,Z)|S],Dc,Df):- A\=b, dist(X,W,D1), dist(Y,Z,D2), 
                                         Dc1 is Dc+ D1+D2, distManh(R,S,Dc1,Df).

transf(_,[],[]).
transf((X,Y),[A|R],S1):- transfl((X,Y),A,B), Y1 is Y+1, transf((X,Y1),R,S),append(B,S,S1).

transfl(_,[],[]).
transfl((X,Y),[A|R],[A-(X,Y)|S]):- X1 is X+1, transfl((X1,Y),R,S). 

testa(Op,F):- estado_inicial(E0),ope(E0,Op,F,_).
testa2(E0,E1,D):-estado_inicial(E0),op(E0,Op,E1,C), h1(E0,D).
testa3(E0,E1,D):-estado_inicial(E0),op(E0,Op,E1,C), h2(E0,D).

dist(X,Y,K):- X>Y,!, K is X -Y.
dist(X,Y,K):-  K is Y - X.