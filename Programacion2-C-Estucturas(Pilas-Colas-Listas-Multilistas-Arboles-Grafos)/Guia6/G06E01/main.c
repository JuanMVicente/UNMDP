#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

int main()
{
    int i=0,n=25,a[]={12,36,54,21,45,21,32,45,12,4,5,12,87,54,12,55,21,54,91,18,22,78,17,16,98};
    TLista L1,L2,L3;
    iniciaL(&L1);
    for(;i<n;i++){
        agregaLa(&L1,a[i]);
    }
    printf("Lista ejercicio a:\n");
    mostrarL(L1);
    iniciaL(&L2);
    for(i=0;i<n;i++){
        agregaLb(&L2,a[i]);
    }
    printf("Lista ejercicio b:\n");
    mostrarL(L2);
    iniciaL(&L3);
    printf("Lista ejercicio c:\n");
    for(i=0;i<n;i++){
        agregaLc(&L3,a[i]);
    }
    printf("Lista ejercicio c:\n");
    mostrarL(L3);
    return 0;
}
