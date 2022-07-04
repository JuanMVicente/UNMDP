#define MAX 50

typedef int TElementoC;

typedef struct {
    TElementoC datos[MAX];
    int pri, ult; } TCola;


void IniciaC(TCola *C){
    (*C).pri = -1;
    (*C).ult = -1;
}

int VaciaC(TCola C){
    return C.pri == -1;
}

void PoneC(TCola *C, TElementoC x){
    if((*C).ult!= MAX-1){
        if((*C).pri== -1)
            (*C).pri=0;
        (*C).datos[++((*C).ult)] = x;
    }
}

void SacaC(TCola *C, TElementoC *x){
    if(!vaciaC(*C))
        *x = (*C).datos[(*C).pri];
    if((*C).pri == (*C).ult)
        iniciaC(C);
    else
        (*C).pri++;
}

TElementoC ConsultaC(TCola C){
    if (C.pri!=-1)
        return C.datos[C.pri];
}
