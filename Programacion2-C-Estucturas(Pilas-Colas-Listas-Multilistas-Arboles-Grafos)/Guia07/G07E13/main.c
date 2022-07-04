#include <stdio.h>
#include <stdlib.h>
#define MAX 20

typedef char Tdato;
typedef struct nodo{
    Tdato dato;
    struct nodo * izq,* der;}nodo;

typedef nodo * TArbol;

void Inserta (TArbol *A, Tdato X);
void arreglo(TArbol A, char v[MAX],int *n);
void muestraarreglo(char v[MAX], int n);

int main()
{
    TArbol A=NULL;
    int n=0;
    char x,v[MAX];
    printf("Ingrese dato(0 para terminar): ");
    scanf(" %c",&x);
    while(x!='0'){
        Inserta(&A,x);
        printf("Ingrese dato(0 para terminar): ");
        scanf(" %c",&x);
    }
    arreglo(A,v,&n);
    muestraarreglo(v,n);
    return 0;
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

void arreglo(TArbol A, char v[MAX],int *n){
    if(A!=NULL){
        arreglo(A->der,v,n);
        v[*n]=A->dato;
        (*n)++;
        arreglo(A->izq,v,n);
    }
}

void muestraarreglo(char v[MAX], int n){
    int i=0;
    printf("Arreglo: ");
    for(;i<n;i++)
        printf("%c -",v[i]);
}
