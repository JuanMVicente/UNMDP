#define MAX 20

typedef struct nodo{
    char dato;
    struct nodo * ant, * sig;} nodo;

typedef nodo * Pnodo;

typedef struct{
    Pnodo pri, ult;} TLista;


void iniciaL(TLista *L);
int vaciaL(TLista L);
void agregaL(TLista *L,char x);
void mostrarL(TLista L);
int palindroma(TLista L);

