#include <string>
using namespace std;


class Stack
{
    private:
        static const int SIZE = 10;
        int tope;
        string arr[SIZE];

    
    public:
        Stack()
        {
            tope = 0;
        }

        bool apilar(string elem)
        {
            if(tope < SIZE)
            {
                arr[tope] = elem;
                tope++;
                return true;
            }
            return false;
        }

        string toString()
        {
            string s = "";
            for(int i = 0; i < tope; i++)
            {
                s += arr[i] + " ";
            }
            return s;
        }

        bool desapilar()
        {
            if(tope > 0)
            {
                tope -= 1;
                return true;
            }
            return false;
        }

        string obtenerTope()
        {
            if(tope > 0)
            {
                return arr[tope-1];
            }
            return "";
        }

        Stack clone()
        {
            Stack s;
            for(int i = 0; i < tope; i++)
            {
                s.arr[i] = arr[i];
            }
            s.tope = tope;
            return s;
        }
};