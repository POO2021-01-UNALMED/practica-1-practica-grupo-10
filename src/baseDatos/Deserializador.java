package baseDatos;

import gestorAplicacion.tablero.Columna;
import gestorAplicacion.tablero.Tablero;

import java.io.*;
import java.util.List;

public class Deserializador {
    private final static String rutaDirectorio = "src\\baseDatos\\temp";
    private final static String nombreArchivoTablero = "tablero";
    private final static String nombreArchivoColumnas = "columnas";

    private final static String rutaCompletaTablero = rutaDirectorio + "\\" + nombreArchivoTablero;
    private final static String rutaCompletaColumnas = rutaDirectorio + "\\" + nombreArchivoColumnas;

    private static final File archivoTablero = new File(rutaCompletaTablero);
    private static final File archivoColumnas = new File(rutaCompletaColumnas);

    public static Tablero deserializarTablero() {
        FileInputStream fis;
        ObjectInputStream ois;
        Tablero tablero = null;

        if (!archivoTablero.exists()) {
            return null;
        }

        if (archivoTablero.getAbsolutePath().contains(nombreArchivoTablero)) {
            try {
                fis = new FileInputStream(archivoTablero.getAbsolutePath());
                ois = new ObjectInputStream(fis);
                tablero = (Tablero) ois.readObject();

                if (archivoColumnas.exists()) {
                    List<Columna> columnas = deserializarColumnas();
                    tablero.setColumnas(columnas);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return tablero;
    }

    public static List<Columna> deserializarColumnas() {
        FileInputStream fis;
        ObjectInputStream ois;
        List<Columna> columnas = null;

        if (!archivoColumnas.exists()) {
            return null;
        }

        if (archivoColumnas.getAbsolutePath().contains(nombreArchivoColumnas)) {
            try {
                fis = new FileInputStream(archivoColumnas.getAbsolutePath());
                ois = new ObjectInputStream(fis);

                columnas = (List<Columna>) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return columnas;
    }
}
