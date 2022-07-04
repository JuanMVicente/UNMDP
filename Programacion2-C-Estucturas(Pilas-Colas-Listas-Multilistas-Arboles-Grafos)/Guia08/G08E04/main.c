#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    return 0;
}

void matrisSubyacente(int digrafo[][10], int n){
    int i,j;
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            if(digrafo[i][j]==1)
                digrafo[j][i]=1;
}
