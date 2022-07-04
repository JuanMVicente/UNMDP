#include <stdio.h>
#include <stdlib.h>

typedef struct nodo{
    int etiqueta;
    struct nodo * sig;}nodo;

typedef struct nodo{
    int etiqueta;
    float costo;
    struct nodo * sig;}nodo;

typedef nodo * Lista;



int main()
{
    printf("Hello world!\n");
    return 0;
}

int gradoMatriz(int matriz[][10], int n, int vertice){
    int i=0, aux=0;
    for(;i<n;i++)
        if(matriz[vertice][i]!=0)
            aux++;
    return aux;
}

int gradoNodo(nodo Lista[10],int vertice){
    int aux=0;
    nodo auxNodo;
    auxNodo=Lista[vertice]->sig;
    while(auxNodo!=NULL){
        aux++;
        auxNodo=auxNodo->sig->;
    }
    return aux;
}


int gradoMediaMatriz(int mediaMatriz[][10], int n, int vertice){
    int i=0, aux=0;
    for(;i<n;i++)
        if(i<vertice)
            if(mediaMatrix[i][vertice]!=0)
                aux++;
        else
            if(mediaMatrix[vertice][i]!=0)
                aux++;
    return aux;
}
