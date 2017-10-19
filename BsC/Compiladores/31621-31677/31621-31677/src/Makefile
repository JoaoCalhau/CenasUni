CC = gcc
CFLAGS = -g
OUTFILE = ya
LIBS = -lm



all: parser.c lexer.c
	$(CC) $(CFLAGS) parser.c lexer.c -o $(OUTFILE) $(LIBS)

parser.c: ya.y
	bison -y -d -v ya.y -o parser.c

lexer.c: ya.lex
	flex -o lexer.c ya.lex


run: $(OUTFILE)
	./$(OUTFILE)

runtests: $(OUTFILE)
	@echo ——————Correr ficheiros de teste———————
	@echo ——————————————————————example1.ya————————————————————————
	./$(OUTFILE) < example1.ya
	@echo ——————————————————————example2.ya———————————————————————
	./$(OUTFILE) < example2.ya
	@echo ——————————————————————example6.ya——————————————————————
	./$(OUTFILE) < example6.ya




clean: 
	rm -rf parser.c lexer.c parser.h
	rm -f *~
	rm -f *.o
	rm -f ya
