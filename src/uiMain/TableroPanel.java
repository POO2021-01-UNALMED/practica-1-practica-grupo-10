package uiMain;

import gestorAplicacion.tablero.Columna;
import gestorAplicacion.tablero.Tablero;
import gestorAplicacion.tablero.Tarjeta;
import gestorAplicacion.usuarios.Administrador;
import gestorAplicacion.usuarios.Desarrollador;
import gestorAplicacion.usuarios.Usuario;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TableroPanel extends Pane {

    public TableroPanel(Tablero tablero) {
        HBox columnas = new HBox();

        for (Columna c : tablero.getColumnas()) {
            VBox columna = new VBox();
            columna.setPadding(new Insets(10, 20, 20, 20));
            columna.setSpacing(10);
            columna.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            columna.getChildren().add(new Label(c.getTitulo()));
            for (Tarjeta t : c.getTarjetas()) {
                TarjetaPanel tarjetaPanel = new TarjetaPanel(t);
                tarjetaPanel.setOnMouseClicked(new EventHandlerTarjeta());
                columna.getChildren().add(tarjetaPanel);
            }
            columnas.getChildren().addAll(columna);
        }
        getChildren().add(columnas);
    }

    private void cambiarEscenaEditarTarjeta(Tarjeta tarjeta, Usuario usuario) {
        /*boolean isAdmin = usuario instanceof Administrador;
        if (isAdmin) {
            System.out.println("El administrador sólo puede realizar tareas administrativas.");
            return;
        }

        String[] criterios = new String[]{"Id Tarjeta", "Titulo de la Tarjeta", "Descripcion de la Tarjeta", "Desarrollador"};
        String[] valores = new String[]{Integer.toString(tarjeta.getId()), tarjeta.getTitulo(), tarjeta.getDescripcion(), tarjeta.getEncargado().getNombre()};

        FieldPanel fieldPanel = new FieldPanel(Constantes.DATOS_TARJETA_EDITAR, criterios, "", valores, new boolean[]{false, true, true, true});
        MenuBar menuBar = createMenuBar();
        VBox vBox = new VBox(menuBar, fieldPanel);
        Scene escena = new Scene(vBox, 1280, 720);
        MainFX.primaryStage.setScene(escena);*/
    }

    static class EventHandlerTarjeta implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType().toString().equals("MOUSE_CLICKED")) {
                Object source = mouseEvent.getSource();
                if (!(source instanceof TarjetaPanel)) {
                    return;
                }

                TarjetaPanel tarjetaPanel = (TarjetaPanel) source;
                System.out.println("Presiona en la tarjeta " + tarjetaPanel.getTarjeta().getId());
                //cambiarEscenaEditarTarjeta(tarjetaPanel.getTarjeta(), new Desarrollador());
            }
        }
    }
}
