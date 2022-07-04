#include <stdio.h>
#include <stdlib.h>
#define MAX 10
int mayorGradoEntrada(int mat[][MAX], int i, int j, int n, int suma, int maximo, int posicion);
int mayorGradoEntrada2(int mat[][MAX], int i, int j, int n, int suma, int maximo, int posicion);
int main()
{
    int n=4, a[][MAX]={{0,0,1,0},{0,1,1,1},{0,1,0,1},{0,1,1,0}};

    printf("%d\n", mayorGradoEntrada(a,n-1,n-1,n-1,0,0,-1));
    printf("%d", mayorGradoEntrada2(a,0,0,n-1,0,0,-1));

    return 0;
}

int mayorGradoEntrada(int mat[][MAX], int i, int j, int n, int suma, int maximo, int posicion){
    if(j<0){
        return posicion;
    }
    else{
        if(i<0){
            if(suma>maximo){
                return mayorGradoEntrada(mat,n,j-1,n,0,suma,j);
            }
            else{
                return mayorGradoEntrada(mat,n,j-1,n,0,maximo,posicion);
            }
        }
        else{
            return mayorGradoEntrada(mat,i-1,j,n,suma + mat[i][j],maximo,posicion);
        }
    }
}

int mayorGradoEntrada2(int mat[][MAX], int i, int j, int n, int suma, int maximo, int posicion){
    if(j>n){
        return posicion;
    }
    else{
        if(i>n){
            if(suma>maximo){
                return mayorGradoEntrada2(mat,n,j+1,n,0,suma,j);
            }
            else{
                return mayorGradoEntrada2(mat,n,j+1,n,0,maximo,posicion);
            }
        }
        else{
            return mayorGradoEntrada2(mat,i+1,j,n,suma + mat[i][j],maximo,posicion);
        }
    }
}
