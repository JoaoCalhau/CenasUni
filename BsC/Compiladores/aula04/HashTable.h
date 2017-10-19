ht *ht_create(int size);

int ht_hash(ht *hashTable, char *key);

entry *ht_newpair(char *key, char *value);

void ht_set(ht *hashTable, char *key, char *value);

char *ht_get(ht *hashTable, char *key);