package baseDatos;

import gestorAplicacion.usuarios.Administrador;

import java.io.*;

public class RepositorioAdministrador {

    private final static String rutaDirectorio = "src\\baseDatos\\temp";
    private final static String archivoAdministrador = "administrador";
    private final static String rutaCompleta = rutaDirectorio + "\\" + archivoAdministrador;

    private static final File archivo = new File(rutaCompleta);

    public static void guardar(Administrador admin) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream oos;

        PrintWriter pw;

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
            oos.writeObject(admin);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Administrador leer() {
        FileInputStream fis;
        ObjectInputStream ois;
        Administrador admin = null;

        if (!archivo.exists()) {
            return null;
        }

        if (archivo.getAbsolutePath().contains(archivoAdministrador)) {
            try {
                fis = new FileInputStream(archivo.getAbsolutePath());
                ois = new ObjectInputStream(fis);
                admin = (Administrador) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return admin;
    }
}