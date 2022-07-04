#include <stdio.h>
#include <stdlib.h>
#include "Pila.h"


void stringP(TPila *, char []);
void sumaP(TPila *, TPila *, TPila *);

int main()
{
    char a[MAX], b[MAX];
	TPila Pa,Pb,Suma;

	iniciaP(&Pa);
	printf("a: ");
	scanf("%s", a);
	stringP(&Pa, a);

    iniciaP(&Pb);
	printf("b: ");
	scanf("%s", b);
	stringP(&Pb, b);


    iniciaP(&Suma);
    mostrarP(&Pa);
    mostrarP(&Pb);

    sumaP(&Pa,&Pb,&Suma);
    printf("\nResultado: ");
    mostrarRes(&Suma);

    return 0;
}

void stringP(TPila * P, char x[]){
	int i=0;
	while(x[i] != '\0'){
		poneP(P,x[i]);
		i++;
	}
}

void sumaP(TPila * P1, TPila * P2, TPila * Suma){
    char a,b,c=0;
    //48 es 0 57 es 9
    while(!vaciaP(*P1) || !vaciaP(*P2)){
        a=48;b=48;
        sacaP(P1,&a);
        sacaP(P2,&b);
        a=a+b-48+c;
        if(a>57){
            c=1;
            a-=10;
        }
        else
            c=0;
        poneP(Suma,a);
    }
    if (c=1)
        poneP(Suma, 49);
}
