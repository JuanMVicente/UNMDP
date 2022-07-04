#include <stdio.h>
#include <stdlib.h>
#include "Cola.h"

void parentesis(char []);

int main()
{
    char a[MAX];
    printf("Operacion aritmetica: ");
    scanf("%s", a);

    parentesis(a);



    return 0;
}

void parentesis(char a[]){
    int i=0,izq=0,der=0;
    char b;
    TCola C;
    iniciaC(&C);
    while(a[i] != '\0'){
        if (a[i]=='(')
                poneC(&C, a[i]);
        else{
            if (a[i]==')'){
                if (!vaciaC(C))
                    sacaC(&C,&b);
                else
                    der++;
            }
        }
        i++;
    }
    while(!vaciaC(C)){
        izq++;
        sacaC(&C,&b);
    }
    printf("\nFalta derecha: %d", izq);
    printf("\nFalta izquierda: %d", der);
}
