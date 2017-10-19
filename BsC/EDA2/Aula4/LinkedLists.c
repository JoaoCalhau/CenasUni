#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#include "LinkedLists.h"

struct node {
	struct node *nextNode;
	int value;
};

struct linkedList {
	struct node *header;
	int size;
};

static struct node *node_new() {
	struct node *node = malloc(sizeof(*node));

	node->nextNode = NULL;

	return node;
}

static void node_free(struct node *node) {
	free(node);
}

static void node_destroy(struct node *node) {
	if (node == NULL)
		return;

	node_destroy(node->nextNode);

	node_free(node);
}

struct linkedList *list_new() {
	struct linkedList *list = malloc(sizeof(struct linkedList));

	list->header = node_new();
	list->size = 0;

	return list;
}

bool list_empty(struct linkedList *l) {
	return (l->size == 0);
}

bool list_insert(struct linkedList *l, int v) {
	struct node *newNode = node_new();
	newNode->value = v;

	newNode->nextNode = l->header->nextNode;
	l->header->nextNode = newNode;
	
	l->size++;
	return true;
}

bool list_remove(struct linkedList *l, int v) {
	struct node *node = l->header;
	struct node *NodeRemove = NULL;
	struct node *nodeNext = NULL;

	while (node->nextNode != NULL || node->nextNode->value != v) {
		node = node->nextNode;
	}

	if (node->nextNode == NULL || node->nextNode->value != v)
		return false;
	else {
		NodeRemove = node->nextNode;
		nodeNext = node->nextNode->nextNode;
		node->nextNode = nodeNext;
		node_free(NodeRemove);
		return true;
	}
}

void list_print(struct linkedList *l) {
	struct node *n = l->header;

	printf("[");
	while (n->nextNode != NULL) {
		printf(" %d", n->nextNode->value);
		n = n->nextNode;
	}

	printf("]");
}

/*
int list_find(struct linkedList *l, int v) {

}

void list_destroy(struct linkedList *l) {

}

int list_length(struct linkedList *l) {

}

int list_nth(struct linkedList *l, int n) {

}
*/