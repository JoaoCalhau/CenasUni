PARSER = Tacl

JAVAC = javac -classpath $(CLASSPATH)
JAVA = java -classpath $(CLASSPATH)
YACC = $(CUP) -parser $(PARSER) -nosummary
LEX = jflex -q

CUP = cup
# or
# CUP = java -classpath $(CUP_JAR) java_cup.Main
CUP_JAR = /usr/share/java/cup.jar

CLASSPATH = $(CUP_JAR):

$(PARSER).class : $(PARSER).java Yylex.java
	$(JAVAC) $^

$(PARSER).java sym.java : tacl.cup
	@echo "* ignore all messages regarding non used terminals" >&2
	$(YACC) $^

Yylex.java : tacl.lex
	$(LEX) $^


run : $(PARSER).class
	@$(JAVA) $(PARSER)

run-1 : $(PARSER).class
	@echo '[twice.tacl]'
	@$(JAVA) $(PARSER) < ../examples/twice.tacl

run-2 : $(PARSER).class
	@echo '[fibonacci.tacl]'
	@$(JAVA) $(PARSER) < ../examples/fibonacci.tacl

run-3 : $(PARSER).class
	@echo '[errors.tacl]'
	@$(JAVA) $(PARSER) < ../examples/errors.tacl

run-a : $(PARSER).class
	@echo '[full-a.tacl]'
	@$(JAVA) $(PARSER) < ../examples/full-a.tacl

run-b : $(PARSER).class
	@echo '[full-b.tacl]'
	@$(JAVA) $(PARSER) < ../examples/full-b.tacl

clean :
	@$(RM) $(PARSER).java $(PARSER).class 'CUP$$$(PARSER)$$actions'.class
	@$(RM) sym.java sym.class
	@$(RM) Yylex.java{,~} Yylex.class
