local socket = require("socket")
local chunk = assert(loadfile("JogoDoGalo.lua"))
chunk()

local galo = TicTacToe()
local me = "x"
local other = "o"
local host = "localhost"
local port = 9000

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

tcp = socket.connect(host, port)
galo.newTable(3)

while 1 do
	print("Insira a posicao 'x' onde quer jogar")
	toSend = io.read()
	print("Insira a posicao 'y' onde quer jogar")
	toSend = toSend .. "\\" .. io.read()
	tcp:send(toSend .. "\n")
	jogada = toSend:split("\\")
	print(galo.play(tonumber(jogada[1]), tonumber(jogada[2]), me))
	recv = tcp:receive('*l')
	x, y = string.gmatch(recv, '([^\\]+)')
	jogada = recv:split("\\")

	print(galo.play(tonumber(jogada[1]), tonumber(jogada[2]), other))
	print(galo.printTab())

	if galo.finished() then
		print("Acabou bitch")
	end
end



