:-dynamic(diag/1, diag2/1, conta/1).


% valor define tamanho, 3 ->  3x3 , 4 -> 4x4 ...
tamanho_tabuleiro(3). %(3x3)

% estado_inicial E contém e(Nafec,Afect) criado em functor
%conta contém o valor soma de cada linha/coluna/diagonal
estado_inicial(E):-
  tamanho_tabuleiro(S),
  SS is S * S,
  KK is S * (SS + 1),
  K is KK // 2,
  assertz(conta(K)),
  functor(E, e, 2), arg(1, E, T), arg(2, E, []),
  gerar_tab(T2, S),
  flatten(T2, T).


%gerar_tab cria o tabuleiro, inicializando variaveis
%conforme o valor do tamanho_tabuleiro
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
  S1 is S * S,
  range(1, S1, D), %cria o dominio da variavel dado um maximo como arg
  H = v(p(N, J), D, _).


gerar_coluna([H|T], I, J, N):-
  tamanho_tabuleiro(S),
  S1 is S * S,
  range(1, S1, D), %cria o dominio da variavel dado um maximo como arg
  I < N, I2 is I+1,
  H = v(p(I, J), D, _),
  gerar_coluna(T, I2, J, N).



%devolve uma lista com numeros de I a J
range(I,I,[I]).
range(I,J,[I|L]) :- I < J, I1 is I + 1, range(I1,J,L).    



%Restricoes 
ve_restricoes(E):- 
  tamanho_tabuleiro(T),
  ver_tudo(E),
  ver_linhas(E,L1,T1),
  ver_colunas(E,L2,T2),
  ver_diagonal_dir(E,L3,T3),
  ver_diagonal_esq(E, L4, T4),

  conta(K),

  (=(T, T1)
    -> (=(K, L1)
        -> true
        ; fail)
    ; true),

  (=(T, T2)
    -> (=(K, L2)
        -> true
        ; fail)
    ; true),

  (=(T, T3)
    -> (=(K, L3)
        -> true
        ; fail)
    ; true),

  (=(T, T4)
    -> (=(K, L4)
        -> true
        ; fail)
    ; true).



ver_tudo(e(Nafect,[v(p(_,_), D, V)|R])):-
  findall(V1,member(v(p(_,_),_,V1),R),L),
  todos_diff([V|L]).



ver_linhas(e(Nafect,[v(p(X,Y), D, V)|R]),S, T):-
  findall(V1,member(v(p(X,_),_,V1),R),L),
   todos_diff([V|L]), length([V|L],T),
  sum_list([V|L],S).
  
  

ver_colunas(e(Nafect,[v(p(X,Y), D, V)|R]),S, T):-
  findall(V1,member(v(p(_,Y),_,V1),R),L),
  todos_diff([V|L]), length([V|L],T),
   sum_list([V|L],S).
   


ver_diagonal_dir(e(Nafect,[v(p(X,Y), D, V)|R]),S, T):-
  tamanho_tabuleiro(Tb),
  Ta is Tb * Tb,
  findall((K1,K2,V1),member(v(p(K1,K2),_,V1),R),L),
  length([(X,Y,V)|L],Tc),

  (=(Tc,Ta)
    ->
    (verify_dir([(X,Y,V)|L], Result), diag(Diag), 
      sum_list(Diag,S), length(Diag,T))
  ;
  true).


  ver_diagonal_esq(e(Nafect,[v(p(X,Y), D, V)|R]),S, T):-
  tamanho_tabuleiro(Tb),
  Ta is Tb * Tb,
  findall((K1,K2,V1),member(v(p(K1,K2),_,V1),R),L),
  length([(X,Y,V)|L],Tc),
  (=(Tc,Ta)
    ->
    (verify_esq([(X,Y,V)|L], Result), diag2(Diag),
      sum_list(Diag,S), length(Diag,T))
  ;
  true).

verify_dir([],[X, Y, Z, W, J|H]):-
      tamanho_tabuleiro(K),
      ((K=3 ) 
        -> retractall(diag(_)), assertz(diag([X, Y, Z]))
        ;
        ((K=4 ) 
        -> retractall(diag(_)), assertz(diag([X, Y, Z, W]))
        ; ((K=5 ) 
        -> retractall(diag(_)), assertz(diag([X, Y, Z, W, J]))
        


      ))).

verify_dir([(X,Y,V)|Antiga2], []):-
    (=(X,Y)
      ->
      verify_dir(Antiga2,[V])

      ; verify_dir(Antiga2,[])

    ).

verify_dir([(X,Y,V)|Antiga2], Nova):-
    (=(X,Y)
      ->  (merge_list([V], Nova, N),
          verify_dir(Antiga2,N))

      ; verify_dir(Antiga2,Nova)

    ).



verify_esq([],[X, Y, Z, W, J|H]):- 
      tamanho_tabuleiro(K),
      ((K=3 ) 
        -> retractall(diag2(_)), assertz(diag2([X, Y, Z]))
        ;
        ((K=4 ) 
        -> retractall(diag2(_)), assertz(diag2([X, Y, Z, W]))
        ; ((K=5 ) 
        -> retractall(diag2(_)), assertz(diag2([X, Y, Z, W, J]))
        


      ))).

verify_esq([(X,Y,V)|Antiga2], []):-
    tamanho_tabuleiro(S),
    S1 is S + 1,
    K is X + Y,
    (=(S1, K)
      ->
      verify_esq(Antiga2,[V])

      ; verify_esq(Antiga2,[])

    ).

verify_esq([(X,Y,V)|Antiga2], Nova):-
    tamanho_tabuleiro(S),
    S1 is S + 1,
    K is X + Y,
    (=(S1, K)
      ->  (merge_list([V], Nova, N),
          verify_esq(Antiga2,N))

      ; verify_esq(Antiga2,Nova)

    ).

merge_list([],L,L ).
merge_list([H|T],L,[H|M]):-
    merge_list(T,L,M).

todos_diff([]).
todos_diff([X|R]):-
  \+ member(X,R), todos_diff(R).



%% escreve
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