CC = gcc -Wall
YACC = bison -d -v
LEX = flex


tacl : tacl.tab.c lex.yy.c ast.c ir.c
	$(CC) $^ -o $@ -lfl

tacl.tab.c : tacl.y
	$(YACC) $^

lex.yy.c : tacl.lex
	$(LEX) $^


run : tacl
	@./tacl

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

clean :
	@$(RM) tacl
	@$(RM) tacl.tab.c tacl.tab.h
	@$(RM) lex.yy.c
