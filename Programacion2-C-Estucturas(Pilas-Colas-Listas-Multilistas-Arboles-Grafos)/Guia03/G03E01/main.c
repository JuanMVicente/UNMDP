#include <stdio.h>
#include <stdlib.h>
#include "fraccion.h"

int main(){
    fraccion f1,f2;
    crear(&f1);
    mostrar(f1);
    crear(&f2);
    mostrar(f2);
    printf("\nSuma: ");
    mostrar(sumar(f1,f2));
    printf("\nResta: ");
    mostrar(restar(f1,f2));
    printf("\nMultiplicacion: ");
    mostrar(multiplicar(f1,f2));
    printf("\nDivision: ");
    mostrar(dividir(f1,f2));
    iguales(f1,f2);

    return 0;
}
