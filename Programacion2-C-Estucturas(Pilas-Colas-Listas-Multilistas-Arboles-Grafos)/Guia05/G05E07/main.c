#include <stdio.h>
#include <stdlib.h>
#include "Pila.h"

void escribeP(TPila *);
void cambiasigno(TPila *);

int main()
{
    TPila P;
    iniciaP(&P);
    escribeP(&P);
    mostrarP(&P);
    cambiasigno(&P);
    printf("\nSigno Cambiado: \n");
    mostrarP(&P);
    return 0;
}

void escribeP(TPila *P){
    TElementoP x;
    int n,i=0;
    printf("Cuantos: ");
    scanf("%d", &n);
    for(;i<n;i++){
        printf("\n%d - ",i+1);
        scanf("%f",&x);
        poneP(P,x);
    }
}

void cambiasigno(TPila *P){
    TElementoP x;
    if(!vaciaP(*P)){
        sacaP(P,&x);
        cambiasigno(P);
        x*=-1;
        poneP(P,x);
    }
}
