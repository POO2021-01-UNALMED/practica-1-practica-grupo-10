package uiMain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VentanaInicial {
    private Scene escena;

    public Scene getEscena(){
        return escena;
    }

    public VentanaInicial() throws FileNotFoundException {
        Pane pane1 = createPane1();
        Pane pane2 = createPane2();

        GridPane gridP0 = createGenericGridPane();
        gridP0.add(pane1, 0, 0);
        gridP0.add(pane2, 1, 0);

        MenuBar menuBar = createMenuBar();
        VBox vBox = new VBox(menuBar, gridP0);
        escena = new Scene(vBox, 1280, 720);
    }

    private MenuBar createMenuBar() {
        MenuItem menuItemDescripcion = new MenuItem("Descripción del sistema");
        MenuItem menuItemSalir = new MenuItem("Salir");

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
        GridPane gridP4 = createGenericGridPane();

        final String pathRelativoFoto = "src\\baseDatos\\temp\\imagenApp.png";
        FileInputStream input = new FileInputStream(pathRelativoFoto);
        Image image1 = new Image(input);
        ImageView imageView1 = new ImageView(image1);

        imageView1.setPreserveRatio(true);
        imageView1.setFitHeight(100);

        Button iniciarAppButton = new Button("Iniciar aplicacion");

        iniciarAppButton.setOnAction(new EventHandlerVentanaInicial());

        gridP4.add(imageView1, 0,0);
        gridP4.add(iniciarAppButton, 0,1);
        return gridP4;
    }

    private static GridPane createGenericGridPane() {
        GridPane gridP1 = new GridPane();
        gridP1.setPadding(new Insets(10, 10, 10, 10));
        gridP1.setVgap(5);
        gridP1.setHgap(5);
        gridP1.setAlignment(Pos.CENTER);
        return gridP1;
    }

    private static GridPane crearPaneFotos() throws FileNotFoundException {
        GridPane gridP5 = createGenericGridPane();

        final String pathRelativoFoto = "src\\baseDatos\\temp\\2018.jpeg";
        FileInputStream input = new FileInputStream(pathRelativoFoto);
        Image image1 = new Image(input);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image1);
        ImageView imageView3 = new ImageView(image1);
        ImageView imageView4 = new ImageView(image1);

        imageView1.setPreserveRatio(true);
        imageView1.setFitHeight(100);

        imageView2.setPreserveRatio(true);
        imageView2.setFitHeight(100);

        imageView3.setPreserveRatio(true);
        imageView3.setFitHeight(100);

        imageView4.setPreserveRatio(true);
        imageView4.setFitHeight(100);

        gridP5.add(imageView1, 0,0);
        gridP5.add(imageView2, 0,1);
        gridP5.add(imageView3, 1,0);
        gridP5.add(imageView4, 1,1);

        return gridP5;
    }

    private static GridPane crearPaneBienvenida() {
        GridPane gridP3 = createGenericGridPane();
        Label labelSaludo = new Label("Saludo de bienvenida al sistema");
        TextArea descripcion = new TextArea("Maneja las tareas usando un Tablero Canvan de forma eficiente, minimizando cantidad de las tareas en ejecucion.");
        descripcion.setDisable(true);
        gridP3.add(labelSaludo, 0,0);
        gridP3.add(descripcion, 0,1);
        return gridP3;
    }

    private static GridPane crearPaneHojaVida() {
        GridPane gridPane4 = createGenericGridPane();
        TextArea textoHojaVida = new TextArea("Desarrollador backend con 0 experiencia y gusto por el frontend.");
        textoHojaVida.setDisable(true);
        gridPane4.add(textoHojaVida, 0,0);
        return gridPane4;
    }

    class EventHandlerVentanaInicial implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();

            if(source instanceof Button) {
                MainFX.primaryStage.setScene(MainFX.escenaPrinpical);
            }
        }
    }
}
