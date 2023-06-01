package conjuntistas;


public class HeapMin
{
    private static int L = 20;
    private Object[] heap;
    private int ultimo;


    public HeapMin()
    {
        this.heap = new Object[L];
        this.ultimo = -1;
    }

    public boolean insertar(Object elem)
    {
        boolean e = false;
        if(this.ultimo < 19)
        {
            this.ultimo++;
            this.heap[this.ultimo] = elem;
            e = true;
            this.intercambiar(this.ultimo);
        }
        return e;
    }

    // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    //  u = 0;
    //  hi = 2*0 + 1 = 1
    //  hd = 2*0 + 2 = 2
    //
    //  u = 1
    //  hi = 2*1 + 1 = 3
    //  hd = 2*1 + 2 = 4
    //
    //  u = 2
    //  hi = 2*2 + 1 = 5
    //  hd = 2*2 + 2 = 6

    private void intercambiar(int u)
    {
        // lado = 1 ==> izquierdo
        int lado;
        int aux;
        int p=1201932809;
        boolean continuar = true;

        while(continuar && u > 0 && u < 20)
        {
            lado = u%2;
            if(lado == 1)
            {
                p = (u-1) / 2;
            }
            else if(lado == 0)
            {
                p = (u-2) / 2;
            }

            if((int)this.heap[p] > (int)this.heap[u])
            {
                aux = (int)this.heap[p];
                this.heap[p] = this.heap[u];
                this.heap[u] = aux;
            }
            else
            {
                continuar = false;
            }
            u = p;
        }
    }

    public boolean eliminarCima()
    {
        return false;
    }

    public Object recuperarCima()
    {
        return new Object();
    }

    public String toString()
    {
        String s = "[" + this.heap[0];
        for(int i = 1; i<this.heap.length; i++)
        {
            s += ", " + this.heap[i];
        }
        return s + "]";
    }
}