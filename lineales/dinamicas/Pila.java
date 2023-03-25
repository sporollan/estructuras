package lineales.dinamicas;

public class Pila {
    private Nodo tope;
    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem){
        // crea un nuevo nodo delante de la antigua cabecera
        Nodo nuevo = new Nodo(nuevoElem, this.tope);

        // actualiza el tope para que apunte al nodo nuevo
        this.tope = nuevo;

        // nunca hay error de pila llena, entonces devuelve  true
        return true;
    }

    public boolean desapilar(){
        this.tope = this.tope.getEnlace();
        return this.tope != null;
    }

    public Object obtenerTope(){
        return this.tope.getElem();
    }

    public boolean esVacia(){
        return this.tope == null;
    }

    public void vaciar(){
        this.tope = null;
    }

    public Pila cloneOld(){
        Pila newPila = new Pila();
        Nodo topeAux = this.tope;
        Nodo newNodoTope = new Nodo(null, null);
        Nodo newNodo, prevNodo;
        newNodoTope.setElem(topeAux.getElem());
        newPila.tope = newNodoTope;
        prevNodo = newNodoTope;
        topeAux = topeAux.getEnlace();
        while(topeAux != null){
            newNodo = new Nodo(null, null);
            newNodo.setElem(topeAux.getElem());
            prevNodo.setEnlace(newNodo);
            prevNodo = newNodo;
            topeAux = topeAux.getEnlace();
        }
        return newPila;
    }

    public Pila clone(){
        Pila newPila = new Pila();
        newPila.tope = cloneAux(null, this.tope);
        return newPila;
    }

    public Nodo cloneAux(Nodo previo, Nodo original){
        if(original == null){
            return null;
        } else {
            Nodo newNodo = new Nodo(original.getElem(), null);
            if (previo != null){
                previo.setEnlace(newNodo);
            }
            cloneAux(newNodo, original.getEnlace());
            return newNodo;
        }
    }

    @Override
    public String toString(){
        String s = "";

        if (this.tope == null)
            s = "Pila vacia";
        else {
            // se ubica para recorrer la pila
            Nodo aux = this.tope;
            s = "[";
            while (aux != null){
                // agrega el texto del elem y avanza
                s += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null)
                    s += ",";
            }
            s += "]";
        }
        return s;
    }
}