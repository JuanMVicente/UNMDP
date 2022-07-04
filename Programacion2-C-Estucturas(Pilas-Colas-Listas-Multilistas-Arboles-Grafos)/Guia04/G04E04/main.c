#include <stdio.h>
#include <stdlib.h>
#define MAX 20

int repite1(float a[][MAX], int i, int j, int m, float x);
void repite2(float a[][MAX], int i, int j, int m, float x, int *q);

int main(){
    float a[MAX][MAX] = {{1.2,2.3,5.6,4.8},{7.1,2.5,2.3,4.8},{5.1,7.1,1.2,7.6}}, x;
    int n=3, m=4,q;
    printf("Valor a buscar: ");
    scanf("%f", &x);
    printf("Se repite 1: %d", repite1(a,n-1,m-1,m-1,x));
    repite2(a,n-1,m-1,m-1,x,&q);
    printf("\nSe repite 2: %d", q);
}

int repite1(float a[][MAX], int i, int j, int m, float x){
int aux;
if (i<0)
	return 0;
else{
	if (j==0)
		aux = repite1(a,i-1,m,m,x);
	else
		aux = repite1(a,i,j-1,m,x);
	if (a[i][j] == x)
		aux++;
	return aux;
}
}

void repite2(float a[][MAX], int i, int j, int m, float x, int *q){
if (i<0)
	*q = 0;
else{
	if (j==0)
		repite2(a,i-1,m,m,x,q);
	else
		repite2(a,i,j-1,m,x,q);
	if (a[i][j] == x)
		*q = *q + 1;
    }
}

