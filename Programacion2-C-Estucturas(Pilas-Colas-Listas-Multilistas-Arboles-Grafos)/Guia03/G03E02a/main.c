#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "menu.h"
#define LONGNUM 15
#define LONGNAME 20
#define MAX 30

int main(){
        char nom[LONGNAME];
        char tel[LONGNUM];
        Tcontacto agenda[MAX];
        unsigned int n,a;
        iniciaagenda(&n);
        printf("Elija una opcion (1-agregar/2-listar/3-buscar): ");
        scanf("%d",&a);
        while(a!=0){
                switch (a){
                case 1:
                    printf("Nombre: ");
                    scanf("%s", nom);
                    printf("Numero: ");
                    scanf("%s", tel);
                    agrega(agenda, &n, nom, tel);

                    break;
                case 2:
                    listar(agenda,n);
                    break;

                case 3:
                    printf("Nombre: ");
                    scanf("%s", nom);
                    busca(agenda,n,nom);
                    break;
                }
                printf("Elija una opcion (1-agregar/2-listar/3-buscar): ");
                scanf("%d",&a);
        }

        return 0;
}
