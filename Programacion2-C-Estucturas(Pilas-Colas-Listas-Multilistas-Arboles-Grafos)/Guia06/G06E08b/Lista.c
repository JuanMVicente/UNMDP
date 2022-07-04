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
    TLista nuevo, aux=*L;
    nuevo=(TLista)malloc(sizeof(nodo));
    nuevo->dato=x;
    if (vaciaL(*L)){
        nuevo->sig=nuevo;
        *L=nuevo;
    }
    else{
        while(aux->sig!=*L)
            aux=aux->sig;
        aux->sig=nuevo;
        nuevo->sig=*L;
    }
}
void mostrarL(TLista L){
    TLista aux;
    aux=L;
    do{
        printf("%c\n",aux->dato);
        aux=aux->sig;
    }while(aux!=L);
}

int vocales(TLista L){
    int auxc=0;
    TLista aux=L;
    do{
        if(aux->dato == 'a' || aux->dato == 'e' || aux->dato == 'i' || aux->dato == 'o' || aux->dato == 'u')
            auxc++;
        aux=aux->sig;
    }while(L!= aux);
    return auxc;
}

int ordenada(TLista L){
    TLista aux=L;
    if(!vaciaL(L) && L!=L->sig){
        while(aux->sig!=L && aux->dato <= aux->sig->dato)
            aux=aux->sig;
        if(aux->sig==L)
            return 1;
        else
            return 0;
    }
    return 1;
}

void eliminar(TLista *L,int x){
    TLista elim=*L, aux;
    int i=1;
    if(!vaciaL(*L)){
        for(;i<x;i++){
            aux=elim;
            elim=elim->sig;
        }
        if(elim == *L){
            *L = (*L)->sig;
            aux = *L;
            while(aux->sig != elim)
                aux=aux->sig;
            aux->sig=*L;
        }
        else{
            aux->sig=elim->sig;
        }
        printf("Saco %c\n",elim->dato);
        free(elim);
    }
    else{
        printf("\nLista vacia.");
    }
}
