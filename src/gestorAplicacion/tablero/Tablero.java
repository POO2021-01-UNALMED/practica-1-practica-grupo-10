package gestorAplicacion.tablero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tablero implements Serializable {
    private static final long serialVersionUID = 1;

    private String titulo;
    private List<Columna> columnas = new ArrayList<>();

    public Tablero() {
    }

    public Tablero(String titulo) {
        this.titulo = titulo;
        Columna pendiente = new Columna(this, "Pendiente");
        columnas.add(pendiente);
        Columna hecho = new Columna(this, "Hecho");
        columnas.add(hecho);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void agregarColumna(Columna columna) {
        agregarPenultimaColumna(columna);
    }

    private void agregarPenultimaColumna(Columna columna) {
        Columna ultima = columnas.get(columnas.size() - 1);
        columnas.set(columnas.size() - 1, columna);
        columnas.add(ultima);
    }

    public void setColumnas(List<Columna> columnas) {
        this.columnas = columnas;
    }

    public List<Columna> getColumnas() {
        return columnas;
    }

    public int ContarTarjetas(){
        int numeroTarjetas = 0;
        for (Columna c: columnas) {
            numeroTarjetas += c.contarTarjetas();
        }

        return  numeroTarjetas;
    }

    public Columna encontrarColumna(int indice){
        if( indice < 0 || indice > columnas.size() - 1)
            return  null;

        return  columnas.get(indice);
    }

    public String toString() {
        String cadena = "Titulo: " + titulo + "\n";
        for (int i = 0; i < columnas.size(); i++) {
            Columna c = columnas.get(i);
            cadena += "\t" + i + " " + c;
        }
        return cadena;
    }
}
