#include <stdio.h>
#include <stdlib.h>
#include "fraccion.h"


void crear(fraccion *f){ //retorna fracción.
    printf("\nNumerador: ");
    scanf("%d",&(f->numerador));
    printf("Denominador: ");
    scanf("%d",&(f->denominador));
    while (f->denominador == 0){
        printf("Denominador (distinto de 0): ");
        scanf("%d",&(f->denominador));
    };
}

void mostrar(fraccion f){
    printf("\nFraccion: %d / %d", numerador(f), denominador(f));
}

int numerador(fraccion f){ //retorna entero.
    return f.numerador;
}

int denominador(fraccion f){ //retorna entero.
    return f.denominador;
}

3int mcd(int a, int b){
    int aux;
    while (b !=0){
        aux = b;
        b = a%b;
        a = aux;
    }
    return a;
}

fraccion simplificar(fraccion f){ //retorna fracción simplificada.
    int d;
    d = mcd(f.numerador,f.denominador);
    f.numerador/=d;
    f.denominador/=d;
    return f;
}

fraccion sumar(fraccion f1, fraccion f2){ //retorna fracción.
    if (f1.denominador == f2.denominador){
        f1.numerador = f1.numerador + f2.numerador;
        f1.denominador = f1.denominador;
    }
    else{
        f1.numerador = f1.numerador * f2.denominador + f2.numerador * f1.denominador;
        f1.denominador = f1.denominador * f2.denominador;
    }
    f1 = simplificar(f1);
    return f1;
}

fraccion restar(fraccion f1, fraccion f2){ //retorna fracción.
    if (f1.denominador == f2.denominador){
        f1.numerador = f1.numerador - f2.numerador;
        f1.denominador = f1.denominador;
    }
    else{
        f1.numerador = f1.numerador * f2.denominador - f2.numerador * f1.denominador;
        f1.denominador = f1.denominador * f2.denominador;
    }
    f1 = simplificar(f1);
    return f1;
}

fraccion multiplicar(fraccion f1, fraccion f2){ //retorna fracción.
    f1.numerador = f1.numerador * f2.numerador;
    f1.denominador = f1.denominador * f2.denominador;
    f1 = simplificar(f1);
    return f1;
}

fraccion dividir(fraccion f1, fraccion f2){ //retorna fracción.
    f1.numerador = f1.numerador * f2.denominador;
    f1.denominador = f1.denominador * f2.numerador;
    f1 = simplificar(f1);
    return f1;
}

void iguales(fraccion f1, fraccion f2){ //retorna verdadero o falso.
    f1=simplificar(f1);
    f2=simplificar(f2);
    if ((f1.numerador==f2.numerador) && (f1.denominador == f2.denominador))
        printf("\nSon iguales.");
    else
        printf("\nNo son iguales.");

}
