#include <string>
#include "Node.h"
using namespace std;


class Queue
{
    private:
        Node* head;
        Node* tail;
    
    public:
        Queue()
        {
            head = NULL;
            tail = NULL;
        }

        bool insertar(string elem)
        {
            if(head == NULL)
            {
                head = new Node(elem, NULL);
                tail = head;
            }
            else
            {
                Node* aux = head;
                head = new Node(elem ,NULL);
                aux->setNext(head);
            }
            return true;
        }

        bool remover()
        {
            if(head != NULL)
            {
                tail = tail->getNext();
                return true;
            }
            return false;
        }

        string obtener()
        {
            if(tail != NULL)
            {
                return tail->getElem();
            }
            return "";
        }

        string toString()
        {
            Node* taux = tail;
            return toStringAux(taux);
        }

        string toStringAux(Node* p)
        {
            if(p != NULL)
            {
                return p->getElem() + " " + toStringAux(p->getNext());
            }
            return "";
        }

        Queue clone()
        {
            Queue q;
            Node* taux = tail;
            q.tail = cloneAux(taux, NULL, q.head);
            return q;
        }

        Node* cloneAux(Node* taux, Node* n, Node* head)
        {
            if(taux != NULL)
            {
                if(n == NULL)
                {
                    n = new Node(taux->getElem(), NULL);
                }
                else
                {
                    Node* aux = new Node(taux->getElem(), NULL);
                    n->setNext(aux);
                    n = aux;
                }
                cloneAux(taux->getNext(), n, head);
                return n;
            }
            else
            {
                head = n;
            }
            return NULL;
        }

};