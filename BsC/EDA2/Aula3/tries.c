/* trie implementation */

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#include "tries.h"

#define ALPH_MIN 'a'
#define ALPH_MAX 'z'
#define ALPH_SIZE (ALPH_MAX - ALPH_MIN + 1)

#define POS(c)  ((c) - ALPH_MIN)		// character position
#define CHAR(p) ((p) + ALPH_MIN)		// character in position

/* trie node */
struct node {
  struct node *child[ALPH_SIZE];
  bool	      word;
};

/* trie */
struct trie {
  struct node *root;
};


/* allocates and returns a new trie node */
static struct node *node_new()
{
  struct node *node = malloc(sizeof(*node));
  int i;

  node->word = false;
  for (i = 0; i < ALPH_SIZE; ++i)
    node->child[i] = NULL;

  return node;
}


/* frees a trie NODE */
static void node_free(struct node *node)
{
  free(node);
}


/* destroys the sub-trie with root NODE */
static void node_destroy(struct node *node)
{
  int i;

  if (node == NULL)
    return;

  for (i = 0; i < ALPH_SIZE; ++i)
    node_destroy(node->child[i]);

  node_free(node);
}


/* creates a new, empty trie */
struct trie *trie_new()
{
  struct trie *trie = malloc(sizeof(struct trie));

  if (trie)
    trie->root = NULL;

  return trie;
}


/* destroys trie T, freeing up its space */
void trie_destroy(struct trie *t)
{
  node_destroy(t->root);

  free(t);
}


/* checks whether trie T is empty */
bool trie_empty(struct trie *t)
{
  return t->root == NULL;
}


/* inserts word P into trie T */
void trie_insert(struct trie *t, char p[])
{
  struct node *n;
  int i = 0;

  if (t->root == NULL)
    t->root = node_new();

  n = t->root;

  // follow the word down the trie as long as possible
  while (p[i] != '\0' && n->child[POS(p[i])] != NULL)
    {
      n = n->child[POS(p[i])];
      i++;
    }

  // insert the new suffix into the trie
  while (p[i] != '\0')
    {
      n->child[POS(p[i])] = node_new();
      n = n->child[POS(p[i])];

      i++;
    }

  n->word = true;
}


/* searches word P in trie T
   returns true if it finds it, false otherwise */

bool trie_find(struct trie *t, char p[])
{
  struct node *n;
  //2.
  n = t->root;
  int i = 0;

  while (n != NULL && p[i] != '\0') {
    n = n->child[POS(p[i])];
    i++;
  }

  return (n != NULL && n->word);
}


/* counts the number of words with prefix P in trie T */

int trie_count(struct trie *t, char p[])
{
  struct node *n;
  //3.
  n = t->root;
  int i = 0, j=0, count = 0;
  bool encontrou = false;

  while (n != NULL && p[i] != '\0') {
    n = n->child[POS(p[i])];
    i++;
    if (p[i] == '\0')
      encontrou = true;
    else
      return 0;
  }

  if (encontrou) {
    for (i=0; i < ALPH_SIZE; i++) {
      n = n->child[CHAR(i)];
      if ()
    }
  }

}



/* prints all words in trie T with prefix P */
/*
void trie_print_completions(struct trie *t, char p[])
{
  4.
}
*/


/* removes word P from trie T */
/*
void trie_remove(struct trie *t, char p[])
{
  5.
}
*/


/* prints the full contents of trie T */
/*
void trie_print(struct trie *t)
{
  6.
}
*/