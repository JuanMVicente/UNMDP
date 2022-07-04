#define MAX 25

typedef char TElementoC;

typedef struct nodo {
    TElementoC dato[MAX];
    struct nodo * sig;} nodo;

typedef struct {
    nodo *pri, *ult;} TCola;

void iniciaC (TCola *C);

int vaciaC(TCola C);

void poneC (TCola *C, TElementoC X[MAX]);
void sacaC (TCola *C, TElementoC X[MAX]);
TElementoC consultaC (TCola C);
void mostrarC(TCola *C);
