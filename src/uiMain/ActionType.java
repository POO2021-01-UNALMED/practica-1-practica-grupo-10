package uiMain;

public enum ActionType {
    MOSTRAR_CONFIGURACION(0),
    CREAR_TABLERO(10),
    MOSTRAR_TABLERO(11),
    CREAR_DESARROLLADOR(40),
    MOSTRAR_DESARROLLADORES(41),
    CREAR_COLUMNA(20),
    CREAR_TARJETA(30),
    VER_TARJETAS(31),
    VER_TARJETA_POR_ID(32),
    MOVER_TARJETA(33),
    SALIR(99);

    private final int value;

    private ActionType(int value){
        this.value = value;
    }

    public static ActionType fromInt(int value){
        ActionType[] actions = ActionType.values();
        for (ActionType action: actions ) {
            if(action.value == value){
                return action;
            }
        }

        return SALIR;
    }

    public int getValue(){
        return value;
    }
}
