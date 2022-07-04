#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

void iniciaL(TLista *L){
    L->pri = NULL;
    L->ult = NULL;
}
int vaciaL(TLista L){
    return (L.ult==NULL);
}
void agregaL(TLista *L,char x){
    Pnodo nuevo;
    nuevo=(Pnodo)malloc(sizeof(nodo));
    nuevo->dato=x;
    if (L->pri==NULL){
        nuevo->ant=NULL;
        nuevo->sig=NULL;
        L->pri=nuevo;
        L->ult=nuevo;
    }
    else{
        nuevo->sig=L->ult->sig;
        L->ult->sig=nuevo;
        nuevo->ant=L->ult;;
        L->ult=nuevo;
    }
}
void mostrarL(TLista L){
    do{
        printf("%c\n",L.pri->dato);
        L.pri=L.pri->sig;
    }while(L.pri!=NULL);
}

int palindroma(TLista L){
    while(L.pri<L.ult ){
        if(L.pri->dato==L.ult->dato){
            L.pri=L.pri->sig;
            L.ult=L.ult->ant;
        }
        else
            return 0;
    }
    if (L.pri>=L.ult)
        return 1;
    else
        return 0;
}
