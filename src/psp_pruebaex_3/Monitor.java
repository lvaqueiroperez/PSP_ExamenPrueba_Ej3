package psp_pruebaex_3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
//Como cada Hilo accede a un método sync distinto PERO todos acceden a una misma variable,
//lo único que habrá que controlar será el acceso a la variable compartida (?)

public class Monitor {

    //variable compartida
    private int ocurrencias = 0;
    //semáforo
    private Boolean disp = true;

    public synchronized void contarMayus(String texto) {

        while (disp == false) {

            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        disp = false;

        //ACCEDER 10 VECES AL MÉTODO EN LA CLASE DEL HILO EN VEZ DE PONER AQUÍ EL FOR??
        //Podríamos hacer que cada uno solo lea un caracter del texto en cada iteracción con él
        //(cada hilo cuenta todos sus elementos y hasta que acabe no empieza otro, como si fuera un join )
        for (int i = 0; i < texto.length(); i++) {

            if (Character.isUpperCase(texto.charAt(i))) {

                ocurrencias++;

                System.out.println("Ocurrencias totales MAYUS: " + ocurrencias);

                try {
                    sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        disp = true;

        notifyAll();

    }

    public synchronized void contarMinus(String texto) {

        while (disp == false) {

            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        disp = false;

        for (int i = 0; i < texto.length(); i++) {

            if (Character.isLowerCase(texto.charAt(i))) {

                ocurrencias++;

                System.out.println("Ocurrencias totales MINUS: " + ocurrencias);

                try {
                    sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        disp = true;
        notifyAll();

    }

    public synchronized void contarNums(String texto) {

        while (disp == false) {

            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        disp = false;

        for (int i = 0; i < texto.length(); i++) {

            if (Character.isDigit(texto.charAt(i))) {

                ocurrencias++;

                System.out.println("Ocurrencias totales NUMS: " + ocurrencias);

                try {
                    sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        disp = true;

        notifyAll();
    }

}
