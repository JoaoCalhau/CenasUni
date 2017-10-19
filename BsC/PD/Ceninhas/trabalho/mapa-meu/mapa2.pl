
%salas

quarto(8, 'Entrance - Room 8', 1).
quarto(9, 'Room 9', 1).
quarto(10, 'Room 10', 1).
quarto(11, 'Room 11', 1).
quarto(12, 'Room 12', 1).
quarto(13, 'Room 13', 1).
quarto(14, 'Room 14', 1).
quarto(15, 'Room 15', 1).
quarto(16, 'Room 16', 1).
quarto(17, 'Room 17', 1).
quarto(18, 'Boss Room - Room 18', 1).

%paths

passagem(8, 10, s).
passagem(8, 9, e).
passagem(9, 10, nw).
passagem(9, 8, w).
passagem(9, 11, n).
passagem(10, 15, n).
passagem(10, 9, ne).
passagem(10, 8, e).
passagem(10, 14, s).
passagem(10, 13, w).
passagem(11, 9, n).
passagem(11, 12, w).
passagem(12, 11, e).
passagem(12, 16, w).
passagem(13, 18, n).
passagem(13, 15, ne).
passagem(13, 14, s).
passagem(13, 10, e).
passagem(14, 10, n).
passagem(14, 13, w).
passagem(15, 10, e).
passagem(15, 13, s).
passagem(16, 12, n).
passagem(16, 17, s).
passagem(17, 18, ne).
passagem(17, 16, n).
passagem(18, 13, s).
passagem(18, 17, sw).




passagem(18,19,down).
passagem(19,18,up).