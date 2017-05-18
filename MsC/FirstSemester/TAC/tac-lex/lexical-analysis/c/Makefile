CC = gcc -Wall
YACC = bison -d -v
LEX = flex


tacl : tacl.tab.c lex.yy.c
	$(CC) $^ -o $@ -lfl

tacl.tab.c : tacl.y
	$(YACC) $^

lex.yy.c : tacl.lex
	$(LEX) $^


run : tacl
	@./tacl

run-1 : tacl
	@echo '[twice.tacl]'
	@./tacl < ../examples/twice.tacl

run-2 : tacl
	@echo '[fibonacci.tacl]'
	@./tacl < ../examples/fibonacci.tacl

run-3 : tacl
	@echo '[errors.tacl]'
	@./tacl < ../examples/errors.tacl

run-a : tacl
	@echo '[full-a.tacl]'
	@./tacl < ../examples/full-a.tacl

run-b : tacl
	@echo '[full-b.tacl]'
	@./tacl < ../examples/full-b.tacl

clean :
	@$(RM) tacl
	@$(RM) tacl.tab.c tacl.tab.h
	@$(RM) lex.yy.c
