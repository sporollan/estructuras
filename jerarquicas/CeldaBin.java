package jerarquicas;

public class CeldaBin {
    private Object elem;
    private int izquierdo, derecho;
    private boolean enUso;

    public CeldaBin(Object elem, int izq, int der){
        this.elem = elem;
        this.izquierdo = izq;
        this.derecho = der;
        this.enUso = (elem != null);
    }

    public void setElem(Object elem)
    {
        this.elem = elem;
    }

    public void setIzquierdo(int izq){
        this.izquierdo = izq;
    }

    public void setDerecho(int der){
        this.derecho = der;
    }

    public void setEnUso(boolean b){
        this.enUso = b;
    }

    public Object getElem(){
        return this.elem;
    }

    public int getIzquierdo(){
        return this.izquierdo;
    }

    public int getDerecho(){
        return this.derecho;
    }

    public boolean enUso(){
        return this.enUso;
    }
}
