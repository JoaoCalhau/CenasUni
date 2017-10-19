:-dynamic(winner/1, usedImpar/1, usedPar/1).

estado_inicial(([(p1,_), (p2,_), (p3,_), 
				 (p4,_), (p5,_), (p6,_), 
				 (p7,_), (p8,_), (p9,_)])).

listaI([1,3,5,7,9]).
listaP([2,4,6,8]).



terminal(E):-linhas(E); colunas(E); 
			  diagonais(E);empate(E).



%função de utilidade, retorna o valor dos estados terminais, 1 ganha -1 perde
valor(E,1,_):- (linhas(E); colunas(E); diagonais(E)), winner(impar),!.
valor(E,-1,_):-(linhas(E); colunas(E); diagonais(E)), winner(par),!.
valor(E,0,_):- empate(E),!.





trocaSimbolo(listaI,listaP).
trocaSimbolo(listaP,listaI).

% op1(estado,jogada,estado seguinte)
op1(E, insere(p1,2), EF):-
	\+ usedPar(2),
	insere_posicao(p1, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p1,4), EF):-
	\+ usedPar(4),
	insere_posicao(p1, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p1,6), EF):-
	\+ usedPar(6),
	insere_posicao(p1, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p1,8), EF):-
	\+ usedPar(8),
	insere_posicao(p1, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------

op1(E, insere(p2,2), EF):-
	\+ usedPar(2),
	insere_posicao(p2, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p2,4), EF):-
	\+ usedPar(4),
	insere_posicao(p2, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p2,6), EF):-
	\+ usedPar(6),
	insere_posicao(p2, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p2,8), EF):-
	\+ usedPar(8),
	insere_posicao(p2, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------

op1(E, insere(p3,2), EF):-
	\+ usedPar(2),
	insere_posicao(p3, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p3,4), EF):-
	\+ usedPar(4),
	insere_posicao(p3, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p3,6), EF):-
	\+ usedPar(6),
	insere_posicao(p3, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p3,8), EF):-
	\+ usedPar(8),
	insere_posicao(p3, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------

op1(E, insere(p4,2), EF):-
	\+ usedPar(2),
	insere_posicao(p4, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p4,4), EF):-
	\+ usedPar(4),
	insere_posicao(p4, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p4,6), EF):-
	\+ usedPar(6),
	insere_posicao(p4, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p4,8), EF):-
	\+ usedPar(8),
	insere_posicao(p4, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------


op1(E, insere(p5,2), EF):-
	\+ usedPar(2),
	insere_posicao(p5, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p5,4), EF):-
	\+ usedPar(4),
	insere_posicao(p5, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p5,6), EF):-
	\+ usedPar(6),
	insere_posicao(p5, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p5,8), EF):-
	\+ usedPar(8),
	insere_posicao(p5, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------

op1(E, insere(p6,2), EF):-
	\+ usedPar(2),
	insere_posicao(p6, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p6,4), EF):-
	\+ usedPar(4),
	insere_posicao(p6, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p6,6), EF):-
	\+ usedPar(6),
	insere_posicao(p6, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p6,8), EF):-
	\+ usedPar(8),
	insere_posicao(p6, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------

op1(E, insere(p7,2), EF):-
	\+ usedPar(2),
	insere_posicao(p7, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p7,4), EF):-
	\+ usedPar(4),
	insere_posicao(p7, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p7,6), EF):-
	\+ usedPar(6),
	insere_posicao(p7, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p7,8), EF):-
	\+ usedPar(8),
	insere_posicao(p7, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------

op1(E, insere(p8,2), EF):-
	\+ usedPar(2),
	insere_posicao(p8, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p8,4), EF):-
	\+ usedPar(4),
	insere_posicao(p8, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p8,6), EF):-
	\+ usedPar(6),
	insere_posicao(p8, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p8,8), EF):-
	\+ usedPar(8),
	insere_posicao(p8, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------

op1(E, insere(p9,2), EF):-
	\+ usedPar(2),
	insere_posicao(p9, 2, E, EF),
	asserta(usedPar(2)).

op1(E, insere(p9,4), EF):-
	\+ usedPar(4),
	insere_posicao(p9, 4, E, EF),
	asserta(usedPar(4)).

op1(E, insere(p9,6), EF):-
	\+ usedPar(6),
	insere_posicao(p9, 6, E, EF),
	asserta(usedPar(6)).

op1(E, insere(p9,8), EF):-
	\+ usedPar(8),
	insere_posicao(p9, 8, E, EF),
	asserta(usedPar(8)).

%-------------------------


op2(E, insere(Pos,Val), EF):-
	\+ usedImpar(Val),
	insere_posicao(Pos, Val, E, EF),
	asserta(usedImpar(Val)).






insere_posicao(PX, S, E, EF):-
	member((PX, J), E),
	\+ nonvar(J), J = S,
	EF = E.




save(winner(P)):- retractall(winner(_)), asserta(winner(P)),!.


tres_seguidos(E,X,Y,Z):-member((X,P1),E),
			  	member((Y,P2),E),
			  	member((Z,P3),E), !,
			 	atom(P1), atom(P2), atom(P3),
			 	L = [P1, P2, P3],
			 	sum_list(L,K),
			 	=(K,15),
			 	save(winner(P1)),!.

linhas(E):-
	(tres_seguidos(E,p1,p2,p3);
	tres_seguidos(E,p4,p5,p6);
	tres_seguidos(E,p7,p8,p9)).

colunas(E):-
	(tres_seguidos(E,p1,p4,p7);
	tres_seguidos(E,p2,p5,p8);
	tres_seguidos(E,p3,p6,p9)).

diagonais(E):-
	(tres_seguidos(E,p1,p5,p9);
	tres_seguidos(E,p3,p5,p7)).


empate(E):-
	com_valor(E), asserta(empate).


com_valor([]).
com_valor([(_,K)|T]):-
	atom(K),
	com_valor(T).
	


jogada_minimax(_,E):- (linhas(E);colunas(E);diagonais(E)), print_(E),write('WINNER: '),winner(X),write(X),!.
jogada_minimax(_,E):- empate(E), print_(E),write('TIE!'),nl,!.

jogada_minimax('p',E):-
	print_(E),
	nl,statistics(real_time,[Ti,_]),
	minimax_decidir(E,Op),
	statistics(real_time,[Tf,_]), T is Tf-Ti,
	nl, 
	write('Tempo: '(T)),
	nl,
	n(N),
	write('Numero de Nos: '(N)),
	initInc,	
	nl,
	write(Op),
	nl,
	nl,
	op1(E,Op,Es),
	jogada_minimax('h',Es).

jogada_minimax('h',E):-
	print_(E),
	nl,
	write('Escreva a posicao onde deseja jogar: '),
	read(X),
	(X=1
		-> func_aux(p1,E,ES),!
	;(X=2
		-> func_aux(p2,E,ES),!
	;(X=3
		-> func_aux(p3,E,ES),!
	;(X=4
		-> func_aux(p4,E,ES),!
	;(X=5
		-> func_aux(p5,E,ES),!
	;(X=6
		-> func_aux(p6,E,ES),!
	;(X=7
		-> func_aux(p7,E,ES),!
	;(X=8
		-> func_aux(p8,E,ES),!
	;(X=9
		-> func_aux(p9,E,ES),!
	;(write('valor invalido!'),nl, jogada_minimax('h',E))))))))))),
	jogada_minimax('p',Es).
	




jogada_alfabeta(_,E):- (linhas(E);colunas(E);diagonais(E)), print_(E),write('WINNER: '), winner(X),write(X),!.
jogada_alfabeta(_,E):- empate(E), print_(E),write('TIE!'),nl,!.

jogada_alfabeta('p',E):-
	print_(E),
	nl,statistics(real_time,[Ti,_]),
	alfabeta_decidir(E,Op),
	statistics(real_time,[Tf,_]), T is Tf-Ti,
	nl, 
	write('Tempo: '(T)),
	nl,
	n(N),
	write('Numero de Nos: '(N)),
	initInc,	
	nl,
	write(Op),
	nl,
	nl,
	op1(E,Op,Es),
	jogada_alfabeta('h',Es).

jogada_alfabeta('h',E):-
	print_(E),
	nl,
	write('Escreva a posicao onde deseja jogar: '),
	read(X),
	(X=1
		-> func_aux(p1,E,ES),!
	;(X=2
		-> func_aux(p2,E,ES),!
	;(X=3
		-> func_aux(p3,E,ES),!
	;(X=4
		-> func_aux(p4,E,ES),!
	;(X=5
		-> func_aux(p5,E,ES),!
	;(X=6
		-> func_aux(p6,E,ES),!
	;(X=7
		-> func_aux(p7,E,ES),!
	;(X=8
		-> func_aux(p8,E,ES),!
	;(X=9
		-> func_aux(p9,E,ES),!
	;(write('valor invalido!'),nl, jogada_alfabeta('h',E))))))))))),
	jogada_alfabeta('p',Es).





func_aux(X,E,ES):-
	write('Escreva o valor que deseja jogar: '),
	read(Y),
	(Y=1->
		op2(E,insere(X,Y),Es),!
	;(Y=3->
		op2(E,insere(X,Y),Es),!
	;(Y=5->
		op2(E,insere(X,Y),Es),!
	;(Y=7->
		op2(E,insere(X,Y),Es),!
	;(Y=9->
		op2(E,insere(X,Y),Es),!
	;(write('valor invalido!'),nl, func_aux(X,E,ES))))))).






quant(E,X,Y,Z,J,S):-
				findall((X,J), (member(X,J),E), L1),
				findall((Y,J), (member(Y,J),E), L2),
				findall((Z,J), (member(Z,J),E), L3),
				length(L1,S1),
				length(L2,S2),
				length(L3,S3),
				S = S1 + S2 + S3.


linhas2(E,J, Total):-
	quant(E,p1,p2,p3,J,S1),
	quant(E,p4,p5,p6,J,S2),
	quant(E,p7,p8,p9,J,S3),

	quant(E,p1,p4,p7,J,S4),
	quant(E,p2,p5,p8,J,S5),
	quant(E,p3,p6,p9,J,S6),

	quant(E,p1,p5,p9,J,S7),
	quant(E,p3,p5,p7,J,S8),
	Total = S1 + S2 + S3 + S4 + S5 + S6 + S7 + S8.


% avalia(Estado, Tipo_peca, Avaliacao)
% dados um estado, um tipo de peca, returna em C o valor da avaliacao
func_aval(E, Val,_):-
	countImpares(X),
	countPares(Y),
	Val is Y-X.


countImpares(X) :-
    findall(N, usedImpar(N), Ns),
    length(Ns, X).

countPares(X) :-
    findall(N, usedPar(N), Ns),
    length(Ns, X).
	

print_(E):-
	print_linhas(E).

print_linhas(E):-
	write('       '),
	print_linha1(E),
	write('       '),
	write_line(1, 3),
	write('       '),
	print_linha2(E),
	write('       '),
	write_line(1, 3),
	write('       '),
	print_linha3(E),
	write('\n\n').



print_linha1(E):-
	member((p1, X), E),
	write_elements(X),
	member((p2, Y), E),
	write_elements(Y),
	member((p3, Z), E),
	write_last_element(Z).

print_linha2(E):-
	member((p4, X), E),
	write_elements(X),
	member((p5, Y), E),
	write_elements(Y),
	member((p6, Z), E),
	write_last_element(Z).

print_linha3(E):-
	member((p7, X), E),
	write_elements(X),
	member((p8, Y), E),
	write_elements(Y),
	member((p9, Z), E),
	write_last_element(Z).


write_elements(X):-
	nonvar(X),
	write(X),write(' | ').
write_elements(X):-
	\+ nonvar(X),
	write(' '),write(' | ').
write_last_element(X):-
	nonvar(X),
	write(X), write('\n').
write_last_element(X):-
	\+ nonvar(X),
	write(' '), write('\n').


write_line( I, P):-
        I = P, write('- - -'), nl.
write_line( I, P):-
        I < P, I2 is I+1,
        write('- '),
        write_line(I2, P).




