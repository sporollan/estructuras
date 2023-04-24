package tests.jerarquicas;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;


public class TestArbolBin {
    public static void main(String[] args){
        ArbolBin a = new ArbolBin();
        
        a.insertar("A", null, 'L');
        a.insertar("B", "A", 'L');
        a.insertar("D", "B", 'L');

        System.out.println(a.toString());
        System.out.println(a.clone().toString());
        System.out.println(a.padre("2"));

        a.insertar("C", "A", 'R');
        a.insertar("E", "C", 'L');

        a.insertar("G", "E", 'L');
        a.insertar("H", "E", 'R');
        a.insertar("F", "C", 'R');


        System.out.println(a.toString());
        System.out.println(a.clone().toString());
        System.out.println(a.padre("6"));
        System.out.println(a.altura());
        
        Lista l = a.listarPreorden();
        System.out.println("preorden " + l.toString());

        l = a.listarInorden();
        System.out.println("inorden " + l.toString());

        l = a.listarPosorden();
        System.out.println("posorden " + l.toString());

        l = a.listarNiveles();
        System.out.println("niveles " + l.toString());

        }
}
