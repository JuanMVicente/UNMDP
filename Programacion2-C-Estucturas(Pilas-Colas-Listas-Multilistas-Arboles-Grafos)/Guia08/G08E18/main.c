#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    return 0;
    for(i=0,i<n,i++)
        if(i!=k)
            visitados[i]=0;
        else
            visitados[i]=1;
    alcanzable(mat,k,n-1,n-1,&alc, visitados);

}


//ejercicio 18 (en clase)
void alcanzable(int mat[][MAX], int i, int j, int n, int *alc, int visitados[]){
    if(mat[i][j]!=0)
        *alc=1;
    else{
        k=0;
        while(k<=n && *al==0){
            if(mat[i][k]!=0 && vis[k==0]){
                visitados[k]=1;
                alcanzable(mat,k,j,n,alc,visitados);
            }
            (*k)++;
        }
    }
}

//alcanzable(listaA,listaA[k],n,alc,visitados)
void alcanzable(TLista listaA[MAX], int i, int j,int n, int *alc, int visitados[]){
    TLista aux;
    TCola C;
    aux=listaA[i]->sig;
    *alc=0;
    iniciaC(&C);
    poneC(&C,i);
    k=0;
    while(*alc==0 && k<=n){
        sacaC(&C,&i);
        k++;
        aux=listaA[i]->sig;
        while(aux!=NULL && *alc==0){
            if(aux->posicion==j)
                *alc=1;
            else{
                if(visitados[aux->posicion]==0){
                    poneC(&C,aux->posicion);
                    visitados[aux->posicion]=1;
                }
                aux=aux->sig;
            }
        }
    }
}

//ejercicio 19
void alcanzable(int mat[][MAX], int i, int j, int n, int *alc, int visitados[]){
    if(mat[i][j]!=0)
        *alc=1;
    else{
        k=0;
        while(k<=n && *alc==0){
            if(mat[i][k]!=0 && visitados[k]==0]){
                visitados[k]=1;
                alcanzable(mat,k,j,n,alc,visitados);
                if(*alc==0)
                    visitados(k)=2;// lo propuso Lucas
                (*k)++;
            }
        }
    }
}
//alcanzable(listaA,listaA[k],n,alc,visitados)
void alcanzable(TLista listaA[MAX], int i, int j,int n, int *alc, int visitados[], int *cant){
    TLista aux;
    TCola C;
    aux=listaA[i]->sig;
    *alc=0;
    iniciaC(&C);
    poneC(&C,i);
    (*cant)=0;
    k=0;
    while(*alc==0 && k<=n){
        sacaC(&C,&i);
        k++;
        aux=listaA[i]->sig;
        while(aux!=NULL && *alc==0){
            if(aux->posicion==j)
                *alc=1;
            else{
                if(visitados[aux->posicion]==0){
                    poneC(&C,aux->posicion);
                    visitados[aux->posicion]=1;
                    (*cant)++;
                }
                aux=aux->sig;
            }
        }
    }
    while(!vaciaC(C)){
        (*cant)--;
        sacaC(&C,&i)
    }


}
