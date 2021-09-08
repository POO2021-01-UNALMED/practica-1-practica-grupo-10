package uiMain;

import gestorAplicacion.tablero.Tarjeta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TarjetaPanel extends Pane {
    private Tarjeta tarjeta;

    public TarjetaPanel(Tarjeta tarjeta){
        this.tarjeta = tarjeta;
        setBorder(new Border(new BorderStroke(Color.web("#001f3f"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setStyle("-fx-background-color: #7FDBFF");

        Label id  = new Label("Id: " + Integer.toString(tarjeta.getId()));
        Label titulo = new Label(tarjeta.getTitulo());
        Label encargado = new Label("Encargado : \n\t"+tarjeta.getEncargado().getNombre());

        VBox columna = new VBox();
        columna.setPadding(new Insets(10, 10, 10, 10));
        columna.getChildren().addAll(id, titulo, encargado);

        getChildren().addAll(columna);
    }

    public Tarjeta getTarjeta(){
        return tarjeta;
    }

}
