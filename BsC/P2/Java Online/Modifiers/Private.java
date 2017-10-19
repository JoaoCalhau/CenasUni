public class Private {
	
	private String format;
	public String getFormat(){
		return this.format;
	}
	//getFormat é utilizado para ir buscar o format fora desta class, visto que a variavel format é privada (só pode ser vista dentro desta classe
	
	public void setFormat(String format){
		this.format = format;
	}
	//setFormat é a unica maneira de mudar a variavel format (privada) fora desta classe
}
