#include <stdio.h>
#include <stdlib.h>
#define MAX 20

void cargavector(int ** ,int *);
void muestrapositivos(int **, int );
void libera(int** ,int );

int main(){
    int *punteros[MAX],N;
    cargavector(punteros, &N);
    muestrapositivos(punteros,N);
    libera(punteros, N);
    return 0;
}
void cargavector(int *punteros[], int *N){
    int i=0;
    FILE * archt;
    if((archt=fopen("G02E05.txt", "rt"))!=NULL){
    punteros[i]=(int *) malloc(sizeof(int));
    while(fscanf(archt,"%d", punteros[i])==1){
            i++;
            punteros[i]=(int *) malloc(sizeof(int));
        }
    free(punteros[i]);
    }
    *N=i;
    fclose(archt);
}
void muestrapositivos(int *punteros[], int N){
    int i=0;
    for(;i<N;i++)
        if (*punteros[i]>0)
            printf("%d\n", *punteros[i]);
}

void libera(int *punteros[], int N){
        int i=0;
        for(;i<N;i++)
            free(punteros[i]);
}

