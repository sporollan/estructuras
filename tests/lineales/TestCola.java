package tests.lineales;
import lineales.dinamicas.Cola;


public class TestCola {
    public static void main(String[] args){
        Cola c = new Cola();

        for(int i = 0; i < 9; i++){
            c.poner(i);
        }

        testModificar(c,"[0, 1, 2, 3, 4, 5, 6, 7, 8]" , 0);
        testClone(c);


        for(int i = 0; i < 5; i++){
            c.sacar();
        }
        
        testModificar(c,"[5, 6, 7, 8]" , 5);
        testClone(c);

        for(int i = 0; i < 10; i++){
            c.sacar();
        }

        testModificar(c, "[]", null);
        testClone(c);
    }

    public static void testModificar(Cola c, String testPoner, Object testFrente){
        boolean exito = true;
    
        if (c.toString().equals(testPoner))
            System.out.println("\nTest poner OK");
        else{
            exito = false;
            System.out.println("\nTest poner failed");
            System.out.println(c.toString());
            System.out.println("should be");
            System.out.println(testPoner);
        }

        if (c.obtenerFrente() == testFrente)
            System.out.println("\nTest obtener frente OK");
        else{
            exito = false;
            System.out.println("\nTest obtener frente failed");
            System.out.println(c.obtenerFrente());
            System.out.println("should be");
            System.out.println(testFrente);
        }


        if(exito)
            System.out.println("\nTests modificar OK");
        else
            System.out.println("\nTests modificar failed");
    }

    public static void testClone(Cola c){
        if(c.toString().equals(c.clone().toString())){
            System.out.println("\nTest clone OK");
        } else {
            System.out.println("\nTest clone failed");
            System.out.println(c.clone().toString());
            System.out.println("should be");
            System.out.println(c.toString());
        }
    }

}
