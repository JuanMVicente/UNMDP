#include <stdio.h>
#include <stdlib.h>
typedef int Tdato;
typedef struct nodo{
    Tdato dato;
    struct nodo * izq, * der;}nodo;

typedef nodo * TArbol;

int main()
{
    printf("Hello world!\n");
    return 0;
}

//ejercicio 19
int arboles(TArbol A){
	if(A!=NULL){
		return 1+arboles(A->der);
	}
}

void arbolesv(TArbol A, int * n){
	while(A!=NULL){
		(*n)++;
		A=A->der;
	}
}
//ejercicio 20
int nodosImpares(TArbol A, int n){
	if(n%2!=0)
		return 1 + nodosImpares(A->izq, n+1) + nodosImpares(A->der, n);
	else
		return nodosImpares(A->izq, n+1) + nodosImpares(A->der, n);
}

//ejercicio 21

void promedio(TArbol A, int k, float *promedio){
	Tdato suma=0;
	int cant=0;
	recorro(A,k,&suma,&cant);
	if (cant!=0)
        *promedio=(float)suma/cant;
}

void recorro(TArbol A, int k, Tdato * suma, int * cant){
    int sumaAux, cantAux;
	if(A!=NULL){
		recorro(A->izq,k,suma,cant);
		recorro(A->der,k,&sumaAux, &cantAux);
		if(k==gradoNodo(A)){// lo puedo dejar así?
			(*suma) = (*suma) + sumaAux + A->dato;
			(*cant) = (*cant) + cantAux + 1;
		}
		else
 			(*suma) = (*suma) + sumaAux;
			(*cant) = (*cant) + cantAux;
	}
    (*suma) = 0;
	(*cant) = 0;
}
int gradoNodo(TArbol A){
	int aux=0;
	if(A->izq!=NULL){
		A=A->izq;
		while(A){
			aux++;
			A=A->der;
		}
	}
}




//ejercicio 22
int altura(TArbol A){
    int der, izq;
    if(A==NULL)
        return -1;
    else{
        izq=1+altura(A->izq);
        der=altura(A->der);
        if(izq>der)
            return izq;
        else
            return der;
    }
}

//ejercicio 23
int gradoA(TArbol A){
    int izq, der, aux;
    if(A==NULL)
        return 0;
    else{
        izq=gradoA(A->izq);
        der=gradoA(A->der);
        aux=grado(A);
        if (izq>der)
            if (izq>aux)
                return izq;
            else
                return aux;
        else
            if (der>aux)
                return der;
            else
                return aux;
    }
}

void gradoA(TArbol A, int *grado, int *gradoA){
    int gradoAux, gradoAaux;
    if(A==NULL){
        *grado=0;
        *gradoA=0;
    }
    else
        gradoA(A->izq,&gradoAux,&gradoAaux);
        gradoA(A->der, grado, gradoA);
        if (gradoAaux>(*gradoA))
            if (gradoAaux>gradoAux)
                (*gradoA)=gradoAaux;
            else
                (*gradoA)=gradoAux;
        else
            if ((*gradoA)<gradoAux)
                (*gradoA)=gradoAux;
        (*grado)++;
}

