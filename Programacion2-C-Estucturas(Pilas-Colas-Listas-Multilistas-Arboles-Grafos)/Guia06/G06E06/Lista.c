#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"
#include <string.h>

void lista(TLista L, char k){  // k es el valor elegido para listar, n cantidad de equipos
    TLista actL=L;
    SubLista actS;
    int i=0, * cont, suma=0; // N es cantidad de equipos
    printf("Equipo          Jugador\n");
    while(actL!=NULL){
        cont[i]=0;
        cont[i]=(int *)malloc(sizeof(int));
        actS=actL->sub;
        while (actS!=NULL){
            if(actS->jugador[0]==k){
                printf("%20s %30s", actL->equipo,actS->jugador);
                cont[i]++;
                suma++;
            }
            actS=actS->sig;
        }
        i++;
        actL=actL->sig;
    }
    printf("Jugadores que arrancan con '%c' son %d.\n", k,suma);
    muestrajugadores(L,cont,i);
}

void muestrajugadores(TLista L, int * cont, int n){
    int i=0, aux=0, j;
    char * eq[20][n]; //donde guardo los equipos
    for(;i<n;i++){
        if(cont[i]>aux){
            j=0;
            aux=cont[i];
            strcpy(eq[20][j],L->equipo);
        }
        else
            if(cont[i]==aux){
                j++;
                strcpy(eq[20][j],L->equipo);
            }
        L=L->sig;
    }
    printf("Los equipos con mmás jugadores:\n");
    for(i=0;i=j;i++)
        printf("%s",eq[20][i]);
}


void ejb(TLista L, int x){
    TLista actL=L;
    SubLista actS;
    int suma, cont;

    printf("\nEjercicio b;\n");
    while(actL->puntaje>=x){
        suma=0;
        cont=0;
        printf("%s\n", actL->equipo);
        actS=actL->sub;
        while (actS!=NULL){
            printf("%s\n", actS->jugador);
            suma+=actS->edad;
            cont++;
            actS=actS->sig;
        }
        printf("Promedio de edad %f\n",suma/cont);
        actL=actL->sig;
    }
}
void ejc(TLista L, char eq[20], int p){

    while(L!=NULL && strcmp(eq,L->equipo)){
        if (L->puntaje==p)
            printf("Cumple.\n");
        else
            printf("Cumple.\n");
        L=L->sig;
    }
}

void ejd(TLista L){
    SubLista actS, antS;

    while (L!=NULL){
        actS=L->sub;
        while(actS!=NULL){
            if(actS->estado=='S')
                if(actS==L->sub){
                    L->sub=actS->sig;
                    free(actS);
                    actS=L->sub;
                }
                else{
                    antS->sig=actS->sig;
                    free(actS);
                    actS=antS->sig;
                }
            else{
                antS=actS;
                actS=actS->sig;
            }
        }
        L=L->sig;
    }
}
