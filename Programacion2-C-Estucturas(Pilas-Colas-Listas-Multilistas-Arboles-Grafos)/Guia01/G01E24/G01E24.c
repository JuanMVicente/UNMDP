#include <stdio.h>

void lee_arch(float *prom, float *min, float *max);

int main(){
	float t, prom, min, max;
	FILE *regtemp;
	regtemp = fopen("G01E24.dat","wb");
	printf("Ingrese Medicion (0 termina): ");
	scanf("%f",&t);
	while(t != 0){
        fwrite(&t,sizeof(float),1,regtemp);
		printf("Ingrese Medicion (0 termina): ");
		scanf("%f",&t);
	}
	fclose(regtemp);


	lee_arch(&prom, &min, &max);
	printf("Prom: %5.2f\n", prom);
	printf("Minimo: %5.2f\n", min);
	printf("Maximo: %5.2f\n", max);

	return 0;
}

void lee_arch(float *prom, float *min, float *max){
	FILE *regtemp;
	float sum= 0,t;
	int cont = 0;
	regtemp = fopen("G01E24.dat","rb");
	fread(&t,sizeof(float),1,regtemp);
	*min = *max = t;
	while(!feof(regtemp)){
		sum+=t;
		cont++;
		if(*min>t)
			*min = t;
		else
			if(*max<t)
				*max = t;
		fread(&t,sizeof(float),1,regtemp);
	}
	*prom = sum /cont;
}

