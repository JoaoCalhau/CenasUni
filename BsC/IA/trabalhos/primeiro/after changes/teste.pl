


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


op((S, (X, Y)), sobe, (S, (Z, Y)), 1) :- estado_final((a,(A,B))),
										  	X > A,
											X > 1, %Z is X-1.

										(not_possible((X, Y), (Z, Y))
											-> op((S, (X, Y)), esq, (S, (X, Z)), 1)
										;Z is X-1).


op((S, (X, Y)), esq, (S, (X, Z)), 1) :- estado_final((a,(A,B))),
										  	Y > B,
											Y > 1, %Z is Y-1.

										 (not_possible((X, Y), (X, Z))
										 	-> op((S, (X, Y)), desce, (S, (Z, Y)), 1)
										 ;Z is Y-1).



op((S, (X, Y)), dir, (S, (X, Z)), 1) :- profundidade(Prof),
											estado_final((a,(A,B))),
										  	Y < B,
										 	Y < Prof, %Z is Y+1.

										  (not_possible((X, Y), (X, Z))
										  	-> op((S, (X, Y)), sobe, (S, (Z, Y)), 1)
										  ; Z is Y+1).


op((S, (X, Y)), desce, (S, (Z, Y)), 1) :- largura(Larg),
											estado_final((a,(A,B))),
										  	X < A,
											X < Larg, %Z is X+1.

										(not_possible((X, Y), (Z, Y))
											-> op((S, (X, Y)), dir, (S, (X, Z)), 1)
											;Z is X+1).








%heuristica

h1((_,E),Val):- estado_final((_,Ef)), distancia_Npecas(E,Ef,0,Val).


h2((_,E),Val):- estado_final((_,Ef)), distancia_Manh(E,Ef,Val).

distancia_Npecas([],[],Nc,Nc). 
distancia_Npecas([X|Ec],[X|Ef],Nc,Nf):- !,distancia_Npecas(Ec,Ef,Nc,Nf). 
distancia_Npecas([X|Ec],[Y|Ef],Nc,Nf):- distintas(X,Y,Nc,Nf0),
                                        distancia_Npecas(Ec,Ef,Nf0,Nf). 
distintas([],[],Nc,Nc).
distintas([b|R],[_|S],Nc,Nf):- !,distintas(R,S,Nc,Nf).
distintas([X|R],[X|S],Nc,Nf):- distintas(R,S,Nc,Nf).
distintas([X|R],[Y|S],Nc,Nf):- X\=Y, Nc1 is Nc + 1, distintas(R,S,Nc1,Nf).

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