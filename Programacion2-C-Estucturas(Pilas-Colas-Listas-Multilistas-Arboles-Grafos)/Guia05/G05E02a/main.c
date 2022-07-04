#include <stdio.h>
#include <stdlib.h>
#include "pila.h"

int main(){

    FILE * arch;
    TPila P;
    char x, y2[2]= { 'a' , 'b'} ;
    //printf("\n%s\n", y2);

    arch = fopen("G05E02a.txt","rt");
    iniciaP(&P);
    if (arch!=NULL){
        fscanf(arch,"%c",&x);
        while(!feof(arch)){
            poneP(&P, x);
            fscanf(arch," %c",&x);
        }
    }

    //printf("%s\n", P.datos);
    cadenaP(&P);
    //printf("%s\n", P.datos);

    while(!vaciaP(P)){
        sacaP(&P, &x);
        printf("%d - %c\n",P.tope+1, x);
    }

    //printf("\n");
    //printf("%s\n", P.datos);
    //cadenaP(&P);
    //porque me aparece eso?
    //printf("\n");printf("\n");
    //printf("\n%s\n", y2);
}
