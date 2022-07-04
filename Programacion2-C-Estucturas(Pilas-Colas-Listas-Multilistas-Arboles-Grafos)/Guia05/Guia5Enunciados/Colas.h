#include <stdio.h>
#include <stdlib.h>
#define MAX 50

typedef int TElementoC;

typedef struct {
    TElementoC datos[MAX];
    int pri, ult; } TCola;


void iniciaC(TCola *C);
int vaciaC(TCola C);
void poneC(TCola *C, TElementoC x);
void sacaC(TCola *C, TElementoC *x);
TElementoC consultaC(TCola C);
void mostrarC(TCola *C);
