local socket = require("socket")

local host = "localhost"
local port = 9000

while 1 do

	tcp = socket.connect(host, port)

	print("Connected")

	recv = tcp:receive('*l')
	print(recv)

	toSend = io.read()
	tcp:send(toSend .. "\n")

	recv = tcp:receive()
	print("Received back from server: " .. recv)

	tcp:shutdown()

	print("")
end