package baseDatos;

import gestorAplicacion.tablero.Columna;
import gestorAplicacion.tablero.Tablero;

import java.io.*;
import java.util.List;

public class RepositorioColumna {

    public void agregar(Columna columna) throws IOException {
        List<Columna> columnas = Deserializador.deserializarColumnas();
        columnas.add(columna);
        Serializador.serializar(columnas);
    }

    public void agregarLista(List<Columna> columnas) throws IOException {
        Serializador.serializar(columnas);
    }
}
