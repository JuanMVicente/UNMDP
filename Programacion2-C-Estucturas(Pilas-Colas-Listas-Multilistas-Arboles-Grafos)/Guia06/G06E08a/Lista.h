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
int vocales(TLista L);
int ordenada(TLista L);
void eliminar(TLista *L,int x);

