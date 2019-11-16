
package psp_pruebaex_3;


public class Nums extends Thread{
    
    private Monitor m;
    private String texto;

    public Nums(Monitor m, String texto) {

        
        this.m = m;
        this.texto = texto;

    }
    
    
    @Override
    public void run(){
        
        m.contarNums(texto);
        
    }
    
}
