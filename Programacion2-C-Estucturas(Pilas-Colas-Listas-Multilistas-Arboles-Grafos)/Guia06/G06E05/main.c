#include <stdio.h>
#include <stdlib.h>
#include "TDA.h"

typedef struct nodo{
        TCola cola;
        struct nodo * sig;} nodo;

typedef nodo * TLista;

int main()
{
    int n, x, i;
    FILE * arch;
    TLista L=NULL, nuevo;
    TPila P;

    arch=fopen("G06E05.txt", "rt");
    if(arch!=NULL){
        while(!feof(arch)){
            nuevo=(TLista) malloc(sizeof(nodo));
            fscanf(arch,"%d", &n);
            iniciaC(&(nuevo->cola));
            for(i=0;i<n;i++){
                fscanf(arch,"%d", &x);
                poneC(&(nuevo->cola),x);
            }
            nuevo->sig=L;
            L=nuevo;
        }
    }
    nuevo=L;
    while(nuevo!=NULL){
        mostrarC(&(nuevo->cola));
        nuevo=nuevo->sig;
    }
    iniciaP(&P);
    nuevo=L;
    while(nuevo!=NULL){
        n=-99;x=0;
        poneC(&(nuevo->cola),-99);
        sacaC(&(nuevo->cola),&x);
            while(x!=-99){
                poneC(&(nuevo->cola),x);
                sacaC(&(nuevo->cola),&x);
                if (x>n) n=x;
            }
        poneP(&P,n);
        nuevo=nuevo->sig;
    }

    mostrarP(&P);
        nuevo=L;
    while(nuevo!=NULL){
        mostrarC(&(nuevo->cola));
        nuevo=nuevo->sig;
    }

}
