package com.fran.calculadora_imc.model;

public class CalculadoraIMC {

    public CalculadoraIMC() {
    }

    public double calcular(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String clasificar(double imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc <= 24.9) {
            return "Peso normal";
        } else if (imc < 30.0) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
