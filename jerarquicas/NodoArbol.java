package jerarquicas;

public class NodoArbol {
    private Object elem;
    private NodoArbol izq, der;

    public NodoArbol(Object elem, NodoArbol izq, NodoArbol der)
    {
        this.elem = elem;
        this.izq = izq;
        this.der = der;
    }

    public Object getElem()
    {
        return this.elem;
    }

    public NodoArbol getIzquierdo()
    {
        return this.izq;
    }

    public NodoArbol getDerecho()
    {
        return this.der;
    }

    public void setElem(Object elem)
    {
        this.elem = elem;
    }

    public void setDerecho(NodoArbol der)
    {
        this.der = der;
    }

    public void setIzquierdo(NodoArbol izq)
    {
        this.izq = izq;
    }

    
}
