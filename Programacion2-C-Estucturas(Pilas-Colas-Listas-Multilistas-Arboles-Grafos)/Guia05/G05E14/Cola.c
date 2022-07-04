#include <stdio.h>
#include <stdlib.h>
#include "Cola.h"

void iniciaC (TCola *C){
    (*C).pri=NULL;
    (*C).ult=NULL;
}

int vaciaC(TCola C){
    return (C.pri==NULL);
}

void poneC (TCola *C, TElementoC X[MAX]) {
    nodo * aux;
    aux = (nodo *) malloc (sizeof(nodo));
    strcpy(aux->dato,X);
    aux->sig = NULL;
    if ((*C).pri==NULL)
        (*C).pri=aux;
    else
        (*C).ult->sig=aux;
    (*C).ult=aux;
}

void sacaC (TCola *C, TElementoC X[MAX]){
    nodo * aux;
    if ((*C).pri !=NULL) {
        aux = (*C).pri;
        strcpy(X,aux->dato);
        (*C).pri = (*C).pri->sig;
        if ((*C).pri == NULL)
            (*C).ult = NULL;
        free(aux);
    }
}

TElementoC consultaC (TCola C){
    if (C.pri !=NULL)
        return C.pri->dato;
}

void mostrarC(TCola *C){
    TElementoC x[MAX], y[]="xxx";
    printf("\nC:\n");
    poneC(C,y);
    sacaC(C,x);
    while(strcmp(x,y)){
        printf("%s", x);    // ver TElementoC
        poneC(C,x);
        sacaC(C,x);
    }
}


