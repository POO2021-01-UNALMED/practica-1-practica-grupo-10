package uiMain;

public class MaximoTarjetasExcedidoException extends  ErrorAplicacion{
    private final int maxTarjetas = 10;
    private int numTarjetasIngresadas;

    public MaximoTarjetasExcedidoException(int numTarjetasIngresadas){
        super();
        this.numTarjetasIngresadas = numTarjetasIngresadas;
    }

    public int getNumTarjetasIngresadas(){
        return numTarjetasIngresadas;
    }

    public int getMaxTarjetas(){
        return maxTarjetas;
    }
}
