#include "Colas.h"

void iniciaC(TCola *C){
    (*C).pri = -1;
    (*C).ult = -1;
}

int vaciaC(TCola C){
    return C.pri == -1;
}

void poneC(TCola *C, TElementoC x){
    if((*C).ult!= MAX-1){
        if((*C).pri== -1)
            (*C).pri=0;
        (*C).datos[++((*C).ult)] = x;
    }
}

void sacaC(TCola *C, TElementoC *x){
    if(!vaciaC(*C))
        *x = (*C).datos[(*C).pri];
    if((*C).pri == (*C).ult)
        iniciaC(C);
    else
        (*C).pri++;
}

TElementoC consultaC(TCola C){
    if (C.pri!=-1)
        return C.datos[C.pri];
}
void mostrarC(TCola *C){
    TElementoC x;
    printf("\nC: ");
    x=100;
    poneC(C,x);
    sacaC(C,&x);
    while(x!=100){
        printf("%d - ", x);
        poneC(C,x);
        sacaC(C,&x);
    }
}

