package so2;

public class PedidoDeConsulta extends Pedido{
    
    private String matricula;
 
    public PedidoDeConsulta(String matricula) {
        this.matricula= matricula;
    }
 
    public String getMatricula() {
        return matricula;
    }
}
