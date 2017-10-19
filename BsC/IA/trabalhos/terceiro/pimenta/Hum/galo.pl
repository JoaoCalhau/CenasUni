:-dynamic(winner/1).

estado_inicial(([(p1,_), (p2,_), (p3,_), 
				 (p4,_), (p5,_), (p6,_), 
				 (p7,_), (p8,_), (p9,_)],_)).



terminal((E,_)):-linhas(E); colunas(E); 
			  diagonais(E);empate(E).



%função de utilidade, retorna o valor dos estados terminais, 1 ganha -1 perde
valor((E,_),1,_):- (linhas(E); colunas(E); diagonais(E)), winner(o),!.
valor((E,_),-1,_):-(linhas(E); colunas(E); diagonais(E)), winner(x),!.
valor((E,_),0,_):- empate(E),!.





trocaSimbolo('x','o').
trocaSimbolo('o','x').

% op1(estado,jogada,estado seguinte)
op1((E,O), insere(p1,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p1, P, E, EF).

op1((E,O), insere(p2,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p2, P, E, EF).

op1((E,O), insere(p3,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p3, P, E, EF).


op1((E,O), insere(p4,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p4, P, E, EF).

op1((E,O), insere(p5,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p5, P, E, EF).

op1((E,O), insere(p6,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p6, P, E, EF).


op1((E,O), insere(p7,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p7, P, E, EF).

op1((E,O), insere(p8,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p8, P, E, EF).

op1((E,O), insere(p9,P), (EF,P)):-
	trocaSimbolo(O,P),	
	insere_posicao(p9, P, E, EF).



insere_posicao(PX, S, E, EF):-
	member((PX, J), E),
	\+ nonvar(J), J = S,
	EF = E.




save(winner(P)):- retractall(winner(_)), asserta(winner(P)),!.

compare([X|Y]):-help(Y,X).
compare([]).

help([],_).
help([Y|X],Y) :- help(X,Y).


tres_seguidos(E,X,Y,Z):-member((X,P1),E),
			  	member((Y,P2),E),
			  	member((Z,P3),E),
			 	atom(P1), atom(P2), atom(P3),
			 	L = [P1, P2, P3],
			 	compare(L),
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
	


jogada_minimax(_,(E,J)):- (linhas(E);colunas(E);diagonais(E)), print_(E),write('WINNER: '),write(J),!.
jogada_minimax(_,(E,_)):- empate(E), print_(E),write('TIE!'),nl,!.

jogada_minimax('p',(E,J)):-
	print_(E),
	nl,statistics(real_time,[Ti,_]),
	minimax_decidir((E,J),Op),
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
	op1((E,J),Op,Es),
	jogada_minimax('h',Es).

jogada_minimax('h',(E,J)):-
	print_(E),
	nl,
	write('Escreva a posicao onde deseja jogar: '),
	read(X),
	trocaSimbolo(J,J1),
	(X=1
		->op1((E,J),insere(p1,J1),Es),!
	;(X=2
		->op1((E,J),insere(p2,J1),Es),!
	;(X=3
		->op1((E,J),insere(p3,J1),Es),!
	;(X=4
		->op1((E,J),insere(p4,J1),Es),!
	;(X=5
		->op1((E,J),insere(p5,J1),Es),!
	;(X=6
		->op1((E,J),insere(p6,J1),Es),!
	;(X=7
		->op1((E,J),insere(p7,J1),Es),!
	;(X=8
		->op1((E,J),insere(p8,J1),Es),!
	;(X=9
		->op1((E,J),insere(p9,J1),Es),!
	;(write('valor invalido!'),nl, jogada_minimax('h',(E,J)))))))))))),
	jogada_minimax('p',Es).
	




jogada_alfabeta(_,(E,J)):- (linhas(E);colunas(E);diagonais(E)), print_(E),write('WINNER: '),write(J),!.
jogada_alfabeta(_,(E,_)):- empate(E), print_(E),write('TIE!'),nl,!.

jogada_alfabeta('p',(E,J)):-
	print_(E),
	nl,statistics(real_time,[Ti,_]),
	alfabeta_decidir((E,J),Op),
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
	op1((E,J),Op,Es),
	jogada_alfabeta('h',Es).

jogada_alfabeta('h',(E,J)):-
	print_(E),
	nl,
	write('Escreva a posicao onde deseja jogar: '),
	read(X),
	trocaSimbolo(J,J1),
	(X=1
		->op1((E,J),insere(p1,J1),Es),!
	;(X=2
		->op1((E,J),insere(p2,J1),Es),!
	;(X=3
		->op1((E,J),insere(p3,J1),Es),!
	;(X=4
		->op1((E,J),insere(p4,J1),Es),!
	;(X=5
		->op1((E,J),insere(p5,J1),Es),!
	;(X=6
		->op1((E,J),insere(p6,J1),Es),!
	;(X=7
		->op1((E,J),insere(p7,J1),Es),!
	;(X=8
		->op1((E,J),insere(p8,J1),Es),!
	;(X=9
		->op1((E,J),insere(p9,J1),Es),!
	;(write('valor invalido!'),nl, jogada_alfabeta('h',(E,J)))))))))))),
	jogada_alfabeta('p',Es).







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
	linhas2_aux(S1, Ss1),
	linhas2_aux(S2, Ss2),
	linhas2_aux(S3, Ss3),
	linhas2_aux(S4, Ss4),
	linhas2_aux(S5, Ss5),
	linhas2_aux(S6, Ss6),
	linhas2_aux(S7, Ss7),
	linhas2_aux(S8, Ss8),

	Total = (Ss1 * S1) + (Ss2 * S2) + (Ss3 * S3) + (Ss4 * S4) + (Ss5 * S5) + (Ss6 * S6) + (Ss7 * S7) + (Ss8 * S8).

linhas2_aux(S, Ss) :-
	( =(S,1)
		-> Ss = 1
		; ( =(S,2)
			-> Ss = 2
			; Ss = 3
		  )
	).


% avalia(Estado, Tipo_peca, Avaliacao)
% dados um estado, um tipo de peca, returna em C o valor da avaliacao
func_aval((E,J), Val,_):-
	trocaSimbolo(J, J2),
	aval(E,J2,Val).

aval(E, J, Val):-
	linhas2(E,J, Val1),
	trocaSimbolo(J, J2),
	linhas2(E,J2,Val2),
	Val is (Val1-Val2).
	

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




