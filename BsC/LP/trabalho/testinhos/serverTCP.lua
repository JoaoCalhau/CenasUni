local socket = require("socket")

local port = 9000
local addr = "127.0.0.1"
local backlog = 10

print("Binding to host '" .. addr .. "' and port " .. port .. "...")
tcp = socket.tcp()
tcp:bind(addr, port)
tcp:listen(backlog)

while 1 do
	client = tcp:accept()
	print("Connection accepted")

	msg = "Send a message to be echoed"
	client:send(msg .. "\n")
	print("Message sent to client")

	recv = client:receive()
	print("Message received from client: " .. recv)

	client:send(recv .. "\n")
	print("Message sent again")

	print("")
	client:shutdown()
end

tcp.close()
