tamanho_tabuleiro(9). %(3x3)
ocupados([v(p(1, 2), [1,2,3,4,5,6,7,8,9], 1), v(p(1, 6), [1,2,3,4,5,6,7,8,9], 8), v(p(1, 8), [1,2,3,4,5,6,7,8,9], 7), v(p(1, 9), [1,2,3,4,5,6,7,8,9], 3),
          v(p(2, 4), [1,2,3,4,5,6,7,8,9], 5), v(p(2, 6), [1,2,3,4,5,6,7,8,9], 9),
          v(p(3, 1), [1,2,3,4,5,6,7,8,9], 7), v(p(3, 7), [1,2,3,4,5,6,7,8,9], 9), v(p(3, 9), [1,2,3,4,5,6,7,8,9], 4),
          v(p(4, 6), [1,2,3,4,5,6,7,8,9], 4),
          v(p(5, 5), [1,2,3,4,5,6,7,8,9], 3), v(p(5, 6), [1,2,3,4,5,6,7,8,9], 5), v(p(5, 8), [1,2,3,4,5,6,7,8,9], 1), v(p(5, 9), [1,2,3,4,5,6,7,8,9], 8),
          v(p(6, 1), [1,2,3,4,5,6,7,8,9], 8), v(p(6, 4), [1,2,3,4,5,6,7,8,9], 9),
          v(p(7, 4), [1,2,3,4,5,6,7,8,9], 7),
          v(p(8, 1), [1,2,3,4,5,6,7,8,9], 2), v(p(8, 2), [1,2,3,4,5,6,7,8,9], 6), v(p(8, 5), [1,2,3,4,5,6,7,8,9], 4), v(p(8, 8), [1,2,3,4,5,6,7,8,9], 3),
          v(p(9, 3), [1,2,3,4,5,6,7,8,9], 5), v(p(9, 6), [1,2,3,4,5,6,7,8,9], 3)]).

estado_inicial(E) :-
  estado(E1),
  fill(E1, E).

estado(E) :-
  tamanho_tabuleiro(S),
  functor(E, e, 2), arg(1, E, T), arg(2, E, []),
  gerar_tab(T2, S),
  flatten(T2, T).

fill(e(NAfect, Afect), e(NAfect, Afect2)) :-
  ocupados(L),
  append(Afect, L, Afect2).


gerar_tab(L, Size):- 
  gerar_tab(L, 1, Size).

gerar_tab([H], N, N):-
  gerar_coluna(H, N, N).

gerar_tab([H|T], J, N):-
  J < N, J2 is J+1,
  gerar_coluna(H, J, N),
  gerar_tab(T, J2, N).
  
gerar_coluna(L, J, NColunas):- 
  gerar_coluna(L, 1, J, NColunas).

gerar_coluna([H], N, J, N):-
  tamanho_tabuleiro(S),
  range(1, S, D), %cria o dominio da variavel dado um maximo como arg
  ocupados(L),
  ( member(v(p(N, J), D, _), L)
    -> write('')
    ; H = v(p(N, J), D, _)
  ).


gerar_coluna([H|T], I, J, N):-
  tamanho_tabuleiro(S),
  range(1, S, D), %cria o dominio da variavel dado um maximo como arg
  I < N, I2 is I+1,
  ocupados(L),
  ( member(v(p(N, J), D, _), L)
    -> gerar_coluna(T, I2, J, N)
    ; H = v(p(I, J), D, _), gerar_coluna(T, I2, J, N)
  ).



%devolve uma lista com numeros de I a J
range(I,I,[I]).
range(I,J,[I|L]) :- I < J, I1 is I + 1, range(I1,J,L).    


%Restricoes 
ve_restricoes(E):-
  ver_linhas(E),
  ver_colunas(E),
  ver_quadrantes(E).


ver_linhas(e(Nafect,[v(p(X,Y), D, V)|R])):-
  findall(V1,member(v(p(X,_),_,V1),R),L),
   todos_diff([V|L]).
  
ver_colunas(e(Nafect,[v(p(X,Y), D, V)|R])):-
  findall(V1,member(v(p(_,Y),_,V1),R),L),
  todos_diff([V|L]).


ver_quadrantes(e(_,Afect)) :-
  ver_quad(Afect, 1, 1, 3, Q1),
  todos_diff(Q1),
  ver_quad(Afect, 1, 4, 6, Q2),
  todos_diff(Q2),
  ver_quad(Afect, 1, 7, 9, Q3),
  todos_diff(Q3),
  ver_quad(Afect, 4, 1, 3, Q4),
  todos_diff(Q4),
  ver_quad(Afect, 4, 4, 6, Q5),
  todos_diff(Q5),
  ver_quad(Afect, 4, 7, 9, Q6),
  todos_diff(Q6),
  ver_quad(Afect, 7, 1, 3, Q7),
  todos_diff(Q7),
  ver_quad(Afect, 7, 4, 6, Q8),
  todos_diff(Q8),
  ver_quad(Afect, 7, 7, 9, Q9),
  todos_diff(Q9).


ver_quad(L, X, Y, Y2, Q) :-
  Y = Y2, X1 is X+2,
  add_quad(L, X, Y, X1, Q).

ver_quad(L, X, Y, Y2, Q) :-
  Y < Y2, Y1 is Y+1,
  X1 is X+2,
  add_quad(L, X, Y, X1, L1),
  append(L1, L2, Q),
  ver_quad(L, X, Y1, Y2, L2).

add_quad(L, X, Y, X2, []) :-
  X = X2,
  \+member(v(p(X, Y), _, _), L).

add_quad(L, X, Y, X2, [V]) :-
  X = X2,
  member(v(p(X, Y), _, V), L).

add_quad(L, X, Y, X2, T) :-
  X < X2, X1 is X+1,
  \+member(v(p(X, Y), _, _), L),
  add_quad(L, X1, Y, X2, T).

add_quad(L, X, Y, X2, [V|T]) :-
  X < X2,
  member(v(p(X, Y), _, V), L),
  X1 is X+1,
  add_quad(L, X1, Y, X2, T).


todos_diff([]).
todos_diff([X|R]):-
  \+ member(X,R), todos_diff(R).

%% escreve
%esc(_).


%% escreve
%esc(_).

esc(L):-sort(L, L1), esc_a(L1),nl.
esc_a(L):- tamanho_tabuleiro(S), esc_l(L, 1, S).

esc_l([H], S, S):-
  H = v(_,_,X), write(X),nl.

esc_l([H|T], S, S):-
  H = v(_,_,X), write(X), nl,
  esc_l(T, 1, S).

esc_l([H|T], I, S):- 
  I<S, I2 is I+1,
  H = v(_,_,X), write(X),write(' . '),
  esc_l(T, I2, S).