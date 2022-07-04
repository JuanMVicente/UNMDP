#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

void iniciaL(TLista *L){
    *L = NULL;
}
int vaciaL(TLista L){
    return (L==NULL);
}
void agregaLa(TLista *L,int x){
    TLista nuevo;
    nuevo=(TLista)malloc(sizeof(nodo));
    nuevo->sig=(*L);
    nuevo->numero=x;
    (*L) = nuevo;
}
void mostrarL(TLista L){
    while(L!=NULL){
        printf("%d\n",L->numero);
        L=L->sig;
    }
}

void agregaLb(TLista * L,int x){
    TLista nuevo,une=*L;
    nuevo=(TLista)malloc(sizeof(nodo));
    nuevo->sig=NULL;
    nuevo->numero=x;
    if(*L==NULL)
        *L=nuevo;
    else{
        while(une->sig!=NULL)
            une=une->sig;
        une->sig=nuevo;
    }
}

void agregaLc(TLista * L,int x){
    TLista nuevo,act,ant;
    nuevo=(TLista)malloc(sizeof(nodo));
    nuevo->numero=x;
    if(*L==NULL || (*L)->numero>=x){
        nuevo->sig=*L;
        *L=nuevo;
    }
    else{
        ant=NULL;
        act=*L;
        while(act!=NULL && act->numero<x){
            ant=act;
            act=act->sig;
        }
        nuevo->sig=act;
        ant->sig=nuevo;
    }
}
