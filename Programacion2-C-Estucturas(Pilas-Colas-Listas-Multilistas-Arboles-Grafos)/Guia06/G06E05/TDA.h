#define MAX 50

typedef int TElementoP;

typedef struct nodop{
    TElementoP dato;
    struct nodop *sig;} nodop;

typedef nodop *TPila;

typedef int TElementoC;

typedef struct {
    TElementoC datos[MAX];
    int pri, ult; } TCola;

void iniciaP(TPila *P);
int vaciaP(TPila P);
TElementoP consultaP(TPila P);
void sacaP(TPila *P, TElementoP *x);
void poneP(TPila *P, TElementoP x);
void mostrarP(TPila *P);

void iniciaC(TCola *C);
int vaciaC(TCola C);
void poneC (TCola *C, TElementoC X);
void sacaC (TCola *C, TElementoC *X);
TElementoC consultaC (TCola C);
void mostrarC(TCola *C);

