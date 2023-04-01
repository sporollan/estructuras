package lineales.estaticas;


public class Cola {
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int SIZE = 10;

    public Cola() {
        this.initArreglo();
    }

    private void initArreglo(){
        this.arreglo = new Object[SIZE];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object obj){
        boolean exito = false;
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;

        if (this.esVacia()) {
            // la cola esta vacia, reporta error
            exito = false;
        } else {
            // al menos hay 1 elemento, avanza frente ( de manera circular)
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1 ) % SIZE;
        }
        return exito;
    }

    public Object obtenerFrente(){
        return this.arreglo[this.frente];
    }

    public boolean esVacia(){
        return false;
    }

    public void vaciar(){
        this.initArreglo();
    }

    public Cola clone(){
        Cola newCola = new Cola();
        return newCola;
    }

    public String toString(){
        String str = "";
        return str;
    }
}

