#include <stdio.h>
#include <stdlib.h>

void promedio(int v[],int i, int n, float *prom);

int main(){
    int v[]={2,2,3,5,5,6,7,8,9}, n=9;
    float prom=0;
    promedio(v,n-1,n, &prom);
    printf("Promedio: %5.2f", prom);
}

void promedio(int v[],int i, int n, float *prom){
if (i<0)
	*prom = *prom/n;
else{
	*prom+=v[i];
	promedio(v,i-1,n, prom);
    }
}
//iniciar en 0 el puntero *prom antes de entrar a la función
