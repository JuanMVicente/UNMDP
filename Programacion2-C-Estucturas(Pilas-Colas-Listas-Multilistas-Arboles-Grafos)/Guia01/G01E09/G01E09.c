#include <stdio.h>

int main(){
    int x,y;
    printf("x: ");
    scanf("%d", &x);
    switch(x){
            case 4: y = 7;
                break;
            case 5: y = 9;
                break;
            case 9: y = 14;
                break;
            default: y = 22;
    }
    printf("y = %d", y);

    return 0;
}
