

% bloco (nomeBloco, tamanhoBloco)

bloco(d,2).
bloco(a,2).

bloco(c,1).
bloco(b,1).



%PERGUNTA 1
% NOTAÇAO STRIPS


% Estado inicial

estado_inicial([bracoEsq([]), bracoDir([]),
				chao(a),chao(b), 
				sobre(d,a), sobre(c,b), 
				livre(d), livre(c)]).


% Estado final

estado_final([bracoEsq([]), bracoDir([]),
				chao(d), chao(c),
				sobre(a,d), sobre(b,c), 
				livre(a), livre(b)]).







% desempilha 1 bloco grande que esteja em cima de outro grande
% e coloca-o nos dois braços


accao(desempilharGrandeDeGrande(D, A),
	[bracoEsq([]), bracoDir([]), livre(D), sobre(D, A)],
	[bracoDir(D), bracoEsq(D), livre(A)],
	[bracoEsq([]), bracoDir([]), livre(D), sobre(D, A)])
	:- bloco(D,2), bloco(A,2), A \= D.



% desempilha 1 bloco grande que esteja no chão
% e coloca-o nos dois braços

accao(desempilharGrandeDeChao(A),
	[bracoEsq([]), bracoDir([]), livre(A), chao(A)],
	[bracoEsq(A), bracoDir(A)],
	[bracoEsq([]), bracoDir([]), livre(A), chao(A)])
	:- bloco(A,2).



% desempilha 1 bloco pequeno que esteja em cima de outro pequeno
% e coloca-o em um braço Esquerdo

accao(desempilharPequenoDePequeno(C),
	[bracoEsq([]), livre(C), sobre(C, B)],
	[bracoEsq(C), livre(B)],
	[bracoEsq([]), livre(C), sobre(C, B)])
	:- bloco(B,1), bloco(C,1), B \= C.



% desempilha 1 bloco pequeno que esteja no chão
% e coloca-o em um braço Direito

accao(desempilharPequenoDeChao(B),
	[bracoDir([]), livre(B), chao(B)],
	[bracoDir(B)],
	[bracoDir([]), livre(B), chao(B)])
	:- bloco(B,1).



% empilha 1 bloco grande das mãos
% no chão

accao(empilharGrandeChao(D),
	[bracoEsq(D), bracoDir(D)],
	[bracoEsq([]), bracoDir([]), livre(D), chao(D)],
	[bracoEsq(D), bracoDir(D)])
	:- bloco(D,2).



% empilha 1 bloco pequeno da mão esquerda
% no chão

accao(empilharPequenoChao(C),
	[bracoEsq(C)],
	[bracoEsq([]), livre(C), chao(C)],
	[bracoEsq(C)])
	:- bloco(C,1).



% empilha 1 bloco grande das mãos
% sobre 1 bloco grande

accao(empilharGrandeSobreGrande(A,D),
	[bracoEsq(A), bracoDir(A)],
	[bracoEsq([]), bracoDir([]), livre(A)],
	[bracoEsq(A), bracoDir(A), livre(D)])
	:- bloco(D,2), bloco(A,2), A \= D.



% empilha 1 bloco pequeno das mão direita
% sobre 1 bloco pequeno

accao(empilharPequenoSobrePequeno(B,C),
	[bracoDir(B)],
	[bracoDir([]), livre(B)],
	[bracoDir(B), livre(C)])
	:- bloco(B,1), bloco(C,1), B \= C.






%PERGUNTA 2
%CALCULO DE SITUAÇOES


h(bracoEsq([]), S0).
h(bracoDir([]), S0).
h(chao(a), S0).
h(chao(b), S0).
h(sobre(d,a), S0).
h(sobre(c,b), S0).
h(livre(d),S0).
h(livre(c),S0).








%PERGUNTA 3
%CONSEQUENCIAS POSITIVAS


h(bracoDir(D), bracoEsq(D), livre(A), r(desempilharGrandeDeGrande(D, A), S)) :-
	h(bracoEsq([]), S),
	h(bracoDir([]), S),
	h(sobre(D, A), S),
	h(livre(D), S).


h(bracoEsq(A), bracoDir(A), r(desempilharGrandeDeChao(A), S)) :-
	h(bracoEsq([]), S),
	h(bracoDir([]), S),
	h(chao(A), S),
	h(livre(A), S).


h(bracoEsq(C), livre(B), bracoDir(A), r(desempilharPequenoDePequeno(C), S)) :-
	h(bracoEsq([]), S),
	h(sobre(C, B), S),
	h(livre(C), S).


h(bracoDir(B), r(desempilharPequenoDeChao(B), S)) :-
	h(bracoDir([]), S),
	h(chao(B), S),
	h(livre(B), S).


h(bracoEsq([]), bracoDir([]), livre(D), chao(D), r(empilharGrandeChao(D), S)) :-
	h(bracoEsq(D), S),
	h(bracoDir(D), S).


h(bracoEsq([]), livre(C), chao(C), r(empilharPequenoChao(C), S)) :-
	h(bracoEsq(C), S).


h(bracoEsq([]), bracoDir([]), livre(A), r(empilharGrandeSobreGrande(A,D), S)) :-
	h(bracoEsq(A), S),
	h(bracoDir(A), S),
	h(livre(D), S).


h(bracoDir([]), livre(B), r(empilharPequenoSobrePequeno(B,C), S)) :-
	h(bracoDir(B), S),
	h(livre(C), S).








%PERGUNTA 4
%INERCIA


h(bracoDir(B), r(A, S)) :-
	h(bracoDir(B), S),
	A \= desempilharPequenoDeChao(B).


h(bracoEsq(B), r(A, S)) :-
	h(bracoEsq(B), S),
	A \= desempilharPequenoDePequeno(B).



h(bracoDir(D), bracoEsq(D), r(B, S)) :-
	h(bracoEsq(D), S),
	h(bracoDir(D), S),
	B \= desempilharGrandeDeGrande(D, A),
	B \= desempilharGrandeDeChao(A).




h(bracoEsq([]), bracoDir([]), r(X, S)) :-
	h(bracoEsq([]), S),
	h(bracoDir([]), S),
	X \= empilharGrandeSobreGrande(A,D),
	X \= empilharGrandeChao(D).



h(bracoEsq([]), r(Y, S)) :-
	h(bracoEsq([]), S),
	Y \= empilharPequenoChao(C).


h(bracoDir([]), livre(B), r(Y, S)) :-
	h(bracoDir([]), S),
	Y \= empilharPequenoSobrePequeno(B,C).







%PERGUNTA 5
%QUERY -  estado final


:-h(bracoEsq([]),S),
h(bracoDir([]),S),
h(chao(d),S),
h(chao(c),S),
h(sobre(a,d),S),
h(sobre(b,c),S),
h(livre(a),S),
h(livre(b),S).








%PERGUNTA 6
%PLANO

S =
r(empilharPequenoSobrePequeno(b,c),
r(desempilharPequenoDeChao(b),
r(empilharPequenoChao(c),
r(desempilharPequenoDePequeno(c),
r(empilharGrandeSobreGrande(a,d),
r(desempilharGrandeDeChao(a),
r(empilharGrandeChao(d),
r(desempilharGrandeDeGrande(d, a),S0))))))))





%PERGUNTA 7
%RELATORIO








