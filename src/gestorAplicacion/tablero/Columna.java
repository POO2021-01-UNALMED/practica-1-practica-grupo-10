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

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public Tarjeta buscarTarjeta(int id) {
        for (Tarjeta t : tarjetas) {
            if (t.getId() == id)
                return t;
        }

        return null;
    }

    public int contarTarjetas(){
        return tarjetas.size();
    }

    public void quitarTarjeta(Tarjeta tarjeta) {
        if (!tarjetas.contains(tarjeta)) {
            System.out.println("Esta intentando remover una tarjeta que no está en la columna indicada.");
            return;
        }

        tarjetas.remove(tarjeta);
    }

    @Override
    public String toString() {
        String cadena = "Columna: " + titulo + "\n";
        for (Tarjeta t : tarjetas) {
            cadena += t.toString() + "\n";
        }
        return cadena;
    }
}
