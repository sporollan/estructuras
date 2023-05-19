package tests.jerarquicas;
import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;


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

        System.out.println((a.pertenece("Q")?"Q pertenece":"Q no pertenece"));
        System.out.println((a.pertenece("Z")?"Z pertenece":"Z no pertenece"));
        System.out.println("padre de M: " + a.padre("M"));


        System.out.println("altura: " + a.altura());
        a.insertar("T", "S");
        System.out.println("altura: " + a.altura());
        a.insertar("U", "T");
        System.out.println("altura: " + a.altura());

        System.out.println("nivel S: " + a.nivel("S"));
        System.out.println("nivel A: " + a.nivel("A"));
        System.out.println("nivel C: " + a.nivel("C"));
        System.out.println("nivel U: " + a.nivel("U"));

        System.out.println(a.toString());

        System.out.println("ancestros U: " + a.ancestros("U"));

        System.out.println("clone: " + a.clone().toString());
	
        System.out.println("preorden: " + a.listarPreorden().toString());

        System.out.println("posorden: " + a.listarPosorden().toString());

        System.out.println("niveles: " + a.listarPorNiveles().toString());

        System.out.println("inorden: " + a.listarInorden().toString()); 

        Lista frontera = new Lista();
        frontera.insertar("F", frontera.longitud() + 1);
        frontera.insertar("G", frontera.longitud() + 1);
        frontera.insertar("H", frontera.longitud() + 1);
        frontera.insertar("I", frontera.longitud() + 1);
        frontera.insertar("J", frontera.longitud() + 1);
        frontera.insertar("K", frontera.longitud() + 1);
        frontera.insertar("L", frontera.longitud() + 1);

        System.out.println("sonFrontera(frontera): " + a.sonFrontera1(frontera));

        Lista frontera1 = new Lista();
        frontera1.insertar("F", frontera1.longitud() + 1);
        frontera1.insertar("G", frontera1.longitud() + 1);
        frontera1.insertar("H", frontera1.longitud() + 1);
        frontera1.insertar("I", frontera1.longitud() + 1);
        frontera1.insertar("J", frontera1.longitud() + 1);
        frontera1.insertar("K", frontera1.longitud() + 1);
        frontera1.insertar("L", frontera1.longitud() + 1);
        frontera1.insertar("M", frontera1.longitud() + 1);
        frontera1.insertar("N", frontera1.longitud() + 1);
        frontera1.insertar("O", frontera1.longitud() + 1);
        frontera1.insertar("P", frontera1.longitud() + 1);
        frontera1.insertar("Q", frontera1.longitud() + 1);
        frontera1.insertar("R", frontera1.longitud() + 1);
        frontera1.insertar("U", frontera1.longitud() + 1);

        System.out.println("sonFrontera(frontera1): " + frontera1.toString() + a.sonFrontera1(frontera1));
    }
}
