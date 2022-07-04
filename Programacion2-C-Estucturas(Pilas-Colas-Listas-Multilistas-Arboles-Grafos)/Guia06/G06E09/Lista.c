#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

void iniciaL(TLista *L){
    *L = NULL;
}
int vaciaL(TLista L){
    return (L==NULL);
}
void agregaL(TLista *L,char x){
    TLista nuevo;
    nuevo=(TLista)malloc(sizeof(nodo));
    nuevo->sig=(*L);
    nuevo->dato=x;
    (*L) = nuevo;
}

void mostrarL(TLista L){
    while(L!=NULL){
        printf("%c\n",L->dato);
        L=L->sig;
    }
}

void iniciaLD(TListaD *L){
    L->pri = NULL;
    L->ult = NULL;
}

void ListaD(TLista L, TListaD * LD){
    while(L!=NULL){
        agregaLD(LD, L->dato);
        L=L->sig;
    }
}

void agregaLD(TListaD *L,char x){
    Pnodo nuevo;
    nuevo=(Pnodo)malloc(sizeof(nodoD));
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
void mostrarLD(TListaD L){
    do{
        printf("%c\n",L.pri->dato);
        L.pri=L.pri->sig;
    }while(L.pri!=NULL);
}

void ListaC(TLista L, TLista LC){
    while(L!=NULL){
        agregaLC(LC, L->dato);
        L=L->sig;
    }
}
void iniciaLC(TLista *L){
    *L = NULL;
}
void agregaLC(TLista *L,char x){
    TLista nuevo;
    nuevo=(TLista)malloc(sizeof(nodo));
    nuevo->dato=x;
    if (vaciaL(*L)){
        nuevo->sig=nuevo;
        *L=nuevo;
    }
    else{
        nuevo->sig=(*L)->sig;
        (*L)->sig=nuevo;
        *L=nuevo;
    }
}
void mostrarLC(TLista L){
    TLista aux;
    aux=L;
    do{
        aux=aux->sig;
        printf("%c\n",aux->dato);
    }while(aux!=L);
}
