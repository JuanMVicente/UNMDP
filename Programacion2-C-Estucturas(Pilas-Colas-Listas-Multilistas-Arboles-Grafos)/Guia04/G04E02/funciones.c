#include <stdio.h>
#include <stdlib.h>

int producto(int a, int b){
if (b==1)
	return a;
else
	return a + producto(a,b-1);
}

void divide(int a, int b, int *c, int *r){
if (a < b){
    *r=a;
    *c=0;
    }
else{
	divide(a-b,b,c,r);
	*c+=1;
    }
}

int maximoc1(int v[], int i){
int aux;
if (i==0)
	return v[0];
else{
	aux = maximoc1(v,i-1);
	if (v[i]>aux)
		aux = v[i];
	return aux;
}
}

void maximoc2(int v[], int i, int *M){
if (i==0)
	*M = v[0];
else{
	maximoc2(v,i-1, M);
	if (v[i]>*M)
		*M = v[i];
    }
}
