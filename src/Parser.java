import java.util.HashMap;

public class Parser
{
    public static final int PRINT       = 10; // "print"
    public static final int FUNC        = 11; // "func"
    public static final int VAR         = 12; // "var"
    public static final int VOID        = 13; // "void"
    public static final int BOOL        = 14; // "bool"
    public static final int INT         = 15; // "int"
    public static final int FLOAT       = 16; // "float"
    public static final int STRUCT      = 17; // "struct"
    public static final int SIZE        = 18; // "size"
    public static final int NEW         = 19; // "new"
    public static final int IF          = 20; // "if"
    public static final int ELSE        = 22; // "else"
    public static final int BEGIN       = 23; // "{"
    public static final int END         = 24; // "}"
    public static final int WHILE       = 25; // "while"
    public static final int RETURN      = 26; // "return"
    public static final int BREAK       = 27; // "break"
    public static final int CONTINUE    = 28; // "continue"
    public static final int LPAREN      = 29; // "("
    public static final int RPAREN      = 30; // ")"
    public static final int LBRACKET    = 31; // "["
    public static final int RBRACKET    = 32; // "]"
    public static final int SEMI        = 33; // ";"
    public static final int COMMA       = 34; // ","
    public static final int DOT         = 35; // "."
    public static final int ADDR        = 36; // "&"
    public static final int ASSIGN      = 38; // "<-"
    public static final int FUNCRET     = 39; // "->"
    public static final int OP          = 40; // "+", "-", "*", "/", "and", "or", "not"
    public static final int RELOP       = 41; // "=", "!=", "<", ">", "<=", ">="
    public static final int BOOL_LIT    = 42; // "true", "false"
    public static final int INT_LIT     = 43; // {int}
    public static final int FLOAT_LIT   = 44; // {float}
    public static final int IDENT       = 45; // {identifier}

    public Parser(java.io.Reader r, Compiler compiler) throws Exception
    {
        this.compiler = compiler;
        this.lexer    = new Lexer(r, this);
    }

    Lexer            lexer;
    Compiler         compiler;
    public ParserVal yylval;

    HashMap<String, Integer> symbolTable = new HashMap<>();
    int currSymID = 0;

    public int yyparse() throws java.io.IOException
    {
        while ( true )
        {
            int token = lexer.yylex();
            String attrString = "";
            Object attr = yylval.obj;
            if(token == 10)
            {
                attrString = "PRINT";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 11)
            {
                attrString = "FUNC";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 12)
            {
                attrString = "VAR";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 13)
            {

                attrString = "VOID";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 14)
            {
                attrString = "BOOL";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 15)
            {
                attrString = "INT";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 16)
            {
                attrString = "FLOAT";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 17)
            {
                attrString = "STRUCT";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 18)
            {
                attrString = "SIZE";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();

            }
            if(token == 19)
            {
                attrString = "NEW";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 20)
            {
                attrString = "IF";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 22)
            {
                attrString = "ELSE";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 23)
            {
                attrString = "BEGIN";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 24)
            {
                attrString = "END";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 25)
            {
                attrString = "WHILE";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 26)
            {
                attrString = "RETURN";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 27)
            {
                attrString = "BREAK";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 28)
            {
                attrString = "CONTINUE";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 29)
            {
                attrString = "LPAREN";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 30)
            {
                attrString = "RPAREN";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 31)
            {
                attrString = "LBRACKET";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 32)
            {
                attrString = "RBRACKET";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 33)
            {
                attrString = "SEMI";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 34)
            {
                attrString = "COMMA";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 35)
            {
                attrString = "DOT";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 36)
            {
                attrString = "ADDR";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 38)
            {
                attrString = "ASSIGN";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 39)
            {
                attrString = "FUNCRET";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 40)
            {
                attrString = "OP";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 41)
            {
                attrString = "RELOP";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 42)
            {
                attrString = "BOOL_LIT";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 43)
            {
                lexer.column += attr.toString().length();
                attrString = "INT_LIT";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
            }
            if(token == 44)
            {
                attrString = "FLOAT_LIT";
                System.out.print("< " + attrString + ", " + lexer.lineno + ":" + lexer.column + ">");
                lexer.column += attr.toString().length();
            }
            if(token == 45)
            {
                attrString = "IDENT";
                if(symbolTable.containsKey(attr.toString())){
                    System.out.print("< ID, attr:sym-id: " + symbolTable.get(attr.toString()) + "," + lexer.lineno + ":" + lexer.column + ">" );
                }
                else{
                    symbolTable.put(attr.toString(), currSymID);
                    System.out.print("<<new symbol table entity [" + currSymID +", \"" + attr.toString() + "\"]>>");
                    System.out.print("<ID, attr:sym-id: " + symbolTable.get(attr.toString()) + "," + lexer.lineno + ":" + lexer.column + ">" );
                    currSymID++;

                }
                lexer.column += attr.toString().length();
            }
            if(token == 0)
            {
                // EOF is reached
                return 0;
            }
            if(token == -1)
            {
                // error
                return -1;
            }

        }
    }
}
