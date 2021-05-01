package gestorAplicacion.tablero;

import java.io.Serializable;

import gestorAplicacion.usuarios.*;

public class Tarjeta implements Serializable {
    private static final long serialVersionUID = 1;

    private int id;
    private String titulo;
    private Columna columna;
    private String descripcion;

    public Tarjeta() {
    }

    public Tarjeta(Columna columna, String titulo, String descripcion, int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\t\tTarjeta: \n"
                + "\t\t\tId: " + id
                + "\t\t\tTitulo: " + titulo
                + "\t\t\tDescripcio: " + descripcion;
    }

}
