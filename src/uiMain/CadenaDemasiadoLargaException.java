package uiMain;

public class CadenaDemasiadoLargaException extends  ErrorAplicacion{
    private final int maxLenth = 30;
    private int tamano;

    public CadenaDemasiadoLargaException(int tamano){
        super();
        this.tamano = tamano;
    }
}
