local socket = require("socket")
local chunk = assert(loadfile("JogoDoGalo.lua"))
chunk()

local tic = TicTacToe()
local me
local other
local host = "localhost"
local port = 9000
local started = false
local finished = false
local first = true

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
tic.newTable(3)

while 1 do
  io.write("What do you wish to do?\n")
	toSend = io.read()

  rec = toSend:split(" ")

  --[ Comando comeca, para comecar o jogo ]--
  if rec[1] == "comeca" then
    if started then
      io.write("Can't start a new game...\n")
    else
      tcp:send(rec[1] .. "\n")
    end
    recv = tcp:receive()
    coisas = recv:split(" ")

    --[ Se for o player 1 ]--
    if coisas[1] == "Awaiting" then
      me = "x"
      other = "o"
      io.write(recv .. "\n")
      recv = tcp:receive()
      if recv == "Game starting!" then
        started = true
        io.write(recv .. "\n")
      end
    --[ Se for o player 2 ]--
    else
      me = "o"
      other = "x"
      started = true
      io.write(recv .. "\n")
    end

    --[ Ciclo de jogadas dos bots ]--
    while 1 do
      recv = ""
      --[ Se o jogador for o 'x' ]--
      if me == "x" then
        if first then
          jogada = tic.playBot("x")
          io.write(jogada .. "\n")
          io.write("You played in position (" .. jogada .. ")\n")
          io.write(tic.printTab() .. "\n")
          jg = jogada:split(",")
          send = "jogo " .. jg[1] .. "/" .. jg[2]
          tcp:send(send .. "\n")
          first = false
        else
          recv = tcp:receive()
          rec = recv:split(" ")
          if rec[1] == "jogo" then
            jogada = rec[2]:split("/")
            jg = tic.play(tonumber(jogada[1]), tonumber(jogada[2]), other)
            io.write("Opponent played in position (" .. jg .. ")\n")
            io.write(tic.printTab() .. "\n")
            jogada = tic.playBot("x")
            io.write("You played in position (" .. jogada .. ")\n")
            io.write(tic.printTab() .. "\n")
            jg = jogada:split(",")
            tcp:send("jogo " .. jg[1] .. "/" .. jg[2] .. "\n")
          else
              --[ doing nothing ]--
          end
        end
      --[ Se o jogador or  'o' ]--
      elseif me == "o" then
        recv = tcp:receive()
        rec = recv:split(" ")
        if rec[1] == "jogo" then
          jogada = rec[2]:split("/")
          jg = tic.play(tonumber(jogada[1]), tonumber(jogada[2]), other)
          io.write("Opponent played in position (" .. jg .. ")\n")
          io.write(tic.printTab() .. "\n")
          jogada = tic.playBot("x")
          io.write("You played in position (" .. jogada .. ")\n")
          io.write(tic.printTab() .. "\n")
          jg = jogada:split(",")
          tcp:send("jogo " .. jg[1] .. "/" .. jg[2] .. "\n")
        else
          --[ doing nothing ]--
        end
      else
        --[ doing nothing ]--
      end

      finished = tic.finished()

      if finished[1] then
        if finished[2] == "x" and me == "x" then
          io.write("You win!\n")
          tcp:send("ganhei\n")
          break
        elseif finished[2] == "o" and me == "o" then
          io.write("You Win!\n")
          tcp:send("ganhei\n")
          break
        elseif finished[2] == "x" and me  == "o" then
          io.write(recv .. "\n")
          break
        elseif finished[2] == "o" and me  == "x" then
          io.write(recv .. "\n")
          break
        elseif not finished[1] and me == "x" and tic.inserted() == 9 then
          tcp:send("empatamos\n")
        elseif not finished[1] and me == "x" and tic.inserted() == 9 then
          io.write(tcp:receive() .. "\n")
        else
          --[ doing nothing ]--
        end
      end
    end 

  elseif rec[1] == "tamanho" then
    tcp:send(rec[1] .. "\n")
    recv = tcp:receive()
    io.write(recv .. "\n")
  elseif rec[1] == "espera" then
    tcp:send(rec[1] .. "\n")
    recv = tcp:receive()
    io.write(recv .. "\n")
  elseif rec[1] == "nome" then
    tcp:send(rec[1] .. " " .. rec[2] .. "\n")
    io.write("Accepted name: " .. rec[2] .. "\n")
  else
    io.write("Unrecognized command\n")
  end

  if finished then
    break
  end

end

tcp:close()

io.write("Goodbye!\n")