#define MAX 25

typedef struct{
    char nombre[MAX];} TElementoP;

typedef struct nodop{
    TElementoP dato;
    struct nodop *sig;} nodop;

typedef nodop *TPila;

void iniciaP(TPila *P);

int vaciaP(TPila P);

TElementoP consultaP(TPila P);

void sacaP(TPila *P, TElementoP x[MAX]);

void poneP(TPila *P, TElementoP x[MAX]);

void mostrarP(TPila *P);
