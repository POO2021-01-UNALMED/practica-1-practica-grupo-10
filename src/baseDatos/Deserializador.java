package baseDatos;

import gestorAplicacion.Configuracion;
import gestorAplicacion.tablero.Columna;
import gestorAplicacion.tablero.Tablero;
import gestorAplicacion.usuarios.Desarrollador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Deserializador {
    private final static String nombreDirectorioBase = "src\\baseDatos\\temp";
    private final static String nombreArchivoTablero = "tablero";
    private final static String nombreArchivoColumnas = "columnas";
    private final static String nombreArchivoConfiguracion = "configuracion";
    private final static String nombreArchivoDesarrolladores = "desarrolladores";

    private static String calcularRutaCompleta(String nombreArchivo) {
        return nombreDirectorioBase + "\\" + nombreArchivo;
    }

    private static File obtenerArchivo(String nombreArchivo) {
        File directory = new File(String.valueOf(nombreDirectorioBase));
        if (!directory.exists()) {
            directory.mkdir();
        }
        return new File(calcularRutaCompleta(nombreArchivo));
    }

    public static Tablero deserializarTablero() {
        FileInputStream fis;
        ObjectInputStream ois;
        Tablero tablero = null;

        File archivoTablero = obtenerArchivo(nombreArchivoTablero);

        if (!archivoTablero.exists()) {
            return null;
        }

        if (archivoTablero.getAbsolutePath().contains(nombreArchivoTablero)) {
            try {
                fis = new FileInputStream(archivoTablero.getAbsolutePath());
                ois = new ObjectInputStream(fis);
                tablero = (Tablero) ois.readObject();

                File archivoColumnas = obtenerArchivo(nombreArchivoColumnas);
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

    public static Configuracion deserializarConfiguracion() {
        FileInputStream fis;
        ObjectInputStream ois;
        Configuracion configuracion = null;

        File archivoConfiguracion = obtenerArchivo(nombreArchivoConfiguracion);

        if (!archivoConfiguracion.exists()) {
            return null;
        }

        if (archivoConfiguracion.getAbsolutePath().contains(nombreArchivoConfiguracion)) {
            try {
                fis = new FileInputStream(archivoConfiguracion.getAbsolutePath());
                ois = new ObjectInputStream(fis);

                configuracion = (Configuracion) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return configuracion;
    }

    public static List<Columna> deserializarColumnas() {
        FileInputStream fis;
        ObjectInputStream ois;
        List<Columna> columnas = null;

        File archivoColumnas = obtenerArchivo(nombreArchivoColumnas);

        if (!archivoColumnas.exists()) {
            return new ArrayList<>();
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

        if (columnas == null)
            columnas = new ArrayList<>();

        return columnas;
    }

    public static List<Desarrollador> deserializarDesarrolladores() {
        FileInputStream fis;
        ObjectInputStream ois;
        List<Desarrollador> desarrolladores = null;

        File archivoDesarrolladores = obtenerArchivo(nombreArchivoDesarrolladores);

        if (!archivoDesarrolladores.exists()) {
            return new ArrayList<>();
        }

        if (archivoDesarrolladores.getAbsolutePath().contains(nombreArchivoDesarrolladores)) {
            try {
                fis = new FileInputStream(archivoDesarrolladores.getAbsolutePath());
                ois = new ObjectInputStream(fis);

                desarrolladores = (List<Desarrollador>) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (desarrolladores == null)
            desarrolladores = new ArrayList<>();

        return desarrolladores;
    }

}
