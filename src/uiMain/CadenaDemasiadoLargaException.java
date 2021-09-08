package uiMain;

public class CadenaDemasiadoLargaException extends  ErrorAplicacion{
    private final int maxLenth = 30;
    private int tamanoMaximo;

    public CadenaDemasiadoLargaException(int tamanoMaximo){
        super();
        this.tamanoMaximo = tamanoMaximo;
    }

    public int tamanoMaximo(){
        return tamanoMaximo;
    }
}
