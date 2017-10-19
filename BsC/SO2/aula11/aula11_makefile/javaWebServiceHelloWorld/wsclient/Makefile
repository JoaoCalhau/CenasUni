# Makefile para o Cliente do Web Service
# #######################################
#

default:
	@echo " "
	@echo "Veja ANTES o conteudo deste Makefile."
	@echo "(Tambem e' comum usar-se o utilitario ant no desenvolvimento de servicos em Java)"
	@echo "---------------------"
	@echo "NOTA: o Web Service ja' deve estar disponivel!"
	@echo "Veja o conteudo dos ficheiros antes de avancar mais!"
	@echo " "


# gerar proxy a partir da service description
proxy:
	wsimport -d classes -s src http://localhost:7070/WebServiceSO2/myhello?WSDL

# compilar a classe cliente, depois de existir o Proxy
client:		src/MyWSClient.java
	javac -classpath classes -d classes src/MyWSClient.java

# executar o cliente no nosso Web Service
runclient:
	java -classpath classes MyWSClient


# eliminar tudo o que foi gerado automaticamente
clean:
	rm -rf classes/* src/so2 *~ src/*~


