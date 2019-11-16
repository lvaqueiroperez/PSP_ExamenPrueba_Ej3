package psp_pruebaex_3;

public class PSP_PruebaEx_3 {

    public static void main(String[] args) {

        String texto = "Fulanito tiene 4 Naranjas y 8 Peras, tambien 10 platanos";

        Monitor m = new Monitor();

        Mayus hM = new Mayus(m, texto);
        Minus hm = new Minus(m, texto);
        Nums hn = new Nums(m, texto);
        
        //Si no tenemos ningún wait o notify para la variable compartida dará fallos(?)
        hM.start();
        hm.start();
        hn.start();

    }

}
