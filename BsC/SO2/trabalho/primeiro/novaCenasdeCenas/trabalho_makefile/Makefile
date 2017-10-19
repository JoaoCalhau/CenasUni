all: cenas client server

cenas:
	javac -d classes -cp lib/postgresql.jar -classpath classes src/so2/Pergunta.java
	javac -d classes -cp lib/postgresql.jar -classpath classes src/so2/Questionario.java
	javac -d classes -cp lib/postgresql.jar -classpath classes src/so2/OperacoesBD.java
	javac -d classes -cp lib/postgresql.jar -classpath classes src/so2/OperacoesBDImpl.java


client: cenas
	javac -d classes -classpath classes src/so2/MenuClient.java


server: cenas
	javac -d classes -cp lib/postgresql.jar -classpath classes src/so2/MenuServer.java

#Não é preciso porque o servidor cria um rmiregistry po porto fornecido por argumento
reg:
	rmiregistry -J-classpath -Jclasses:. $(A1)

rs: 
	java -cp lib/postgresql.jar -classpath classes so2.MenuServer $(A1) $(A2) $(A3) $(A4) $(A5)

rc: 
	java -classpath classes so2.MenuClient $(A1) $(A2)

clean:
	rm -rf classes/* *~ src/*~ src/so2/*~