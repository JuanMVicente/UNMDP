#include <stdio.h>
#include <stdlib.h>
#include "Cola.h"

void muestrasaca(TCola * C);

int main()
{
    TCola C;
    float x;
    FILE * arch;
    iniciaC(&C);
    arch=fopen("G05E04a.txt", "rt");
    if(arch!=NULL){
        fscanf(arch,"%f",&x);
        while(!feof(arch)){
            poneC(&C,x);
            fscanf(arch,"%f",&x);
        }
    }
    mostrarC(&C);
    muestrasaca(&C);

    return 0;
}

void muestrasaca(TCola * C){
    TElementoC x;
    printf("\nC: ");
    while(!vaciaC(*C)){
        sacaC(C,&x);
        printf("%5.2f - ",x);

    }
}
