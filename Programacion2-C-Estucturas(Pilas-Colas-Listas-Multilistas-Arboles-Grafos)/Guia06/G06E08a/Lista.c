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

int vocales(TLista L){
    int aux=0;
    do{
        if(L.pri->dato == 'a' || L.pri->dato == 'e' || L.pri->dato == 'i' || L.pri->dato == 'o' || L.pri->dato == 'u')
            aux++;
        L.pri=L.pri->sig;
    }while(L.pri!= NULL);
    return aux;
}

int ordenada(TLista L){
    if(!vaciaL(L) && L.pri != L.ult){
    L.pri=L.pri->sig;
    while(L.pri!=NULL && L.pri->ant->dato <= L.pri->dato)
            L.pri=L.pri->sig;
        if(L.pri==NULL)
            return 1;
        else
            return 0;
    }
    return 1;
}
void eliminar(TLista *L,int x){
    Pnodo aux;
    aux= L->pri;
    int i=1;
    if(!vaciaL(*L)){
        for(;i<x;i++)
            aux=aux->sig;
        if(aux == L->pri){
            L->pri=L->pri->sig;
            L->pri->ant=NULL;
        }
        else{
            if(aux == L->ult){
                L->ult=L->ult->ant;
                L->ult->sig=NULL;
            }
            else{
                aux->ant->sig=aux->sig;
                aux->sig->ant=aux->ant;
            }
        }
        printf("Saco %c\n",aux->dato);
        free(aux);
    }
    else{
        printf("\nLista vacia.");
    }
}
