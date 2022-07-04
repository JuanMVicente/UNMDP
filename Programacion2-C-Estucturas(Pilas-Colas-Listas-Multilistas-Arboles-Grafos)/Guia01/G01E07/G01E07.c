#include <stdio.h>

int main(){
    int a;
    /* leer a = 3 */
    printf("A: ");
    scanf("%d", &a);
    printf("A leida = %d\n",a);
    //scanf("%f", &a);
    printf("A: ");
    scanf(" %c\n", &a);
    printf("A leida = %c\n",a);

    char x;
    printf("X: ");
    /* leer x = 3 */
    //scanf("%d", &x);
    //scanf("%f", &x);
    scanf(" %c", &x);
    printf("X leida = %c\n",x);

    char w;
    printf("W: ");
    /* leer w = 2.5 */
    scanf("%d", &w);

    printf("W: ");
    //scanf("%f", &w);
    scanf(" %c", &w);
    printf("%c\n",w);

    return 0;
}
