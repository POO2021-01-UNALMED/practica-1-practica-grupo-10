package gestorAplicacion.tablero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Columna implements Serializable {
    private static final long serialVersionUID = 1;

    private int id;
    private String titulo;
    private Tablero tablero;
    private List<Tarjeta> tarjetas = new ArrayList<>();
    private List<Columna> fuentesValidas = new ArrayList<>();

    public Columna() {
    }

    public Columna(Tablero tablero, String titulo, List<Columna> fuentesValidas, int id) {
        this.tablero = tablero;
        this.titulo = titulo;
        this.fuentesValidas = fuentesValidas;
        this.id = id;
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

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public List<Columna> getFuentesValidas() {
        return fuentesValidas;
    }

    public void setFuentesValidas(List<Columna> fuentesValidas) {
        this.fuentesValidas = fuentesValidas;
    }

    public void agregarFuenteValida(Columna columna) {
        fuentesValidas.add(columna);
    }

    public void removerFuenteValida(Columna columna) {
        fuentesValidas.remove(columna);
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

    public int contarTarjetas() {
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
        String cadena = "id: " + getId() + " Titulo Columna: " + titulo + "\n";
        for (Tarjeta t : tarjetas) {
            cadena += "\t\t\tid: " + t.getId() + "\t titulo: " + t.getTitulo() +
                    " encargado: (" + t.getEncargado().getId() + ") " +
                    t.getEncargado().getNombre() + "\n";
        }
        return cadena;
    }
}
