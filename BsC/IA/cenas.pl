homem('Afonso Henriques','rei de Portugal',1109).
homem('Henrique de Borgonha','conde de Portugal',1069).
homem('Sancho I','rei de Portugal',1154).
homem('Fernando II','rei de Leao',1137).
homem('Afonso IX', 'rei de Leao e Castela', 1171).
homem('Afonso II', 'rei de Portugal',1185).
homem('Sancho II', 'rei de Portugal',1207).
homem('Afonso III', 'rei de Portugal',1210).


mulher('Teresa de Castela', 'condessa de Portugal', 1080).
mulher('Mafalda', 'condessa de Saboia', 1125).
mulher('Urraca', 'infanta de Portugal',1151).
mulher('Dulce de Barcelona','infanta de Aragao',1160).
mulher('Berengaria', 'infanta de Portugal',1194).
mulher('Urraca C','infanta de Castela',1186).


filho('Afonso Henriques','Henrique de Borgonha').
filho('Afonso Henriques','Teresa de Castela').
filho('Urraca','Afonso Henriques').
filho('Sancho I','Afonso Henriques').
filho('Urraca','Mafalda').
filho('Sancho I','Mafalda').
filho('Afonso IX','Urraca').
filho('Afonso IX','Fernando II').
filho('Afonso II','Sancho I').
filho('Afonso II','Dulce de Barcelona').
filho('Berengaria','Sancho I').
filho('Berengaria','Dulce de Barcelona').
filho('Sancho II','Afonso II').
filho('Afonso III','Afonso II').
filho('Sancho II','Urraca C').
filho('Afonso III','Urraca C').

mergeLists([A|As], [B|Bs], [A, B|Rs]) :- !, mergeLists(As, Bs, Rs).
mergeLists([], Bs, Bs) :- !.
mergeLists(As, [], As).

irmao(X, Y) :-
	filho(X, Z),
	filho(Y, Z),
	X \= Y.

primodireito(X, Y) :-
	filho(X, Z),
	filho(Y, W),
	irmao(Z, W),
	X \= Y.

primo(X, Y, P) :-
	filho(X, A),
	filho(Y, B),
	irmao(A, B),
	filho(P, Y),
	X \= Y.

primoPai(X, Y, K) :-
	filho(X, Y),
	primodireito(Y, K),
	X \= Y.

:- dynamic(brothers/1).
inputDB(X) :-
	( brothers(X)
		-> !
		; assertz(brothers(X))
	).

irmaos(X, L) :-
	findall(Y, irmao(X, Y), L1),
	percorrerLista(L1),
	findall(Y, brothers(Y), L),
	retractall(brothers(_)).

percorrerLista([]) :- !.
percorrerLista([L1|L2]) :-
	inputDB(L1),
	percorrerLista(L2).


:-dynamic(cousins/1).
inputDB2(X) :-
	( cousins(X)
		-> !
		; assertz(cousins(X))
	).

percorrerLista2([]) :- !.
percorrerLista2([L1|L2]) :-
	inputDB2(L1),
	percorrerLista2(L2).

primos(X, L) :-
	findall(P, primo(X, Y, P), L1),
	findall(Y, primodireito(X, Y), L2),
	findall(K, primoPai(X, Y, K), L3),
	mergeLists(L1, L2, L4),
	mergeLists(L3, L4, Ls),
	percorrerLista2(Ls),
	findall(C, cousins(C), L).