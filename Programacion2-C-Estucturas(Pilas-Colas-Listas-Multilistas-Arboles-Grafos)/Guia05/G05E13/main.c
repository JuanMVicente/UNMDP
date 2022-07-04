#include <stdio.h>
#include <stdlib.h>
#include "Cola.h"
#include "Pila.h"

void GeneraCola(TCola * , char [], int *);
void Palindroma(TCola *, TPila *, int);

int main()
{
    char palabra[MAX];
    int n;
    TCola C;
    TPila P;

    iniciaC(&C);
    iniciaP(&P);
    printf("Escribe una palabra: ");
    scanf("%s",palabra);
    GeneraCola(&C, palabra,&n);
    Palindroma(&C,&P,n);



    return 0;
}

void GeneraCola(TCola * C, char a[], int *n){
    (*n)=0;
    while(a[*n] != '\0'){
        poneC(C,a[*n]);
        printf("%c",a[*n]);
        (*n)++;
    }
}

void GeneraPila(TCola * C, TPila * P, int n){
    int i=0;
    char x;
    for(;i<n/2;i++){
        sacaC(C,&x);
        poneP(P,x);
    }
    if(n%2!=0)
        sacaC(C,&x);
}

void Palindroma(TCola * C, TPila * P, int n){
    GeneraPila(C,P,n);
    char x,y;
    while(!vaciaP(*P) && n!=0){
        sacaP(P,&x);
        sacaC(C,&y);
        if(x!=y)
            n=0;
    }
    if(n!=0)
        printf("\nEs Palindroma");
    else
        printf("\nNo es Palindroma");
}

