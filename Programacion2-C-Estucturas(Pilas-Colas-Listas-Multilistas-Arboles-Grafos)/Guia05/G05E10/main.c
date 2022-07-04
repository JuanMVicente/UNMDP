#include <stdio.h>
#include <stdlib.h>
#include "Cola.h"

void grabaCola(TCola *);
void muestraDatos(TCola *);

int main()
{
    TCola C;
    iniciaC(&C);
    grabaCola(&C);
    muestraDatos(&C);
    return 0;
}

void grabaCola(TCola * C){
    FILE * arch;
    TElementoC x;
    arch = fopen("G05E10.txt", "rt");
    if(arch != NULL)
        while(!feof(arch)){
            fscanf(arch,"%s %d %d", x.id, &x.seg, &x.dur);
            poneC(C,x);
        }
}

void muestraDatos(TCola * C){
    TElementoC x;
    unsigned int tf;
    float suma=0, cont=0; // ver como ponerlo en int y poder dividirlo
    if(!vaciaC(*C)){
        sacaC(C,&x);
        tf=x.seg+x.dur;
        printf("%s - T inicio %d - T final %d\n", x.id, x.seg, tf);
    }
    while(!vaciaC(*C)){
        sacaC(C,&x);
        if (tf>x.seg){
            printf("%s - T inicio %d - T final %d\n", x.id, tf, tf+x.dur);
            cont++;
            suma+=tf-x.seg;
            tf+=x.dur;
        }
        else{
            printf("%s - T inicio %d - T final %d\n", x.id, x.seg, x.seg+x.dur);
            tf=x.seg+x.dur;
        }
    }
    printf("Promedio de espera: %5.2f.", (suma/cont));

}

