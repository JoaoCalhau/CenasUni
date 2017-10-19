estado_inicial(e([
          v(c(1),[1,2,3,4],_),
          v(c(2),[1,2,3,4],_),
          v(c(3),[1,2,3,4],_),
          v(c(4),[1,2,3,4],_)], [])).

ve_restricoes(e(Nafect, Afect)) :-
		length(Afect, Size),
		restricoes(e(Nafect, Afect), Size).

restricoes(e(Nafect, Afect), 1) :- 
		nth(1, Afect, v(c(1), _, R1)),
		fd_domain([R1], [2,3]),
		fd_labeling([R1]).

restricoes(e(Nafect, Afect), 2):-
	nth(1, Afect, v(c(1), _, R1)),
	nth(2, Afect, v(c(2), _, R2)),
   	fd_all_different([R1,R2]),
	fd_domain([R1],[2,3]), 
	fd_domain([R2],[1,4]),
	#\=#(R1, R2+1), #\=#(R1, R2-1),
	fd_labeling([R1,R2]). 

restricoes(e(Nafecf, Afect), 3):-
	nth(1, Afect, v(c(1), _, R1)),
	nth(2, Afect, v(c(2), _, R2)),
	nth(3, Afect, v(c(3), _, R3)),
	fd_all_different([R1,R2,R3]),
	fd_domain([R1],[2,3]),
	fd_domain([R2,R3],[1,4]),
	#\=#(R1, R2+1), #\=#(R1, R2-1), 
	fd_labeling([R1,R2,R3]).


restricoes(e(Nafecf, Afect), 4):-
	nth(1, Afect, v(c(1), _, R1)),
	nth(2, Afect, v(c(2), _, R2)),
	nth(3, Afect, v(c(3), _, R3)),
	nth(4, Afect, v(c(4), _, R4)),	
	fd_all_different([R1,R2,R3,R4]),
	fd_domain([R1,R4],[2,3]), 
	fd_domain([R2,R3],[1,4]),
	#\=#(R1, R2+1), #\=#(R3, R4+1), #\=#(R1, R2-1), 
	#\=#(R3, R4-1),
	fd_labeling([R1,R2,R3,R4]).

esc(L):- sort(L,L1), write(L1), nl, esc1(L1).
esc1([]).
esc1([v(_,_,V)|R]):- esc(4,V,1),  esc1(R).
esc(V,V,V):- !,write(r),nl.
esc(V,N,V):- !,write('_'),nl.
esc(V,N,N):-!,write(r), M is N+1, esc(V,N,M).
esc(V,N1,N):-write('_'), M is N+1, esc(V,N1,M).