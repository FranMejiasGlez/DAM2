module com.fran.calculadora_imc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.fran.calculadora_imc to javafx.fxml;
    exports com.fran.calculadora_imc.main;
}
