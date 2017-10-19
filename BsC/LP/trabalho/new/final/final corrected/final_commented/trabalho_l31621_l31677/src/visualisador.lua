local socket = require("socket")

local port = 9000
local addr = "*"
local backlog = 10
local p1 = "x"
local p2 = "o"
local pp1
local pp2
local turn = "x"
local started = false
local size = 3
local first = true
local doAgain = true


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

tcp = socket.tcp()
tcp:bind(addr, port)
tcp:listen(backlog)

--[ Ciclo principal de connecao ]--
--[ em caso de fim de jogo, volta aqui ]--
while doAgain do

	io.write("Awaiting player...\n")
	player1 = tcp:accept()
	io.write("Player 1 connected\n")
	io.write("Awaiting player...\n")
	player2 = tcp:accept()
	io.write("Player 2 connected\n")

	while 1 do
		--[ while para a fase inicial (ate o jogo comecar) ]--
		while 1 do

			--[ turno do primeiro jogador ]--
			if turn == "x" then
				recv = player1:receive('*l')
				rec = recv:split(" ")

				if rec[1] == "comeca" then
					player1:send("role x\n")
					turn = "o"
				elseif rec[1] == "tamanho" then
					player1:send(size .. "\n")
					turn = "o"
				elseif rec[1] == "nome" then
					recv = player1:receive('*l')
					turn = "o"
				end

			--[ turno do segundo jogador ]--
			elseif turn == "o" then
				recv = player2:receive('*l')
				rec = recv:split(" ")

				if rec[1] == "comeca" then
					player2:send("role o\n")
					turn = "x"
					break
				elseif rec[1] == "tamanho" then
					player2:send(size .. "\n")
					turn = "x"
				elseif rec[1] == "nome" then
					recv = player2:receive('*l')
					turn = "x"
				end
			end
		end

		first = true
		recv = ""
		--[ ciclo de jogadas ]--
		while 1 do

			--[ So acontece na primeira jogada ]--
			if first then
				player1:send("joga\n")
				recv = player1:receive('*l')

				player2:send("joga\n")
				player2:send(recv .. "\n")
				recv = player2:receive('*l')

				first = false
			end

			--[ So acontece na segunda jogada para a frente ]--
			if not first then
				player1:send("joga\n")
				player1:send(recv .. "\n")
				recv = player1:receive('*l')

				rec = recv:split(" ")

				--[ se o player 1 desistir ]--
				if rec[1] == "desisto" then
					player2:send("desisto\n")
					break
				--[ se o player 1 afirmar ter ganho ]--
				elseif rec[1] == "ganhei" then
					player2:send("ganhei\n")
					break
				--[ se o player 1 afirmar ter empatado ]--
				elseif rec[1] == "empatamos" then
					player2:send("empatamos\n")
					break
				--[ jogada normal ]--
				else
					player2:send("joga\n")
					player2:send(recv .. "\n")
					recv = player2:receive('*l')

					rec = recv:split(" ")

					--[ se o player 2 afirmar desistir ]--
					if rec[1] == "desisto" then
						player1:send("desisto\n")
						break
					--[ se o player 2 afirmar ganhei ]--
					elseif rec[1] == "ganhei" then
						player1:send("ganhei\n")
						break
					--[ se o player 2 afirmar empate ]--	
					elseif rec[1] == "empatamos" then
						player1:send("empatamos\n")
						break
					end
				end
			end
		end

		player1:close()
		player2:close()

		io.write("Would you like to close the server? (y/n) ")
		inquire = io.read()
		if inquire == "y" then
			doAgain = false
			io.write("Goodbye!\n")
			break
		else
			break
		end
	end
end

tcp:close()
