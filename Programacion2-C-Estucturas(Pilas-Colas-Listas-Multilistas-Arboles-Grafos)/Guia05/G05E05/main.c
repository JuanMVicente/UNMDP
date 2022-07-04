#include <stdio.h>
#include "cola.h"


void leerCola(TCola *c);

int main() {  //decia void entre parentesis
    TCola cola;
    TElementoC n, suma;
    iniciaC(&cola);
    leerCola(&cola);
    suma = 0;  // estaba suma == 0
    while(!vaciaC(cola)) {
        sacaC(&cola, &n);
        suma += n;
    }
    printf("%d", suma);
    return 0;
}
void leerCola(TCola *c) {
    TElementoC n;
    //iniciac(&c);
    scanf("%d", &n);
    while(n != 0){
        poneC(c, n);
        scanf("%d", &n);
    }
}
