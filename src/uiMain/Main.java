package uiMain;

import baseDatos.RepositorioConfiguracion;
import baseDatos.RepositorioConfiguracionImp;
import baseDatos.RepositorioDesarrollador;
import baseDatos.RepositorioTablero;
import gestorAplicacion.Configuracion;
import gestorAplicacion.tablero.Columna;
import gestorAplicacion.tablero.Tablero;
import gestorAplicacion.tablero.Tarjeta;
import gestorAplicacion.usuarios.Administrador;
import gestorAplicacion.usuarios.Desarrollador;
import gestorAplicacion.usuarios.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    static RepositorioTablero repositorioTablero = new RepositorioTablero();
    static RepositorioConfiguracion repositorioConfiguracion = new RepositorioConfiguracionImp();
    static RepositorioDesarrollador repositorioDesarrollador = new RepositorioDesarrollador();

    public static void main(String[] args) throws IOException {
        ActionType action;

        Usuario usuario;
        do {
            usuario = iniciarSesion();
            if (usuario == null) {
                System.out.println("*******Problemas al iniciar sesion*******\n");
            }
        } while (usuario == null);

        do {
            mostrarMenuPrincipal();
            int intAction = Integer.parseInt(sc.nextLine());
            action = ActionType.fromInt(intAction);

            switch (action) {
                case MOSTRAR_TABLERO:
                    mostrarTablero();
                    break;
                case MOSTRAR_TABLERO_FILTRO_USER_ID:
                    mostrarTableroFiltroUserId();
                    break;
                case MOSTRAR_TABLERO_FILTRO_TITULO:
                    mostrarTableroFiltroTitulo();
                    break;
                case MOVER_TARJETA:
                    moverTarjeta(usuario);
                    break;
                case CREAR_TARJETA:
                    crearTarjeta(usuario);
                    break;
                case MOSTRAR_DESARROLLADORES:
                    mostrarDesarrolladores();
                    break;
                case CREAR_DESARROLLADOR:
                    crearDesarrollador(usuario);
                    break;
                case MOSTRAR_CONFIGURACION:
                    mostrarConfiguracion();
                    break;
                case MODIFICAR_CONFIGURACION:
                    modificarConfiguracion(usuario);
                    break;
                case CREAR_COLUMNA:
                    crearColumna(usuario);
                    break;
                case CREAR_TABLERO:
                    crearTablero(usuario);
                    break;
                case SALIR:
                    break;
            }
        } while (action != ActionType.SALIR);

        System.exit(0);
    }

    private static Usuario iniciarSesion() {
        System.out.println("Seleccione el usuario con el que desea iniciar sesion por id: ");
        var admin = Administrador.getInstance();
        System.out.println();
        System.out.println("-------------Administrador: requiere contraseña");
        System.out.println("\tid: 0\n\tnombre: " + admin.getNombre() + "\n\t" + "correo: " + admin.getCorreo());
        System.out.println();
        mostrarDesarrolladores();

        int devId = Integer.parseInt(sc.nextLine());
        if (devId == 0) {

            System.out.println("Ingrese la contraseña para ingresar como administrado: ");
            String password = sc.nextLine();
            if (!password.equals(admin.getPassword()))
                return null;
            return admin;
        }

        List<Desarrollador> desarrolladores = repositorioDesarrollador.leerTodos();
        var optionalDev = desarrolladores.stream().filter(d -> d.getId() == devId).findFirst();
        if (optionalDev.isEmpty()) {
            System.out.println("No existe un desarrollador con el id indicado");
            return null;
        }

        return optionalDev.get();
    }

    private static void mostrarDesarrolladores() {
        System.out.println("Desarrolladores: ");
        List<Desarrollador> desarrolladores = repositorioDesarrollador.leerTodos();
        for (Desarrollador dev : desarrolladores) {
            System.out.println(dev);
        }

        if (desarrolladores.size() == 0) {
            System.out.println("No hay desarrolladores, crea uno!!!");
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Menú principal\n");
        System.out.println(ActionType.MOSTRAR_TABLERO.getValue() + ". Mostrar tablero.");
        System.out.println(ActionType.MOSTRAR_TABLERO_FILTRO_USER_ID.getValue() + ". Mostrar tablero filtrando por id del usuario.");
        System.out.println(ActionType.MOSTRAR_TABLERO_FILTRO_TITULO.getValue() + ". Mostrar tablero filtrando por titulo.");
        System.out.println(ActionType.MOVER_TARJETA.getValue() + ". Mover tarjeta.");
        System.out.println(ActionType.MOSTRAR_DESARROLLADORES.getValue() + ". Mostrar desarrolladores.");
        System.out.println(ActionType.CREAR_TARJETA.getValue() + ". Crear tarjeta.");
        System.out.println(ActionType.MOSTRAR_CONFIGURACION.getValue() + ". Mostrar la configuracion.");
        System.out.println(ActionType.MODIFICAR_CONFIGURACION.getValue() + ". Modificar la configuracion.");
        System.out.println(ActionType.CREAR_TABLERO.getValue() + ". Crear tablero.");
        System.out.println(ActionType.CREAR_DESARROLLADOR.getValue() + ". Crear desarrollador.");
        System.out.println(ActionType.CREAR_COLUMNA.getValue() + ". Crear columna.");
        System.out.println(ActionType.SALIR.getValue() + ". Salir.");
        System.out.print("\nEcoja una opcion: ");
    }

    private static void moverTarjeta(Usuario usuario) throws IOException {
        System.out.println("Moviendo una Tarjeta");
        System.out.print("Indique el numero de la columna de la tarjeta que desea mover: ");
        int indiceColumnaOrigen = Integer.parseInt(sc.nextLine());

        Tablero tablero = repositorioTablero.leer();
        Columna columnaOrigen = tablero.encontrarColumna(indiceColumnaOrigen);
        if (columnaOrigen == null) {
            System.out.println("ERROR: NO existe la columna de origen.");
            return;
        }

        System.out.print("Indique el identificador de la tarjeta que desea mover: ");
        int indiceTarjeta = Integer.parseInt(sc.nextLine());

        Tarjeta tarjetaParaMover = columnaOrigen.buscarTarjeta(indiceTarjeta);
        if (tarjetaParaMover == null) {
            System.out.println("ERROR: NO existe la tarjeta en la columna de origen.");
            return;
        }
        System.out.print("Indique el numero de la columna a la que desea mover la tarjeta: ");
        int indiceColumnaDestino = Integer.parseInt(sc.nextLine());
        Columna columnaDestino = tablero.encontrarColumna(indiceColumnaDestino);
        if (columnaDestino == null) {
            System.out.println("ERROR: NO existe la columna destino.");
            return;
        }

        Configuracion config = repositorioConfiguracion.leer();
        if (columnaDestino.contarTarjetas() >= config.getMaxTarjetasPorColumna()) {
            System.out.println("ERROR: No se puede mover la tarjeta ya que la columna superaría el máximo permitido: " + config.getMaxTarjetasPorColumna());
            return;
        }

        columnaDestino.agregarTarjeta(tarjetaParaMover);
        columnaOrigen.quitarTarjeta(tarjetaParaMover);
        repositorioTablero.guardar(tablero);
    }

    private static void crearTarjeta(Usuario usuario) throws IOException {
        System.out.println("Creando una nueva Tarjeta");
        System.out.print("Indique el titulo de la tarjeta: ");
        String titulo = sc.nextLine();

        System.out.print("Indique la descripcion de la tarjeta: ");
        String descripcion = sc.nextLine();

        Tablero tablero = repositorioTablero.leer();
        List<Columna> columnas = tablero.getColumnas();

        Desarrollador desarrollador;
        if (usuario instanceof Administrador) {
            List<Desarrollador> desarrolladores = repositorioDesarrollador.leerTodos();
            System.out.println("Escoja uno de los siguientes desarrolladores por id.");
            for (Desarrollador dev : desarrolladores) {
                System.out.println(dev.getId() + " " + dev.getNombre());
            }
            final int devId = Integer.parseInt(sc.nextLine());
            var optionalDev = desarrolladores.stream().filter(d -> d.getId() == devId).findFirst();
            if (optionalDev.isEmpty()) {
                System.out.println("Error al seleccionar el desarrollador.");
                return;
            }
            desarrollador = optionalDev.get();
        } else {
            desarrollador = (Desarrollador) usuario;
        }

        Columna primerColumna = columnas.get(0);
        int idNuevaTarjeta = tablero.ContarTarjetas() + 1;
        Tarjeta tarjeta = new Tarjeta(primerColumna, titulo, descripcion, desarrollador, idNuevaTarjeta);
        repositorioTablero.guardar(tablero);
    }

    private static void crearDesarrollador(Usuario usuario) throws IOException {
        System.out.println("Creando un Desarrollador: ");
        boolean isAdmin = usuario instanceof Administrador;
        if (!isAdmin) {
            System.out.println("Sólo los administradores pueden crear un desarrollador.");
            return;
        }

        System.out.println("Creando un nuevo Desarrolador");
        System.out.print("Indique el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Indique el correo: ");
        String correo = sc.nextLine();

        Desarrollador desarrollador = new Desarrollador(nombre, correo, repositorioDesarrollador.leerTodos().size() + 1);
        repositorioDesarrollador.guardar(desarrollador);
    }

    private static void crearColumna(Usuario usuario) throws IOException {
        boolean isAdmin = usuario instanceof Administrador;
        if (!isAdmin) {
            System.out.println("Solo el administrador puede crear columnas.");
            return;
        }

        System.out.println("Creando una nueva Columna");
        System.out.print("Indique el titulo de la columna: ");
        String nombre = sc.nextLine();

        Tablero tablero = repositorioTablero.leer();

        List<Columna> columnasValidas = new ArrayList<>();
        int idColumna = -1;
        do {
            System.out.println("Indique el número de la columna desde las cuales se puede mover tarjetas o");
            System.out.print("Ingrese -1 para terminar de seleccionar columnas de origen válido: ");

            System.out.println("\tColumnas existentes: ");
            for (Columna c : tablero.getColumnas()) {
                System.out.println("\t\tId: " + c.getId() + ", titulo: " + c.getTitulo());
            }
            System.out.print("\tId de la columna a agregar: ");
            idColumna = Integer.parseInt(sc.nextLine());

            if (idColumna < 0)
                break;

            final int idColumnaValida = idColumna;
            Optional<Columna> columnaValida = tablero.getColumnas().stream()
                    .filter(c -> c.getId() == idColumnaValida).findFirst();

            if (columnaValida.isEmpty()) {
                System.out.println("Error al seleccionar la columna.");
                return;
            }

            columnasValidas.add(columnaValida.get());
        } while (true);

        Columna columna = new Columna(tablero, nombre, columnasValidas, tablero.getColumnas().size() + 1);
        tablero.agregarColumna(columna);
        repositorioTablero.guardar(tablero);

        System.out.println("Columna creada correctamente\n");
    }

    private static void crearTablero(Usuario usuario) throws IOException {
        boolean isAdmin = usuario instanceof Administrador;
        if (!isAdmin) {
            System.out.println("Solo el administrador puede crear un tablero");
            return;
        }

        System.out.println("Creando un nuevo tablero");
        System.out.print("Indique el titulo del tablero: ");
        String nombre = sc.nextLine();

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

    private static void mostrarTableroFiltroUserId() {
        Tablero tablero = repositorioTablero.leer();
        if (tablero == null) {
            System.out.println("No se encontró el tablero");
            return;
        }

        System.out.println(tablero);
    }

    private static void mostrarTableroFiltroTitulo() {
        Tablero tablero = repositorioTablero.leer();
        if (tablero == null) {
            System.out.println("No se encontró el tablero");
            return;
        }

        System.out.print("Indique la palabra que debe contener las tarjetas que desea ver en el tablero: ");
        String palabraClave = sc.nextLine();

        for (Columna c : tablero.getColumnas()) {
            List<Tarjeta> tarjetas = c.getTarjetas().stream()
                    .filter(t -> t.getTitulo().contains(palabraClave))
                    .collect(Collectors.toList());
            c.setTarjetas(tarjetas);
        }

        System.out.println(tablero);
    }

    public static void mostrarConfiguracion() throws IOException {
        System.out.println("Configuración actual");
        Configuracion configuracion = repositorioConfiguracion.leer();
        if (configuracion == null) {
            configuracion = new Configuracion();
            repositorioConfiguracion.guardar(configuracion);
        }
        System.out.println(configuracion);
    }

    public static void modificarConfiguracion(Usuario usuario) throws IOException {
        boolean isAdmin = usuario instanceof Administrador;
        if (!isAdmin) {
            System.out.println("Sólo el administrador puede cambiar la configuración.");
            return;
        }

        mostrarConfiguracion();
        System.out.print("Indique el número máximo de tarjetas por usuario: ");
        int maxTarjetasPorUsuario = Integer.parseInt(sc.nextLine());
        System.out.print("Indique el número máximo de tarjetas por columna: ");
        int maxTarjetasPorColumna = Integer.parseInt(sc.nextLine());
        Configuracion config = new Configuracion(maxTarjetasPorUsuario, maxTarjetasPorColumna);
        repositorioConfiguracion.guardar(config);
        System.out.println("Configuración guardada con extio");
    }

}
