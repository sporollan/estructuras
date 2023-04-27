package jerarquicas;


import lineales.dinamicas.Lista;

public class ArbolBin {
    private NodoArbol raiz;
    public ArbolBin()
    {
        this.raiz = null;
    }

    public Lista frontera()
    {
        Lista l = new Lista();
        fronteraAux(l, this.raiz);
        return l;
    }

    private void fronteraAux(Lista l, NodoArbol r)
    {
        if(r != null)
        {
            if(r.getDerecho() == null && r.getIzquierdo() == null)
            {
                l.insertar(r.getElem(), l.longitud()+1);
            }
            if(r.getIzquierdo()!=null)
            {
                fronteraAux(l, r.getIzquierdo());
            }
            if(r.getDerecho()!=null)
            {
                fronteraAux(l, r.getDerecho());
            }
        }
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

    public boolean esVacio()
    {
        return this.raiz == null;
    }

    public Object padre(Object elem)
    {
        return padreAux(elem, null, null);
    }

    public Object padreAux(Object elem, NodoArbol p, NodoArbol h)
    {
        Object elemp = null;
        if(h != null)
        {      
            if(h.getElem() == elem)
            {
                elemp = p.getElem();
            }
            else
            {
                elemp = padreAux(elem, h, h.getIzquierdo());
                if(elemp == null)
                {
                    elemp = padreAux(elem, h, h.getDerecho());
                }
            }
            
        }
        else
        {
            if(p == null)
            {
                elemp = padreAux(elem, this.raiz, this.raiz.getIzquierdo());
                if(elemp == null)
                {
                    elemp = padreAux(elem, this.raiz, this.raiz.getDerecho());
                }
            }
        }
        return elemp;
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

    public int altura()
    {
        if(raiz == null)
        {
            return -1;
        }
        else
        {
            return alturaAux(this.raiz, -1);
        }
    }
    public int alturaAux(NodoArbol r, int a)
    {
        int der = 0;
        int izq = 0;

        if(r != null)
        {
            a += 1;
            der = alturaAux(r.getDerecho(), a);
            izq = alturaAux(r.getIzquierdo(), a);
        }
        else
        {
            return a;
        }
        return (izq > der) ? izq:der;
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

    public Lista listarPreorden()
    {
        Lista l = new Lista();
        listarPreordenAux(l, this.raiz, 1);
        return l;
    }

    private int listarPreordenAux(Lista l, NodoArbol r, int i)
    {
        if(r != null)
        {
            l.insertar(r.getElem(), l.longitud()+1);
            i+=1;
            if(r.getIzquierdo() != null)
            {
                i = listarPreordenAux(l, r.getIzquierdo(), i);

            }
            if (r.getDerecho() != null)
            {
                i = listarPreordenAux(l, r.getDerecho(), i);
            }
        }
        return i;
    }

    public Lista listarInorden()
    {
        Lista l = new Lista();
        listarInordenAux(l, this.raiz, 1);
        return l;
    }

    private int listarInordenAux(Lista l, NodoArbol r, int i)
    {
        if(r != null)
        {
            if(r.getIzquierdo() != null){
                i = listarInordenAux(l, r.getIzquierdo(), i);
            }
            l.insertar(r.getElem(), i);
            i+=1;
            if(r.getDerecho() != null)
            {
                i = listarInordenAux(l, r.getDerecho(), i);
            }
        }
        return i;
    }

    public Lista listarPosorden()
    {
        Lista l = new Lista();
        listarPosordenAux(l, this.raiz, 1);
        return l;
    }

    private int listarPosordenAux(Lista l, NodoArbol r, int i)
    {
        if(r != null)
        {
            if(r.getIzquierdo() != null){
                i = listarPosordenAux(l, r.getIzquierdo(), i);
            }

            if(r.getDerecho() != null)
            {
                i = listarPosordenAux(l, r.getDerecho(), i);
            }
            l.insertar(r.getElem(), i);
            i+=1;
        }
        return i;
    }

    public Lista listarNiveles()
    {
        Lista ll = new Lista();
        Lista l = new Lista();
        Lista laux;
        int k = 1;

        listarNivelesAux(ll, this.raiz, 0);

        for(int i = 1; i <= ll.longitud(); i++)
        {
            // unir todas las listas de ll donde
            // cada indice es una lista con todos 
            // los elementos de un nivel
            laux = (Lista)ll.recuperar(i);
            for(int j = 1; j <= laux.longitud(); j++)
            {
                l.insertar(laux.recuperar(j),k);
                k+=1;
            }
        }
        return l;
    }

    private void listarNivelesAux(Lista l, NodoArbol r, int nivel)
    {
        Lista laux;
        if( r != null)
        {
            if(nivel >= l.longitud())
            {
                // agregar nivel nuevo a la lista
                laux = new Lista();
                laux.insertar(r.getElem(), laux.longitud()+1);
                l.insertar(laux, nivel+1);
            }
            else
            {
                // insertar elemento en su lista nivel
                laux = (Lista)l.recuperar(nivel+1);
                l.eliminar(nivel+1);
                laux.insertar(r.getElem(), laux.longitud() + 1);
                l.insertar(laux, nivel+1);
            }
            
            // seguir recorriendo en preorden
            if(r.getIzquierdo() != null)
            {
                listarNivelesAux(l, r.getIzquierdo(), nivel+1);
            }
            if(r.getDerecho() != null)
            {
                listarNivelesAux(l, r.getDerecho(), nivel+1);
            }
        }
    }
}
