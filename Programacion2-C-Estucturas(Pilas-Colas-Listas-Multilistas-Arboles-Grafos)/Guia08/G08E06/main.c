#include <stdio.h>
#include <stdlib.h>

typedef struct nodo{
    char etiqueta;
    struct nodo * sig;} nodo;



int main()
{
    printf("Hello world!\n");
    return 0;
}

int gradoEntrada(int nodo[10],int n, char vertice){
    int aux=0, i=0;
    nodo auxNodo;
    for(;i<n;i++){
        auxNodo=nodo[0]->sig;
        while(auxNodo!=NULL){
            if(auxNodo->etiqueta==vertice)
                aux++;
        }
    }
    return aux;
}

int gradoSalida(int nodo[10],int n, int vertice){
    int aux=0;
    nodo auxNodo=nodo[vertice]->sig;
    while(auxNodo!=NULL){
        aux++;
        auxNodo=auxNodo->sig;
    }
    return aux;
}

int gradoVertice(int nodo[10],int n, char vertice){
    int aux=0, i=0;
    nodo auxNodo;
    for(;i<n;i++){
        auxNodo=nodo[0]->sig;
        while(auxNodo!=NULL){
            if(auxNodo->etiqueta==vertice)
                aux++;
            else
                if(nodo[0]->etiqueta==vertice)
                    aux++;
        }
    }
    return aux;
}
