#include <stdio.h>

#include "lists.h"

#define VALORES 10
#define UM_VALOR 5

int main()
{
  <TIPO_DE_UMA_LISTA> l;
  int c, n;

  l = list_new();

  // testa list_new() + list_empty() de uma lista vazia
  if (!list_empty(l))
    printf("erro: a nova lista n�o est� vazia?\n");

  // testa list_print() de uma lista vazia
  printf("lista vazia: "); list_print(l); printf("\n");

  // testa list_insert()
  for (int i = 1; i <= VALORES; ++i)
    if (!list_insert(l, i))
      printf("erro: problema na inser��o de %d\n", i);

  // testa list_insert() + list_length()
  c = list_length(l);
  if (c != VALORES)
    printf("erro: o comprimento da lista � %d mas devia ser %d\n", c, VALORES);
  else
    printf("o comprimento da lista � %d\n", c);

  // testa list_nth()
  n = list_nth(l, list_length(l) - 1);
  if (n != 1)
    printf("erro: o �ltimo elemento da lista � %d mas devia ser 1\n", n);
  else
    printf("o �ltimo elemento da lista � %d\n", n);

  // testa list_empty() de uma lista n�o vazia
  if (list_empty(l))
    printf("erro: a lista est� vazia?\n");

  // testa list_print() de uma lista n�o vazia
  printf("lista \"cheia\": "); list_print(l); printf("\n");

  // testa list_find()
  for (int i = 1; i <= VALORES; ++i)
    if (!list_find(l, i))
      printf("erro: n�o encontrou %d\n", i);

  // testa list_remove()
  if (!list_remove(l, UM_VALOR))
    printf("erro: problema na remo��o do %d\n", UM_VALOR);

  printf("lista sem %d: ", UM_VALOR); list_print(l); printf("\n");

  // testa list_remove() + list_find()
  if (list_find(l, UM_VALOR))
    printf("erro: encontrou o %d\n", UM_VALOR);

  for (int i = 1; i <= VALORES; ++i)
    if (i != UM_VALOR)
      if (!list_find(l, i))
	printf("erro: n�o encontrou %d\n", i);

  // testa mais list_remove()
  for (int i = 1; i <= VALORES; ++i)
    if (i != UM_VALOR)
      if (!list_remove(l, i))
	printf("erro: problema na remo��o do %d\n", i);

  printf("lista vazia: "); list_print(l); printf("\n");

  if (!list_empty(l))
    printf("erro: a lista devia estar vazia\n");

  list_destroy(l);

  return 0;
}
