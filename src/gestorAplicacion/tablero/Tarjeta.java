package gestorAplicacion.tablero;

import gestorAplicacion.usuarios.Desarrollador;

import java.io.Serializable;

public class Tarjeta implements Serializable {
    private static final long serialVersionUID = 1;

    private int id;
    private String titulo;
    private Columna columna;
    private String descripcion;
    private Desarrollador encargado;

    public Tarjeta() {
    }

    public Tarjeta(Columna columna, String titulo, String descripcion, Desarrollador encargado, int id) {
        this.id = id;
        this.titulo = titulo;
        this.columna = columna;
        this.descripcion = descripcion;
        this.encargado = encargado;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Desarrollador getEncargado() {
        return encargado;
    }

    public void setEncargado(Desarrollador encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return "\t\tTarjeta: \n"
                + "\t\t\tId: " + id
                + "\t\t\tTitulo: " + titulo
                + "\t\t\tDescripcio: " + descripcion
                + "\t\t\tEncargado: " + encargado.getNombre() + " " + encargado.getCorreo();
    }
}
