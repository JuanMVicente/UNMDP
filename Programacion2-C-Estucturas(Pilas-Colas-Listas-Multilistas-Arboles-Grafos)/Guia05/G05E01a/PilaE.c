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

void sacaP(TPila *P, TElementoP *x){
    if (((*P).Tope) != -1)
        (*x) = (*P).Datos[((*P).Tope)--];
}

void poneP(TPila *P, TElementoP x){
    (*P).Tope++;
    (*P).Datos[(*P).Tope]=x;
}
/*
void mostrarP(TPila *P){
    TElementoP x;
    if(!vaciaP(*P)){
        sacaP(P,&x);
        mostrarP(P);
        printf("%d - ",x); // ver TElementoP
        poneP(P,x);
    }
    else
        printf("P: ");
}*/
