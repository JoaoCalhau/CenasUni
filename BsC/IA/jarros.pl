%estado

%(Conteudo_de_c1,Conteudo_de_c2,Conteudo_de_saco)

%estado final
estado_inicial((0,0)).

%estado final
estado_final((0,1)).


capacidade(c1,3).
capacidade(c2,2).

%op(Estado_act,operador,Estado_seg,Custo)
op((A,B),e(c1),(A1,B),1):- capacidade(c1,A1), A \= A1.
op((A,B),e(c2),(A,B1),1):- capacidade(c2,B1),B\=B1.
op((A,B),d(c1),(0,B),1):- A\= 0.
op((A,B),d(c2),(A,0),1):- B\=0.
op((A,B),d(c1,c2),(A2,B3),1):- capacidade(c2,B1), B2 is A+B,
                              min(B3,B1,B2), A3 is B2 - B3,
                              max(A2,A3,0), A\=A2,B\=B3.
op((B,A),d(c2,c1),(B3,A2),1):- capacidade(c1,B1), B2 is A+B, 
                              min(B3,B1,B2), A3 is B2 - B3,
                              max(A2,A3,0), A\=A2,B\=B3.

max(A,A,B):- A>B,!.
max(A,_,A).

min(A,A,B):- A<B,!.
min(A,_,A).