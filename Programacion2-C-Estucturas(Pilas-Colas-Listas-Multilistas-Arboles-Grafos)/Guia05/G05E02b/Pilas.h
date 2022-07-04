typedef char TElementoP;

typedef struct nodop{
    TElementoP dato;
    struct nodop *sig;} nodop;

typedef nodop* TPila;

void iniciaP(TPila *P);
int vaciaP(TPila P);
TElementoP consultaP(TPila P);
void sacaP(TPila *P, TElementoP * x);
void poneP(TPila *P, TElementoP x);
