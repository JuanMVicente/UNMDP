#include <stdio.h>
#include <stdlib.h>
#include "funciones.h"

int main(){
    int a=11, b=5;
    printf("Producto: %d\n", producto(a,b));
    int c, r;
    divide(a,b,&c,&r);
    printf("Cociente: %d - Resto: %d\n",c,r);
    int v[]={2,5,1,8,6,7,2,3}, n=8;
    printf("Max1: %d\n", maximoc1(v,n-1));
    int m=2;
    maximoc2(v,n-1, &m);
    printf("Max2: %d\n", m);
}

