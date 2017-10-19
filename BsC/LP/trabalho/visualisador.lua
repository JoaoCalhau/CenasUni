local socket = require("socket")

local port = 9000
local addr = "*"
local backlog = 10

tcp = socket.tcp()
tcp:bind(addr, port)
tcp:listen(backlog)

io.write("Awaiting player...\n")
player1 = tcp:accept()
io.write("Player 1 connected\n")
io.write("Awaiting player...\n")
player2 = tcp:accept()
io.write("Player 2 connected\n")

while 1 do
	recv = player1:receive('*l')

	print(recv)

	io.write("Insira a posicao 'x' onde quer jogar\n")
	toSend = io.read()
	io.write("Insira a posicao 'y' onde quer jogar\n")
	toSend = toSend .. "\\" .. io.read()
	player1:send(toSend .. "\n")
end