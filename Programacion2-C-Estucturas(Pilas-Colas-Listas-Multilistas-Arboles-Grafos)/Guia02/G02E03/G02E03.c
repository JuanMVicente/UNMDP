#include <stdio.h>

int main(){
    int * pta, * ptb, * ptc;


    pta = (int *) malloc (sizeof(int));
    ptb = (int *) malloc (sizeof(int));
    ptc = (int *) malloc (sizeof(int));

    * pta = 5;
    * ptb = 2;
    * ptc = 3;

    printf("La suma es: %d\n", *pta + *ptb + *ptc);
    printf("Su producto es: %d", *pta * *ptb * *ptc);

    free(pta);
    free(ptb);
    free(ptc);
    return 0;
}
