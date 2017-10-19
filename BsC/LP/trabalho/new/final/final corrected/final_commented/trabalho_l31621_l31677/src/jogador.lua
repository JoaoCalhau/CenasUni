local socket = require("socket")
local chunk = assert(loadfile("JogoDoGalo.lua"))
chunk()

local tic = TicTacToe()
local me
local other
local host = "localhost"
local port = 9000
local started = false
local first = true
local size = 0
local finished = false

--[ Visto o lua nao ter um split nativo, tivemos de criar um ]--
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

while not finished do
  io.write("(Once the game starts you can only play the game...)\n")
  io.write("What do you wish to do?\n")
	toSend = io.read()

  rec = toSend:split(" ")

  --[ Comando comeca, para comecar o jogo ]--
  if rec[1] == "comeca" then
    if size ~= 0 then
      tcp:send("comeca\n")
      tic.newTable(size)
      io.write("Board created!\n")
      recv = tcp:receive('*l')
      rec = recv:split(" ")
      if rec[2] == "x" then
        me = "x"
        other = "o"
      else
        me = "o"
        other = "x"
      end
    started = true
    else
      io.write("No board size defined...\n")
    end

    if started then
      finished = tic.finished()
      recv = ""

      while not finished do
        recv = tcp:receive('*l')
        rec = recv:split(" ")

        --[ Se receber um pedido de jogada do servidor ]--
        if rec[1] == "joga" then
          --[ A primeira jogada (que e do jogador x) ]--
          if first and me == "x" then
            io.write(tic.printTab() .. "\n")
            io.write("Where to play? (jogo i/j) ")
            toSend = io.read()
            send = toSend:split(" ")
            jogada = send[2]:split("/")
            ok = tic.play(jogada[1], jogada[2], me)
            while ok ~= "ok" do
              io.write(ok .. "\n")
              toSend = io.read()
              send = toSend:split(" ")
              jogada = send[2]:split("/")
              ok = tic.play(jogada[1], jogada[2], me)
            end

            io.write(tic.printTab() .. "\n")
            first = false

            tcp:send("jogo " .. send[2] .. "\n")
          else
            io.write(tic.printTab() .. "\n")
            recv = tcp:receive('*l')
            rec = recv:split(" ")

            --[ Se o outro jogador tiver desistido ]--
            if rec[1] == "desisto" then
              io.write("Your opponent gave up! You win!\n")
              finished = true
              break
            --[ se o outro jogador afirmar que ganhou ]--
            elseif rec[1] == "ganhei" then
              io.write("Your opponent won! You Lose..\n")
              finished = true
              break
            --[ Se o outro jogador afirmar que ha empate ]--
            elseif rec[1] == "empatamos" then
              io.write("It's a tie..\n")
              finished = true
              break
            --[ Jogada normal ]--
            else
              jogada = rec[2]:split("/")
              tic.play(jogada[1], jogada[2], other)

              io.write(tic.printTab() .. "\n")

              io.write("Where to play? (jogo i/j) ")
              toSend = io.read()
              send = toSend:split(" ")
              jogada = send[2]:split("/")
              ok = tic.play(jogada[1], jogada[2], me)
              while ok ~= "ok" do
                io.write(ok .. "\n")
                toSend = io.read()
                send = toSend:split(" ")
                jogada = send[2]:split("/")
                ok = tic.play(jogada[1], jogada[2], me)
              end

              io.write(tic.printTab() .. "\n")

              finished = tic.finished()
              empate = tic.empate()
              
              --[ Em caso de o jogador ter ganho ]--
              if finished then
                io.write("You win! Good Job!\n")
                tcp:send("ganhei\n")
                break
              --[ Em caso de o jogo empatar ]--
              elseif empate then
                io.write("It's a Tie...\n")
                tcp:send("empatamos\n")
                finished = true
                break
              --[ Jogada normal ]--
              else
                tcp:send("jogo " .. send[2] .. "\n")
              end
            end
          end 
        --[ Em caso do oponente ter desistido ]--
        elseif rec[1] == "desisto" then
          io.write("Your opponent gave up! You win!\n")
          finished = true
          break
        --[ Em caso de oponente ter ganho ]--
        elseif rec[1] == "ganhei" then
          io.write("Your opponent won! You Lose..\n")
          finished = true
          break
        --[ Em caso de empate ]--
        elseif rec[1] == "empatamos" then
          io.write("It's a tie..")
          finished = true
          break
        end
      end
    else
      io.write("Board not created yet...\n")
    end
  
  --[ comando tamanho ]--
  elseif rec[1] == "tamanho" then
    tcp:send(rec[1] .. "\n")
    recv = tcp:receive()
    size = recv
    io.write("Board size is now " .. size .. "\n")

  --[ comando nome ]--  
  elseif rec[1] == "nome" then
    tcp:send(rec[1] .. " " .. rec[2] .. "\n")
    io.write("Accepted name: " .. rec[2] .. "\n")
  else
    io.write("Unrecognized command\n")
  end
end

tcp:close()

io.write("Goodbye!\n")