package uiMain;

import baseDatos.RepositorioConfiguracion;
import baseDatos.RepositorioConfiguracionImp;
import baseDatos.RepositorioTablero;
import gestorAplicacion.Configuracion;
import gestorAplicacion.tablero.Tablero;
import gestorAplicacion.usuarios.Administrador;
import gestorAplicacion.usuarios.Desarrollador;
import gestorAplicacion.usuarios.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class VentanaPrincipal {
    private Scene escena;
    RepositorioConfiguracion repositorioConfiguracion = new RepositorioConfiguracionImp();
    RepositorioTablero repositorioTablero = new RepositorioTablero();

    public Scene getEscena() {
        return escena;
    }

    public VentanaPrincipal() throws FileNotFoundException {
        Label nombreProcesoConsulta = new Label("Nombre del proceso o consulta");
        Label descripcionProcesoConsulta = new Label("Descripcion detallada");

        String tituloCriterios = "titulo criterios";
        String[] criterios = {"nombre", "edad"};
        String tituloValores = "titulo valores";
        String[] valores = {"stiven", "100"};
        boolean[] habilitado = {true, false};

        FieldPanel fieldPanel = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
        MenuBar menuBar = createMenuBar();
        VBox vBox = new VBox(menuBar, fieldPanel);
        escena = new Scene(vBox, 1280, 720);
    }


    public void cambiarEscenaConfiguracion(Usuario usuario) {
        boolean isAdmin = usuario instanceof Administrador;
        if (!isAdmin) {
            System.out.println("Sólo el administrador puede cambiar la configuración.");
            return;
        }

        Configuracion configuracion = repositorioConfiguracion.leer();
        if (configuracion == null) {
            //notificar que la configuracion no existe y se creará una por defecto
            configuracion = new Configuracion();
            try {
                repositorioConfiguracion.guardar(configuracion);
            } catch (Exception ex) {
                System.out.println("Imposible guardar la configuracion");
            }
        }

        String[] criterios = new String[]{"Número máximo de tarjetas por usuario", "Número máximo de tarjetas por columna"};
        System.out.println(configuracion.getMaxTarjetasPorUsuario());
        String[] valores = new String[]{Integer.toString(configuracion.getMaxTarjetasPorUsuario()), Integer.toString(configuracion.getMaxTarjetasPorColumna())};

        FieldPanel fieldPanel = new FieldPanel(Constantes.DATOS_CONFIGURACION, criterios, "", valores, new boolean[]{true, true});
        MenuBar menuBar = createMenuBar();
        VBox vBox = new VBox(menuBar, fieldPanel);
        escena = new Scene(vBox, 880, 400);
        MainFX.primaryStage.setScene(escena);
    }

    public void cambiarEscenaCrearTarjeta(Usuario usuario) {
        boolean isAdmin = usuario instanceof Administrador;
        if (isAdmin) {
            System.out.println("El administrador sólo puede realizar tareas administrativas.");
            return;
        }

        String[] criterios = new String[]{"Id Tarjeta", "Titulo de la Tarjeta", "Descripcion de la Tarjeta", "Desarrollador"};
        Tablero tablero = repositorioTablero.leer();
        int idNuevaTarjeta = tablero.ContarTarjetas() + 1;

        String[] valores = new String[]{Integer.toString(idNuevaTarjeta), "", "", ""};

        FieldPanel fieldPanel = new FieldPanel(Constantes.DATOS_NUEVA_TARJETA, criterios, "", valores, new boolean[]{false, true, true, true});
        MenuBar menuBar = createMenuBar();
        VBox vBox = new VBox(menuBar, fieldPanel);
        escena = new Scene(vBox, 1280, 720);
        MainFX.primaryStage.setScene(escena);
    }

    public void cambiarEscenaVerTablero() {
        Tablero tablero = repositorioTablero.leer();
        TableroPanel tableroPanel = new TableroPanel(tablero);
        MenuBar menuBar = createMenuBar();
        VBox vBox = new VBox(menuBar, tableroPanel);
        escena = new Scene(vBox, 1280, 720);
        MainFX.primaryStage.setScene(escena);
    }

    public MenuBar createMenuBar() {
        Menu menuArchivo = crearMenuArchivo();
        Menu menuProcesosConsultas = crearMenuProcesoConsultas();
        Menu menuAyuda = crearMenuAyuda();

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuArchivo, menuProcesosConsultas, menuAyuda);
        return menuBar;
    }

    public Menu crearMenuAyuda() {
        MenuItem menuItemAcercaDe = new MenuItem("Acerca de");
        Menu menuAyuda = new Menu("Ayuda");
        menuAyuda.getItems().add(menuItemAcercaDe);
        return menuAyuda;
    }

    public Menu crearMenuProcesoConsultas() {
        MenuItem menuItemVerTablero = new MenuItem(Constantes.VER_TABLERO);
        menuItemVerTablero.setOnAction(new VentanaPrincipal.EventHandlerVentanaPrincipal());

        MenuItem menuItemVerCrearTarjeta = new MenuItem(Constantes.CREAR_TARJETA);
        menuItemVerCrearTarjeta.setOnAction(new VentanaPrincipal.EventHandlerVentanaPrincipal());

        MenuItem menuItemModificarConfiguracion = new MenuItem(Constantes.CAMBIAR_CONFIGURACION);
        menuItemModificarConfiguracion.setOnAction(new VentanaPrincipal.EventHandlerVentanaPrincipal());

        Menu menuProcesosConsultas = new Menu("Procesos y Consultas");
        menuProcesosConsultas.getItems().addAll(menuItemVerTablero, menuItemVerCrearTarjeta, menuItemModificarConfiguracion);
        return menuProcesosConsultas;
    }

    public Menu crearMenuArchivo() {
        MenuItem menuItemAplicacion = new MenuItem(Constantes.MENU_ITEM_APLICACION);
        MenuItem menuItemSalir = new MenuItem(Constantes.MENU_ITEM_SALIR);

        Menu menuArchivo = new Menu("Archivo");
        menuArchivo.getItems().addAll(menuItemAplicacion, menuItemSalir);

        return menuArchivo;
    }

    class EventHandlerVentanaPrincipal implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();
            if (!(source instanceof MenuItem))
                return;

            MenuItem mi = (MenuItem) source;
            if (mi.getText().equals(Constantes.VER_TABLERO)) {
                cambiarEscenaVerTablero();
            } else if (mi.getText().equals(Constantes.CREAR_TARJETA)) {
                cambiarEscenaCrearTarjeta(new Desarrollador());
            } else if (mi.getText().equals(Constantes.CAMBIAR_CONFIGURACION)) {
                cambiarEscenaConfiguracion(new Administrador());
            }
        }
    }
}
