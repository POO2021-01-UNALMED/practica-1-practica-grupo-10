package baseDatos;

import gestorAplicacion.tablero.Tablero;

import java.io.*;

public class RepositorioTablero {

    public void guardar(Tablero tablero) throws IOException {
        Serializador.serializar(tablero);
    }

    public Tablero leer() {
        return Deserializador.deserializarTablero();
    }
}
