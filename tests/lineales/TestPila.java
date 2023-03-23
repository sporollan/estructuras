package tests.lineales;
import lineales.dinamicas.Pila;
public class TestPila{
    public static void main(String[] args){
        testTDA();
        testClone();
        testCapicua();

    }

    public static void testTDA(){
        Pila p = new Pila();
        boolean exito = true;
        String exitoString;
        // test apilar/desapilar
        p.apilar(1);
        p.apilar(2);
        p.desapilar();
        exito = (int)p.obtenerTope() == 1;
        if(exito)
            exitoString = "OK";
        else
            exitoString = "Fail";
        System.out.println("Test apilar/desapilar, obtener tope, esVacia, vaciar " + exitoString);

    }
    public static void testCapicua(){
        System.out.println("\nTest capicua");
        Pila p = new Pila();
        for(int i = 0; i < 100; i++){
            p.apilar(i);
        }
        for(int i = 99; i >= 0; i--){
            p.apilar(i);
        }
        System.out.println("capicua arreglo 200 elem true: " + esCapicua(p));
        p.vaciar();
        for(int i = 0; i < 100; i++){
            p.apilar(i);
        }
        p.apilar(10000);
        for(int i = 99; i >= 0 ; i--){
            p.apilar(i);
        }
        System.out.println("capicua arreglo 201 elem true: " + esCapicua(p));
        p.apilar(1);
        System.out.println("capicua arreglo 202 elem false: " + esCapicua(p));
    }

    public static void testClone(){
        Pila p = new Pila();
        for(int i = 0; i<10; i++){
            p.apilar(i);
        }
        System.out.println("\nTest Clone");
        String ps = p.toString();
        String psclone = p.clone().toString();
        System.out.println(ps);
        System.out.println(psclone);
        System.out.println("test clone true: "+ ps.equals(psclone));
    }

    public static boolean esCapicua(Pila p){
        Pila inversaAux = p.clone();
        Pila inversa = new Pila();
        Pila pclone = p.clone();

        // crear inversa
        while(!inversaAux.esVacia()){
            inversa.apilar(inversaAux.obtenerTope());
            inversaAux.desapilar();
        }

        // comprobar capicua
        boolean capicua = true;
        while(!pclone.esVacia() && capicua){
            capicua = (pclone.obtenerTope() == inversa.obtenerTope());
            pclone.desapilar();
            inversa.desapilar();
        }
        return capicua;
        
        
    }
}