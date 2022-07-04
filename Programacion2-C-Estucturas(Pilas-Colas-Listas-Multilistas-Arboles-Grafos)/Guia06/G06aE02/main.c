#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

void Genera_pi(TLista *l, TLista *li, TLista *lp);

int main()
{
    int a[10]={1,3,4,6,7,9,10,11,11,13}, i=9;
    TLista l=NULL,li=NULL,lp=NULL;

    for(;i>-1;i--)
        listaV(&l,a[i]);
    muestraL(l);

    Genera_pi2(&l,&li,&lp);
    muestraL(l);
    muestraL(li);
    muestraL(lp);


}

void Genera_pi(TLista *l, TLista *li, TLista *lp){
    TLista aux, ultp;
    //aux=*l;
    //if ((*l)->sig)
    //    *l=(*l)->sig;
    while (*l){
        aux=*l; //aca cambie los de abajo
        *l=(*l)->sig; //aca cambie los de abajo
        if (aux->dato%2){//impar
            aux->sig=*li;
            *li=aux;
        }
        else{//par
            if (*lp==NULL){
                aux->sig=NULL;
                *lp=aux;
            }
            else{
                aux->sig=NULL;
                ultp->sig=aux;
            }
            ultp=aux;
        }
    //aux=*l;
    //*l=(*l)->sig;
    }
}

