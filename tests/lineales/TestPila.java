package tests.lineales;
import lineales.estaticas.Pila;
public class TestPila{
    public static void main(String[] args){
        Pila p = new Pila();
        p.apilar(1);
        p.apilar(2);
        p.apilar(1);
        testClone();
        System.out.println(esCapicua(p));
        p.desapilar();
        System.out.println(esCapicua(p));
        p.apilar(2);
        p.apilar(1);
        System.out.println(esCapicua(p));
        p.vaciar();
        p.apilar("a");
        p.apilar("b");
        p.apilar("a");
        System.out.println(esCapicua(p));
        p.desapilar();
        System.out.println(esCapicua(p));
        p.apilar("b");
        p.apilar("a");
        System.out.println(esCapicua(p));
    }

    public static void testClone(){
        Pila p = new Pila();
        for(int i = 0; i<10; i++){
            p.apilar(i);
        }
        System.out.println(p.toString());
        System.out.println(p.clone().toString());
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
        System.out.println(pclone.toString());
        System.out.println(inversa.toString());
        
        while(!pclone.esVacia() && capicua){
            capicua = (pclone.obtenerTope() == inversa.obtenerTope());
            pclone.desapilar();
            inversa.desapilar();
        }
        return capicua;
        
        
    }
}