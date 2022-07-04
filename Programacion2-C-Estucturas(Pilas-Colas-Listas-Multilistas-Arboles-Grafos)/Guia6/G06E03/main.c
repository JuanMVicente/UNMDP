#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 20

typedef struct nodo{
	char palabra[MAX];
	int cantidad;
	struct nodo * sig;} nodo;

typedef nodo * TLista;

void generaL(TLista *);
void mostrarL(TLista);
void agregaL(TLista * L, char Paux[]);

int main(){
    TLista L;
    L=NULL;
    generaL(&L);
    mostrarL(L);
}

void generaL(TLista * L){
	char Paux[MAX];
	FILE * arch;

	arch=fopen("G06E03.txt","rt");
	if(arch==NULL)
		printf("No existe archivo");
	else
		while(fscanf(arch,"%s", Paux)==1){
			agregaL(L,Paux);
        }
}

void agregaL(TLista * L, char Paux[]){
	TLista ant, act, nuevo;
	ant=NULL;
	act=*L;
	while(act != NULL && strcmp(Paux,act->palabra)>0){
		ant=act;
		act=act->sig;
	}
    nuevo=(TLista) malloc(sizeof(nodo));
    strcpy(nuevo->palabra,Paux);
    nuevo->cantidad=1;
    if(ant==NULL || *L ==NULL){
        if(*L==NULL){
            nuevo->sig=*L;
            *L=nuevo;
        }
        else
            if (strcmp(Paux,act->palabra)==0){
                act->cantidad+=1;
                free(nuevo);
            }
            else{
                nuevo->sig=*L;
                *L=nuevo;
        }
    }
    else{
        if(act==NULL){
            nuevo->sig=act;
            ant->sig=nuevo;
        }
        else{
            if (strcmp(Paux,act->palabra)==0){
                act->cantidad+=1;
                free(nuevo);
            }
            else{
                nuevo->sig=act;
                ant->sig=nuevo;
            }
        }
    }
}

void mostrarL(TLista L){
	TLista aux;
	aux=L;
	printf("Lista                 cantidad");
	while(aux != NULL){
		printf("\n%20s %5d", aux->palabra, aux->cantidad);
		aux=aux->sig;
	}
}
