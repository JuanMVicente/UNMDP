#include <stdio.h>

void mostrari(int v[], int N);
void mostrarc(char v[], int N);

int main(){

    int v1[4] = {0};
    mostrari(v1,4);
    int v2[5] = {6};
    mostrari(v2,5);
    int v3[] = {2,4,6};
    mostrari(v3,3);
    //char s1[4] = {"h","o","y"}; asi no lee
    char s1[4] = "hoy";
    mostrarc(s1,4);
    printf("s1 = %s\n",s1);
    char s2[] = {'h','o','y'};
    mostrarc(s2,3);
    printf("s2 = %s\n",s2);
    char s3[4]= {'h','o','y','\0'};
    mostrarc(s3,4);
    printf("s3 = %s\n",s3);

    return 0;
}

void mostrari(int v[], int N){
    int i=0;
    for (;i<N;i++)
        printf("v[%d]: %d\n", i, v[i]);
}

void mostrarc(char v[], int N){
    int i=0;
    for (;i<N;i++)
        printf("v[%d]: %c\n", i, v[i]);
}
