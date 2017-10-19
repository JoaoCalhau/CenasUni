:-dynamic(inventario/2, itemQuarto/3, rpg/0, atual/1).
:-dynamic(monster/3, passable/3, cPlayer/2, recordVar/1, record/1, player/3).

%rooms floor 0
quarto(1, 'Entrance - Room 1', 0).
quarto(2, 'Room 2', 0).
quarto(3, 'Room 3', 0).
quarto(4, 'Room 4', 0).
quarto(5, 'Room 5', 0).
quarto(6, 'Room 6', 0).
quarto(7, 'Boss Room - Room 7', 0).

%rooms floor 1
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

%rooms floor 2
quarto(19, 'Entrance - Room 19', 2).
quarto(20, 'Room 20', 2).
quarto(21, 'Room 21', 2).
quarto(22, 'Room 22', 2).
quarto(23, 'Room 23', 2).
quarto(24, 'Room 24', 2).
quarto(25, 'Room 25', 2).
quarto(26, 'Room 26', 2).
quarto(27, 'Room 27', 2).
quarto(28, 'Room 28', 2).
quarto(29, 'Room 29', 2).
quarto(30, 'Room 30', 2).
quarto(31, 'Room 31', 2).
quarto(32, 'Room 32', 2).
quarto(33, 'Room 33', 2).
quarto(34, 'Final Boss Room - Room 34', 2).
quarto(35, 'Room 35', 2).


%paths floor 0
passagem(1, 2, e).
passagem(1, 4, w).
passagem(2, 1, n).
passagem(2, 3, w).
passagem(3, 2, e).
passagem(3, 4, w).
passagem(3, 5, s).
passagem(4, 1, e).
passagem(4, 3, s).
passagem(4, 5, w).
passagem(5, 3, n).
passagem(5, 4, s).
passagem(5, 6, w).
passagem(5, 7, se).
passagem(6, 5, e).
passagem(7, 5, n).
passagem(7, 8, down).


%paths floor 1
passagem(8, 7, up).
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
passagem(18, 19, down).


%paths floor 2
passagem(19, 18, up).
passagem(19, 20, n).
passagem(19, 21, nw).
passagem(20, 19, s).
passagem(20, 21, n).
passagem(20, 22, e).
passagem(21, 19, sw).
passagem(21, 20, s).
passagem(21, 23, se).
passagem(22, 20, w).
passagem(22, 25, ne).
passagem(22, 28, s).
passagem(23, 21, nw).
passagem(23, 24, n).
passagem(23, 25, e).
passagem(24, 23, s).
passagem(24, 25, se).
passagem(24, 28, e).
passagem(25, 22, sw).
passagem(25, 23, w).
passagem(25, 24, nw).
passagem(25, 26, n).
passagem(25, 27, s).
passagem(26, 25, s).
passagem(27, 25, n).
passagem(27, 29, w).
passagem(27, 30, s).
passagem(27, 31, e).
passagem(27, 32, ne).
passagem(27, 33, se).
passagem(28, 22, n).
passagem(28, 24, s).
passagem(28, 29, e).
passagem(29, 27, e).
passagem(29, 28, s).
passagem(30, 27, n).
passagem(31, 27, w).
passagem(32, 27, sw).
passagem(33, 27, nw).
passagem(33, 34, ne).
passagem(33, 35, se).
passagem(34, 33, s).
passagem(35, 33, nw).


%foods
item(1, 'Loaf Of Bread', 2).
item(2, 'Chicken Leg', 4).
item(3, 'Strawberry Pie', 6).
item(4, 'Cup Of Noodles', 8).
item(5, 'Steak Of The Gods', 10).

%weapons
item(6, 'Steel Dagger', 2).
item(7, 'Enchanted Dagger', 4).
item(8, 'Steel Sword', 6).
item(9, 'Enchanted Sword', 8).
item(10, 'Legendary Sword Of Mass Destruction', 10).

%shields
item(11, 'Steel Buckler', 2).
item(12, 'Enchanted Buckler', 4).
item(13, 'Steel Shield', 6).
item(14, 'Enchanted Shield', 8).
item(15, 'Legendary Shield Of Mass Defense', 10).

%summoning
item(16, 'Legendary Carrot Of Epicness', 0).
item(17, 'Furry Tail', 0).

%items in rooms
itemQuarto(6, 7, 'Enchanted Dagger').
itemQuarto(2, 12, 'Enchanted Buckler').
itemQuarto(1, 1, 'Loaf Of Bread').
itemQuarto(1, 1, 'Loaf Of Bread').
itemQuarto(3, 2, 'Chicken Leg').
itemQuarto(5, 2, 'Chicken Leg').
itemQuarto(6, 16, 'Legendary Carrot Of Epicness').

