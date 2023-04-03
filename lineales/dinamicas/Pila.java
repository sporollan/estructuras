package lineales.dinamicas;

/************* Autores ***********
    -   Santiago Porollan, Legajo FAI-3200
*/

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
        boolean exito = true;
        if(this.tope!=null)
            this.tope = this.tope.getEnlace();
        else
            exito = false;
        return exito;
    }

    public Object obtenerTope(){
        Object tope = null;
        if(this.tope != null)
            tope = this.tope.getElem();
        return tope;
    }

    public boolean esVacia(){
        return this.tope == null;
    }

    public void vaciar(){
        this.tope = null;
    }

    public Pila clone(){
        Pila newPila = new Pila();
        newPila.tope = cloneAux(null, this.tope);
        return newPila;
    }

    private Nodo cloneAux(Nodo previo, Nodo original){
        Nodo ret = null;
        if(original != null){
            Nodo newNodo = new Nodo(original.getElem(), null);
            if (previo != null){
                previo.setEnlace(newNodo);
            }
            cloneAux(newNodo, original.getEnlace());
            ret = newNodo;
        }
        return ret;
    }

    @Override
    public String toString(){
        String s = "[";
        if (tope != null){
            s += toStringAux(this.tope);
        }
        return s + "]";
    }

    private String toStringAux(Nodo n){
        String s = "";
        if(n.getEnlace() == null){
            s += n.getElem();
        } else {
            s += toStringAux(n.getEnlace()) + ", " + n.getElem();
        }
        return s;
    }
}