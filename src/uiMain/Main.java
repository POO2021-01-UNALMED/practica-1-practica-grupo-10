package uiMain;

import baseDatos.RepositorioAdministrador;
import gestorAplicacion.usuarios.Administrador;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int opcion = 0;

        do {
            System.out.println("Menú principal\n");
            System.out.println("1 Crear administrador.");
            System.out.println("2 Mostrar administrador.");
            System.out.println("9 Salir.");
            System.out.print("\nEcoja una opcion: ");

            opcion = (int) sc.nextInt();

            switch (opcion) {
                case 1:
                    crearAdministrador();
                    break;
                case 2:
                    mostrarAdministrador();
                    break;
                case 9:
                    break;
            }
        } while (opcion != 9);

        System.exit(0);
    }

    public static void mostrarAdministrador() {
        Administrador admin = RepositorioAdministrador.leer();
        if (admin == null) {
            System.out.println("No se encontró el administrador");
        }

        System.out.println(admin);
    }

    public static void crearAdministrador() throws IOException {
        System.out.println("Creando un nuevo administrador");
        System.out.print("Indique el nombre del administrador: ");
        String nombre = sc.next();
        System.out.print("Indique el correo del administrador: ");
        String correo = sc.next();

        Administrador admin = new Administrador(nombre, correo);
        RepositorioAdministrador.guardar(admin);

        if (admin == null) {
            System.out.println("No se encontró el administrador");
        }

        System.out.println(admin);
    }
}
