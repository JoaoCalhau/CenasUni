CC = gcc -Wall
YACC = bison -d -v
LEX = flex


ya : ya.tab.c lex.yy.c
	$(CC) $^ -o $@ -lfl

ya.tab.c : ya.y
	$(YACC) $^

lex.yy.c : ya.lex
	$(LEX) $^

run : ya
	@./ya