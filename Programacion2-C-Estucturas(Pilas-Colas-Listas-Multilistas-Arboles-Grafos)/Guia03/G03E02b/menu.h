#define LONGNUM 15
#define LONGNAME 20
#define MAX 30

void iniciaagenda(unsigned int *n);
void agrega(char nombre[][MAX], char telefono[][MAX],unsigned int *n,char nom[],char tel[]);
int ordena(char nombre[][MAX], unsigned int n, char nom[]);
void mueve(char nombre[][MAX], char telefono[][MAX], unsigned int N, unsigned int i);
void listar(char nombre[][MAX], char telefono[][MAX],unsigned int n);
void busca(char nombre[][MAX], char telefono[][MAX], unsigned int n, char nom[]);
