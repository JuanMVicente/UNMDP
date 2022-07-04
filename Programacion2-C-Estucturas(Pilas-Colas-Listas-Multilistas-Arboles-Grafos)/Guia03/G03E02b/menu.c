#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "menu.h"

void iniciaagenda(unsigned int *n){
    *n=0;
}

void agrega(char nombre[][MAX], char telefono[][MAX],unsigned int *n,char nom[],char tel[]){
    unsigned int i;
    i=ordena(nombre,*n,nom);
    *n = *n+1;
    if (i<*n)
        mueve(nombre, telefono,*n,i);
    strcpy(nombre[i],nom);
    strcpy(telefono[i],tel);
}

void busca(char nombre[][MAX], char telefono[][MAX], unsigned int n, char nom[]){
    unsigned int i=(n-1)/2, pri=0, ult=n;
    while(strcmp(nombre[i],nom)!=0 && pri<ult){
        if (strcmp(nombre[i],nom)<0)
            ult = i-1;
        else
            pri = i+1;
        i=(pri+ult)%2;
    }
    if(pri<=ult)
        printf("%s\n", telefono[i]);
    else
        printf("No se encuentra ese contacto\n");
}

int ordena(char nombre[][MAX], unsigned int n, char nom[]){
    unsigned int i=0;
    while(strcmp(nombre[i],nom)<0 && i<n)
        i++;
    return i;
}


void mueve(char nombre[][MAX], char telefono[][MAX], unsigned int j, unsigned int i){
    for(;i<j;j--){
            strcpy(nombre[j],nombre[j-1]);
            strcpy(telefono[j],telefono[j-1]);
    }
}

void listar(char nombre[][MAX], char telefono[][MAX],unsigned int n){
    unsigned int i=0;
    printf("Nombre              Numero\n");
    for(;i<n;i++)
       printf("%20s %20s\n", nombre[i], telefono[i]);
}
