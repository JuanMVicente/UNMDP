//iniciar agenda, agregar contacto, listar agenda, buscar por
//nombre (búsqueda lineal).
#define LONGNUM 15
#define LONGNAME 20
#define MAX 30

typedef struct{
    char nombre[LONGNAME];
    char numero[LONGNUM];
}Tcontacto;

void iniciaagenda(unsigned int *n);
void agrega(Tcontacto agenda[],unsigned int *n,char nom[],char tel[]);
int ordena(Tcontacto agenda[], unsigned int n, char nom[]);
Tcontacto gencontacto(char nom[], char tel[]);
void mueve(Tcontacto agenda[], unsigned int N, unsigned int i);
void listar(Tcontacto agenda[],unsigned int n);
void busca(Tcontacto agenda[], unsigned int n, char nom[]);
