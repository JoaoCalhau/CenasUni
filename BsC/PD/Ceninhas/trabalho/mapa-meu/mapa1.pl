
%salas
quarto(1, 'Entrance - Room 1', 0).
quarto(2, 'Room 2', 0).
quarto(3, 'Room 3', 0).
quarto(4, 'Room 4', 0).
quarto(5, 'Room 5', 0).
quarto(6, 'Room 6', 0).
quarto(7, 'Boss Room - Room 7', 0).


%paths


passagem(1, 2, e).
passagem(2, 1, n).

passagem(1, 4, w).
passagem(4, 1, e).

passagem(4, 5, w).
passagem(5, 4, s).

passagem(4, 3, s).
passagem(3, 4, w).

passagem(5, 6, e).
passagem(6, 5, w).

passagem(3, 2, e).
passagem(2, 3, w).

passagem(3, 5, s).
passagem(5, 3, n).

passagem(5, 7, se).
passagem(7, 5, n).

passagem(7,8,down).
passagem(8,7,up).

