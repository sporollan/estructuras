package tests.lineales;
import lineales.dinamicas.Pila;
public class TestPila{
    public static void main(String[] args){
        testTDA();
        long startTime = System.currentTimeMillis();
        testClone();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime + " millis");
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

    public static void testClone(){
        System.out.println("\nTest Clone");
        boolean exito = true;
        String exitoString;
        Pila p = new Pila();
        for(int i = 0; i<200; i++){
            p.apilar(i);
        }
        exito = exito && testClone1(p);
        p.vaciar();
        for(int i = 0; i<5000; i++){
            p.apilar(i);
        }
        exito = exito && testClone1(p) ;
        if(exito)  
            exitoString = "OK";
        else
            exitoString = "FAIL";

        System.out.println("Test Clone " + exitoString);
    }

    public static boolean testClone1(Pila p){
        Boolean exito;
        String ps = p.toString();
        String psclone = p.clone().toString();
        exito = ps.equals(psclone);
        if(!exito){
            System.out.println(ps);
            System.out.println(psclone);
        }
        System.out.println("test clone true: "+ exito);
        
        return exito;
    }

    public static void testCapicua(){
        System.out.println("\nTest capicua");
        boolean exito = true;
        String exitoString;
        boolean casoCapicua;
        Pila p = new Pila();
        for(int i = 0; i < 100; i++){
            p.apilar(i);
        }
        for(int i = 99; i >= 0; i--){
            p.apilar(i);
        }
        casoCapicua = esCapicua(p);
        System.out.println("capicua arreglo 200 elem true: " + casoCapicua);
        exito = exito && casoCapicua;

        p.vaciar();
        for(int i = 0; i < 100; i++){
            p.apilar(i);
        }
        p.apilar(10000);
        for(int i = 99; i >= 0 ; i--){
            p.apilar(i);
        }
        casoCapicua = esCapicua(p);
        System.out.println("capicua arreglo 201 elem true: " + casoCapicua);
        exito = exito && casoCapicua;
        p.apilar(1);
        casoCapicua = esCapicua(p);
        System.out.println("capicua arreglo 202 elem false: " + casoCapicua);
        exito = exito && !casoCapicua;
        if(exito)
            exitoString = "OK";
        else
            exitoString = "FAIL";
        System.out.println("test capicua " + exitoString);
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