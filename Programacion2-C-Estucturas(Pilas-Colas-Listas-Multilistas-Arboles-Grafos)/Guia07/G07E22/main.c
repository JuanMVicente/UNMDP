#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    return 0;
}
//ejercicio 22
int alturaO(TArbol A){
	int izq,der;
	if(A==NULL)
		return -1;
	else{
		izq=1+alturaO(A->izq);
		der=alturaO(A->der);
		if(izq>der)
			return izq;
		else
			return der;
	}
}
//ejercicio 23
int gradoO(TArbol A){
	int izq,der;
	if(A==NULL)
		return 0;
	else{
		izq=gradoO(A->izq);
		der=gradoO(A->der);
		aux=grado(A); //desarrollado mas abajo
		if (izq>der)
			if(izq>aux)
				return izq;
			else
				return aux;
		else
			if(der>aux)
				return der;
			else
				return aux;
	}
}

//ejercicio 24
int alturaMin(TArbol A, int Min){  //Min es K
	int aux=0;
	while(A!=NULL){
		if (alturaO(A)>=Min) //ejercicio 22
			aux++;
		A=A->der;
	}
	return aux;
}

//ejercicio 25

int mayor(TArbol A){
	int izq,der, aux;
	while(A!=NULL){
		izq=mayor(A->izq);
		der=mayor(A->der);
		aux=A->dato;
		if (izq>der)
			if(izq>aux)
				return izq;
			else
				return aux;
		else
			if(der>aux)
				return der;
			else
				return aux;
	}
	else
		return 0;
}

void arregloclaves(TArbol A, int may[], int *n){
	*n=0;
	while(A!=NULL){
		may[*n]=mayor(A->izq);
		if(A->dato>may[*n])
			may[*n]=A->dato;
		(*n)++;
		A=A->der;
	}
	*n=i;
}


//ejercicio 26

int grado(TArbol A){
	int aux=0;
	if(A->izq!=NULL){
		A=A->izq;
		while(A->der!=NULL){
			aux++;
			A=A->der;
		}
	}
	return aux;
}

int gradoKarbol(TArbol A, int K){
	if(A==NULL)
		return 0;
	else{
		return	(grado(A)==K) || gradoKarbol(A->izq, K) || gradoKarbol(A->der, K));
	}
}

int gradoKbosque(TArbol A, int K){
	while(A!=NULL && (gradoKarbol(A->izq,K) || grado(A)==K)){
		A=A->der;
		aux++
	}
	return A==NULL;
}
