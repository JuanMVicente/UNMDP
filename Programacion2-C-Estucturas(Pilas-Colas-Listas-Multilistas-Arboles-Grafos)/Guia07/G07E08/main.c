#include <stdio.h>
#include <stdlib.h>

typedef struct nodo{
    char dato[20];
    struct nodo *izq, * der;} nodo;
typedef nodo * TArbol;

void addnodo(TArbol* a, char e[]);
void muestra(TArbol A, int i, int n);

int main()
{
    TArbol a;
    addnodo(&a, "ion");
    addnodo(&a->izq, "ion");
    addnodo(&a->izq->izq, "ion");
    addnodo(&a->izq->der, "luis");
    addnodo(&a->izq->izq->izq, "ion");
    addnodo(&a->izq->izq->der, "seba");
    addnodo(&a->izq->der->der, "luis");
    addnodo(&a->izq->der->izq, "martin");
    addnodo(&a->der, "juan");
    addnodo(&a->der->der, "juan");
    addnodo(&a->der->izq, "aitor");
    addnodo(&a->der->der->izq, "juan");
    addnodo(&a->der->der->der, "vale");
    addnodo(&a->der->izq->der, "aitor");
    addnodo(&a->der->izq->izq, "asier");

    printf("Ganador\n");
    muestra(a,1,1);
    printf("Finalistas\n");
    muestra(a,1,2);
    printf("Semifinalistas\n");
    muestra(a,1,3);
    printf("Todos\n");
    muestra(a,1,4);
}


void addnodo(TArbol* a, char e[]) {
    *a = (TArbol)malloc(sizeof(nodo));
    strcpy((*a)->dato, e);
    (*a)->izq = NULL;
    (*a)->der = NULL;
}

void muestra(TArbol A, int i, int n){
    if (A!=NULL){
            if (n==i)
                printf("%s\n",A->dato);
            else{
                muestra(A->der,i+1,n);
                muestra(A->izq,i+1,n);
            }
    }
}
