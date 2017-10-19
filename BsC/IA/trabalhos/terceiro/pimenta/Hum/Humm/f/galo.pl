:-dynamic(ganhador/1).

%(lista com pos, ultima peca jogada)
estado_inicial(([(p(1,1), _),(p(1,2), _),(p(1,3), _),
                 (p(2,1), _),(p(2,2), _),(p(2,3), _),
	         (p(3,1), _),(p(3,2), _),(p(3,3), _)],_)).

setValor(valor(V)):-
	retractall(valor(_)), asserta(valor(V)).

% O Jogador X comeca a jogar
valor((E, _), 1, _):-(linhas(E);colunas(E);diagonais(E)),ganhador(o),!.
valor((E, _), -1, _):-(linhas(E);colunas(E);diagonais(E)),ganhador(x),!.
valor((E, _), 0, _):- empate(E),!.

terminal((E, _)):-
	linhas(E);colunas(E);diagonais(E);empate(E).



guarda(ganhador(P)):- retractall(ganhador(_)), asserta(ganhador(P)),!.


linhas(E):-
	(linha(E,1);linha(E,2);linha(E,3)).

colunas(E):-
	(coluna(E,1);coluna(E,2);coluna(E,3)).



coluna(E,Y):-
	findall(P, (member((p(_,Y),P),E), atom(P)),L),
	length(L, S),
	S = 3,
	L = [O,O,O], guarda(ganhador(O)),!.
	
linha(E,X):-
	findall(P, (member((p(X,_),P),E), atom(P)),L),
	length(L, S),
	S = 3,
	L = [O,O,O], guarda(ganhador(O)),!.

% diagonais(?Estado, ?Valor)
diagonais(E):-
	(diagonal_1(E, 1, 0, 0, NX1, _), NX1=3;	
	diagonal_2(E, 1, 0, 0, NX2, _), NX2=3), guarda(ganhador(x)), !.

diagonais(E):-
	(diagonal_1(E, 1, 0, 0, _, NO1), NO1=3;
	diagonal_2(E, 1, 0, 0, _, NO2), NO2=3), guarda(ganhador(o)), !.

% diagonal_1(?Estado, ?Posicao, ?NumDeXActual, ?NumDeOActual, ?NumDeXSeguinte, ?NumDeOSeguinte )
diagonal_1(E, 3, NX, NO, NX2, NO2):-
	member((p(3,3), X), E),
	count_(X, NX, NO, NX2, NO2).

diagonal_1(E, I, NX, NO, NX3, NO3):-
	I < 3, I2 is I+1,
	member((p(I,I), X), E),
	count_(X, NX, NO, NX2, NO2),
	diagonal_1(E, I2, NX2, NO2, NX3, NO3).

% diagonal_2(?Estado, ?Posicao, ?NumDeXActual, ?NumDeOActual, ?NumDeXSeguinte, ?NumDeOSeguinte )
diagonal_2(E, 3, NX, NO, NX2, NO2):-
	member((p(3,1), X), E),
	count_(X, NX, NO, NX2, NO2).

diagonal_2(E, I, NX, NO, NX3, NO3):-
	I < 3, I2 is I+1, J is 4-I,
	member((p(I,J), X), E),
	count_(X, NX, NO, NX2, NO2),
	diagonal_2(E, I2, NX2, NO2, NX3, NO3).

empate(E):-
	all_atomics(E), asserta(empate).

all_atomics([]).
all_atomics([(p(_,_), X)|T]):-
	atom(X),
	all_atomics(T).
	

% count_(?ElementoDaPosicao, ?Jogador, ?NumXAntesIncrem, ?NumOAntesIncrem, ?NumXDepoisIncrem, ?NumXDepoisIncrem)
count_(E, NX, NO, NX2, NO):-
	atom(E), E = x,
	NX2 is NX+1.
count_(E, NX, NO, NX, NO2):-
	atom(E), E = o,
	NO2 is NO+1.


op1((E,O), insere(p(X,Y),P), (EF,P)):-
	member(X, [1,2,3]),member(Y, [1,2,3]),
	inverteJog(O,P),	
	insere_posicao(X, Y, P, E, EF).

insere_posicao(X, Y, S, E, EF):-
	member((p(X,Y), J), E),
	\+ nonvar(J), J = S,
	EF = E.

%--------------------------------------------------------------------

% conta o numero total de 1x's ou 1o's 
find_all_1peca(E, J, V):-
	%encontra todos os membros nao atomicos do estado
	findall((p(X,Y), J1), (member((p(X,Y), J1), E),atom(J1)), L),
	findall(J, find_1peca(L, J), L2),
	length(L2, V).

