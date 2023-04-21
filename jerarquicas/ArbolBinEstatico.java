package jerarquicas;


public class ArbolBinEstatico {
    private static final int SIZE = 20;
    private CeldaBin[] arbol;
    private int raiz;

    public ArbolBinEstatico()
    {
        arbol = new CeldaBin[SIZE];
        for(int i = 0; i < SIZE; i++)
        {
            arbol[i] = new CeldaBin(null,2*i+1 , 2*i+2);
        }
        raiz = -1;
    }

    @Override
    public String toString()
    {
        return toStringAux(0);
    }

/* */
    public String toStringAux(int celda){
        String s = "";
        if(celda >= SIZE || arbol[celda].getElem() == null)
            return "";
        else
            s += arbol[celda].getElem();
        return s + " " + arbol[2*celda+1].getElem() + " " + arbol[2*celda+2].getElem() + "\n" + toStringAux(2*celda+1) + toStringAux(2*celda+2);
    }
/* */

    public boolean insertar(Object elem, Object padre, char lugar){
        boolean exito = false;
        if(raiz == -1)
        {
            exito = true;
            arbol[0].setElem(elem);
            raiz = 0;
        } 
        else 
        {
            exito = insertarAux(elem, padre, lugar, 0);
        }
        return exito;
    }

    public boolean insertarAux(Object elem, Object padre, char lugar, int idx){
        int hijo;
        boolean exito = false;
        if(padre == arbol[idx].getElem())
        {
            if(lugar == 'L')
            {
                hijo = 2*idx+1;
            }
            else
            {
                hijo = 2*idx+2;
            }

            if(!arbol[hijo].enUso())
            {
                exito = true;
                arbol[hijo].setElem(elem);
            }
        } 
        else 
        {
            exito = insertarAux(elem, padre, lugar, 2*idx+1);
            if(!exito)
                exito = insertarAux(elem, padre, lugar, 2*idx+2);
        }
        return exito;
    }

    public ArbolBinEstatico clone()
    {
        ArbolBinEstatico a = new ArbolBinEstatico();
        for(int i = 0; i < arbol.length; i++)
        {
            a.arbol[i] = arbol[i];
        }
        a.raiz = this.raiz;
        return a;
    }



}
