#include<string>
using namespace std;

class Node
{
    private:
        Node* next;
        string elem;
    public:
        Node()
        {
            next = NULL;
            elem = "";
        }

        Node(string elem, Node* next)
        {
            this->next = next;
            this->elem = elem;
        }
        void setNext(Node* next)
        {
            this->next = next;
        }
        Node* getNext()
        {
            return this->next;
        }
        void setElem(string elem)
        {
            this->elem = elem;
        }
        string getElem()
        {
            return this->elem;
        }
};