#include "Node.h"
#include <string>
using namespace std;

class Stack
{
    private:
        Node* top;
    
    public:
        Stack()
        {
            top = NULL;
        }
        bool apilar(string elem)
        {
            if(top == NULL)
            {
                top = new Node();
                top->setElem(elem);
                return true;
            } 
            else
            {
                Node* aux = top;
                top = new Node();
                top->setElem(elem);
                top->setNext(aux);
                return true;
            }
            return false;
        }
        bool desapilar()
        {
            if(top != NULL)
            {
                top = top->getNext();
                return true;
            }
            return false;
        }
        string obtenerTope()
        {
            if(top != NULL)
            {
                return top->getElem();
            }
            return "";
        }
        string toString()
        {
            string s = "";
            Node* taux = top;
            while(taux != NULL)
            {
                s = taux->getElem() + " "+s;
                taux = taux->getNext();
            }
            return s;
        }
        Stack clone()
        {
            Stack c;
            Node* taux = top;
            c.top = cloneAux(taux, NULL);
            return c;
        }
        Node* cloneAux(Node* taux, Node* n)
        {
            if(taux != NULL)
            {
                if(n == NULL)
                {
                    n = new Node();
                    n->setElem(taux->getElem());
                }
                else
                {
                    Node* aux = n;
                    n = new Node();
                    n->setElem(taux->getElem());
                    aux->setNext(n);
                }
                cloneAux(taux->getNext(), n);
                return n;
            }
            return NULL;
        }
};