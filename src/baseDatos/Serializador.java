package baseDatos;

import gestorAplicacion.Configuracion;
import gestorAplicacion.tablero.Columna;
import gestorAplicacion.tablero.Tablero;
import gestorAplicacion.usuarios.Desarrollador;

import java.io.*;
import java.util.List;

public class Serializador {
    private final static String nombreDirectorioBase = "src\\baseDatos\\temp";
    private final static String nombreArchivotablero = "tablero";
    private final static String nombreArchivoConfiguracion = "configuracion";
    private final static String nombreArchivoDesarrolladores = "desarrolladores";

    private static String calcularRutaCompleta(String nombreArchivo) {
        return nombreDirectorioBase + "\\" + nombreArchivo;
    }

    private static File obtenerArchivo(String nombreArchivo) {
        return new File(calcularRutaCompleta(nombreArchivo));
    }

    public static void serializar(List<Desarrollador> desarrolladores) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream oos;
        PrintWriter pw;

        File archivo = obtenerArchivo(nombreArchivoDesarrolladores);

        if (archivo.exists()) {
            try {
                pw = new PrintWriter(archivo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            fos = new FileOutputStream(archivo.getAbsolutePath());
            oos = new ObjectOutputStream(fos);

            oos.writeObject(desarrolladores);

            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void serializar(Configuracion configuracion) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream oos;

        PrintWriter pw;

        File archivoConfiguracion = obtenerArchivo(nombreArchivoConfiguracion);

        if (archivoConfiguracion.exists()) {
            try {
                pw = new PrintWriter(archivoConfiguracion);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            fos = new FileOutputStream(archivoConfiguracion.getAbsolutePath());
            oos = new ObjectOutputStream(fos);
            oos.writeObject(configuracion);

            oos.flush();
            fos.flush();

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void serializar(Tablero tablero) throws IOException {

        FileOutputStream fos;
        ObjectOutputStream oos;

        PrintWriter pw;

        File archivoTablero = obtenerArchivo(nombreArchivotablero);

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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
