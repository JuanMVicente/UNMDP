#include <stdio.h>
#include <stdlib.h>
typedef int Tdato;

typedef struct nodo{
    Tdato dato;
    struct nodo * izq, *der;} nodo;

typedef nodo * TArbol;

void insertaABB(TArbol *A, Tdato x);
void muestraordenado(TArbol A);

int main()
{
    TArbol A=NULL;
    int x;

    printf("Ingrese nuevo valor (-99 salir): ");
    scanf("%d",&x);
    while(x!=-99){
        insertaABB(&A,x);
        printf("Ingrese nuevo valor (-99 salir): ");
        scanf("%d",&x);
    }
    muestraordenado(A);
    return 0;
}

void insertaABB(TArbol *A, Tdato x){
    TArbol actA, antA, nuevo;
    nuevo=(TArbol) malloc(sizeof(nodo));
    nuevo->dato=x;
    nuevo->izq=NULL;
    nuevo->der=NULL;
    if(*A==NULL){
        *A=nuevo;
    }
    else{
        actA=*A;
        while(actA!=NULL){
            if(actA->dato<x){
                antA=actA;
                actA=actA->der;
            }
            else{
                antA=actA;
                actA=actA->izq;
            }
        }
        if(antA->dato<x)
            antA->der=nuevo;
        else
            antA->izq=nuevo;

    }
}

void muestraordenado(TArbol A){
    if(A!=NULL){
        muestraordenado(A->izq);
        printf("%d - ",A->dato);
        muestraordenado(A->der);
    }
}
