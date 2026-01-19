/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ascensor extends Thread {

    private int piso;
    Monitor monitor;

    public Ascensor(Monitor monitor) {
        this.piso = 0;
        this.monitor = monitor;
    }

    private void bajar(int pisoDestino) {
        while (this.piso > pisoDestino && this.piso > 0) {
            this.piso--;
            System.out.println("Ascensor baja: Planta " + this.piso);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ascensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void subir(int pisoDestino) {
        while (this.piso < pisoDestino && this.piso < 4) {
            this.piso++;
            System.out.println("Ascensor sube: Planta " + this.piso);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ascensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void recogerPersona(Persona p) {

        if (this.piso < p.getPisoActual()) {
            this.subir(p.getPisoActual());

        } else {
            this.bajar(p.getPisoActual());
        }
    }

    @Override
    public void run() {
        while (true) {
            if (monitor.hayPersonasEsperando()) {
                Persona persona = monitor.obtenerSiguientePersona();
                if (persona != null) {
                    this.recogerPersona(persona);
                }
                 
            } else {
                // esperar a que llegue alguien
                // usar wait()
            }
        }
    }
}
