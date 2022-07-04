#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

int main()
{
    int i=0;
    char pal[MAX];
    TLista L;

    printf("Escribe una palabra: ");
    scanf("%s",pal);
    iniciaL(&L);
    while(pal[i]!='\0'){
        agregaL(&L,pal[i]);
        i++;
    }
    printf("\%c    %c\n", L.pri->dato, L.ult->dato);
    mostrarL(L);
    (palindroma(L)) ? printf("Es palindroma"):printf("No es palindroma");

    return 0;
}
