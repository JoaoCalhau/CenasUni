estado_inicial([bracoEsq([]), bracoDir([]),
				chao(a),chao(b), 
				sobre(d,a), sobre(c,b), 
				livre(d), livre(c)]).



estado_final([bracoEsq([]), bracoDir([]),
				chao(d),sobre(b,d), 
				sobre(c,d), sobre(a,b), sobre(a,c),
				livre(a)]).


accao(desempilharGrandeDeGrande(D, A),
	[bracoEsq([]), bracoDir([]), livre(D), sobre(D, A)],
	[bracoDir(D), bracoEsq(D), livre(A)],
	[bracoEsq([]), bracoDir([]), livre(D), sobre(D, A)])
	:- member(D, [a, d]), member(A, [a, d]), A \= D.

accao(empilharGrandeChao(D),
	[bracoEsq(D), bracoDir(D)],
	[bracoEsq([]), bracoDir([]), livre(D), chao(D)],
	[bracoEsq(D), bracoDir(D)])
	:- member(D, [a, d]).

accao(desempilharPequenoDePequeno(C),
	[bracoEsq([]), bracoDir([]), livre(C), sobre(C, B)],
	[bracoEsq(C), bracoDir([]), livre(B)],
	[bracoEsq([]), bracoDir([]), livre(C), sobre(C, B)])
	:- member(B, [b, c]), member(C, [b, c]), B \= C.

accao(desempilharPequenoDeChao(B),
	[bracoEsq(C), bracoDir([]), livre(B), chao(B)],
	[bracoEsq(C), bracoDir(B)],
	[bracoEsq(C), bracoDir([]), livre(B), chao(B)])
	:- member(B, [b, c]), member(C, [b, c]), B \= C.

accao(empilhar2PequenosGrande(B, C, D),
	[bracoEsq(C), bracoDir(B), livre(D)],
	[bracoEsq([]), bracoDir([]), livre(B), livre(C), sobre(B, D), sobre(C, D)],
	[bracoEsq(C), bracoDir(B), livre(D)])
	:- member(B, [b, c]), member(C, [b, c]), B \= C, member(D, [a, d]).

accao(desempilharGrandeDeChao(A),
	[bracoEsq([]), bracoDir([]), livre(A), chao(A)],
	[bracoEsq(A), bracoDir(A)],
	[bracoEsq([]), bracoDir([]), livre(A), chao(A)])
	:- member(A, [a, d]).

accao(empilharGrande2Pequenos(A, B, C),
	[bracoEsq(A), bracoDir(A), livre(B), livre(C)],
	[bracoEsq([]), bracoDir([]), livre(A), sobre(A, B), sobre(A, C)],
	[bracoEsq(A), bracoDir(A), livre(B), livre(C)])
	:- member(A, [a, d]), member(B, [b, c]), member(C, [b, c]), B \= C.