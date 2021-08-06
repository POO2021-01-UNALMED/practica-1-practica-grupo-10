package gestorAplicacion;

import java.io.Serializable;

public class Configuracion implements Serializable {
    private static final long serialVersionUID = 1;

    private int maxTarjetasPorUsuario = 5;
    private int maxTarjetasPorColumna = 15;

    public Configuracion() {
    }

    public Configuracion(int maxTarjetasPorUsuario, int maxTarjetasPorColumna) {
        this.maxTarjetasPorUsuario = maxTarjetasPorUsuario;
        this.maxTarjetasPorColumna = maxTarjetasPorColumna;
    }

    public int getMaxTarjetasPorUsuario() {
        return maxTarjetasPorUsuario;
    }

    public void setMaxTarjetasPorUsuario(int maxTarjetasPorUsuario) {
        this.maxTarjetasPorUsuario = maxTarjetasPorUsuario;
    }

    public int getMaxTarjetasPorColumna() {
        return maxTarjetasPorColumna;
    }

    public void setMaxTarjetasPorColumna(int maxTarjetasPorColumna) {
        this.maxTarjetasPorColumna = maxTarjetasPorColumna;
    }

    @Override
    public String toString() {
        return "\tConfiguracion:\n" +
                "\t\tNúmero máximo de tarjetas por usuario: " + maxTarjetasPorUsuario + "\n" +
                "\t\tNúmero máximo de tarjetas por columna: " + maxTarjetasPorColumna + "\n";
    }
}
