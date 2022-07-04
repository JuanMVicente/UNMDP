#include <stdio.h>

int main(){
	FILE *medicion, *compara;
	int cont1=0, cont2=0;
	typedef struct{
		char dominio[6];
		float veldom;
		int velmax;}Treg;
	Treg lect;
    char dominio[6];
    float veldom;
    int velmax;

	if((medicion = fopen("G01E25.txt", "rt")) == NULL)
		printf("No existe archivo.");
	else{
	compara = fopen("G01E25.dat", "wb");
	while(fscanf(medicion,"%s %f %d\n",dominio,&veldom,&velmax)==3){
		cont1++;
		if(veldom > 1.2 * velmax){
			fwrite(&lect, sizeof(Treg),1,compara);
			cont2++;
		}
	}
	printf("Se procesaron %d vehiculos.\n",cont1);
	printf("Se generaron %d registros.", cont2);
	}
}
