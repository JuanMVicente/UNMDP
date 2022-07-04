#include <stdio.h>
#define MAX 20

void binario(unsigned int a);

int main(){
    unsigned int a;
    printf("Escribe un numero Natural: ");
    scanf("%d", &a);
    binario(a);
    return 0;
}

void binario(unsigned int a){
    int i = 0, v[MAX];
    while (a / 2 > 1){
		v[i] = a % 2;
		a /= 2;
        ++i;
    };
    v[i] = a % 2;
    v[++i] = 1;
	for(i;i>-1;i--)
		printf("%d" , v[i]);
}
