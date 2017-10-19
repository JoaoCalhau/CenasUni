
:-dynamic(winner/1).

estado_inicial(([(p(1),_), (p(2),_), (p(3),_), 
				 (p(4),_), (p(5),5), (p(6),_), 
				 (p(7),_), (p(8),_), (p(9),8)],[0,5,8],8)).

listaI([1,3,5,7,9]).
listaP([2,4,6,8]).



terminal((E,_,_)):-linhas(E); colunas(E); 
			  diagonais(E);empate(E).



%função de utilidade, retorna o valor dos estados terminais, 1 ganha -1 perde
valor((E,_,_),1,_):- (linhas(E); colunas(E); diagonais(E)), winner(impar),!.
valor((E,_,_),-1,_):-(linhas(E); colunas(E); diagonais(E)), winner(par),!.
valor((E,_,_),0,_):- empate(E),!.






% op1(estado,jogada,estado seguinte)
op1((E,L,P), insere(X,2), (EF,L2,P2)):-
	\+ (0 is P mod 2),
	\+ member(2,L),
	insere_posicao(p(X), 2, E, EF),
	append(L,[2],L2),
	P2 is 2.

op1((E,L,P), insere(X,4), (EF,L2,P2)):-
	\+ (0 is P mod 2),
	\+ member(4,L),
	insere_posicao(p(X), 4, E, EF),
	append(L,[4],L2),
	P2 is 4.

op1((E,L,P), insere(X,6), (EF,L2,P2)):-
	\+ (0 is P mod 2),
	\+ member(6,L),
	insere_posicao(p(X), 6, E, EF),
	append(L,[6],L2),
	P2 is 6.

op1((E,L,P), insere(X,8), (EF,L2,P2)):-
	\+ (0 is P mod 2),
	\+ member(8,L),
	insere_posicao(p(X), 8, E, EF),
	append(L,[8],L2),
	P2 is 8.	

%-------------------------


op1((E,L,P), insere(X,1), (EF,L2,P2)):-
	\+ (1 is P mod 2),
	\+ member(1,L),
	insere_posicao(p(X), 1, E, EF),
	append(L,[1],L2),
	P2 is 1.

op1((E,L,P), insere(X,3), (EF,L2,P2)):-
	\+ (1 is P mod 2),
	\+ member(3,L),
	insere_posicao(p(X), 3, E, EF),
	append(L,[3],L2),
	P2 is 3.

op1((E,L,P), insere(X,5), (EF,L2,P2)):-
	\+ (1 is P mod 2),
	\+ member(5,L),
	insere_posicao(p(X), 5, E, EF),
	append(L,[5],L2),
	P2 is 5.

op1((E,L,P), insere(X,7), (EF,L2,P2)):-
	\+ (1 is P mod 2),
	\+ member(7,L),
	insere_posicao(p(X), 7, E, EF),
	append(L,[7],L2),
	P2 is 7.

op1((E,L,P), insere(X,9), (EF,L2,P2)):-
	\+ (1 is P mod 2),
	\+ member(9,L),
	insere_posicao(p(X), 9, E, EF),
	append(L,[9],L2),
	P2 is 9.



insere_posicao(PX, S, E, EF):-
	member((PX, J), E),
	\+ nonvar(J), J = S,
	EF = E.




save(winner(P)):- retractall(winner(_)), asserta(winner(P)),!.


tres_seguidos(E,X,Y,Z):-member((X,P1),E),
			  	member((Y,P2),E),
			  	member((Z,P3),E), 
			 	atom(P1), atom(P2), atom(P3),
			 	L = [P1, P2, P3],
			 	sum_list(L,K),
			 	=(K,15),
			 	Result is K mod 2,
			 	(Result=0
			 	->save(winner(par))
			 	; save(winner(impar))),!.


/*
tres_seguidos(E,p(X),p(Y),p(Z)):-
				findall(P1, (member((p(X),P1),E), atom(P1)),L1),
				findall(P2, (member((p(Y),P2),E), atom(P2)),L2),
				findall(P3, (member((p(Z),P3),E), atom(P3)),L3),
				append(L1,L2,L4),
				append(L4,L3,L5),
				length(L5,S),
				S = 3,
			 	sum_list(L,K),
			 	=(K,15),
			 	Result is K mod 2,
			 	(Result=0
			 	->save(winner(par))
			 	; save(winner(impar))),!.
*/			 	

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
	


jogada_minimax(_,(E,L,V)):- (linhas(E);colunas(E);diagonais(E)), print_(E),write('WINNER: '),winner(X),write(X),!.
jogada_minimax(_,(E,_,_)):- empate(E), print_(E),write('TIE!'),nl,!.

jogada_minimax('p',(E,L,V)):-
	print_(E),
	nl,statistics(real_time,[Ti,_]),
	minimax_decidir((E,L,V),Op),
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
	op1((E,L,V),Op,Es),
	jogada_minimax('h',Es).

