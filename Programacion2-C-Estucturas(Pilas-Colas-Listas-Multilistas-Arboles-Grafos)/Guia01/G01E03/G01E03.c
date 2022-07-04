#include <stdio.h>

int main()
{
    char A;
    A = 'a';
    printf(" %c ", A);
    printf(" %d ", A);
    A = 'a' + 10;
    printf(" %c ", A);
    printf(" %d ", A);

    int B;
    B = 5;
    printf(" %d ", B);
    printf(" %c ", B);
    B = 5 + 'A';
    printf(" %d ", B);
    printf(" %c ", B);

    #define num 15
    printf(" %d ", num);
    printf(" %c ", num);

    #define num 15
    //num = 5 + 'A'; Esta definida como constante, no como variable
    printf(" %d ", num);
    printf(" %c ", num);

    // Declaración de variables
    int a = 10,b = 2;
    float res1, res2, res3, res4, res5, res6;

    // Operaciones
    res1 = (float)b / (float)a;
    res2 = (float)b / a;
    res3 = b / (float)a;
    res4 = 2/10.0;
    res5 = (float)(b / a);
    res6 = (float)(2 / 10);


    // Escritura por pantalla
    printf("%f %f %f %f %f %f\n", res1, res2, res3, res4, res5, res6);

    float c;
    printf("A = ");
    scanf("%d",&a);
    printf("B = ");
    scanf("%d",&b);
    c=(float)a/b;
    printf("A/B = %8.2f",c);
}

