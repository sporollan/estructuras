package tests.conjuntistas;
import conjuntistas.HeapMin;


public class TestArbolHeap
{
    public static void main(String[] args)
    {
        HeapMin h = new HeapMin();

        h.insertar(2);
        h.insertar(7);
        h.insertar(1);
        h.insertar(8);
        h.insertar(10);
        h.insertar(4);
        h.insertar(0);
        h.insertar(9);
        h.insertar(0);
        h.insertar(-44);
        System.out.println(h.toString());
    }
}