#include <stdio.h>
#include <stdlib.h>
#define N 20

typedef struct nodo{
    char dato;
    struct nodo * izq, * der;} nodo;
typedef nodo * arbol;

int main()
{
    printf("Hello world!\n");
    return 0;
}
//Corregir los errores en la siguiente función void, la cual genera un arreglo de caracteres con los  nodos de grado 2 de un árbol binario
void arrgrado2(arbol a, char v[N], int * dimv) {
 if (a != NULL) {
    if(a->izq != NULL && a->der != NULL) {/* grado 2 */
        (*dimv)++;
        v[*dimv] = a->dato;
    } else
        arrgrado2(a->izq, v, dimv);
        arrgrado2(a->der, v, dimv);
 }
}
//este es el q NO esta arreglado
void arrgrado2(arbol a, char v[N], int dimv) {
 if (a != NULL) {
 if(a->izq != NULL && a->der == NULL) {/* grado 2 */
 (*dimv)++;
 v[dimv] = a->dato;
 } else
 arrgrado2(a->izq, v[], dimv);
 arrgrado2(a->der, v[], dimv);
 }
}
