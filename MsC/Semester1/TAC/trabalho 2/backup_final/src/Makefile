CC = gcc -Wall -g
YACC = bison -d -v
LEX = flex


tacl : tacl.tab.c lex.yy.c
	$(CC) $^ -o $@ -lfl

tacl.tab.c : tacl.y
	$(YACC) $^

lex.yy.c : tacl.lex
	$(LEX) $^

run-1 : tacl
	@echo '[example]'
	@./tacl < examples/example.ir2

run-2 : tacl
	@echo '[factorial]'
	@./tacl < examples/factorial.ir2

run-3 : tacl
	@echo '[fig-9]'
	@./tacl < examples/fig-9.ir2

run-4 : tacl
	@echo '[ragbag]'
	@./tacl < examples/ragbag.ir2

run-5 : tacl
	@echo '[triangular]'
	@./tacl < examples/triangular.ir2

run-6 : tacl
	@echo '[twice]'
	@./tacl < examples/twice.ir2

save-1 : tacl
	@echo '[example]'
	@./tacl < examples/example.ir2 > results/example.mips

save-2 : tacl
	@echo '[factorial]'
	@./tacl < examples/factorial.ir2 > results/factorial.mips

save-3 : tacl
	@echo '[fig-9]'
	@./tacl < examples/fig-9.ir2 > results/fig-9.mips

save-4 : tacl
	@echo '[ragbag]'
	@./tacl < examples/ragbag.ir2 > results/ragbag.mips

save-5 : tacl
	@echo '[triangular]'
	@./tacl < examples/triangular.ir2 > results/triangular.mips

save-6 : tacl
	@echo '[twice]'
	@./tacl < examples/twice.ir2 > results/twice.mips

save-all : tacl
	@echo '[example]'
	@./tacl < examples/example.ir2 > results/example.mips
	@echo '[factorial]'
	@./tacl < examples/factorial.ir2 > results/factorial.mips
	@echo '[fig-9]'
	@./tacl < examples/fig-9.ir2 > results/fig-9.mips
	@echo '[ragbag]'
	@./tacl < examples/ragbag.ir2 > results/ragbag.mips
	@echo '[triangular]'
	@./tacl < examples/triangular.ir2 > results/triangular.mips
	@echo '[twice]'
	@./tacl < examples/twice.ir2 > results/twice.mips

clean :
	@$(RM) tacl
	@$(RM) tacl.tab.c tacl.tab.h
	@$(RM) lex.yy.c
	@$(RM) tacl.output
	@$(RM) results/*.mips
