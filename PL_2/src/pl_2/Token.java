
package pl_2;


public class Token {
    
    public static final int ID = 1 ; // abc 
    public static final int LP = 3 ; // (  左小括號
    public static final int RP = 4 ; // )  右小括號
    public static final int SC = 6 ;  // ; 分號
    public static final int SUB = 7 ;  // - 減
    public static final int ADD = 8 ; // + 加
    public static final int MUL = 9 ; // * 乘
    public static final int DIV = 10 ; // / 除
    public static final int LMP = 11 ; // [ 左中括號 
    public static final int RMP = 12 ; // ] 右中括號
    public static final int LBP = 13 ; // { 左大括號
    public static final int RBP = 14 ; // } 右大括號
    public static final int ST = 15 ; // < 小於
    public static final int BT = 16 ; // > 大於
    public static final int EQ = 17 ; // == 等於
    public static final int ENTER = 18 ; // 換行
    public static final int GE = 21 ; // >= 大於等於
    public static final int LE = 22 ; // <= 小於等於
    public static final int QUIT = 25 ; // 結束
    public static final int NON = 26 ; // 都不是
    
    public static final int PA = 27 ; // %
    public static final int POW = 28 ; // ^
    public static final int NEQ = 29 ; // !=
    public static final int and = 30 ; // &
    public static final int or = 31 ; // |
    public static final int equ = 32 ; // =
    public static final int NOT = 33 ; // !
    public static final int AND = 34 ; // &&
    public static final int OR = 35 ; // ||
    public static final int PE = 36 ; // +=
    public static final int ME = 37 ; // -=
    public static final int TE = 38 ; // *=
    public static final int DE = 39 ; // /=
    public static final int RE = 40 ; // %=
    public static final int PP = 41 ; // ++
    public static final int MM = 42 ; // --
    public static final int RS = 43 ; // >>
    public static final int LS = 44 ; // <<
    public static final int COMMA = 45 ; // ,
    public static final int QUESTION = 46 ; // ?
    public static final int COLON = 47 ; // :
    
    public static final int INT = 48 ; // int
    public static final int FLOAT = 49 ; // float
    public static final int CHAR = 50 ; // char
    public static final int BOOL = 51 ; // boolean
    public static final int STRING = 52 ; // string
    public static final int VOID = 53 ; // void
    public static final int IF = 54 ; // if
    public static final int ELSE = 55 ; // else
    public static final int WHILE = 56 ; // while
    public static final int DO = 57 ; // do
    public static final int RETURN = 58 ; // return
    public static final int CONSTANT = 59 ; // constant
    
    private boolean Is_Quit = false ; // 是否結束
    private boolean Is_String = false ; // 是否為 String
    public TokenImfor[] my_TokenImfor = new TokenImfor[600] ; // TokenImfor 陣列
    // public String[] save_token = new String[600] ; // 切完的 token 串
    int my_TokenImfor_num = 0 ; // TokenImfor 陣列 的 index
    
    // String input_token = "" ; // 輸入的 token 串
    
    public Token() {
        Initialization() ; // 初始化
    } // Token()
    
    public boolean Is_Quit() {
        if ( Is_Quit ) return true ;
        else return false ;
    } // Is_Quit( )
    
    private void Set_Is_String( boolean set ) {
        Is_String = set ;
    } // Set_Is_String()
    
    private boolean Get_Is_String() {
        return Is_String ;
    } // Get_Is_Gtring()
    
    public void Print( Object o ) {
        System.out.println( o );
    } // Print()
    
    private void Initialization() {
        Is_Quit = false ;
        my_TokenImfor_num = 0 ;
        for ( int i = 0 ; i < my_TokenImfor.length ; i++ ) {
            my_TokenImfor[i] = new TokenImfor() ;
        } // for()
    } // Initialization()
    
    private boolean IsLetter( char ch ) { // 判斷是不是英文
         if ( ( ch >= 'A' && ch <= 'Z' ) // 在A~Z或a~z之間
                || ( ch >= 'a' && ch <= 'z' ) )
             return true ;
         else return false ;
    } // IsLetter()
    
