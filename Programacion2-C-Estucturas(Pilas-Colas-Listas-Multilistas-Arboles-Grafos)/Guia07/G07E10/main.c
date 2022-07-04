#include <stdio.h>
#include <stdlib.h>
typedef int Tdato;
typedef struct nodo{
    Tdato dato;
    struct nodo * izq,* der;}nodo;

typedef nodo * TArbol;

void Inserta (TArbol *A, Tdato X);
int busca(TArbol a, Tdato x);
Tdato minimo(TArbol A);
void minimov(TArbol A, Tdato *x);
int dentrorango(TArbol A, Tdato x, Tdato y);
void dentrorangov(TArbol A, Tdato x, Tdato y, int *n);

int main()
{
    int x,y,z;
    TArbol A=NULL;
    printf("Ingrese dato(-99 para terminar): ");
    scanf("%d",&x);
    while(x!=-99){
        Inserta(&A,x);
        printf("Ingrese dato(-99 para terminar): ");
        scanf("%d",&x);
    }
    printf("\n%d", A->dato);
    printf("\n%d", A->izq->dato);
    printf("\n%d", A->der->dato);

    printf("\nCual desea buscar: ");
    scanf("%d",&x);
    while(x!=-99){
        if (busca(A,x))
            printf("si");
        else
            printf("no");
        printf("\nCual desea buscar: ");
        scanf("%d",&x);
    }
    printf("\nEl valor minimo es: %d", minimo(A));
    minimov(A,&x);
    printf("\nEl valor minimo es: %d", x);
    printf("\nCota inferior: ");
    scanf("%d",&x);
    printf("\nCota superior: ");
    scanf("%d",&y);
    dentrorangov(A,x,y,&z);
    printf("\nLa cantidad de valores es: %d", dentrorango(A,x,y));
    printf("\nLa cantidad de valores es: %d", z);

}


void Inserta (TArbol *A, Tdato X) {
    if (*A == NULL) {
        *A = (TArbol) malloc (sizeof (nodo));
        (*A)->dato = X;
        (*A)->der = NULL;
        (*A)->izq = NULL;
}
    else
        if (X>(*A)->dato)
            Inserta(&((*A)->der), X);
        else
            Inserta(&((*A)->izq), X);
}


int busca(TArbol a, int x) {
 if (a == NULL)
    return 0;
 else
    if(x == a->dato)
        return 1;
    else
        if(x > a->dato)
            return busca(a->der, x);
        else
            return busca(a->izq, x);
}

Tdato minimo(TArbol A){
    if(A->izq==NULL)
        return A->dato;
    else
        return minimo(A->izq);
}

void minimov(TArbol A, Tdato *x){
    if(A->izq==NULL)
        *x=A->dato;
    else
        minimov(A->izq,x);
}

int dentrorango(TArbol A, Tdato x, Tdato y){
    if (A==NULL)
        return 0;
    else
        if(A->dato>x && A->dato<y)
            return 1 + dentrorango(A->izq,x,y) + dentrorango(A->der,x,y);
        else
            if (A->dato<x)
                return dentrorango(A->der,x,y);
            else
                return dentrorango(A->izq,x,y);
}

void dentrorangov(TArbol A, Tdato x, Tdato y, int *n){
    int der, izq;
    if (A!=NULL){
        if(A->dato>x && A->dato<y){
            dentrorangov(A->izq,x,y,&izq);
            dentrorangov(A->der,x,y,&der);
            (*n)=1+der+izq;
        }
        if (A->dato<x)
            dentrorangov(A->der,x,y,&der);
        else
            dentrorangov(A->izq,x,y,&izq);
    }
    else
        *n=0;
}
