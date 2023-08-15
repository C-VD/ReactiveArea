package com.example.reactivearea;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private Label labArea;
    @FXML
    private TextField txtA;
    @FXML
    private TextField txtB;


    SimpleIntegerProperty a = new SimpleIntegerProperty();
    SimpleIntegerProperty b = new SimpleIntegerProperty();
    public void initialize(){
        //txtA.setOnAction(ActionEvent -> a.set(Integer.parseInt(txtA.getText())));
        //txtB.setOnAction(ActionEvent -> b.set(Integer.parseInt(txtB.getText())));
        txtA.textProperty().bindBidirectional(a, new DecimalFormat());
        txtB.textProperty().bindBidirectional(b, new DecimalFormat());
        a.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                updateArea();
            }
        });
        b.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                updateArea();
            }
        });
    }

    void updateArea(){
        int s = Integer.parseInt(txtA.getText()) * Integer.parseInt(txtB.getText());
        labArea.setText("Area: " + s);
    }
}