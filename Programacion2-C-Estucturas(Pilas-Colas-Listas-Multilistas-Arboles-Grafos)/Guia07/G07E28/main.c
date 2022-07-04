#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    return 0;
}
//ejercicio a
int nodos(arbolN A, posicion p){
    if(nulo(p))
        return 0;
    else
        return 1+nodos(A,HijoMasIzq(p,A))+nodos(A,(HnoDer(p,A));
}

void nodosV(arbolN A,posicion p, int * n){//*n inicializado en 0
    if(!nulo(p)){
        *n+=1;
        nodosV(A,HijoMasIzq(p,A),n);
        nodosV(A,HnoDer(p,A),n);
        }
    }
}
//ejercicio b
void porcentaje(arbolN A, float *prom){
    posicion p;
    int cantNodo=0, nodoPar=0;
    if(A!=NULL){
        p=Raiz(A)
        calculo(A,p,&cantNodo,&nodoPar);
        if(!cantNodo)
            (*prom)=nodoPar/cantNodo;
    }
}

/*void calculo(arbolN A, posicion p, int * cantNodo, int * nodoPar){
    int aux1, aux2;
    if(Nulo(p)){
        (*n)=0;
        (*nodoPar)=0;
    }
    else{
        calculo(A,HijoMasIzq(p,A), cantNodo, nodoPar);
        calculo(A,HnoDer(p,A), &aux1, &aux2);
        if(Info(p,A)%2==0)
            (*nodoPar)+=aux2+1;
        else
            (*nodoPar)+=aux2;
        (*cantNodo)+=aux1+1;
    }
}*/
void calculo(arbolN A, posicion p, int * cantNodo, int * nodoPar){
    if(!Nulo(p)){
        if(Info(p,A)%2==0)
            (*nodoPar)+=1;
        (*cantNodo)+=1;
        calculo(A,HijoMasIzq(p,A), cantNodo, nodoPar);
        calculo(A,HnoDer(p,A), &aux1, &aux2);
    }
}



//ejercicio c

void grado(arbolN A, posicion p, int * gradoP, int * gradoA){
    int gradoPaux,gradoAaux;
    if (Nulo(p)){
        *gradoP=0;
        *gradoA=0;
    }
    else{
        grado(A,HijoMasIzq(p,A),gradoP, gradoA);
        grado(A,HnoDer(p,A),&gradoPaux,&gradoAaux);
        if((*gradoP)>(*gradoA) && (*gradoP)>gradoAaux)
                *gradoA=*gradoP;
        else
            if(gradoAaux>(*gradoA) && gradoAaux>(*gradoP))
                *gradoA=*gradoAaux;
        (*gradoP)=gradoPaux+1;
    }
}

int grado(arbolN A, posicion p){
    int aux, aux1,aux2;
    posición c;
    if(Nulo(p))
        return 0;
    else
        if(Nulo(HijoMasIzq(A,p)))
            aux=0;
        else{
            aux=1
            c=HijoMasIzq(A,p)
            while(!Nulo(HnoDer(A,c))){
                c=HnoDer(A,c)
                aux++;
            }
        }
        aux1=grado(A,HijoMasIzq(A,p));
        aux2=grado(A,HnoDer(A,p));
        if(aux2<aux1)
            if(aux>aux1)
                return aux;
            else
                return aux1;
        else
            if(aux>aux2)
                return aux;
            else
                return aux2;
}

//ejercicio d

void cantGrado(arbolN A, posicion p, int * gradoP, int * cantGradoPar, int Nivel){
    int gradoPaux,cantGradoParAux;
    if (Nulo(p)){
        *gradoP=0;
        *cantGradoPar=0;
    }
    else{
        cantGrado(A,HijoMasIzq(p,A),gradoP, cantGradoPar, Nivel+1);
        cantGrado(A,HnoDer(p,A),&gradoPaux,&cantGradoParAux, Nivel);
        if(Nivel%2!=0 && (*gradoP)%2)
            (*cantGradoPar)+=1+cantGradoParAux;
        (*gradoP)=gradoPaux+1;
    }
}

int cantGrado(arbolN A, posicion p, int Nivel){
    if (Nulo(p)){
        return 0;
    }
    else{
        aux1=cantGrado(A,HijoMasIzq(p,A), Nivel+1);
        aux2=cantGrado(A,HnoDer(p,A), Nivel);
        if(Nivel%2!=0 && (grado(A,p))%2)
            return 1+ cantGrado(A,HijoMasIzq(p,A), Nivel+1) + cantGrado(A,HnoDer(p,A), Nivel);
        else
            return cantGrado(A,HijoMasIzq(p,A), Nivel+1) + cantGrado(A,HnoDer(p,A), Nivel);
    }
}

int grado(arbolN A, posicion p){
    int aux;
    if(nulo(HijoMasIzq(A,p)))
        return 0;
    else{
        p=HijoMasIzq(A,p);
        aux=1;
        while(!nulo(Hnoder(A,p)){
            p=Hnoder(A,p);
            aux++;
        }
        return aux;
    }
}
int grado(arbolN A, posicion p){
    if(!A){
        return 0;
    else
        return 1+grado(A,HnoDer(A,p));
    }
}

//ejercicio e

int claveHijos(arbolN A, posicion p){
    int aux;
    if(nulo(p))
        return 1;
    else{
        if(Nulo(HijoMasIzq(A,p))
            return 1;
        else
            if(gradoA==info(A,p))
                return claveHijos(A,hijoMasIzq(A,p)) && claveHijos(A,HnoDer(A,p));
    }
}

int grado(arbolN A, posicion p){
    int aux;
    if(nulo(HijoMasIzq(A,p)))
        return 0;
    else{
        p=HijoMasIzq(A,p);
        aux=1;
        while(!nulo(Hnoder(A,p)){
            p=Hnoder(A,p);
            aux++;
        }
        return aux;
    }
}

void claveHijos(arbolN A, posicion p,int *grado,int *cumple){
    int auxGrado, auxCumple;
    if(nulo(p))
        *cumple=1;
        *grado=0;
    else{
        claveHijos(A,HijoMasIzq(A,p),grado,cumple);
        claveHijos(A,HnoDer(A,p),auxGrado,&auxCumple);
        if((*cumple) && auxCumple && (*grado)==info(A,p))
            (*cumple)=1;
        else
            (*cumple)=0;
        (*grado)=auxGrado+1;
    }
}

//ejercicio f
void promedio1(arbolN A, posicion p,int k,int nivel,Tdato *suma,int *cant){
    int auxSuma,auxCant;
    if(nulo(p) || nivel>k){
        *suma=0;
        *cant=0
    }
    else{
        promedio1(A,HijoMasIzq(A,p),k,nivel+1,suma,cant);
        promedio1(A,HnoDer(A,p),k,nivel,&auxSuma,&auxCant);
        if(nivel==k){
            (*suma)+=info(A,p)+auxSuma;
            (*cant)+=1+auxCant;
        }
        else{
            (*suma)+=auxSuma;
            (*cant)+=auxCant;
        }
    }
}

void promedio(arbolN A, posicion p, int k, float * prom){
    int cant;
    Tdato suma;
    promedio(A,p,k,1,&suma,&cant);
    (*prom)=suma/cant;
}
