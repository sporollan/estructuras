package lineales.estaticas;
public class Pila{
    public Object[] arr;
    public int tope;
    private static final int SIZE=20;

    public Pila(){
        this.arr = new Object[SIZE];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem){
        boolean exito;
        if (this.tope+1 >= this.SIZE){
            exito = false;
        } else {
            this.tope++;
            this.arr[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar(){
        boolean exito = false;
        if(!this.esVacia()){
            this.arr[this.tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope(){
        Object elemTope = null;
        if(!esVacia())
            elemTope = this.arr[this.tope];
        return elemTope;
    }

    public boolean esVacia(){
        return this.tope == -1;
    }

    public Pila clone(){
        Pila newPila = new Pila();
        int idx = 0;
        while(idx <= this.tope){
            newPila.apilar(this.arr[idx]);
            idx++;
        }
        return newPila;
    }

    public String toString(){
        String p="";
        int idx = 0;
        while(idx <= this.tope){
            p+=this.arr[idx];
            idx++;
        }
        return p;
    }

    public void vaciar(){
        this.arr = new Object[SIZE];
    }

    public int getSize(){
        return this.SIZE;
    }
}