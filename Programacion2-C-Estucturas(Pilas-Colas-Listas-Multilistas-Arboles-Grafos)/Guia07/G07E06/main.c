#include <stdio.h>
#include <stdlib.h>

typedef struct nodo{
    char cadena[MAX];
    struct nodo * izq, * der;} nodo;

typedef nodo * TArbol;

int main()
{
    printf("Hello world!\n");
    return 0;
}



void longcad(TArbol A, int n, int *l, int *nM){ //n inicializado en 1 // *l inicializado en 0
	if(A!=NULL){
        longcad(A->izq,n+1,l,nM);
		longcad(A->der,n+1,l,nM);
        if(A->cadena[0]=='A' && strlen(A->cadena)>(*l)){
            *l=strlen(A->cadena);
            *nM = n;
        }
    }
}

