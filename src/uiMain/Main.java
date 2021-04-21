package uiMain;

import baseDatos.RepositorioAdministrador;
import baseDatos.RepositorioTablero;
import gestorAplicacion.tablero.Columna;
import gestorAplicacion.tablero.Tablero;
import gestorAplicacion.tablero.Tarjeta;
import gestorAplicacion.usuarios.Administrador;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static RepositorioTablero repositorioTablero = new RepositorioTablero();
    static RepositorioAdministrador repositorioAdministrador = new RepositorioAdministrador();

    public static void main(String[] args) throws IOException {
        int opcion = 0;

        do {
            System.out.println("Menú principal\n");
            System.out.println("1 Crear administrador.");
            System.out.println("2 Mostrar administrador.");
            System.out.println("3 Crear tablero.");
            System.out.println("4 Mostrar tablero.");
            System.out.println("5 Crear columna.");
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
                case 3:
                    crearTablero();
                    break;
                case 4:
                    mostrarTablero();
                    break;
                case 5:
                    agregarColumna();
                    break;
                case 6:
                    agregarTarjeta();
                    break;
                case 9:
                    break;
            }
        } while (opcion != 9);

        System.exit(0);
    }

    private static void agregarTarjeta() throws IOException {
        System.out.println("Creando una nueva Tarjeta");
        System.out.print("Indique el titulo de la tarjeta: ");
        String titulo = sc.next();

        System.out.print("Indique la descripcion de la tarjeta: ");
        String descripcion = sc.next();

        Tablero tablero = repositorioTablero.leer();
        List<Columna> columnas = tablero.getColumnas();

        Columna primerColumna = columnas.get(0);

        Tarjeta tarjeta = new Tarjeta(primerColumna, titulo, descripcion);

        repositorioTablero.guardar(tablero);
    }

    private static void agregarColumna() throws IOException {
        System.out.println("Creando una nueva Columna");
        System.out.print("Indique el titulo de la columna: ");
        String nombre = sc.next();

        Tablero tablero = repositorioTablero.leer();

        Columna columna = new Columna(tablero, nombre);
        tablero.agregarColumna(columna);
        repositorioTablero.guardar(tablero);

        System.out.println("Columna creada correctamente\n");
    }

    private static void crearTablero() throws IOException {
        System.out.println("Creando un nuevo tablero");
        System.out.print("Indique el titulo del tablero: ");
        String nombre = sc.next();

        Tablero tablero = new Tablero(nombre);
        repositorioTablero.guardar(tablero);

        System.out.println("Tablero creado correctamente\n");
    }

    private static void mostrarTablero() {
        Tablero tablero = repositorioTablero.leer();
        if (tablero == null) {
            System.out.println("No se encontró el tablero");
            return;
        }

        System.out.println(tablero);
    }

    public static void mostrarAdministrador() {
        Administrador admin = repositorioAdministrador.leer();
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

        System.out.println("Administrador creado correctamente\n");
    }
}
