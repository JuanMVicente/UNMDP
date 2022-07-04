#include <stdio.h>
#include <stdlib.h>

void camino(int i, int j, int dijstra[]);
void mostrar(int a[], int n);

int main()
{
    int a[]={0,3,1,0};
    int b[]={4,0,3,1,2};
    int c[][10]={{4,0,3,1,2},{4,0,3,1,2},{4,0,3,1,2},{4,0,3,1,2}};
    camino(0,2,a);
    printf("\n");
    camino(1,0,b);
    printf("\n");
    mostrar(c[1],5);
    printf("\n");
    camino(1,0,c[1]);
    return 0;

}

void camino(int i, int j, int dijstra[]){
    int aux=j;
    if(dijstra[aux]!=999){
        printf("%d - ",aux);
        while(aux!=i){
        aux=dijstra[aux];
        printf("%d - ",aux);
        }
    }
    else
        printf("No existe camino");
}

void mostrar(int a[], int n){
    int i;
    for(i=0;i<n;i++)
        printf("%d - ",a[i]);
}
