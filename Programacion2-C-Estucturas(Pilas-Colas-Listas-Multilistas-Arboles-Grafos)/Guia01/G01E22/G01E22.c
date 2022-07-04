#include <stdio.h>

int main(){
    char cad1[20], cad2[20], cad3[20] = "que?";
    gets(cad1); gets(cad2);
    int i=0;

    if(strcmp(cad1,cad2)){
        while(cad1[i] != '\0'){
            cad3[i]=cad1[i];
            i++;
        }
        cad3[i] = '\0';
    }
    printf("cad 1: %s\n", cad1);
    printf("cad 2: %s\n", cad2);
    printf("cad 3: %s\n", cad3);
    return 0;

}
