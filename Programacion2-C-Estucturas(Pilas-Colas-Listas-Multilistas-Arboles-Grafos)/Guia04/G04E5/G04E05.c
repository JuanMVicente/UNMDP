#include <stdio.h>
#include <stdlib.h>
#define MAX 10

int simetria(int a[][MAX],int i, int j);

int main(){
    int a[MAX][MAX] = {{1,2,3},{4,5,6},{7,8,9}},b[MAX][MAX]= {{1,2,4},{2,1,3},{4,3,1}};
    int n=3;
    if (simetria(a,n-1,n-2))
        printf("a es simetrica\n");
    else
        printf("a no es simetrica\n");
    if (simetria(b,2,1))
        printf("b es simetrica\n");
    else
        printf("b no es simetrica\n");
}

int simetria(int a[][MAX],int i, int j){
if (i<1)
	return 1;
else
	if (j==0)
		if(a[i][j] == a[j][i])
			return simetria(a,i-1,i-2);
		else
			return 0;
	else
		if(a[i][j] == a[j][i])
			return simetria(a,i,j-1);
		else
			return 0;
}
// aux = simetria(a,n-1,n-2) // aux = simetria(a,n-1,n-1 debería andar también)
