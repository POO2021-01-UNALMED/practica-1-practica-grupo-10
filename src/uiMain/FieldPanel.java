package uiMain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class FieldPanel extends Pane {
    private HashMap<String, String> criteroToValor = new HashMap<>();
    TextField[] textFieldValores;

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
        textFieldValores = new TextField[valores.length];

        for (int i = 0; i < criterios.length; i++) {
            criteroToValor.put(criterios[i], valores[i]);
        }

        GridPane gridCriterios = new GridPane();
        gridCriterios.setPadding(new Insets(10, 10, 10, 10));
        gridCriterios.setVgap(5);
        gridCriterios.setHgap(5);
        gridCriterios.setAlignment(Pos.CENTER);

        Label labelCriterio = new Label(tituloCriterios);
        Label labelValores = new Label(tituloValores);
        gridCriterios.add(labelCriterio, 0, 0);
        gridCriterios.add(labelValores, 1, 0);

        for (int i = 0; i < criterios.length; i++) {
            gridCriterios.add(new Label(criterios[i]), 0,i +1);
            textFieldValores[i] = new TextField(valores[i]);
            textFieldValores[i].setDisable(habilitado[i]);
            gridCriterios.add(textFieldValores[i], 1,i+1);
        }

        Button botonAceptar = new Button("Aceptar");
        Button botonBorrar = new Button("Borrar");

        botonAceptar.setOnAction(new EventHandlerFieldPanel());
        botonBorrar.setOnAction(new EventHandlerFieldPanel());

        gridCriterios.add(botonAceptar, 0, criterios.length + 1);
        gridCriterios.add(botonBorrar, 1, criterios.length + 1);

        getChildren().add(gridCriterios);
    }

    public String getValue(String criterio){
        return criteroToValor.get(criterio);
    }

    class EventHandlerFieldPanel implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();

            if(!(source instanceof Button)) {
                return;
            }

            Button button = (Button) source;
            if(button.getText() == "Borrar"){
                limpiarTextFieldEditables();
            } else if(button.getText() == "Aceptar"){
                System.out.println("Click en aceptar");
            }
        }

        private void limpiarTextFieldEditables() {
            for (TextField tf: textFieldValores) {
                if(!tf.isDisable()){
                    tf.clear();;
                }
            }
        }
    }
}
