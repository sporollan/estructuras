package lineales.dinamicas;


public class Lista {
    private Nodo cabecera;

    public Lista(){

    }

    public boolean insertar(Object obj, int pos){
        boolean exito = false;
        if(cabecera == null)
        {
            cabecera = new Nodo(obj, null);
            exito = true;
        }
        else if (pos == 1)
        {
            Nodo aux = cabecera;
            cabecera = new Nodo(obj, aux);
            exito = true;
        } 
        else
        {
            Nodo headAux = cabecera;
            Nodo aux;

            int index = 2;
            do{
                if(pos == index){
                    aux = new Nodo(obj, headAux.getEnlace());
                    headAux.setEnlace(aux);
                    exito = true;
                }
                headAux = headAux.getEnlace();
                index+=1;
            } while(headAux != null && pos >= index);
        }
        return exito;
    }

    public boolean eliminar(int pos){
        Boolean exito = false;
        if(cabecera == null)
        {
        }
        else if (pos == 1)
        {
            cabecera = cabecera.getEnlace();
            exito = true;
        } 
        else 
        {
            int i = 2;
            Nodo haux = cabecera.getEnlace();
            Nodo prev = cabecera;
            while(haux != null && i <= pos)
            {
                if(i == pos)
                {
                    prev.setEnlace(haux.getEnlace());
                    exito = true;
                }
                prev = haux;
                haux = haux.getEnlace();
                i+=1;
            }
        }
        return exito;
    }

    public Object recuperar(int pos){
        Nodo pointer = cabecera;
        int i = 1;
        while(pointer != null && i != pos)
        {
            pointer = pointer.getEnlace();
            i++;
        }
        return (pointer != null) ? pointer.getElem() : null;
    }

    public int localizar(Object obj){
        Nodo pointer = cabecera;
        int i = 1;
        while(pointer != null && pointer.getElem()!=obj){
            i++;
            pointer = pointer.getEnlace();
        }
        return (pointer != null) ? i : -1;
    }

    public int longitud(){
        Nodo pointer = cabecera;
        int i = 0;
        while(pointer != null){
            i++;
            pointer = pointer.getEnlace();
        }
        return i;
    }

    public boolean esVacia(){
        return cabecera != null;
    }

    public void vaciar(){
        cabecera = null;
    }

    public Lista clone(){
        Lista nl = new Lista();
        nl.cabecera = cloneAux(cabecera, null);
        return nl;
    }

    private Nodo cloneAux(Nodo n, Nodo previo){
        Nodo ret = null;
        if(n != null){
            Nodo newNodo = new Nodo(n.getElem(), null);
            if(previo != null)
                previo.setEnlace(newNodo);
            cloneAux(n.getEnlace(), newNodo);
            ret = newNodo;
        }
        return ret;
    }

    @Override
    public String toString(){
        String s = "[";
        Nodo hAux = cabecera;
        s += hAux.getElem();
        hAux = hAux.getEnlace();
        while(hAux != null){
            s += ", " + hAux.getElem();
            hAux = hAux.getEnlace();
        }
        return s + "]";
    }

}