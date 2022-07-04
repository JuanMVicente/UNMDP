 #include <stdio.h>

 void cuadrado(int N);

 int main(){
    int N;
    printf("Ingresar valor de N: ");
    scanf("%d", &N);
    cuadrado(N);
    return 0;
 }


 void cuadrado(int N){
    int i,j;
    for (i=0; i<N ;i++)
        for(j=0; j<N; j++)
            if (j==N-1)
                printf("#\n");
            else
                if (i==0 || j==0 || i==N-1)
                        printf("#");
                else
                    printf(" ");
 }