itemQuarto(14, 8, 'Steel Sword').
itemQuarto(17, 13, 'Steel Shield').
itemQuarto(8, 1, 'Loaf Of Bread').
itemQuarto(8, 1, 'Loaf Of Bread').
itemQuarto(17, 2, 'Chicken Leg').
itemQuarto(13, 3, 'Strawberry Pie').
itemQuarto(15, 17, 'Furry Tail').

itemQuarto(26, 9, 'Enchanted Sword').
itemQuarto(28, 14, 'Enchanted Shield').
itemQuarto(35, 10, 'Legendary Sword Of Mass Destruction').
itemQuarto(32, 15, 'Legendary Shield Of Mass Defense').
itemQuarto(20, 1, 'Loaf Of Bread').
itemQuarto(21, 2, 'Strawberry Pie').
itemQuarto(28, 2, 'Cup Of Noodles').
itemQuarto(33, 1, 'Loaf Of Bread').
itemQuarto(32, 3, 'Strawberry Pie').


%monster(ID, HP, attack, defense, description).
monsterID(a, 10, 2, 0, 'Homunculus').
monsterID(b, 10, 4, 2, 'Wyrm Empress').
monsterID(c, 10, 6, 5, 'Spider Queen').

monsterID(d, 2, 1, 0, 'Dire Rat').
monsterID(e, 4, 2, 1, 'Goblin Dog').
monsterID(f, 5, 2, 1, 'Ghoul').
monsterID(g, 4, 2, 0, 'Svirfneblin').
monsterID(h, 3, 1, 0, 'Human Skeleton').
monsterID(i, 5, 2, 0, 'Iron Cobra').

%companion(ID, attack, description)
companion(a, 0, 'Stony, The Stone', 'A stone......HEY! Its better than nothing...').
companion(b, 1, 'Snuggles, The Golden Rabbit', 'An adorable little rabbit.').
companion(c, 2, 'Foxy, The Nine-Tailed Fox', 'A cute little fox.').

%monster(MonsterID, CurrentHP, Room)
%mobs floor 0:
monster(a, 10, 7).
monster(d, 2, 3).
monster(h, 3, 4).

%mobs floor 1:
monster(b, 10, 18).
monster(g, 4, 10).
monster(i, 5, 16).

%mobs floor 2:
monster(c, 10, 34).
monster(d, 2, 22).
monster(f, 5, 23).
monster(e, 4, 27).

%passable(room, roomTo,y/n)
passable(7, 8, n).
passable(7, 5, y).

passable(18, 19, n).
passable(18, 17, y).

%player(HP, WeaponID, ShieldID).
player(10, 6, 11).

%cPlayer(Current HP, companion)
cPlayer(10, a).

jogar(start) :- 
	nl,
	write('(For a full experience please compile the file again, so all the items are available again)'),nl,
	write('As you are taking your regular walk, you stumble upon a dungeon.'), nl,
	write('You decide to take a look, seeing as you have nothing better to do...'), nl,
	write('As you walk down the first flight of stairs, you find a Dagger and a Wooden Shield.'), nl,
	write('Of course you take them with you (who wouldnt?).'), nl,
	write('Looks like an adventure is starting...'), nl,
	retractall(atual(_)),
	asserta(atual(1)),
	retractall(record(_)),
	retractall(recordVar(_)),
	asserta(recordVar(n)),
	nl.

jogar(attack) :-
	nl,
	atual(X),
	player(_, W, S),
	item(S, _, PD),
	item(W, _, PA),
	cPlayer(HP, Pet),
	companion(Pet, PetAttack, PetName, _),
	( monster(ID, CHP, X)
	-> (monsterID(ID, _, A, D, _), PAttack is PA-D, TotalAttack is PAttack+PetAttack, NHP is CHP-TotalAttack, write('The player attacks the monster for '), write(PAttack), write(' points of damage, with a little help of '), write(PetName), write(' you do an extra '), write(PetAttack), nl, MAttack is A-PD, PNHP is HP-MAttack, write('The monster attacks the player back for '), write(MAttack), write(' points of damage'), nl)
	; (write('There is no monster in this room...'), nl)
	),
	( PNHP =< 0
	-> (write('You are now dead!, GAME OVER'), nl, break)
	; write('')
	),
	( NHP =< 0 
	-> (write('The monster has been slain!!'), nl, retract(monster(ID,_,_)), retract(passable(X, Y, n)), asserta(passable(X, Y, y)))
	; (retract(monster(ID,_,_)), asserta(monster(ID, NHP, X)), retract(cPlayer(_,_)), asserta(cPlayer(PNHP, Pet)))
	),
	recordVar(R),
	( R == y
	-> assertz(record(attack))
	; write('')
	),
	nl.

