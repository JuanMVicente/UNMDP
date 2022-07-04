#include <stdio.h>
#include <stdlib.h>

typedef struct nodo{
    int clave;
    struct nodo * izq, * der;} nodo;

typedef nodo * TArbol;


int main()
{
    printf("Hello world!\n");
    return 0;
}

int sumaMult3(TArbol A){
    if (A!=NULL){
        if(A->clave%3!=0)
            return sumaMult3(A->izq) + sumaMult3(A->der);
        else
            return A + sumaMult3(A->izq) + sumaMult3(A->der);
    }
}

int hojas(TArbol A){
    if(A!=NULL){
        if(A->izq==NULL && A->der==NULL)
            return 1 + hojas(A->izq) + hojas(A->der);
        else
            return hojas(A->izq) + hojas(A->der);
    }
}

int esta(TArbol A, int x){
    if (A!=NULL){
        if(A->clave == x)
            return 1;
        else
            return esta(A->izq, x) || esta(A->der, x);
    }
}
