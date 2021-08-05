package gestorAplicacion;

import java.io.Serializable;

public class Configuracion implements Serializable {
    private static final long serialVersionUID = 1;

    private int maxTarjetasPorUsuario = 3;
    private int maxTarjetasPorColumna = 5;
    private int maxTarjetasNoFinalizadas = 10;
    private int maxDiasEnColumna = 3;

    public Configuracion() {
    }

    public Configuracion(int maxTarjetasPorUsuario,
                         int maxTarjetasPorColumna,
                         int maxTarjetasNoFinalizadas,
                         int maxDiasEnColumna) {
        this.maxTarjetasPorUsuario = maxTarjetasPorUsuario;
        this.maxTarjetasPorColumna = maxTarjetasPorColumna;
        this.maxTarjetasNoFinalizadas = maxTarjetasNoFinalizadas;
        this.maxDiasEnColumna = maxDiasEnColumna;
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

    public int getMaxTarjetasNoFinalizadas() {
        return maxTarjetasNoFinalizadas;
    }

    public void setMaxTarjetasNoFinalizadas(int maxTarjetasNoFinalizadas) {
        this.maxTarjetasNoFinalizadas = maxTarjetasNoFinalizadas;
    }

    public int getMaxDiasEnColumna() {
        return maxDiasEnColumna;
    }

    public void setMaxDiasEnColumna(int maxDiasEnColumna) {
        this.maxDiasEnColumna = maxDiasEnColumna;
    }

    @Override
    public String toString() {
        return "\tConfiguracion:\n" +
                "\t\tmaxTarjetasPorUsuario=" + maxTarjetasPorUsuario + "\n" +
                "\t\tmaxTarjetasPorColumna=" + maxTarjetasPorColumna + "\n" +
                "\t\tmaxTarjetasNoFinalizadas=" + maxTarjetasNoFinalizadas + "\n" +
                "\t\tmaxDiasEnColumna=" + maxDiasEnColumna + "\n";
    }

}
