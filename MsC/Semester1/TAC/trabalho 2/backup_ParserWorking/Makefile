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
	@echo '[fig-9.ir2]'
	@./tacl < examples/fig-9.ir2

clean :
	@$(RM) tacl
	@$(RM) tacl.tab.c tacl.tab.h
	@$(RM) lex.yy.c
	@$(RM) tacl.output
