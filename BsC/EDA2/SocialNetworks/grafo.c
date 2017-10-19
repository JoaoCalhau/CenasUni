#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define P_MAX 2000

struct Graph {
	short matriz[P_MAX][P_MAX];
	short p, r;
};

struct Graph *Graph_new() {
	struct Graph *graph = malloc(sizeof(*graph));
	
	int i, j;
	for(i=0; i<P_MAX; i++) {
		for(j=0; j<P_MAX; j++) {
			graph->matriz[i][j] = 0;
		}
	}

	short p, r;
	scanf("%hd %hd\n", &p, &r);

	graph->p = p;
	graph->r = r;

	return graph;
}

void Graph_free(struct Graph *graph) {
	free(graph);
}

void Graph_input(struct Graph *graph) {
	short in1, in2, in3, ciclo = 0;

	while(ciclo < graph->r) {
		scanf("%hd %hd %hd\n", &in1, &in2, &in3);

		graph->matriz[in1-1][in2-1] = in3;
		graph->matriz[in2-1][in1-1] = in3;

		ciclo++;
	}
}

void Mst_prim(struct Graph *graph) {
	
}

int main() {
	struct Graph *graph = Graph_new();
	Graph_input(graph);

	printf("\n");
	int i, j;
	for(i=0; i<4; i++) {
		for(j=0; j<4; j++) {
			printf("%hd ", graph->matriz[j][i]);
		}
		printf("\n");
	}

	Graph_free(graph);

	return 0;
}