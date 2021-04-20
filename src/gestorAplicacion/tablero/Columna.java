package gestorAplicacion.tablero;

import java.io.Serializable;

public class Columna implements Serializable {
    private static final long serialVersionUID = 1;

    private String titulo;
    private Tablero tablero;

    public Columna() {
    }

    public Columna(Tablero tablero, String titulo) {
        this.tablero = tablero;
        this.titulo = titulo;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Tablero getTablero() {
        return tablero;
    }

    @Override
    public String toString() {
        return "Columna: " + titulo + "\n";
    }
}
