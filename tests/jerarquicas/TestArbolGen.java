package tests.jerarquicas;
import jerarquicas.ArbolGen;


public class TestArbolGen {
    public static void main(String[] args)
    {
        ArbolGen a = new ArbolGen();
        /*
         *          A
         *      
         * B        C   D       E
         * F G H I  J   K L M   N O P Q R S
         */
        a.insertar("A", null);
        
        a.insertar("B", "A");
        a.insertar("C", "A");
        a.insertar("D", "A");
        a.insertar("E", "A");

        a.insertar("F", "B");
        a.insertar("G", "B");
        a.insertar("H", "B");
        a.insertar("I", "B");

        a.insertar("J", "C");

        a.insertar("K", "D");
        a.insertar("L", "D");
        a.insertar("M", "D");

        a.insertar("N", "E");
        a.insertar("O", "E");
        a.insertar("P", "E");
        a.insertar("Q", "E");
        a.insertar("R", "E");
        a.insertar("S", "E");

        System.out.println(a.toString());
        System.out.println((a.pertenece("Q")?"Q pertenece":"Q no pertenece"));
        System.out.println((a.pertenece("Z")?"Z pertenece":"Z no pertenece"));
        System.out.println("padre de M: " + a.padre("M"));










    }
}
