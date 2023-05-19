package jerarquicas.dinamicas;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;


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
        return alturaAux(this.raiz, -1);
    }

    private int alturaAux(NodoGen r, int a)
    {
        if(r != null)
        {
            a = a + 1;
            int max = a;
            int aHijo;
            NodoGen hijo = r.getHijoIzquierdo();
            while(hijo != null)
            {
                aHijo = alturaAux(hijo, a);
                max = (aHijo > max) ? aHijo : max;
                hijo = hijo.getHermanoDerecho();
            }
            a = max;
        }
        return a;
    }

    public int nivel(Object elem)
    {
        return nivelAux(0, elem, raiz);
    }

    private int nivelAux(int a, Object elem, NodoGen r)
    {
        int b = -1;
        if(r != null)
        {

            if(r.getElem() == elem)
            {   
                b = a;
            }
            else
            {
                NodoGen hijo = r.getHijoIzquierdo();
                while(hijo != null && b == -1)
                {
                    b = nivelAux(a+1, elem, hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return b;
    }

    public Lista ancestros(Object elem)
    {
        Lista L = new Lista();
        ancestrosAux(L, elem, this.raiz);
        return L;
    }

    public boolean ancestrosAux(Lista L, Object elem, NodoGen r)
    {
        boolean encontrado = false;
        if(r != null)
        {
            if(r.getElem() == elem)
            {
                L.insertar(elem, 1);
                encontrado = true;
            }
            else
            {
                NodoGen h = r.getHijoIzquierdo();
                while(h != null && !encontrado)
                {
                    encontrado = ancestrosAux(L, elem, h);
                    h = h.getHermanoDerecho();
                }
                if(encontrado)
                {
                    L.insertar(r.getElem(), 1);
                }
            }
        }
        return encontrado;
    }

    public ArbolGen clone()
    {
        ArbolGen a = new ArbolGen();
        a.raiz = this.cloneAux(this.raiz);
        return a;
    }

    private NodoGen cloneAux(NodoGen r) {
    NodoGen clone = null;
    if (r != null) {
        clone = new NodoGen(r.getElem(), null, null);
        NodoGen hijo = r.getHijoIzquierdo();
        if (hijo != null) {
            clone.setHijoIzquierdo(cloneAux(hijo));
        }
        clone.setHermanoDerecho(cloneAux(r.getHermanoDerecho()));
    }
    return clone;
}
    public void vaciar()
    {
        this.raiz = null;
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();
        listarPreordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPreordenAux(NodoGen r, Lista lista) {
        if (r != null) {
            lista.insertar(r.getElem(), lista.longitud() + 1); // Add current element to the list
            NodoGen hijo = r.getHijoIzquierdo();
            while (hijo != null) {
                listarPreordenAux(hijo, lista); // Recursively traverse and add elements of the subtree
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInorden() {
        Lista lista = new Lista();
        listarInordenAux(this.raiz, lista);
        return lista;
    }

    private void listarInordenAux(NodoGen r, Lista lista) {
        if (r != null) {
            NodoGen hijo = r.getHijoIzquierdo();
            while (hijo != null) {
                listarInordenAux(hijo, lista); // Recursively traverse and add elements of the left subtree
                hijo = hijo.getHermanoDerecho();
            }
            lista.insertar(r.getElem(), lista.longitud() + 1); // Add current element to the list
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        listarPosordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPosordenAux(NodoGen r, Lista lista) {
        if (r != null) {
            NodoGen hijo = r.getHijoIzquierdo();
            while (hijo != null) {
                listarPosordenAux(hijo, lista); // Recursively traverse and add elements of the subtree
                hijo = hijo.getHermanoDerecho();
            }
            lista.insertar(r.getElem(), lista.longitud() + 1); // Add current element to the list
        }
    }

    public Lista listarPorNiveles() {
        Lista lista = new Lista();
        if (this.raiz != null) {
            Cola cola = new Cola();
            cola.poner(this.raiz);

            while (!cola.esVacia()) {
                NodoGen actual = (NodoGen) cola.obtenerFrente();
                cola.sacar();
                lista.insertar(actual.getElem(), lista.longitud() + 1);

                NodoGen hijo = actual.getHijoIzquierdo();
                while (hijo != null) {
                    cola.poner(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return lista;
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

   public boolean sonFrontera(Lista unaLista) {
        return sonFronteraAux(this.raiz, unaLista);
    }

    private boolean sonFronteraAux(NodoGen r, Lista unaLista) {
        if (r == null) {
            return true; // Empty tree has no frontier nodes
        }
        
        if (r.getHijoIzquierdo() == null && r.getHermanoDerecho() == null) {
            // Current node is a leaf node, check if it is present in the given list
            int pos = unaLista.localizar(r.getElem());
            if (pos != -1) {
                unaLista.eliminar(pos);
            } else {
                return false; // Leaf node not found in the list
            }
        }

        // Recursively check the frontier nodes of the subtree
        return sonFronteraAux(r.getHijoIzquierdo(), unaLista) &&
               sonFronteraAux(r.getHermanoDerecho(), unaLista);
    }
    public boolean sonFrontera1(Lista unaLista){
        Lista lClon= unaLista.clone();
        boolean verif;

        verif= sonFronteraAux1(this.raiz, lClon);

        return verif;

    }
    private boolean sonFronteraAux1(NodoGen n, Lista lClon){
        boolean verif=false;
        int pos;
        if(lClon.esVacia()){
            verif= true;
        }else{ 

            if(n!=null){

                if(n.getHijoIzquierdo()== null){
                    if(lClon.localizar(n.getElem())!= -1){
                        pos= lClon.localizar(n.getElem());
                        lClon.eliminar(pos);
                    }

                }
                verif= sonFronteraAux1(n.getHijoIzquierdo(), lClon);
                if(!verif){
                    verif= sonFronteraAux1(n.getHermanoDerecho(), lClon);
                }
            }
        }
        return verif;
    }
}