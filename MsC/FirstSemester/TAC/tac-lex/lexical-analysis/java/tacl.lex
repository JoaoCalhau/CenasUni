
import java_cup.runtime.Symbol;

%%

%cup

%char
%line

%{
  private Symbol token(int id, Object value) {
    return new Symbol(id, yychar, yyline, value);
  }

  private Symbol token(int id) {
    return token(id, yytext());
  }
%}

%eofval{
  return token(sym.EOF);
%eofval}

%%

fun			{ return token(sym.FUN); }

"("			{ return token(sym.OPPAR); }
")"			{ return token(sym.CLPAR); }

[_a-zA-Z][_a-zA-Z0-9]*	{ return token(sym.ID /* ... */); }

[0-9]+			{ return token(sym.INT_LITERAL, new Integer(yytext())); }

#.*			{ /* ignore comments */ }

[\ \n\t]+		{ /* and whitespace */ }

.	      {
	        System.err.println("unrecognised character: `" + yytext() + "'");

		return token(sym.ERROR);
	      }
