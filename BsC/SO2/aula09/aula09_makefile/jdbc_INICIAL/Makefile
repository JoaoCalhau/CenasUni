
all: classes/AcessoAUmaBD.class

runjdbc: classes/AcessoAUmaBD.class
	echo " **** falta adicionar o driver PG a classpath **** "
	java -classpath classes;lib/postgresql.jar AcessoAUmaBD $(A0) $(A1) $(A2) $(A3)

classes/AcessoAUmaBD.class: src/AcessoAUmaBD.java
	javac -classpath .:classes -d classes src/AcessoAUmaBD.java

clean: 
	rm -fr *~ src/*~ classes/*
