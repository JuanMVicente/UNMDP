#include <stdio.h>

void cambioFormato(int s,int *a, int *, int *c);

int main(){
    int s,a=0,b=0,c=0;
    printf("S: \n");
    scanf("%d",&s);

    cambioFormato(s,&a,&b,&c);
    printf("%02d:%02d:%02d\n",a,b,c);
    return 0;
}
void cambioFormato(int s, int *a, int *b, int *c){
    *c=s%60;
    *b=s/60%60;
    *a=s/(60*60);
}
