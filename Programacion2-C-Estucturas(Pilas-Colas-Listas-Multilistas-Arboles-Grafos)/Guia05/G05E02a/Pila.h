#define MAX 100

typedef char TElementoP;

typedef struct{
    TElementoP datos[MAX];
    int tope;} TPila;

void iniciaP(TPila *P);
int vaciaP(TPila P);
TElementoP consultaP(TPila P);
void sacaP(TPila *P, TElementoP *x);
void poneP(TPila *P, TElementoP x);
void cadenaP(TPila *P);
