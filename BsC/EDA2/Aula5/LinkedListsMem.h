#include <stdbool.h>

struct linkedList;

struct  linkedList *list_open(char *name);

bool list_empty(struct linkedList *l);

bool list_insert(struct linkedList *l, int v);
bool list_remove(struct linkedList *l, int v);

void list_print(struct linkedList *l);

int list_find(struct linkedList *l, int v);

int list_close(struct linkedList *l);

int list_length(struct linkedList *l);

int list_nth(struct linkedList *l, int n);