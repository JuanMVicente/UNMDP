#include <stdio.h>
#include <stdlib.h>
#define MAX 10
typedef struct reg{
    int posicion;
    int grado;
} reg;

void generaMatriz(int a[][MAX]);
void muestraMatriz(int a[][MAX]);
void gradosMatriz(int matriz[][MAX],int grados[MAX], int i, int j, int n);
void verticeMayorGradoEntrada(int matriz[][MAX],int i, int j, int n,int gradoEMax,int gradoE, int *vertice);
int verticeMayorGradoEntrada2(int matriz[][MAX],int i, int j, int n,int gradoEMax,int gradoE, int vertice);
int costoMayor(int matriz[][MAX],int i, int j, int n,int costo);
void escribir(int matriz[][MAX],int i, int j, int n,int costo);
void registro(int a[][MAX],int i, int j, int n, int grado,reg b[], int *m);

int main()
{
    int a[MAX][MAX], grados[MAX], n=5,i,vertice=-1, m=0;
    reg b[MAX];
    generaMatriz(a);
    muestraMatriz(a);
    gradosMatriz(a,grados,n-1,n-1,n-1);
    for(i=0;i<5;i++)
        printf("%4d  ",grados[i]);
    verticeMayorGradoEntrada(a,n-1,n-1,n-1,0,0,&vertice);
    printf("\n%4d",vertice);
    printf("\n%4d",verticeMayorGradoEntrada2(a,n-1,n-1,n-1,0,0,-1));
    (costoMayor(a,n-1,n-2,n-1,5)) ? printf("\nsi") : printf("\nno");
    //escribir(a,n-1,n-2,n-1,5);
    registro(a,n-1,n-1,n-1,0,b,&m);
    for(i=0;i<m;i++)
        printf("\n %4d %d ",b[i].posicion, b[i].grado);

    m=-5;
    n=-3;
    printf("\nabsolutos %4d %4d ", abs(m), abs(n));

}
void generaMatriz(int a[][MAX]){
    FILE * arch;
    arch=fopen("G08E08.txt","rt");
    int i,j;
    if(arch!=NULL){
        for(i=0;i<5;i++)
            for(j=0;j<5;j++)
                fscanf(arch,"%d",&a[i][j]);
    }
}
void muestraMatriz(int a[][MAX]){
    int i,j;
    for(i=0;i<5;i++){
        for(j=0;j<5;j++)
            printf("  %4d  -",a[i][j]);
        printf("\n");
    }
}


void gradosMatriz(int matriz[][MAX],int grados[MAX], int i, int j, int n){
    if(i>-1){
        if(j<0){
            gradosMatriz(matriz,grados,i-1,n,n);
            grados[i]=0;
        }
        else{
            gradosMatriz(matriz,grados,i,j-1,n);
            if(matriz[i][j]!=0)
                grados[i]++;
        }
    }
}
//gradosMatriz(matriz,grados,n-1,n-1,n-1)

void verticeMayorGradoEntrada(int matriz[][MAX],int i, int j, int n,int gradoEMax,int gradoE, int *vertice){
    if(j>-1){
        if(i<0){
            if(gradoE>gradoEMax){
                (*vertice)=j;
                verticeMayorGradoEntrada(matriz,n,j-1,n,gradoE,0,vertice);
            }
            else
                verticeMayorGradoEntrada(matriz,n,j-1,n,gradoEMax,0,vertice);
        }
        else{
            if(matriz[i][j]!=0)
                verticeMayorGradoEntrada(matriz,i-1,j,n,gradoEMax,gradoE+1,vertice);
            else
                verticeMayorGradoEntrada(matriz,i-1,j,n,gradoEMax,gradoE,vertice);
            }
        }
    //printf("\n%2d  %2d %2d %2d", i,j,*vertice, gradoE);
}
int verticeMayorGradoEntrada2(int matriz[][MAX],int i, int j, int n,int gradoEMax,int gradoE, int vertice){
    if(j<0){
        return vertice;
    }
    else{
        if(i<0){
            if(gradoE>gradoEMax)
                return verticeMayorGradoEntrada2(matriz,n,j-1,n,gradoE,0,j);
            else
                return verticeMayorGradoEntrada2(matriz,n,j-1,n,gradoEMax,0,vertice);
        }
        else{
            if(matriz[i][j]!=0)
                return verticeMayorGradoEntrada2(matriz,i-1,j,n,gradoEMax,gradoE+1,vertice);
            else
                return verticeMayorGradoEntrada2(matriz,i-1,j,n,gradoEMax,gradoE,vertice);
        }
    }
}

//verticeMayorGradoEntrada(matriz,n-1,n-1,n-1,0,0,-1);


int costoMayor(int matriz[][MAX],int i, int j, int n,int costo){
    if(i<0)
        return 1;
    else
        if(j<0)
            return 0;
        else
            if(i<j)
                if(matriz[j][i]>costo)
                    return costoMayor(matriz,i-1,n,n,costo);
                else
                    return costoMayor(matriz,i,j-1,n,costo);
            else
                if(i>j)
                    if(matriz[i][j]>costo)
                        return costoMayor(matriz,i-1,n,n,costo);
                    else
                        return costoMayor(matriz,i,j-1,n,costo);
                else
                    return costoMayor(matriz,i,j-1,n,costo);
}
void escribir(int matriz[][MAX],int i, int j, int n,int costo){
    if(i<0){}

    else
        if(j<0){}

        else
            if(i<j){
                if(matriz[j][i]>costo)
                    escribir(matriz,i-1,n,n,costo);
                else
                    escribir(matriz,i,j-1,n,costo);
                printf("\n%2d %2d", j,i);
            }
            else
                if(i>j){
                    if(matriz[i][j]>costo)
                        escribir(matriz,i-1,n,n,costo);
                    else
                        escribir(matriz,i,j-1,n,costo);
                    printf("\n%2d %2d", i,j);
                }
                else{
                    escribir(matriz,i,j-1,n,costo);
                    printf("\n%2d %2d", i,j);
                }
}

void registro(int a[][MAX],int i, int j, int n, int grado,reg b[], int *m){
    if(i>-1)
        if(j<0){
            registro(a,i-1,n,n,0,b,m);
            if(grado>2){
                b[*m].grado=grado;
                b[*m].posicion=i;
                (*m)++;
            }
        }
        else
            if(a[i][j]!=0)
                registro(a,i,j-1,n,grado+1,b,m);
            else
                registro(a,i,j-1,n,grado,b,m);

}



