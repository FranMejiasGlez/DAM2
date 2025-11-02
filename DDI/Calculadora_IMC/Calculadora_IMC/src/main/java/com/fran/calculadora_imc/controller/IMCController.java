package com.fran.calculadora_imc.controller;

import com.fran.calculadora_imc.model.CalculadoraIMC;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IMCController {

    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtAltura;
    @FXML
    private Label lblResultado;
    @FXML
    private Label lblClasificacion;
    @FXML
    private Button btnEnviar;

    private final CalculadoraIMC calculadora = new CalculadoraIMC();

    @FXML
    private void handleCalcular() {
        try {
            double peso = Double.parseDouble(txtPeso.getText().replace(',', '.'));
            double altura = Double.parseDouble(txtAltura.getText().replace(',', '.'));

            double imc = calculadora.calcular(peso, altura);
            String clasificacion = calculadora.clasificar(imc);

            lblResultado.setText(String.format("IMC: %.2f", imc));
            lblClasificacion.setText(clasificacion);

        } catch (NumberFormatException nfe) {
            lblResultado.setText("Error");
            lblClasificacion.setText("Datos inválidos");
        }
    }
}