% encontrar num. de 1x's ou 1o's na linha
find_1peca(E, J):-
	member((p(X,Y), J), E),
	X1 is X+1, X2 is X-1,
	Y1 is Y-1, Y2 is Y+1,
	\+ member((p(X,Y1),J), E), \+ member((p(X,Y2),J), E), \+ member((p(X1,Y),J), E), 
	\+ member((p(X2,Y),J), E), \+ member((p(X1,Y1),J), E), \+ member((p(X2,Y2),J), E), 
	\+ member((p(X1,Y2),J), E), \+ member((p(X2,Y1),J), E).

% conta o numero total de 2x's ou 2o's 
find_all_2pecas(E, J, V):-
	findall((p(X,Y), J1), (member((p(X,Y), J1), E),atom(J1)), L),
	findall(J, find_2pecas(L, J), L2),
	length(L2, V).

% encontrar num. de 2x's ou 2o's na linha
find_2pecas(E, J):-
	member((p(X,Y), J), E),
	Y1 is Y-1,
	member((p(X,Y1),J), E).

% encontrar num. de 2x's ou 2o's na coluna
find_2pecas(E, J):-
	member((p(X,Y), J), E),
	X1 is X-1,
	member((p(X1,Y),J), E).

%diagonal 1
find_2pecas(E, J):-
	member((p(X,Y), J), E),
	X1 is X-1, Y1 is Y-1,
	member((p(X1,Y1),J), E).

%diagonal 2
find_2pecas(E, J):-
	member((p(X,Y), J), E),
	X1 is X-1, Y1 is Y+1,
	member((p(X1,Y1),J), E).
	

% avalia(Estado, Tipo_peca, Avaliacao)
% dados um estado, um tipo de peca, returna em C o valor da avaliacao
func_aval((E,J), Val,_):-
	inverteJog(J, J2),
	aval(E,J2,Val).

aval(E, J, Val):-
	find_all_1peca(E, J, V1),
	find_all_2pecas(E, J, V2),
	Val1 is V1+(3*V2),
	inverteJog(J, J2),
	find_all_1peca(E, J2, V3),
	find_all_2pecas(E, J2, V4),
	Val2 is V3+(3*V4),
	Val is (Val1-Val2).
	

%------------------------------------------------------------------------	

inverteJog('x','o').
inverteJog('o','x').


ciclo_jogada(_,(E,J)):- (linhas(E);colunas(E);diagonais(E)), print_(E),write('Vencedor: '),write(J),!.
ciclo_jogada(_,(E,_)):- empate(E), print_(E),write('Empate!'),nl,!.

ciclo_jogada('c',(E,J)):-
	print_(E),
	nl,statistics(real_time,[Ti,_]),
	minimax_decidir((E,J),Op),
	statistics(real_time,[Tf,_]), T is Tf-Ti,
	nl, 
	write('Tempo: '(T)),
	nl,
	n(N),
	write('Numero de Nós: '(N)),
	initInc,	
	nl,
	write(Op),
	nl,
	nl,
	op1((E,J),Op,Es),
	ciclo_jogada('j',Es).

ciclo_jogada('j',(E,J)):-
	print_(E),
	nl,
	write('Escreva a linha da posicao onde deseja jogar: '),
	read(X),
	write('Escreva a coluna da posicao onde deseja jogar: '),
	read(Y),
	inverteJog(J,J1),
	op1((E,J),insere(p(X,Y),J1),Es),
	ciclo_jogada('c',Es).

print_(E):-
	print_linhas(E).

print_linhas(E):-
	write('       '),
	print_linha(E, 1, 1),
	write('       '),
	write_line(1, 3),
	write('       '),
	print_linha(E, 2, 1),
	write('       '),
	write_line(1, 3),
	write('       '),
	print_linha(E, 3, 1),
	write('\n\n').

print_linha(E, I, J):-
	member((p(I,J), X), E),
	J = 3,
	write_last_element(X),write('\n').

print_linha(E, I, J):-
	\+member((p(I,J), X), E),
	J = 3,
	write_last_element(X).

print_linha(E, I, J):-
	J < 3, J2 is J+1,
	member((p(I,J), X), E),
	write_elements(X),
	print_linha(E, I, J2).

print_linha(E, I, J):-
	J < 3, J2 is J+1,
	\+member((p(I,J), X), E),
	write_elements(X),
	print_linha(E, I, J2).

write_elements(X):-
	nonvar(X),
	write(X),write(' | ').
write_elements(X):-
	\+ nonvar(X),
	write(' '),write(' | ').
write_last_element(X):-
	nonvar(X),
	write(X).
write_last_element(X):-
	\+ nonvar(X),
	write(' ').


write_line( I, P):-
        I = P, write('- - -'), nl.
write_line( I, P):-
        I < P, I2 is I+1,
        write('- '),
        write_line(I2, P).