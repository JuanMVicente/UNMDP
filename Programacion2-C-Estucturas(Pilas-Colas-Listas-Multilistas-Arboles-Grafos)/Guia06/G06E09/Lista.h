typedef struct nodo{
 char dato;
 struct nodo * sig;} nodo;

typedef nodo * TLista;


typedef struct nodoD{
    char dato;
    struct nodoD * ant, * sig;} nodoD;

typedef nodoD * Pnodo;

typedef struct{
    Pnodo pri, ult;} TListaD;

void iniciaL(TLista *L);
int vaciaL(TLista L);
void agregaL(TLista *L,char x);
void mostrarL(TLista L);
void iniciaLD(TListaD *L);
void ListaD(TLista L, TListaD * LD);
void agregaLD(TListaD *L,char x);
void mostrarLD(TListaD L);
void iniciaLC(TLista *L);
void agregaLC(TLista *L,char x);
void mostrarLC(TLista L);
