#include "pila.h"
#include <stdlib.h>

void iniciaP(TPila *P){
    (*P).tope = -1;
}

int vaciaP(TPila P){
    return (P.tope == -1);
}

TElementoP consultaP(TPila P){
    if ((P.tope) != -1)
        return P.datos[P.tope];
}

void sacaP(TPila *P, TElementoP *x){
    if (((*P).tope) != -1){
        (*x) = (*P).datos[(*P).tope];
        ((*P).tope)--;
    }
}

void poneP(TPila *P, TElementoP x){
    if(((*P).tope)!= MAX-1 ){
        ((*P).tope)+=1;
        (*P).datos[(*P).tope] = x;
    }
}

void cadenaP(TPila *P){
    (*P).datos[(*P).tope+1]='\0';
}
