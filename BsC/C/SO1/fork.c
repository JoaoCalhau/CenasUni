#include <sys/types.h>
#include<stdio.h>
#include<unistd.h>

void fork() {
	puts("TESTE FORK:\n");

	pid_t pid;

	pid = fork();

	if (pid>0) {
		printf("Processo Pai PID: %d ", pid);
	}else {
		printf("Processo Filho PID: %d ", pid);
	}

	puts("FIM");
}
