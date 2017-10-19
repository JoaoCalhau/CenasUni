CLASSES_DIR=classes
DEST_DIR=classes
SRC_DIR=src

CP=.:$(CLASSES_DIR)



# compilar a classe que implementa o servico
endpoint:	$(SRC_DIR)/so2/MyHelloImpl.java
	javac -d $(DEST_DIR) -classpath $(CP) $(SRC_DIR)/so2/MyHelloImpl.java

# gerar os artifacts: stubs e documento com a service interface em WSDL
stubs:
	wsgen -classpath $(CP) -d $(DEST_DIR) -s $(SRC_DIR) -wsdl so2.MyHelloImpl


# compilar a classe que publicara o servico
server:	$(SRC_DIR)/Main.java
	javac -d $(DEST_DIR) -classpath $(CP) $(SRC_DIR)/Main.java


# publicar o servico - lancar o web application server com o nosso web service
# (evita o deplyment num servlet container como o Tomcat)
# so' e' possivel com JEE ou JSE-1.6
publish:
	java -classpath $(CP) Main


# apagar temporarios, class files e outros gerados automaticamente
clean:
	rm -rf classes/* *~ src/*~ src/so2/jaxws
