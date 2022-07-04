#include <stdio.h>
#include <stdlib.h>

typedef int TElememtoA;
typedef struct nodo{
        TElememtoA dato;
        struct nodo *izq;
        struct nodo *der;
} NODO;
typedef NODO * arbol;


void addnodo(arbol* a, TElememtoA e);
void sumaej7(arbol , int *, int , int );

int main(){
 arbol a;
 int x, suma;
 /* carga arbol ejemplo. Ej 1 */
 addnodo(&a, 5);
 addnodo(&a->izq, 8);
 addnodo(&a->izq->izq, 3);
 addnodo(&a->izq->der, 6);

 addnodo(&a->der, 4);
 addnodo(&a->der->izq, 1);
 addnodo(&a->der->izq->der, 2);

 printf("Elija un nivel: ");
 scanf("%d",&x);
 suma=0;
 sumaej7(a,&suma,1,x);
 printf("La suma es: %d", suma);
 return 0;

}

void addnodo(arbol* a, TElememtoA e) {
    *a = (arbol)malloc(sizeof(NODO));
    (*a)->dato = e;
    (*a)->izq = NULL;
    (*a)->der = NULL;
}


void sumaej7(arbol A, int *suma, int i, int n){ //i inicializado en 1// *suma inicializado=0;
    if (A!=NULL){
        sumaej7(A->izq,suma,i+1,n);
        sumaej7(A->der,suma,i+1,n);
        if (i==n && ((A->izq==NULL && A->der!=NULL) || (A->izq!=NULL && A->der==NULL)))
            (*suma)+=A->dato;
    }
}
