%{
#include <stdlib.h>
#include <string.h>

  struct {
    char *val;
    enum {ARTIGO, VERBO, NOME, PONTUACAO} kind;
    int position[2];
  } yylval;

  int line = 0;        /* linha actual */
  int column = 0;      /* coluna actual */
  
#define INC_LINE line++;column=0
#define INC_COL  column+=strlen(yytext)
%}

ARTIGO  "o"
VERBO   "comer"|"jantar"|"fritar"
NOME    "gato"|"rato"
PONTUACAO   "."|"!"|"?"|"..."
ESPACO  [\t ]+
PALAVRA [a-z]+
%%


{ARTIGO}   { yylval.val = strdup(yytext);
             yylval.kind = ARTIGO;
       printf("ARTIGO: %s\n", yytext);
       INC_COL; }
{VERBO}    { yylval.val = strdup(yytext);
             yylval.kind = VERBO;
       printf("VERBO: %s\n", yytext);
       INC_COL; }
{NOME}     { yylval.val = strdup(yytext);
             yylval.kind = NOME;
       printf("NOME: %s\n", yytext);
       INC_COL; }
{PONTUACAO}   { yylval.val = strdup(yytext);
                yylval.kind = PONTUACAO;
    printf("PONTUACAO: \"%s\"\n", yytext);
    INC_COL; }
\n     { INC_LINE; }
{ESPACO}   { INC_COL; }
{PALAVRA}  { printf("DESCONHECIDO: \"%s\"\n", yytext);
             INC_COL; }
.    { printf("Erro lexical na linha %d, caracter %d\n", line, column); }

%%

int yywrap()  {return 1;}

int main() { yylex(); }
