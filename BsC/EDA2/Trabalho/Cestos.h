struct item;
struct Cesto;

struct Cesto *Cesto_new(char identificador[], short idade);
void Cesto_free(struct Cesto *cesto);
void Cesto_insert(struct Cesto *cesto, char codigo[], short quantidade, float price, short age);