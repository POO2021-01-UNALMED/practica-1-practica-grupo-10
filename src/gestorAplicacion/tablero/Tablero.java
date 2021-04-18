package gestorAplicacion.tablero;

import baseDatos.RepositorioTablero;

import java.io.Serializable;

public class Tablero implements Serializable {
    private String name;

    public Tablero(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
