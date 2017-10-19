#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <unistd.h>


#include "LinkedListsMem.h"

#define NIL 0;

struct node {
	int element;
	int next;
};

struct header {
	int head;
	int used,
		free;
};

struct linkedList {
	int fd;
	struct header header;
};

struct linkedList *list_open(char *name) {
	int fd;

	fd = open(name, O_CREAT | O_RDWR, S_IRUSR | S_IWUSR);

	if (fd == -1) {
		perror("open");

		return NULL;
	}

	struct linkedList *list = malloc(sizeof(struct linkedList));

	switch (read(fd, &list->header, sizeof(struct header))) {
		case -1:
			perror("read");

			close(fd);

			return NULL;
		case 0:
			list->fd = fd;
			list->header.head = NIL;
			list->header.used = NIL;
			list->header.free = NIL;

			return list;
		default:
			list->fd = fd;
			
			return list;
	}
}



int list_close(struct linkedList * l) {

}