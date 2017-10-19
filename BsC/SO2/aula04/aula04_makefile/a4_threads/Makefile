# regras para o make


paralelo: classes/Paralelo.class

classes/Paralelo.class: src/Paralelo.java
	javac -d classes src/Paralelo.java

runparalelo:
	java -classpath classes Paralelo



# ####################################
all: paralelo client1 server1 server2


client1:	classes/so2/EchoClient.class

classes/so2/EchoClient.class: src/so2/EchoClient.java
	javac -d classes -classpath classes src/so2/EchoClient.java

server1:	classes/so2/EchoServer.class
server2:	classes/so2/EchoServerConcorrente.class

classes/so2/EchoServer.class: src/so2/EchoServer.java
	javac -d classes -classpath classes src/so2/EchoServer.java
classes/so2/EchoServerConcorrente.class: src/so2/EchoServerConcorrente.java
	javac -d classes -classpath classes src/so2/EchoServerConcorrente.java


runechoclient: client1
	java -classpath classes so2.EchoClient localhost 9001 exemplo-1-2-ok


runechoserver1: server1
	java -classpath classes so2.EchoServer 9001
runechoserver2: server2
	java -classpath classes so2.EchoServerConcorrente 9001



# eliminar temporarios e .class
clean:
	find . -name \*~ | xargs rm -f
	find . -name \*.class | xargs rm -f
	rm -rf classes/so2
