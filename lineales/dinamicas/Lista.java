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
        return null;
    }

    public int localizar(Object obj){
        return 0;
    }

    public int longitud(){
        return 0;
    }

    public boolean esVacia(){
        return false;
    }

    public void vaciar(){

    }

    public Lista clone(){
        return null;
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