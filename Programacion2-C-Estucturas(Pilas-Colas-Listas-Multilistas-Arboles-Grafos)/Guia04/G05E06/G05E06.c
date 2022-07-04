#include <stdio.h>
#include <stdlib.h>
#define MAX 10

void cumplefila(int a[0][MAX], int i, int j, int m, int *f1, int *f2);

int main(){
    int a[MAX][MAX] = {{1,2,3},{4,5,6},{7,8,9}},b[MAX][MAX]= {{1,2,4},{2,1,3},{4,3,1}};
    int n=3,m=3, f1=0,f2=125;
    cumplefila(a,n-1,m-1,m-1,&f1,&f2);
    if (f1)
        printf("a cumple\n");
    else
        printf("a no cumple\n");
    printf("%d %d\n", n,m);
    f1=0;f2=125;
    cumplefila(b,n-1,m-1,m-1,&f1,&f2);
    if (f1)
        printf("b cumple\n");
    else
        printf("b no cumple\n");
}

void cumplefila(int a[0][MAX], int i, int j, int m, int *f1, int *f2){
if (i<0){
	if((*f2)>(*f1) && (*f1)%2==0)
		*f1=*f2=1;
	else
		*f1=*f2=0;
    }
else{
	if (j<0){
	    if ((*f2)>(*f1)){
            printf("%d %d\n", *f1,*f2);
            (*f2)=(*f1);
            (*f1)=0;
            cumplefila(a,i-1,m,m,f1,f2);
	    }
	    else
            *f1=*f2=0;
	}
	else{
		(*f1)+=a[i][j];
		cumplefila(a,i,j-1,m,f1,f2);
    }
}
}
