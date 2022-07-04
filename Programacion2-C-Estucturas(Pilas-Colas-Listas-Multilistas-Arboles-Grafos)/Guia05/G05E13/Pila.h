#define MAX 50

typedef char TElementoP;

typedef struct{
    TElementoP Datos[MAX];
    int Tope;} TPila;

void iniciaP(TPila *P);
int vaciaP(TPila P);
TElementoP consultaP(TPila P);
void sacaP(TPila *P, TElementoP *x);
void poneP(TPila *P, TElementoP x);
void mostrarP(TPila *P);
