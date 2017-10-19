:-initialization(menu).



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





menu:-
	nl,
	write('  -----< MAIN MENU >-----  '),nl,
	nl,
	nl,
	write('       JOGO DO GALO'),nl,
	write('---------------------------'),nl,
	write(' 1 - HUMANO VS PC (minimax)'),nl,
	nl,
	nl,
	write(' JOGO DO GALO COM NUMEROS'),nl,
	write('---------------------------'),nl,
	write(' 2 - HUMANO VS PC (minimax)'),nl,
	nl,
	nl,
	write(' 3 - FECHAR MENU E PROGRAMA'),nl,
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
	write('QUEM ESCOLHE X? HUMANO OU PC (h ou p)? '),
	nl,
	read(Jogador),
	nl,
	((Jogador= h)
		-> write('JOGADOR PRIMEIRO - JOGADOR "X"'),
		nl,
		estado_inicial((E,P)),nl,	
		ciclo_jogada('h', (E,'o'))
		; 

		((Jogador = p)
			-> write('JOGADOR SEGUNDO - JOGADOR "O"'),
			nl,
			estado_inicial(Ei),nl,
			ciclo_jogada('p', (E,'o'))
			
			; write('COMANDO NAO RECONHECIDO!'),nl,
			  escolha(1)


		)),
	
	menu.
	
escolha(3).


escolha(_):-
	nl, write('POR FAVOR, INSIRA VALOR VALIDO!'),nl,
	read(OPCAO),
	escolha(OPCAO).

