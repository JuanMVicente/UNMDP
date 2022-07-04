#include <stdio.h>
#include <stdlib.h>
#include "Pila.h"

void iniciaP(TPila *P){
    *P = NULL;
}

int vaciaP(TPila P){
    return (P == NULL);
}

TElementoP consultaP(TPila P){
    if (P)
        return P->dato;
}

void sacaP(TPila *P, TElementoP x[MAX]){
    TPila N;
    if(*P){
        N = *P;
        strcpy(x,(*P)->dato);
        *P = (*P)->sig;
        free(N);

    }
}

void poneP(TPila *P, TElementoP x[MAX]){
    TPila N;
    N = (TPila) malloc(sizeof(nodop));
    strcpy(N->dato,x);
    N->sig =*P;
    *P=N;
}

void mostrarP(TPila *P){
    TElementoP x[MAX];
    if(!vaciaP(*P)){
        sacaP(P,x);
        mostrarP(P);
        printf("%s",x); //ver como es el TElementoP
        poneP(P,x);
    }
    else
        printf("P:\n");
}
