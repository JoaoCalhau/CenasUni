/* trie interface */

#include <stdbool.h>

struct trie;

struct trie *trie_new(void);
void trie_destroy(struct trie *);

bool trie_empty(struct trie *);

bool trie_find(struct trie *, char []);
void trie_insert(struct trie *, char []);
void trie_remove(struct trie *, char []);

int trie_count(struct trie *, char []);

void trie_print(struct trie *);
void trie_print_completions(struct trie *, char []);
