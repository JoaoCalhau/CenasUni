all: or client server

or: classes/so2/rmi/PalavrasImpl.class

classes/so2/rmi/Palavras.class: src/so2/rmi/Palavras.java
	javac -d classes src/so2/rmi/Palavras.java
classes/so2/rmi/PalavrasImpl.class: src/so2/rmi/PalavrasImpl.java classes/so2/rmi/Palavras.class
	javac -d classes -classpath classes src/so2/rmi/PalavrasImpl.java

client: classes/so2/rmi/PalavrasClient.class 
classes/so2/rmi/PalavrasClient.class: src/so2/rmi/PalavrasClient.java classes/so2/rmi/Palavras.class
	javac -d classes -classpath classes src/so2/rmi/PalavrasClient.java

server: classes/so2/rmi/PalavrasServer.class 
classes/so2/rmi/PalavrasServer.class: src/so2/rmi/PalavrasServer.java or
	javac -d classes -classpath classes src/so2/rmi/PalavrasServer.java


# #########################################

# operacao antiga, para criar stubs estaticamente
#stubs:
#	CLASSPATH=classes:. rmic -vcompat -d classes so2.rmi.PalavrasImpl


# activar o servico de nomes:
reg:
	 rmiregistry -J-classpath -Jclasses:. 9000


# executar o servidor
rs:
	java -classpath classes so2.rmi.PalavrasServer 9000


# executar o cliente
rc:
	java -classpath classes so2.rmi.PalavrasClient localhost 9000 "Hello, my name is..."



clean:
	rm -rf classes/* *~ src/*~ src/so2/*~ src/so2/rmi/*~
