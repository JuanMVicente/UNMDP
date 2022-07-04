#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void linea(int *);
void columna(int *);

int main(){
    int a=0,b=0;
    linea(&a);
    printf("Fila: %d\n", a);
    columna(&b);
    printf("Columna: %d", b);
    return 0;
}

void linea(int *sum){
	FILE *archt;
	int a;
	if ((archt = fopen("G01E23a.txt","rt")) == NULL)
        printf("No existe el archivo.");
	else{
        fscanf(archt,"%d", &a); //probar si anda con los dos programas así
        *sum = a;
        while(!feof(archt)){
            fscanf(archt,"%d", &a);
            *sum += a;
        }
	}
	fclose(archt);
	return sum;
}

void columna(int *sum){
	FILE *archt;
	int  a;
	if ((archt = fopen("G01E23b.txt","rt")) == NULL)
        printf("No existe el archivo.");
	else
        while(fscanf(archt,"%d", &a)==1)
            *sum += a;
    fclose(archt);
	return sum;
}

