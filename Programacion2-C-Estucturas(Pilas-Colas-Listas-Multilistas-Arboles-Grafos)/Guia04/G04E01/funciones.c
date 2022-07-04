#include <stdio.h>
#include "funciones.h"

int suma(int v[],int i){
    if (i==0)
        return v[0];
    else
        return v[i] + suma(v,i-1);
}

void mostrar(int v[], int i){
    if (i==0)
        printf("V[0]= %d\n", v[0]);
    else{
        mostrar(v,i-1);
        printf("V[%d]= %d\n", i, v[i]);
    }
}

void mostrarinv(int v[], int i){
    if (i==0)
        printf("V[0]= %d\n", v[0]);
    else{
        printf("V[%d]= %d\n", i, v[i]);
        mostrar(v,i-1);
    }
}

int busca(float a[], int i, float x){
    if (i<0)
        return 0;
    else
        if (a[i]==x)
            return i+1;
        else
            return busca(a,i-1,x);
}

int buscab(float a[], float x, int pri,int ult){
    if (pri>=ult)
        return 0;
    else
        if (a[(pri+ult)%2]==x)
            return (pri+ult)%2;
        else
            if (a[(pri+ult)%2]>x)
                return buscab(a,x,pri, (pri+ult)%2-1);
            else
                return buscab(a,x,(pri+ult)%2+1,ult);
}

void mostrarf(float a[], int i){
    if (i<1)
        printf("V[1]= %f\n", a[0]);
    else{
        mostrarf(a,i-1);
        printf("V[%d]= %f\n", i+1, a[i]);
    }
}

float minimo(float a[][10], int i, int j, int n){
float min;
if(i==0 && j == 0)
	return a[0][0];
else
	if (j<0)
		return minimo(a,i-1,n,n);
	else{
		min = minimo (a,i,j-1,n);
		if (a[i][j]<min)
			min=a[i][j];
		return min;
	}
}

void maximos(float a[][10], float b[], int i, int j, int m){
if (i>=0){
if (j==0){
	maximos(a,b,i-1,m,m);
	b[i] = a[i][0];
    }
else{
	maximos(a,b,i,j-1,m);
	if (b[i] < a[i][j])
		b[i] = a[i][j];
	}
}
}
void ordena(float a[], float b[], float c[], int i, int j, int *k){
if (i==0 && j==0)
	if (a[0]<b[0]){
        (*k)=0;
        c[0] = a[0];
        (*k)++;
        c[1] = b[1];
		}
	else
        if (b[0] < a[0]){
            (*k)=0;
            c[0] = b[0];
            (*k)++;
            c[1]=a[1];
        }
        else
            c[0] = a[0];
else
	if(i>0 && j>0)
		if (a[i]==b[j]){
			ordena(a,b,c,i-1,j-1,k);
			c[*k]=a[i];
			}
		else
			if (a[i]<b[j]){
				ordena(a,b,c,i,j-1,k);
				c[*k]=b[j];
				}
			else{
				ordena(a,b,c,i-1,j,k);
				c[*k]=a[i];
	 			}
	else
        if (i==0){
            ordena(a,b,c,i,j-1,k);
			c[*k]=b[j];
        }
		else{
			ordena(a,b,c,i-1,j,k);
            c[*k]=a[i];
		}
(*k)++;
}