jogar(inspectM) :-
	nl,
	atual(X),
	( monster(ID, HP, X)
	-> (monsterID(ID, _, A, D, Desc), write('The monsters name is '), write(Desc), nl, write('The monsters attack is '), write(A), nl, write('The monsters defense is '), write(D), nl, write('The monster has '), write(HP), write(' HP'), nl)
	; (write('There is no monster in this room...'), nl)
	),
	recordVar(R),
	( R == y
	-> assertz(record(inspectM)) 
	; write('')
	),
	nl.

jogar(inspectP) :-
	nl,
	player(_, W, S),
	cPlayer(HP, Pet),
	companion(Pet, PetAttack, PetName, PetDescription),
	item(W, N, A),
	item(S, N1, D),
	write('You currently have '), write(HP), write(' HP'), nl,
	write('On your right hand you have a '), write(N), write(' with '), write(A), write(' attack.'), nl,
	write('On you left hand you have a '), write(N1), write(' with '), write(D), write(' defense.'), nl,
	write('Behind you is '), write(PetName), write(' it is '), write(PetDescription), write('. He adds '), write(PetAttack), write(' attack.'), nl,
	recordVar(R),
	( R == y
	-> assertz(record(inspectP))
	; write('')
	),
	nl.

jogar(record) :-
	nl,
	retractall(record(_)),
	retractall(recordVar(_)),
	asserta(recordVar(y)),
	nl.

jogar(forget) :-
	nl,
	retractall(recordVar(_)),
	asserta(recordVar(n)),
	nl.

jogar(track) :-
	nl,
	write('['),
	forall(record(X), ((write(X), write('   ')))), write(']'), nl.

jogar(go(N)) :-
	nl,
	passagem(X, N, _),
	atual(X),
	retractall(atual(_)),
	asserta(atual(N)),
	recordVar(R),
	( R == y
	-> assertz(record(go(N)))
	; write('')
	),
	nl.

jogar(n) :- 
	nl,
	atual(X),
	passagem(X, Y, n),
	quarto(Y, Z, _),
	retract(atual(_)),
	asserta(atual(Y)),
	write('Advanced to '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(n))
	; write('')
	),
	nl.

jogar(s) :-
	nl,
	atual(X),
	passagem(X, Y, s),
	retract(atual(_)),
	quarto(Y, Z, _),
	asserta(atual(Y)),
	write('Advanced to '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(s))
	; write('')
	),
	nl.

jogar(e) :- 
	nl,
	atual(X),
	passagem(X, Y, e),
	quarto(Y, Z, _),
	retract(atual(_)),
	asserta(atual(Y)),
	write('Advanced to '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(e))
	; write('')
	),
	nl.

jogar(w) :- 
	nl,
	atual(X),
	passagem(X, Y, w),
	quarto(Y, Z, _),
	retract(atual(_)),
	asserta(atual(Y)),
	write('Advanced to '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(w))
	; write('')
	),
	nl.

jogar(nw) :-
	nl,
	atual(X),
	passagem(X, Y, nw),
	quarto(Y, Z, _),
	retract(atual(_)),
	asserta(atual(Y)),
	write('Advanced to '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(nw))
	; write('')
	),
	nl.

jogar(sw) :-
	nl,
	atual(X),
	passagem(X, Y, sw),
	quarto(Y, Z, _),
	retract(atual(_)),
	asserta(atual(Y)),
	write('Advanced to '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(sw))
	; write('')
	),
	nl.

jogar(ne) :-
	nl,
	atual(X),
	passagem(X, Y, ne),
	quarto(Y, Z, _),
	retract(atual(_)),
	asserta(atual(Y)),
	write('Advanced to '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(ne))
	; write('')
	),
	nl.

jogar(se) :-
	nl,
	atual(X),
	passagem(X, Y, se),
	quarto(Y, Z, _),
	retract(atual(_)),
	asserta(atual(Y)),
	write('Advanced to '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(se))
	; write('')
	),
	nl.

jogar(up) :-
	nl,
	atual(X),
	passagem(X, Y, up),
	quarto(Y, Z, _),
	retract(atual(_)),
	asserta(atual(Y)),
	quarto(X, _, Z),
	Z1 is Z-1,
	write('You went up a floor! You are now on floor: '), write(Z1), nl,
	recordVar(R),
	( R == y
	-> assertz(record(up))
	; write('')
	),
	nl.

jogar(down) :-
	nl,
	atual(X),
	passagem(X, Y, down),
	passable(X, Y, P),
	( P == y
	-> (retract(atual(_)), asserta(atual(Y)), quarto(X, _, Z), Z1 is Z+1, write('You went down a floor! You are now on floor: '), write(Z1), nl)
	; (write('There is a monster blocking your way...'), nl)
	),
	recordVar(R),
	( R == y
	-> assertz(record(down))
	; write('')
	),
	nl.

