local chunk = assert(loadfile("JogoDoGalo.lua"))
chunk()

local galo = TicTacToe()

--[[
-- Checks de fim de jogo
galo.newTable(3)

print(galo.printTab())

print('  ' .. tostring(galo.finished()))
print('')

--[ Check Diag Esquerda ]--
galo.play(1,1,"x")
galo.play(2,2,"x")
galo.play(3,3,"x")

print(galo.printTab())

print('  ' .. tostring(galo.finished()))
print('')


galo.newTable(3)

--[ Check Diag Direita ]--
galo.play(1,3,"x")
galo.play(2,2,"x")
galo.play(3,1,"x")

print(galo.printTab())

print('  ' .. tostring(galo.finished()))
print('')

galo.newTable(3)

--[ Check Linha n=0 ]--
galo.play(1,1,"x")
galo.play(1,2,"x")
galo.play(1,3,"x")

print(galo.printTab())

print('  ' .. tostring(galo.finished()))
print('')

galo.newTable(3)

--[ Check linha n=1 ]--
galo.play(2,1,"x")
galo.play(2,2,"x")
galo.play(2,3,"x")

print(galo.printTab())

print('  ' .. tostring(galo.finished()))
print('')

galo.newTable(3)

--[ Check linha n=2 ]--
galo.play(3,1,"x")
galo.play(3,2,"x")
galo.play(3,3,"x")

print(galo.printTab())

print('  ' .. tostring(galo.finished()))
print('')

galo.newTable(3)

--[ Check coluna n=0 ]--
galo.play(1,1,"x")
galo.play(2,1,"x")
galo.play(3,1,"x")

print(galo.printTab())

print('  ' .. tostring(galo.finished()))
print('')

galo.newTable(3)

--[ Check coluna n=1 ]--
galo.play(1,2,"x")
galo.play(2,2,"x")
galo.play(3,2,"x")

print(galo.printTab())

print('  ' .. tostring(galo.finished()))
print('')
]]--
galo.newTable(3)

--[ Check coluna n=2 ]--
print(galo.play(1,3,"x"))
print(galo.play(0,0,"x"))
print(galo.play(1,3,"o"))
print(galo.play(2,2,"x"))
print(galo.play(2,2,"o"))
print(galo.play(3,1,"x"))
print(galo.play(1,1,"o"))
print(galo.play(3,3,"x"))
print(galo.play(3,2,"o"))
print(galo.play(2,3,"x"))
print(galo.play(1,2,"o"))



print(galo.printTab())

print('  ' .. tostring(galo.finished()))

galo.newTable(3)