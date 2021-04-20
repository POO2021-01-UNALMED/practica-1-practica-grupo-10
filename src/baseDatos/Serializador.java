package baseDatos;

import gestorAplicacion.tablero.Columna;
import gestorAplicacion.tablero.Tablero;

import java.io.*;
import java.util.List;

public class Serializador {
    private final static String nombreDirectorioBase = "src\\baseDatos\\temp";
    private final static String nombreArchivotablero = "tablero";
    private final static String nombreArchivoColumnas = "columnas";

    private final static String rutaCompletaTablero = nombreDirectorioBase + "\\" + nombreArchivotablero;
    private final static String rutaCompletaColumnas = nombreDirectorioBase + "\\" + nombreArchivoColumnas;

    private static final File archivoTablero = new File(rutaCompletaTablero);
    private static final File archivoColumnas = new File(rutaCompletaColumnas);

    public static void serializar(Tablero tablero) throws IOException {

        FileOutputStream fos;
        ObjectOutputStream oos;

        PrintWriter pw;

        if (archivoTablero.exists()) {
            try {
                pw = new PrintWriter(archivoTablero);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            fos = new FileOutputStream(archivoTablero.getAbsolutePath());
            oos = new ObjectOutputStream(fos);
            oos.writeObject(tablero);

            oos.flush();
            fos.flush();

            oos.close();
            fos.close();

            serializar(tablero.getColumnas());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void serializar(List<Columna> columnas) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream oos;

        PrintWriter pw;

        if (archivoColumnas.exists()) {
            try {
                pw = new PrintWriter(archivoColumnas);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            fos = new FileOutputStream(archivoColumnas.getAbsolutePath());
            oos = new ObjectOutputStream(fos);

            oos.writeObject(columnas);

            oos.flush();
            fos.flush();

            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
