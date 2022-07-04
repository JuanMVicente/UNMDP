#include <stdio.h>
#include <stdlib.h>
#include "Cola.h"
#include "Pila.h"
#define GRUPO 26
void leearchivo(TCola *);
void pilas(TCola *, TPila []);
int busca(char);

int main()
{
    int i=0;
    char a;
    TCola C;
    TPila P[GRUPO];
    TElementoP x,y;
    iniciaC(&C);
    for(;i<GRUPO;i++)
        iniciaP(&P[i]);
    leearchivo(&C);
    mostrarC(&C);
    pilas(&C,P);
    /*printf("\nElija una Letra (mayuscula): ");
    scanf("%c",&a);
    mostrarP(&P[busca(a)]);*/
    sacaP(&P[1],&x);
    printf("\nprueba\n");
    printf("%s",x);
    y=x;
    printf("\nprueba\n");
    printf("%s",y);


    return 0;
}

void leearchivo(TCola * C){
    FILE * arch;
    char Nom[MAX];
    arch = fopen("Competidores.txt", "rt");
    if(arch!=NULL){
        while (fgets(Nom, MAX, arch)){
            poneC(C,Nom);
        }
    }
}

void pilas(TCola * C, TPila P[]){
    char x[MAX];
    while(!vaciaC(*C)){
        sacaC(C,x);
        poneP(&P[busca(x[0])],x);
        }
}



int busca(char x){
    switch(x){
            case 'A':return 0;
                break;
            case 'B':return 1;
                break;
            case 'C':return 2;
                break;
            case 'D':return 3;
                break;
            case 'E':return 4;
                break;
            case 'F':return 5;
                break;
            case 'G':return 6;
                break;
            case 'H':return 7;
                break;
            case 'I':return 8;
                break;
            case 'J':return 8;
                break;
            case 'K':return 10;
                break;
            case 'L':return 11;
                break;
            case 'M':return 12;
                break;
            case 'N':return 13;
                break;
            case 'O':return 14;
                break;
            case 'P':return 15;
                break;
            case 'Q':return 16;
                break;
            case 'R':return 17;
                break;
            case 'S':return 18;
                break;
            case 'T':return 19;
                break;
            case 'U':return 20;
                break;
            case 'V':return 21;
                break;
            case 'W':return 22;
                break;
            case 'X':return 23;
                break;
            case 'Y':return 24;
                break;
            case 'Z':return 25;
                break;
    }
}
