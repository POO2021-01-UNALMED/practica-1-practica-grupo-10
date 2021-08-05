package baseDatos;

import gestorAplicacion.usuarios.Desarrollador;

import java.io.*;
import java.util.List;

public class RepositorioDesarrollador {

    public void guardar(Desarrollador desarrollador) throws IOException {
        List<Desarrollador> desarrolladores = leerTodos();
        desarrolladores.add(desarrollador);
        Serializador.serializar(desarrolladores);
    }

    public List<Desarrollador> leerTodos() {
        return Deserializador.deserializarDesarrolladores();
    }
}