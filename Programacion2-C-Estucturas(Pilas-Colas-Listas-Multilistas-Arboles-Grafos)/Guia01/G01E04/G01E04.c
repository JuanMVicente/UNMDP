#include <stdio.h>

 int main(){
    int a, b, d = 2;
    a = 8 - 5 * 3 + 2;
    b = 7 % 3 + 4 * 2;
    printf(" valor de a %d\tvalor de b %d\n", a ,b);
    b = b % a;
    printf(" valor de b %d\t\n", b);
    b =(-4) % 3;
    printf(" valor de b %d\t\n", b);
    if (d == a)
        printf(" d y a son iguales ");
    else printf(" d y a son distintos ");

    int c=3;
    c  -= d++ * 3;
    printf(" valor de c %d\tvalor de d %d\n", c, d);

    int l;
    c = 3;
    c = (c * 2 - (l = 4, -- l));
    printf(" valor de c %d\t valor de l %d\n", c, l);
    getch();
    return 0;
 }
