:-dynamic(winner/1, usedImpar/1, usedPar/1, parImpar/1).

estado_inicial(([(p(1),_), (p(2),_), (p(3),_), 
				 (p(4),_), (p(5),_), (p(6),_), 
				 (p(7),_), (p(8),_), (p(9),_)])).

listaI([1,3,5,7,9]).
listaP([2,4,6,8]).



terminal(E):-linhas(E); colunas(E); 
			  diagonais(E);empate(E).



%função de utilidade, retorna o valor dos estados terminais, 1 ganha -1 perde
valor(E,1,_):- (linhas(E); colunas(E); diagonais(E)), winner(impar),!.
valor(E,-1,_):-(linhas(E); colunas(E); diagonais(E)), winner(par),!.
valor(E,0,_):- empate(E),!.


inserirPar:-
	retractall(parImpar(_)),
	asserta(parImpar(2)),!.

inserirImpar:-
	retractall(parImpar(_)),
	asserta(parImpar(1)),!.



trocaSimbolo(listaI,listaP).
trocaSimbolo(listaP,listaI).

% op1(estado,jogada,estado seguinte)
op1(E, insere(X,2), EF):-
	\+ usedPar(2),!,
	parImpar(1),
	insere_posicao(p(X), 2, E, EF),
	asserta(usedPar(2)),
	inserirPar.

op1(E, insere(X,4), EF):-
	\+ usedPar(4),!,
	parImpar(1),
	insere_posicao(p(X), 4, E, EF),
	asserta(usedPar(4)),
	inserirPar.

op1(E, insere(X,6), EF):-
	\+ usedPar(6),!,
	parImpar(1),
	insere_posicao(p(X), 6, E, EF),
	asserta(usedPar(6)),
	inserirPar.

op1(E, insere(X,8), EF):-
	\+ usedPar(8),!,
	parImpar(1),
	insere_posicao(p(X), 8, E, EF),
	asserta(usedPar(8)),
	inserirPar.


%-------------------------

op1(E, insere(X,1), EF):-
	\+ usedImpar(1),!,
	parImpar(2),
	insere_posicao(p(X), 1, E, EF),
	asserta(usedPar(1)),
	inserirImpar.

op1(E, insere(X,3), EF):-
	\+ usedImpar(3),!,
	parImpar(2),
	insere_posicao(p(X), 3, E, EF),
	asserta(usedPar(3)),
	inserirImpar.

op1(E, insere(X,5), EF):-
	\+ usedImpar(5),!,
	parImpar(2),
	insere_posicao(p(X), 5, E, EF),
	asserta(usedPar(5)),
	inserirImpar.

op1(E, insere(X,7), EF):-
	\+ usedImpar(7),!,
	parImpar(2),
	insere_posicao(p(X), 7, E, EF),
	asserta(usedPar(7)),
	inserirImpar.

op1(E, insere(X,9), EF):-
	\+ usedImpar(9),!,
	parImpar(2),
	insere_posicao(p(X), 9, E, EF),
	asserta(usedPar(9)),
	inserirImpar.


















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
			 	Result is K mod 2,
			 	(Result=0
			 	->save(winner(par))
			 	; save(winner(impar))),!.

linhas(E):-
	(tres_seguidos(E,p(1),p(2),p(3));
	tres_seguidos(E,p(4),p(5),p(6));
	tres_seguidos(E,p(7),p(8),p(9))).

colunas(E):-
	(tres_seguidos(E,p(1),p(4),p(7));
	tres_seguidos(E,p(2),p(5),p(8));
	tres_seguidos(E,p(3),p(6),p(9))).

diagonais(E):-
	(tres_seguidos(E,p(1),p(5),p(9));
	tres_seguidos(E,p(3),p(5),p(7))).


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
		-> func_aux(p(X),E,Es),!
	;(X=2
		-> func_aux(p(X),E,Es),!
	;(X=3
		-> func_aux(p(X),E,Es),!
	;(X=4
		-> func_aux(p(X),E,Es),!
	;(X=5
		-> func_aux(p(X),E,Es),!
	;(X=6
		-> func_aux(p(X),E,Es),!
	;(X=7
		-> func_aux(p(X),E,Es),!
	;(X=8
		-> func_aux(p(X),E,Es),!
	;(X=9
		-> func_aux(p(X),E,Es),!
	;(write('valor invalido!'),nl, jogada_minimax('h',E))))))))))),
	jogada_minimax('p',Es).
	




jogada_alfabeta(_,E):- (linhas(E);colunas(E);diagonais(E)), print_(E),write('WINNER: '), winner(X),write(X),!.
jogada_alfabeta(_,E):- empate(E), print_(E),write('TIE!'),nl,!.

jogada_alfabeta('p',E):-
	print_(E),
	nl,statistics(real_time,[Ti,_]),
	alfabeta_decidir(E,Op),

	retractall(usedPar(_)),
	retractall(usedImpar(_)),
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
		-> func_aux(X,E,Es),!
	;(X=2
		-> func_aux(X,E,Es),!
	;(X=3
		-> func_aux(X,E,Es),!
	;(X=4
		-> func_aux(X,E,Es),!
	;(X=5
		-> func_aux(X,E,Es),!
	;(X=6
		-> func_aux(X,E,Es),!
	;(X=7
		-> func_aux(X,E,Es),!
	;(X=8
		-> func_aux(X,E,Es),!
	;(X=9
		-> func_aux(X,E,Es),!
	;(write('valor invalido!'),nl, jogada_alfabeta('h',E))))))))))),
	jogada_alfabeta('p',Es).





func_aux(X,E,Es):-
	write('Escreva o valor que deseja jogar: '),
	read(Y),
	(Y=1->
		op1(E,insere(X,Y),Es),!
	;(Y=3->
		op1(E,insere(X,Y),Es),!
	;(Y=5->
		op1(E,insere(X,Y),Es),!
	;(Y=7->
		op1(E,insere(X,Y),Es),!
	;(Y=9->
		op1(E,insere(X,Y),Es),!
	;(write('valor invalido!'),nl, func_aux(X,E,Es))))))).






quant(E,X,Y,Z,J,S):-
				findall((X,J), (member(X,J),E), L1),
				findall((Y,J), (member(Y,J),E), L2),
				findall((Z,J), (member(Z,J),E), L3),
				length(L1,S1),
				length(L2,S2),
				length(L3,S3),
				S = S1 + S2 + S3.


linhas2(E,J, Total):-
	quant(E,p(1),p(2),p(3),J,S1),
	quant(E,p(4),p(5),p(6),J,S2),
	quant(E,p(7),p(8),p(9),J,S3),

	quant(E,p(1),p(4),p(7),J,S4),
	quant(E,p(2),p(5),p(8),J,S5),
	quant(E,p(3),p(6),p(9),J,S6),

	quant(E,p(1),p(5),p(9),J,S7),
	quant(E,p(3),p(5),p(7),J,S8),
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
	member((p(1), X), E),
	write_elements(X),
	member((p(2), Y), E),
	write_elements(Y),
	member((p(3), Z), E),
	write_last_element(Z).

print_linha2(E):-
	member((p(4), X), E),
	write_elements(X),
	member((p(5), Y), E),
	write_elements(Y),
	member((p(6), Z), E),
	write_last_element(Z).

print_linha3(E):-
	member((p(7), X), E),
	write_elements(X),
	member((p(8), Y), E),
	write_elements(Y),
	member((p(9), Z), E),
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




