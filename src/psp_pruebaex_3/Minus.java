
package psp_pruebaex_3;


public class Minus extends Thread {
    
    private Monitor m;
    private String texto;

    public Minus(Monitor m, String texto) {

        
        this.m = m;
        this.texto = texto;

    }
    
    
    @Override
    public void run(){
        
        m.contarMinus(texto);
        
    }
    
}
