#include <stdio.h>

#define MAX(a,b) ( (a) > (b) ? (a) : (b))
#define caralf(c) ( (64 < c & c < 91) || (96 < c & c < 123) ? 1 : 0)
int main(){

    float a = 4.5, b = 5.3;
    printf("El mayor es: %5.2f\n\n", MAX(a,b));

    char c = 70, d = 'D', e = 95;
    printf("%c %c %c\n",c,d,e);
    printf("%d %d %d\n",c,d,e);
    (caralf(c)) ? printf("Es alfabetico\n"): printf("No es alfabetico\n");
    (caralf(d)) ? printf("Es alfabetico\n"): printf("No es alfabetico\n");
    (caralf(e)) ? printf("Es alfabetico\n"): printf("No es alfabetico\n");

    return 0;
}
