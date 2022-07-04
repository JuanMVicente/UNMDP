typedef struct{
    int numerador;
    int denominador;
}fraccion;

void crear(fraccion *f);

void mostrar(fraccion f);

int numerador(fraccion f);

int denominador(fraccion f);

int mcd(int a, int b);

fraccion simplificar(fraccion f);

fraccion sumar(fraccion f1, fraccion f2);

fraccion restar(fraccion f1, fraccion f2);

fraccion multiplicar(fraccion f1, fraccion f2);

fraccion dividir(fraccion f1, fraccion f2);

void iguales(fraccion f1, fraccion f2);
