package gestorAplicacion.tablero;

import java.io.Serializable;

import gestorAplicacion.usuarios.*;

public class Tarjeta implements Serializable {
    private static final long serialVersionUID = 1;

    private String titulo;
    private Columna columna;
    private String descripcion;

    public Tarjeta() {
    }

    public Tarjeta(Columna columna, String titulo, String descripcion) {
        this.titulo = titulo;
        this.columna = columna;
        this.descripcion = descripcion;

        this.columna.agregarTarjeta(this);
    }

    public Columna getColumna() {
        return columna;
    }

    public void setColumna(Columna columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "\tTarjeta: \n"
                + "\t\tTitulo: " + titulo
                + "\t\tDescripcio: " + descripcion;
    }

}
