package baseDatos;

import gestorAplicacion.Configuracion;
import gestorAplicacion.tablero.Tablero;
import gestorAplicacion.usuarios.Desarrollador;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

public class Serializador {
    private final static String nombreDirectorioBase = "src" + File.separator
            + File.separator + "baseDatos" + File.separator + "temp";
    private final static String nombreArchivotablero = "tablero";
    private final static String nombreArchivoConfiguracion = "configuracion";
    private final static String nombreArchivoDesarrolladores = "desarrolladores";

    private static String rutaConDirectorioBase(String nombreArchivo) {
        return nombreDirectorioBase + File.separator + nombreArchivo;
    }

    private static String calcularRutaAbsoluta(String archivo) {
        Path currentDirectoryPath = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath();
        return currentDirectoryPath.toString() + File.separator + archivo;
    }

    private static void createBaseDirectory() throws IOException {
        File srcFile = new File("src");
        boolean result = srcFile.mkdir();
        File baseDatosFile = new File("src" + File.separator + "baseDatos");
        result = baseDatosFile.mkdir();
        File tempFile = new File("src" + File.separator + "baseDatos" + File.separator + "temp");
        result = tempFile.mkdir();
    }

    private static File obtenerArchivo(String nombreArchivo) throws IOException {
        File directory = new File(calcularRutaAbsoluta(nombreDirectorioBase));
        if (!directory.exists()) {
            createBaseDirectory();
            boolean result = directory.mkdir();
            if (result == false) {
                System.out.println("El directorio no pudo ser creado");
            }
        }
        String rutaAbsoluta = calcularRutaAbsoluta(rutaConDirectorioBase(nombreArchivo));
        File archivo = new File(rutaAbsoluta);
        if (!archivo.exists()) {
            System.out.println(archivo.getAbsolutePath());
            archivo.createNewFile();
        }
        return archivo;
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
