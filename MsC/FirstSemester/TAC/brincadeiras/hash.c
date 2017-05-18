#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define SIZE 1024

typedef struct ht_entry {
	char *name;
	char *type;
	char *kind;
	struct ht_entry *next;
} ht_entry ;

typedef struct HashTable {
	int size;
	ht_entry **table;
} ht ;

ht *ht_create() {
	ht *hashtable = NULL;
	int i;

	if(SIZE < 1) 
		return NULL;

	if((hashtable = malloc(sizeof(ht))) == NULL )
		return NULL;

	if((hashtable->table = malloc(sizeof(ht_entry *) * SIZE )) == NULL)
		return NULL;

	for(i = 0; i < SIZE; i++)
		hashtable->table[i] = NULL;

	hashtable->size = 0;

	return hashtable;
}

int djb2(unsigned char *str) {
	unsigned long hash = 5381;
	int c;

	while(c = *str++)
		hash = ((hash << 5) + hash) + c;

	return hash % SIZE;
}

ht_entry *ht_newblock(char *name, char *type, char *kind) {
	ht_entry *newblock;

	if((newblock = malloc(sizeof(ht_entry))) == NULL)
		return NULL;

	if((newblock->name = strdup(name)) == NULL)
		return NULL;

	if((newblock->type = strdup(type)) == NULL)
		return NULL;

	if((newblock->kind = strdup(kind)) == NULL)
		return NULL;

	newblock->next = NULL;

	return newblock
}

void ht_set(ht *hashtable, char *name, char *type, char *kind) {
	int currentHash = 0;
	ht_entry *newblock = NULL;
	ht_entry *next = NULL;
	ht_entry *last = NULL;

	currentHash = djb2(name);

	next = hashtable->table[currentHash];

	while(next != NULL && next->name != NULL && strcmp(name, next->name) != 0) {
		free(next->type);
		free(next->kind);

		next->type = type;
		next->kind = kind;
	}

	if(next != NULL && next->key != NULL && strcmp(name, next->key) == 0) {
		free(next->type);
		free(next->kind);

		next->type = strdup(type);
		next->kind = strdup(kind);

	} else {
		newblock = ht_newblock(name, type, kind);

		if(next == hashtable->table[currentHash]) {
			newblock->next = next;
			hashtable->table[currentHash] = newblock;

		} else if(next == NULL) {
			last->next = newblock;

		} else {
			newblock->next = next;
			last->next = newblock;

		}
	}

}

