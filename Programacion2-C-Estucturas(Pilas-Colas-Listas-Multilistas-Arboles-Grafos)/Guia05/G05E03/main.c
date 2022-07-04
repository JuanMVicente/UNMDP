#include <stdio.h>
#include <stdlib.h>
#include "PilasD.h"

int main()
{   TPila P, Paux;
    TElementoP x;
    int N;
    FILE * arch;
    int i;

    iniciaP(&P);
    arch = fopen("G05E03.txt","rt");
    if(arch != NULL)
        while(fscanf(arch,"%8u\n", &x)==1){
            poneP(&P, x);
        }

    printf("Cantidad a mostrar: ");
    scanf("%d",&N);
    iniciaP(&Paux);
    printf("Inverso\n");
    for(;i<N;i++){
        sacaP(&P,&x);
        printf("%d - %8u\n", N-i, x);
        poneP(&Paux,x);

    }
    printf("Ordenado\n");
    i = 1;
    while(!vaciaP(Paux)){
        sacaP(&Paux,&x);
        printf("%d - %8u\n", i++, x);
        poneP(&P,x);
    }
    printf("Recursivo\n");
    muestrarec(&P,N);
}

void muestrarec(TPila *P, int N){
    TElementoP x;
    if (N!=0){
        sacaP(P,&x);
        muestrarec(P, N-1);
        printf("%d - %8u\n",N, x);
        poneP(P,x);
    }
}
