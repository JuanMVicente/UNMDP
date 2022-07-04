#include <stdio.h>
#include <stdlib.h>
#include "TDA.h"

void iniciaC(TCola *C){
    (*C).pri=-1;
    (*C).ult=-1;
}

int vaciaC(TCola C){
 return (C.pri==-1);
}

void poneC (TCola *C, TElementoC X) {
    if (!((*C).ult==49 && (*C).pri==0 || (*C).ult+1==(*C).pri)) {
        if ((*C).pri==-1){
            (*C).pri = 0;
            (*C).ult = 0;
            }
        else
            if ((*C).ult == 49)
                (*C).ult = 0;
            else
                (*C).ult += 1;
        (*C).datos[(*C).ult]=X;
    }
}

void sacaC (TCola *C, TElementoC *X) {
    if ((*C).pri != -1) {
        *X = (*C).datos[(*C).pri];
    if ((*C).pri == (*C).ult)
        iniciaC(C);
    else
        if ((*C).pri == 49)
            (*C).pri = 0;
        else
            (*C).pri += 1;
    }
}


TElementoC consultaC (TCola C){
    if (C.pri !=-1)
        return (C.datos[C.pri]);
}

void mostrarC(TCola *C){
    TElementoC x;
    printf("\nC: ");
    x=100;
    poneC(C,x);
    sacaC(C,&x);
    while(x!=100){
        printf("%d - ", x);    // ver TElementoC
        poneC(C,x);
        sacaC(C,&x);
    }
}
