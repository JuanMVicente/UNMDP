typedef struct nodo{
    int dato;
    struct nodo * sig;} nodo;

typedef nodo * TLista;

void Genera_pi2(TLista *l, TLista *li, TLista *lp);
void listaV(TLista * l, int x);
void muestraL(TLista l);
