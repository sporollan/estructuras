package tests.jerarquicas;
import jerarquicas.ArbolBin;


public class TestArbolBin {
    public static void main(String[] args){
        ArbolBin a = new ArbolBin();
        
        a.insertar("1", null, 'L');
        a.insertar("2", "1", 'L');
        a.insertar("3", "1", 'R');

        System.out.println(a.toString());
        System.out.println(a.clone().toString());
        System.out.println(a.padre("2"));

        a.insertar("4", "3", 'L');
        a.insertar("5", "3", 'R');
        a.insertar("6", "5", 'R');

        System.out.println(a.toString());
        System.out.println(a.clone().toString());
        System.out.println(a.padre("6"));

        }
}
