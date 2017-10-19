all: client server


# insira aqui as regras para o make
build:
	javac -d classes src/so2/Echo*.java

client:	classes/so2/EchoClient.class


runclient: client
	java -classpath classes so2.EchoClient $(A1) $(A2) "$(A3)"

runserver: server
	java -classpath classes so2.EchoServer $(A1)


server:   # to do...





# eliminar temporarios e .class
clean:
	find . -name \*~ | xargs rm -f
	find . -name \*.class | xargs rm -f