jogar(inv) :- 
	nl,
	forall(inventario(X, Y), (write('Item Number: '), write(X), write(' - '), write(Y), nl)),
	recordVar(R),
	( R == y
	-> assertz(record(inv))
	; write('')
	),
	nl.

jogar(look) :-
	nl,
	write('You take a look around...'), nl,
	atual(X),
	quarto(X, N, A),
	write('Current Floor: '), write(A), nl, write('Current Room: '), write(N), nl,
	forall(passagem(X, H, Y), ((write('Exit: '), write(Y), write(' (To room number: '), write(H), write(')'), nl))),
	forall(itemQuarto(X, Z, K), ((write('Item number '), write(Z), write(': '), write(K), nl))),
	( monster(ID, _, X)
	-> (write('There is a monster in this room'), nl)
	; write('')
	),
	recordVar(R),
	( R == y
	-> assertz(record(look))
	; write('')
	),
	nl.

%get para numero
jogar(get(X)) :-
	nl,
	itemQuarto(Y, X, Z),
	atual(Y),
	asserta(inventario(X, Z)),
	write('You picked up a '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(get(X)))
	; write('')
	),
	retract(itemQuarto(Y, X, Z)), nl, !.

%get para nome
jogar(get(Z)) :-
	nl,
	itemQuarto(Y, X, Z),
	atual(Y),
	asserta(inventario(X, Z)),
	write('You picked up a '), write(Z), nl,
	recordVar(R),
	( R == y
	-> assertz(record(get(Z)))
	; write('')
	),
	retract(itemQuarto(Y, X, Z)), nl, !.

jogar(drop(X)) :-
	nl,
	inventario(X, Y),
	atual(Z),
	asserta(itemQuarto(Z, X, Y)),
	write('You droped the '), write(Y), nl,
	recordVar(R),
	( R == y
	-> assertz(record(drop(X)))
	; write('')
	),
	retract(inventario(X, Y)), nl, !.

jogar(jump(N)) :-
	nl,
	retractall(atual(_)),
	asserta(atual(N)),
	write('You were teleported to Room '), write(N), nl,
	recordVar(R),
	( R == y
	-> assertz(record(jump(N)))
	; write('')
	),
	nl.

jogar(warp(X)) :-
	nl,
	atual(Y),
	item(X, K, W),
	asserta(itemQuarto(Y, X, K)),
	recordVar(R),
	( R == y
	-> assertz(record(warp(X)))
	; write('')
	),
	nl.

jogar(destroy(X)) :-
	nl,
	atual(Y),
	item(X, K),
	itemQuarto(Y, X, K),
	recordVar(R),
	( R == y
	-> assertz(record(destroy(X)))
	; write('')
	),
	retract(itemQuarto(Y, X, K)), nl, !.

jogar(listItem) :-
	nl,
	forall(item(X, Y), (nl, write('Item number: '), write(X), write('    Name: '), write(Y), nl)),
	recordVar(R),
	( R == y
	-> assertz(record(listItem))
	; write('')
	),
	nl.

jogar(eat(X)) :-
	nl,
	inventario(X, Y),
	( X > 6
	-> !
	; write('')
	),
	item(X, Y, Z),
	retract(inventario(X, Y)),
	cPlayer(HP, Pet),
	NHP is HP+Z,
	( NHP > 10
	-> retract(cPlayer(_,_)), asserta(cPlayer(10, Pet))
	; retract(cPlayer(_,_)), asserta(cPlayer(NHP, Pet))
	), 
	write('You ate a '), write(Y), nl,
	write('Your HP is now '), write(NHP),
	nl.

jogar(equip(X)) :-
	nl,
	inventario(X, Y),
	item(X, Y, Z),
	player(HP, Sword, Shield),
	( X > 5, X < 11
	-> retract(player(_,_,_)), asserta(player(HP, X, Shield)), retract(inventario(X, Y))
	; write('')
	),
	( X > 10, X < 16
	-> retract(player(_,_,_)), asserta(player(HP, Sword, X)), retract(inventario(X, Y))
	; write(''), nl
	),
	write('You equipped the '), write(Y), nl,
	nl.

jogar(summon(X)) :-
	nl,
	inventario(X, Y),
	item(X, Y, Z),
	cPlayer(HP, Pet),
	( X = 16
	-> companion(b, PetAttack, PetName, PetDescription), retract(cPlayer(_,_)), asserta(cPlayer(HP, b)), write('You successfully summoned '), write(PetName), nl
	; write('')
	),
	( X = 17
	-> companion(c, PetAttack, PetName, PetDescription), retract(cPlayer(_,_)), asserta(cPlayer(HP, c)), write('You successfully summoned '), write(PetName), nl
	; write(''), nl
	),
	nl.

%incomplete
jogar(stop) :-
	break.

rpg :-
	repeat, read(A), jogar(A), fail.