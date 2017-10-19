#include <stdio.h>

#include "tries.h"

char *words[] = {
  "acabais",
  "acocora",
  "amuareis",
  "aramada",
  "arpoavam",
  "azoto",
  "barceiro",
  "barco",
  "cabulais",
  "coragem",
  "corasse",
  "cuja",
  "embarace",
  "ensaquem",
  "enxuguem",
  "festeiro",
  "laringes",
  "mar",
  "propugno",
  "remem",
  "salteada",
  "repudiei",
  "reactive",
  "festa",
  "leque",
  "festarola",
  "achar",
  "enteados",
  "marujar",
  "vinte",
  NULL
};

/*
   Fazer um programa que:

   1. insere todas as palavras em words[] numa trie

   2. confirma que trie_find() as encontra todas

   3. diz quantas palavras existem na trie

   4. mostra completações possíveis de "a" "ac" "mar" "por"

   5. remove algumas palavras da trie

   6. mostra todo o conteúdo da trie, antes e depois de remover
      palavras
*/

int main()
{  
  int i=0;
  struct trie *t = trie_new();
  char *wordz[] = {"cenas", NULL};
  //1.

  while(words[i] != NULL) {
    trie_insert(t, words[i]);
    i++;
  }
  printf("Insert Done!\n");
  printf("\n");

  //2.
  i=0;
  while(words[i] != NULL) {
    if (trie_find(t, words[i]))
      printf("true\n");
    else
      printf("false\n");
    i++;
  }

  if(trie_find(t, wordz[0]))
    printf("true\n");
  else
    printf("false\n");

  printf("Test Done!\n");
  printf("\n");
  //3. No ficheiro tries.c

  //4.
  printf("%d\n", trie_count(t, "a"));
  printf("%d\n", trie_count(t, "ac"));
  printf("%d\n", trie_count(t, "mar"));
  printf("%d\n", trie_count(t, "por"));

  //5.

  trie_destroy(t);

  return 0;
}