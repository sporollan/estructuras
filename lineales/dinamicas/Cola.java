package lineales.dinamicas;

public class Cola {
    private Nodo frente, fin;
    
    public Cola(){

    }

    public boolean poner(Object obj){
        boolean exito = true;
        Nodo newNodo = new Nodo(obj, null);
        if(this.frente == null){
            this.frente = newNodo;
            this.fin = newNodo;
        } else {
            this.fin.setEnlace(newNodo);
            this.fin = newNodo;
        }
        return exito;
    }

    public boolean sacar(){
        boolean exito = true;
        if(this.frente == null){
            exito = false;
        } else {
            this.frente = this.frente.getEnlace();
            if(this.frente == null){
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente(){
        Object obj = null;
        try{
            obj = this.frente.getElem();
        } catch(NullPointerException e){}
        return obj;
    }

    public boolean esVacia(){
        return this.frente == null;
    }

    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }

    public Cola clone(){
        Cola newCola = new Cola();
        if(this.frente != null){
            newCola.frente = new Nodo(this.frente.getElem(), null);
            newCola.fin = newCola.frente;
            this.cloneAux(newCola.fin, this.frente.getEnlace());
        }
        return newCola;
    }

    public void cloneAux(Nodo newColaFin, Nodo colaFin){
        if(colaFin != null){
            Nodo newNodo = new Nodo(colaFin.getElem(), null);
            newColaFin.setEnlace(newNodo);
            newColaFin = newNodo;
            cloneAux(newColaFin, colaFin.getEnlace());
        }
    }

    public String toString(){
        String str = "[";
        Nodo frenteAux = this.frente;
        if(frenteAux != null){
            str += frenteAux.getElem();
            frenteAux = frenteAux.getEnlace();
            while(frenteAux!=null){
                str += ", " + frenteAux.getElem();
                frenteAux = frenteAux.getEnlace();
            }

        }
        return str + "]";
    }

}
