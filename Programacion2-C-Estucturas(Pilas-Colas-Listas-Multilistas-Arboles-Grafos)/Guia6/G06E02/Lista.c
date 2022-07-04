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

int vocales(TLista L){
    int aux=0;
    while(L != NULL){
            if(L->dato == 'a' || L->dato == 'e' || L->dato == 'i' || L->dato == 'o' || L->dato == 'u')
                aux++;
            L=L->sig;
        }
    return aux;
}

int ordenada(TLista L){
    TLista ant;
    if(L!=NULL){
        ant=L;
        L=L->sig;
        while(L!=NULL && L->dato > ant->dato){
            ant=L;
            L=L->sig;
        }
        if(L==NULL)
            return 1;
    }
    return 0;
}
void eliminar(TLista *L,int x){
    int i=1;
    TLista act=*L,ant;
    if(x==1)
        *L=(*L)->sig;
    else{
        for(;i<x;i++){
            ant=act;
            act=act->sig;
        }
        ant->sig = act->sig;
    }
    printf("Saco %c\n",act->dato);
    free(act);
}
