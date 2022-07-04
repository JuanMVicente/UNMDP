#include <stdio.h>
#include <stdlib.h>

int main(){
    int N,i;
    float * vector;

    printf("Cantidad de datos del vector: ");
    scanf("%d", &N);

    vector = (float *) malloc(N*sizeof(float));


    for(i=0;i<N;i++){  //Por aritmetica de punteros
        printf("V[%d]: ",i);
        scanf("%f",vector+i);
    }

    /*for(i=0;i<N;i++){
        printf("P[%d]: ",i);
        scanf("%f", &vector[i]);
    }*/

    for(i=0;i<N;i++){  //Por aritmetica de punteros
        if (*(vector+i)>=0)
            printf("\nV[%d]: %5.2f",i,*(vector+i));
    }

    for(i=0;i<N;i++){
        if (vector[i]>=0)
            printf("\nP[%d]: %5.2f",i,vector[i]);
    }
    free(vector);
}
/*int main()
{

    for (i=0;i<N;i++)
        scanf("%f",Vector+i);
    printf("Reales Positivos:");
    for (i=0;i<N;i++)
        if (*(Vector+i)>0)
          printf(" %5.2f",*(Vector+i));
    free(Vector);
    return 0;
}*/
