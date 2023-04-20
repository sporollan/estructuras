package jerarquicas;

public class ArbolBin {
    private NodoArbol raiz;
    public ArbolBin()
    {
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object padre, char lado)
    {
        boolean exito = false;
        if(this.raiz == null)
        {
            this.raiz = new NodoArbol(elem, null, null);
            exito = true;
        } 
        else
        {  
            exito = insertarAux(this.raiz, padre, elem, lado);
        }
        return exito;
    }

    private boolean insertarAux(NodoArbol n, Object padre, Object elem, char lado)
    {
        boolean exito = false;
        
        if(n == null)
        {
            // caso base
        }
        else if (n.getElem() == padre)
        {   // caso base
            // insertar. se inserta si existe el elemento?
            if(lado == 'L')
            {
                n.setIzquierdo(new NodoArbol(elem, null, null));
                exito = true;
            } else if (lado == 'R')
            {
                exito = true;
                n.setDerecho(new NodoArbol(elem, null, null));
            }
        } 
        else 
        {
            // paso inductivo
            exito = insertarAux(n.getIzquierdo(), padre, elem, lado);
            if(!exito)
            {
                exito = insertarAux(n.getDerecho(), padre, elem, lado);
            }
        }
        return exito;
    }

    public String toString()
    {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoArbol n)
    {
        if(n != null)
        {
            return n.getElem() + " " + ((n.getIzquierdo()!=null) ? n.getIzquierdo().getElem() : null)+
            " " + ((n.getDerecho()!=null) ? n.getDerecho().getElem() : null) + "\n" +
            toStringAux(n.getIzquierdo()) +
            toStringAux(n.getDerecho());
        }
        else
        {
            return "";
        }
    }

    public ArbolBin clone()
    {
        ArbolBin a = new ArbolBin();
        a.raiz = cloneAux(this.raiz, null, 'n');
        return a;
    }

    private NodoArbol cloneAux(NodoArbol r, NodoArbol n, char lado)
    {
        if(r != null)
        {
            if(n == null)
            {
                n = new NodoArbol(r.getElem(), null, null);
            }
            else
            {
                NodoArbol h = new NodoArbol(r.getElem(), null, null);
                if(lado == 'L')
                {
                    n.setIzquierdo(h);
                }
                else if (lado == 'R')
                {
                    n.setDerecho(h);
                }
                n = h;
            }
            cloneAux(r.getIzquierdo(), n, 'L');
            cloneAux(r.getDerecho(), n, 'R');
            return n;
        }
        return null;

    }
}