    private void Put_Into_Save_Token( String token, int type ) {
        my_TokenImfor[my_TokenImfor_num].token = token ;
        my_TokenImfor[my_TokenImfor_num].type = type ;
        
        if ( Get_Is_String() ) { // 如果是字串
            my_TokenImfor[my_TokenImfor_num].is_String = true ;
        } // if()
        
        my_TokenImfor_num++ ;
        
    } // Put_Into_Save_Token()
    
    private void Set_Done() {
        my_TokenImfor[my_TokenImfor_num].is_Done = true ;
    } // Set_Done()
    
    private void Set_ListAllVariables() {
        my_TokenImfor[my_TokenImfor_num].is_ListAllVariables = true ;
    } // Set_Done()
    
    private void Set_ListAllFunctions() {
        my_TokenImfor[my_TokenImfor_num].is_ListAllFunctions = true ;
    } // Set_Done()
    
    private void Set_ListVariable() {
        my_TokenImfor[my_TokenImfor_num].is_ListVariable = true ;
    } // Set_Done()
    
    private void Set_ListFunction() {
        my_TokenImfor[my_TokenImfor_num].is_ListFunction = true ;
    } // Set_Done()
    
    public void CutToken( String input_token ) {
        my_TokenImfor_num = 0 ; // 初始化
        
        for ( int i = 0 ; i < input_token.length() ; i++ ) {
            
            if ( input_token.charAt( i ) == '(' ) { // 是 '('
                Put_Into_Save_Token( input_token.charAt( i ) + "", LP ) ;
            } // if()
            else if ( input_token.charAt( i ) == ')' ) { // 是 ')'
                Put_Into_Save_Token( input_token.charAt( i ) + "", RP ) ;
            } // else if()
            else if ( input_token.charAt( i ) == ';' ) { // 是 ';'
                Put_Into_Save_Token( input_token.charAt( i ) + "", SC ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '+' ) { // 是 '+' // 或是 '+=' // 或是 '++'
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '=' ) { // 是 '+='
                    Put_Into_Save_Token( "+=", PE ) ;
                    i++ ;
                } // if() 
                else if ( i + 1 < input_token.length() 
                          && input_token.charAt( i + 1 ) == '+' ) { // 是 '++'
                    Put_Into_Save_Token( "++", PP ) ;
                    i++ ;
                } // else if()
                else { // 是 '+'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", ADD ) ;
                } // else()
                
            } // else if()
            else if ( input_token.charAt( i ) == '-' ) { // 是 '-' // 或是 '-=' // 或是 '--'
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '=' ) { // 是 '-='
                    Put_Into_Save_Token( "-=", ME ) ;
                    i++ ;
                } // if() 
                else if ( i + 1 < input_token.length() 
                          && input_token.charAt( i + 1 ) == '-' ) { // 是 '--'
                    Put_Into_Save_Token( "--", MM ) ;
                    i++ ;
                } // else if()
                else { // 是 '-'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", SUB ) ;
                } // else()
                
            } // else if()
            else if ( input_token.charAt( i ) == '*' ) { // 是 '*' // 或是 '*='
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '=' ) { // 是 '*='
                    Put_Into_Save_Token( "*=", TE ) ;
                    i++ ;
                } // if() 
                else { // 是 '*'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", MUL ) ;
                } // else()
                
            } // else if()
            else if ( input_token.charAt( i ) == '/'
                      && i + 1 < input_token.length()
                      && input_token.charAt( i + 1 ) != '/' ) { // 是 '/' // 或是 '/= 不是 '//'
                
                if ( input_token.charAt( i + 1 ) == '=' ) { // 是 '/='
                    Put_Into_Save_Token( "/=", DE ) ;
                    i++ ;
                } // if() 
                else { // 是 '/'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", DIV ) ;
                } // else()
                
            } // else if()
            else if ( input_token.charAt( i ) == '[' ) { // 是 '['
                Put_Into_Save_Token( input_token.charAt( i ) + "", LMP ) ;
            } // else if()
            else if ( input_token.charAt( i ) == ']' ) { // 是 ']'
                Put_Into_Save_Token( input_token.charAt( i ) + "", RMP ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '{' ) { // 是 '{'
                Put_Into_Save_Token( input_token.charAt( i ) + "", LBP ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '}' ) { // 是 '}'
                Put_Into_Save_Token( input_token.charAt( i ) + "", RBP ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '\'' ) { // 是 '''
                
                if ( i + 1 < input_token.length() ) i++ ;
                
                Put_Into_Save_Token( input_token.charAt( i ) + "", CONSTANT ) ;
                
                if ( i + 1 < input_token.length()
                     && input_token.charAt( i + 1 ) == '\'' ) {
                    i++ ;
                } // if()
                else { // '字元 後面沒有 '
                    Print( "Class_Token --> Function_CutToken --> Line202 --> Char Error" ) ;
                } // else()
                
            } // else if()
            else if ( input_token.charAt( i ) == '"' ) { // 如果是 '"'
                // 表示為字串
                
                // 讀到另一個 '"' 才停止
                boolean breakk = false ;
                String save_String = "" ; // 存 字串
                
                for ( ; !breakk ; ) {
                    if ( i + 1 < input_token.length() ) i++ ;
                    
                    if ( input_token.charAt( i ) != '"' ) { // 如果沒讀到另一個 "
                        save_String = save_String + input_token.charAt( i ) ;
                    } // if()
                    else { // 讀到另一個 " 了
                        breakk = true ;
                    } // else()
                } // for()
                
                Set_Is_String( true ) ;
                Put_Into_Save_Token( save_String + "", CONSTANT ) ;
                Set_Is_String( false ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '%' ) { // 是 '%' // 或是 '%='
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '=' ) { // 是 '%='
                    Put_Into_Save_Token( "%=", RE ) ;
                    i++ ;
                } // if() 
                else { // 是 '%'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", PA ) ;
                } // else()
                
            } // else if()
            else if ( input_token.charAt( i ) == '^' ) { // 是 '^'
               Put_Into_Save_Token( input_token.charAt( i ) + "", POW ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '&' ) { // 是 '&' // 或是 '&&'
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '&' ) { // 是 '&&'
                    Put_Into_Save_Token( "&&", AND ) ;
                    i++ ;
                } // if() 
                else { // 是 '&'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", and ) ;
                } // else()
                
            } // else if()
            else if ( input_token.charAt( i ) == '|' ) { // 是 '|' // 或是 '||'
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '|' ) { // 是 '||'
                    Put_Into_Save_Token( "||", OR ) ;
                    i++ ;
                } // if() 
                else { // 是 '|'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", or ) ;
                } // else()
                
               
            } // else if()
            else if ( input_token.charAt( i ) == '=' ) { // 是 '=' 或 '=='
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '=' ) { // 是 '=='
                    Put_Into_Save_Token("==", EQ ) ;
                    i++ ;
                } // if() 
                else { // 是 '='
                    Put_Into_Save_Token( input_token.charAt( i ) + "", equ ) ;
                } // else()
            } // else if()
            else if ( input_token.charAt( i ) == '!' ) { // 是 '!' // 或是 '!='
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '=' ) { // 是 '!='
                    Put_Into_Save_Token( "!=", NEQ ) ;
                    i++ ;
                } // if() 
                else { // 是 '!'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", NOT ) ;
                } // else()
                
               
            } // else if()
            else if ( input_token.charAt( i ) == ',' ) { // 是 ','
               Put_Into_Save_Token( input_token.charAt( i ) + "", COMMA ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '?' ) { // 是 '?'
               Put_Into_Save_Token( input_token.charAt( i ) + "", QUESTION ) ;
            } // else if()
            else if ( input_token.charAt( i ) == ':' ) { // 是 ':'
               Put_Into_Save_Token( input_token.charAt( i ) + "", COLON ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '<' ) { // 是 '<' 或 '<=' // 或是 '<<'
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '=' ) { // 是 '<='
                    Put_Into_Save_Token("<=", LE ) ;
                    i++ ;
                } // if()
                else if ( i + 1 < input_token.length() 
                          && input_token.charAt( i + 1 ) == '<' ) { // 是 '<<'
                    Put_Into_Save_Token( "<<", LS ) ;
                    i++ ;
                } // else if()
                else { // 是 '<'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", ST ) ;
                } // else()
            } // else if()
            else if ( input_token.charAt( i ) == '>' ) { // 是 '>' 或 '>=' // 或是 '>>'
                
                if ( i + 1 < input_token.length() 
                     && input_token.charAt( i + 1 ) == '=' ) { // 是 '>='
                    Put_Into_Save_Token(">=", GE ) ;
                    i++ ;
                } // if()
                else if ( i + 1 < input_token.length() 
                          && input_token.charAt( i + 1 ) == '>' ) { // 是 '>>'
                    Put_Into_Save_Token( ">>", RS ) ;
                    i++ ;
                } // else if()
                else { // 是 '>'
                    Put_Into_Save_Token( input_token.charAt( i ) + "", BT ) ;
                } // else()
            } // else if()
            else if ( input_token.charAt( i ) == '\n' ) { // 是 '換行'
                // 先不放 enter
                // Put_Into_Save_Token( "\n", ENTER ) ;
            } // else if()
            else if ( IsLetter( input_token.charAt( i ) ) ) { // 是 ID ( ID 只能字母開頭 )
                boolean breakk = false ;
                String save_ID = "" ; // 存 ID
                save_ID = input_token.charAt( i ) + "" ;
                
                for ( ; !breakk ; ) { // 繼續吃 ID
                    if ( i + 1 < input_token.length() ) i++ ;
                    
                    if ( IsLetter( input_token.charAt( i ) ) ) { // 如果之後都是 字母
                        save_ID = save_ID + input_token.charAt( i ) ;
                    } // if()
                    else if ( Character.isDigit( input_token.charAt( i ) ) ) { // 如果之後是 數字
                        save_ID = save_ID + input_token.charAt( i ) ;
                    } // else if()
                    else if ( input_token.charAt( i ) == '_' ) { // 如果之後是 底線
                        save_ID = save_ID + input_token.charAt( i ) ;
                    } // else if()
                    else {
                        i-- ;
                        breakk = true ;
                    } // else()
                } // for()
                
                if ( save_ID.equals( "true" ) ) { // 如果是 true
                    Put_Into_Save_Token( save_ID, CONSTANT ) ;
                } // if()
                else if ( save_ID.equals( "false" ) ) { // 如果是 false
                    Put_Into_Save_Token( save_ID, CONSTANT ) ;
                } // else if()
                else if ( save_ID.equals( "int" ) ) { // 如果是 int
                    Put_Into_Save_Token( save_ID, INT ) ;
                } // else if()
                else if ( save_ID.equals( "float" ) ) { // 如果是 float
                    Put_Into_Save_Token( save_ID, FLOAT ) ;
                } // else if()
                else if ( save_ID.equals( "char" ) ) { // 如果是 char
                    Put_Into_Save_Token( save_ID, CHAR ) ;
                } // else if()
                else if ( save_ID.equals( "bool" ) ) { // 如果是 bool
                    Put_Into_Save_Token( save_ID, BOOL ) ;
                } // else if()
                else if ( save_ID.equals( "string" ) ) { // 如果是 string
                    Put_Into_Save_Token( save_ID, STRING ) ;
                } // else if()
                else if ( save_ID.equals( "void" ) ) { // 如果是 void
                    Put_Into_Save_Token( save_ID, VOID ) ;
                } // else if()
                else if ( save_ID.equals( "if" ) ) { // 如果是 if
                    Put_Into_Save_Token( save_ID, IF ) ;
                } // else if()
                else if ( save_ID.equals( "else" ) ) { // 如果是 else
                    Put_Into_Save_Token( save_ID, ELSE ) ;
                } // else if()
                else if ( save_ID.equals( "while" ) ) { // 如果是 while
                    Put_Into_Save_Token( save_ID, WHILE ) ;
                } // else if()
                else if ( save_ID.equals( "do" ) ) { // 如果是 do
                    Put_Into_Save_Token( save_ID, DO ) ;
                } // else if()
                else if ( save_ID.equals( "return" ) ) { // 如果是 return
                    Put_Into_Save_Token( save_ID, RETURN ) ;
                } // else if()
                else if ( save_ID.equals( "Done" ) ) { // 如果是 Done()
                    Set_Done() ;
                    Put_Into_Save_Token( save_ID, ID ) ;
                } // else if()
                else if ( save_ID.equals( "ListAllVariables" ) ) { // 如果是 ListAllVariables()
                    Set_ListAllVariables() ;
                    Put_Into_Save_Token( save_ID, ID ) ;
                } // else if()
                else if ( save_ID.equals( "ListAllFunctions" ) ) { // 如果是 ListAllFunctions()
                    Set_ListAllFunctions() ;
                    Put_Into_Save_Token( save_ID, ID ) ;
                } // else if()
                else if ( save_ID.equals( "ListVariable" ) ) { // 如果是 ListVariable()
                    Set_ListVariable() ;
                    Put_Into_Save_Token( save_ID, ID ) ;
                } // else if()
                else if ( save_ID.equals( "ListFunction" ) ) { // 如果是 ListFunction()
                    Set_ListFunction() ;
                    Put_Into_Save_Token( save_ID, ID ) ;
                } // else if()
                else if ( save_ID.equals( "cin" ) ) { // 如果是 cin
                    Put_Into_Save_Token( save_ID, CONSTANT ) ;
                } // else if()
                else if ( save_ID.equals( "cout" ) ) { // 如果是 cout
                    Put_Into_Save_Token( save_ID, CONSTANT ) ;
                } // else if()
                else { // 是 ID
                    Put_Into_Save_Token( save_ID, ID ) ;
                } // else()
                
            } // else if()
            else if ( Character.isDigit( input_token.charAt( i ) )
                      || input_token.charAt( i ) == '.' ) { // 如果是數字開頭 或 '.' 開頭
                boolean breakk = false ;
                String save_num = "" ; // 存數字字串
                int dot_num = 0 ; // '.' 的個數
                
                if ( input_token.charAt( i ) == '.' ) {
                    dot_num++ ;
                } // if()
                
                save_num = save_num + input_token.charAt( i ) ;
                
                for ( ; !breakk ; ) { // 繼續吃 數字
                    if ( i + 1 < input_token.length() ) i++ ;
                    // 可以接 數字 或 '.' // 但只能接一次 '.'

                    if ( input_token.charAt( i ) == '.' ) { // 如果下一個是點
                        if ( dot_num < 1 ) {
                            save_num = save_num + "." ;
                            dot_num++ ;
                        } // if()
                        else { // 第二次出現 點 '.'
                            i-- ;
                            breakk = true ;
                        } // else()
                        
                    } // if()
                    else if ( Character.isDigit( input_token.charAt( i ) ) ) { // 如果下一個是數字
                        save_num = save_num + input_token.charAt( i ) ;
                    } // else if()
                    else {
                        i-- ;
                        breakk = true ;
                    } // else()
                } // for()
                
                
                Put_Into_Save_Token( save_num, CONSTANT ) ;
            } // else if()
            else if ( input_token.charAt( i ) == '/' ) {
                
                if (  i + 1 < input_token.length()  // 是 '//'
                      && input_token.charAt( i + 1 ) == '/' ) {
                    int j = 0 ;
                    for ( j = i + 1 ; input_token.charAt( j ) != '\n' ; j++ ) {
                        
                    } // for()
                    
                    i = j ;
                } // if()
                
            } // else if()
            else { // 都不是
                if ( input_token.charAt( i ) != ' ' 
                     && input_token.charAt( i ) != '\t' ) { // 不是 空白 或 Tab 再存
                    Put_Into_Save_Token( input_token.charAt( i ) + "", NON ) ;
                } // if()
                
            } // else()
            
            
        } // for()
        
        
    } // CutToken()
            
    
} // Token()
