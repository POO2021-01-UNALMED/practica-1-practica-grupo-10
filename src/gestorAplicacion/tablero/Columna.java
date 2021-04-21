package gestorAplicacion.tablero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Columna implements Serializable {
    private static final long serialVersionUID = 1;

    private String titulo;
    private Tablero tablero;
    private List<Tarjeta> tarjetas = new ArrayList<>();

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

    public void agregarTarjeta(Tarjeta tarjeta){
        tarjetas.add(tarjeta);
    }

    public List<Tarjeta> getTarjetas(){
        return tarjetas;
    }

    @Override
    public String toString() {
        String cadena = "Columna: " + titulo + "\n";
        for (Tarjeta t:  tarjetas) {
            cadena += t.toString() + "\n";
        }
        return cadena;
    }
}
