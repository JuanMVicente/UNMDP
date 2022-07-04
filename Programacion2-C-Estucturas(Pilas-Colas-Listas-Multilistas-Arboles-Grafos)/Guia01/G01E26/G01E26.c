#include <stdio.h>
#include <stdlib.h>

typedef struct{
    char nombre[15], apellido[15], nacionalidad[20];
    float puntaje;
}Treg;

void crearachivo(char []);
void leerarchivo(char [], int pos);

int main(){
  int pos;
  crearachivo("ranking.dat");
  printf("ingrese posicion\n");
  scanf("%d",&pos);
  leerarchivo("ranking.dat",pos);
  return 0;
}

 void crearachivo(char archivo[]){
     Treg jugador;
     FILE *ranking;
     ranking= fopen(archivo,"wb");
     if (ranking==NULL)
        printf("archivo no encontrado"); //No se si va, porque si no lo encuentra, lo crea creo
     else{
        printf("ingrese ranking \n");
        scanf("%f %s %s %s",&(jugador.puntaje),jugador.nombre,jugador.apellido,jugador.nacionalidad);
        while (!(jugador.puntaje)==0){
           fwrite(&jugador,sizeof(Treg),1,ranking);
          scanf("%f %s %s %s",&(jugador.puntaje),jugador.nombre,jugador.apellido,jugador.nacionalidad);
        }
     }
     fclose(ranking);
 }

 void leerarchivo(char archivo[],int pos){
     Treg jugador;
     FILE *ranking;
     ranking= fopen(archivo,"rb");
     if (ranking==NULL)
        printf("archivo no encontrado"); //No se si va, porque si no lo encuentra, lo crea creo
     else{
        fseek(ranking,pos*sizeof(Treg),0);
        fread(&jugador,sizeof(Treg),1,ranking);
        printf("POSICION NRO: %d \n NOMBRE: %s \n APELLIDO: %s \n NACIONALIDAD: %s \n PUNTAJE: %7.2f",pos,jugador.nombre, jugador.apellido, jugador.nacionalidad, jugador.puntaje);
     }
     fclose(ranking);
 }
