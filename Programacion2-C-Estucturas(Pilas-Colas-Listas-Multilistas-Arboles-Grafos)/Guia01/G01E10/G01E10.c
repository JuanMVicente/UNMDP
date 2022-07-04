#include <stdio.h>

int main(){
    int a,b,c;
    printf("a: ");
    scanf("%d", &a);
    printf("b: ");
    scanf("%d", &b);
    c = (a>b) ? a : b;
    printf("c = %d\n", c);
    c = 5;
    printf((a<=b && b<=c) ? "ordenados" : "desordenados");
    return 0;
}
