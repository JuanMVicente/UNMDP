#include <stdio.h>
#include <stdlib.h>

typedef float TElementoP;

typedef struct nodop{
    TElementoP dato;
    struct nodop *sig;} nodop;

typedef nodop *TPila;

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

void sacaP(TPila *P, TElementoP *x){
    TPila N;
    if(*P){
        N = *P;
        *x = (*P)->dato;
        *P = (*P)->sig;
        free(N);
    }
}

void poneP(TPila *P, TElementoP x){
    TPila N;
    N = (TPila) malloc(sizeof(nodop));
    N->dato = x;
    N->sig = *P;
    *P=N;
}

/*
void mostrarP(TPila *P){
    TElementoP x;
    if(!vaciaP(*P)){
        sacaP(P,&x);
        mostrarP(P);
        printf("%f - ",x); //ver como es el TElementoP
        poneP(P,x);
    }
    else
        printf("P: ");
}*/
