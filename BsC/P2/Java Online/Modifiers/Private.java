public class Private {
	
	private String format;
	public String getFormat(){
		return this.format;
	}
	//getFormat � utilizado para ir buscar o format fora desta class, visto que a variavel format � privada (s� pode ser vista dentro desta classe
	
	public void setFormat(String format){
		this.format = format;
	}
	//setFormat � a unica maneira de mudar a variavel format (privada) fora desta classe
}
