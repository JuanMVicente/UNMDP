#define MAX 100

typedef float TElementoP;

typedef struct{
    TElementoP Datos[MAX];
    int Tope;} TPila;

void iniciaP(TPila *P){
    (*P).Tope = -1;
}

int vaciaP(TPila P){
    return (P.Tope == -1);
}

TElementoP consultaP(TPila P){
    if (P.Tope != -1)
        return P.Datos[P.Tope];
}

void sacaP(TPila *P, TElementoP x){
    x = (*P).Datos[(*P).Tope];
    (*P).Tope--;

}

void poneP(TPila *P, TElementoP x){
    (*P).Tope++;
    x = (*P).Datos[(*P).Tope];
}

void mostrarP(TPila *P){
    TElementoP x;
    if(!vaciaP(*P)){
        sacaP(P, &x);
        mostrarP(P);
        printf("%d - ",x);
        poneP(P,x);
    }
    else
        printf("P: ");
}
