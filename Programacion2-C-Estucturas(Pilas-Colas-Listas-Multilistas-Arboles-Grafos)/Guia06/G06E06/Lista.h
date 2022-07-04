#define MAX 20

typedef struct nodito{
        char jugador[30];
        int edad;
        char estado;
        struct nodito * sig;} nodito;

typedef nodito * SubLista;

struct nodo{
        char equipo[20];
        unsigned int puntaje;
        SubLista * sub;
        struct nodo * sig;} nodo;

typedef struct nodo * TLista;
