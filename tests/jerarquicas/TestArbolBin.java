package tests.jerarquicas;
import jerarquicas.ArbolBin;


public class TestArbolBin {
    public static void main(String[] args){
        ArbolBin a = new ArbolBin();
        
        a.insertar("1", null, 'L');
        a.insertar("2", "1", 'L');
        a.insertar("3", "1", 'R');

        System.out.println(a.toString());

        }
}
