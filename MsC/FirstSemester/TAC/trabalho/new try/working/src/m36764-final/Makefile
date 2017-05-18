CC = gcc -Wall
YACC = bison -d -v
LEX = flex


tacl : tacl.tab.c lex.yy.c ast.c ir.c
	$(CC) $^ -o $@ -lfl

tacl.tab.c : tacl.y
	$(YACC) $^

lex.yy.c : tacl.lex
	$(LEX) $^

run-1 : tacl
	@echo '[example.tacl]'
	@./tacl < examples/example.ast

run-2 : tacl
	@echo '[factorial.tacl]'
	@./tacl < examples/factorial.ast

run-3 : tacl
	@echo '[fibonacci-v2.tacl]'
	@./tacl < examples/fibonacci-v2.ast

run-4 : tacl
	@echo '[fig-9.tacl]'
	@./tacl < examples/fig-9.ast

run-5 : tacl
	@echo '[g.tacl]'
	@./tacl < examples/g.ast

run-6 : tacl
	@echo '[procedure.tacl]'
	@./tacl < examples/procedure.ast

run-7 : tacl
	@echo '[triangular.tacl]'
	@./tacl < examples/triangular.ast

run-8 : tacl
	@echo '[twice.tacl]'
	@./tacl < examples/twice.ast

run-save-1 : tacl
	@echo '[example.tacl] > [example.ir]'
	@./tacl < examples/example.ast > results/example.ir

run-save-2 : tacl
	@echo '[factorial.tacl] > [factorial.ir]'
	@./tacl < examples/factorial.ast > results/factorial.ir

run-save-3 : tacl
	@echo '[fibonacci-v2.tacl] > [fibonacci-v2.ir]'
	@./tacl < examples/fibonacci-v2.ast > results/fibonacci-v2.ir

run-save-4 : tacl
	@echo '[fig-9.tacl] > [fig-9.ir]'
	@./tacl < examples/fig-9.ast > results/fig-9.ir

run-save-5 : tacl
	@echo '[g.tacl] > [g.ir]'
	@./tacl < examples/g.ast > results/g.ir

run-save-6 : tacl
	@echo '[procedure.tacl] > [procedure.ir]'
	@./tacl < examples/procedure.ast > results/procedure.ir

run-save-7 : tacl
	@echo '[triangular.tacl] > [triangular.ir]'
	@./tacl < examples/triangular.ast > results/triangular.ir

run-save-8 : tacl
	@echo '[twice.tacl] > [twice.ir]'
	@./tacl < examples/twice.ast > results/twice.ir

clean :
	@$(RM) tacl
	@$(RM) tacl.tab.c tacl.tab.h
	@$(RM) lex.yy.c
	@$(RM) tacl.output
	@$(RM) results/*.ir
