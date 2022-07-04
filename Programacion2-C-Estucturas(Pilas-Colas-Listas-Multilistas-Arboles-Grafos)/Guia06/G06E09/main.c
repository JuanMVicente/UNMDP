#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

int main()
{
    int i=0,n=10;
    char a[]={'a','d','g','m','o','p','s','u','v','z'};
    TLista L,LC;
    TListaD LD;
    iniciaL(&L);
    for(;i<n;i++){
        agregaL(&L,a[i]);
    }
    printf("Lista: \n");
    mostrarL(L);
    iniciaLD(&LD);
    ListaD(L,&LD);
    printf("Lista Doble: \n");
    mostrarLD(LD);

    iniciaLC(&LC);
    ListaC(L,&LC);
    printf("Lista Circular: \n");
    mostrarLC(LC);


    return 0;
}
