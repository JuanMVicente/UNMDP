#include <stdio.h>

void duplicafor(int v[],int N);
void duplicawhile(int v[],int N);
void duplicadowhile(int v[],int N);
void muestra(int v[],int N);

void main(){
    int i, v[]={1,2,3,4,5,6,7,8};
    duplicafor(v,8);
    muestra(v,8);
    duplicawhile(v,8);
    muestra(v,8);
    duplicadowhile(v,8);
    muestra(v,8);
    return 0;
}

void duplicafor(int v[],int N){
    int i = 0;
    for (;i<N;i+=2)
        v[i] *= 2;
}

void duplicawhile(int v[],int N){
    int i = 0;
    while(i<N){
        v[i] *= 2;
        i+=2;
    }
}

void duplicadowhile(int v[],int N){
    int i = 0;
    do {
        v[i] *= 2;
        i+=2;
    } while(i<N);
}

void muestra(int v[],int N){
    int i = 0;
    for (;i<N;i++)
        printf("V[%d] = %d\n", i, v[i]);
}
