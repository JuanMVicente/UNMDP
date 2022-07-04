#include <stdio.h>
#include <stdlib.h>
#include "PilasD.h"
#include "Colas.h"
#define MAX 50

void ejercicio1(TPila *P, TCola *C);

int main()
{
    TPila P;
    TCola C;
    TElementoP x;
    FILE * arch1/*, * arch2, *arch3*/;
    iniciaP(&P);
    iniciaC(&C);
    arch1 = fopen("Ejercicio1.txt", "rt");
    if (arch1 != NULL)
        while(fscanf(arch1,"%d",&x)==1)
            poneP(&P,x);

    mostrarP(&P);
    ejercicio1(&P,&C);
    mostrarC(&C);

    return 0;
}

void ejercicio1(TPila *P, TCola *C){
	TElementoP x,y;
	int i=0;
	TPila Paux;
	sacaP(P,&x);
	while(!vaciaP(*P)){
		y=99;
		iniciaP(&Paux);
		while(x!=0 && (!vaciaP(*P))){
           // if (!vaciaP(*P))
            //    i++;
			if (x<y){
				poneP(&Paux,x);
				y=x;
				sacaP(P,&x);
                }
			else{
                while(x!=0 && !vaciaP(*P))
                    sacaP(P,&x);
            	while(!vaciaP(Paux))
					sacaP(&Paux,&y);
                }

            }
		if (x==0)
                sacaP(P,&x);
        while(!vaciaP(Paux)){
                sacaP(&Paux,&y);
                poneC(C,y);
            }
		}
}

/*
void ejercicio3(TPila *P, TElementoP x, int *a){
	TElementoP y;
    if (!vaciaP(P))
        (*a) =1;
    else{
        sacaP(P, &y);
        if (y<=x)
            ejercicio3(P, y,&a);
        else
            (*a)=0;
        }
}*/
