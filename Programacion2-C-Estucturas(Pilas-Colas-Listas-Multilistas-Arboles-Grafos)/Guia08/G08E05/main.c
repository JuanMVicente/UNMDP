#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    return 0;
}

int gradoEntrada(int digrafo[][10], int n, int vertice){
    int i=0, aux=0;
    for(;i<n;i++)
        if(digrafo[i][vertice]!=0)
            aux++;
    return aux;
}

int gradoSalida(int digrafo[][10], int n, int vertice){
    int i=0, aux=0;
    for(;i<n;i++)
        if(digrafo[vertice][i]!=0)
            aux++;
    return aux;
}

int gradoSalida(int digrafo[][10], int n, int vertice){ //grado vertice = grado entrada + grado salida - cantidad de bucles
    return gradoEntrada(digrafo,n,vertice)+gradoSalida(digrafo,n,vertice)-digrafo[vertice][vertice];
}
