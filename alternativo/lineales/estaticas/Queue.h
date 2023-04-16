#include <string>
using namespace std;


class Queue
{
    private:
        static const int SIZE = 10;
        string arr[SIZE];
        int head = 0;
        int tail = 0;
    public:
        bool insertar(string elem)
        {
            if((head+1)%SIZE == tail)
            {
                // is full
                return false;
            }
            else
            {
                arr[head] = elem;
                head = (head+1) % SIZE;
            }
            return true;
        }

        bool remover()
        {
            if(head == tail)
            {
                // is empty
                return false;
            }
            else
            {
                arr[tail] = "";
                tail = (tail+1) % SIZE;
            }
            return true;
        }

        string obtener()
        {
            if(head != tail)
            {
                return arr[tail];
            }
            return "";
        }

        string toString()
        {
            string s = "";
            int taux = tail;
            while(taux != head)
            {
                s = s + arr[taux] + " ";
                taux = (taux + 1) % SIZE;
            }
            return s;
        }

        Queue clone()
        {
            Queue q;
            for(int i = 0; i<SIZE; i++)
            {
                q.arr[i] = arr[i];
            }
            q.head = head;
            q.tail = tail;
            return q;
        }
};