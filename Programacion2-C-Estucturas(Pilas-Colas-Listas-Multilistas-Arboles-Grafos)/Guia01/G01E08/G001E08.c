#include <stdio.h>

int main(){
    int a = 0;
    if( ++a )
        printf("a vale 0\n");
    else
        printf("a vale 1\n");

    printf("%d",a);

    return 0;
}
