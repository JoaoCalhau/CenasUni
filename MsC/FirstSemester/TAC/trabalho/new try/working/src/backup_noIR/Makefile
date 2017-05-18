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
	@echo '[twice.tacl]'
	@./tacl < examples/twice.tacl

run-2 : tacl
	@echo '[fibonacci.tacl]'
	@./tacl < examples/fibonacci.tacl

run-3 : tacl
	@echo '[factorial.tacl]'
	@./tacl < examples/factorial.tacl

run-4 : tacl
	@echo '[figure9.tacl]'
	@./tacl < examples/figure9.tacl

run-5 : tacl
	@echo '[g.tacl]'
	@./tacl < examples/g.tacl

run-6 : tacl
	@echo '[procedure.tacl]'
	@./tacl < examples/triangular.tacl

run-7 : tacl
	@echo '[example.tacl]'
	@./tacl < examples/example.tacl

run-8 : tacl
	@echo '[var.tacl]'
	@./tacl < examples/var.tacl

run-9 : tacl
	@echo '[proc.tacl]'
	@./tacl < examples/proc.tacl

clean :
	@$(RM) tacl
	@$(RM) tacl.tab.c tacl.tab.h
	@$(RM) lex.yy.c
