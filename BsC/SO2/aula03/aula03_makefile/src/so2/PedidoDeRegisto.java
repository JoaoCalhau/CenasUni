package so2;

public class PedidoDeRegisto extends Pedido{
    
    public Registo reg;
 
    public PedidoDeRegisto(Registo r) {
        this.reg= r;
    }
 
    public Registo getRegisto() {
        return reg;
    }    
}
