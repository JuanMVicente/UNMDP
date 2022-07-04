#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct nodo{
    char dato[20];
    struct nodo *izq, * der;} nodo;
typedef nodo * TArbol;

void addnodo(TArbol* a, char e[]);
int altura(TArbol A);
void alturav(TArbol A, int *n);
int longcad(TArbol A);
void longcadv(TArbol A, int *n);
int hderecho(TArbol A);
void hderechov(TArbol A, int *n);


int main()
{
    TArbol a;
    int n;
    addnodo(&a, "ionchi");
    addnodo(&a->izq, "luisma");
    addnodo(&a->izq->izq, "iker");
    addnodo(&a->izq->der, "otro");
    addnodo(&a->izq->der->der, "bianca");
    addnodo(&a->izq->der->der->der, "bianca");
    addnodo(&a->der, "sebastian");
    addnodo(&a->der->izq, "roberto");
    addnodo(&a->der->izq->der, "mesa");

    alturav(a, &n);
    printf("Altura: %d\n",altura(a));
    printf("Altura: %d\n",n);
    longcadv(a,&n);
    printf("Longitud max cadena: %d\n",longcad(a));
    printf("Longitud max cadena: %d\n",n);
    hderechov(a,&n);
    printf("Hijos derechos: %d\n",hderecho(a));
    printf("Hijos derechos: %d",n);
    return 0;
}

void addnodo(TArbol* a, char e[]) {
    *a = (TArbol)malloc(sizeof(nodo));
    strcpy((*a)->dato, e);
    (*a)->izq = NULL;
    (*a)->der = NULL;
}

int altura(TArbol A){
	int izq,der;
	if(A!=NULL){
        izq=altura(A->izq);
        der=altura(A->der);
        if(der>izq)
			return 1+der;
		else
			return 1+izq;
    }
	else
		return -1;
}

/*int altura(TArbol A){
	int izq,der;
	if(A!=NULL){
		if(A->izq==NULL && A->der==NULL)
			return 0;
		else{
			izq=altura(A->izq);
			der=altura(A->der);
			if(der>izq)
				return 1+der;
			else
				return 1+izq;
		}
	}
	else
		return 0;
}*/

void alturav(TArbol A, int *n){
	int izq,der;
	if(A!=NULL){
        alturav(A->izq,&izq);
		alturav(A->der,&der);
		if(der>izq)
			*n=der+1;
        else
			*n=izq+1;
    }
    else
        *n=-1;
}

int longcad(TArbol A){
	int izq,der, aux;
	if(A!=NULL){
		aux=strlen(A->dato);
		izq=longcad(A->izq);
        der=longcad(A->der);
		if(der>izq){
			if (der>aux)
				return der;
			else
				return aux;
		}
		else{
			if (izq>aux)
				return izq;
			else
                return aux;
        }
	}
	else
		return 0;
}

void longcadv(TArbol A, int *n){
	int izq,der, aux;
	if(A!=NULL){
		aux=strlen(A->dato);
		if(A->izq==NULL && A->der==NULL)
			*n=aux;
		else{
			longcadv(A->izq, &izq);
			longcadv(A->der, &der);
			if(der>izq){
				if (der>aux)
					*n=der;
				else
					*n=aux;
			}
			else{
				if (izq>aux)
					*n=izq;
				else
					*n=aux;
			}
		}
	}
	else
		*n=0;
}



int hderecho(TArbol A){
	if(A!=NULL){
		if(A->der!=NULL){
			return 1 + hderecho(A->der) + hderecho(A->izq);
		}
        else{
            return hderecho(A->izq);
		}
	}
	else{
		return 0;
    }
}

void hderechov(TArbol A, int *n){
	int der, izq;
	if(A!=NULL){
		if(A->der!=NULL){
            hderechov(A->der,&der);
            hderechov(A->izq,&izq);
			*n= 1 + der + hderecho(A->izq);
		}
        else{
            hderechov(A->izq,n);
		}
	}
	else{
		*n=0;
    }
}
