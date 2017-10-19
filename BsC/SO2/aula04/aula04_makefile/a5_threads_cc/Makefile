# regras para o make



contas:	src/so2/Conta.java src/so2/ThreadsBancarias.java
	javac -classpath .:classes -d classes src/so2/ThreadsBancarias.java src/so2/Conta.java

runcontas:  contas
	java -classpath .:classes so2.ThreadsBancarias



# eliminar temporarios e .class
clean:
	find . -name \*~ | xargs rm -f
	find . -name \*.class | xargs rm -f
	rm -rf classes/so2
