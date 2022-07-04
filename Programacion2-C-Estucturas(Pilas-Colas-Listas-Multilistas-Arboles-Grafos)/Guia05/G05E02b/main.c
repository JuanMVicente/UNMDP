#include <stdio.h>
#include <stdlib.h>
#include "Pilas.h"

int main()
{   TPila P,Paux;
    FILE* arch;
    char x;
    int i=-1;

    iniciaP(&P);
    arch = fopen("G05E02b.txt", "rt");
    if(arch != NULL)
        while(fscanf(arch, "%c\n,", &x)==1)
            poneP(&P, x);


    iniciaP(&Paux);
    while(!vaciaP(P)){
        sacaP(&P, &x);
        i++;
        printf("%d - %c\n",i,x);
        poneP(&Paux,x);
    }


    printf("%d",i);
    while(!vaciaP(Paux)){
        sacaP(&Paux, &x);
        poneP(&P,x);
    }
    return 0;
}
