package uiMain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VentanaInicial {
    private Scene escena;
    private int indiceImagen = 0;
    private int indiceHojaVida = 0;
    private String[] rutasImagenes = {
            "src\\baseDatos\\temp\\imagenApp1.png",
            "src\\baseDatos\\temp\\imagenApp2.png",
            "src\\baseDatos\\temp\\imagenApp3.png",
            "src\\baseDatos\\temp\\imagenApp4.png"
    };

    public Scene getEscena() {
        return escena;
    }

    public VentanaInicial() throws FileNotFoundException {
        escena = crearEscena();
    }

    private Scene crearEscena() throws FileNotFoundException {
        Pane pane1 = createPane1();
        Pane pane2 = createPane2();

        GridPane gridP0 = createGenericGridPane();
        gridP0.add(pane1, 0, 0);
        gridP0.add(pane2, 1, 0);

        MenuBar menuBar = createMenuBar();
        VBox vBox = new VBox(menuBar, gridP0);
        return new Scene(vBox, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
    }

    private MenuBar createMenuBar() {
        MenuItem menuItemDescripcion = new MenuItem("Descripción del sistema");
        MenuItem menuItemSalir = new MenuItem(Constantes.MENU_ITEM_SALIR);

        menuItemSalir.setOnAction(new EventHandlerVentanaInicial());

        Menu menuInicio = new Menu("Inicio");
        menuInicio.getItems().addAll(menuItemDescripcion, menuItemSalir);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menuInicio);
        return menuBar;
    }

    private Pane createPane2() throws FileNotFoundException {
        GridPane gridP5 = crearPaneHojaVida();
        GridPane gridP6 = crearPaneFotos();

        return new VBox(gridP5, gridP6);
    }

    private Pane createPane1() throws FileNotFoundException {
        GridPane gridP3 = crearPaneBienvenida();
        GridPane gridP4 = panelAplicacion();

        return new VBox(gridP3, gridP4);
    }

    private GridPane panelAplicacion() throws FileNotFoundException {
        final int height = 300;
        GridPane gridP4 = createGenericGridPane();

        final String pathRelativoFoto1 = rutasImagenes[indiceImagen];
        FileInputStream input1 = new FileInputStream(pathRelativoFoto1);
        ImageView imageView1 = new ImageView(new Image(input1));
        imageView1.setPreserveRatio(true);
        imageView1.setFitHeight(height);

        imageView1.setOnMouseEntered(mouseAplicacionEventHandler);

        Button iniciarAppButton = new Button("Iniciar aplicacion");
        iniciarAppButton.setOnAction(new EventHandlerVentanaInicial());

        gridP4.add(imageView1, 0, 0);
        gridP4.add(iniciarAppButton, 0, 1);
        return gridP4;
    }

    private GridPane createGenericGridPane() {
        GridPane gridP1 = new GridPane();
        gridP1.setPadding(new Insets(10, 10, 10, 10));
        gridP1.setVgap(5);
        gridP1.setHgap(5);
        gridP1.setAlignment(Pos.CENTER);
        return gridP1;
    }

    private GridPane crearPaneFotos() throws FileNotFoundException {
        GridPane gridP5 = createGenericGridPane();

        final String pathRelativoFoto1 = "src\\baseDatos\\temp\\2015.jpg";
        final String pathRelativoFoto2 = "src\\baseDatos\\temp\\2017.jpg";
        final String pathRelativoFoto3 = "src\\baseDatos\\temp\\2018.jpeg";
        final String pathRelativoFoto4 = "src\\baseDatos\\temp\\2019.jpg";

        FileInputStream input1 = new FileInputStream(pathRelativoFoto1);
        FileInputStream input2 = new FileInputStream(pathRelativoFoto2);
        FileInputStream input3 = new FileInputStream(pathRelativoFoto3);
        FileInputStream input4 = new FileInputStream(pathRelativoFoto4);

        ImageView imageView1 = new ImageView(new Image(input1));
        ImageView imageView2 = new ImageView(new Image(input2));
        ImageView imageView3 = new ImageView(new Image(input3));
        ImageView imageView4 = new ImageView(new Image(input4));

        imageView1.setPreserveRatio(true);
        imageView1.setFitHeight(100);

        imageView2.setPreserveRatio(true);
        imageView2.setFitHeight(100);

        imageView3.setPreserveRatio(true);
        imageView3.setFitHeight(100);

        imageView4.setPreserveRatio(true);
        imageView4.setFitHeight(100);

        gridP5.add(imageView1, 0, 0);
        gridP5.add(imageView2, 0, 1);
        gridP5.add(imageView3, 1, 0);
        gridP5.add(imageView4, 1, 1);

        return gridP5;
    }

    private GridPane crearPaneBienvenida() {
        GridPane gridP3 = createGenericGridPane();
        Label labelSaludo = new Label("Bienvenido al Tablero Kanban!!");
        TextArea descripcion = new TextArea("Maneja las tareas usando un Tablero Canvan de forma eficiente\n," +
                "minimizando cantidad de las tareas en ejecucion.");
        descripcion.setDisable(true);
        gridP3.add(labelSaludo, 0, 0);
        gridP3.add(descripcion, 0, 1);
        return gridP3;
    }

    private GridPane crearPaneHojaVida() {
        String[] hojasDeVida = {"Silvio Stiven Villegas Castro\n Cédula: 1041229027\n Programa: Ciencias de la Computación\n"+
        "Desarrollador Backend que cuenta con 0 conocimiento en frontend", "Valkiria Maria\n Cédula: 001\n Programa: Gata a tiempo completo\n"+
                        "Duerme 3/4 del dia"};

        GridPane gridPane4 = createGenericGridPane();
        TextArea textoHojaVida = new TextArea(hojasDeVida[indiceHojaVida]);
        textoHojaVida.setDisable(true);
        textoHojaVida.setOnMouseClicked(mouseAplicacionEventHandler);
        gridPane4.add(textoHojaVida, 0, 0);
        return gridPane4;
    }

    void cambiarImagenAplicacion() throws FileNotFoundException {
        indiceImagen = (indiceImagen + 1) % rutasImagenes.length;
        escena = crearEscena();
        MainFX.primaryStage.setScene(escena);
    }

    void cambiarHojaVidaYFotos() throws FileNotFoundException {
        System.out.println("Cambio hoja de vida y fotos");
        indiceHojaVida = (indiceHojaVida + 1) % 2;
        escena = crearEscena();
        MainFX.primaryStage.setScene(escena);
    }

    class EventHandlerVentanaInicial implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();

            if (source instanceof Button) {
                MainFX.primaryStage.setScene(MainFX.escenaPrinpical);
            }

            if(source instanceof MenuItem) {
                MenuItem mi = (MenuItem) source;
                if (mi.getText().equals(Constantes.MENU_ITEM_SALIR)) {
                    MainFX.primaryStage.close();
                }
            }
        }
    }

    EventHandler<MouseEvent> mouseAplicacionEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType().toString().equals("MOUSE_CLICKED")) {
                System.out.println("Click en imagen");
                try {
                    cambiarImagenAplicacion();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED")) {
                try {
                    cambiarImagenAplicacion();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    EventHandler<MouseEvent> mouseHojaVidaEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType().toString().equals("MOUSE_CLICKED")) {
                System.out.println("Click en imagen");
                try {
                    cambiarImagenAplicacion();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
