module com.fran.calculadora_imc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

     // Abre los paquetes que existen
    opens com.fran.calculadora_imc.controller to javafx.fxml;
    opens com.fran.calculadora_imc.main to javafx.fxml;
    opens com.fran.calculadora_imc.model to javafx.fxml;
    
    // Exporta los paquetes
    exports com.fran.calculadora_imc.controller;
    exports com.fran.calculadora_imc.main;
    exports com.fran.calculadora_imc.model;
}
