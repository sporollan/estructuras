#include <iostream>
#include "../../lineales/dinamicas/Stack.h"

using namespace std;


bool esCapicua(Stack s)
{
    Stack inv;
    Stack c = s.clone();
    string elem = c.obtenerTope();
    bool capicua = true;

    while(elem != "")
    {
        inv.apilar(elem);
        c.desapilar();
        elem = c.obtenerTope(); 
    }


    Stack c2 = s.clone();
    bool desapilar = true;
    while(capicua && desapilar)
    {
        capicua = (inv.obtenerTope() == c2.obtenerTope());
        desapilar = (inv.desapilar() && c2.desapilar());
    }

    return capicua;
}


int main()
{
    Stack s;

    s.apilar("1");
    s.apilar("2");
    s.apilar("3");

    cout<<s.toString()<<endl;
    cout<<s.clone().toString()<<endl;
    cout<<s.obtenerTope()<<endl;

    s.desapilar();

    cout<<s.toString()<<endl;
    cout<<s.obtenerTope()<<endl;
    cout<<esCapicua(s)<<endl;

    s.apilar("1");

    cout<<s.toString()<<endl;
    cout<<s.obtenerTope()<<endl;
    cout<<esCapicua(s)<<endl;

};