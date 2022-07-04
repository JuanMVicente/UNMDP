#include <stdio.h>

int main(){
    float a,suma;
    printf("X: ");
    scanf("%f",&a);
    suma=a;
    while (a!=0){
        printf("X: ");
        scanf("%f",&a);
        suma+=a;
    }
    printf("suma: %5.2f",suma);
    return 0;
}
