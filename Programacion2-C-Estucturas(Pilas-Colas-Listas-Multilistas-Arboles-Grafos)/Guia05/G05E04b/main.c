#include <stdio.h>
#include <stdlib.h>
#include "Cola.h"

void muestrasaca(TCola *);

int main()
{
    FILE * arch;
    TCola C;
    float x;

    iniciaC(&C);

    arch = fopen("G05E04b.txt", "rt");
    if(arch!=NULL){
        while((fscanf(arch,"%f",&x))==1)
              poneC(&C,x);
    }

    mostrarC(&C);

    muestrasaca(&C);

    return 0;
}

void muestrasaca(TCola *C){
    TElementoC x;
    printf("\nC: ");
    while(!vaciaC(*C)){
        sacaC(C,&x);
        printf("%5.2f - ",x);
    }
}
