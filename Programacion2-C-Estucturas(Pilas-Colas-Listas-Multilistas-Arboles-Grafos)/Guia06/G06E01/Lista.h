typedef struct nodo{
 int numero;
 struct nodo * sig;} nodo;

typedef nodo * TLista;


void iniciaL(TLista *L);
int vaciaL(TLista L);
void agregaLa(TLista *L,int x);
void mostrarL(TLista L);
void agregaLb(TLista * L,int x);
void agregaLc(TLista * L,int x);
