package tests.lineales;
import lineales.dinamicas.Lista;

public class TestLista {
    public static void main(String[] args){
        Lista L = new Lista();
        for(int i = 1; i<4; i++){
            L.insertar(""+i, i);
        }

        L.insertar("0", 1);
        L.insertar("22", 2);
        L.insertar("5", 5);
        L.insertar("7", 7);

        System.out.println(L.toString());

        L.eliminar(1);
        L.eliminar(2);

        System.out.println(L.toString());

        System.out.println(L.recuperar(1));
        System.out.println(L.recuperar(3));
        System.out.println(L.recuperar(5));

        System.out.println(L.localizar("22"));
        System.out.println(L.localizar("5"));
        System.out.println(L.localizar("7"));

        System.out.println(L.longitud());

        System.out.println(L.toString());
        System.out.println(L.clone().toString());

    }
}
