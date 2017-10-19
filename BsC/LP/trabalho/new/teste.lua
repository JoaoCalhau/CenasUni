local chunk = assert(loadfile("JogoDoGalo.lua"))
chunk()

local tic = TicTacToe()

function string:split( inSplitPattern, outResults )
  if not outResults then
    outResults = { }
  end
  local theStart = 1
  local theSplitStart, theSplitEnd = string.find( self, inSplitPattern, theStart )
  while theSplitStart do
    table.insert( outResults, string.sub( self, theStart, theSplitStart-1 ) )
    theStart = theSplitEnd + 1
    theSplitStart, theSplitEnd = string.find( self, inSplitPattern, theStart )
  end
  table.insert( outResults, string.sub( self, theStart ) )
  return outResults
end

--[[

local current = "x"

while 1 do
	io.write(tic.playBot(current) .. "\n")
	if current == "x" then 
		current = "o"
	else
		current = "x"
	end
end

math.randomseed( tonumber(tostring(os.time()):reverse():sub(1,6)) )
 r1 = math.random(3)
 r2 = math.random(3)
 io.write("(" .. r1 .. ", " .. r2 .. ")")


x = 1
y = 2
s = "jogo " .. x .. "/" .. y
io.write(s .. "\n")
ss = s:split(" ")
io.write(ss[1] .. "\n")
io.write(ss[2] .. "\n")
sss = ss[2]:split("/")
io.write(sss[1] .. "\n")
io.write(sss[2] .. "\n")


tic.newTable(3)

tic.play("1", "1", "x")
tic.play("1", "2", "o")
tic.play("1", "3", "x")
tic.play("2", "3", "o")
tic.play("2", "1", "x")
tic.play("3", "1", "o")
tic.play("2", "2", "x")
tic.play("3", "3", "o")
tic.play("3", "2", "x")

io.write(tic.printTab() .. "\n")

print(tic.finished())
print(tic.empate())
io.write("\n")


tic.newTable(3)

tic.tab[1][3] = "o"
tic.tab[2][2] = "o"
tic.tab[3][1] = "o"
tic.tab[1][1] = "x"
tic.tab[1][2] = "x"
tic.tab[3][3] = "x"

print(tic.printTab())
print(tic.finished())
print(tic.empate())

]]--

--[[

tab = {}

num = 1

for i = 1, 3 do
  tab[i] = {}
  for j = 1, 3 do
    tab[i][j] = tostring(num)
    num = num + 1
  end
end


tab[1][3] = "o"
tab[2][2] = "o"
tab[3][1] = "o"

for i = 1, 3 do
  print(tab[i][i])
end
print("")

for i=1, 3 do
  print(tab[3-i+1][i])
end

]]--

--[[
toSend = "jogo 1/1"
send = toSend:split(" ")
jogada = send[2]:split("/")

x = tonumber(jogada[1])
y = tonumber(jogada[2])
oi = tic.play(x, y, "x")

io.write(tic.printTab() .. "\n")

io.write(oi .. "\n")
]]--

s = "joga 1/2"
ss = s:split(" ")
print(ss[1])
print(ss[2])

sss = {}
s:split(" ", sss)
print(sss[1])
print(sss[2])