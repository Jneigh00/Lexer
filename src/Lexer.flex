/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2000 Gerwin Klein <lsf@jflex.de>                          *
 * All rights reserved.                                                    *
 *                                                                         *
 * Thanks to Larry Bell and Bob Jamison for suggestions and comments.      *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

%%

%class Lexer
%byaccj

%{

  public Parser   parser;
  public int      lineno;
  public int      column;

  public Lexer(java.io.Reader r, Parser parser) {
    this(r);
    this.parser = parser;
    this.lineno = 1;
    this.column = 1;
  }
%}

int         = [0-9]+
float       = [0-9]+("."[0-9]+)?
identifier  = [a-zA-Z][a-zA-Z0-9_]*
newline     = \n
whitespace  = [ \t\r]+
linecomment = "##".*
blockcomment=  "#{"([^]|\n)*"}#"
defines =    "#define"

%%

"var"                               { parser.yylval = new ParserVal((Object)yytext()); return Parser.VAR   ;   }
"void"                              { parser.yylval = new ParserVal((Object)yytext()); return Parser.VOID   ;  }
"print"                             { parser.yylval = new ParserVal((Object)yytext()); return Parser.PRINT   ; }
"bool"                              { parser.yylval = new ParserVal((Object)yytext()); return Parser.BOOL   ; }
"float"                             { parser.yylval = new ParserVal((Object)yytext()); return Parser.FLOAT   ; }
"struct"                            { parser.yylval = new ParserVal((Object)yytext()); return Parser.STRUCT   ; }
"size"                              { parser.yylval = new ParserVal((Object)yytext()); return Parser.SIZE   ; }
"new"                               { parser.yylval = new ParserVal((Object)yytext()); return Parser.NEW   ; }
"if"                                { parser.yylval = new ParserVal((Object)yytext()); return Parser.IF   ; }
"else"                              { parser.yylval = new ParserVal((Object)yytext()); return Parser.ELSE   ; }
"while"                             { parser.yylval = new ParserVal((Object)yytext()); return Parser.WHILE   ; }
"return"                            { parser.yylval = new ParserVal((Object)yytext()); return Parser.RETURN   ; }
"break"                             { parser.yylval = new ParserVal((Object)yytext()); return Parser.BREAK   ; }
"continue"                          { parser.yylval = new ParserVal((Object)yytext()); return Parser.CONTINUE   ; }
"true"                              { parser.yylval = new ParserVal((Object)yytext()); return Parser.BOOL_LIT   ; }
"false"                             { parser.yylval = new ParserVal((Object)yytext()); return Parser.BOOL_LIT   ; }
"["                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.LBRACKET   ; }
"]"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.RBRACKET   ; }
","                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.COMMA   ; }
"."                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.DOT   ; }
"&"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.ADDR   ; }
"&"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.ADDR   ; }
"-"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.OP   ; }
"*"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.OP   ; }
"/"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.OP   ; }
"and"                               { parser.yylval = new ParserVal((Object)yytext()); return Parser.OP   ; }
"or"                                { parser.yylval = new ParserVal((Object)yytext()); return Parser.OP   ; }
"not"                               { parser.yylval = new ParserVal((Object)yytext()); return Parser.OP   ; }
"func"                              { parser.yylval = new ParserVal((Object)yytext()); return Parser.FUNC    ; }
"int"                               { parser.yylval = new ParserVal((Object)yytext()); return Parser.INT     ; }
"{"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.BEGIN   ; }
"}"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.END     ; }
"("                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.LPAREN  ; }
")"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.RPAREN  ; }
";"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.SEMI    ; }
"<-"                                { parser.yylval = new ParserVal((Object)yytext()); return Parser.ASSIGN  ; }
"->"                                { parser.yylval = new ParserVal((Object)yytext()); return Parser.FUNCRET ; }
"+"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.OP      ; }
"<"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.RELOP   ; }
"="                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.RELOP   ; }
"!="                                { parser.yylval = new ParserVal((Object)yytext()); return Parser.RELOP   ; }
">"                                 { parser.yylval = new ParserVal((Object)yytext()); return Parser.RELOP   ; }
"<="                                { parser.yylval = new ParserVal((Object)yytext()); return Parser.RELOP   ; }
">="                                { parser.yylval = new ParserVal((Object)yytext()); return Parser.RELOP   ; }
{int}                               { parser.yylval = new ParserVal((Object)yytext()); return Parser.INT_LIT ; }
{float}                             { parser.yylval = new ParserVal((Object)yytext()); return Parser.FLOAT_LIT ; }
{identifier}                        { parser.yylval = new ParserVal((Object)yytext()); return Parser.IDENT   ; }
{linecomment}                       { System.out.print(yytext()); /* skip */ }
{newline}                           { System.out.print(yytext()); lineno++; column = 1; /* skip */ }
{whitespace}                        { System.out.print(yytext()); column += yytext().length(); /* skip */ }
{blockcomment}                      { System.out.print(yytext());String[] skipLines = yytext().split("\n");
                                       lineno+= skipLines.length -1; column+=2;                      /* skip */ }
"#define" =                         { parser.yylval = new ParserVal((Object)yytext()); System.out.println("Works"); return Parser.DEF;}

\b     { System.err.println("Sorry, backspace doesn't work"); }

/* error fallback */
[^]    { System.err.println("Lexical error: unexpected character '"+yytext()+"'" + " at " + lineno + ":" + column + "."); return -1; }
