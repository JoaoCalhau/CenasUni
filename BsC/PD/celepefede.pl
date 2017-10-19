%clpfd

fd_domain(X, 0, 10),
fd_domain([A, B, C], 1, 10),
fd_domain(Y, 4, 7),
Y #= A*X*X + B*X + C,
fd_labeling([X, Y, A, B, C]).


fd_domain(A, 1, 4),
fd_domain(P, 1, 10),
fd_domain(C, 1, 40),
20 #= A + P + C,
20 #= A*3 + P*2 + C/2,
fd_labeling([A, P, C]).

fd_domain([Z, M, J, R, F, C, M1, L, S, C1], 2, 6),
fd_all_different([Z, M, J, R, F]),
fd_all_different([C, M1, L, S, C1]),
M #= M1,
Z #= S-1,
S #= R-1,
C #= J-3,
F #= L/2,
fd_labeling([Z, M, J, R, F, C, M1, L, S, C1]).