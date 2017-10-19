%:-initialization(menu).



%inicia a contagem de nos
initInc:-
	retractall(n(_)),
	assertz(n(0)),!.

%incrementa o contador mais N
incMais(N):-
	retract(n(M)),
	M1 is N+M,
	assertz(n(M1)),!.

%no caso em que queremos limitar a profundidade
limitar_profundidade(0):-
	retractall(prof(_)), 
	assertz(prof(100)),!.
	
limitar_profundidade(X):-
	retractall(prof(_)), 
	assertz(prof(X)),!.

%incrementa a profundidade
incProf:-
	p(P),
	P1 is P + 1,
	retract(p(_)), 
	assertz(p(P1)).
	
%inicializa a contagem da profundidade
initProf:-
	retractall(p(_)),
	assertz(p(1)),!.


initParImpar:-
	retractall(parImpar(_)),
	asserta(parImpar(2)),!.


menu:-
	nl,
	write('  -----< MAIN MENU >-----  '),nl,
	nl,
	nl,
	write('       JOGO DO GALO'),nl,
	write('---------------------------'),nl,
	write(' 1 - HUMANO VS PC (minimax)'),nl,
	nl,
	write(' 2 - HUMANO VS PC (minimaxCut)'),nl,
	nl,
	write(' 3 - HUMANO VS PC (alfabeta)'),nl,
	nl,
	nl,
	write(' JOGO DO GALO COM NUMEROS'),nl,
	write('---------------------------'),nl,
	write(' 4 - HUMANO VS PC (minimax)'),nl,
	nl,
	write(' 5 - HUMANO VS PC (alfabeta)'),nl,
	nl,
	nl,
	write(' 6 - FECHAR MENU E PROGRAMA'),nl,
	nl,
	nl,
	write(' ESCOLHA UMA OPCAO:'),nl,
	nl,
	read(OPCAO),
	escolha(OPCAO).

escolha(1):-
	[minimax],
	[galo],
	initInc,  %inicia a incrementação dos nos	
	initProf,
	write('JOGADOR PRIMEIRO - JOGADOR "X"'),
	nl,
	estado_inicial((E,P)),nl,	
	jogada_minimax('h', (E,'o')),
	menu.

escolha(2):-
	[minimaxCut],
	[galo],
	initInc,  %inicia a incrementação dos nos	
	initProf,
	limitar_profundidade(8),
	write('JOGADOR PRIMEIRO - JOGADOR "X"'),
	nl,
	estado_inicial((E,P)),nl,	
	jogada_minimax('h', (E,'o')),
	menu.


escolha(3):-
	[alfabeta],
	[galo],
	initInc,  %inicia a incrementação dos nos	
	initProf,
	limitar_profundidade(15),
	write('JOGADOR PRIMEIRO - JOGADOR "X"'),
	nl,
	estado_inicial((E,P)),nl,	
	jogada_alfabeta('h', (E,'o')),
	menu.


escolha(4):-
	[minimax],
	[galonum],
	initParImpar,
	initInc,  %inicia a incrementação dos nos	
	initProf,
	write('JOGADOR PRIMEIRO - JOGADOR "Impares"'),
	nl,
	estado_inicial((E,L,V)),nl,	
	jogada_minimax('h', (E,L,V)),
	menu.


escolha(5):-
	[alfabeta],
	[galonum],
	initParImpar,
	initInc,  %inicia a incrementação dos nos	
	initProf,
	limitar_profundidade(15),
	write('JOGADOR PRIMEIRO - JOGADOR "Impares"'),
	nl,
	estado_inicial((E,L,V)),nl,	
	jogada_alfabeta('h', (E,L,V)),
	menu.

	
escolha(6).


escolha(_):-
	nl, write('POR FAVOR, INSIRA VALOR VALIDO!'),nl,
	read(OPCAO),
	escolha(OPCAO).

