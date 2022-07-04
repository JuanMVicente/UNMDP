#include <stdio.h>

void orden(int a, int b, int c);

main(){
    int a,b,c;
    printf("valores: \n");
    scanf("%d %d %d",&a,&b,&c);
    printf("%d, %d y %d\n",a,b,c);
    orden(a,b,c);

    return 0;

}

void orden(int a, int b, int c){
    if(a<=b && b<=c)
        printf("ordenados");
    else
        printf("desordenados");
}
