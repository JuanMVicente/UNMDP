#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

void Genera_pi2(TLista *l, TLista *li, TLista *lp){
    TLista aux,ultp;
    while(*l){
        aux=*l;
        *l=(*l)->sig;
        if(aux->dato%2){
            aux->sig= *li;
            *li=aux;
            }

        else{
            if(*lp==NULL){
                aux->sig=NULL;
                *lp=aux;
            }
            else{
                aux->sig=NULL;
                ultp->sig=aux;
            }
            ultp=aux;
            }
        }
}

void listaV(TLista *l, int x){
    TLista nuevo;
    nuevo = (TLista)malloc(sizeof(nodo));
    nuevo->dato=x;
    nuevo->sig=*l;
    *l=nuevo;
}

void muestraL(TLista l){
    printf("\nLista:");
    if (!l)
        printf(" Esta vacia.");
    else
        while(l!=NULL){
            printf(" %d",l->dato);
            l=l->sig;
        }
}
