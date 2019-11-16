package psp_pruebaex_3;

public class Mayus extends Thread {

    private Monitor m;
    private String texto;

    public Mayus(Monitor m, String texto) {

        
        this.m = m;
        this.texto = texto;

    }
    
    
    @Override
    public void run(){
        
        m.contarMayus(texto);
        
    }
    

}
