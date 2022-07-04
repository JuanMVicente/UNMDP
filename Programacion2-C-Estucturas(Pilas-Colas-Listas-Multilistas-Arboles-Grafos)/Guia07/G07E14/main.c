#include <stdio.h>
#include <stdlib.h>

typedef int Tdato;

typedef struct nodo{
    Tdato dato;
    struct nodo * izq, * der;}nodo;

typedef nodo * TArbol;

void addArbol(TArbol *A, Tdato x);
int ABB(TArbol A);

int main()
{
    TArbol A=NULL;
    addArbol(&A,7);
    addArbol(&(A->izq),3);
    addArbol(&(A->der),10);
    addArbol(&(A->izq->izq),1);
    addArbol(&(A->izq->der),4);
    addArbol(&(A->der->izq),9);
    addArbol(&(A->der->der),12);

//    printf("%d",A->dato);
//    printf("%d",A->der->dato);
//    printf("%d",A->der->der->dato);
    (ABB(A))? printf("Es ABB"):printf("No es ABB");
    return 0;
}

void addArbol(TArbol *A, Tdato x){
    *A = (TArbol)malloc(sizeof(nodo));
    (*A)->dato=x;
    (*A)->izq=NULL;
    (*A)->der=NULL;
}

int ABB(TArbol A){
    if(A!=NULL){
        if(A->izq==NULL && A->der==NULL){
            return 1;
        }
        else{
            if(A->izq!=NULL && A->der!=NULL){
                if(A->dato < A->izq->dato || A->dato > A->der->dato)
                    return 0;
                else
                    return (ABB(A->izq) && ABB(A->der));
            }
            else{
                if(A->izq==NULL){
                    if(A->dato > A->der->dato)
                        return 0;
                    else
                        return (ABB(A->der));
                    }
                else{//A->der==NULL
                    if(A->dato < A->izq->dato)
                        return 0;
                    else
                        return (ABB(A->izq));
                }
            }
        }
    }
}
