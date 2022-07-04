#include <stdio.h>
#include <stdlib.h>
#include "funciones.h"

int main(){
    //Ejercicio a - i ii iii
    /*int v[] = {1,2,3,4,5}, na=5;
    printf("Suma: %d\n", suma(v,na-1));
    mostrar(v,na-1);
    mostrarinv(v,na-1);

    //Ejercicio b - i ii (ver binario)
    float ab[] = {1.3 , 2.6 , 6.2 , 7.6, 8.4, 6.0, 2.4}, x;
    int nb = 7;
    mostrarf(ab,nb-1);
    printf("X: ");
    scanf("%f", &x);
    printf("Posicion: %d\n", busca(ab,nb-1,x));
    printf("X bin: ");
    scanf("%f", &x);
    printf("Posicion: %d\n", buscab(ab,x,0,nb-1));

    // Ejercicio c
    float ac[][10]={{0.4,2.6,3.4},{4.9,5.1,6},{7.4,0.5,0.3}};
    int nc=3;
    printf("%5.2f", minimo(ac, nc-1, nc-1, nc-1));*/

    //Ejercicio d
    float ad[][10]={{1.2,2.6,3.4},{4.9,5.1,6},{7.4,0.5,8.3},{1.4,6,9.2}};
    float bd[10];
    int nd=4, md=3;
    maximos(ad,bd,nd-1,md-1,md-1);
    mostrarf(bd,nd-1);

    /*float ae[] = {1.2,2.6,3.4,5.1,8}, be[]= {1,2.3,4.9,5.1,6}, ce[20];
    int ne=5, me=5, ke=0; // debe estar inicializado k
    ordena(ae, be, ce, ne-1, me-1, &ke);
    mostrarf(ce,ke-1);*/

}
