#include "../../lineales/estaticas/Queue.h"
#include <iostream>
#include <string>
using namespace std;


int main()
{
    cout<<"TEST TEST TEST TEST"<<endl;
    Queue q;

    q.insertar("1");
    q.insertar("2");
    q.insertar("3");
    q.insertar("4");
    q.insertar("5");

    cout<<q.toString()<<endl;
    cout<<q.obtener()<<endl;
    cout<<q.clone().toString()<<endl;

}