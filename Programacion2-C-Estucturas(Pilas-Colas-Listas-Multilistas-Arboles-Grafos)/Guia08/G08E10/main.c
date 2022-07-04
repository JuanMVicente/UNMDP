#include <stdio.h>
#include <stdlib.h>
#define MAX 10
int main()
{
    printf("Hello world!\n");
    return 0;
}

//ej10a
void profundidad(int matriz[][MAX], int n){
    int i,j,z, vec[MAX];
    TPila P;
    for(i=0, i<n,i++)
        vec[i]=0;
    iniciaP(&P);
    i=0;j=0;z=1;
    poneP(&P,i);
    vec[i]=1;
    printf("%s", etiquetas[i]);
    while(!vaciaP(P) && z<n){
	j=0;
        while((mat[i][j]==0 || j==i || v[j]==1) && j<n){
            j++;
        }
        if(j<n){
            i=j;
            printf("%s", etiquetas[i]);
            z++;
            vec[i]=1;
            poneP(&P,i);
        }
        else
            sacaP(&P,&i)
	}
}

ej10b
void altura(int matriz[][MAX], int n){
    int i,j,z, vec[MAX];
    TCola C;
    for(i=0, i<n,i++)
        vec[i]=0;
    iniciaC(&C);
    i=0;j=0;z=1;
    poneC(&C,i);
    vec[i]=1;
    printf("%s", etiquetas[i]);
    while(!vaciaC(C) || z==n){
        sacaC(&C,&i);
        while(j<n){
            j++;
            if(mat[i][j]==0 && j!=i && v[j]!=0){
                printf("%s", etiquetas[j]);
                poneC(&C,j);
                v[j]=1;
                z++;//para ver cuantos conexos hay
            }
        }
    }
}

int recorridos(int vec[MAX], int n){
	int i=0;
	while(vec[i]=1 && i<n){
		i++;
	}
	return (i==n);
}

ej11a
void profundidad(TLista lista[], int n){
    TLista aux;
    int i,z;
    for(i=0, i<n,i++)
        vec[i]=0;
    iniciaP(&P);
    z=1;i=0;
    poneP(&P,i);
    vec[i]=1;
    printf("%s", etiquetas[i]);
    while(!vaciaP(P) || z==n){
        aux=Lista[i];
        while(nodo!=NULL && vec[i]!=0){
            nodo=nodo->sig;}
        if(nodo!=NULL)
            printf("%s", etiquetas[i]);
            z++;
            i=nodo->posicion;
            vec[i]=1;
            poneP(P,i);
        }
        else
            sacaP(P,i)
	}
}

ej11b
void profundidad(TLista lista[], int n){
        TLista aux;
    int i,z;
    for(i=0, i<n,i++)
        vec[i]=0;
    iniciaC(&C);
    i=0;z=1;
    poneC(&C,i);
    vec[i]=1;
    printf("%s", etiquetas[i]);
    while(!vaciaC(C) || z==n){
        sacaC(C,&i);
        nodo=Lista[i];
        while(nodo!=NULL){
            if(vec[i]!=0){
                nodo=nodo->sig;
                printf("%s", etiquetas[j]);
                v[nodo->posicion]=1;
                poneC(C,nodo->posicion);
                z++;
            }
            else
                nodo=nodo->sig;
        }
    }
}



void Prim(int matriz[][MAX],int AMM[][MAX], int n){
    int i,j,z=0, vec[MAX];
    TCola C;
    for(i=0, i<n,i++)
        vec[i]=0;
    for(i=0,i<n,i++){
        for(j=0,j<n,j++){
            if(matriz[i][j]<Min && i!=j && vec[i]+vec[j]!=2){
                Min=matriz[i][j];
                vec[i]=1;
                vec[j]=1;
                AAM[i][j]=Min;
                z++;
            }
        }
    }
    while(z<n-1){
        Min=9999;
        for(i=0,i<n,i++){
            if(vec[i]==1){
                for(j=0,j<n,j++){
                    if(vec[j]==0 && matriz[i][j]<Min)
                        Min=matriz[i][j];
                        vec[j]=1;
                        AAM[i][j]=Min;
                        z++;
                    }
                }
        }
    }
}

void Prim(int matriz[][MAX],int AMM[MAX], int n, float *costo){
    int i,j,k,z;
    TCola C;
    (*costo)=0;
    for(i=0, i<n,i++)
        AMM[i]=0;
    for(i=0,i<n,i++){
        for(j=0,j<n,j++){
            if(matriz[i][j]<Min && i!=j){
                Min=matriz[i][j];
                k=i;
                z=j;
            }
        }
    }
    (*costo)=matriz[i][j];
    AMM[k]=z;
    AMM[z]=k;
    z=2;
    while(z<n || recorridos(ABB,n)){
        Min=9999;
        for(i=0,i<n,i++){
            if(vec[i]==1){
                for(j=0,j<n,j++){
                    if(vec[j]==0 && matriz[i][j]<Min)
                        Min=matriz[i][j];
                        k=j;
                }
            }
        }
        (*costo)+=matriz[i][k];
        AAM[k]=i;
        z++;
    }
}

void Kruskal(int matriz[][MAX],int AMM[MAX], int n, float *costo){
    int i,j,k,z;
    TCola C;
    (*costo)=0;
    for(i=0, i<n,i++)
        AMM[i]=i;
    while(z<n || recorridos(ABB,n)){
        Min=9999;
        for(i=0,i<n,i++){
            for(j=0,j<n,j++){
                if(matriz[i][j]<Min && (AMM[i]!=AMM[j]))
                        Min=matriz[i][j];
                        k=i;
                        z=j;
                }
            }
        (*costo)+=matriz[k][z];
        if(z<k)
            k=z;
        for(i=0,i<n,i++)
            if(AAM[i]==z)
                AAM[i]=k;

    }
}


int recorridos(int vec[MAX], int n){
	int i=0;
	while(vec[i]=1 && i<n){
		i++;
	}
	return (i==n);
}
