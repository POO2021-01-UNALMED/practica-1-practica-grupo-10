package uiMain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class VentanaPrincipal {
    private Scene escena;

    public Scene getEscena(){
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

    private MenuBar createMenuBar() {
        Menu menuArchivo = crearMenuArchivo();
        Menu menuProcesosConsultas = crearMenuProcesoConsultas();
        Menu menuAyuda = crearMenuAyuda();

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuArchivo, menuProcesosConsultas, menuAyuda);
        return menuBar;
    }

    private Menu crearMenuAyuda() {
        MenuItem menuItemAcercaDe = new MenuItem("Acerca de");
        Menu menuAyuda = new Menu("Ayuda");
        menuAyuda.getItems().add(menuItemAcercaDe);
        return menuAyuda;
    }

    private Menu crearMenuProcesoConsultas() {
        MenuItem menuItemVerTablero = new MenuItem("Ver Tablero");
        menuItemVerTablero.setOnAction(new EventHandlerVentanaPrincipal());

        MenuItem menuItemVerCrearTarjeta = new MenuItem("Crear Tarjeta");
        menuItemVerCrearTarjeta.setOnAction(new EventHandlerVentanaPrincipal());

        Menu menuProcesosConsultas = new Menu("Procesos y Consultas");
        menuProcesosConsultas.getItems().addAll(menuItemVerTablero, menuItemVerCrearTarjeta);
        return menuProcesosConsultas;
    }

    private Menu crearMenuArchivo(){
        MenuItem menuItemAplicacion = new MenuItem("Aplicación");
        MenuItem menuItemSalir = new MenuItem("Salir");

        Menu menuArchivo = new Menu("Archivo");
        menuArchivo.getItems().addAll(menuItemAplicacion, menuItemSalir);

        return menuArchivo;
    }

    class EventHandlerVentanaPrincipal implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();
            if(!(source instanceof  MenuItem))
                return;

            MenuItem mi = (MenuItem) source;
            if (mi.getText().equals("Ver Tablero")) {
                System.out.println("Ver tablero");
            }else if (mi.getText().equals("Crear Tarjeta")) {
                System.out.println("Crear Tarjeta");
            }
        }
    }
}