jogada_minimax('h',(E,L,V)):-
	print_(E),
	nl,
	write('Escreva a posicao onde deseja jogar: '),
	read(X),
	(X=1
		-> func_aux(X,(E,L,V),Es),!
	;(X=2
		-> func_aux(X,(E,L,V),Es),!
	;(X=3
		-> func_aux(X,(E,L,V),Es),!
	;(X=4
		-> func_aux(X,(E,L,V),Es),!
	;(X=5
		-> func_aux(X,(E,L,V),Es),!
	;(X=6
		-> func_aux(X,(E,L,V),Es),!
	;(X=7
		-> func_aux(X,(E,L,V),Es),!
	;(X=8
		-> func_aux(X,(E,L,V),Es),!
	;(X=9
		-> func_aux(X,(E,L,V),Es),!
	;(write('valor invalido!'),nl, jogada_minimax('h',(E,L,V)))))))))))),
	jogada_minimax('p',Es).
	




jogada_alfabeta(_,(E,L,V)):- (linhas(E);colunas(E);diagonais(E)), print_(E),write('WINNER: '), winner(X),write(X),!.
jogada_alfabeta(_,(E,_,_)):- empate(E), print_(E),write('TIE!'),nl,!.

jogada_alfabeta('p',(E,L,V)):-
	print_(E),
	nl,statistics(real_time,[Ti,_]),
	alfabeta_decidir((E,L,V),Op),
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
	op1((E,L,V),Op,Es),
	jogada_alfabeta('h', Es).

jogada_alfabeta('h',(E,L,V)):-
	print_(E),
	nl,
	write('Escreva a posicao onde deseja jogar: '),
	read(X),
	(X=1
		-> func_aux(X,(E,L,V),Es),!
	;(X=2
		-> func_aux(X,(E,L,V),Es),!
	;(X=3
		-> func_aux(X,(E,L,V),Es),!
	;(X=4
		-> func_aux(X,(E,L,V),Es),!
	;(X=5
		-> func_aux(X,(E,L,V),Es),!
	;(X=6
		-> func_aux(X,(E,L,V),Es),!
	;(X=7
		-> func_aux(X,(E,L,V),Es),!
	;(X=8
		-> func_aux(X,(E,L,V),Es),!
	;(X=9
		-> func_aux(X,(E,L,V),Es),!
	;(write('valor invalido!'),nl, jogada_alfabeta('h',(E,L,V)))))))))))),
	jogada_alfabeta('p',Es).





func_aux(X,(E,L,V),Es):-
	write('Escreva o valor que deseja jogar: '),
	read(Y),
	(Y=1->
		op1((E,L,V),insere(X,Y),Es),!
	;(Y=3->
		op1((E,L,V),insere(X,Y),Es),!
	;(Y=5->
		op1((E,L,V),insere(X,Y),Es),!
	;(Y=7->
		op1((E,L,V),insere(X,Y),Es),!
	;(Y=9->
		op1((E,L,V),insere(X,Y),Es),!
	;(write('valor invalido!'),nl, func_aux(X,(E,L,V),Es))))))).






quant(E,X,Y,Z,S):-
				findall((X,X1), (member(X,X1),E), L1),
				findall((Y,Y1), (member(Y,Y1),E), L2),
				findall((Z,Z1), (member(Z,Z1),E), L3),
				length(L1,S1),
				length(L2,S2),
				length(L3,S3),
				S = S1 + S2 + S3.


linhas2(E, Total):-
	quant(E,p(1),p(2),p(3),S1),
	quant(E,p(4),p(5),p(6),S2),
	quant(E,p(7),p(8),p(9),S3),

	quant(E,p(1),p(4),p(7),S4),
	quant(E,p(2),p(5),p(8),S5),
	quant(E,p(3),p(6),p(9),S6),

	quant(E,p(1),p(5),p(9),S7),
	quant(E,p(3),p(5),p(7),S8),
	Total = S1 + S2 + S3 + S4 + S5 + S6 + S7 + S8.


% avalia(Estado, Tipo_peca, Avaliacao)
% dados um estado, um tipo de peca, returna em C o valor da avaliacao

func_aval((E,L,V), Val,_):-
	countImpares(L,X),
	countPares(L,Y),
	Val is Y-X.
/*

func_aval((E,L,V), Val,_):-
	linhas2(E,Val).

*/
countImpares(L,X) :-
    findall(N, (member(N, L), numeroImpar(N)), Ns),
    length(Ns, X).

countPares(L,X) :-
    findall(N, (member(N, L), numeroPar(N)), Ns),
    length(Ns, X).
	


numeroPar(X):-
	K is X mod 2,
	(=(K,0)
		-> true
		;false).

numeroImpar(X):-
	K is X mod 2,
	(=(K,1)
		-> true
		;false).





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




