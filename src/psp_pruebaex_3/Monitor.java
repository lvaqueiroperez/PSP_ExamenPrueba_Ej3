package psp_pruebaex_3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Monitor {

    //variable compartida
    private int ocurrencias = 0;

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
