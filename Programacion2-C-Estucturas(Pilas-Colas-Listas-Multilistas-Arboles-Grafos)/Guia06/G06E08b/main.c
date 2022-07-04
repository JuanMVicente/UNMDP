#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

int main()
{
    int i=0,n=10,x;
    char a[]={'a','d','f','g','o','p','s','u','v','z'};
    TLista L1,L2;
    iniciaL(&L1);
    iniciaL(&L2);
    for(;i<n;i++){
        agregaL(&L1,a[i]);
    }
    for(i=9;i>-1;i--){
        agregaL(&L2,a[i]);
    }

    printf("Lista:\n");
    mostrarL(L1);
    (ordenada(L1)) ? printf("Ordenada\n") : printf("Desordenada\n");
    printf("Vocales: %d\n", vocales(L1));
    printf("Lista:\n");
    mostrarL(L2);
    (ordenada(L2)) ? printf("Ordenada\n") : printf("Desordenada\n");
    printf("Vocales: %d\n", vocales(L2));
    printf("Posicion a Eliminar: ");
    scanf("%d",&x);
    eliminar(&L2,x);
    mostrarL(L2);
    return 0;
}
