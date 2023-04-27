package jerarquicas;
import lineales.dinamicas.Lista;


public class ArbolGen {
    private NodoGen raiz;
    public ArbolGen()
    {
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object padre)
    {
        boolean exito = false;
        if(this.raiz == null)
        {
            this.raiz = new NodoGen(elem, null, null);
            exito = true;
        }
        else
        {
            exito = insertarAux(elem, padre, this.raiz);
        }
        return exito;
    }

    private boolean insertarAux(Object elem, Object padreElem, NodoGen padre)
    {
        boolean exito = false;
        if(padre != null)
        {
            if(padre.getElem() == padreElem)
            {
                NodoGen hijo = padre.getHijoIzquierdo();
                if(hijo != null)
                {
                    while(hijo.getHermanoDerecho() != null)
                    {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoGen(elem, null, null));
                    exito = true;
                }
                else
                {
                    padre.setHijoIzquierdo(new NodoGen(elem, null, null));
                    exito = true;
                }
            }
            else
            {
                exito = insertarAux(elem, padreElem, padre.getHijoIzquierdo());
                if(!exito)
                {
                    exito = insertarAux(elem, padreElem, padre.getHermanoDerecho());
                }
            }
        }
        return exito;
    }

    public boolean pertenece(Object elem)
    {
        return perteneceAux(elem, this.raiz);
    }

    private boolean perteneceAux(Object elem, NodoGen r)
    {
        boolean p = false;
        if(r != null)
        {
            if(r.getElem() == elem)
            {
                p = true;
            }
            else
            {
                p = perteneceAux(elem, r.getHijoIzquierdo());
                if(!p)
                {
                    p = perteneceAux(elem, r.getHermanoDerecho());
                }
            }
        }
        return p;
    }

    public boolean esVacio()
    {
        return this.raiz == null;
    }

    public Object padre(Object elem)
    {
        return padreAux(elem, this.raiz);
    }
    private Object padreAux(Object elem, NodoGen r)
    {
        Object obj = null;
        if(r != null)
        {
            NodoGen h = r.getHijoIzquierdo();
            while(h != null && obj == null)
            {
                if(h.getElem() == elem)
                {
                    obj = r.getElem();
                }
                h = h.getHermanoDerecho();
            }
            if(obj == null)
            {
                obj = padreAux(elem, r.getHijoIzquierdo());
            }
            if(obj == null)
            {
                obj = padreAux(elem, r.getHermanoDerecho());
            }
        }
        return obj;
    }

    public int altura()
    {
        int a = 0;
        return a;
    }

    public int nivel(Object elem)
    {
        return 0;
    }

    public Lista ancestros(Object elem)
    {
        return new Lista();
    }

    public ArbolGen clone()
    {
        return new ArbolGen();
    }

    public void vaciar()
    {

    }

    public Lista listarPreorden()
    {
        return new Lista();
    }

    public Lista listarInorden()
    {
        return new Lista();
    }

    public Lista listarPosorden()
    {
        return new Lista();
    }

    public Lista listarPorNiveles()
    {
        return new Lista();
    }

    public String toString()
    {
        String s = "";
        if(this.raiz != null)
        {
            s = s + toStringAux(this.raiz);
        }
        return s;
    }

    private String toStringAux(NodoGen r)
    {
        String s = "";
        if(r != null)
        {
            s = r.getElem() + ":";
            NodoGen hijo = r.getHijoIzquierdo();
            while(hijo != null)
            {
                s = s + " " + hijo.getElem();
                hijo = hijo.getHermanoDerecho();
            }
            s = s + "\n";
            s = s + toStringAux(r.getHijoIzquierdo());
            s = s + toStringAux(r.getHermanoDerecho());
        }
        return s;
    }

}