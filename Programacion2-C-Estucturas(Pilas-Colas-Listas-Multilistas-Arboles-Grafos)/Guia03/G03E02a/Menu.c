#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "menu.h"

void iniciaagenda(unsigned int *n){
    *n=0;
}

void agrega(Tcontacto agenda[],unsigned int *n,char nom[],char tel[]){
    unsigned int i;
    Tcontacto aux;
    i=ordena(agenda,*n,nom);
    aux = gencontacto(nom,tel);
    *n = *n+1;
    if (i<*n)
        mueve(agenda,*n,i);
    agenda[i]=aux;
}

void busca(Tcontacto agenda[], unsigned int n, char nom[]){
    unsigned int i=0;
    while(strcmp(agenda[i].nombre,nom)!=0 && i<n)
        i++;
    if(i<n)
        printf("%s\n", agenda[i].numero);
    else
        printf("No se encuentra ese contacto\n");
}

int ordena(Tcontacto agenda[], unsigned int n, char nom[]){
    unsigned int i=0;
    while(strcmp(agenda[i].nombre,nom)<0 && i<n)
        i++;
    return i;
}

Tcontacto gencontacto(char nom[], char tel[]){
    Tcontacto aux;
    strcpy(aux.nombre,nom);
    strcpy(aux.numero,tel);
    return aux;
}

void mueve(Tcontacto agenda[], unsigned int j, unsigned int i){
    for(;i<j;j--)
        agenda[j]=agenda[j-1];
}

void listar(Tcontacto agenda[],unsigned int n){
    unsigned int i=0;
    printf("Nombre              Numero\n");
    for(;i<n;i++)
       printf("%20s %20s\n",agenda[i].nombre,agenda[i].numero);
}


