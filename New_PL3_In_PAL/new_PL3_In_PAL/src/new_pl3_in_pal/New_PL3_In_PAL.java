
package PL106_10327106 ;

import java.util.Scanner ;

class Main {

  public static void main( String[] args ) throws Throwable {
        
    Scanner cin = new Scanner( System.in ) ;

    System.out.println( "Our-C running ..." ) ; 

    Grammar myGrammar = new Grammar() ;

    System.out.println( "Our-C exited ..." ) ;
        
  } // main()
    
} // class Main


class Token {
    
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
    public static final int SMALL_AND = 30 ; // &
    public static final int SMALL_OR = 31 ; // |
    public static final int SMALL_EQU = 32 ; // =
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
    
    private boolean mIs_Quit = false ; // 是否結束
    private boolean mIs_String = false ; // 是否為 String
    private boolean mIs_Num = false ;
    private boolean mIs_Boolean = false ;
    public TokenImfor[] my_TokenImfor = new TokenImfor[1000] ; // TokenImfor 陣列
  int my_TokenImfor_num = 0 ; // TokenImfor 陣列 的 index
    
    
    
    public Token() {
    Initialization() ; // 初始化
  } // Token()
    
    public boolean Is_Quit() {
    if ( mIs_Quit ) return true ;
    else return false ;
  } // Is_Quit()
    
    private void Set_Is_String( boolean set ) {
    mIs_String = set ;
  } // Set_Is_String()
    
    private boolean Get_Is_String() {
    return mIs_String ;
  } // Get_Is_String()
    
    private void Set_Is_Num( boolean set ) {
    mIs_Num = set ;
  } // Set_Is_Num()
    
    private boolean Get_Is_Num() {
    return mIs_Num ;
  } // Get_Is_Num()
    
    private void Set_Is_Float( boolean f ) {
    my_TokenImfor[my_TokenImfor_num].m_is_Float = f ;
  } // Set_Is_Float()
    
    private void Set_Is_Char( boolean f ) {
    my_TokenImfor[my_TokenImfor_num].m_is_Char = f ;
  } // Set_Is_Char()
    
    private void Set_Is_Boolean( boolean set ) {
    mIs_Boolean = set ;
  } // Set_Is_Boolean()
    
    private boolean Get_Is_Boolean() {
    return mIs_Boolean ;
  } // Get_Is_Boolean()
    
    private void Initialization() {
    mIs_Quit = false ;
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
    my_TokenImfor[my_TokenImfor_num].m_token = token ;
    my_TokenImfor[my_TokenImfor_num].m_type = type ;

    if ( Get_Is_String() ) { // 如果是字串
      my_TokenImfor[my_TokenImfor_num].m_is_String = true ;
    } // if()
    else if ( Get_Is_Num() ) { // 如果是 數字
      my_TokenImfor[my_TokenImfor_num].m_is_Num = true ;
    } // else if()
    else if ( Get_Is_Boolean() ) { // 如果是 布林
      my_TokenImfor[my_TokenImfor_num].m_is_Boolean = true ;
    } // else if()

    my_TokenImfor_num++ ;
        
  } // Put_Into_Save_Token()
    
    private void Set_Done() {
    my_TokenImfor[my_TokenImfor_num].m_is_Done = true ;
  } // Set_Done()
    
    private void Set_ListAllVariables() {
    my_TokenImfor[my_TokenImfor_num].m_is_ListAllVariables = true ;
  } // Set_ListAllVariables()
    
    private void Set_ListAllFunctions() {
    my_TokenImfor[my_TokenImfor_num].m_is_ListAllFunctions = true ;
  } // Set_ListAllFunctions()
    
    private void Set_ListVariable() {
    my_TokenImfor[my_TokenImfor_num].m_is_ListVariable = true ;
  } // Set_ListVariable()
    
    private void Set_ListFunction() {
    my_TokenImfor[my_TokenImfor_num].m_is_ListFunction = true ;
  } // Set_ListFunction()
    
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
          
        } // else()

      } // else if()
      else if ( input_token.charAt( i ) == '"' ) { // 如果是 '"'
        // 表示為字串

        // 讀到另一個 '"' 才停止
        boolean breakk = false ;
        String save_String = "" ; // 存 字串

        for ( ; !breakk ; ) {
          if ( i + 1 < input_token.length() ) i++ ;
          
          if ( i + 1 < input_token.length() 
               && input_token.charAt( i ) == '\\'
               && input_token.charAt( i + 1 ) == 'n' ) {
            save_String = save_String + '\n' ;
            i++ ;
          } // if()

          else if ( input_token.charAt( i ) != '"' ) { // 如果沒讀到另一個 "
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
          Put_Into_Save_Token( input_token.charAt( i ) + "", SMALL_AND ) ;
        } // else()

      } // else if()
      else if ( input_token.charAt( i ) == '|' ) { // 是 '|' // 或是 '||'

        if ( i + 1 < input_token.length() 
             && input_token.charAt( i + 1 ) == '|' ) { // 是 '||'
          Put_Into_Save_Token( "||", OR ) ;
          i++ ;
        } // if() 
        else { // 是 '|'
          Put_Into_Save_Token( input_token.charAt( i ) + "", SMALL_OR ) ;
        } // else()

      } // else if()
      else if ( input_token.charAt( i ) == '=' ) { // 是 '=' 或 '=='
        if ( i + 1 < input_token.length() 
             && input_token.charAt( i + 1 ) == '=' ) { // 是 '=='
          Put_Into_Save_Token( "==", EQ ) ;
          i++ ;
        } // if() 
        else { // 是 '='
          Put_Into_Save_Token( input_token.charAt( i ) + "", SMALL_EQU ) ;
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
          Put_Into_Save_Token( "<=", LE ) ;
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
          Put_Into_Save_Token( ">=", GE ) ;
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
          Set_Is_Boolean( true ) ;
          Put_Into_Save_Token( save_ID, CONSTANT ) ;
          Set_Is_Boolean( false ) ;
        } // if()
        else if ( save_ID.equals( "false" ) ) { // 如果是 false
          Set_Is_Boolean( true ) ;
          Put_Into_Save_Token( save_ID, CONSTANT ) ;
          Set_Is_Boolean( false ) ;
        } // else if()
        else if ( save_ID.equals( "int" ) ) { // 如果是 int
          Put_Into_Save_Token( save_ID, INT ) ;
        } // else if()
        else if ( save_ID.equals( "float" ) ) { // 如果是 float
          Put_Into_Save_Token( save_ID, FLOAT ) ;
        } // else if()
        else if ( save_ID.equals( "char" ) ) { // 如果是 char
          Set_Is_Char( true ) ;
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
          Put_Into_Save_Token( save_ID, ID ) ;
        } // else if()
        else if ( save_ID.equals( "cout" ) ) { // 如果是 cout
          Put_Into_Save_Token( save_ID, ID ) ;
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


        if ( dot_num > 0 ) { // 若有小數點
          Set_Is_Float( true ) ;
        } // if()

        Set_Is_Num( true ) ;
        Put_Into_Save_Token( save_num, CONSTANT ) ;
        Set_Is_Num( false ) ;
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
            
    
} // class Token()

class Grammar {
    
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
    public static final int SMALL_AND = 30 ; // &
    public static final int SMALL_OR = 31 ; // |
    public static final int SMALL_EQU = 32 ; // =
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
    public static final int FLOAT = 49 ; // double
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
    
    public static final int COUT = 60 ; // Id
    public static final int POSITIVE = 70 ; // 正的
    public static final int NEGATIVE = 71 ; // 負的
    
    private TokenImfor[] my_TokenImfor = new TokenImfor[1000] ; // 輸入的 TokenImfor 陣列
    private Id[] my_Glo_Or_Loc_Id = new Id[600] ; // Id 陣列
  int my_Glo_Or_Loc_Id_length = 0 ; // Id 陣列 的 長度 ( 第幾層 {} )
    private boolean[] my_Glo_Or_Loc_Already_Ini = new boolean[40] ;
    
    private Id[] my_Now_Id = new Id[100] ; // 當下輸入的 id ( 對付印定義 )
  int my_Now_Id_Num = 0 ;
    
  int mDone_num = 0 ;
  int mListAllVariables_num = 0 ;
  int mListAllFunctions_num = 0 ;
  int mListVariable_num = 0 ;
  int mListFunction_num = 0 ;
    
  String mListVariable_Id = "" ;
  String mListFunction_Id = "" ;
    
  String merror_token = "" ; // 紀錄第一個出現的錯誤
  int merror_token_type = -1 ;
  boolean merror_token_already_set = false ; // 是否已經紀錄過第一個出現的錯誤
  boolean merror_token_no_id = false ; // 第一個錯誤是不是 未定義 的 id
  boolean minside_the_LBP = false ; // 在 '{' 裡面
    
  int mId_type = -1 ; // 此 變數的型別
    
  boolean mis_function = false ; // 此變數是否為 Funciton 變數
  String my_now_func_String = "" ; // 存當下的 Function
    
  int my_TokenImfor_num = -1 ; // TokenImfor 陣列 的 index
  int my_TokenImfor_length = -1 ; // TokenImfor 陣列 的 長度
    
  int my_line = 0 ; // 第幾行
    
  boolean mcheck_next_token_RBP = false ; // 判斷下一個 token 是不是 '{'
    
  int mlast_token_type = -1 ;
  String mlast_token = "" ;
    
  String marray_number = "" ;
    
  int mcompound_enter = 0 ; //
    
  int[] my_operator = new int[50] ; // 紀錄多個 '=' '+=' -=' .....
  int my_operator_count = -1 ; // 紀錄 operator 的 index
    
  int my_sign = -1 ; // 紀錄 sign
    
  boolean mprint_cout = true ;
  boolean mever_cout = false ; // 曾經有出現過 'cout'
  boolean mIs_double = false ; // 判斷此數字是不是 double
    
  int mset_while = -1 ; // 是否要存 while 內的 token
  String mwhile_buffer = "" ; // 存所有的 while token
  boolean mever_print_BT = false ; // 曾經印過 "> "
    
    
  // ====== 計算值 ======
    
  String m_Basic_expression = "" ;
  String m_Expression = "" ;
  String m_Statement = "" ;
  String m_rest_of_PPMM_Identifier_started_basic_exp = "" ;
  String m_romce_and_romloe = "" ;
  String m_rest_of_maybe_relational_exp = "" ;
  String m_maybe_relational_exp = "" ;
  String m_rest_of_maybe_equality_exp = "" ;
  String m_maybe_equality_exp = "" ;
  String m_rest_of_maybe_bit_AND_exp = "" ;
  String m_maybe_bit_AND_exp = "" ;
  String m_rest_of_maybe_bit_ex_OR_exp = "" ;
  String m_maybe_bit_ex_OR_exp = "" ;
  String m_rest_of_maybe_bit_OR_exp = "" ;
  String m_maybe_bit_OR_exp = "" ;
  String m_rest_of_maybe_logical_AND_exp = "" ;
  String m_maybe_logical_AND_exp = "" ;
  String m_rest_of_maybe_logical_OR_exp = "" ;
  String m_rest_of_maybe_mult_exp = "" ;
  String m_rest_of_Identifier_started_basic_exp = "" ;
  String m_maybe_mult_exp = "" ;
  String m_signed_unary_exp = "" ;
  String m_unsigned_unary_exp = "" ;
  String m_unary_exp = "" ;
  String m_rest_of_maybe_additive_exp = "" ;
  String m_maybe_additive_exp = "" ;
  String m_rest_of_maybe_shift_exp = "" ;
  String m_maybe_shift_exp = "" ;
    
  // ====== 計rest_of_maybe_logical_OR_exp_num算值 ======
    
  int m_cout_or_shift = LS ;
  int m_Rest_of_maybe_relational_exp_num_or_bool = -9487 ;
  int m_Maybe_relational_exp_num_or_bool = -9487 ;
  int m_Rest_of_maybe_equality_exp_num_or_bool = -9487 ;
  int m_Maybe_equality_exp_num_or_bool = -9487 ;
  int m_Rest_of_maybe_bit_AND_exp_num_or_bool = -9487 ;
  int m_Maybe_bit_AND_exp_num_or_bool = -9487 ;
  int m_Rest_of_maybe_bit_ex_OR_exp_num_or_bool = -9487 ;
  int m_Maybe_bit_ex_OR_exp_num_or_bool = -9487 ;
  int m_Rest_of_maybe_bit_OR_exp_num_or_bool = -9487 ;
  int m_Maybe_bit_OR_exp_num_or_bool = -9487 ;
  int m_Rest_of_maybe_logical_AND_exp_num_or_bool = -9487 ;
  int m_Maybe_logical_AND_exp_num_or_bool = -9487 ;
  int m_Rest_of_maybe_logical_OR_exp_num_or_bool = -9487 ;
  int m_Romce_and_romloe_num_or_bool = -9487 ;
  int m_Up_Romce_and_romloe_num_or_bool = -9487 ;
    
    
  Scanner mcin ;
    
    public Grammar() {
    mcin = new Scanner( System.in ) ;
    boolean breakk = false ;
    mcin.nextLine() ; // 讀入廢東西
    // 只需初始化一次
    for ( int i = 0 ; i < 30 ; i++ ) {
      my_Glo_Or_Loc_Already_Ini[i] = false ;
    } // for()

    for ( ; !breakk ; ) {

      Initialization() ; // 初始化
      User_Input() ;
      if ( Return_Done() ) breakk = true ;

    } // for()
  } // Grammar()
    
    // ====== 判斷 是回傳 num 或 bool ======
    
    private void Set_Rest_of_maybe_relational_exp_num_or_bool( int set ) {
    m_Rest_of_maybe_relational_exp_num_or_bool = set ;
  } // Set_Rest_of_maybe_relational_exp_num_or_bool()
    
    private int Get_Rest_of_maybe_relational_exp_num_or_bool() {
    return m_Rest_of_maybe_relational_exp_num_or_bool ;
  } // Get_Rest_of_maybe_relational_exp_num_or_bool()
    
    private void Set_Maybe_relational_exp_num_or_bool( int set ) {
    m_Maybe_relational_exp_num_or_bool = set ;
  } // Set_Maybe_relational_exp_num_or_bool()
    
    private int Get_Maybe_relational_exp_num_or_bool() {
    return m_Maybe_relational_exp_num_or_bool ;
  } // Get_Maybe_relational_exp_num_or_bool()
    
    private void Set_Rest_of_maybe_equality_exp_num_or_bool( int set ) {
    m_Rest_of_maybe_equality_exp_num_or_bool = set ;
  } // Set_Rest_of_maybe_equality_exp_num_or_bool()
    
    private int Get_Rest_of_maybe_equality_exp_num_or_bool() {
    return m_Rest_of_maybe_equality_exp_num_or_bool ;
  } // Get_Rest_of_maybe_equality_exp_num_or_bool()
    
    private void Set_Maybe_equality_exp_num_or_bool( int set ) {
    m_Maybe_equality_exp_num_or_bool = set ;
  } // Set_Maybe_equality_exp_num_or_bool()
    
    private int Get_Maybe_equality_exp_num_or_bool() {
    return m_Maybe_equality_exp_num_or_bool ;
  } // Get_Maybe_equality_exp_num_or_bool()
    
    private void Set_Rest_of_maybe_bit_AND_exp_num_or_bool( int set ) {
    m_Rest_of_maybe_bit_AND_exp_num_or_bool = set ;
  } // Set_Rest_of_maybe_bit_AND_exp_num_or_bool()
    
    private int Get_Rest_of_maybe_bit_AND_exp_num_or_bool() {
    return m_Rest_of_maybe_bit_AND_exp_num_or_bool ;
  } // Get_Rest_of_maybe_bit_AND_exp_num_or_bool()
    
    private void Set_Maybe_bit_AND_exp_num_or_bool( int set ) {
    m_Maybe_bit_AND_exp_num_or_bool = set ;
  } // Set_Maybe_bit_AND_exp_num_or_bool()
    
    private int Get_Maybe_bit_AND_exp_num_or_bool() {
    return m_Maybe_bit_AND_exp_num_or_bool ;
  } // Get_Maybe_bit_AND_exp_num_or_bool()
    
    private void Set_Rest_of_maybe_bit_ex_OR_exp_num_or_bool( int set ) {
    m_Rest_of_maybe_bit_ex_OR_exp_num_or_bool = set ;
  } // Set_Rest_of_maybe_bit_ex_OR_exp_num_or_bool()
    
    private int Get_Rest_of_maybe_bit_ex_OR_exp_num_or_bool() {
    return m_Rest_of_maybe_bit_ex_OR_exp_num_or_bool ;
  } // Get_Rest_of_maybe_bit_ex_OR_exp_num_or_bool()
    
    private void Set_Maybe_bit_ex_OR_exp_num_or_bool( int set ) {
    m_Maybe_bit_ex_OR_exp_num_or_bool = set ;
  } // Set_Maybe_bit_ex_OR_exp_num_or_bool()
    
    private int Get_Maybe_bit_ex_OR_exp_num_or_bool() {
    return m_Maybe_bit_ex_OR_exp_num_or_bool ;
  } // Get_Maybe_bit_ex_OR_exp_num_or_bool()
    
    private void Set_Rest_of_maybe_bit_OR_exp_num_or_bool( int set ) {
    m_Rest_of_maybe_bit_OR_exp_num_or_bool = set ;
  } // Set_Rest_of_maybe_bit_OR_exp_num_or_bool()
    
    private int Get_Rest_of_maybe_bit_OR_exp_num_or_bool() {
    return m_Rest_of_maybe_bit_OR_exp_num_or_bool ;
  } // Get_Rest_of_maybe_bit_OR_exp_num_or_bool()
    
    private void Set_Maybe_bit_OR_exp_num_or_bool( int set ) {
    m_Maybe_bit_OR_exp_num_or_bool = set ;
  } // Set_Maybe_bit_OR_exp_num_or_bool()
    
    private int Get_Maybe_bit_OR_exp_num_or_bool() {
    return m_Maybe_bit_OR_exp_num_or_bool ;
  } // Get_Maybe_bit_OR_exp_num_or_bool()
    
    private void Set_Rest_of_maybe_logical_AND_exp_num_or_bool( int set ) {
    m_Rest_of_maybe_logical_AND_exp_num_or_bool = set ;
  } // Set_Rest_of_maybe_logical_AND_exp_num_or_bool()
    
    private int Get_Rest_of_maybe_logical_AND_exp_num_or_bool() {
    return m_Rest_of_maybe_logical_AND_exp_num_or_bool ;
  } // Get_Rest_of_maybe_logical_AND_exp_num_or_bool()
    
    private void Set_Maybe_logical_AND_exp_num_or_bool( int set ) {
    m_Maybe_logical_AND_exp_num_or_bool = set ;
  } // Set_Maybe_logical_AND_exp_num_or_bool()
    
    private int Get_Maybe_logical_AND_exp_num_or_bool() {
    return m_Maybe_logical_AND_exp_num_or_bool ;
  } // Get_Maybe_logical_AND_exp_num_or_bool()
    
    private void Set_Rest_of_maybe_logical_OR_exp_num_or_bool( int set ) {
    m_Rest_of_maybe_logical_OR_exp_num_or_bool = set ;
  } // Set_Rest_of_maybe_logical_OR_exp_num_or_bool()
    
    private int Get_Rest_of_maybe_logical_OR_exp_num_or_bool() {
    return m_Rest_of_maybe_logical_OR_exp_num_or_bool ;
  } // Get_Rest_of_maybe_logical_OR_exp_num_or_bool()
    
    private void Set_Up_Romce_and_romloe_num_or_bool( int set ) {
    m_Up_Romce_and_romloe_num_or_bool = set ;
  } // Set_Up_Romce_and_romloe_num_or_bool()
    
    private int Get_Up_Romce_and_romloe_num_or_bool() {
    return m_Up_Romce_and_romloe_num_or_bool ;
  } // Get_Up_Romce_and_romloe_num_or_bool()
    
    // ====== 判斷 是回傳 num 或 bool ======
    
    // ====== 設定是 cout 或是一般 << ======
    
    private void Set_cout_or_shift( int set ) {
    m_cout_or_shift = set ;
        
  } // Set_cout_or_shift()
    
    private int Get_cout_or_shift() {
    return m_cout_or_shift ;
  } // Get_cout_or_shift()
    
    // ====== 設定是 cout 或是一般 << ======
    
    // ====== 設定曾經有過 cout ======
    
    private void Set_ever_cout( boolean set ) {
    mever_cout = set ;
  } // Set_ever_cout()
    
    private boolean Get_ever_cout() {
    return mever_cout ;
  } // Get_ever_cout()
    
    // ====== 設定曾經有過 cout ======
    
    // ====== 回傳值 ======
    
    private void Set_Basic_expression( String set ) {
    m_Basic_expression = set ;
  } // Set_Basic_expression()
    
    private String Get_Basic_expression() {
    return m_Basic_expression ;
  } // Get_Basic_expression()
    
    private void Set_Expression( String set ) {
    m_Expression = set ;
  } // Set_Expression()
    
    private String Get_Expression() {
    return m_Expression ;
  } // Get_Expression()
    
    private void Set_Statement( String set ) {
    m_Statement = set ;
  } // Set_Statement()
    
    private String Get_Statement() {
    return m_Statement ;
  } // Get_Statement()
    
    private void Set_Rest_of_PPMM_Identifier_started_basic_exp( String set ) {
    m_rest_of_PPMM_Identifier_started_basic_exp = set ;
  } // Set_Rest_of_PPMM_Identifier_started_basic_exp()
    
    private String Get_Rest_of_PPMM_Identifier_started_basic_exp() {
    return m_rest_of_PPMM_Identifier_started_basic_exp ;
  } // Get_Rest_of_PPMM_Identifier_started_basic_exp()
    
    private void Set_Signed_unary_exp( String set ) {
    m_signed_unary_exp = set ;
  } // Set_Signed_unary_exp()
    
    private String Get_Signed_unary_exp() {
    return m_signed_unary_exp ;
  } // Get_Signed_unary_exp()
    
    private void Set_Unsigned_unary_exp( String set ) {
    m_unsigned_unary_exp = set ;
  } // Set_Unsigned_unary_exp()
    
    private String Get_Unsigned_unary_exp() {
    return m_unsigned_unary_exp ;
  } // Get_Unsigned_unary_exp()
    
    private void Set_Romce_and_romloe( String set ) { 
    m_romce_and_romloe = set ;
  } // Set_Romce_and_romloe()
    
    private String Get_Romce_and_romloe() {
    return m_romce_and_romloe ;
  } // Get_Romce_and_romloe()
    
    private void Set_Unary_exp( String set ) {
    m_unary_exp = set ;
  } // Set_Unary_exp()
    
    private String Get_Unary_exp() {
    return m_unary_exp ;
  } // Get_Unary_exp()
    
    private void Set_Rest_of_maybe_mult_exp( double set1, double set2, 
                                             int operator, boolean set, String num ) {
        
    double return_num = -9487 ;

    if ( set ) {
      m_rest_of_maybe_mult_exp = num ;
    } // if()
    else if ( operator == MUL ) { // 如果是 '*'
      return_num = set1 * set2 ;


      if ( Get_Is_Float() ) {
        // 如果是 浮點數
        // 才用 浮點數存
        // 否則用 整數存
        m_rest_of_maybe_mult_exp = return_num + "" ;
      } // if()
      else {
        int return_int = -1 ;
        return_int = ( int ) return_num ;
        m_rest_of_maybe_mult_exp = return_int + "" ;
      } // else()


    } // else if()
    else if ( operator == DIV ) { // 如果是 '/'
      return_num = set1 / set2 ;

      if ( Get_Is_Float() ) {
        // 如果是 浮點數
        // 才用 浮點數存
        // 否則用 整數存
        m_rest_of_maybe_mult_exp = return_num + "" ;
      } // if()
      else {
        int return_int = -1 ;
        return_int = ( int ) return_num ;
        m_rest_of_maybe_mult_exp = return_int + "" ;
      } // else()

    } // else if()
    else if ( operator == PA ) { // 如果是 '%'
      return_num = set1 % set2 ;

      if ( Get_Is_Float() ) {
        // 如果是 浮點數
        // 才用 浮點數存
        // 否則用 整數存
        m_rest_of_maybe_mult_exp = return_num + "" ;
      } // if()
      else {
        int return_int = -1 ;
        return_int = ( int ) return_num ;
        m_rest_of_maybe_mult_exp = return_int + "" ;
      } // else()

    } // else if()
    else {
      
    } // else()
        
        
  } // Set_Rest_of_maybe_mult_exp()
    
    private String Get_Rest_of_maybe_mult_exp() {
    return m_rest_of_maybe_mult_exp ;
  } // Get_Rest_of_maybe_mult_exp()
    
    private void Set_Maybe_mult_exp( String set ) {
    m_maybe_mult_exp = set ;
  } // Set_Maybe_mult_exp()
    
    private String Get_Maybe_mult_exp() {
    return m_maybe_mult_exp ;
  } // Get_Maybe_mult_exp()
    
    private void Set_Rest_of_maybe_additive_exp( String num1, String num2, 
                                                 int ope, boolean set, String num ) {
        
    double return_num = -9487 ;

    if ( set ) {
      m_rest_of_maybe_additive_exp = num ;
    } // if()
    else if ( String_Which_Type( num1 ) == STRING 
              || String_Which_Type( num2 ) == STRING ) {
        // 只要有一個是 String

      if ( ope == ADD ) { // 如果是 '+'
        m_rest_of_maybe_additive_exp = num1 + num2 ;
      } // if()
      else if ( ope == SUB ) { // 如果是 '-'
            
      } // else if()
      else {
         
      } // else()

    } // else if()
    else if ( ( String_Which_Type( num1 ) == FLOAT && String_Which_Type( num2 ) == FLOAT )
              || ( String_Which_Type( num1 ) == INT && String_Which_Type( num2 ) == FLOAT )
              || ( String_Which_Type( num1 ) == FLOAT && String_Which_Type( num2 ) == INT )
              || ( String_Which_Type( num1 ) == INT && String_Which_Type( num2 ) == INT ) ) {

      if ( ope == ADD ) { // 如果是 '+'
        return_num = Turn_String_To_Float( num1 ) + Turn_String_To_Float( num2 ) ;

        if ( Get_Is_Float() ) {
          // 如果是 浮點數
          // 才用 浮點數存
          // 否則用 整數存
          m_rest_of_maybe_additive_exp = return_num + "" ;
        } // if()
        else {
          int return_int = -1 ;
          return_int = ( int ) return_num ;
          m_rest_of_maybe_additive_exp = return_int + "" ;
        } // else()


      } // if()
      else if ( ope == SUB ) { // 如果是 '-'
        return_num = Turn_String_To_Float( num1 ) - Turn_String_To_Float( num2 ) ;

        if ( Get_Is_Float() ) {
          // 如果是 浮點數
          // 才用 浮點數存
          // 否則用 整數存
          m_rest_of_maybe_additive_exp = return_num + "" ;
        } // if()
        else {
          int return_int = -1 ;
          return_int = ( int ) return_num ;
          m_rest_of_maybe_additive_exp = return_int + "" ;
        } // else()


      } // else if()
      else {
        
      } // else()

    } // else if()

    else {
      
    } // else()
        
        
  } // Set_Rest_of_maybe_additive_exp()
    
    private String Get_Rest_of_maybe_additive_exp() {
    return m_rest_of_maybe_additive_exp ;
  } // Get_Rest_of_maybe_additive_exp()
    
    private void Set_Maybe_additive_exp( String num1, String num2, int ope, boolean set, String num ) {
        
    double return_num = -9487 ;

    if ( set ) {
      m_maybe_additive_exp = num ;
    } // if()
    else if ( String_Which_Type( num1 ) == STRING 
              || String_Which_Type( num1 ) == STRING ) {
      // 只要有一個是 String

      if ( ope == ADD ) { // 如果是 '+'
        m_maybe_additive_exp = num1 + num2 ;
      } // if()
      else if ( ope == SUB ) { // 如果是 '-'
            
      } // else if()
      else {
            
      } // else()

    } // else if()
    else if ( ( String_Which_Type( num1 ) == FLOAT && String_Which_Type( num2 ) == FLOAT )
              || ( String_Which_Type( num1 ) == INT && String_Which_Type( num2 ) == FLOAT )
              || ( String_Which_Type( num1 ) == FLOAT && String_Which_Type( num2 ) == INT )
              || ( String_Which_Type( num1 ) == INT && String_Which_Type( num2 ) == INT ) ) {

      if ( ope == ADD ) { // 如果是 '+'
        return_num = Turn_String_To_Float( num1 ) + Turn_String_To_Float( num2 ) ;

        if ( Get_Is_Float() ) {
          // 如果是 浮點數
          // 才用 浮點數存
          // 否則用 整數存
          m_maybe_additive_exp = return_num + "" ;
        } // if()
        else {
          int return_int = -1 ;
          return_int = ( int ) return_num ;
          m_maybe_additive_exp = return_int + "" ;
        } // else()


      } // if()
      else if ( ope == SUB ) { // 如果是 '-'
        return_num = Turn_String_To_Float( num1 ) - Turn_String_To_Float( num2 ) ;

        if ( Get_Is_Float() ) {
          // 如果是 浮點數
          // 才用 浮點數存
          // 否則用 整數存
          m_maybe_additive_exp = return_num + "" ;
        } // if()
        else {
          int return_int = -1 ;
          return_int = ( int ) return_num ;
          m_maybe_additive_exp = return_int + "" ;
        } // else()


      } // else if()
      else {
            
      } // else()

    } // else if()
    else {
        
    } // else()
        
        
  } // Set_Maybe_additive_exp()
    
    private String Get_Maybe_additive_exp() {
    return m_maybe_additive_exp ;
  } // Get_Maybe_additive_exp()
    
    private void Set_Rest_of_maybe_shift_exp( int num1, int num2, int ope, boolean set, String num ) {
        
    double return_num = -9487 ;

    if ( set ) {
      m_rest_of_maybe_shift_exp = num ;
    } // if()
    else if ( ope == LS ) { // 如果是 '<<'
      return_num = num1 << num2 ;


      if ( Get_Is_Float() ) {
        // 如果是 浮點數
        // 才用 浮點數存
        // 否則用 整數存
        m_rest_of_maybe_shift_exp = return_num + "" ;
      } // if()
      else {
        int return_int = -1 ;
        return_int = ( int ) return_num ;
        m_rest_of_maybe_shift_exp = return_int + "" ;
      } // else()


    } // else if()
    else if ( ope == RS ) { // 如果是 '>>'
      return_num = num1 >> num2 ;

      if ( Get_Is_Float() ) {
        // 如果是 浮點數
        // 才用 浮點數存
        // 否則用 整數存
        m_rest_of_maybe_shift_exp = return_num + "" ;
      } // if()
      else {
        int return_int = -1 ;
        return_int = ( int ) return_num ;
        m_rest_of_maybe_shift_exp = return_int + "" ;
      } // else()


    } // else if()
    else {
       
    } // else()
        
        
        
  } // Set_Rest_of_maybe_shift_exp()
    
    private String Get_Rest_of_maybe_shift_exp() {
    return m_rest_of_maybe_shift_exp ;
  } // Get_Rest_of_maybe_shift_exp()
    
    private void Set_Maybe_shift_exp( int num1, int num2, int ope, boolean set, String num ) {
        
    double return_num = -9487 ;

    if ( set ) {
      m_maybe_shift_exp = num ;
    } // if()
    else if ( ope == LS ) { // 如果是 '<<'
      return_num = num1 << num2 ;

      if ( Get_Is_Float() ) {
        // 如果是 浮點數
        // 才用 浮點數存
        // 否則用 整數存
        m_maybe_shift_exp = return_num + "" ;
      } // if()
      else {
        int return_int = -1 ;
        return_int = ( int ) return_num ;
        m_maybe_shift_exp = return_int + "" ;
      } // else()


    } // else if()
    else if ( ope == RS ) { // 如果是 '>>'
      return_num = num1 >> num2 ;

      if ( Get_Is_Float() ) {
        // 如果是 浮點數
        // 才用 浮點數存
        // 否則用 整數存
        m_maybe_shift_exp = return_num + "" ;
      } // if()
      else {
        int return_int = -1 ;
        return_int = ( int ) return_num ;
        m_maybe_shift_exp = return_int + "" ;
      } // else()

    } // else if()
    else {
      
    } // else()
        
        
        
  } // Set_Maybe_shift_exp()
    
    private String Get_Maybe_shift_exp() {
    return m_maybe_shift_exp ;
  } // Get_Maybe_shift_exp()
    
    private void Set_Rest_of_maybe_relational_exp( String num1, String num2, 
                                                   int ope, boolean set, String num ) {
        
    if ( set ) {
      m_rest_of_maybe_relational_exp = num + "" ;
      return ;
    } // if()


    if ( ( String_Is_Float( num1 ) && String_Is_Float( num2 ) )
         || String_Is_Int( num1 ) && String_Is_Float( num2 )
         || String_Is_Float( num1 ) && String_Is_Int( num2 ) 
         || String_Is_Int( num1 ) && String_Is_Int( num2 ) ) {

      double f_num1 = -1 ;
      double f_num2 = -1 ;

      f_num1 = Turn_String_To_Float( num1 ) ;
      f_num2 = Turn_String_To_Float( num2 ) ;


      if ( ope == ST ) { // 如果是 '<'

        if ( f_num1 < f_num2 ) { // 真的是 '<'
          m_rest_of_maybe_relational_exp = true + "" ;
        } // if()
        else {
          m_rest_of_maybe_relational_exp = false + "" ;
        } // else()


      } // if()
      else if ( ope == BT ) { // 如果是 '>'

        if ( f_num1 > f_num2 ) { // 真的是 '>'
          m_rest_of_maybe_relational_exp = true + "" ;
        } // if()
        else {
          m_rest_of_maybe_relational_exp = false + "" ;
        } // else()

      } // else if()
      else if ( ope == GE ) { // 如果是 '>='

        if ( f_num1 >= f_num2 ) { // 真的是 '>='
          m_rest_of_maybe_relational_exp = true + "" ;
        } // if()
        else {
          m_rest_of_maybe_relational_exp = false + "" ;
        } // else()

      } // else if()
      else if ( ope == LE ) { // 如果是 '<='

        if ( f_num1 <= f_num2 ) { // 真的是 '<='
          m_rest_of_maybe_relational_exp = true + "" ;
        } // if()
        else {
          m_rest_of_maybe_relational_exp = false + "" ;
        } // else()

      } // else if()
      else {
        // Print("Set_Rest_of_maybe_relational_exp_Error 1") ;
      } // else()

      return ;

    } // if()



    if ( ope == ST ) { // 如果是 '<'

      if ( num1.compareTo( num2 ) < 0 ) { // 真的是 '<'
        m_rest_of_maybe_relational_exp = true + "" ;
      } // if()
      else {
        m_rest_of_maybe_relational_exp = false + "" ;
      } // else()


    } // if()
    else if ( ope == BT ) { // 如果是 '>'

      if ( num1.compareTo( num2 ) > 0 ) { // 真的是 '>'
        m_rest_of_maybe_relational_exp = true + "" ;
      } // if()
      else {
        m_rest_of_maybe_relational_exp = false + "" ;
      } // else()

    } // else if()
    else if ( ope == GE ) { // 如果是 '>='

      if ( num1.compareTo( num2 ) >= 0 ) { // 真的是 '>='
        m_rest_of_maybe_relational_exp = true + "" ;
      } // if()
      else {
        m_rest_of_maybe_relational_exp = false + "" ;
      } // else()

    } // else if()
    else if ( ope == LE ) { // 如果是 '<='

      if ( num1.compareTo( num2 ) <= 0 ) { // 真的是 '<='
        m_rest_of_maybe_relational_exp = true + "" ;
      } // if()
      else {
        m_rest_of_maybe_relational_exp = false + "" ;
      } // else()

    } // else if()
    else {
      // Print("Set_Rest_of_maybe_relational_exp_Error 2") ;
    } // else()
        
        
        
  } // Set_Rest_of_maybe_relational_exp()
    
    private String Get_Rest_of_maybe_relational_exp() {
    return m_rest_of_maybe_relational_exp ;
  } // Get_Rest_of_maybe_relational_exp()
    
    private void Set_Maybe_relational_exp( String num1, String num2, int ope, boolean set, String num ) {
        
    if ( set ) {
      m_maybe_relational_exp = num + "" ;

      return ;
    } // if()


    if ( ( String_Is_Float( num1 ) && String_Is_Float( num2 ) )
         || String_Is_Int( num1 ) && String_Is_Float( num2 )
         || String_Is_Float( num1 ) && String_Is_Int( num2 ) 
         || String_Is_Int( num1 ) && String_Is_Int( num2 ) ) {

      double f_num1 = -1 ;
      double f_num2 = -1 ;

      f_num1 = Turn_String_To_Float( num1 ) ;
      f_num2 = Turn_String_To_Float( num2 ) ;


      if ( ope == ST ) { // 如果是 '<'

        if ( f_num1 < f_num2 ) { // 真的是 '<'
          m_maybe_relational_exp = true + "" ;
        } // if()
        else {
          m_maybe_relational_exp = false + "" ;
        } // else()


      } // if()
      else if ( ope == BT ) { // 如果是 '>'

        if ( f_num1 > f_num2 ) { // 真的是 '>'
          m_maybe_relational_exp = true + "" ;
        } // if()
        else {
          m_maybe_relational_exp = false + "" ;
        } // else()

      } // else if()
      else if ( ope == GE ) { // 如果是 '>='

        if ( f_num1 >= f_num2 ) { // 真的是 '>='
          m_maybe_relational_exp = true + "" ;
        } // if()
        else {
          m_maybe_relational_exp = false + "" ;
        } // else()

      } // else if()
      else if ( ope == LE ) { // 如果是 '<='

        if ( f_num1 <= f_num2 ) { // 真的是 '<='
          m_maybe_relational_exp = true + "" ;
        } // if()
        else {
          m_maybe_relational_exp = false + "" ;
        } // else()

      } // else if()
      else {
        // Print("Set_Maybe_relational_exp_Error 1") ;
      } // else()

      return ;

    } // if()




    if ( ope == ST ) { // 如果是 '<'

      if ( num1.compareTo( num2 ) < 0 ) { // 真的是 '<'
        m_maybe_relational_exp = true + "" ;
      } // if()
      else {
        m_maybe_relational_exp = false + "" ;
      } // else()


    } // if()
    else if ( ope == BT ) { // 如果是 '>'

      if ( num1.compareTo( num2 ) > 0 ) { // 真的是 '>'
        m_maybe_relational_exp = true + "" ;
      } // if()
      else {
        m_maybe_relational_exp = false + "" ;
      } // else()

    } // else if()
    else if ( ope == GE ) { // 如果是 '>='

      if ( num1.compareTo( num2 ) >= 0 ) { // 真的是 '>='
        m_maybe_relational_exp = true + "" ;
      } // if()
      else {
        m_maybe_relational_exp = false + "" ;
      } // else()

    } // else if()
    else if ( ope == LE ) { // 如果是 '<='

      if ( num1.compareTo( num2 ) <= 0 ) { // 真的是 '<='
        m_maybe_relational_exp = true + "" ;
      } // if()
      else {
        m_maybe_relational_exp = false + "" ;
      } // else()

    } // else if()
    else {
      // Print("Set_Maybe_relational_exp_Error 2") ;
    } // else()
        
        
        
  } // Set_Maybe_relational_exp()
    
    private String Get_Maybe_relational_exp() {
    return m_maybe_relational_exp ;
  } // Get_Maybe_relational_exp()
    
    private void Set_Rest_of_maybe_equality_exp( String num1, String num2, 
                                                 int ope, boolean set, String num ) {
        
    if ( Double_Dot_All_Zero( num1 ) ) { // 如果有小數點 且 小數點以後都是 0
      num1 = Cut_Double_Dot( num1 ) ;
    } // if()

    if ( Double_Dot_All_Zero( num2 ) ) {
      num2 = Cut_Double_Dot( num2 ) ;
    } // if()


    if ( set ) {
      m_rest_of_maybe_equality_exp = num ;
    } // if()
    else if ( ope == EQ ) { // 如果是 '=='

      if ( num1.equals( num2 ) ) {
        m_rest_of_maybe_equality_exp = true + "" ;
      } // if()
      else {
        m_rest_of_maybe_equality_exp = false + "" ;
      } // else()


    } // else if()
    else if ( ope == NEQ ) { // 如果是 '!='

      if ( !num1.equals( num2 ) ) {
        m_rest_of_maybe_equality_exp = true + "" ;
      } // if()
      else {
        m_rest_of_maybe_equality_exp = false + "" ;
      } // else()

    } // else if()
    else {
      // Print("Set_Rest_of_maybe_equality_exp_Error") ;
    } // else()
        
        
        
  } // Set_Rest_of_maybe_equality_exp()
    
    private String Get_Rest_of_maybe_equality_exp() {
    return m_rest_of_maybe_equality_exp ;
  } // Get_Rest_of_maybe_equality_exp()
    
    private void Set_Maybe_equality_exp( String num1, String num2, int ope, boolean set, String num ) {
        
    if ( Double_Dot_All_Zero( num1 ) ) { // 如果有小數點 且 小數點以後都是 0
      num1 = Cut_Double_Dot( num1 ) ;
    } // if()

    if ( Double_Dot_All_Zero( num2 ) ) {
      num2 = Cut_Double_Dot( num2 ) ;
    } // if()

    if ( set ) {
      m_maybe_equality_exp = num ;
    } // if()
    else if ( ope == EQ ) { // 如果是 '=='

      if ( num1.equals( num2 ) ) {
        m_maybe_equality_exp = true + "" ;
      } // if()
      else {
        m_maybe_equality_exp = false + "" ;
      } // else()


    } // else if()
    else if ( ope == NEQ ) { // 如果是 '!='

      if ( !num1.equals( num2 ) ) {
        m_maybe_equality_exp = true + "" ;
      } // if()
      else {
        m_maybe_equality_exp = false + "" ;
      } // else()

    } // else if()
    else {
      // Print("Set_Maybe_equality_exp_Error") ;
    } // else()
        
        
  } // Set_Maybe_equality_exp()
    
    private String Get_Maybe_equality_exp() {
    return m_maybe_equality_exp ;
  } // Get_Maybe_equality_exp()
    
    private void Set_Rest_of_Identifier_started_basic_exp( String set ) {
    m_rest_of_Identifier_started_basic_exp = set ;
  } // Set_Rest_of_Identifier_started_basic_exp()
    
    private String Get_Rest_of_Identifier_started_basic_exp() {
    return m_rest_of_Identifier_started_basic_exp ;
  } // Get_Rest_of_Identifier_started_basic_exp()
    
    private void Set_Rest_of_maybe_bit_AND_exp( boolean num1, boolean num2, 
                                                  int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_rest_of_maybe_bit_AND_exp = num + "" ;
    } // if()
    else if ( ope == SMALL_AND ) { // 如果是 '&'
      // return_num = num1 & num2 ;
      m_rest_of_maybe_bit_AND_exp = return_num + "" ;
    } // else if()
    else {
      // Print("Set_Rest_of_maybe_bit_AND_exp_Error") ;
    } // else()
        
        
  } // Set_Rest_of_maybe_bit_AND_exp()
    
    private String Get_Rest_of_maybe_bit_AND_exp() {
    return m_rest_of_maybe_bit_AND_exp ;
  } // Get_Rest_of_maybe_bit_AND_exp()
    
    private void Set_Maybe_bit_AND_exp( boolean num1, boolean num2, 
                                           int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_maybe_bit_AND_exp = num + "" ;
    } // if()
    else if ( ope == SMALL_AND ) { // 如果是 '&'
      // return_num = num1 & num2 ;
      m_maybe_bit_AND_exp = return_num + "" ;
    } // else if()
    else {
      // Print("Set_Maybe_bit_AND_exp_Error") ;
    } // else()
        
        
        
  } // Set_Maybe_bit_AND_exp()
    
    private String Get_Maybe_bit_AND_exp() {
    return m_maybe_bit_AND_exp ;
  } // Get_Maybe_bit_AND_exp()
    
    private void Set_Rest_of_maybe_bit_ex_OR_exp( boolean num1, boolean num2, 
                                                    int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_rest_of_maybe_bit_ex_OR_exp = num + "" ;
    } // if()
    else if ( ope == POW ) { // 如果是 '^'
      // return_num = num1 ^ num2 ;
      m_rest_of_maybe_bit_ex_OR_exp = return_num + "" ;
    } // else if()
    else {
      // Print("Set_Rest_of_maybe_bit_ex_OR_exp_Error") ;
    } // else()
        
        
        
  } // Set_Rest_of_maybe_bit_ex_OR_exp()
    
    private String Get_Rest_of_maybe_bit_ex_OR_exp() {
    return m_rest_of_maybe_bit_ex_OR_exp ;
  } // Get_Rest_of_maybe_bit_ex_OR_exp()
    
    private void Set_Maybe_bit_ex_OR_exp( boolean num1, boolean num2, int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_maybe_bit_ex_OR_exp = num + "" ;
    } // if()
    else if ( ope == POW ) { // 如果是 '^'
      // return_num = num1 ^ num2 ;
      m_maybe_bit_ex_OR_exp = return_num + "" ;
    } // else if()
    else {
      // Print("Set_Maybe_bit_ex_OR_exp_Error") ;
    } // else()
        
        
        
  } // Set_Maybe_bit_ex_OR_exp()
    
    private String Get_Maybe_bit_ex_OR_exp() {
    return m_maybe_bit_ex_OR_exp ;
  } // Get_Maybe_bit_ex_OR_exp()
    
    private void Set_Rest_of_maybe_bit_OR_exp( boolean num1, boolean num2, 
                                                 int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_rest_of_maybe_bit_OR_exp = num + "" ;
    } // if()
    else if ( ope == SMALL_OR ) { // 如果是 '|'
      // return_num = num1 | num2 ;
      m_rest_of_maybe_bit_OR_exp = return_num + "" ;
    } // else if()
    else {
      // Print("Set_Rest_of_maybe_bit_OR_exp_Error") ;
    } // else()
        
        
        
  } // Set_Rest_of_maybe_bit_OR_exp()
    
    private String Get_Rest_of_maybe_bit_OR_exp() {
    return m_rest_of_maybe_bit_OR_exp ;
  } // Get_Rest_of_maybe_bit_OR_exp()
    
    private void Set_Maybe_bit_OR_exp( boolean num1, boolean num2, int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_maybe_bit_OR_exp = num + "" ;
    } // if()
    else if ( ope == SMALL_OR ) { // 如果是 '|'
      // return_num = num1 | num2 ;
      m_maybe_bit_OR_exp = return_num + "" ;
    } // else if()
    else {
      // Print("Set_Maybe_bit_OR_exp_Error") ;
    } // else()
        
        
  } // Set_Maybe_bit_OR_exp()
    
    private String Get_Maybe_bit_OR_exp() {
    return m_maybe_bit_OR_exp ;
  } // Get_Maybe_bit_OR_exp()
    
    private void Set_Rest_of_maybe_logical_AND_exp( boolean num1, boolean num2, 
                                                      int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_rest_of_maybe_logical_AND_exp = num + "" ;
    } // if()
    else if ( ope == AND ) { // 如果是 '&&'

      return_num = num1 && num2 ;
      m_rest_of_maybe_logical_AND_exp = return_num + "" ;
    } // else if()
    else {
      // Print("Set_Rest_of_maybe_logical_AND_exp_Error") ;
    } // else()
        
        
  } // Set_Rest_of_maybe_logical_AND_exp()
    
    private String Get_Rest_of_maybe_logical_AND_exp() {
    return m_rest_of_maybe_logical_AND_exp ;
  } // Get_Rest_of_maybe_logical_AND_exp()
    
    private void Set_Maybe_logical_AND_exp( boolean num1, boolean num2, int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_maybe_logical_AND_exp = num + "" ;
    } // if()
    else if ( ope == AND ) { // 如果是 '&&'

      return_num = num1 && num2 ;
      m_maybe_logical_AND_exp = return_num + "" ;
    } // else if()
    else {
      // Print("Set_Maybe_logical_AND_exp_Error") ;
    } // else()
        
        
        
  } // Set_Maybe_logical_AND_exp()
    
    private String Get_Maybe_logical_AND_exp() {
    return m_maybe_logical_AND_exp ;
  } // Get_Maybe_logical_AND_exp()
    
    private void Set_Rest_of_maybe_logical_OR_exp( boolean num1, boolean num2, 
                                                   int ope, boolean set, String num ) {
        
    boolean return_num = false ;

    if ( set ) {
      m_rest_of_maybe_logical_OR_exp = num + "" ;
    } // if()
    else if ( ope == OR ) { // 如果是 '||'
      return_num = num1 || num2 ;
      m_rest_of_maybe_logical_OR_exp = return_num + "" ;

    } // else if()
    else {
      // Print("Set_Rest_of_maybe_logical_OR_exp_Error") ;
    } // else()
        
        
        
  } // Set_Rest_of_maybe_logical_OR_exp()
    
    private String Get_Rest_of_maybe_logical_OR_exp() {
    return m_rest_of_maybe_logical_OR_exp ;
  } // Get_Rest_of_maybe_logical_OR_exp()
    
    // ====== 回傳值 ======
    
    // ====== 拿運算元 ======
    
    private void Set_Operator( int set ) {
    my_operator_count++ ;
    my_operator[my_operator_count] = set ;
  } // Set_Operator()
    
    private int Get_Operator() {
    int return_ope = -123 ;
    return_ope = my_operator[my_operator_count] ;
    my_operator_count-- ;
    return return_ope ;
  } // Get_Operator()
    
    private void Ini_Operator() {
    // 初始化運算元

    for ( int i = 0 ; i < 50 ; i++ ) {
      my_operator[i] = -1 ;
    } // for()
        
  } // Ini_Operator()
    
    // ====== 拿運算元 ======
    
    // ====== 字串轉數字 ======
    
    private double Turn_String_To_Digit( String num ) {
        
    double afterConvert = Float.parseFloat( num );
    return afterConvert ;
        
  } // Turn_String_To_Digit()
    
    // ====== 字串轉數字 ======
    
    // ====== 拿 sign ======
    
    private void Set_Sign( int set ) {
    my_sign = set ;
  } // Set_Sign()
    
    private int Get_Sign() {
    return my_sign ;
  } // Get_Sign()
    
    // ====== 拿 sign ======
    
    // ====== 計算有幾個 負 ======
    
    // ====== 是否為偶數 ======
    
    private boolean Is_Even( int num ) {
        
    if ( num % 2 == 0 ) { // 是偶數
      return true ;
    } // if()
    else {
      return false ;
    } // else()
        
  } // Is_Even()
    
    // ====== 是否為偶數 ======
    
    // ====== "==" "!=" "2.0 != 2 之問題" ======
    
    private boolean Double_Dot_All_Zero( String num ) {
        
    if ( !String_Is_Float( num ) ) { // 不是浮點數
      return false ;
    } // if()


    boolean start = false ;

    for ( int i = 0 ; i < num.length() ; i++ ) {

      if ( start ) {

        if ( num.charAt( i ) != '0' ) {

          return false ;
        } // if()
      } // if()

      if ( !start && num.charAt( i ) == '.' ) {
        start = true ;
      } // if()

    } // for()


    return true ;
        
  } // Double_Dot_All_Zero()
    
    private String Cut_Double_Dot( String num ) {
        
    double turn_num = -1 ;
    int turn_num_int = -1 ;


    turn_num = Turn_String_To_Float( num ) ;
    turn_num_int = ( int ) turn_num ;

    return turn_num_int + "" ;
        
  } // Cut_Double_Dot()
    
    // ====== "==" "!=" "2.0 != 2 之問題" ======
    
    private void Set_Check_Next_Token_RBP( boolean set ) {
    mcheck_next_token_RBP = set ;
  } // Set_Check_Next_Token_RBP()
    
    private boolean Get_Check_Next_Token_RBP() {
    return mcheck_next_token_RBP ;
  } // Get_Check_Next_Token_RBP()
    
    private void Add_Compound_Enter( int add ) {
    mcompound_enter = mcompound_enter + add ;
  } // Add_Compound_Enter()
    
    private int Get_Compound_Enter() {
    return mcompound_enter ;
  } // Get_Compound_Enter()
    
    private void Set_Is_Function( boolean set ) {
    mis_function = set ;
  } // Set_Is_Function()
    
    private boolean Get_Is_Function() {
    return mis_function ;
  } // Get_Is_Function()
    
    private void Print_Statement() {
    System.out.println( "Statement executed ..." ) ;
  } // Print_Statement()
    
    private void Print_Definition() {
        
    boolean breakk = false ;

    for ( int i = 0 ; !breakk && i < Get_My_Now_Index() ; i++ ) { 

      if ( my_Now_Id[i].m_new_def ) { // 如果是 重新定義

        if ( my_Now_Id[i].m_is_Function ) { // 如果是 Function
          System.out.println( "New definition of " +  my_Now_Id[i].m_id_string + "() entered ..." ) ;
          // 是 Function 必定只印一次
          // 因為一次只能定義一個 Funciton
          breakk = true ;
        } // if()
        else { // 不是 Function
          System.out.println( "New definition of " +  my_Now_Id[i].m_id_string + " entered ..." ) ;
        } // else()

      } // if()
      else { // 第一次定義

        if ( my_Now_Id[i].m_is_Function ) { // 如果是 Function
          System.out.println( "Definition of " +  my_Now_Id[i].m_id_string + "() entered ..." ) ;
          // 是 Function 必定只印一次
          // 因為一次只能定義一個 Funciton
          breakk = true ;
        } // if()
        else { // 不是 Function
          System.out.println( "Definition of " +  my_Now_Id[i].m_id_string + " entered ..." ) ;
        } // else()

      } // else()

    } // for()
        
  } // Print_Definition()
    
    private void Reverse_My_Now_Id() {
        
    for ( int i = 0 ; i < Get_My_Now_Index() - 1 ; i++ ) {
        
      Id temp_id = new Id() ;
      temp_id = my_Now_Id[i] ;
      my_Now_Id[i] = my_Now_Id[Get_My_Now_Index() - 1] ;
      my_Now_Id[Get_My_Now_Index() - 1] = temp_id ;

    } // for()
        
        
  } // Reverse_My_Now_Id()
    
    private void Set_Error( String token, int token_type, boolean no_id ) {
        
    Set_Error_Token( token ) ;
    Set_Error_Type( token_type ) ;
    Set_Error_Token_No_Id( no_id ) ;
    Set_Error_Token_Already_Set( true ) ;
    Read_Input_After_Error_Until_Enter() ; // 整行讀掉
        
  } // Set_Error()
    
    private void Print_Error( String token, int token_type, boolean no_id ) {
        
    int line = -1 ;
    line = Get_Line() ;

    if ( token_type == NON ) { // 不是定義的 token
      System.out.println( "Line " + line + " : unrecognized token with first char '" + token + "'" ) ;
    } // if()
    else if ( !no_id ) { // 不是預期的 token
      System.out.println( "Line " + line + " : unexpected token '" + token + "'" ) ;
    } // else if()
    else {
      if ( no_id ) { // 文法正確，但 token 不存在
        System.out.println( "Line " + line + " : undefined identifier '" + token + "'" ) ;
      } // if()
      else {
        // Print( "Print_Error Error" ) ;
      } // else()
    } // else()
        
  } // Print_Error()
    
    private void Add_Line() {
    my_line++ ;
  } // Add_Line()
    
    private int Get_Line() {
    return my_line ;
  } // Get_Line()
    
    private void Read_Input_After_Error_Until_Enter() { // 未定義 ID 不算
    boolean breakk = false ;
    int i = 0 ;
    for ( i = my_TokenImfor_num ; !breakk ; i++ ) { // 一直讀掉，直到換行
      if ( i >= my_TokenImfor.length ) {
        breakk = true ;
      } // if()
      else if ( my_TokenImfor[i].m_type == ENTER ) { // 如果是 換行
        breakk = true ;
      } // else if()
    } // for()

    my_TokenImfor_num = i + 1 ; // 讀掉這個 換行
        
  } // Read_Input_After_Error_Until_Enter()
    
    private void Set_My_Glo_Or_Loc_Id_Length( int add_or_minus ) {
    my_Glo_Or_Loc_Id_length = my_Glo_Or_Loc_Id_length + add_or_minus ;
  } // Set_My_Glo_Or_Loc_Id_Length()
    
    private int Get_My_Glo_Or_Loc_Id_Length() {
    return my_Glo_Or_Loc_Id_length ;
  } // Get_My_Glo_Or_Loc_Id_Length() 
    
    private boolean Same_Id( String id, int Glo_Or_Loc, boolean is_function ) {
        
    if ( id.equals( "ListAllVariables" ) ) { 
      return true ;
    } // if()
    else if ( id.equals( "ListAllFunctions" ) ) { 
      return true ;
    } // else if()
    else if ( id.equals( "ListVariable" ) ) { 
      return true ;
    } // else if()
    else if ( id.equals( "ListFunction" ) ) { 
      return true ;
    } // else if()


    if ( id.equals( "cin" ) || id.equals( "cout" ) ) {
      return true ;
    } // if()

    for ( int i = Glo_Or_Loc ; i >= 0 ; i-- ) { // 找此 {} 外面有宣告過的變數 
      // 找本身自己 {} 內 宣告的變數
      if ( my_Glo_Or_Loc_Already_Ini[i] ) { // 如果有初始化過

        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_Func_var_num ; j++ ) {
          if ( my_Glo_Or_Loc_Id[i].my_Func_Variable[j] != null
               && id.equals( my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_var ) ) { 
            // 如果是出現過的 id

            return true ;
          } // if()
        } // for()

        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_var_num ; j++ ) {

          if ( my_Glo_Or_Loc_Id[i].my_Variable[j] != null
               && id.equals( my_Glo_Or_Loc_Id[i].my_Variable[j].m_var ) ) { 
            // 如果是出現過的 id

            return true ;
          } // if()
        } // for()

      } // if()
    } // for()

    return false ;
  } // Same_Id()
    
    private boolean Same_Id_In_Same_Compound( String id, int Glo_Or_Loc, boolean is_function ) {
        
        
    // 找本身自己 {} 內 宣告的變數
    if ( my_Glo_Or_Loc_Already_Ini[Glo_Or_Loc] ) { // 如果有初始化過

      for ( int j = 0 ; j < my_Glo_Or_Loc_Id[Glo_Or_Loc].m_Func_var_num ; j++ ) {
        if ( my_Glo_Or_Loc_Id[Glo_Or_Loc].my_Func_Variable[j] != null
             && id.equals( my_Glo_Or_Loc_Id[Glo_Or_Loc].my_Func_Variable[j].m_var ) ) { 
          // 如果是出現過的 id

          return true ;
        } // if()
      } // for()

      for ( int j = 0 ; j < my_Glo_Or_Loc_Id[Glo_Or_Loc].m_var_num ; j++ ) {

        if ( my_Glo_Or_Loc_Id[Glo_Or_Loc].my_Variable[j] != null
             && id.equals( my_Glo_Or_Loc_Id[Glo_Or_Loc].my_Variable[j].m_var ) ) { // 如果是出現過的 id

          return true ;
        } // if()
      } // for()

    } // if()


    return false ;
        
        
  } // Same_Id_In_Same_Compound()
    
    private void Set_New_Definition( String id, int Glo_Or_Loc, int type, String array_num ) {
        
    boolean breakk = false ;

    for ( int i = Glo_Or_Loc ; !breakk && i >= 0 ; i-- ) { // 找此 {} 外面有宣告過的變數 
      // 找本身自己 {} 內 宣告的變數
      if ( my_Glo_Or_Loc_Already_Ini[i] ) { // 如果有初始化過
        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_var_num ; j++ ) {
          if ( id.equals( my_Glo_Or_Loc_Id[i].my_Variable[j].m_var ) ) { // 如果是出現過的 id
            // ===== 紀錄之前的 ======
            my_Glo_Or_Loc_Id[i].my_Variable[j].m_last_type 
            = my_Glo_Or_Loc_Id[i].my_Variable[j].m_type ;
            my_Glo_Or_Loc_Id[i].my_Variable[j].m_last_array_num
            = my_Glo_Or_Loc_Id[i].my_Variable[j].m_array_num ;
            // ===== 重新定義 =====
            my_Glo_Or_Loc_Id[i].my_Variable[j].m_new_def = true ; // 重新定義
            my_Glo_Or_Loc_Id[i].my_Variable[j].m_type = type ;
            my_Glo_Or_Loc_Id[i].my_Variable[j].m_array_num = array_num ;
            return ;
          } // if()
        } // for()

        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_Func_var_num ; j++ ) {
          if ( id.equals( my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_var ) ) { // 如果是出現過的 id
            // ===== 紀錄之前的 ======
            my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_last_type
            = my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_type ;
            my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_last_array_num
            = my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_array_num ;
            my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_last_Function_String
            = my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_Function_String ;
            // ===== 重新定義 =====
            my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_new_def = true ; // 重新定義
            my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_type = type ;
            my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_array_num = array_num ;
            my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_Function_String = Get_My_Now_Func_String() ;
            return ;
          } // if()
        } // for()

      } // if()
    } // for()
        
  } // Set_New_Definition()
    
    private void Print_ListAllVariables() {
        
    // 印全域變數
    // 由小到大印
    // [0] 為全域變數

    Id tempId = new Id() ; // 暫存 Id

    if ( my_Glo_Or_Loc_Already_Ini[0] ) { // 如果有初始化過

      Id myid = new Id() ; // 初始化它
      tempId = myid ; // 初始化它

      // 把原本 存 ID 的 陣列 copy 到另一個陣列上暫存
      for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].m_var_num ; i++ ) {
        Variable my_Variable = new Variable() ; // 初始化它
        tempId.my_Variable[i] = my_Variable ; // 初始化它
        tempId.my_Variable[i].m_var = my_Glo_Or_Loc_Id[0].my_Variable[i].m_var ;
      } // for()

      for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].m_var_num ; i++ ) {
        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[0].m_var_num - 1 - i ; j++ ) {
          if ( tempId.my_Variable[j].m_var.compareTo( tempId.my_Variable[j+1].m_var ) > 0 ) {
            String tmp = tempId.my_Variable[j].m_var ;
            tempId.my_Variable[j].m_var = tempId.my_Variable[j+1].m_var ;
            tempId.my_Variable[j+1].m_var = tmp ;
          } // if()
        } // for()
      } // for()



      for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].m_var_num ; i++ ) {

        if ( !tempId.my_Variable[i].m_var.equals( "" ) ) {
          System.out.println( tempId.my_Variable[i].m_var ) ;
        } // if()

      } // for()

    } // if()
    else {
      // 沒有定義過 全域變數
      // 不用印
    } // else()
        
  } // Print_ListAllVariables()
    
    private void Print_ListAllFunctions() {
        
    // 印 Function 變數
    // 由小到大印
    // Function 內不能再包 Function
    // 所以為 [0]

    Id tempId = new Id() ; // 暫存 Id

    if ( my_Glo_Or_Loc_Already_Ini[0] ) { // 如果有初始化過

      Id myid = new Id() ; // 初始化它
      tempId = myid ; // 初始化它

      // 把原本 存 ID 的 陣列 copy 到另一個陣列上暫存
      for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].m_Func_var_num ; i++ ) {
        Variable my_Variable = new Variable() ; // 初始化它
        tempId.my_Func_Variable[i] = my_Variable ; // 初始化它
        tempId.my_Func_Variable[i].m_var = my_Glo_Or_Loc_Id[0].my_Func_Variable[i].m_var ;
      } // for()

      for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].m_Func_var_num ; i++ ) {
        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[0].m_Func_var_num - 1 - i ; j++ ) {
          if ( tempId.my_Func_Variable[j].m_var.compareTo( tempId.my_Func_Variable[j+1].m_var ) > 0 ) {
            String tmp = tempId.my_Func_Variable[j].m_var ;
            tempId.my_Func_Variable[j].m_var = tempId.my_Func_Variable[j+1].m_var ;
            tempId.my_Func_Variable[j+1].m_var = tmp ;
          } // if()
        } // for()
      } // for()

      for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].m_Func_var_num ; i++ ) {
        System.out.println( tempId.my_Func_Variable[i].m_var + "()" ) ;
      } // for()

    } // if()
    else {
      // 沒有定義過 全域變數
      // 不用印
    } // else()
        
  } // Print_ListAllFunctions()
    
    private void Print_ListVariable() {
        
    // 因為此指令專門印 全域變數
    // 所以 [] 直接帶 0
    boolean breakk = false ;
    for ( int i = 0 ; !breakk && i < my_Glo_Or_Loc_Id[0].m_var_num ; i++ ) {

      // 如果是要印的 Id
      if ( my_Glo_Or_Loc_Id[0].my_Variable[i].m_var.equals( Get_ListVariable_Id() ) ) {

        String type = "" ;
        type = Change_Type_Num_To_Real_Type( my_Glo_Or_Loc_Id[0].my_Variable[i].m_type ) ;

        System.out.print( type + " " ) ;

        System.out.print( my_Glo_Or_Loc_Id[0].my_Variable[i].m_var ) ;

        // 如果有陣列
        if ( !my_Glo_Or_Loc_Id[0].my_Variable[i].m_array_num.equals( "" ) ) {
          System.out.println( "[ " + my_Glo_Or_Loc_Id[0].my_Variable[i].m_array_num + " ] ;" ) ;
        } // if()
        else { // 沒有陣列
          // 就要 ';' + 換行
          System.out.println( " ;" ) ;
        } // else()

        breakk = true ;
      } // if()
    } // for()
        
        
  } // Print_ListVariable()
    
    private void Print_ListFunction() {
        
    // 因為此指令專門印 Function
    // 所以 [] 直接帶 0
    // 且要有初始化過
    boolean breakk = false ;
    for ( int i = 0 ; !breakk && my_Glo_Or_Loc_Already_Ini[0] 
          && i < my_Glo_Or_Loc_Id[0].m_Func_var_num ; i++ ) {

      // 如果是要印的 Id
      if ( my_Glo_Or_Loc_Id[0].my_Func_Variable[i].m_var.equals( Get_ListFunction_Id() ) ) {

        System.out.print( my_Glo_Or_Loc_Id[0].my_Func_Variable[i].m_Function_String ) ;
        breakk = true ;
      } // if()
    } // for()
        
  } // Print_ListFunction()
    
    private String Change_Type_Num_To_Real_Type( int type ) {
        
    if ( type == 48 ) {
      return "int" ;
    } // if()
    else if ( type == 49 ) {
      return "double" ;
    } // else if()
    else if ( type == 50 ) {
      return "char" ;
    } // else if()
    else if ( type == 51 ) {
      return "bool" ;
    } // else if()
    else if ( type == 52 ) {
      return "string" ;
    } // else if()
    else if ( type == 53 ) {
      return "void" ;
    } // else if()
    else {
      return "Change_Type_Num_To_Real_Type()_Error" ;
    } // else()
        
  } // Change_Type_Num_To_Real_Type()
    
    private void Set_All( int num ) {
    Set_Done( num ) ;
    Set_ListAllVariables( num ) ;
    Set_ListAllFunctions( num ) ;
    Set_ListVariable( num ) ;
    Set_ListFunction( num ) ;
  } // Set_All()
    
    private void Set_Which_Done_List_Var_Func( boolean DDone, boolean ListAllVariables, 
                                               boolean ListAllFunctions,
                                               boolean ListVariable, 
                                               boolean ListFunction ) {
    if ( DDone ) {

      Set_Done( 1 ) ;
    } // if()
    else if ( ListAllVariables ) {

      Set_ListAllVariables( 1 ) ;
    } // else if()
    else if ( ListAllFunctions ) {
      Set_ListAllFunctions( 1 ) ;
    } // else if()
    else if ( ListVariable ) {
      Set_ListVariable( 1 ) ;
    } // else if()
    else if ( ListFunction ) {
      Set_ListFunction( 1 ) ;
    } // else if()
    else {

    } // else()
        
  } // Set_Which_Done_List_Var_Func()
    
    private void Set_Done( int num ) {
    mDone_num = mDone_num + num ;
  } // Set_Done()
    
    private void Set_Done_Zeor() {
    mDone_num = 0 ;
  } // Set_Done_Zeor()
    
    private void Set_Id_Type( int type ) {
    mId_type = type ;
  } // Set_Id_Type()
    
    private int Get_Id_Type() {
    return mId_type ;
  } // Get_Id_Type()
    
    // 印 cout 的 '>'
    
    private void Set_Print_Cout( boolean set ) {
    mprint_cout = set ;
  } // Set_Print_Cout()
    
    private boolean Get_Print_Cout() {
    return mprint_cout ;
  } // Get_Print_Cout()
    
    private void Set_ListAllVariables( int num ) {
    mListAllVariables_num = mListAllVariables_num + num ;
  } // Set_ListAllVariables()
    
    private void Set_ListAllFunctions( int num ) {
    mListAllFunctions_num = mListAllFunctions_num + num ;
  } // Set_ListAllFunctions()
    
    private void Set_ListVariable( int num ) {
    mListVariable_num = mListVariable_num + num ;
  } // Set_ListVariable()
    
    private void Set_ListFunction( int num ) {
    mListFunction_num = mListFunction_num + num ;
  } // Set_ListFunction()
    
    private boolean Return_Done() {
    if ( Return_Done_Num() == 4 ) {
      return true ;
    } // if()
    else {
      return false ;
    } // else()
  } // Return_Done()
    
    private boolean Return_ListAllVariables() {
    if ( Return_ListAllVariables_Num() == 4 ) {
      return true ;
    } // if()
    else {
      return false ;
    } // else()
  } // Return_ListAllVariables()
    
    private boolean Return_ListAllFunctions() {
    if ( Return_ListAllFunctions_Num() == 4 ) {
      return true ;
    } // if()
    else {
      return false ;
    } // else()
  } // Return_ListAllFunctions()
    
    private boolean Return_ListVariable() {
    if ( Return_ListVariable_Num() == 4 ) {
      return true ;
    } // if()
    else {
      return false ;
    } // else()
  } // Return_ListVariable()
    
    private boolean Return_ListFunction() {
    if ( Return_ListFunction_Num() == 4 ) {
      return true ;
    } // if()
    else {
      return false ;
    } // else()
  } // Return_ListFunction()
    
    private int Return_Done_Num() {
    return mDone_num ;
  } // Return_Done_Num()
    
    private int Return_ListAllVariables_Num() {
    return mListAllVariables_num ;
  } // Return_ListAllVariables_Num()
    
    private int Return_ListAllFunctions_Num() {
    return mListAllFunctions_num ;
  } // Return_ListAllFunctions_Num()
    
    private int Return_ListVariable_Num() {
    return mListVariable_num ;
  } // Return_ListVariable_Num()
    
    private int Return_ListFunction_Num() {
    return mListFunction_num ;
  } // Return_ListFunction_Num()
    
    private String Return_Token() {
    return my_TokenImfor[my_TokenImfor_num].m_token ;
  } // Return_Token()
    
    private boolean Return_Is_String() {
    return my_TokenImfor[my_TokenImfor_num].m_is_String ;
  } // Return_Is_String()
    
    private boolean Return_Is_Num() {
    return my_TokenImfor[my_TokenImfor_num].m_is_Num ;
  } // Return_Is_Num()
    
    private boolean Return_Is_Boolean() {
    return my_TokenImfor[my_TokenImfor_num].m_is_Boolean ;
  } // Return_Is_Boolean()
    
    private int Return_Token_Type() {
    return my_TokenImfor[my_TokenImfor_num].m_type ;
  } // Return_Token_Type()
    
    private boolean Return_Token_Is_Done() {
    return my_TokenImfor[my_TokenImfor_num].m_is_Done ;
  } // Return_Token_Is_Done()
    
    private boolean Return_Token_Is_ListAllVariables() {
    return my_TokenImfor[my_TokenImfor_num].m_is_ListAllVariables ;
  } // Return_Token_Is_ListAllVariables()
    
    private boolean Return_Token_Is_ListAllFunctions() {
    return my_TokenImfor[my_TokenImfor_num].m_is_ListAllFunctions ;
  } // Return_Token_Is_ListAllFunctions()
    
    private boolean Return_Token_Is_ListVariable() {
    return my_TokenImfor[my_TokenImfor_num].m_is_ListVariable ;
  } // Return_Token_Is_ListVariable()
    
    private boolean Return_Token_Is_ListFunction() {
    return my_TokenImfor[my_TokenImfor_num].m_is_ListFunction ;
  } // Return_Token_Is_ListFunction()
    
    private void Set_ListVariable_Id( String id ) {
    mListVariable_Id = id ;
  } // Set_ListVariable_Id()
    
    private void Set_ListFunction_Id( String id ) {
    mListFunction_Id = id ;
  } // Set_ListFunction_Id()
    
    private String Get_ListVariable_Id() {
    return mListVariable_Id ;
  } // Get_ListVariable_Id()
    
    private String Get_ListFunction_Id() {
    return mListFunction_Id ;
  } // Get_ListFunction_Id()
    
    private void Save_My_Now_Id( String id, boolean new_or_not, int type, boolean is_Function ) {
        
    my_Now_Id[Get_My_Now_Index()] = new Id() ;

    my_Now_Id[Get_My_Now_Index()].m_id_string = id ;
    my_Now_Id[Get_My_Now_Index()].m_type = type ;
    my_Now_Id[Get_My_Now_Index()].m_is_Function = is_Function ;

    if ( new_or_not ) {
      my_Now_Id[Get_My_Now_Index()].m_new_def = true ;
    } // if()

    Add_My_Now_Id_Num() ;
        
  } // Save_My_Now_Id()
    
    private void ReSet_My_Now_Id() {
        
    for ( int i = 0 ; i < Get_My_Now_Index() ; i++ ) {
      my_Now_Id[Get_My_Now_Index()].m_id_string = "" ;
    } // for()
        
  } // ReSet_My_Now_Id()
    
    private void Add_My_Now_Id_Num() {
    my_Now_Id_Num++ ;
  } // Add_My_Now_Id_Num()
    
    private void ReSet_My_Now_Index() {
    my_Now_Id_Num = 0 ;
  } // ReSet_My_Now_Index()
    
    private int Get_My_Now_Index() {
    return my_Now_Id_Num ;
  } // Get_My_Now_Index()
    
    // ============================= 初始化 =============================
    
    private void Initialization() {
        
    if ( Enough_Token() )
      my_line = 1 ;
    else
      my_line = 0 ;

    mDone_num = 0 ;
    mListAllVariables_num = 0 ;
    mListAllFunctions_num = 0 ;
    mListVariable_num = 0 ;
    mListFunction_num = 0 ;
    merror_token = "" ; // 紀錄第一個出現的錯誤
    merror_token_type = -1 ;
    merror_token_already_set = false ; // 是否已經紀錄過第一個出現的錯誤
    merror_token_no_id = false ; // 第一個錯誤是不是 未定義 的 id
    minside_the_LBP = false ;
    mListVariable_Id = "" ;
    mListFunction_Id = "" ;
    my_Now_Id_Num = 0 ;
    mis_function = false ;
    my_now_func_String = "" ;
    ReSet_My_Now_Id() ;
    mcompound_enter = 0 ;
    mcheck_next_token_RBP = false ;
    marray_number = "" ;
    mprint_cout = true ;
    mever_cout = false ;
    mIs_double = false ;



    m_Basic_expression = "" ;
    m_Expression = "" ;
    m_Statement = "" ;
    m_rest_of_PPMM_Identifier_started_basic_exp = "" ;
    m_romce_and_romloe = "" ;
    m_rest_of_maybe_relational_exp = "" ;
    m_maybe_relational_exp = "" ;
    m_rest_of_maybe_equality_exp = "" ;
    m_maybe_equality_exp = "" ;
    m_rest_of_maybe_bit_AND_exp = "" ;
    m_maybe_bit_AND_exp = "" ;
    m_rest_of_maybe_bit_ex_OR_exp = "" ;
    m_maybe_bit_ex_OR_exp = "" ;
    m_rest_of_maybe_bit_OR_exp = "" ;
    m_maybe_bit_OR_exp = "" ;
    m_rest_of_maybe_logical_AND_exp = "" ;
    m_maybe_logical_AND_exp = "" ;
    m_rest_of_maybe_logical_OR_exp = "" ;
    m_rest_of_maybe_mult_exp = "" ;
    m_rest_of_Identifier_started_basic_exp = "" ;
    m_maybe_mult_exp = "" ;
    m_signed_unary_exp = "" ;
    m_unsigned_unary_exp = "" ;
    m_unary_exp = "" ;
    m_rest_of_maybe_additive_exp = "" ;
    m_maybe_additive_exp = "" ;
    m_rest_of_maybe_shift_exp = "" ;
    m_maybe_shift_exp = "" ;

    m_Up_Romce_and_romloe_num_or_bool = -9487 ;


    m_cout_or_shift = LS ;
    m_Rest_of_maybe_relational_exp_num_or_bool = FLOAT ;
    m_Maybe_relational_exp_num_or_bool = FLOAT ;
    m_Rest_of_maybe_equality_exp_num_or_bool = FLOAT ;
    m_Maybe_equality_exp_num_or_bool = FLOAT ;
    m_Rest_of_maybe_bit_AND_exp_num_or_bool = FLOAT ;
    m_Maybe_bit_AND_exp_num_or_bool = FLOAT ;
    m_Rest_of_maybe_bit_ex_OR_exp_num_or_bool = FLOAT ;
    m_Maybe_bit_ex_OR_exp_num_or_bool = FLOAT ;
    m_Rest_of_maybe_bit_OR_exp_num_or_bool = FLOAT ;
    m_Maybe_bit_OR_exp_num_or_bool = FLOAT ;
    m_Rest_of_maybe_logical_AND_exp_num_or_bool = FLOAT ;
    m_Maybe_logical_AND_exp_num_or_bool = FLOAT ;
    m_Rest_of_maybe_logical_OR_exp_num_or_bool = FLOAT ;
    m_Romce_and_romloe_num_or_bool = FLOAT ;


    Ini_Operator() ;
    my_operator_count = -1 ;

    my_sign = -1 ;
        
        
  } // Initialization()
    
    private void Set_My_Now_Func_String( String set, int space ) {
    my_now_func_String = my_now_func_String + set ;
    // 存空格
    for ( int j = 0 ; j < space ; j++ ) {
      my_now_func_String = my_now_func_String + " " ;
    } // for
  } // Set_My_Now_Func_String()
    
    private String Get_My_Now_Func_String() {
    return my_now_func_String ;
  } // Get_My_Now_Func_String()
    
    private int Get_Last_Token_Type() {
    return mlast_token_type ;
  } // Get_Last_Token_Type()
    
    private String Get_Last_Token() {
    return mlast_token ;
  } // Get_Last_Token()
    
    private void Save_Last_Token_Type( int type ) {
    mlast_token_type = type ;
  } // Save_Last_Token_Type()
    
    private void Save_Last_Token( String token ) {
    mlast_token = token ;
  } // Save_Last_Token()
    
    private void Get_Token() {
    Save_Last_Token_Type( Return_Token_Type() ) ;
    Save_Last_Token( Return_Token() ) ;

    if ( Get_Set_While() >= 0 ) { // 如果要存 while
      Copy_While_Token( Return_Token(), Return_Token_Type(), Return_Is_String() ) ;
    } // if()

    my_TokenImfor_num++ ;
  } // Get_Token()
    
    private void Copy_my_TokenImfor( Token myToken ) {
        
    for ( int i = 0 ; i < 1000 ; i++ ) {
      my_TokenImfor[i] = new TokenImfor() ;
    } // for()

    for ( int i = 0 ; i <= myToken.my_TokenImfor_num ; i++ ) {
      my_TokenImfor[i].m_token = myToken.my_TokenImfor[i].m_token ;
      my_TokenImfor[i].m_type = myToken.my_TokenImfor[i].m_type ;
      my_TokenImfor[i].m_is_Done = myToken.my_TokenImfor[i].m_is_Done ;
      my_TokenImfor[i].m_is_ListAllVariables = myToken.my_TokenImfor[i].m_is_ListAllVariables ;
      my_TokenImfor[i].m_is_ListAllFunctions = myToken.my_TokenImfor[i].m_is_ListAllFunctions ;
      my_TokenImfor[i].m_is_ListVariable = myToken.my_TokenImfor[i].m_is_ListVariable ;
      my_TokenImfor[i].m_is_ListFunction = myToken.my_TokenImfor[i].m_is_ListFunction ;
      my_TokenImfor[i].m_is_String = myToken.my_TokenImfor[i].m_is_String ;
      my_TokenImfor[i].m_is_Num = myToken.my_TokenImfor[i].m_is_Num ;
      my_TokenImfor[i].m_is_Boolean = myToken.my_TokenImfor[i].m_is_Boolean ;
      my_TokenImfor[i].m_is_Float = myToken.my_TokenImfor[i].m_is_Float ;
      my_TokenImfor[i].m_is_Char = myToken.my_TokenImfor[i].m_is_Char ;
    } // for()
  } // Copy_my_TokenImfor()
    
    private void Read_Input() {
        
    my_TokenImfor_num = 0 ; // 初始化
    String buffer = "" ;
    buffer = mcin.nextLine() + '\n' ;
    Add_Line() ; // 行數++

    Token myToken = new Token() ;
    myToken.CutToken( buffer ) ; 
    my_TokenImfor_length = myToken.my_TokenImfor_num ;

    Copy_my_TokenImfor( myToken ) ;
        
  } // Read_Input()
    
    private boolean Enough_Token() {
        
    if ( 0 <= my_TokenImfor_length && my_TokenImfor_num < my_TokenImfor_length ) {

      return true ;
    } // if()
    else {

      return false ; 
    } // else()
  } // Enough_Token()
    
    private int Get_Now_Token_Tpye() {
        
    if ( Enough_Token() ) { // 如果 Token 夠多

      if ( Get_Check_Next_Token_RBP() ) {
        if ( my_TokenImfor[my_TokenImfor_num].m_type != RBP ) { // 如果"不"是 '{'
          Set_My_Now_Func_String( "", 2 ) ; // 空 2 格
          Set_Check_Next_Token_RBP( false ) ;
        } // if()
      } // if()

      return my_TokenImfor[my_TokenImfor_num].m_type ;
    } // if()
    else { // 不夠了

      boolean breakk = false ;
      for ( ; !breakk ; ) {  // 直到 Token 夠多為止
        Read_Input() ; // 再讀進來
        if ( Enough_Token() ) { // 如果 Token 夠多
          breakk = true ;
        } // if()
      } // for()

      if ( Get_Check_Next_Token_RBP() ) {
        if ( my_TokenImfor[my_TokenImfor_num].m_type != RBP ) { // 如果"不"是 '{'
          Set_My_Now_Func_String( "", 2 ) ; // 空 2 格
          Set_Check_Next_Token_RBP( false ) ;
        } // if()
      } // if()

      return my_TokenImfor[my_TokenImfor_num].m_type ; 
    } // else()
        
  } // Get_Now_Token_Tpye()
    
    private void Set_Error_Token( String token ) {
    merror_token = token ;
  } // Set_Error_Token()
    
    private void Set_Error_Type( int type ) {
    merror_token_type = type ;
  } // Set_Error_Type()
    
    private void Set_Error_Token_No_Id( boolean no_id ) {
    merror_token_no_id = no_id ;
  } // Set_Error_Token_No_Id()
    
    private void Set_Error_Token_Already_Set( boolean set ) {
    merror_token_already_set = set ;
  } // Set_Error_Token_Already_Set()
    
    private boolean Get_Error_Token_Already_Set() {
    return merror_token_already_set ;
  } // Get_Error_Token_Already_Set()
    
    private String Get_Error_Token() {
    return merror_token ;
  } // Get_Error_Token()
    
    private int Get_Error_Type() {
    return merror_token_type ;
  } // Get_Error_Type()
    
    private boolean Get_Error_Token_No_Id() {
    return merror_token_no_id ;
  } // Get_Error_Token_No_Id()
    
    private void Set_Inside_The_LBP( boolean set ) {
    minside_the_LBP = set ;
  } // Set_Inside_The_LBP()
    
    private boolean Get_Inside_The_LBP() {
    return minside_the_LBP ;
  } // Get_Inside_The_LBP()
    
    private void Ini_Set_New_ID( int which ) {
        
    if ( !my_Glo_Or_Loc_Already_Ini[which] ) {
      // 如果沒初始化過
      // 所以 [0]
      // 不過僅須初始化 一般變數
      // 不用初始化 Function 變數
      // 因為在 {} 外已經宣告過此變數 導致 {} 為 Same_Id
      // 導致不用儲存 而導致 {} 內尚未宣告
      // 此情況只有可能是 一般變數
      // 因為 Function 不能 Function 內 再 Function
      Id myid = new Id() ; // 初始化它
      my_Glo_Or_Loc_Id[which] = myid ; // 初始化它
      Variable myVariable1 = new Variable() ;
      my_Glo_Or_Loc_Id[which].my_Variable[0] = myVariable1 ; // 初始化它
      // my_Glo_Or_Loc_Already_Ini[which] = false ;

    } // if()
    else {
      System.out.println( "There is NO need to Ini ---> Ini_Set_New_ID_Error !!! " ) ;
    } // else()
        
  } // Ini_Set_New_ID()
    
    private void Undo_Variable( Variable[] my, int my_num ) {
        
        
    int count = 0 ;
    // 要 -1 是因為 [0] 沒有存東西 ( 重 1 開始 )

    for ( int j = 0 ; j < my_num ; j++ ) {

      for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].m_var_num ; i++ ) {
        // 如果是此 id
        if ( my[j].m_var.equals( my_Glo_Or_Loc_Id[0].my_Variable[i].m_var ) ) {

          if ( my_Glo_Or_Loc_Id[0].my_Variable[i].m_new_def ) { // 如果已經有重新定義過
            // 表示定義了不只一次
            my_Glo_Or_Loc_Id[0].my_Variable[i].m_type 
            = my_Glo_Or_Loc_Id[0].my_Variable[i].m_last_type ;
            my_Glo_Or_Loc_Id[0].my_Variable[i].m_array_num
            = my_Glo_Or_Loc_Id[0].my_Variable[i].m_last_array_num ;

          } // if()
          else { // 沒重新定義過
            // 代表只定義一次
            // 所有還原就是初始化它
            Variable myVariable1 = new Variable() ;
            my_Glo_Or_Loc_Id[0].my_Variable[i] = myVariable1 ;
            count++ ;
          } // else()


        } // if()

      } // for()


    } // for()



    my_Glo_Or_Loc_Id[0].m_var_num = my_Glo_Or_Loc_Id[0].m_var_num - count ;
        
  } // Undo_Variable()
    
    private void Set_New_ID( String save_id, int which, int type, boolean is_Function, String array_num ) {
        
    if ( !my_Glo_Or_Loc_Already_Ini[which] ) { // 如果沒初始化過
      // 因為沒初始化過
      // 所以 [0]
      Id myid = new Id() ; // 初始化它
      my_Glo_Or_Loc_Id[which] = myid ; // 初始化它
      Variable myVariable1 = new Variable() ;
      Variable myVariable2 = new Variable() ;
      my_Glo_Or_Loc_Id[which].my_Variable[0] = myVariable1 ; // 初始化它
      my_Glo_Or_Loc_Id[which].my_Func_Variable[0] = myVariable2 ; // 初始化它

      // 初始化全部的 Array
      for ( int i = 0 ; i < 50 ; i++ ) {
        Array myArray = new Array() ;
        my_Glo_Or_Loc_Id[which].my_Variable[0].my_Array[i] = myArray ;
      } // for()


      if ( is_Function ) { // 如果是 Function

        my_Glo_Or_Loc_Id[which].my_Func_Variable[0].m_var
        = save_id ; // 存 id
        my_Glo_Or_Loc_Id[which].my_Func_Variable[0].m_Func_type
        = type ; // 存 型別
        my_Glo_Or_Loc_Id[which].my_Func_Variable[0].m_is_Function
        = is_Function ; // 存 是否為 Function
        my_Glo_Or_Loc_Id[which].my_Func_Variable[0].m_Function_String 
        = Get_My_Now_Func_String() ; // 存 Function
        my_Glo_Or_Loc_Id[which].my_Func_Variable[0].m_last_Function_String 
        = Get_My_Now_Func_String() ; // 存 Function
        my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過

      } // if()
      else { // 不是 Function

        my_Glo_Or_Loc_Id[which].my_Variable[0].m_var = save_id ; // 存 id
        my_Glo_Or_Loc_Id[which].my_Variable[0].m_type = type ; // 存 型別
        my_Glo_Or_Loc_Id[which].my_Variable[0].m_is_Function = is_Function ; // 存 是否為 Function
        my_Glo_Or_Loc_Id[which].my_Variable[0].m_array_num = array_num ;
        // ==== 也記錄在 last 裡面
        my_Glo_Or_Loc_Id[which].my_Variable[0].m_last_type = type ; // 存 型別
        my_Glo_Or_Loc_Id[which].my_Variable[0].m_last_array_num = array_num ;
        my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過

      } // else()

    } // if()
    else { // 有初始化過

      if ( is_Function ) { // 如果是 Function

        int varnum = my_Glo_Or_Loc_Id[which].m_Func_var_num ;
        my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].m_var
        = save_id ; // 存 id
        my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].m_Func_type
        = type ; // 存 型別
        my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].m_is_Function 
        = is_Function ; // 存 是否為 Function
        my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].m_Function_String 
        = Get_My_Now_Func_String() ; // 存 Function
        my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].m_last_Function_String 
        = Get_My_Now_Func_String() ; // 存 Function
        my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過

      } // if()
      else { // 不是 Function

        int varnum = my_Glo_Or_Loc_Id[which].m_var_num ;

        // 初始化全部的 Array
        for ( int i = 0 ; i < 50 ; i++ ) {
          Array myArray = new Array() ;
          my_Glo_Or_Loc_Id[which].my_Variable[varnum].my_Array[i] = myArray ;
        } // for()



        my_Glo_Or_Loc_Id[which].my_Variable[varnum].m_var = save_id ; // 存 id
        my_Glo_Or_Loc_Id[which].my_Variable[varnum].m_type = type ; // 存 型別
        my_Glo_Or_Loc_Id[which].my_Variable[varnum].m_is_Function = is_Function ; // 存 是否為 Function
        my_Glo_Or_Loc_Id[which].my_Variable[varnum].m_array_num = array_num ;
        // ==== 也記錄在 last 裡面
        my_Glo_Or_Loc_Id[which].my_Variable[varnum].m_last_type = type ; // 存 型別
        my_Glo_Or_Loc_Id[which].my_Variable[varnum].m_last_array_num = array_num ;
        my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過

      } // else()

    } // else()
        
  } // Set_New_ID()
    
    private void Var_Num_Add( int which ) {
        
    my_Glo_Or_Loc_Id[which].m_var_num++ ; // index + 1

    // 已經第一次初始化了
    // 其他就不是從 0 開始了
    int varnum = my_Glo_Or_Loc_Id[which].m_var_num ;
    Variable myVariable2 = new Variable() ;
    my_Glo_Or_Loc_Id[which].my_Variable[varnum] = myVariable2 ; // 初始化它
        
        
  } // Var_Num_Add()
    
    private void Func_Var_Num_Add( int which ) {
        
    my_Glo_Or_Loc_Id[which].m_Func_var_num++ ; // index + 1
    int varnum = -1 ;
    // 初始化下一個
    varnum = my_Glo_Or_Loc_Id[which].m_Func_var_num ;
    Variable myVariable3 = new Variable() ;
    my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum] = myVariable3 ; // 初始化它
       
  } // Func_Var_Num_Add()
    
    private void Func_Or_Var_Num_Add( int which, boolean is_function ) {
        
    if ( is_function ) {
      Func_Var_Num_Add( which ) ;
    } // if()
    else {
      Var_Num_Add( which ) ;
    } // else()
        
  } // Func_Or_Var_Num_Add()
    
    private void Clear_Function_Variable( int which ) {
        
    // 初始化
    my_Glo_Or_Loc_Already_Ini[which] = false ; 
    Id set = new Id() ;
    my_Glo_Or_Loc_Id[which] = set ;

  } // Clear_Function_Variable()
    
    private boolean Is_Return_Get_My_Glo_Or_Loc_Id_Length_Null( int which ) {
        
    if ( my_Glo_Or_Loc_Already_Ini[which] ) { 
      // 初始化過了
      // 不為 Null
      return false ;
    } // if()
    else {
      return true ;
    } // else()
        
  } // Is_Return_Get_My_Glo_Or_Loc_Id_Length_Null()
    
    private boolean Is_Cout( String id ) {
    if ( id.equals( "cout" ) ) {
      return true ;
    } // if()
    else {
      return false ;
    } // else()
  } // Is_Cout()
    
    // ======== While ======== 
    
    private void Set_Ever_Print_BT( boolean set ) {
    mever_print_BT = set ;
  } // Set_Ever_Print_BT()
    
    private boolean Get_Ever_Print_BT() {
    return mever_print_BT ;
  } // Get_Ever_Print_BT()    
    
    private void Set_Set_While( int set ) {
    mset_while = mset_while + set ;
  } // Set_Set_While()
    
    private void Direct_Set_Set_While( int set ) {
    mset_while = set ;
  } // Direct_Set_Set_While()
    
    private int  Get_Set_While() {
    return mset_while ;
  } // Get_Set_While()
    
    private String Get_While_String() {
    return mwhile_buffer ;
  } // Get_While_String()
    
    private void Clean_While_String() {
    mwhile_buffer = "" ;
  } // Clean_While_String()
    
    private void Copy_While_Token( String token, int type, boolean is_string ) {
        
    if ( type == CONSTANT ) { // 如果是 constant


      if ( is_string ) { // 如果是 字串
        mwhile_buffer = mwhile_buffer + "\"" + token + "\" " ;
      } // if()
      else {
        mwhile_buffer = mwhile_buffer + token + " " ;
      } // else()

    } // if()
    else {
      mwhile_buffer = mwhile_buffer + token + " " ;
    } // else()
        
        
        
  } // Copy_While_Token()
    
    private void Add_While_Token_To_My_Token() {
        
    my_TokenImfor_num = 0 ; // 初始化
    Token myToken = new Token() ;
    myToken.CutToken( Get_While_String() ) ; 
    my_TokenImfor_length = myToken.my_TokenImfor_num ;

    Copy_my_TokenImfor( myToken ) ;
        
  } // Add_While_Token_To_My_Token()
    
    // ======== While ========
    
    // ======== Fake 假的宣告型別 ========
    
    private void Set_Fake_Variable( String id, int Glo_Or_Loc ) {
        
    boolean breakk = false ;

    for ( int i = Glo_Or_Loc ; !breakk && i >= 0 ; i-- ) { // 找此 {} 外面有宣告過的變數 
      // 找本身自己 {} 內 宣告的變數
      if ( my_Glo_Or_Loc_Already_Ini[i] ) { // 如果有初始化過
        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_var_num ; j++ ) {
          if ( my_Glo_Or_Loc_Id[i].my_Variable[j] != null 
               && id.equals( my_Glo_Or_Loc_Id[i].my_Variable[j].m_var ) ) { // 如果是出現過的 id
            my_Glo_Or_Loc_Id[i].my_Variable[j].m_is_fake = true ;

            return ;
          } // if()
        } // for()

        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_Func_var_num ; j++ ) {
          if ( id.equals( my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_var ) ) { // 如果是出現過的 id

            my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_is_fake = true ;
            return ;
          } // if()
        } // for()

      } // if()
    } // for()
        
        
        
  } // Set_Fake_Variable()
    
    private void Delete_Fake_Variable( int Glo_Or_Loc ) {
        
    int count_var = 0 ;
    int count_fun_var = 0 ;

    for ( int i = Glo_Or_Loc ; i >= 0 ; i-- ) { // 找此 {} 外面有宣告過的變數 
      // 找本身自己 {} 內 宣告的變數
      count_var = 0 ;
      count_fun_var = 0 ;
      if ( my_Glo_Or_Loc_Already_Ini[i] ) { // 如果有初始化過

        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_var_num ; j++ ) {

          if ( my_Glo_Or_Loc_Id[i].my_Variable[j] != null 
               && my_Glo_Or_Loc_Id[i].my_Variable[j].m_is_fake ) { // 如果是假的的 id

            count_var++ ;
          } // if()
        } // for()

        for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_Func_var_num ; j++ ) {
          if ( my_Glo_Or_Loc_Id[i].my_Func_Variable[j].m_is_fake ) { // 如果是假的的 id

            count_fun_var++ ;
          } // if()
        } // for()

      } // if()

      if ( my_Glo_Or_Loc_Id[i] != null ) {
        my_Glo_Or_Loc_Id[i].m_var_num = my_Glo_Or_Loc_Id[i].m_var_num - count_var ;
        my_Glo_Or_Loc_Id[i].m_Func_var_num = my_Glo_Or_Loc_Id[i].m_Func_var_num - count_fun_var ;
      } // if()



    } // for()
        
        
        
  } // Delete_Fake_Variable()
    
    // ======== Fake 假的宣告型別 ========
    
    // 把 String 轉回各種型別
    
    private boolean Turn_String_To_Boolean( String str ) {
        
    if ( str.equals( "true" ) ) {
      return true ;
    } // if()
    else if ( str.equals( "false" ) ) {
      return false ;
    } // else if()
    else {
      // Print("Turn_String_To_Boolean_Error") ;
      return false ;
    } // else()
        
  } // Turn_String_To_Boolean()
    
    private char Turn_String_To_Char( String str ) {
        
    if ( str.length() == 1 ) { // 只有 1 個字元
      return str.charAt( 0 ) ;
    } // if()
    else { // 多個字元
      // Print("Turn_String_To_Char_Error") ;
      return '@' ;
    } // else()
        
  } // Turn_String_To_Char()
    
    private int Turn_String_To_Int( String str ) {
        
    int afterConvert = Integer.parseInt( str );
    return afterConvert ;
        
  } // Turn_String_To_Int()
    
    private double Turn_String_To_Float( String str ) {
        
    double afterConvert ; 

    if ( !str.equals( "" ) ) { // 如果 value 不是空
      if ( !String_Is_Float( str ) && !String_Is_Int( str ) ) {
        return -9487 ;
      } // if()
        
        
      afterConvert = Double.parseDouble( str ) ; 
      return afterConvert ;
    } // if()
    else {
      return -9487 ;
    } // else()
        
  } // Turn_String_To_Float()
    
    // 把 String 轉回各種型別
    
    private boolean String_Is_Float( String str ) {
    for ( int i = 0 ; i < str.length() ; i++ ) {
      if ( !Character.isDigit( str.charAt( i ) ) && str.charAt( i ) != '-'
           && str.charAt( i ) != '.' && str.charAt( i ) != 'E' ) {
        return false ;
      } // if()
    } // for()
        
        
    for ( int i = 0 ; i < str.length() ; i++ ) {
      if ( str.charAt( i ) == '.' ) {
        return true ;
      } // if()
    } // for()

    return false ;
  } // String_Is_Float()
    
    private boolean String_Is_Int( String str ) {
        
        
    for ( int i = 0 ; i < str.length() ; i++ ) {
      if ( !Character.isDigit( str.charAt( i ) ) && str.charAt( i ) != '-' ) {
        return false ;
      } // if()
    } // for()


    return true ;
  } // String_Is_Int()
    
    private boolean String_Is_Char( String str ) {
        
    if ( str.length() == 1 ) {
      return true ;
    } // if()

    return false ;
        
  } // String_Is_Char()
    
    private boolean String_Is_Boolean( String str ) {
        
    if ( str.equals( "true" ) || str.equals( "false" ) ) {
      return true ;
    } // if()

    return false ;
        
  } // String_Is_Boolean()
    
    private boolean String_Is_String( String str ) {
        
        
    if ( !String_Is_Float( str ) 
         && !String_Is_Int( str )  
         && !String_Is_Boolean( str ) ) {
      return true ;
    } // if()

    return false ;
        
  } // String_Is_String()
    
    private int String_Which_Type( String str ) {
        
    if ( str.equals( "true" ) || str.equals( "false" ) ) {
      return BOOL ;
    } // if()
    else if ( String_Is_Float( str ) ) {
      return FLOAT ;
    } // else if()
    else if ( String_Is_Int( str ) ) {
      return INT ;
    } // else if()
    else {
      return STRING ;
    } // else()
        
        
  } // String_Which_Type()
    
    // ======= 浮點數判斷 =======
    
    private void Set_Is_Float( boolean f ) {
    mIs_double = f ;
  } // Set_Is_Float()
    
    private boolean Get_Is_Float() {
    return mIs_double ;
  } // Get_Is_Float()
    
    private boolean Return_Token_Is_Float() {
    return my_TokenImfor[my_TokenImfor_num].m_is_Float ;
  } // Return_Token_Is_Float()
    
    private boolean Return_Id_Is_Float( String id, int Glo_Or_Loc ) {
        
    boolean breakk = false ;

    // if ( my_Glo_Or_Loc_Id == null ) {
      // return false ;
    // } // if()

    for ( int i = 0 ; !breakk && i <= Glo_Or_Loc ; i++ ) { // 找此 {} 外面有宣告過的變數 

      if ( my_Glo_Or_Loc_Id[i] == null ) {

        return false ;
      } // if()

      for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].m_var_num ; j++ ) {

        if ( my_Glo_Or_Loc_Id[i].my_Variable[j] == null ) {

          return false ;
        } // if()

        if ( id.equals( my_Glo_Or_Loc_Id[i].my_Variable[j].m_var ) ) { // 如果是出現過的 id
          if ( my_Glo_Or_Loc_Id[i].my_Variable[j].m_type == FLOAT ) { // 如果是 浮點數
            return true ;
          } // if()
          else {
            return false ;
          } // else()
        } // if()
      } // for()

    } // for()


    return false ;
  } // Return_Id_Is_Float()
    
    // ======= 浮點數判斷 =======
    
    private void Save_Id_Num( String id, int which, String num, int operator, int array_num ) {
        
    boolean breakk = false ;
    boolean breakk_outside = false ;


    // 一層一層往外找
    for ( ; !breakk_outside && which >= 0 ; which-- ) {

      for ( int j = 0 ; !breakk 
            && my_Glo_Or_Loc_Id[which] != null 
            && j < my_Glo_Or_Loc_Id[which].m_var_num ; j++ ) {

        if ( my_Glo_Or_Loc_Id[which].my_Variable[j] != null
             && id.equals( my_Glo_Or_Loc_Id[which].my_Variable[j].m_var ) ) { // 如果是一樣的 id



          if ( operator == SMALL_EQU ) { // 如果是 '='


            if ( array_num == -1 ) { // 如果 沒有陣列

              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value
                = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = num ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = num ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value = num ;
              } // else()

            } // if()
            else { // 有陣列

              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value  ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value 
                = num ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                = num ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value
                = num ;
              } // else()

            } // else()


          } // if()
          else if ( operator == TE ) { // 如果是 '*='

            double now_value = -1 ;
            double string_num = -1 ;



            if ( array_num == -1 ) { // 如果 沒有陣列
              String f = "" ;
              f = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;
              now_value 
              = Turn_String_To_Float( f ) ;
              string_num 
              = Turn_String_To_Float( num ) ;
              now_value *= string_num ;


              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;

                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value
                = now_value + "" ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value
                = now_value + "" ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value
                = now_value + "" ;
              } // else()

            } // if()
            else { // 有陣列
              String f = "" ;
              f = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value ;
              now_value 
              = Turn_String_To_Float( f ) ;
              string_num 
              = Turn_String_To_Float( num ) ;
              now_value *= string_num ;


              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value  ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                = now_value + "" ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                = now_value + "" ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value
                = now_value + "" ;
              } // else()

            } // else()


          } // else if()
          else if ( operator == DE ) { // 如果是 '/='


            double now_value = -1 ;
            double string_num = -1 ;


            if ( array_num == -1 ) { // 如果 沒有陣列
              String f = "" ;
              f = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;
              now_value 
              = Turn_String_To_Float( f ) ;
              string_num 
              = Turn_String_To_Float( num ) ;
              now_value /= string_num ;


              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;

                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value
                = now_value + "" ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value 
                = now_value + "" ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value
                = now_value + "" ;
              } // else()

            } // if()
            else { // 有陣列
              String f = "" ;
              f = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value ;
              now_value 
              = Turn_String_To_Float( f ) ;
              string_num 
              = Turn_String_To_Float( num ) ;
              now_value /= string_num ;


              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value  ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                = now_value + "" ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                = now_value + "" ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value
                = now_value + "" ;
              } // else()

            } // else()

          } // else if()
          else if ( operator == RE ) { // 如果是 '%='

            double now_value = -1 ;
            double string_num = -1 ;



            if ( array_num == -1 ) { // 如果 沒有陣列


              now_value 
              = Turn_String_To_Float( my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ) ;
              string_num 
              = Turn_String_To_Float( num ) ;
              now_value %= string_num ;


              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;

                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = now_value + "" ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = now_value + "" ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value = now_value + "" ;
              } // else()

            } // if()
            else { // 有陣列
              String f = "" ;
              f = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value ;
              now_value 
              = Turn_String_To_Float( f ) ;
              string_num 
              = Turn_String_To_Float( num ) ;
              now_value %= string_num ;

              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value  ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                = now_value + "" ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                = now_value + "" ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value
                = now_value + "" ;
              } // else()

            } // else()


          } // else if()
          else if ( operator == PE ) { // 如果是 '+='


            double now_value = -1 ;
            double string_num = -1 ;



            if ( array_num == -1 ) { // 如果 沒有陣列


              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_type == STRING
                   || String_Is_String( num ) ) {
                // 如果有個是字串

                String now_value_string = "" ;
                String string_num_string = "" ;

                now_value_string 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;
                string_num_string = num ;
                now_value_string += string_num_string ;


                if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_new_def ) { // 如果已經有重新定義過
                  my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value 
                  = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;

                  my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = now_value_string ;
                } // if()
                else {
                  my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = now_value_string ;
                  my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value = now_value_string ;
                } // else()

              } // if()
              else {
                // 兩個都不是字串

                now_value 
                = Turn_String_To_Float( my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ) ;
                string_num 
                = Turn_String_To_Float( num ) ;
                now_value += string_num ;


                if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_new_def ) { // 如果已經有重新定義過
                  my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value 
                  = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;

                  my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = now_value + "" ;
                } // if()
                else {
                  my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = now_value + "" ;
                  my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value = now_value + "" ;
                } // else()


              } // else()

            } // if()
            else { // 有陣列

              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_type == STRING
                   || String_Is_String( num ) ) {
                // 如果有個是字串

                String now_value_string = "" ;
                String string_num_string = "" ;

                now_value_string 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value ;
                string_num_string = num ;
                now_value_string += string_num_string ;


                if ( my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_new_def ) { // 如果已經有重新定義過
                  my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value 
                  = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value  ;
                  my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                  = now_value_string ;
                } // if()
                else {

                  my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                  = now_value_string ;
                  my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value
                  = now_value_string ;
                } // else()

              } // if()
              else {
                // 兩個都不是字串
                String e = "" ;
                e = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value ;
                now_value 
                = Turn_String_To_Float( e ) ;
                string_num 
                = Turn_String_To_Float( num ) ;
                now_value += string_num ;


                if ( my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_new_def ) { // 如果已經有重新定義過
                  my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value 
                  = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value  ;
                  my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                  = now_value + "" ;
                } // if()
                else {

                  my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                  = now_value + "" ;
                  my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value
                  = now_value + "" ;
                } // else()


              } // else()


            } // else()

          } // else if()
          else if ( operator == ME ) { // 如果是 '-='

            double now_value = -1 ;
            double string_num = -1 ;



            if ( array_num == -1 ) { // 如果 沒有陣列


              now_value 
              = Turn_String_To_Float( my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ) ;
              string_num 
              = Turn_String_To_Float( num ) ;
              now_value -= string_num ;


              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;

                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = now_value + "" ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value = now_value + "" ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_last_value = now_value + "" ;
              } // else()

            } // if()
            else { // 有陣列
              String d = "" ;
              d = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value ;
              now_value 
              = Turn_String_To_Float( d ) ;
              string_num 
              = Turn_String_To_Float( num ) ;
              now_value -= string_num ;


              if ( my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_new_def ) { // 如果已經有重新定義過
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value 
                = my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value  ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value
                = now_value + "" ;
              } // if()
              else {
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value 
                = now_value + "" ;
                my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_last_value
                = now_value + "" ;
              } // else()

            } // else()

          } // else if()
          else {
            // Print( "Save_Id_Num_Error" ) ;
          } // else()


          breakk = true ;
          breakk_outside = true ;

        } // if()
        
      } // for()

    } // for()
        
        
  } // Save_Id_Num()
    
    // ======== 拿 Id 的值 ========
    
    private String Get_Id_Num( String id, int which, int array_num ) {
        
        
    // 一層一層往外找
    for ( ; which >= 0 ; which-- ) {

      for ( int j = 0 ; my_Glo_Or_Loc_Id[which] != null 
            && j < my_Glo_Or_Loc_Id[which].m_var_num ; j++ ) {

        if ( my_Glo_Or_Loc_Id[which].my_Variable[j] != null
             && id.equals( my_Glo_Or_Loc_Id[which].my_Variable[j].m_var ) ) { 
          // 如果是一樣的 id


          if ( array_num == -1 ) { // 沒有陣列

            return my_Glo_Or_Loc_Id[which].my_Variable[j].m_all_type_value ;
          } // if()
          else { // 有陣列 
            return my_Glo_Or_Loc_Id[which].my_Variable[j].my_Array[array_num].m_all_type_value ;
          } // else()



        } // if()

      } // for()

    } // for()

    if ( !id.equals( "Done" ) && !id.equals( "cin" ) && !id.equals( "cout" ) ) {
      // Print( "id : \"" + id + "\" Get_Id_Num_Error --> No Such Id" ) ;
    } // if()

    return "Get_Id_Num_Error --> No Such Id Num" ;
        
  } // Get_Id_Num()
    
    // ======== 拿 Id 的值 ========
    
    // ============= Start =============
    
    private boolean User_Input() {
        
    if ( Get_Now_Token_Tpye() == VOID
         || Get_Now_Token_Tpye() == INT
         || Get_Now_Token_Tpye() == FLOAT
         || Get_Now_Token_Tpye() == CHAR
         || Get_Now_Token_Tpye() == STRING
         || Get_Now_Token_Tpye() == BOOL ) { 
      // 先不要拿
      if ( Definition() ) { // 如果是 Definition()
        System.out.print( "> " ) ;
        Print_Definition() ;
        return true ;
      } // if()
      else { // 不是 Definition()
        Print_Error( Get_Error_Token(), Get_Error_Type(), Get_Error_Token_No_Id() ) ;
        return false ;
      } // else()
    } // if()
    else if ( Statement() ) { // 如果是 Statement()

      if ( Get_cout_or_shift() != COUT && Get_Set_While() == -1 ) { 
        // 不是 'cout' 再印
        // 而且 不是 while

        System.out.print( "> " ) ;
      } // if()


      if ( Return_ListAllVariables() ) { // 印出所有全域變數 // 由小到大
        Print_ListAllVariables() ;
      } // if()
      else if ( Return_ListAllFunctions() ) { // 印出所有 Function 名稱 // 由小到大
        Print_ListAllFunctions() ;
      } // else if()
      else if ( Return_ListVariable() ) { // 印出一個 已定義的變數 以及型別
        Print_ListVariable() ;
      } // else if()
      else if ( Return_ListFunction() ) { // 印出一個 已定義的 Function
        Print_ListFunction() ;
      } // else if()

      if ( !Return_Done() && Get_Set_While() == -1 ) { 
        // 如果不是 Done();
        // 而且不是 while
        Print_Statement() ;

      } // if()
      else if ( Get_Set_While() == -2 ) {
        // 只有再出 while 時
        // 值才有可能是 -2
        Print_Statement() ;
        // 再把它設回正常值 -1
        Direct_Set_Set_While( -1 ) ;
        // while 結束
        // 把設定改回去
        Set_Ever_Print_BT( false ) ;
      } // else if()

      return true ;
    } // else if()
    else { // 都不是
      Print_Error( Get_Error_Token(), Get_Error_Type(), Get_Error_Token_No_Id() ) ;
      return false ;
    } // else()
        
  } // User_Input()
    
    private boolean Definition() {
        
    String save_id = "" ; // 定義的 id
    int type = -9487 ;
    String save_function = "" ; // 存 Function

    if ( Get_Now_Token_Tpye() == VOID ) { // 如果是 void
      type = VOID ; // 取得型別
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
        save_id = Return_Token() ; // 暫存此 id
        Get_Token() ;
        if ( Get_Now_Token_Tpye() == LP ) { // 如果下一個是 '(' // 是 Function
          // 不用空格 // ex . void A()
          Set_My_Now_Func_String( save_id, 0 ) ; // 存當下的 Function
        } // if()
        else { // 不是 Function
          // 就要空格 // ex void a ;
          Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
        } // else()

        if ( Function_definition_without_ID( save_id, type ) ) { // 如果是 Function_definition_without_ID()
          Set_Is_Function( false ) ;
          return true ;
        } // if()
        else { // 不是 Function_definition_without_ID()
          return false ;
        } // else()

      } // if()
      else { // 不是 id

        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Definition() 1 =====") ;
        return false ;
      } // else()

    } // if()
    else if ( Type_specifier() ) { // 如果是 Type_specifier()
      type = Get_Id_Type() ; // 取得型別
      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
        save_id = Return_Token() ; // 暫存此 id
        Get_Token() ;
        if ( Get_Now_Token_Tpye() == LP ) { // 如果下一個是 '(' // 是 Function
          // 不用空格 // ex . int A()
          Set_My_Now_Func_String( save_id, 0 ) ; // 存當下的 Function
        } // if()
        else { // 不是 Function
            // 就要空格 // ex int a ;

          if ( Get_Now_Token_Tpye() == COMMA 
               || Get_Now_Token_Tpye() == LMP ) { // 如果下一個 Token 是 ','
            // 或是 '['
            Set_My_Now_Func_String( save_id, 0 ) ; // 就不要空格
          } // if()
          else { // 不是 ',' 也不是 '['
            // 就要空格
            Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
          } // else()

        } // else()

        if ( Function_definition_or_declarators( save_id, type ) ) { 
          // 如果 Function_definition_or_declarators()
          return true ;
        } // if()
        else { // 不是 Function_definition_or_declarators()
          return false ;
        } // else()

      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Definition() 2 =====") ;
        return false ;
      } // else()

    } // else if()
    else { // 都不是
      // ============= 不需要印錯誤 !? ==============================
      // ============= 因為可能是 statement =========================
      return false ;
    } // else()
        
        
  } // Definition() 
    
    private boolean Type_specifier() {
        
    if ( Get_Now_Token_Tpye() == INT ) { // 如果是 int
      Set_Id_Type( Return_Token_Type() ) ;
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      return true ;
    } // if()
    else if ( Get_Now_Token_Tpye() == CHAR ) { // 如果是 char
      Set_Id_Type( Return_Token_Type() ) ;
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == FLOAT ) { // 如果是 double
      Set_Id_Type( Return_Token_Type() ) ;
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == STRING ) { // 如果是 string
      Set_Id_Type( Return_Token_Type() ) ;
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == BOOL ) { // 如果是 bool
      Set_Id_Type( Return_Token_Type() ) ;
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      return true ;
    } // else if()
    else { // 都不是
      // =============================== 不印錯誤 !? ====================================
      Set_Id_Type( -9487 ) ;
      return false ;
    } // else()

  } // Type_specifier()
    
    private boolean Function_definition_or_declarators( String id, int type ) {
        
    if ( Get_Now_Token_Tpye() == LMP
         || Get_Now_Token_Tpye() == COMMA
         || Get_Now_Token_Tpye() == SC ) { // 如果是 '[' 或 ',' 或 ';'
      // 先不要拿
      if ( Rest_of_declarators( id, type ) ) { // 如果是 Rest_of_declarators()

        return true ;
      } // if()
      else { // 不是 Rest_of_declarators()
        return false ;
      } // else()
    } // if()
    else if ( Get_Now_Token_Tpye() == LP ) {
      if ( Function_definition_without_ID( id, type ) ) { // 如果是 Function_definition_without_ID()

        return true ;
      } // else if()
      else {
        return false ;
      } // else()
    } // else if()
    else { // 都不是

      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()

      // System.out.println("===== Function_definition_or_declarators() 1 =====") ;

      return false ;
    } // else()
        
        
  } // Function_definition_or_declarators()
    
    private boolean Rest_of_declarators( String id, int type ) {
     
    Variable[] save_Variable = new Variable[50] ; // 存 在這裡定義的 Id
    int save_Variable_num = 0 ;
    // 初始化 
    for ( int j = 0 ; j < 50 ; j++ ) {
      Variable ini = new Variable() ;
      save_Variable[j] = ini ;
    } // for()
    
    save_Variable[save_Variable_num].m_var = id ;
    save_Variable_num++ ;
    String array_num = "" ; // [num] // 以字串存
    // 以下為可要可不要
    if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
        array_num = Return_Token() ;
        if ( Return_Is_String() ) { // 如果是字串
          Set_My_Now_Func_String( "\"" + Return_Token() + "\"", 1 ) ; // 存當下的 Function
        } // if()
        else { // 不是字串
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        } // else()

        Get_Token() ;
        if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          if ( Same_Id( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
            // 以下兩個都需要更新所有的狀態 ( type... )
            // 所以如果是 Function 只要印最外面的 Function name
            // 不用管理面變數名稱是怎樣
            // 而進 Rest_of_declarators 就不可能是要印 Function 變數
            // ( 不能 void A(), B()..... )
            // 故 最後一項必為 false
            // 而如果不是 Function 才要進
            // 因為如果是 Function 就只要印 Funciton
            if ( !Get_Is_Function() ) {
              Save_My_Now_Id( id, true, type, false ) ;
            } // if()

            if ( Same_Id_In_Same_Compound( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) {
              // 如果是同一個 {} 內 再定義
              // 那就真的要重新定義
              // 重新定義
              Set_New_Definition( id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;
            } // if()
            else {
              // 不是同一個 {} 內重新定義
              // 表示是此 {} 專屬的定義
              // 存所以的變數 // 沒有 array
              Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
              // 變數++
              Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
            } // else()
            // 不需要變數++ ( 因為是重新定義 )
          } // if()
          else { // 新定義
            // 存印定義
            // 因為是要印定義
            // 所以如果是 Function 只要印最外面的 Function name
            // 不用管理面變數名稱是怎樣
            // 而進 Rest_of_declarators 就不可能是要印 Function 變數
            // ( 不能 void A(), B()..... )
            // 故 最後一項必為 false
            if ( !Get_Is_Function() ) {
              Save_My_Now_Id( id, false, type, false ) ;
            } // if()

            // 存所有的變數
            Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), array_num ) ;
            // 變數++
            Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
          } // else()

          Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
          Get_Token() ;
          if ( Get_Now_Token_Tpye() != COMMA ) { // 如果下一個 Token 不是 ','
            Set_My_Now_Func_String( "", 1 ) ; // 就要空格
          } // if()
        } // if()
        else { // 不是 ']'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Rest_of_declarators() 1 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 Constant
        return false ;
      } // else()
    } // if()
    else { // 沒有 array
      if ( Same_Id( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
        // 以下兩個都需要更新所有的狀態 ( type... )
        // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
        if ( !Get_Is_Function() ) {
          Save_My_Now_Id( id, true, type, false ) ;
        } // if()

        if ( Same_Id_In_Same_Compound( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) {
          // 如果是同一個 {} 內 再定義
          // 那就真的要重新定義
          // 重新定義
          Set_New_Definition( id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;
        } // if()
        else {
          // 不是同一個 {} 內重新定義
          // 表示是此 {} 專屬的定義
          // 存所以的變數 // 沒有 array
          Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
          // 變數++
          Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
        } // else()
        // 不需要變數++ ( 因為是重新定義 )
      } // if()
      else { // 新定義
        // 存印定義
        if ( !Get_Is_Function() ) {
          Save_My_Now_Id( id, false, type, false ) ;
        } // if()

        // 存所以的變數 // 沒有 array
        Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
        // 變數++
        Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
      } // else()
    } // else()
    // 以上為可要可不要
    boolean breakk = false ;
    String save_id = "" ;
    type = Get_Id_Type() ; // 取得型別
    for ( ; !breakk ; ) {
      if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
          save_id = Return_Token() ;
          save_Variable[save_Variable_num].m_var = save_id ;
          save_Variable_num++ ; 
          Get_Token() ;
          if ( Get_Now_Token_Tpye() == COMMA 
               || Get_Now_Token_Tpye() == LMP ) { // 如果下一個 Token 是 ','
            // 或是 '['
            Set_My_Now_Func_String( save_id, 0 ) ; // 就不要空格
          } // if()
          else { // 不是 ',' 也不是 '['
            // 就要空格
            Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
          } // else()

          // 以下為可要可不要
          if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
              array_num = Return_Token() ;
              if ( Return_Is_String() ) { // 如果是字串
                Set_My_Now_Func_String( "\"" + Return_Token() + "\"", 1 ) ; // 存當下的 Function
              } // if()
              else { // 不是字串
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
              } // else()

              Get_Token() ;
              if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
                if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
                  // 以下兩個都需要更新所有的狀態 ( type... )
                  // 所以如果是 Function 只要印最外面的 Function name
                  // 不用管理面變數名稱是怎樣
                  // 而進 Rest_of_declarators 就不可能是要印 Function 變數
                  // ( 不能 void A(), B()..... )
                  // 故 最後一項必為 false
                  // 而如果不是 Function 才要進
                  // 因為如果是 Function 就只要印 Funciton
                  if ( !Get_Is_Function() ) {
                    Save_My_Now_Id( save_id, true, type, false ) ;
                  } // if()
                  
                  if ( Same_Id_In_Same_Compound( save_id, Get_My_Glo_Or_Loc_Id_Length(), 
                                                 Get_Is_Function() ) ) {
                    // 如果是同一個 {} 內 再定義
                    // 那就真的要重新定義
                    // 重新定義
                    Set_New_Definition( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;
                  } // if()
                  else {
                    // 不是同一個 {} 內重新定義
                    // 表示是此 {} 專屬的定義
                    // 存所以的變數 // 沒有 array
                    Set_New_ID( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
                    // 變數++
                    Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
                  } // else()
                  // 不需要變數++ ( 因為是重新定義 )
                } // if()
                else { // 新定義
                  // 存印定義
                  // 因為是要印定義
                  // 所以如果是 Function 只要印最外面的 Function name
                  // 不用管理面變數名稱是怎樣
                  // 而進 Rest_of_declarators 就不可能是要印 Function 變數
                  // ( 不能 void A(), B()..... )
                  // 故 最後一項必為 false
                  if ( !Get_Is_Function() ) {
                    Save_My_Now_Id( save_id, false, type, false ) ;
                  } // if()
                  // 存所有的變數
                  Set_New_ID( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), array_num ) ;
                  // 變數++
                  Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
                } // else()

                Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
                Get_Token() ;
                if ( Get_Now_Token_Tpye() != COMMA ) { // 如果下一個 Token 不是 ','
                  Set_My_Now_Func_String( "", 1 ) ; // 就要空格
                } // if()
              } // if()
              else { // 不是 ']'
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                  // 就設定錯誤
                  Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                  // 還原
                  Undo_Variable( save_Variable, save_Variable_num ) ;
                } // if()
                // System.out.println("===== Rest_of_declarators() 2 =====") ;
                return false ;
              } // else()
            } // if()
            else { // 不是 Constant
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                // 還原
                Undo_Variable( save_Variable, save_Variable_num ) ;
              } // if()
              // System.out.println("===== Rest_of_declarators() 3 =====") ;
              return false ;
            } // else()
          } // if()
          else { // 沒有 array
            if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
              // 以下兩個都需要更新所有的狀態 ( type... )
              // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
              if ( !Get_Is_Function() ) {
                Save_My_Now_Id( save_id, true, type, false ) ;
              } // if()
              
              if ( Same_Id_In_Same_Compound( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) {
                // 如果是同一個 {} 內 再定義
                // 那就真的要重新定義
                // 重新定義
                Set_New_Definition( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;
              } // if()
              else {
                // 不是同一個 {} 內重新定義
                // 表示是此 {} 專屬的定義
                // 存所以的變數 // 沒有 array
                Set_New_ID( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
                // 變數++
                Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
              } // else()
              // 不需要變數++ ( 因為是重新定義 )
            } // if()
            else { // 新定義
              // 存印定義
              if ( !Get_Is_Function() ) {
                Save_My_Now_Id( save_id, false, type, false ) ;
              } // if()
              // 存所以的變數 // 沒有 array
              Set_New_ID( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
              // 變數++
              Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
            } // else()
          } // else()
        } // if()
        else { // 不是 id
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            // 還原
            Undo_Variable( save_Variable, save_Variable_num ) ;
          } // if()
          // System.out.println("===== Rest_of_declarators() 4 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 ','
        breakk = true ;
      } // else()
    } // for()

    if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
      Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
      // 存當下的 Function ( 換行 )
      // 以及 要空幾格
      Get_Token() ;
      Set_Check_Next_Token_RBP( true ) ;
      Set_My_Now_Func_String( "\n", Get_Compound_Enter() - 2 ) ; // 先減 2
      // 如果是 declaration 或 statement 再加 2
      return true ;
    } // if()
    else { // 不是 ';'
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        // 還原
        Undo_Variable( save_Variable, save_Variable_num ) ;
      } // if()
      // System.out.println("===== Rest_of_declarators() 6 =====") ;
      return false ;
    } // else()
        
  } // Rest_of_declarators()
    
    private boolean Function_definition_without_ID( String id, int type ) {
        
    Set_Is_Function( true ) ; // 是 Function 變數
    if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
      Get_Token() ;
      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == VOID ) { // 如果是 void
        // 那 '(' 後面就必須有空格
        Set_My_Now_Func_String( "", 1 ) ; // 空 1 格
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
      } // if()
      else if ( Get_Now_Token_Tpye() == INT || Get_Now_Token_Tpye() == CHAR
                || Get_Now_Token_Tpye() == FLOAT || Get_Now_Token_Tpye() == STRING
                || Get_Now_Token_Tpye() == BOOL ) {
        if ( Formal_parameter_list() ) { // 如果是 Formal_parameter_list()
          // 不做事
        } // if()
        else { // 不是 Formal_parameter_list()
          return false ;
        } // else()
      } // else if()
      // 以上為可要可不要

      if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Compound_statement() ) { // 如果是 Compound_statement()
          if ( Same_Id( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
            // 以下兩個都需要更新所有的狀態 ( type... )
            // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
            Save_My_Now_Id( id, true, type, Get_Is_Function() ) ;
            // 重新定義
            Set_New_Definition( id, Get_My_Glo_Or_Loc_Id_Length(), type, "" ) ;
            // 不需要變數++ ( 因為是重新定義 )
          } // if()
          else { // 新定義
            // 存印定義
            Save_My_Now_Id( id, false, type, Get_Is_Function() ) ;
            // 存所以的變數
            Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
            // 變數++
            Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
          } // else()

          return true ;
        } // if()
        else { // 不是 Compound_statement()
          return false ;
        } // else()
      } // if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Function_definition_without_ID() 1 =====") ;
        return false ;
      } // else()
    } // if()
    else { // 不是 '('
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if() 
      // System.out.println("===== Function_definition_without_ID() 2 =====") ;
      return false ;
    } // else()
        
  } // Function_definition_without_ID()
    
    private boolean Formal_parameter_list() {
        
    String array_num = "" ; // [num] // 以字串存
    if ( Get_Now_Token_Tpye() != RP ) { // 如果不是 ')'
      Set_My_Now_Func_String( "", 1 ) ; // 空 1 格
    } // if()

    String save_id = "" ; // 定義的 id
    int type = -9487 ;
    if ( Type_specifier() ) { // 如果是 Type_specifier()
      type = Get_Id_Type() ; // 取得型別
      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
      } // if()
      // 以上為可要可不要
      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
        save_id = Return_Token() ; // 暫存此 id
        Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Get_Now_Token_Tpye() != COMMA 
             && Get_Now_Token_Tpye() != LMP ) { // 如果下一個 Token 不是 ','
          // 而且不是 '['
          Set_My_Now_Func_String( "", 1 ) ; // 就要空格
        } // if()
        // 以下為可要可不要
        if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          Get_Token() ;
          if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
            array_num = Return_Token() ;
            if ( Return_Is_String() ) { // 如果是字串
              Set_My_Now_Func_String( "\"" + Return_Token() + "\"", 1 ) ; // 存當下的 Function
            } // if()
            else { // 不是字串
              Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            } // else()
            
            Get_Token() ;
            if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
              Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
              if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
                // 以下兩個都需要更新所有的狀態 ( type... )
                // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
                // Save_My_Now_Id( save_id, true, type, Get_Is_Function() ) ;
                // 重新定義
                Set_New_Definition( save_id, 1, type, array_num ) ;
                // 不需要變數++ ( 因為是重新定義 )
              } // if()
              else { // 新定義
                // 存印定義
                // Save_My_Now_Id( save_id, false, type, Get_Is_Function() ) ;
                // 存所以的變數
                Set_New_ID( save_id, 1, type, Get_Is_Function(), array_num ) ;
                // 變數++
                Func_Or_Var_Num_Add( 1, Get_Is_Function() ) ;
              } // else()

              Get_Token() ;
              if ( Get_Now_Token_Tpye() != COMMA ) { // 如果下一個 Token 不是 ','
                Set_My_Now_Func_String( "", 1 ) ; // 就要空格
              } // if()
            } // if()
            else { // 不是 ']'
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
              } // if()
              // System.out.println("===== Formal_parameter_list() 1 =====") ;
              return false ;
            } // else()
          } // if()
          else { // 不是 Constant
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("===== Formal_parameter_list() 2 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 沒有 array
          if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
            // 以下兩個都需要更新所有的狀態 ( type... )
            // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
            // Save_My_Now_Id( save_id, true, type, Get_Is_Function() ) ;
            // 重新定義
            Set_New_Definition( save_id, 1, type, "" ) ;
            // 不需要變數++ ( 因為是重新定義 )
          } // if()
          else { // 新定義
            // 存印定義
            // Save_My_Now_Id( save_id, false, type, Get_Is_Function() ) ;
            // 存所以的變數
            Set_New_ID( save_id, 1, type, Get_Is_Function(), "" ) ;
            // 變數++
            Func_Or_Var_Num_Add( 1, Get_Is_Function() ) ;
          } // else()
        } // else()
        // 以上為可要可不要
      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Formal_parameter_list() 3 =====") ;
        return false ;
      } // else()
    } // if()

    boolean breakk = false ;
    for ( ; !breakk ; ) { // 執行 0 到 多次
      if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Type_specifier() ) { // 如果是 Type_specifier()
          type = Get_Id_Type() ; // 取得型別
          // 以下為可要可不要
          if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
          } // if()
          // 以上為可要可不要
          if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
            save_id = Return_Token() ; // 暫存此 id
            Get_Token() ;
            if ( Get_Now_Token_Tpye() == COMMA 
                 || Get_Now_Token_Tpye() == LMP ) { // 如果下一個 Token 是 ','
              // 或是 '['
              Set_My_Now_Func_String( save_id, 0 ) ; // 就不要空格
            } // if()
            else { // 不是 ',' 也不是 '['
              // 就要空格
              Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
            } // else()

            // 以下為可要可不要
            if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
              Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
              Get_Token() ;
              if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
                array_num = Return_Token() ;
                if ( Return_Is_String() ) { // 如果是字串
                  Set_My_Now_Func_String( "\"" + Return_Token() + "\"", 1 ) ; // 存當下的 Function
                } // if()
                else { // 不是字串
                  Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                } // else()

                Get_Token() ;
                if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
                  Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
                  if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { 
                    // 如果是 出現過的 id
                    // 以下兩個都需要更新所有的狀態 ( type... )
                    // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
                    // Save_My_Now_Id( save_id, true, type, Get_Is_Function() ) ;
                    // 重新定義
                    Set_New_Definition( save_id, 1, type, array_num ) ;
                    // 不需要變數++ ( 因為是重新定義 )
                  } // if()
                  else { // 新定義
                    // 存印定義
                    // Save_My_Now_Id( save_id, false, type, Get_Is_Function() ) ;
                    // 存所以的變數
                    Set_New_ID( save_id, 1, type, Get_Is_Function(), array_num ) ;
                    // 變數++
                    Func_Or_Var_Num_Add( 1, Get_Is_Function() ) ;
                  } // else()

                  Get_Token() ;
                  if ( Get_Now_Token_Tpye() != COMMA ) { // 如果下一個 Token 不是 ','
                    Set_My_Now_Func_String( "", 1 ) ; // 就要空格
                  } // if()
                } // if()
                else { // 不是 ']'
                  if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                  } // if()
                  // System.out.println("===== Formal_parameter_list() 4 =====") ;
                  return false ;
                } // else()
              } // if()
              else { // 不是 Constant
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                  // 就設定錯誤
                  Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                } // if()
                // System.out.println("===== Formal_parameter_list() 5 =====") ;
                return false ;
              } // else()
            } // if()
            else {
              if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
                // 以下兩個都需要更新所有的狀態 ( type... )
                // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
                // Save_My_Now_Id( save_id, true, type, Get_Is_Function() ) ;
                // 重新定義
                Set_New_Definition( save_id, 1, type, "" ) ;
                // 不需要變數++ ( 因為是重新定義 )
              } // if()
              else { // 新定義
                // 存印定義
                // Save_My_Now_Id( save_id, false, type, Get_Is_Function() ) ;
                // 存所以的變數
                Set_New_ID( save_id, 1, type, Get_Is_Function(), "" ) ;
                // 變數++
                Func_Or_Var_Num_Add( 1, Get_Is_Function() ) ;
              } // else()
            } // else()
            // 以上為可要可不要
          } // if()
          else { // 不是 id
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("===== Formal_parameter_list() 6 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 不是 Type_specifier()
          // 因為在 Type_specifier() 沒有 print error
          // 所以這裡要 print error 
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Formal_parameter_list() 7 =====") ;
          return false ;
        } // else()
      } // if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 不讀掉 ')'
        // 表示已結束
        breakk = true ;
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Formal_parameter_list() 8 =====") ;
        return false ;
      } // else()
    } // for()

    if ( breakk ) {
      return true ;
    } // if()
    else {
      return false ;
    } // else()
        
  } // Formal_parameter_list()
    
    private boolean Compound_statement() {
        
    if ( Get_Now_Token_Tpye() == LBP ) { // 如果是 '{'
      Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
      Set_My_Now_Func_String( "\n", 0 ) ; // 存 換行
      Get_Token() ;
      Add_Compound_Enter( 2 ) ; // 空 2 格
      // 看要空幾個空格
      if ( Get_Now_Token_Tpye() == RBP ) { // 如果直接是'}'
        // 就不用多空 2 格
        Set_My_Now_Func_String( "", Get_Compound_Enter() - 2 ) ; // 存當下的 Function
      } // if()
      else { // 裡面還有其他 declaration 或 statement
        Set_My_Now_Func_String( "", Get_Compound_Enter() ) ; // 存當下的 Function
      } // else()

      Set_My_Glo_Or_Loc_Id_Length( 1 ) ; // 進入一個 {} 了
      Set_Inside_The_LBP( true ) ; // 是在 '{' 內 // 所以不要印 定義
      boolean breakk = false ;

      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == RBP ) { // 如果是 '}'
          // 先不要拿
          breakk = true ;
        } // if()
        else if ( Declaration() ) { // 如果是 Declaration()
        } // else if()
        else if ( Statement() ) { // 如果是 Statement()
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Compound_statement() 1 =====") ;
          // 竟然沒有 '}'
          // 表示有 '{' 沒 '}'
          // 所以要扣掉
          Set_My_Glo_Or_Loc_Id_Length( -1 ) ;
          return false ;
        } // else()
      } // for()

      if ( Get_Now_Token_Tpye() == RBP ) { // 如果是 '}'
        Add_Compound_Enter( -2 ) ; // 少空 2 格
        String save_token = "" ;
        save_token = Return_Token() ;
        Get_Token() ;
        Set_My_Now_Func_String( save_token, 0 ) ; // 存當下的 Function
        Set_Check_Next_Token_RBP( true ) ;
        Set_My_Now_Func_String( "\n", Get_Compound_Enter() - 2 ) ; // 先減 2
        // 把此 Function 初始化
        Clear_Function_Variable( Get_My_Glo_Or_Loc_Id_Length() ) ; 
        Set_My_Glo_Or_Loc_Id_Length( -1 ) ; // 離開一個 {}
        return true ;
      } // if()
      else { // 不是 '}'
        // 照理不可能進這
        // 如果要進這 
        // 那應該在上面的 for 就會進 else
        // 而 return false
        // Print( "Class_Grammar --> Function_Compound_statement !!!" ) ;
        return false ;
      } // else()
    } // if()
    else { // 不是 '{'
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()

      // System.out.println("===== Compound_statement() 2 =====") ;
      return false ;
    } // else()
        
  } // Compound_statement()
    
    private boolean Declaration() {
        
    String save_id = "" ; // 定義的 id
    if ( Type_specifier() ) { // 如果是 Type_specifier()
      int type = Get_Id_Type() ; // 取得型別
      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
        save_id = Return_Token() ; // 暫存此 id
        Get_Token() ;
        if ( Get_Now_Token_Tpye() == COMMA 
             || Get_Now_Token_Tpye() == LMP ) { // 如果下一個 Token 是 ','
          // 或是 '['
          Set_My_Now_Func_String( save_id, 0 ) ; // 就不要空格
        } // if()
        else { // 不是 ',' 也不是 '['
          // 就要空格
          Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
        } // else()

        if ( Rest_of_declarators( save_id, type ) ) { // 如果 Rest_of_declarators()
          return true ;
        } // if()
        else { // 不是 Rest_of_declarators()
          return false ;
        } // else()
      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Declaration() 1 =====") ;
        return false ;
      } // else()

    } // if()
    else { // 不是 Type_specifier()
      return false ;
    } // else()
        
  } // Declaration()
    
    private boolean Statement() {
        
    if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
      Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
      Get_Token() ;
      Set_Check_Next_Token_RBP( true ) ;
      Set_My_Now_Func_String( "\n", Get_Compound_Enter() - 2 ) ; // 先減 2
      // 如果是 declaration 或 statement 再加 2
      return true ;
    } // if()
    else if ( Get_Now_Token_Tpye() == RETURN ) { // 如果是 return
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
        Set_Check_Next_Token_RBP( true ) ;
        Set_My_Now_Func_String( "\n", Get_Compound_Enter() - 2 ) ; // 先減 2
        // 如果是 declaration 或 statement 再加 2
        Get_Token() ;
        return true ;
      } // if()
      else if ( Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
          Set_Check_Next_Token_RBP( true ) ;
          Set_My_Now_Func_String( "\n", Get_Compound_Enter() - 2 ) ; // 先減 2
          // 如果是 declaration 或 statement 再加 2
          Get_Token() ;
          return true ;
        } // if()
        else { // 不是 ';'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Statement() 2 =====") ;
          return false ;
        } // else()
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Statement() 3 =====") ;
        return false ;
      } // else()
    } // else if()
    else if ( Get_Now_Token_Tpye() == IF ) { // 如果是 if
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Expression() ) { // 如果是 Expression()
          String expres = "" ; // 存回傳值
          boolean if_is_true = false ; // 判斷 if 是否成立
          expres = Get_Expression() ;
          if ( String_Is_Boolean( expres ) ) {
            // 如果它是布林
            if_is_true = Turn_String_To_Boolean( expres ) ;
          } // if()

          if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            // 如果 if 條件成立才進
            if ( if_is_true && Statement() ) { // 如果是 Statement()
              // 以下為可要可不要
              if ( Get_Now_Token_Tpye() == ELSE ) { // 如果是 else
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                // 因為 if 條件 "成立"
                // 所以一定 "不" 做 else
                if ( Fake_Statement() ) { // 如果是 Fake_Statement()
                  // 因為已經出來了
                  // 所以要 +1 才會進到 {} 裡面
                  Delete_Fake_Variable( Get_My_Glo_Or_Loc_Id_Length() + 1 ) ;
                  return true ;
                } // if()
                else { // 不是 Fake_Statement()
                  return false ;
                } // else()
              } // if()
              else { // 表示沒有 else
                return true ;
              } // else()
              // 以上為可要可不要
            } // if()
            // 如果 if 條件不成立
            else if ( !if_is_true && Fake_Statement() ) {
              // 因為已經出來了
              // 所以要 +1 才會進到 {} 裡面
              Delete_Fake_Variable( Get_My_Glo_Or_Loc_Id_Length() + 1 ) ;
              // 以下為可要可不要
              if ( Get_Now_Token_Tpye() == ELSE ) { // 如果是 else
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                // 因為 if 條件 "不" 成立
                // 所以一定 "要" 做 else
                if ( Statement() ) { // 如果是 Statement()
                  return true ;
                } // if()
                else { // 不是 Statement()
                  return false ;
                } // else()
              } // if()
              else { // 表示沒有 else
                return true ;
              } // else()
            } // else if()
            else { // 不是 Statement()
              return false ;
            } // else()
          } // if()
          else { // 不是 ')'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("===== Statement() 5 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 不是 Expression()
          return false ;
        } // else()
      } // if()
      else { // 不是 '('
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Statement() 6 =====") ;
        return false ;
      } // else()
    } // else if()
    else if ( Get_Now_Token_Tpye() == WHILE ) { // 如果是 while
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Set_Set_While( 1 ) ;
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Expression() ) { // 如果是 Expression()
          String expres = "" ; // 存回傳值
          boolean if_is_true = false ; // 判斷 if 是否成立
          expres = Get_Expression() ;
          if ( String_Is_Boolean( expres ) ) {
            // 如果它是布林
            if_is_true = Turn_String_To_Boolean( expres ) ;
          } // if()

          if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            if ( !if_is_true ) {
              // 如果條件式不成立
              if ( Fake_Statement() ) {
                // 如果條件是 "false"
                // 條件不成立
                // 即不會進 while
                // 所以不用紀錄
                // 直接再把值設成 -2
                // 只有在這裡才有可能設 -2
                Direct_Set_Set_While( -2 ) ;
                Clean_While_String() ;
                // 因為已經出來了
                // 所以要 +1 才會進到 {} 裡面
                Delete_Fake_Variable( Get_My_Glo_Or_Loc_Id_Length() + 1 ) ;
                if ( !Get_Ever_Print_BT() && Get_Print_Cout() ) {
                  // 如果沒印過 "> "
                  System.out.print( "> " ) ;
                  Set_Ever_Print_BT( true ) ; // 設回去
                } // if()

                return true ;
              } // if()
              else {
                // 不是 Fake_Statement()
                return false ;
              } // else()
            } // if()
            else if ( if_is_true ) { // 如果是 Statement()
              // 如果條件是 "true"
              // 條件成立
              if ( Statement() ) { // 如果是 Statement()
                Add_While_Token_To_My_Token() ;
                Clean_While_String() ;
                return true ;
              } // if()
              else {
                return false ;
              } // else()
            } // else if()
            else { // 不是 Statement()
              return false ;
            } // else()
          } // if()
          else { // 不是 ')'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("===== Statement() 7 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 不是 Expression()
          return false ;
        } // else()
      } // if()
      else { // 不是 '('
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Statement() 8 =====") ;
        return false ;
      } // else()
    } // else if()
    else if ( Get_Now_Token_Tpye() == DO ) { // 如果是 do
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      if ( Statement() ) { // 如果是 Statement()
        if ( Get_Now_Token_Tpye() == WHILE ) { // 如果是 while
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          Get_Token() ;
          if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            if ( Expression() ) { // 如果是 Expression()
              if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
                  Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
                  Set_Check_Next_Token_RBP( true ) ;
                  Set_My_Now_Func_String( "\n", Get_Compound_Enter() - 2 ) ; // 先減 2
                  // 如果是 declaration 或 statement 再加 2
                  Get_Token() ;
                  return true ;
                } // if()
                else { // 不是 ';'
                  if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                  } // if()
                  // System.out.println("===== Statement() 9 =====") ;
                  return false ;
                } // else()
              } // if()
              else { // 不是 ')'
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                  // 就設定錯誤
                  Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                } // if()
                // System.out.println("===== Statement() 10 =====") ;
                return false ;
              } // else()
            } // if()
            else { // 不是 Expression()
              return false ;
            } // else()
          } // if()
          else { // 不是 '('
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("====== Statement() 11 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 不是 while
          return false ;
        } // else()
      } // if()
      else { // 不是 Statement()
        return false ;
      } // else()
    } // else if()
    else if ( Get_Now_Token_Tpye() == LBP ) { // 如果是 '{'
      // 就有可能是 Compound_statement()
      // 先不讀掉 '{'
      if ( Compound_statement() ) { // 如果是 Compound_statement()
        return true ;
      } // if()
      else { // 不是 Compound_statement()
        return false ;
      } // else()
    } // else if()
    else if ( Get_Now_Token_Tpye() == ID 
              || Get_Now_Token_Tpye() == PP
              || Get_Now_Token_Tpye() == MM
              || Get_Now_Token_Tpye() == CONSTANT
              || Get_Now_Token_Tpye() == LP
              || Get_Now_Token_Tpye() == ADD
              || Get_Now_Token_Tpye() == SUB
              || Get_Now_Token_Tpye() == NOT ) {
      if ( Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
          Get_Token() ;
          Set_Check_Next_Token_RBP( true ) ;
          Set_My_Now_Func_String( "\n", Get_Compound_Enter() - 2 ) ; // 先減 2
          // 如果是 declaration 或 statement 再加 2
          return true ;
        } // if()
        else { // 不是 ';'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Statement() 12 =====") ;
          return false ;
        } // else()
      } // if()
      else {
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()
      // System.out.println("===== Statement() 13 =====") ;
      return false ;
    } // else()
        
  } // Statement()
    
    private boolean Expression() {
        
    if ( Basic_expression() ) { // 如果是 Basic_expression()
      Set_Expression( Get_Basic_expression() ) ;
      for ( ; ; ) {
        if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          String save_token = "" ;
          save_token = Return_Token() ;

          Get_Token() ;

          if ( Get_Now_Token_Tpye() == LP ) { // 如果下一個 Token 是 '('
            Set_My_Now_Func_String( save_token, 0 ) ; // 存當下的 Function
          } // if()
          else { // 不是 ')'
            // 就要空格
            Set_My_Now_Func_String( save_token, 1 ) ; // 存當下的 Function
          } // else()

          if ( Basic_expression() ) { // 如果是 Basic_expression()
            Set_Expression( Get_Basic_expression() ) ;
          } // if()
          else { // 不是 Basic_expression()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Expression() 1 =====") ;
          return false ;
        } // else()
      } // for()

    } // if()
    else { // 不是 Basic_expression()
      return false ;
    } // else()
        
        
  } // Expression()
    
    private boolean Basic_expression() {
        
    String save_id = "" ;
    boolean is_cout = false ; // 是不是 cout
    if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
      // 判斷有沒有遇到特殊指令
      Set_Which_Done_List_Var_Func( Return_Token_Is_Done(), Return_Token_Is_ListAllVariables(),
                                     Return_Token_Is_ListAllFunctions(), Return_Token_Is_ListVariable(),
                                     Return_Token_Is_ListFunction() ) ;
      save_id = Return_Token() ; // 暫存此 id
      if ( Return_Id_Is_Float( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ) {
        // 如果此 Id 是浮點數
        Set_Is_Float( true ) ;
      } // if()
      
      if ( save_id.equals( "cout" ) ) { // 如果是 cout
        is_cout = true ;
        Set_cout_or_shift( COUT ) ;
        Set_ever_cout( true ) ;
      } // if()

      Get_Token() ;
      if ( Return_Done_Num() != 1 
           && !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
        // 且不是 Done();
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( save_id, ID, true ) ;
        } // if()
        // System.out.println("===== Basic_expression() 1 =====") ;
        return false ;
      } // if()

      if ( Get_Now_Token_Tpye() == PP
           || Get_Now_Token_Tpye() == MM
           || Get_Now_Token_Tpye() == LP
           || Get_Now_Token_Tpye() == LMP ) { // 如果下一個 Token 是 '++'
        // 或是 '--' // 或 '('
        Set_My_Now_Func_String( save_id, 0 ) ; // 就不要空格
      } // if()
      else { // 不是 '++' 也不是 '--' // 也不是 '('
        // 就要空格
        Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
      } // else()

      if ( Rest_of_Identifier_started_basic_exp( save_id ) ) { // 如果是 Rest_of_Identifier_started_basic_exp()
        String roisbe = "" ;
        roisbe = Get_Rest_of_Identifier_started_basic_exp() ;
        Set_Basic_expression( Get_Rest_of_Identifier_started_basic_exp() ) ;
        return true ;
      } // if()
      else { // 不是 Rest_of_Identifier_started_basic_exp()
        return false ;
      } // else()

    } // if()
    else if ( Get_Now_Token_Tpye() == PP 
              || Get_Now_Token_Tpye() == MM ) { // 如果是 ++ 或 --
      Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
      int ope = Return_Token_Type() ; // 紀錄是 '++' 還是 '--'
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
        save_id = Return_Token() ; // 暫存此 id
        if ( Return_Id_Is_Float( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ) {
          // 如果此 Id 是浮點數
          Set_Is_Float( true ) ;
        } // if()

        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Return_Done_Num() != 1 
             && !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
            // 且不是 Done();
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( save_id, ID, true ) ;
          } // if()

          // System.out.println("===== Basic_expression() 2 =====") ;
          return false ;
        } // if()

        if ( Rest_of_PPMM_Identifier_started_basic_exp( save_id, ope ) ) { 
          Set_Basic_expression( Get_Rest_of_PPMM_Identifier_started_basic_exp() ) ;
          return true ;
        } // if()
        else { // 不是 Rest_of_PPMM_Identifier_started_basic_exp()
          return false ;
        } // else()
      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Basic_expression() 3 =====") ; 
        return false ;
      } // else()
    } // else if
    else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
      String constant_string = "" ;
      constant_string = Return_Token() ; // 拿此 constant
      if ( Return_Token_Is_Float() ) { // 如果是 浮點數
        Set_Is_Float( true ) ;
      } // if()

      boolean is_num = false ;
      if ( Return_Is_Num() ) { // 如果此 constant 是數字
        is_num = true ;
      } // if()

      if ( Return_ListVariable_Num() == 2 ) { // 如果剛剛已經有出現 ListVariable + "("
        Set_ListVariable_Id( Return_Token() ) ;
      } // if()
      else if ( Return_ListFunction_Num() == 2 ) { // 如果剛剛已經有出現 ListFunction + "("
        Set_ListFunction_Id( Return_Token() ) ;
      } // else if()

      if ( Return_Is_String() ) { // 如果是字串
        Set_My_Now_Func_String( "\"" + Return_Token() + "\"", 1 ) ; // 存當下的 Function
      } // if()
      else { // 不是字串
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      } // else()

      Get_Token() ;
      if ( Romce_and_romloe( is_num, constant_string, constant_string ) ) { // 如果是 Romce_and_romloe()
        Set_Basic_expression( Get_Romce_and_romloe() ) ;
        return true ;
      } // if()
      else { // 不是 Romce_and_romloe()
        return false ;
      } // else()
    } // else if()
    else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      boolean is_num = false ;
      if ( Expression() ) { // 如果是 Expression()
        if ( String_Is_Float( Get_Expression() ) || String_Is_Int( Get_Expression() ) ) {
          // 如果回傳值是 double 或是 int
          is_num = true ;
        } // if()

        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          Get_Token() ;
          if ( Romce_and_romloe( is_num, Get_Expression(), Get_Expression() ) ) { // 如果是 Romce_and_romloe()
            Set_Basic_expression( Get_Romce_and_romloe() ) ;
            return true ;
          } // if()
          else { // 不是 Romce_and_romloe()
            return false ;
          } // else()
        } // if()
        else { // 不是 ')'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // Print("===== Basic_expression() 4 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()
    } // else if()
    else if ( Sign() ) { // 如果是 sign()
      int not_sub_count = 1 ; // '!' 或 '-'
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ID ) { // 如果是 ID
          // 先不要拿
          breakk = true ;
        } // if()
        else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 CONSTANT
          // 先不要拿
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
          // 先不要拿
          breakk = true ;
        } // else if()
        else if ( Sign() ) { // 如果是 sign()
          not_sub_count++ ; 
        } // else if()
        else { // 不是 sign()
          breakk = true ;
        } // else()
      } // for()

      if ( Signed_unary_exp() ) { // 如果是 Signed_unary_exp()
        String new_string = "" ;
        new_string = Get_Signed_unary_exp() ;
        double this_Signed_unary_exp_num = -9487 ;
        boolean is_num = false ;
        if ( String_Is_Float( Get_Signed_unary_exp() ) || String_Is_Int( Get_Signed_unary_exp() ) ) { 
          // 如果是 double 或是 int
          new_string = "" ;
          this_Signed_unary_exp_num = Turn_String_To_Float( Get_Signed_unary_exp() ) ;
          is_num = true ;
          if ( Is_Even( not_sub_count ) ) { // 有偶數個 負
                // 是正的
          } // if()
          else { // 是負的
            this_Signed_unary_exp_num = this_Signed_unary_exp_num * -1 ;
            new_string = new_string + this_Signed_unary_exp_num ;
            Set_Signed_unary_exp( new_string ) ;
          } // else()
        } // if()
        else if ( String_Is_Boolean( Get_Signed_unary_exp() ) ) {
          if ( !Is_Even( not_sub_count ) ) { // 如果是奇數個 '!'
            if ( Get_Signed_unary_exp().equals( "true" ) ) {
              new_string = "false" ;
            } // if()
            else if ( Get_Signed_unary_exp().equals( "false" ) ) {
              new_string = "true" ;
            } // else if()
            else {
              // Print("===== Basic_expression() 5 =====") ;
            } // else()
            
            Set_Signed_unary_exp( new_string ) ;
          } // if()
          else { // 偶數個
            Set_Signed_unary_exp( new_string ) ;
          } // else()
        } // else if()
        
        if ( Romce_and_romloe( is_num, new_string, Get_Signed_unary_exp() ) ) { 
          // 如果是 Romce_and_romloe()
          Set_Basic_expression( Get_Romce_and_romloe() ) ;
          return true ;
        } // if()
        else { // 不是 Romce_and_romloe()
          return false ;
        } // else()
      } // if()
      else { // 不是 Signed_unary_exp()
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      // 不用印錯誤 // 因為 Sign() 已經印過了
      return false ;
    } // else()
        
  } // Basic_expression()
    
    private boolean Rest_of_Identifier_started_basic_exp( String id ) {
        
    double id_num = -9487 ;
    double num_to_Romce_and_romloe = -9487 ;
    double array_num = -9487 ; // array 的維度
    String direct_to_rom = "" ; // 直接給 romce_and_romloe 的
    boolean bool_to_Romce = true ; // 要傳給 Romce_and_romloe() 的是不是 num 
    // 'cout' 不是數值 
    if ( id.equals( "cout" ) || id.equals( "Done" ) ) { // 如果是 cout << .....
      id_num = 1 ;
      bool_to_Romce = false ;
    } // if()
    else {
      String id__num = "" ;
      id__num = Get_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), -1 ) ;
      direct_to_rom = id__num ;
      if ( String_Is_Int( id__num ) || String_Is_Float( id__num ) ) {
        id_num = Turn_String_To_Float( id__num ) ;
      } // if()
    } // else()

    // 以下為可要可不要
    if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      if ( Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          array_num = Turn_String_To_Float( Get_Expression() ) ; // 給 陣列的數值
          String id__num = "" ;
          int a = ( int ) array_num ;
          id__num = Get_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), a ) ;
          direct_to_rom = id__num ;
          Get_Token() ;
        } // if()
        else { // 不是 ']'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Rest_of_Identifier_started_basic_exp() 1 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()
    } // if()
    // 以上為可要可不要

    // 以下為可要可不要
    if ( Get_Now_Token_Tpye() == PP
         || Get_Now_Token_Tpye() == MM ) { // 如果是 ++ 或 --
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      int ope = Return_Token_Type() ; // 拿 '++' 或 '--'
      Get_Token() ;
      if ( array_num == -9487 ) { // 表示沒有 陣列
        id_num 
        = Turn_String_To_Float( Get_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), -1 ) ) ;
        array_num = -1 ;
      } // if()
      else { // 有陣列
        int a  = ( int ) array_num ;
        id_num 
        = Turn_String_To_Float( Get_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), a ) ) ;
      } // else()
      // 先取直 再 ++ --
      if ( ope == PP ) { // 是 '++'
        int a  = ( int ) array_num ;
        // 把此 Id + 1
        num_to_Romce_and_romloe = id_num ;
        id_num++ ;
        Save_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, a ) ;
      } // if()
      else if ( ope == MM ) { // 是 '--'
        int a  = ( int ) array_num ;
        // 把此 Id - 1
        num_to_Romce_and_romloe = id_num ;
        id_num-- ;
        Save_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, a ) ;
      } // else if()

      if ( Romce_and_romloe( bool_to_Romce, num_to_Romce_and_romloe + "", id ) ) { // 如果是 Romce_and_romloe()
        Set_Rest_of_Identifier_started_basic_exp( Get_Romce_and_romloe() ) ;
        return true ;
      } // if()
      else { // 不是 Romce_and_romloe()
        return false ;
      } // else()
    } // if()
    // ===================== 以下為 Function 呼叫 暫不理它 =====================
    // 以上為可要可不要
    else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      String save_token = "" ;
      save_token = Return_Token() ;
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == RP ) { // 如果下一個 Token 是 ')'
        Set_My_Now_Func_String( save_token, 0 ) ; // 存當下的 Function
      } // if()
      else { // 不是 ')'
        // 就要空格
        Set_My_Now_Func_String( save_token, 1 ) ; // 存當下的 Function
      } // else()

      Set_All( 1 ) ; // 可能是 特殊指令 ;
      // 以下為可要可不要
      if ( Actual_parameter_list() ) { // 如果是 Actual_parameter_list()
        // 如果進來了 // 肯定不是 ListAllVariables(); 或 ListAllFunctions(); 
        Set_ListAllVariables( -1 ) ;
        Set_ListAllFunctions( -1 ) ;
      } // if()
      // 以上為可要可不要
      if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        Set_All( 1 ) ; // 可能是 特殊指令 ;
        if ( Romce_and_romloe( true, "", "" ) ) { // 如果是 Romce_and_romloe()
          Set_All( 1 ) ; // 可能是 特殊指令 ;
          return true ;
        } // if()
        else { // 不是 Romce_and_romloe()
          return false ;
        } // else()
      } // if()
      else { // 不果是 ')'
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Rest_of_Identifier_started_basic_exp() 2 =====") ;
        return false ;
      } // else()
    } // else if()
    else if ( Assignment_operator( id ) ) { // 如果是 Assignment_operator()
      if ( Basic_expression() ) { // 如果是 Basic_expression()
        String may_id = "" ;
        may_id = Get_Basic_expression() ;
        String may_id_num = "" ;
        // 存值
        // 如果是 Id 就轉為數字存
        if ( array_num == -9487 ) { // 如果沒有陣列
          Save_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Basic_expression(), Get_Operator(), -1 ) ;
          may_id_num = Get_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), -1 ) ;
        } // if()
        else { // 有陣列
          int a  = ( int ) array_num ;
          Save_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Basic_expression(), Get_Operator(), a ) ;
          may_id_num = Get_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), a ) ;
        } // else()
        // 設定此 Function 的回傳值 
        Set_Rest_of_Identifier_started_basic_exp( may_id_num ) ;
        return true ;
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()
    } // else if()
    else if ( Romce_and_romloe( bool_to_Romce, direct_to_rom, id ) ) { // 如果是 Romce_and_romloe()
      Set_Rest_of_Identifier_started_basic_exp( Get_Romce_and_romloe() ) ;
      return true ;
    } // else if()
    else { // 都不是
      // 不用印錯誤 // Romce_and_romloe() 已經印過
      return false ;
    } // else()
        
  } // Rest_of_Identifier_started_basic_exp()
    
    private boolean Rest_of_PPMM_Identifier_started_basic_exp( String id, int ope ) {
        
    double num_to_Romce_and_romloe = -9487 ;
    boolean bool_to_Romce = true ; // 要傳給 Romce_and_romloe() 的是不是 num 
    // 'cout' 不是數值 
    if ( id.equals( "cout" ) || id.equals( "Done" ) ) { // 如果是 cout << .....
      bool_to_Romce = false ;
    } // if()
    // 以下為可要可不要
    if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      if ( Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          int a  = ( int ) Turn_String_To_Float( Get_Expression() ) ;
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          double id_num = -9487 ;
          // 先拿原本的值
          id_num 
          = Turn_String_To_Float( Get_Id_Num( id, 
                                                Get_My_Glo_Or_Loc_Id_Length(), 
                                                a ) ) ;
          if ( ope == PP ) { // 是 '++'
            int b = ( int ) Turn_String_To_Float( Get_Expression() ) ;
            // 把此 Id + 1
            id_num++ ;
            Save_Id_Num( id, 
                         Get_My_Glo_Or_Loc_Id_Length(), id_num + "", 
                         SMALL_EQU, 
                         b ) ;
            num_to_Romce_and_romloe = id_num ;
          } // if()
          else if ( ope == MM ) { // 是 '--'
            int b = ( int ) Turn_String_To_Float( Get_Expression() ) ;
            // 把此 Id - 1
            id_num-- ;
            Save_Id_Num( id, 
                         Get_My_Glo_Or_Loc_Id_Length(), 
                         id_num + "", 
                         SMALL_EQU, 
                         b ) ;
            num_to_Romce_and_romloe = id_num ;
          } // else if()
          else { // 都不是
            // Print( "Rest_of_PPMM_Identifier_started_basic_exp_Error --> PP_MM  Array" ) ;
          } // else()

          Get_Token() ;
        } // if()
        else { // 不是 ']'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Rest_of_PPMM_Identifier_started_basic_exp() 1 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()
    } // if()
    // 以上為可要可不要
    else { // 沒有陣列
      if ( ope == PP ) { // 是 '++'
        // 把此 Id + 1
        Save_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), 1 + "", PE, -1 ) ;
      } // if()
      else if ( ope == MM ) { // 是 '--'
        // 把此 Id - 1
        Save_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), -1 + "", ME, -1 ) ;
      } // else if()
      else { // 都不是
        // Print( "Rest_of_PPMM_Identifier_started_basic_exp_Error --> PP_MM" ) ;
      } // else()

      num_to_Romce_and_romloe
      = Turn_String_To_Float( Get_Id_Num( id, Get_My_Glo_Or_Loc_Id_Length(), -1 ) ) ;
    } // else()

    // 上面的 Id 陣列要丟給 Romce_and_romloe()
    if ( Romce_and_romloe( bool_to_Romce, num_to_Romce_and_romloe + "", id ) ) { // 如果是 Romce_and_romloe()
      Set_Rest_of_PPMM_Identifier_started_basic_exp( Get_Romce_and_romloe() ) ;
      return true ;
    } // if()
    else { // 不是 Romce_and_romloe()
      return false ;
    } // else()
        
  } // Rest_of_PPMM_Identifier_started_basic_exp()
    
    private boolean Sign() {
        
    if ( Get_Now_Token_Tpye() == ADD ) { // 如果是 '+'
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      Set_Sign( ADD ) ; // 設定 sign

      return true ;
    } // if()
    else if ( Get_Now_Token_Tpye() == SUB ) { // 如果是 '-'
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      Set_Sign( SUB ) ; // 設定 sign

      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == NOT ) { // 如果是 '!'
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      Set_Sign( NOT ) ; // 設定 sign

      return true ;
    } // else if()
    else { // 都不是
      if ( Return_Done_Num() == 0 ) { // 如果不是 Done();
        // 再 print error

        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Sign() 1 =====") ;

      } // if()

      return false ;
    } // else()
  } // Sign()
    
    private boolean Actual_parameter_list() {
        
    if ( Basic_expression() ) { // 如果是 Basic_expression()

      boolean breakk = false ;

      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          Get_Token() ;

          if ( Basic_expression() ) { // 如果是 Basic_expression()

          } // if()
          else { // 不是 Basic_expression()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Actual_parameter_list() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) { 
        return true ;
      } // if()
      else { // 不是 ')'
        return false ;
      } // else()

    } // if()
    else { // 不是 Basic_expression()
      return false ;
    } // else()
        
  } // Actual_parameter_list()
    
    private boolean Assignment_operator( String id ) {
        
    if ( Get_Now_Token_Tpye() == SMALL_EQU ) { // 如果是 '='
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      Set_Operator( SMALL_EQU ) ;
      return true ;
    } // if()
    else if ( Get_Now_Token_Tpye() == TE ) { // 如果是 '*='
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      Set_Operator( TE ) ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == DE ) { // 如果是 '/='
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      Set_Operator( DE ) ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == RE ) { // 如果是 '%='
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      Set_Operator( RE ) ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == PE ) { // 如果是 '+='
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      Set_Operator( PE ) ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == ME ) { // 如果是 '-='
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;
      Set_Operator( ME ) ;
      return true ;
    } // else if()
    else { // 都不是
      // ==================== 這裡不用印錯誤 !? ======================================================
      return false ;
    } // else()
        
  } // Assignment_operator()
    
    private boolean Romce_and_romloe( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_logical_OR_exp( is_num, last_num, string_value ) ) { 
      // 如果是 Rest_of_maybe_logical_OR_exp()
      double num1_double = -1 ;
      boolean num1_bool = false ;
      String rest_of_maybe = "" ;
      rest_of_maybe = Get_Rest_of_maybe_logical_OR_exp() ;
      Set_Romce_and_romloe( Get_Rest_of_maybe_logical_OR_exp() ) ;
      if ( String_Is_Boolean( rest_of_maybe ) ) {
        // 如果它是布林
        num1_bool = Turn_String_To_Boolean( rest_of_maybe ) ;
      } // if()

      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( !num1_bool ) { // 如果是 false
          // 就不執行真正的 Basic_expression()
          // 改執行假的 Fake_Basic_expression
          if ( Fake_Basic_expression() ) {
            if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
              Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
              Get_Token() ;
              if ( Basic_expression() ) { // 如果是 Basic_expression()
                Set_Romce_and_romloe( Get_Basic_expression() ) ; 
                return true ;
              } // if()
              else { // 不是 Basic_expression()
                return false ;
              } // else()
            } // if()
            else { // 不是 ':'
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
              } // if()

              // System.out.println("===== Romce_and_romloe() fake_1 =====") ;
              return false ;
            } // else()
          } // if()
          else {
            return false ;
          } // else()
        } // if()
        else if ( num1_bool && Basic_expression() ) { // 如果是 Basic_expression()
          String save_this_Basic_expression = "" ;
          save_this_Basic_expression = Get_Basic_expression() ;
          if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            // 進這裡表示 
            // 必定前面是 true
            // 所以必定不執行這裡的 Basic_expression()
            // 改執行 Fake_Basic_expression()
            if ( Fake_Basic_expression() ) { // 如果是 Fake_Basic_expression()
              // set 就 set 前面真正有執行的值
              Set_Romce_and_romloe( save_this_Basic_expression ) ;
              return true ;
            } // if()
            else { // 不是 Fake_Basic_expression()
              return false ;
            } // else()
          } // if()
          else { // 不是 ':'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("===== Romce_and_romloe() 1 =====") ;
            return false ;
          } // else()
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Romce_and_romloe() 2 =====") ;
          return false ;
        } // else()
      } // if()
      // 以上為可要可不要
      else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
        // 先不要讀掉
        return true ;
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Romce_and_romloe() 3 =====") ;
        return false ;
      } // else()
    } // if()
    else { // 不是 Rest_of_maybe_logical_OR_exp()
      return false ;
    } // else()
        
  } // Romce_and_romloe()
    
    private boolean Rest_of_maybe_logical_OR_exp( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_logical_AND_exp( is_num, last_num, string_value ) ) { 
      // 如果是 Rest_of_maybe_logical_AND_exp()
      Set_Rest_of_maybe_logical_OR_exp( true, true, -1, true, Get_Rest_of_maybe_logical_AND_exp() ) ;
      boolean num1_bool = false ;
      // 判斷前面進來的如果是 bool
      if ( String_Which_Type( Get_Rest_of_maybe_logical_AND_exp() ) == BOOL ) { 
        // 如果 Rest_of_maybe_relational_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_logical_AND_exp() ) ;
      } // if()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '||'
          Get_Token() ;
          if ( Maybe_logical_AND_exp() ) { // 如果是 Maybe_logical_AND_exp()
            double num2_double = -1 ;
            boolean num2_bool = false ;
            // 判斷前面進來的是 bool 還是 double
            if ( String_Which_Type( Get_Maybe_logical_AND_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_logical_AND_exp() ) ;
              Set_Rest_of_maybe_logical_OR_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Rest_of_maybe_logical_OR_exp_num_or_bool( BOOL ) ;
              num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_logical_OR_exp() ) ;
            } // if()
          } // if()
          else { // 不是 Maybe_logical_AND_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Rest_of_maybe_logical_OR_exp() 1 =====") ;
          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Rest_of_maybe_logical_AND_exp()
      return false ;
    } // else()
        
  } // Rest_of_maybe_logical_OR_exp()
    
    private boolean Maybe_logical_AND_exp() {
        
    if ( Maybe_bit_OR_exp() ) { // 如果是 Maybe_bit_OR_exp()

      Set_Maybe_logical_AND_exp( true, true, -1, true, Get_Maybe_bit_OR_exp() ) ;

      boolean num1_bool = false ;

      // 判斷前面進來的如果是 bool
      if ( String_Which_Type( Get_Maybe_bit_OR_exp() ) == BOOL ) { 
        // 如果 Rest_of_maybe_relational_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Maybe_bit_OR_exp() ) ;

      } // if()


      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '&&'

          Get_Token() ;

          if ( Maybe_bit_OR_exp() ) { // 如果是 Maybe_bit_OR_exp()

            double num2_double = -1 ;
            boolean num2_bool = false ;

            // 判斷前面進來的是 bool
            if ( String_Which_Type( Get_Maybe_bit_OR_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_bit_OR_exp() ) ;
              Set_Maybe_logical_AND_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Maybe_logical_AND_exp_num_or_bool( BOOL ) ;
              num1_bool = Turn_String_To_Boolean( Get_Maybe_logical_AND_exp() ) ;
            } // if()

          } // if()
          else { // 不是 Maybe_bit_OR_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Maybe_logical_AND_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()

    } // if()
    else { // 不是 Maybe_bit_OR_exp()
      return false ;
    } // else()
        
  } // Maybe_logical_AND_exp()
    
    private boolean Rest_of_maybe_logical_AND_exp( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_bit_OR_exp( is_num, last_num, string_value ) ) { // 如果是 Rest_of_maybe_bit_OR_exp()

      boolean num1_bool = false ;

      Set_Rest_of_maybe_logical_AND_exp( true, true, -1, true, Get_Rest_of_maybe_bit_OR_exp() ) ;

      // 判斷前面進來的是 bool 還是 double
      if ( String_Which_Type( Get_Rest_of_maybe_bit_OR_exp() ) == BOOL ) { 
        // 如果 Rest_of_maybe_relational_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_bit_OR_exp() ) ;
      } // if()

      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '&&'

          Get_Token() ;

          if ( Maybe_bit_OR_exp() ) { // 如果是 Maybe_bit_OR_exp()

            double num2_double = -1 ;
            boolean num2_bool = false ;

            // 判斷前面進來的是 bool 還是 double
            if ( String_Which_Type( Get_Maybe_bit_OR_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_bit_OR_exp() ) ;

              Set_Rest_of_maybe_logical_AND_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Rest_of_maybe_logical_AND_exp_num_or_bool( BOOL ) ;
              num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_logical_AND_exp() ) ;
            } // if()


          } // if()
          else { // 不是 Maybe_bit_OR_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Rest_of_maybe_logical_AND_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Rest_of_maybe_bit_OR_exp()
      return false ;
    } // else()
        
  } // Rest_of_maybe_logical_AND_exp()
    
    private boolean Maybe_bit_OR_exp() {
        
    if ( Maybe_bit_ex_OR_exp() ) { // 如果是 Maybe_bit_ex_OR_exp()

      Set_Maybe_bit_OR_exp( true, true, -9487, true, Get_Maybe_bit_ex_OR_exp() ) ;

      boolean num1_bool = false ;

      // 判斷前面進來的是 bool
      if ( String_Which_Type( Get_Maybe_bit_ex_OR_exp() ) == BOOL ) { 
        // 如果 Rest_of_maybe_relational_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Maybe_bit_ex_OR_exp() ) ;

      } // if()


      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 'or'

          Get_Token() ;

          if ( Maybe_bit_ex_OR_exp() ) { // 如果是 Maybe_bit_ex_OR_exp()


            double num2_double = -1 ;
            boolean num2_bool = false ;

            // 判斷前面進來的是 bool
            if ( String_Which_Type( Get_Maybe_bit_ex_OR_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_bit_ex_OR_exp() ) ;
              Set_Maybe_bit_OR_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Maybe_bit_OR_exp_num_or_bool( BOOL ) ;
              num1_bool = Turn_String_To_Boolean( Get_Maybe_bit_OR_exp() ) ;
            } // if()


          } // if()
          else { // 不是 Maybe_bit_ex_OR_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 '&&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Maybe_bit_OR_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Maybe_bit_ex_OR_exp()
      return false ;
    } // else()
        
  } // Maybe_bit_OR_exp()
    
    private boolean Rest_of_maybe_bit_OR_exp( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_bit_ex_OR_exp( is_num, last_num, string_value ) ) { 
      // 如果是 Rest_of_maybe_bit_ex_OR_exp()

      Set_Rest_of_maybe_bit_OR_exp( true, true, -1, true, Get_Rest_of_maybe_bit_ex_OR_exp() ) ;

      boolean num1_bool = false ;

        // 判斷前面進來的是 bool 還是 double
      if ( String_Which_Type( Get_Rest_of_maybe_bit_ex_OR_exp() ) == BOOL ) { 
        // 如果 Rest_of_maybe_relational_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_bit_ex_OR_exp() ) ;

      } // if()


      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 'or'

          Get_Token() ;

          if ( Maybe_bit_ex_OR_exp() ) { // 如果是 Maybe_bit_ex_OR_exp()

            double num2_double = -1 ;
            boolean num2_bool = false ;

            // 判斷前面進來的是 bool
            if ( String_Which_Type( Get_Maybe_bit_ex_OR_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_bit_ex_OR_exp()  );
              Set_Rest_of_maybe_bit_OR_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Rest_of_maybe_bit_OR_exp_num_or_bool( BOOL ) ;
              num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_bit_OR_exp() ) ;
            } // if()


          } // if()
          else { // 不是 Maybe_bit_ex_OR_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Rest_of_maybe_bit_OR_exp() =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Maybe_bit_ex_OR_exp()
      return false ;
    } // else()

        
  } // Rest_of_maybe_bit_OR_exp()
    
    private boolean Maybe_bit_ex_OR_exp() {
        
    if ( Maybe_bit_AND_exp() ) { // 如果是 Maybe_bit_AND_exp()

      Set_Maybe_bit_ex_OR_exp( true, true, -1, true, Get_Maybe_bit_AND_exp() ) ;

      boolean num1_bool = false ;

      // 判斷前面進來的是 bool 還是 double
      if ( String_Which_Type( Get_Maybe_bit_AND_exp() ) == BOOL ) { 
        // 如果 Rest_of_maybe_relational_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Maybe_bit_AND_exp() ) ;
      } // if()


      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '^'

          Get_Token() ;

          if ( Maybe_bit_AND_exp() ) { // 如果是 Maybe_bit_AND_exp()


            double num2_double = -1 ;
            boolean num2_bool = false ;

            // 判斷前面進來的是 bool
            if ( String_Which_Type( Get_Maybe_bit_AND_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_bit_AND_exp() ) ;
              Set_Maybe_bit_ex_OR_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Maybe_bit_ex_OR_exp_num_or_bool( BOOL ) ;
              num1_bool = Turn_String_To_Boolean( Get_Maybe_bit_ex_OR_exp() ) ;
            } // if()

          } // if()
          else { // 不是 Maybe_bit_AND_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Maybe_bit_ex_OR_exp 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Maybe_bit_AND_exp()
      return false ;
    } // else()
        
  } // Maybe_bit_ex_OR_exp()
    
    private boolean Rest_of_maybe_bit_ex_OR_exp( boolean is_num, String last_num, String string_value ) {
        
        
    if ( Rest_of_maybe_bit_AND_exp( is_num, last_num, string_value ) ) { // 如果是 Rest_of_maybe_bit_AND_exp()

      Set_Rest_of_maybe_bit_ex_OR_exp( true, true, -1, true, Get_Rest_of_maybe_bit_AND_exp() ) ;

      boolean num1_bool = false ;

      // 判斷前面進來的是 bool 還是 double
      if ( String_Which_Type( Get_Rest_of_maybe_bit_AND_exp() ) == BOOL ) { 
        // 如果 Rest_of_maybe_relational_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_bit_AND_exp() ) ;
      } // if()


      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '^'

          Get_Token() ;

          if ( Maybe_bit_AND_exp() ) { // 如果是 Maybe_bit_AND_exp()

            double num2_double = -1 ;
            boolean num2_bool = false ;

            // 判斷前面進來的是 bool 還是 double
            if ( String_Which_Type( Get_Maybe_bit_AND_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_bit_AND_exp() ) ;
              Set_Rest_of_maybe_bit_ex_OR_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Maybe_bit_AND_exp_num_or_bool( BOOL ) ;
              num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_bit_ex_OR_exp() ) ;
            } // if()


          } // if()
          else { // 不是 Maybe_bit_AND_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Rest_of_maybe_bit_ex_OR_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Rest_of_maybe_bit_AND_exp()
      return false ;
    } // else()
        
  } // Rest_of_maybe_bit_ex_OR_exp()
    
    private boolean Maybe_bit_AND_exp() {
        
    if ( Maybe_equality_exp() ) { // 如果是 Maybe_equality_exp()

      Set_Maybe_bit_AND_exp( true, true, -1, true, Get_Maybe_equality_exp() ) ;

      boolean num1_bool = false ;

      // 判斷前面進來的是 bool
      if ( String_Which_Type( Get_Maybe_equality_exp() ) == BOOL ) { 
        // 如果 Maybe_equality_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Maybe_equality_exp() ) ;

      } // if()


      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '&'

          Get_Token() ;

          if ( Maybe_equality_exp() ) { // 如果是 Maybe_equality_exp()

            double num2_double = -1 ;
            boolean num2_bool = false ;

            // 判斷前面進來的是 bool 還是 double
            if ( String_Which_Type( Get_Maybe_equality_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_equality_exp() ) ;
              Set_Maybe_bit_AND_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Maybe_bit_AND_exp_num_or_bool( BOOL ) ;
              num1_bool = Turn_String_To_Boolean( Get_Maybe_bit_AND_exp() ) ;
            } // if()

          } // if()
          else { // 不是 Maybe_equality_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Maybe_bit_AND_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Maybe_equality_exp()
      return false ;
    } // else()
        
  } // Maybe_bit_AND_exp()
    
    private boolean Rest_of_maybe_bit_AND_exp( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_equality_exp( is_num, last_num, string_value ) ) { // 如果是 Rest_of_maybe_equality_exp()

      Set_Rest_of_maybe_bit_AND_exp( true, true, -1, true, Get_Rest_of_maybe_equality_exp() ) ;

      boolean num1_bool = false ;

      // 判斷前面進來的是 bool 還是 double
      if ( String_Which_Type( Get_Rest_of_maybe_equality_exp() ) == BOOL ) { 
        // 如果 Rest_of_maybe_relational_exp 是布林
        num1_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_equality_exp() ) ;
      } // if()


      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '&'

          Get_Token() ;

          if ( Maybe_equality_exp() ) { // 如果是 Maybe_equality_exp()


            double num2_double = -1 ;
            boolean num2_bool = false ;

            // 判斷前面進來的是 bool 還是 double
            if ( String_Which_Type( Get_Maybe_equality_exp() ) == BOOL ) { 
              // 如果 Rest_of_maybe_relational_exp 是布林
              num2_bool = Turn_String_To_Boolean( Get_Maybe_equality_exp() ) ;
              Set_Rest_of_maybe_bit_AND_exp( num1_bool, num2_bool, save_ope, false, "" ) ;
              Set_Rest_of_maybe_bit_AND_exp_num_or_bool( BOOL ) ;
              num2_bool = Turn_String_To_Boolean( Get_Rest_of_maybe_bit_AND_exp() ) ;
            } // if()


          } // if()
          else { // 不是 Maybe_equality_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Rest_of_maybe_bit_AND_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Rest_of_maybe_equality_exp()
      return false ;
    } // else()

        
  } // Rest_of_maybe_bit_AND_exp()
    
    private boolean Maybe_equality_exp() {
        
    if ( Maybe_relational_exp() ) { // 如果是 Maybe_relational_exp()

      String num1 = "" ;
      String num2 = "" ;

      num1 = Get_Maybe_relational_exp() ;
      Set_Maybe_equality_exp( "", "", -1, true, num1 ) ;

      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == EQ
             || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '==' 或 '!='

          Get_Token() ;

          if ( Maybe_relational_exp() ) { // 如果是 Maybe_relational_exp()

            num2 = Get_Maybe_relational_exp() ;
            Set_Maybe_equality_exp( num1, num2, save_ope, false, "" ) ;
            Set_Maybe_equality_exp_num_or_bool( BOOL ) ;
            num2 = Get_Maybe_equality_exp() ;

          } // if()
          else { // 不是 Maybe_relational_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          // System.out.println("===== Maybe_equality_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Maybe_relational_exp()
      return false ;
    } // else()
        
        
  } // Maybe_equality_exp()
    
    private boolean Rest_of_maybe_equality_exp( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_relational_exp( is_num, last_num, string_value ) ) { 
      // 如果是 Rest_of_maybe_relational_exp()

      String num1 = "" ;
      String num2 = "" ;


      num1 = Get_Rest_of_maybe_relational_exp() ;
      Set_Rest_of_maybe_equality_exp( "", "", -1, true, num1 ) ;


      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == EQ
             || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '==' 或 '!='

          Get_Token() ;

          if ( Maybe_relational_exp() ) { // 如果是 Maybe_relational_exp()

            num2 = Get_Maybe_relational_exp() ;
            Set_Rest_of_maybe_equality_exp( num1, num2, save_ope, false, "" ) ;
            Set_Rest_of_maybe_equality_exp_num_or_bool( BOOL ) ;
            num2 = Get_Rest_of_maybe_equality_exp() ;


          } // if()
          else { // 不是 Maybe_relational_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Rest_of_maybe_equality_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Rest_of_maybe_relational_exp()
      return false ;
    } // else()
        
        
  } // Rest_of_maybe_equality_exp()
    
    private boolean Maybe_relational_exp() {
        
    if ( Maybe_shift_exp() ) { // 如果是 Maybe_shift_exp()

      String num1 = "" ;
      num1 = Get_Maybe_shift_exp() ;
      Set_Maybe_relational_exp( "", "", -1, true, num1 ) ;
      Set_Maybe_relational_exp_num_or_bool( FLOAT ) ;

      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == ST
             || Get_Now_Token_Tpye() == BT
             || Get_Now_Token_Tpye() == LE
             || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '>' 或 '<' 或 '>= 或 '<='


          Get_Token() ;

          if ( Maybe_shift_exp() ) { // 如果是 Maybe_shift_exp()

            String num2 = "" ;
            num2 = Get_Maybe_shift_exp() ;
            Set_Maybe_relational_exp( num1, num2, save_ope, false, "" ) ;
            Set_Maybe_relational_exp_num_or_bool( BOOL ) ;
            num1 = Get_Maybe_relational_exp() ;

          } // if()
          else { // 不是 Maybe_shift_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Maybe_relational_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Maybe_shift_exp()
      return false ;
    } // else()
        
        
  } // Maybe_relational_exp()
    
    private boolean Rest_of_maybe_relational_exp( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_shift_exp( is_num, last_num, string_value ) ) { // 如果是 Rest_of_maybe_shift_exp()

      String num1 = "" ;
      num1 = Get_Rest_of_maybe_shift_exp() ;
      Set_Rest_of_maybe_relational_exp( "", "", -1, true, num1 ) ;
      Set_Rest_of_maybe_relational_exp_num_or_bool( FLOAT ) ;

      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == ST
             || Get_Now_Token_Tpye() == BT
             || Get_Now_Token_Tpye() == LE
             || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '>' 或 '<' 或 '>= 或 '<='


          Get_Token() ;

          if ( Maybe_shift_exp() ) { // 如果是 Maybe_shift_exp()

            String num2 = "" ;
            num2 = Get_Maybe_shift_exp() ;
            Set_Rest_of_maybe_relational_exp( num1, num2, save_ope, false, "" ) ;
            Set_Rest_of_maybe_relational_exp_num_or_bool( BOOL ) ;
            num1 = Get_Rest_of_maybe_relational_exp() ;

          } // if()
          else { // 不是 Maybe_shift_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Rest_of_maybe_relational_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Rest_of_maybe_shift_exp()
      return false ;
    } // else()
        
        
  } // Rest_of_maybe_relational_exp()
    
    private boolean Maybe_shift_exp() {
        
    if ( Maybe_additive_exp() ) { // 如果是 Maybe_additive_exp()

      String num1 = "" ;

      num1 = Get_Maybe_additive_exp() ;


      // 萬一沒進 for // num1 >> 0 = num1
      Set_Maybe_shift_exp( 0, 0, LS, true, num1 ) ;

      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == LS
             || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function

          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '>>' 或 '<<'

          Get_Token() ;

          if ( Maybe_additive_exp() ) { // 如果是 Maybe_additive_exp()

            double num2 = -1 ;
            num2 = Turn_String_To_Float( Get_Maybe_additive_exp() ) ;

            if ( Get_ever_cout() ) { // 如果曾經是 cout
              // Set_cout_or_shift( COUT ) ;
            } // if()

            // 這裡應該不可能是 'cout' 
            if ( Get_cout_or_shift() == COUT ) { // 如果前面是 cout
              Set_Maybe_shift_exp( 0, 0, -9487, true, num2 + "" ) ;
              Set_cout_or_shift( LS ) ; // 恢復為 <<
            } // if()
            else { // 單純的 << 
              double d = Turn_String_To_Float( num1 ) ;
              int a = ( int ) d ;
              int b = ( int ) ( num2 ) ;
              Set_Maybe_shift_exp( a, b, save_ope, false, "" ) ;
              num1 = Get_Maybe_shift_exp() ;
            } // else()

            num1 = Get_Maybe_shift_exp() ;

          } // if()
          else { // 不是 Maybe_additive_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Maybe_shift_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()


    } // if()
    else { // 不是 Maybe_additive_exp()
      return false ;
    } // else()
        
        
  } // Maybe_shift_exp()
    
    private boolean Rest_of_maybe_shift_exp( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_additive_exp( is_num, last_num, string_value ) ) { // 如果是 Rest_of_maybe_additive_exp()
      double num1 = -1 ;
      if ( String_Is_Float( Get_Rest_of_maybe_additive_exp() ) 
           || String_Is_Int( Get_Rest_of_maybe_additive_exp() ) ) { // 如果是數值
        num1 = Turn_String_To_Float( Get_Rest_of_maybe_additive_exp() ) ;

      } // if()

      // 萬一沒進 for // num1 >> 0 = num1
      Set_Rest_of_maybe_shift_exp( 0, 0, 0, true, Get_Rest_of_maybe_additive_exp() ) ;

      boolean breakk = false ;
      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == LS
             || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '>>' 或 '<<'
          if ( Get_cout_or_shift() == COUT ) { // 如果是 'cout'
            if ( save_ope == RS ) { // 如果是 '>>'
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
              } // if()
              // System.out.println("===== Rest_of_maybe_shift_exp() 0 =====") ;
            } // if()
          } // if()

          Get_Token() ;

          if ( Maybe_additive_exp() ) { // 如果是 Maybe_additive_exp()

            double num2 = -1 ;
            if ( Get_cout_or_shift() == COUT ) { // 如果前面是 cout
              if ( Get_Print_Cout() && Get_Set_While() == -1 ) {
                // 正常的時候
                // while 值為 -1
                System.out.print( "> " ) ;
                Set_Print_Cout( false ) ;
              } // if()
              else if ( Get_Set_While() == 0 ) {
                // while 值為 0
                // 表示第一次的 while
                // 要印 ">"
                System.out.print( "> " ) ;
                Set_Set_While( 1 ) ; // 再 +1 避免連續 cout << ... << ...
                Set_Ever_Print_BT( true ) ; // 有印過 "> "
              } // else if()

              Set_Rest_of_maybe_shift_exp( 0, 0, 0, true, Get_Maybe_additive_exp() ) ;

              if ( Get_Is_Float() && String_Is_Float( Get_Maybe_additive_exp() ) ) {
                // 如果是浮點數
                double print_gloat = -1 ;
                print_gloat = Turn_String_To_Float( Get_Maybe_additive_exp() ) ;
                String s = String.format( "%.3f", print_gloat ) ;
                System.out.print( s ) ;
              } // if()
              else if ( !Get_Is_Float() && String_Is_Float( Get_Maybe_additive_exp() ) ) {
                // 如果不是浮點數
                // 但是 是用 double 在做運算

                double print_gloat = -1 ;
                print_gloat = Turn_String_To_Float( Get_Maybe_additive_exp() ) ;
                int t = ( new Float( print_gloat ) ).intValue() ;
                System.out.print( t ) ;
              } // else if()
              else {

                System.out.print( Get_Maybe_additive_exp() ) ;
              } // else()

            } // if()
            else { // 單純的 << 
              num2 = Turn_String_To_Float( Get_Maybe_additive_exp() ) ;
              int a = ( int ) num1 ;
              int b = ( int ) num2 ;
              Set_Rest_of_maybe_shift_exp( a, b, save_ope, false, "" ) ;
              num1 = Turn_String_To_Float( Get_Rest_of_maybe_shift_exp() ) ;
            } // else()
          } // if()
          else { // 不是 Maybe_additive_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Rest_of_maybe_shift_exp() 1 =====") ;
          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()

    } // if()
    else { // 不是 Rest_of_maybe_additive_exp()
      return false ;
    } // else()
        
  } // Rest_of_maybe_shift_exp()
    
    private boolean Maybe_additive_exp() {
        
    if ( Maybe_mult_exp() ) { // 如果是 Maybe_mult_exp()

      String num1 = "" ;
      num1 = Get_Maybe_mult_exp() ;

      // 萬一沒進 for // num1 + 0 = num1
      Set_Maybe_additive_exp( "", "", ADD, true, Get_Maybe_mult_exp() ) ;

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ADD
             || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '+' 或 '-'
          Get_Token() ;
          if ( Maybe_mult_exp() ) { // 如果是 Maybe_mult_exp()
            String num2 = "" ;
            num2 = Get_Maybe_mult_exp() ;
            Set_Maybe_additive_exp( num1, num2, save_ope, false, "" ) ;
            num1 = Get_Maybe_additive_exp() ;
          } // if()
          else { // 不是 Maybe_mult_exp()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == LS
                  || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // Print("Maybe_additive_exp() 1") ;
          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()

    } // if()
    else { // 不是 Maybe_mult_exp()
      return false ;
    } // else()
        
  } // Maybe_additive_exp()
    
    private boolean Rest_of_maybe_additive_exp( boolean is_num, String last_num, String string_value ) {
        
    if ( Rest_of_maybe_mult_exp( is_num, last_num, string_value ) ) { // 如果是 Rest_of_maybe_mult_exp()

      String num1 = "" ;
      num1 = Get_Rest_of_maybe_mult_exp() ;
      // 萬一沒進 for // 直接 set
      Set_Rest_of_maybe_additive_exp( "", "", ADD, true, Get_Rest_of_maybe_mult_exp() ) ;
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ADD
             || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          int save_ope = -1 ; 
          save_ope = Return_Token_Type() ; // 存 '+' 或 '-'
          Get_Token() ;
          if ( Maybe_mult_exp() ) { // 如果是 Maybe_mult_exp()
            String num2 = "" ;
            num2 = Get_Maybe_mult_exp() ;
            Set_Rest_of_maybe_additive_exp( num1 + "", num2, save_ope, false, "" ) ;
            num1 = Get_Rest_of_maybe_additive_exp() ;
          } // if()
          else { // 不是 Maybe_mult_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == LS
                  || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是

          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Rest_of_maybe_additive_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()

    } // if()
    else { // 不是 Maybe_mult_exp()
      return false ;
    } // else()
        
  } // Rest_of_maybe_additive_exp()
    
    private boolean Maybe_mult_exp() {
        
    if ( Unary_exp() ) { // 如果是 Unary_exp()

      String unary_exp_string = "" ;
      unary_exp_string = Get_Unary_exp() ;


      boolean is_num = false ;

      if ( String_Is_Float( Get_Unary_exp() ) 
           || String_Is_Int( Get_Unary_exp() ) ) { 
        // 如果此 Unary_exp() 是數字
        is_num = true ;
      } // if()


      if ( Rest_of_maybe_mult_exp( is_num, Get_Unary_exp(), Get_Unary_exp() ) ) { 
        // 如果是 Rest_of_maybe_mult_exp()

        // 存數值
        Set_Maybe_mult_exp( Get_Rest_of_maybe_mult_exp() ) ;

        return true ;
      } // if()
      else { // 不是 Rest_of_maybe_mult_exp()
        return false ;
      } // else()

    } // if()
    else { // 不是 Unary_exp()
      return false ;
    } // else()
        
  } // Maybe_mult_exp()
    
    private boolean Rest_of_maybe_mult_exp( boolean is_num, String last_num, String string_value ) {
        
    boolean breakk = false ;
    // 萬一沒進 for
    if ( Same_Id( string_value, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) {
      // 如果有這個 Id
      // 存它的值
      Set_Rest_of_maybe_mult_exp( 1, 1, MUL, true, last_num + "" ) ;
    } // if()
    else {
      Set_Rest_of_maybe_mult_exp( 1, 1, MUL, true, string_value ) ;
    } // else()

    // 以下的 for 可以不要進
    for ( ; !breakk ; ) {

      if ( Get_Now_Token_Tpye() == MUL
           || Get_Now_Token_Tpye() == DIV
           || Get_Now_Token_Tpye() == PA ) { // 如果是 '*' 或 '/' 或 '%'
        int save_ope = -1 ;
        save_ope = Return_Token_Type() ;
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Unary_exp() ) { // 如果是 Unary_exp()
          // 給數值 // 以及 '*' '/' '%'
          Set_Rest_of_maybe_mult_exp( Turn_String_To_Float( last_num ), 
                                      Turn_String_To_Float( Get_Unary_exp() ), 
                                      save_ope, false, "" ) ;
          last_num = Get_Rest_of_maybe_mult_exp() ;
        } // if()
        else { // 不是 Unary_exp()
          return false ;
        } // else()
      } // if()
      else if ( Get_Now_Token_Tpye() == ADD
                || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == LS
                || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == ST
                || Get_Now_Token_Tpye() == BT
                || Get_Now_Token_Tpye() == LE
                || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == EQ
                || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
        // 先不要讀掉
        return true ;
      } // else if()
      else { // 都不是
        // 但因為可以不要進
        return true ;
      } // else()

    } // for()

    if ( breakk ) {
      return true ;
    } // if()
    else {
      // 不可能進這
      // Print("Rest_of_maybe_mult_exp() Error") ;
      return false ;
    } // else()
        
  } // Rest_of_maybe_mult_exp()
    
    private boolean Unary_exp() {
        
    String save_id = "" ;
    double array_num = -9487 ; // array 的維度

    if ( Get_Now_Token_Tpye() == PP
         || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      int ope = Return_Token_Type() ; // 拿 '++' 或 '--'
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
        save_id = Return_Token() ; // 暫存此 id 
        if ( Return_Id_Is_Float( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ) {
          // 如果此 Id 是浮點數
          Set_Is_Float( true ) ;
        } // if()
        
        double id_num = -9487 ;
        id_num 
        = Turn_String_To_Float( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), -1 ) ) ;
        if ( ope == PP ) { // 是 '++'
          // 把此 Id + 1
          id_num++ ;
          Save_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, -1 ) ;
          Set_Unary_exp( id_num + "" ) ;
        } // if()
        else if ( ope == MM ) { // 是 '--'
          // 把此 Id - 1
          id_num-- ;
          Save_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, -1 ) ;
          Set_Unary_exp( id_num + "" ) ;
        } // else if()

        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過

          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( save_id, ID, true ) ;
          } // if()

          // System.out.println("===== Unary_exp() 1 =====") ;
          return false ;
        } // if()

        // 以下為可要可不要

        if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          Get_Token() ;
          if ( Expression() ) { // 如果是 Expression()
            if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
              Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
              array_num = Turn_String_To_Float( Get_Expression() ) ; // 給 陣列的數值
              Get_Token() ;
              int a = ( int ) array_num ;
              id_num 
              = Turn_String_To_Float( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), a ) ) ;
              if ( ope == PP ) { // 是 '++'
                int b = ( int ) array_num ;
                // 把此 Id + 1
                id_num++ ;
                Save_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, b ) ;
                Set_Unary_exp( id_num + "" ) ;
              } // if()
              else if ( ope == MM ) { // 是 '--'
                int c = ( int ) array_num ;
                // 把此 Id - 1
                id_num-- ;
                Save_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, c ) ;
                Set_Unary_exp( id_num + "" ) ;
              } // else if()

              return true ;
            } // if()
            else { // 不是 ']'
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
              } // if()

              // System.out.println("===== Unary_exp() 2 =====") ;
              return false ;
            } // else()
          } // if()
          else { // 不是 Expression()
            return false ;
          } // else()

        } // if()
        // 以上為可要可不要
        else if ( Get_Now_Token_Tpye() == MUL
                  || Get_Now_Token_Tpye() == DIV
                  || Get_Now_Token_Tpye() == PA ) { // 如果是 '*' 或 '/' 或 '%'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ADD
                  || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == LS
                  || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是

          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Unary_exp() 3 =====") ;

          return false ;
        } // else()
      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Unary_exp() 4 =====") ;
        return false ;
      } // else()

    } // if()
    else if ( Get_Now_Token_Tpye() == ID 
              || Get_Now_Token_Tpye() == CONSTANT
              || Get_Now_Token_Tpye() == LP ) { // 如果是 ID 或是 constant 或是 '('

      // 先不要拿
      if ( Unsigned_unary_exp() ) { // 如果是 Unsigned_unary_exp()
        // 設定數值
        Set_Unary_exp( Get_Unsigned_unary_exp() ) ;
        return true ;
      } // if()
      else { // 不是 Unsigned_unary_exp()
        return false ;
      } // else()
    } // else if()
    else if ( Sign() ) { // 如果是 sign()
      int not_sub_count = 1 ; // '!' 或 '-'
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ID ) { // 如果是 ID
          // 先不要拿
          breakk = true ;
        } // if()
        else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 CONSTANT
          // 先不要拿
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
          // 先不要拿
          breakk = true ;
        } // else if()
        else if ( Sign() ) { // 如果是 sign()
          not_sub_count++ ;
        } // else if()
        else { // 不是 sign()
          breakk = true ;
        } // else()
      } // for()

      if ( Signed_unary_exp() ) { // 如果是 Signed_unary_exp()
        if ( String_Is_Float( Get_Signed_unary_exp() ) || String_Is_Int( Get_Signed_unary_exp() ) ) { 
          // 如果是 double 或是 int
          if ( !Is_Even( not_sub_count ) ) { // 如果有奇數個 '-' // 表示是負的
            Set_Unary_exp( Turn_String_To_Float( Get_Signed_unary_exp() ) * ( -1 ) + "" ) ;
          } // if()
          else { // 是正的
            Set_Unary_exp( Get_Signed_unary_exp() ) ;
          } // else()
        } // if()
        else if ( String_Is_Boolean( Get_Signed_unary_exp() ) ) {
          if ( !Is_Even( not_sub_count ) ) { // 如果是奇數個 '!'
            if ( Get_Signed_unary_exp().equals( "true" ) ) {
              Set_Unary_exp( "false" ) ;
            } // if()
            else if ( Get_Signed_unary_exp().equals( "false" ) ) {
              Set_Unary_exp( "true" ) ;
            } // else if()
            else {
              // Print("===== Unary_exp() 4 =====") ;
            } // else()
          } // if()
          else { //  是偶數
            Set_Unary_exp( Get_Signed_unary_exp() ) ;
          } // else()
        } // else if()

        return true ;
      } // if()
      else { // 不是 Signed_unary_exp()
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      return false ;
    } // else()
           
  } // Unary_exp()
    
    private boolean Signed_unary_exp() {
        
    String save_id = "" ;
    double array_num = -9487 ; // array 的維度
    if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
      save_id = Return_Token() ; // 暫存此 id 
      double id_num = -9487 ;
      if ( Return_Id_Is_Float( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ) {
        // 如果此 Id 是浮點數
        Set_Is_Float( true ) ;
      } // if()
      // 先存 // 假設沒陣列狀況
      // 如果等等有陣列
      // 會把它蓋掉
      Get_Token() ;
      Set_Signed_unary_exp( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), -1 ) ) ;
      if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( save_id, ID, true ) ;
        } // if()
        // System.out.println("===== Signed_unary_exp() 1 =====") ;
        return false ;
      } // if()
      
      if ( Get_Now_Token_Tpye() == COMMA 
           || Get_Now_Token_Tpye() == LMP
           || Get_Now_Token_Tpye() == LP ) { // 如果下一個 Token 是 ','
        // 或是 '[' // 或 '('
        Set_My_Now_Func_String( save_id, 0 ) ; // 就不要空格
      } // if()
      else { // 不是 ',' 也不是 '['
        // 就要空格
        Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
      } // else()
      // 以下為 Function 暫時不處理
      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
        Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
        Get_Token() ;
        // 以下為可要可不要
        if ( Actual_parameter_list() ) { // 如果是 Actual_parameter_list()
        } // if()
        // 以上為可要可不要
        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          Get_Token() ;
          return true ;
        } // if()
        else { // 不是 ')'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Signed_unary_exp() 2 =====") ;
          return false ;
        } // else()
      } // if()
      else if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Expression() ) { // 如果是 Expression()
          if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            array_num = Turn_String_To_Float( Get_Expression() ) ; // 給 陣列的數值
            int a = ( int ) array_num ;
            Set_Signed_unary_exp( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), a ) ) ;
            Get_Token() ;
            return true ;
          } // if()
          else { // 不是 ']'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("===== Signed_unary_exp() 3 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 不是 Expression()
          return false ;
        } // else()
      } // else if()
      // 以上為可要可不要
      else if ( Get_Now_Token_Tpye() == ADD
                || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == MUL
                || Get_Now_Token_Tpye() == DIV
                || Get_Now_Token_Tpye() == PA ) { // 如果是 '8' 或 '/' 或 '%'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == LS
                || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == ST
                || Get_Now_Token_Tpye() == BT
                || Get_Now_Token_Tpye() == LE
                || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == EQ
                || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
        // 先不要讀掉
        return true ;
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Signed_unary_exp() 4 =====") ;
        return false ;
      } // else()
    } // if()
    else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
      Set_Signed_unary_exp( Return_Token() ) ;
      if ( Return_Token_Is_Float() ) { // 如果是 浮點數
        Set_Is_Float( true ) ;
      } // if()
      
      if ( Return_Is_String() ) { // 如果是字串
        Set_My_Now_Func_String( "\"" + Return_Token() + "\"", 1 ) ; // 存當下的 Function
      } // if()
      else { // 不是字串
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      } // else()

      Get_Token() ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      String save_token = "" ;
      save_token = Return_Token() ;
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == RP ) { // 如果下一個 Token 是 ')'
        Set_My_Now_Func_String( save_token, 0 ) ; // 存當下的 Function
      } // if()
      else { // 不是 ')'
        // 就要空格
        Set_My_Now_Func_String( save_token, 1 ) ; // 存當下的 Function
      } // else()

      if ( Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          // 存數值
          Set_Signed_unary_exp( Get_Expression() ) ;
          Get_Token() ;
          return true ;
        } // if()
        else { // 不是 ')'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Signed_unary_exp() 5 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()
      // System.out.println("===== Signed_unary_exp() 6 =====") ;
      return false ;
    } // else()
  } // Signed_unary_exp()
    
    private boolean Unsigned_unary_exp() {
        
    String save_id = "" ;
    double array_num = -9487 ; // array 的維度
    if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
      save_id = Return_Token() ; // 暫存此 id 
      if ( save_id.equals( "cout" ) ) { // 如果是 cout
        Set_cout_or_shift( COUT ) ;
      } // if()
      
      if ( Return_Id_Is_Float( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ) {
        // 如果此 Id 是浮點數
        Set_Is_Float( true ) ;
      } // if()

      double id_num = -9487 ;
      // 先存 // 假設沒陣列狀況
      // 如果等等有陣列
      // 會把它蓋掉
      Get_Token() ;
      Set_Unsigned_unary_exp( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), -1 ) ) ;
      if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
        // 且 不是 Function
        // 那肯定是 Id 未定義
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( save_id, ID, true ) ;
        } // if()
        // System.out.println("===== Unsigned_unary_exp() 1 =====") ;
        return false ;
      } // if()

      if ( Get_Now_Token_Tpye() == COMMA 
           || Get_Now_Token_Tpye() == LMP 
           || Get_Now_Token_Tpye() == PP
           || Get_Now_Token_Tpye() == MM
           || Get_Now_Token_Tpye() == LP ) { // 如果下一個 Token 是 ','
        // 或是 '[' // 或 '('
        Set_My_Now_Func_String( save_id, 0 ) ; // 就不要空格
      } // if()
      else { // 不是 ',' 也不是 '['
        // 就要空格
        Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
      } // else()
      // 以下為 Function 呼叫 // 暫不處理
      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
        String save_token = "" ;
        save_token = Return_Token() ;
        Get_Token() ;
        if ( Get_Now_Token_Tpye() == RP ) { // 如果下一個 Token 是 ')'
          Set_My_Now_Func_String( save_token, 0 ) ; // 存當下的 Function
        } // if()
        else { // 不是 ')'
          // 就要空格
          Set_My_Now_Func_String( save_token, 1 ) ; // 存當下的 Function
        } // else()
        // 以下為可要可不要
        if ( Get_Now_Token_Tpye() == ID
             || Get_Now_Token_Tpye() == PP || Get_Now_Token_Tpye() == MM
             || Get_Now_Token_Tpye() == CONSTANT || Get_Now_Token_Tpye() == ADD
             || Get_Now_Token_Tpye() == SUB || Get_Now_Token_Tpye() == NOT ) {
          // 如果這這幾個 Token
          // 才有可能是 Actual_parameter_list()
          if ( Actual_parameter_list() ) { // 如果是 Actual_parameter_list()
          } // if()
          else { // 不是 Actual_parameter_list()
            // 不可能進這裡
            // Print("Unsigned_unary_exp()_Error") ;
            return false ;
          } // else()
        } // if()
        // 以上為可要可不要

        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          Get_Token() ;
          if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { 
            // 如果此 id 未定義過
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( save_id, ID, true ) ;
            } // if()
            // System.out.println("===== Unsigned_unary_exp() 2 =====") ;
            return false ;
          } // if()

          return true ;
        } // if()
        else { // 不是 ')'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Unsigned_unary_exp() 3 =====") ;
          return false ;
        } // else()
      } // if()
      // 以下為陣列處理 
      else if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Expression() ) { // 如果是 Expression()
          if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
            array_num = Turn_String_To_Float( Get_Expression() ) ; // 給 陣列的數值
            Get_Token() ;
            int a = ( int ) array_num ;
            Set_Unsigned_unary_exp( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), a ) ) ;
            if ( Get_Now_Token_Tpye() == PP
                 || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
              // 就不要空格
              Set_My_Now_Func_String( save_id, 0 ) ; // 存當下的 Function
              int ope = Return_Token_Type() ; // 拿 '++' 或 '--'
              if ( ope == PP ) { // 是 '++'
                // 把此 Id + 1
                int b = ( int ) array_num ;
                id_num 
                = Turn_String_To_Float( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), b ) ) ;
                Set_Unsigned_unary_exp( id_num + "" ) ;
                id_num++ ;
                Save_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, b ) ;
              } // if()
              else if ( ope == MM ) { // 是 '--'
                int c = ( int ) array_num ;  
                // 把此 Id - 1
                id_num 
                = Turn_String_To_Float( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), c ) ) ;
                Set_Unsigned_unary_exp( id_num + "" ) ;
                id_num-- ;
                Save_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, c ) ;
              } // else if()
            } // if()
            else {
              Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
            } // else()

            // 以下為可要可不要
            if ( Get_Now_Token_Tpye() == PP
                 || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
              Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
              Get_Token() ;
              return true ;
            } // if()
            // 以上為可要可不要
            else if ( Get_Now_Token_Tpye() == ADD
                      || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == MUL
                      || Get_Now_Token_Tpye() == DIV
                      || Get_Now_Token_Tpye() == PA ) { // 如果是 '8' 或 '/' 或 '%'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == LS
                      || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == ST
                      || Get_Now_Token_Tpye() == BT
                      || Get_Now_Token_Tpye() == LE
                      || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == EQ
                      || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
              // 先不要讀掉
              return true ;
            } // else if()
            else { // 都不是
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
              } // if()
              // System.out.println("===== Unsigned_unary_exp() 4 =====") ;
              return false ;
            } // else()
          } // if()
          else { // 不是 ']'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("===== Unsigned_unary_exp() 5 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 不是 Expression()
          return false ;
        } // else()
      } // else if()
      // 以上為可要可不要
      // 以下為可要可不要
      else if ( Get_Now_Token_Tpye() == PP
                || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
        int ope = Return_Token_Type() ; // 拿 '++' 或 '--'
        Get_Token() ;
        // 進這裡表示沒有陣列
        id_num 
        = Turn_String_To_Float( Get_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), -1 ) ) ;
        if ( ope == PP ) { // 是 '++'
          // 把此 Id + 1
          Set_Unsigned_unary_exp( id_num + "" ) ;
          id_num++ ;
          Save_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, -1 ) ;
        } // if()
        else if ( ope == MM ) { // 是 '--'
          // 把此 Id - 1
          Set_Unsigned_unary_exp( id_num + "" ) ;
          id_num-- ;
          Save_Id_Num( save_id, Get_My_Glo_Or_Loc_Id_Length(), id_num + "", SMALL_EQU, -1 ) ;
        } // else if()

        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == MUL
                || Get_Now_Token_Tpye() == DIV
                || Get_Now_Token_Tpye() == PA ) { // 如果是 '*' 或 '/' 或 '%'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == ADD
                || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == LS
                || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == ST
                || Get_Now_Token_Tpye() == BT
                || Get_Now_Token_Tpye() == LE
                || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == EQ
                || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
        // 先不要讀掉
        return true ;
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()
        // System.out.println("===== Unsigned_unary_exp() 6 =====") ;
        return false ;
      } // else()
    } // if()
    else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
      Set_Unsigned_unary_exp( Return_Token() ) ;
      if ( Return_Token_Is_Float() ) { // 如果是 浮點數
        Set_Is_Float( true ) ;
      } // if()

      if ( Return_Is_String() ) { // 如果是字串
        Set_My_Now_Func_String( "\"" + Return_Token() + "\"", 1 ) ; // 存當下的 Function
      } // if()
      else { // 不是字串
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      } // else()

      Get_Token() ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
      Get_Token() ;

      if ( Get_ever_cout() && Get_cout_or_shift() == COUT ) {
        // 如果現在是 cout 且曾經是 cout
        Set_cout_or_shift( LS ) ;
      } // if()

      if ( Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          // 存數值
          Set_Unsigned_unary_exp( Get_Expression() ) ;
          Get_Token() ;
          if ( Get_ever_cout() ) {
            // 如果曾經是 cout
            // 再把它變回 cout
            Set_cout_or_shift( COUT ) ;
          } // if()

          return true ;
        } // if()
        else { // 不是 ')'
          return false ;
        } // else()
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()

      // System.out.println("===== Unsigned_unary_exp() 7 =====") ;
      return false ;
    } // else()
  } // Unsigned_unary_exp()
    
    
    
    
    // ========== 只用來讀掉 token 的 ==========
    
    private boolean Fake_Type_specifier() {
        
    if ( Get_Now_Token_Tpye() == INT ) { // 如果是 int

      Get_Token() ;

      return true ;
    } // if()
    else if ( Get_Now_Token_Tpye() == CHAR ) { // 如果是 char

      Get_Token() ;

      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == FLOAT ) { // 如果是 double

      Get_Token() ;

      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == STRING ) { // 如果是 string

      Get_Token() ;

      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == BOOL ) { // 如果是 bool

      Get_Token() ;

      return true ;
    } // else if()
    else { // 都不是
      // =============================== 不印錯誤 !? ====================================

      return false ;
    } // else()
        
  } // Fake_Type_specifier()
    
    private boolean Fake_Rest_of_declarators( String id, int type ) {
        
    String array_num = "" ; // [num] // 以字串存
    // 以下為可要可不要
    if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['


      Get_Token() ;

      if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant

        array_num = Return_Token() ;

        Get_Token() ;

        if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'

          if ( Same_Id( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
            // 以下兩個都需要更新所有的狀態 ( type... )
            // 所以如果是 Function 只要印最外面的 Function name
            // 不用管理面變數名稱是怎樣
            // 而進 Rest_of_declarators 就不可能是要印 Function 變數
            // ( 不能 void A(), B()..... )
            // 故 最後一項必為 false
            // 而如果不是 Function 才要進
            // 因為如果是 Function 就只要印 Funciton
            if ( !Get_Is_Function() ) {
              Save_My_Now_Id( id, true, type, false ) ;
            } // if()

            if ( Same_Id_In_Same_Compound( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) {
              // 如果是同一個 {} 內 再定義
              // 那就真的要重新定義
              // 重新定義
              Set_New_Definition( id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;


            } // if()
            else {
              // 不是同一個 {} 內重新定義
              // 表示是此 {} 專屬的定義

              // 存所以的變數 // 沒有 array
              Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
              // 變數++
              Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;

              // 標記此變數為 假的宣告
              // 即 吃掉 token 後就要消失
              Set_Fake_Variable( id, Get_My_Glo_Or_Loc_Id_Length() ) ;

            } // else()

            // 不需要變數++ ( 因為是重新定義 )
          } // if()
          else { // 新定義
            // 存印定義
            // 因為是要印定義
            // 所以如果是 Function 只要印最外面的 Function name
            // 不用管理面變數名稱是怎樣
            // 而進 Rest_of_declarators 就不可能是要印 Function 變數
            // ( 不能 void A(), B()..... )
            // 故 最後一項必為 false
            if ( !Get_Is_Function() ) {
              Save_My_Now_Id( id, false, type, false ) ;
            } // if()

            // 存所有的變數
            Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), array_num ) ;
            // 變數++
            Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;

            // 標記此變數為 假的宣告
            // 即 吃掉 token 後就要消失
            Set_Fake_Variable( id, Get_My_Glo_Or_Loc_Id_Length() ) ;


          } // else()

          Get_Token() ;

        } // if()
        else { // 不是 ']'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_declarators() 1 =====") ;
          return false ;
        } // else()

      } // if()
      else { // 不是 Constant
        return false ;
      } // else()

    } // if()
    else { // 沒有 array

      if ( Same_Id( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
        // 以下兩個都需要更新所有的狀態 ( type... )
        // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
        if ( !Get_Is_Function() ) {
          Save_My_Now_Id( id, true, type, false ) ;
        } // if()

        if ( Same_Id_In_Same_Compound( id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) {
          // 如果是同一個 {} 內 再定義
          // 那就真的要重新定義
          // 重新定義
          Set_New_Definition( id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;



        } // if()
        else {
          // 不是同一個 {} 內重新定義
          // 表示是此 {} 專屬的定義

          // 存所以的變數 // 沒有 array
          Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
          // 變數++
          Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;

          // 標記此變數為 假的宣告
          // 即 吃掉 token 後就要消失
          Set_Fake_Variable( id, Get_My_Glo_Or_Loc_Id_Length() ) ;


        } // else()

        // 不需要變數++ ( 因為是重新定義 )
      } // if()
      else { // 新定義
        // 存印定義
        if ( !Get_Is_Function() ) {
          Save_My_Now_Id( id, false, type, false ) ;
        } // if()

        // 存所以的變數 // 沒有 array
        Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
        // 變數++
        Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;

        // 標記此變數為 假的宣告
        // 即 吃掉 token 後就要消失
        Set_Fake_Variable( id, Get_My_Glo_Or_Loc_Id_Length() ) ;

      } // else()

    } // else()

    // 以上為可要可不要

    String save_id = "" ;
    type = Get_Id_Type() ; // 取得型別

    boolean breakk = false ;

    for ( ; !breakk ; ) {

      if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','


        Get_Token() ;

        if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id

          save_id = Return_Token() ;

          Get_Token() ;

          if ( Get_Now_Token_Tpye() == COMMA 
               || Get_Now_Token_Tpye() == LMP ) { // 如果下一個 Token 是 ','
            // 或是 '['

          } // if()
          else { // 不是 ',' 也不是 '['
            // 就要空格

          } // else()

          // 以下為可要可不要
          if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['

            Get_Token() ;

            if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant

              Get_Token() ;

              if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'

                if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
                  // 以下兩個都需要更新所有的狀態 ( type... )
                  // 所以如果是 Function 只要印最外面的 Function name
                  // 不用管理面變數名稱是怎樣
                  // 而進 Rest_of_declarators 就不可能是要印 Function 變數
                  // ( 不能 void A(), B()..... )
                  // 故 最後一項必為 false
                  // 而如果不是 Function 才要進
                  // 因為如果是 Function 就只要印 Funciton
                  if ( !Get_Is_Function() ) {
                    Save_My_Now_Id( save_id, true, type, false ) ;
                  } // if()

                  if ( Same_Id_In_Same_Compound( save_id, Get_My_Glo_Or_Loc_Id_Length(), 
                                                 Get_Is_Function() ) ) {
                    // 如果是同一個 {} 內 再定義
                    // 那就真的要重新定義
                    // 重新定義
                    Set_New_Definition( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;

                  } // if()
                  else {
                    // 不是同一個 {} 內重新定義
                    // 表示是此 {} 專屬的定義

                    // 存所以的變數 // 沒有 array
                    Set_New_ID( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
                    // 變數++
                    Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;

                    // 標記此變數為 假的宣告
                    // 即 吃掉 token 後就要消失
                    Set_Fake_Variable( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ;

                  } // else()

                  // 不需要變數++ ( 因為是重新定義 )
                } // if()
                else { // 新定義
                  // 存印定義
                  // 因為是要印定義
                  // 所以如果是 Function 只要印最外面的 Function name
                  // 不用管理面變數名稱是怎樣
                  // 而進 Rest_of_declarators 就不可能是要印 Function 變數
                  // ( 不能 void A(), B()..... )
                  // 故 最後一項必為 false
                  if ( !Get_Is_Function() ) {
                    Save_My_Now_Id( save_id, false, type, false ) ;
                  } // if()

                  // 存所有的變數
                  Set_New_ID( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), array_num ) ;
                  // 變數++
                  Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;

                  // 標記此變數為 假的宣告
                  // 即 吃掉 token 後就要消失
                  Set_Fake_Variable( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ;

                } // else()

                Get_Token() ;

              } // if()
              else { // 不是 ']'
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                  // 就設定錯誤
                  Set_Error( Return_Token(), Return_Token_Type(), false ) ;

                } // if()

                // System.out.println("===== Fake_Rest_of_declarators() 2 =====") ;
                return false ;
              } // else()

            } // if()
            else { // 不是 Constant
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;

              } // if()

              // System.out.println("===== Rest_of_declarators() 3 =====") ;
              return false ;
            } // else()
          } // if()
          else { // 沒有 array

            if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
                // 以下兩個都需要更新所有的狀態 ( type... )
                // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
              if ( !Get_Is_Function() ) {
                Save_My_Now_Id( save_id, true, type, false ) ;
              } // if()

              if ( Same_Id_In_Same_Compound( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) {
                // 如果是同一個 {} 內 再定義
                // 那就真的要重新定義
                // 重新定義
                Set_New_Definition( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;
              } // if()
              else {
                // 不是同一個 {} 內重新定義
                // 表示是此 {} 專屬的定義

                // 存所以的變數 // 沒有 array
                Set_New_ID( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
                // 變數++
                Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;

                // 標記此變數為 假的宣告
                // 即 吃掉 token 後就要消失
                Set_Fake_Variable( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ;

              } // else()

                // 不需要變數++ ( 因為是重新定義 )
            } // if()
            else { // 新定義
              // 存印定義
              if ( !Get_Is_Function() ) {
                Save_My_Now_Id( save_id, false, type, Get_Is_Function() ) ;
              } // if()

              // 存所以的變數 // 沒有 array
              Set_New_ID( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), "" ) ;
              // 變數++
              Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;

              // 標記此變數為 假的宣告
              // 即 吃掉 token 後就要消失
              Set_Fake_Variable( save_id, Get_My_Glo_Or_Loc_Id_Length() ) ;


            } // else()


          } // else()

        } // if()
        else { // 不是 id
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;

          } // if()

          // System.out.println("===== Fake_Rest_of_declarators() 4 =====") ;
          return false ;
        } // else()

      } // if()
      else { // 不是 ','
        breakk = true ;
      } // else()

    } // for()

    if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'

      Get_Token() ;

      return true ;
    } // if()
    else { // 不是 ';'
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;

      } // if()

      // System.out.println("===== Fake_Rest_of_declarators() 6 =====") ;
      return false ;
    } // else()
        
  } // Fake_Rest_of_declarators()
    
    private boolean Fake_Function_definition_without_ID() {
        
    if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('

      Get_Token() ;

        // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == VOID ) { // 如果是 void
        // 那 '(' 後面就必須有空格

        Get_Token() ;

      } // if()
      else if ( Get_Now_Token_Tpye() == INT || Get_Now_Token_Tpye() == CHAR
                || Get_Now_Token_Tpye() == FLOAT || Get_Now_Token_Tpye() == STRING
                || Get_Now_Token_Tpye() == BOOL ) {

        if ( Fake_Formal_parameter_list() ) { // 如果是 Formal_parameter_list()
          // 不做事
        } // if()
        else { // 不是 Formal_parameter_list()
          return false ;
        } // else()

      } // else if()
      // 以上為可要可不要

      if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'

        Get_Token() ;

        if ( Fake_Compound_statement() ) { // 如果是 Compound_statement()

          return true ;
        } // if()
        else { // 不是 Compound_statement()
          return false ;
        } // else()

      } // if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Function_definition_without_ID() 1 =====") ;
        return false ;
      } // else()

    } // if()
    else { // 不是 '('
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()

      // System.out.println("===== Fake_Function_definition_without_ID() 2 =====") ;
      return false ;
    } // else()

        
  } // Fake_Function_definition_without_ID()
    
    private boolean Fake_Formal_parameter_list() {
        
    if ( Fake_Type_specifier() ) { // 如果是 Type_specifier()

      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'

        Get_Token() ;

      } // if()
      // 以上為可要可不要

      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id

        String save_id = Return_Token() ;

        Get_Token() ;

        // 以下為可要可不要
        if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['

          Get_Token() ;

          if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant


            Get_Token() ;

            if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'

              Get_Token() ;

            } // if()
            else { // 不是 ']'
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
              } // if()

              // System.out.println("===== Fake_Formal_parameter_list() 1 =====") ;
              return false ;
            } // else()

          } // if()
          else { // 不是 Constant
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()

            // System.out.println("===== Fake_Formal_parameter_list() 2 =====") ;
            return false ;
          } // else()

        } // if()
        else { // 沒有 array
          if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id

          } // if()
          else { // 新定義

          } // else()
        } // else()
        // 以上為可要可不要
        
      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Formal_parameter_list() 3 =====") ;
        return false ;
      } // else()

    } // if()

    boolean breakk = false ;

    for ( ; !breakk ; ) { // 執行 0 到 多次

      if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;

        if ( Fake_Type_specifier() ) { // 如果是 Type_specifier()

          // 以下為可要可不要
          if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'

            Get_Token() ;
          } // if()
          // 以上為可要可不要

          if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id

            Get_Token() ;

            // 以下為可要可不要
            if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['

              Get_Token() ;

              if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
                
                Get_Token() ;

                if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'

                  Get_Token() ;

                } // if()
                else { // 不是 ']'
                  if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                  } // if()

                  // System.out.println("===== Fake_Formal_parameter_list() 4 =====") ;
                  return false ;
                } // else()
                
              } // if()
              else { // 不是 Constant
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                  // 就設定錯誤
                  Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                } // if()

                // System.out.println("===== Fake_Formal_parameter_list() 5 =====") ;
                return false ;
              } // else()

            } // if()
            else {

            } // else()
            // 以上為可要可不要
            
          } // if()
          else { // 不是 id
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()

            // System.out.println("===== Fake_Formal_parameter_list() 6 =====") ;
            return false ;
          } // else()

        } // if()
        else { // 不是 Type_specifier()
          // 因為在 Type_specifier() 沒有 print error
          // 所以這裡要 print error 
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Formal_parameter_list() 7 =====") ;
          return false ;
        } // else()
      } // if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 不讀掉 ')'
        // 表示已結束

        breakk = true ;
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Formal_parameter_list() 8 =====") ;
        return false ;
      } // else()

    } // for()

    if ( breakk ) {
      return true ;
    } // if()
    else {
      return false ;
    } // else()
        
  } // Fake_Formal_parameter_list()
    
    private boolean Fake_Compound_statement() {
        
    if ( Get_Now_Token_Tpye() == LBP ) { // 如果是 '{'

      Get_Token() ;

      Set_My_Glo_Or_Loc_Id_Length( 1 ) ; // 進入一個 {} 了

      boolean breakk = false ;

      for ( ; !breakk ; ) {

        if ( Get_Now_Token_Tpye() == RBP ) { // 如果是 '}'
          // 先不要拿
          breakk = true ;
        } // if()
        else if ( Fake_Declaration() ) { // 如果是 Fake_Declaration()

        } // else if()
        else if ( Fake_Statement() ) { // 如果是 Fake_Statement()

        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;

          } // if()

          // System.out.println("===== Fake_Compound_statement() 1 =====") ;

          // 竟然沒有 '}'
          // 表示有 '{' 沒 '}'
          // 所以要扣掉
          Set_My_Glo_Or_Loc_Id_Length( -1 ) ;

          return false ;
        } // else()
      } // for()

      if ( Get_Now_Token_Tpye() == RBP ) { // 如果是 '}'

        Get_Token() ;

        Set_My_Glo_Or_Loc_Id_Length( -1 ) ;

        return true ;
      } // if()
      else { // 不是 '}'
        // 照理不可能進這
        // 如果要進這 
        // 那應該在上面的 for 就會進 else
        // 而 return false
        // Print( "Class_Grammar --> Fake_Function_Compound_statement !!!" ) ;
        return false ;
      } // else()

    } // if()
    else { // 不是 '{'

      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()

      // System.out.println("===== Fake_Compound_statement() 2 =====") ;
      return false ;
    } // else()
        
  } // Fake_Compound_statement()
    
    private boolean Fake_Declaration() {
        
    String save_id = "" ; // 定義的 id

    if ( Fake_Type_specifier() ) { // 如果是 Type_specifier()

      int type = Get_Id_Type() ; // 取得型別

      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id

        save_id = Return_Token() ; // 暫存此 id

        Get_Token() ;

        if ( Fake_Rest_of_declarators( save_id, type ) ) { // 如果 Fake_Rest_of_declarators()

          return true ;
        } // if()
        else { // 不是 Fake_Rest_of_declarators()
          return false ;
        } // else()

      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Declaration() 1 =====") ;
        return false ;
      } // else()

    } // if()
    else { // 不是 Fake_Type_specifier()
      return false ;
    } // else()
        
  } // Fake_Declaration()
    
    private boolean Fake_Statement() {
        
    if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
      Get_Token() ;
      return true ;
    } // if()
    else if ( Get_Now_Token_Tpye() == RETURN ) { // 如果是 return
      Get_Token() ;
      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        Get_Token() ;
        return true ;
      } // if()
      else if ( Fake_Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          Get_Token() ;
          return true ;
        } // if()
        else { // 不是 ';'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Statement() 2 =====") ;
          return false ;
        } // else()
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Statement() 3 =====") ;
        return false ;
      } // else()

    } // else if()
    else if ( Get_Now_Token_Tpye() == IF ) { // 如果是 if
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
        Get_Token() ;
        if ( Fake_Expression() ) { // 如果是 Expression()
          if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
            Get_Token() ;
            if ( Fake_Statement() ) { // 如果是 Statement()

              // 以下為可要可不要
              if ( Get_Now_Token_Tpye() == ELSE ) { // 如果是 else
                Get_Token() ;
                if ( Fake_Statement() ) { // 如果是 Statement()
                  return true ;
                } // if()
                else { // 不是 Fake_Statement()
                  return false ;
                } // else()

              } // if()
              else { // 表示沒有 else
                return true ;
              } // else()
              // 以上為可要可不要
            } // if()
            else { // 不是 Statement()
              return false ;
            } // else()

          } // if()
          else { // 不是 ')'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()

            // System.out.println("===== Fake_Statement() 5 =====") ;
            return false ;
          } // else()

        } // if()
        else { // 不是 Fake_Expression()
          return false ;
        } // else()
      } // if()
      else { // 不是 '('
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Statement() 6 =====") ;
        return false ;
      } // else()

    } // else if()
    else if ( Get_Now_Token_Tpye() == WHILE ) { // 如果是 while
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
        Get_Token() ;
        if ( Fake_Expression() ) { // 如果是 Expression()
          if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
            Get_Token() ;
            if ( Fake_Statement() ) { // 如果是 Fake_Statement()
              return true ;
            } // if()
            else { // 不是 Fake_Statement()
              return false ;
            } // else()

          } // if()
          else { // 不是 ')'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()

            // System.out.println("===== Fake_Statement() 7 =====") ;
            return false ;
          } // else()

        } // if()
        else { // 不是 Fake_Expression()
          return false ;
        } // else()
      } // if()
      else { // 不是 '('
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Statement() 8 =====") ;
        return false ;
      } // else()

    } // else if()
    else if ( Get_Now_Token_Tpye() == DO ) { // 如果是 do
      Get_Token() ;
      if ( Fake_Statement() ) { // 如果是 Statement()

        if ( Get_Now_Token_Tpye() == WHILE ) { // 如果是 while
          Get_Token() ;
          if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
            Get_Token() ;
            if ( Fake_Expression() ) { // 如果是 Expression()
              if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
                Get_Token() ;
                if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
                  Get_Token() ;
                  return true ;
                } // if()
                else { // 不是 ';'
                  if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                  } // if()

                  // System.out.println("===== Fake_Statement() 9 =====") ;
                  return false ;
                } // else()

              } // if()
              else { // 不是 ')'
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                  // 就設定錯誤
                  Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                } // if()

                // System.out.println("===== Fake_Statement() 10 =====") ;
                return false ;
              } // else()

            } // if()
            else { // 不是 Fake_Expression()
              return false ;
            } // else()
          } // if()
          else { // 不是 '('
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()

            // System.out.println("====== Fake_Statement() 11 =====") ;
            return false ;
          } // else()

        } // if()
        else { // 不是 while
          return false ;
        } // else()

      } // if()
      else { // 不是 Fake_Statement()
        return false ;
      } // else()

    } // else if()
    else if ( Get_Now_Token_Tpye() == LBP ) { // 如果是 '{'
      // 就有可能是 Compound_statement()
      // 先不讀掉 '{'
      if ( Fake_Compound_statement() ) { // 如果是 Fake_Compound_statement()
        return true ;
      } // if()
      else { // 不是 Fake_Compound_statement()
        return false ;
      } // else()

    } // else if()
    else if ( Get_Now_Token_Tpye() == ID 
              || Get_Now_Token_Tpye() == PP
              || Get_Now_Token_Tpye() == MM
              || Get_Now_Token_Tpye() == CONSTANT
              || Get_Now_Token_Tpye() == LP
              || Get_Now_Token_Tpye() == ADD
              || Get_Now_Token_Tpye() == SUB
              || Get_Now_Token_Tpye() == NOT ) {

      if ( Fake_Expression() ) { // 如果是 Expression()

        if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          Get_Token() ;
          return true ;
        } // if()
        else { // 不是 ';'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Statement() 12 =====") ;
          return false ;
        } // else()

      } // if()
      else {
        return false ;
      } // else()

    } // else if()
    else { // 都不是
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()

      // System.out.println("===== Fake_Statement() 13 =====") ;
      return false ;
    } // else()
        
  } // Fake_Statement()
    
    private boolean Fake_Expression() {
        
    if ( Fake_Basic_expression() ) { // 如果是 Basic_expression()

      for ( ; ; ) {
        if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','

          Get_Token() ;

          if ( Fake_Basic_expression() ) { // 如果是 Fake_Basic_expression()

          } // if()
          else { // 不是 Fake_Basic_expression()
            return false ;
          } // else()

        } // if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Expression() 1 =====") ;
          return false ;
        } // else()
      } // for()

    } // if()
    else { // 不是 Fake_Basic_expression()
      return false ;
    } // else()
        
        
  } // Fake_Expression()
    
    private boolean Fake_Basic_expression() {
        
    String save_id = "" ;

    if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
      save_id = Return_Token() ; // 暫存此 id
      Get_Token() ;
      if ( Return_Done_Num() != 1 
           && !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
        // 且不是 Done();

        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( save_id, ID, true ) ;
        } // if()

        // System.out.println("===== Fake_Basic_expression() 1 =====") ;
        return false ;
      } // if()

      if ( Fake_Rest_of_Identifier_started_basic_exp() ) { // 如果是 Fake_Rest_of_Identifier_started_basic_exp()
        return true ;
      } // if()
      else { // 不是 Fake_Rest_of_Identifier_started_basic_exp()
        return false ;
      } // else()

    } // if()
    else if ( Get_Now_Token_Tpye() == PP 
              || Get_Now_Token_Tpye() == MM ) { // 如果是 ++ 或 --
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
        save_id = Return_Token() ; // 暫存此 id
        Get_Token() ;
        if ( Return_Done_Num() != 1 
             && !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
          // 且不是 Done();

          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( save_id, ID, true ) ;
          } // if()

          // System.out.println("===== Fake_Basic_expression() 2 =====") ;

          return false ;
        } // if()

        if ( Fake_Rest_of_PPMM_Identifier_started_basic_exp() ) { 
          return true ;
        } // if()
        else { // 不是 Fake_Rest_of_PPMM_Identifier_started_basic_exp()
          return false ;
        } // else()
      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Basic_expression() 3 =====") ; 
        return false ;
      } // else()

    } // else if

    else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
      Get_Token() ;
      if ( Fake_Romce_and_romloe() ) { // 如果是 Fake_Romce_and_romloe()
        return true ;
      } // if()
      else { // 不是 Fake_Romce_and_romloe()
        return false ;
      } // else()
    } // else if()
    else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      Get_Token() ;
      if ( Fake_Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Get_Token() ;
          if ( Fake_Romce_and_romloe() ) { // 如果是 Fake_Romce_and_romloe()
            return true ;
          } // if()
          else { // 不是 Fake_Romce_and_romloe()
            return false ;
          } // else()

        } // if()
        else { // 不是 ')'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // Print("===== Fake_Basic_expression() 4 =====") ;
          return false ;
        } // else()

      } // if()
      else { // 不是 Fake_Expression()
        return false ;
      } // else()

    } // else if()
    else if ( Fake_Sign() ) { // 如果是 Fake_sign()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ID ) { // 如果是 ID
          // 先不要拿
          breakk = true ;
        } // if()
        else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 CONSTANT
          // 先不要拿
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
          // 先不要拿
          breakk = true ;
        } // else if()
        else if ( Fake_Sign() ) { // 如果是 sign()
        } // else if()
        else { // 不是 sign()
          breakk = true ;
        } // else()

      } // for()

      if ( Fake_Signed_unary_exp() ) { // 如果是 Fake_Signed_unary_exp()
        if ( Fake_Romce_and_romloe() ) { // 如果是 Fake_Romce_and_romloe()
          return true ;
        } // if()
        else { // 不是 Fake_Romce_and_romloe()
          return false ;
        } // else()
      } // if()
      else { // 不是 Fake_Signed_unary_exp()
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      // 不用印錯誤 // 因為 Fake_Sign() 已經印過了
      return false ;
    } // else()
        
  } // Fake_Basic_expression()
    
    private boolean Fake_Rest_of_Identifier_started_basic_exp() {
        
    // 以下為可要可不要
    if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
      Get_Token() ;
      if ( Fake_Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          Get_Token() ;
        } // if()
        else { // 不是 ']'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_Identifier_started_basic_exp() 1 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()
    } // if()
    // 以上為可要可不要

    // 以下為可要可不要
    if ( Get_Now_Token_Tpye() == PP
         || Get_Now_Token_Tpye() == MM ) { // 如果是 ++ 或 --
      Get_Token() ;
      if ( Fake_Romce_and_romloe() ) { // 如果是 Fake_Romce_and_romloe()
        return true ;
      } // if()
      else { // 不是 Fake_Romce_and_romloe()
        return false ;
      } // else()
    } // if()

    // ===================== 以下為 Function 呼叫 暫不理它 =====================

    // 以上為可要可不要
    else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      Get_Token() ;
      // 以下為可要可不要
      if ( Actual_parameter_list() ) { // 如果是 Actual_parameter_list()

      } // if()
      // 以上為可要可不要

      if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        Get_Token() ;
        if ( Fake_Romce_and_romloe() ) { // 如果是 Fake_Romce_and_romloe()
          return true ;
        } // if()
        else { // 不是 Fake_Romce_and_romloe()
          return false ;
        } // else()
      } // if()
      else { // 不果是 ')'
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Rest_of_Identifier_started_basic_exp() 2 =====") ;
        return false ;
      } // else()
    } // else if()
    else if ( Fake_Assignment_operator() ) { // 如果是 Fake_Assignment_operator()
      if ( Fake_Basic_expression() ) { // 如果是 Fake_Basic_expression()
        return true ;
      } // if()
      else { // 不是 Fake_Basic_expression()
        return false ;
      } // else()

    } // else if()
    else if ( Fake_Romce_and_romloe() ) { // 如果是 Fake_Romce_and_romloe()
      return true ;
    } // else if()
    else { // 都不是
      // 不用印錯誤 // Fake_Romce_and_romloe() 已經印過
      return false ;
    } // else()
        
  } // Fake_Rest_of_Identifier_started_basic_exp()
    
    private boolean Fake_Rest_of_PPMM_Identifier_started_basic_exp() {
        
    // 以下為可要可不要
    if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
      Get_Token() ;
      if ( Fake_Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          Get_Token() ;
        } // if()
        else { // 不是 ']'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_PPMM_Identifier_started_basic_exp() 1 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()

    } // if()
    // 以上為可要可不要
    else { // 沒有陣列
    } // else()

    // 上面的 Id 陣列要丟給 Fake_Romce_and_romloe()
    if ( Fake_Romce_and_romloe() ) { // 如果是 Fake_Romce_and_romloe()
      return true ;
    } // if()
    else { // 不是 Fake_Romce_and_romloe()
      return false ;
    } // else()
        
  } // Fake_Rest_of_PPMM_Identifier_started_basic_exp()
    
    private boolean Fake_Sign() {
        
    if ( Get_Now_Token_Tpye() == ADD ) { // 如果是 '+'

      Get_Token() ;

      return true ;
    } // if()
    else if ( Get_Now_Token_Tpye() == SUB ) { // 如果是 '-'

      Get_Token() ;

      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == NOT ) { // 如果是 '!'

      Get_Token() ;


      return true ;
    } // else if()
    else { // 都不是
      if ( Return_Done_Num() == 0 ) { // 如果不是 Done();
        // 再 print error

        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Sign() 1 =====") ;

      } // if()

      return false ;
    } // else()
  } // Fake_Sign()
    
    private boolean Fake_Actual_parameter_list() {
        
    if ( Fake_Basic_expression() ) { // 如果是 Basic_expression()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          Get_Token() ;
          if ( Fake_Basic_expression() ) { // 如果是 Basic_expression()
          } // if()
          else { // 不是 Basic_expression()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Actual_parameter_list() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) { 
        return true ;
      } // if()
      else { // 不是 ')'
        return false ;
      } // else()

    } // if()
    else { // 不是 Fake_Basic_expression()
      return false ;
    } // else()
        
  } // Fake_Actual_parameter_list()
    
    private boolean Fake_Assignment_operator() {
        
    if ( Get_Now_Token_Tpye() == SMALL_EQU ) { // 如果是 '='
      Get_Token() ;
      return true ;
    } // if()
    else if ( Get_Now_Token_Tpye() == TE ) { // 如果是 '*='
      Get_Token() ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == DE ) { // 如果是 '/='
      Get_Token() ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == RE ) { // 如果是 '%='
      Get_Token() ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == PE ) { // 如果是 '+='
      Get_Token() ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == ME ) { // 如果是 '-='
      Get_Token() ;
      return true ;
    } // else if()
    else { // 都不是
      // ==================== 這裡不用印錯誤 !? ======================================================
      return false ;
    } // else()
        
  } // Fake_Assignment_operator()
    
    private boolean Fake_Romce_and_romloe() {
        
    if ( Fake_Rest_of_maybe_logical_OR_exp() ) { // 如果是 Fake_Rest_of_maybe_logical_OR_exp()

      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
        Get_Token() ;
        if ( Fake_Basic_expression() ) { // 如果是 Fake_Basic_expression()
          if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
            Get_Token() ;
            if ( Fake_Basic_expression() ) { // 如果是 Fake_Basic_expression()
              return true ;
            } // if()
            else { // 不是 Fake_Basic_expression()
              return false ;
            } // else()
          } // if()
          else { // 不是 ':'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
            // System.out.println("===== Fake_Romce_and_romloe() 1 =====") ;
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Romce_and_romloe() 2 =====") ;
          return false ;
        } // else()

      } // if()
      // 以上為可要可不要
      else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
        // 先不要讀掉
        return true ;
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Romce_and_romloe() 3 =====") ;
        return false ;
      } // else()
    } // if()
    else { // 不是 Rest_of_maybe_logical_OR_exp()
      return false ;
    } // else()
        
  } // Fake_Romce_and_romloe()
    
    private boolean Fake_Rest_of_maybe_logical_OR_exp() {
        
    if ( Fake_Rest_of_maybe_logical_AND_exp() ) { // 如果是 Fake_Rest_of_maybe_logical_AND_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          Get_Token() ;
          if ( Fake_Maybe_logical_AND_exp() ) { // 如果是 Fake_Maybe_logical_AND_exp()
          } // if()
          else { // 不是 Fake_Maybe_logical_AND_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_maybe_logical_OR_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Rest_of_maybe_logical_AND_exp()
      return false ;
    } // else()
        
  } // Fake_Rest_of_maybe_logical_OR_exp()
    
    private boolean Fake_Maybe_logical_AND_exp() {
        
    if ( Fake_Maybe_bit_OR_exp() ) { // 如果是 Maybe_bit_OR_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          Get_Token() ;
          if ( Fake_Maybe_bit_OR_exp() ) { // 如果是 Maybe_bit_OR_exp()
          } // if()
          else { // 不是 Maybe_bit_OR_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Maybe_logical_AND_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Maybe_bit_OR_exp()
      return false ;
    } // else()
        
  } // Fake_Maybe_logical_AND_exp()
    
    private boolean Fake_Rest_of_maybe_logical_AND_exp() {
        
    if ( Fake_Rest_of_maybe_bit_OR_exp() ) { // 如果是 Rest_of_maybe_bit_OR_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          Get_Token() ;
          if ( Fake_Maybe_bit_OR_exp() ) { // 如果是 Maybe_bit_OR_exp()
          } // if()
          else { // 不是 Maybe_bit_OR_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_maybe_logical_AND_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Rest_of_maybe_bit_OR_exp()
      return false ;
    } // else()
        
  } // Fake_Rest_of_maybe_logical_AND_exp()
    
    private boolean Fake_Maybe_bit_OR_exp() {
        
    if ( Fake_Maybe_bit_ex_OR_exp() ) { // 如果是 Maybe_bit_ex_OR_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          Get_Token() ;
          if ( Fake_Maybe_bit_ex_OR_exp() ) { // 如果是 Maybe_bit_ex_OR_exp()
          } // if()
          else { // 不是 Maybe_bit_ex_OR_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 '&&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()
          // System.out.println("===== Fake_Maybe_bit_OR_exp() 1 =====") ;
          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Maybe_bit_ex_OR_exp()
      return false ;
    } // else()
        
  } // Fake_Maybe_bit_OR_exp()
    
    private boolean Fake_Rest_of_maybe_bit_OR_exp() {
        
    if ( Fake_Rest_of_maybe_bit_ex_OR_exp() ) { // 如果是 Rest_of_maybe_bit_ex_OR_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          Get_Token() ;
          if ( Fake_Maybe_bit_ex_OR_exp() ) { // 如果是 Maybe_bit_ex_OR_exp()
          } // if()
          else { // 不是 Maybe_bit_ex_OR_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_maybe_bit_OR_exp() =====") ;
          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Maybe_bit_ex_OR_exp()
      return false ;
    } // else()
        
        
  } // Fake_Rest_of_maybe_bit_OR_exp()
    
    private boolean Fake_Maybe_bit_ex_OR_exp() {
        
    if ( Fake_Maybe_bit_AND_exp() ) { // 如果是 Maybe_bit_AND_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          Get_Token() ;
          if ( Fake_Maybe_bit_AND_exp() ) { // 如果是 Maybe_bit_AND_exp()
          } // if()
          else { // 不是 Maybe_bit_AND_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Maybe_bit_ex_OR_exp 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()

    } // if()
    else { // 不是 Maybe_bit_AND_exp()
      return false ;
    } // else()
        
  } // Fake_Maybe_bit_ex_OR_exp()
    
    private boolean Fake_Rest_of_maybe_bit_ex_OR_exp() {
        
    if ( Fake_Rest_of_maybe_bit_AND_exp() ) { // 如果是 Rest_of_maybe_bit_AND_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          Get_Token() ;
          if ( Fake_Maybe_bit_AND_exp() ) { // 如果是 Maybe_bit_AND_exp()
          } // if()
          else { // 不是 Maybe_bit_AND_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_maybe_bit_ex_OR_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Rest_of_maybe_bit_AND_exp()
      return false ;
    } // else()
        
  } // Fake_Rest_of_maybe_bit_ex_OR_exp()
    
    private boolean Fake_Maybe_bit_AND_exp() {
        
    if ( Fake_Maybe_equality_exp() ) { // 如果是 Maybe_equality_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          Get_Token() ;
          if ( Fake_Maybe_equality_exp() ) { // 如果是 Maybe_equality_exp()
          } // if()
          else { // 不是 Fake_Maybe_equality_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Maybe_bit_AND_exp() 1 =====") ;
          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Maybe_equality_exp()
      return false ;
    } // else()
        
  } // Fake_Maybe_bit_AND_exp()
    
    private boolean Fake_Rest_of_maybe_bit_AND_exp() {
        
    if ( Fake_Rest_of_maybe_equality_exp() ) { // 如果是 Rest_of_maybe_equality_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          Get_Token() ;
          if ( Fake_Maybe_equality_exp() ) { // 如果是 Maybe_equality_exp()
          } // if()
          else { // 不是 Fake_Maybe_equality_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_maybe_bit_AND_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Rest_of_maybe_equality_exp()
      return false ;
    } // else()
        
  } // Fake_Rest_of_maybe_bit_AND_exp()
    
    private boolean Fake_Maybe_equality_exp() {
        
    if ( Fake_Maybe_relational_exp() ) { // 如果是 Maybe_relational_exp()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == EQ
             || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          Get_Token() ;
          if ( Fake_Maybe_relational_exp() ) { // 如果是 Maybe_relational_exp()
          } // if()
          else { // 不是 Maybe_relational_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          // System.out.println("===== Fake_Maybe_equality_exp() 1 =====") ;
          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Maybe_relational_exp()
      return false ;
    } // else()
        
  } // Fake_Maybe_equality_exp()
    
    private boolean Fake_Rest_of_maybe_equality_exp() {
        
    if ( Fake_Rest_of_maybe_relational_exp() ) { // 如果是 Rest_of_maybe_relational_exp()

      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == EQ
             || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          Get_Token() ;
          if ( Fake_Maybe_relational_exp() ) { // 如果是 Maybe_relational_exp()  
          } // if()
          else { // 不是 Maybe_relational_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_maybe_equality_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Rest_of_maybe_relational_exp()
      return false ;
    } // else()
        
        
  } // Fake_Rest_of_maybe_equality_exp()
    
    private boolean Fake_Maybe_relational_exp() {
        
    if ( Fake_Maybe_shift_exp() ) { // 如果是 Maybe_shift_exp()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ST
             || Get_Now_Token_Tpye() == BT
             || Get_Now_Token_Tpye() == LE
             || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          Get_Token() ;
          if ( Fake_Maybe_shift_exp() ) { // 如果是 Fake_Maybe_shift_exp()
          } // if()
          else { // 不是 Fake_Maybe_shift_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Maybe_relational_exp() 1 =====") ;
          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Maybe_shift_exp()
      return false ;
    } // else()
        
  } // Fake_Maybe_relational_exp()
    
    private boolean Fake_Rest_of_maybe_relational_exp() {
        
    if ( Fake_Rest_of_maybe_shift_exp() ) { // 如果是 Fake_Rest_of_maybe_shift_exp()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ST
             || Get_Now_Token_Tpye() == BT
             || Get_Now_Token_Tpye() == LE
             || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          Get_Token() ;
          if ( Fake_Maybe_shift_exp() ) { // 如果是 Maybe_shift_exp()
          } // if()
          else { // 不是 Maybe_shift_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_maybe_relational_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Rest_of_maybe_shift_exp()
      return false ;
    } // else()
        
  } // Fake_Rest_of_maybe_relational_exp()
    
    private boolean Fake_Maybe_shift_exp() {
        
    if ( Fake_Maybe_additive_exp() ) { // 如果是 Maybe_additive_exp()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == LS
             || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          Get_Token() ;
          if ( Fake_Maybe_additive_exp() ) { // 如果是 Maybe_additive_exp()
          } // if()
          else { // 不是 Fake_Maybe_additive_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Maybe_shift_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Maybe_additive_exp()
      return false ;
    } // else()
        
  } // Fake_Maybe_shift_exp()
    
    private boolean Fake_Rest_of_maybe_shift_exp() {
        
    if ( Fake_Rest_of_maybe_additive_exp() ) { // 如果是 Rest_of_maybe_additive_exp()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == LS
             || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          Get_Token() ;
          if ( Fake_Maybe_additive_exp() ) { // 如果是 Maybe_additive_exp()
          } // if()
          else { // 不是 Fake_Maybe_additive_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Rest_of_maybe_shift_exp() 1 =====") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Rest_of_maybe_additive_exp()
      return false ;
    } // else()
        
  } // Fake_Rest_of_maybe_shift_exp()
    
    private boolean Fake_Maybe_additive_exp() {
        
    if ( Fake_Maybe_mult_exp() ) { // 如果是 Maybe_mult_exp()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ADD
             || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
          Get_Token() ;
          if ( Fake_Maybe_mult_exp() ) { // 如果是 Maybe_mult_exp()
          } // if()
          else { // 不是 Maybe_mult_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == LS
                  || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // Print("Fake_Maybe_additive_exp() 1") ;
          return false ;
        } // else()

      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()
    } // if()
    else { // 不是 Fake_Maybe_mult_exp()
      return false ;
    } // else()
        
  } // Fake_Maybe_additive_exp()
    
    private boolean Fake_Rest_of_maybe_additive_exp() {
        
    if ( Fake_Rest_of_maybe_mult_exp() ) { // 如果是 Rest_of_maybe_mult_exp()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ADD
             || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
          Get_Token() ;
          if ( Fake_Maybe_mult_exp() ) { // 如果是 Maybe_mult_exp()
          } // if()
          else { // 不是 Maybe_mult_exp()
            return false ;
          } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == LS
                  || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // Print("====== Fake_Rest_of_maybe_additive_exp_Error ======") ;

          return false ;
        } // else()
      } // for()

      if ( breakk ) {
        return true ;
      } // if()
      else {
        return false ;
      } // else()

    } // if()
    else { // 不是 Maybe_mult_exp()
      return false ;
    } // else()
        
  } // Fake_Rest_of_maybe_additive_exp()
    
    private boolean Fake_Maybe_mult_exp() {
    if ( Fake_Unary_exp() ) { // 如果是 Unary_exp()
      if ( Fake_Rest_of_maybe_mult_exp() ) { // 如果是 Rest_of_maybe_mult_exp()
        return true ;
      } // if()
      else { // 不是 Rest_of_maybe_mult_exp()
        return false ;
      } // else()
    } // if()
    else { // 不是 Unary_exp()
      return false ;
    } // else()
  } // Fake_Maybe_mult_exp()
    
    private boolean Fake_Rest_of_maybe_mult_exp() {
        
    boolean breakk = false ;
    // 以下的 for 可以不要進
    for ( ; !breakk ; ) {
      if ( Get_Now_Token_Tpye() == MUL
           || Get_Now_Token_Tpye() == DIV
           || Get_Now_Token_Tpye() == PA ) { // 如果是 '*' 或 '/' 或 '%'
        Get_Token() ;
        if ( Fake_Unary_exp() ) { // 如果是 Unary_exp()
        } // if()
        else { // 不是 Unary_exp()
          return false ;
        } // else()
      } // if()
      else if ( Get_Now_Token_Tpye() == ADD
                || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == LS
                || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == ST
                || Get_Now_Token_Tpye() == BT
                || Get_Now_Token_Tpye() == LE
                || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == EQ
                || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 '||'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        // 先不要讀掉
        breakk = true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
        // 先不要讀掉
        return true ;
      } // else if()
      else { // 都不是
        // 但因為可以不要進
        return true ;
      } // else()

    } // for()

    if ( breakk ) {
      return true ;
    } // if()
    else {
      // 不可能進這
      // Print("Fake_Rest_of_maybe_mult_exp() Error") ;
      return false ;
    } // else()
        
  } // Fake_Rest_of_maybe_mult_exp()
    
    private boolean Fake_Unary_exp() {
    String save_id = "" ;
    if ( Get_Now_Token_Tpye() == PP
         || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
      Get_Token() ;
      if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
        save_id = Return_Token() ; // 暫存此 id 
        Get_Token() ;
        if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( save_id, ID, true ) ;
          } // if()

          // System.out.println("===== Fake_Unary_exp() 1 =====") ;
          return false ;
        } // if()

        // 以下為可要可不要
        if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
          Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
          Get_Token() ;
          if ( Fake_Expression() ) { // 如果是 Expression()
            if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']' 
              Get_Token() ;
              return true ;
            } // if()
            else { // 不是 ']'
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
              } // if()

              // System.out.println("===== Fake_Unary_exp() 2 =====") ;
              return false ;
            } // else()
          } // if()
          else { // 不是 Fake_Expression()
            return false ;
          } // else()
        } // if()
        // 以上為可要可不要
        else if ( Get_Now_Token_Tpye() == MUL
                  || Get_Now_Token_Tpye() == DIV
                  || Get_Now_Token_Tpye() == PA ) { // 如果是 '*' 或 '/' 或 '%'
           // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ADD
                  || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == LS
                  || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ST
                  || Get_Now_Token_Tpye() == BT
                  || Get_Now_Token_Tpye() == LE
                  || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == EQ
                  || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
          // 先不要讀掉
          return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
          // 先不要讀掉
          return true ;
        } // else if()
        else { // 都不是
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Unary_exp() 3 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 id
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Unary_exp() 4 =====") ;
        return false ;
      } // else()
    } // if()
    else if ( Get_Now_Token_Tpye() == ID 
              || Get_Now_Token_Tpye() == CONSTANT
              || Get_Now_Token_Tpye() == LP ) { // 如果是 ID 或是 constant 或是 '('
      // 先不要拿
      if ( Fake_Unsigned_unary_exp() ) { // 如果是 Unsigned_unary_exp()
        return true ;
      } // if()
      else { // 不是 Fake_Unsigned_unary_exp()
        return false ;
      } // else()

    } // else if()
    else if ( Fake_Sign() ) { // 如果是 Fake_sign()
      boolean breakk = false ;
      for ( ; !breakk ; ) {
        if ( Get_Now_Token_Tpye() == ID ) { // 如果是 ID
          // 先不要拿
          breakk = true ;
        } // if()
        else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 CONSTANT
          // 先不要拿
          breakk = true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
          // 先不要拿
          breakk = true ;
        } // else if()
        else if ( Fake_Sign() ) { // 如果是 Fake_sign()

        } // else if()
        else { // 不是 sign()
          breakk = true ;
        } // else()
      } // for()

      if ( Fake_Signed_unary_exp() ) { // 如果是 Fake_Signed_unary_exp()
        return true ;
      } // if()
      else { // 不是 Fake_Signed_unary_exp()
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      return false ;
    } // else()
              
  } // Fake_Unary_exp()
    
    private boolean Fake_Signed_unary_exp() {
    String save_id = "" ;
    if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
      save_id = Return_Token() ; // 暫存此 id 
      Get_Token() ;
      if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( save_id, ID, true ) ;
        } // if()

        // System.out.println("===== Fake_Signed_unary_exp() 1 =====") ;
        return false ;
      } // if()

      if ( Get_Now_Token_Tpye() == COMMA 
           || Get_Now_Token_Tpye() == LMP
           || Get_Now_Token_Tpye() == LP ) { // 如果下一個 Token 是 ','
        // 或是 '[' // 或 '('
      } // if()
      else { // 不是 ',' 也不是 '['
        // 就要空格
      } // else()

      // 以下為 Function 暫時不處理
      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
        Get_Token() ;
        // 以下為可要可不要
        if ( Fake_Actual_parameter_list() ) { // 如果是 Actual_parameter_list()
        } // if()
        // 以上為可要可不要

        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Get_Token() ;
          return true ;
        } // if()
        else { // 不是 ')'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Signed_unary_exp() 2 =====") ;
          return false ;
        } // else()
      } // if()
      else if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
        Get_Token() ;
        if ( Fake_Expression() ) { // 如果是 Expression()
          if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
            Get_Token() ;
            return true ;
          } // if()
          else { // 不是 ']'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()

            // System.out.println("===== Fake_Signed_unary_exp() 3 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 不是 Expression()
          return false ;
        } // else()

      } // else if()
        // 以上為可要可不要
      else if ( Get_Now_Token_Tpye() == ADD
                || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == MUL
                || Get_Now_Token_Tpye() == DIV
                || Get_Now_Token_Tpye() == PA ) { // 如果是 '8' 或 '/' 或 '%'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == LS
                || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == ST
                || Get_Now_Token_Tpye() == BT
                || Get_Now_Token_Tpye() == LE
                || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == EQ
                || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
        // 先不要讀掉
        return true ;
      } // else if()
      else { // 都不是
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Signed_unary_exp() 4 =====") ;

        return false ;
      } // else()
    } // if()
    else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
      Get_Token() ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      Get_Token() ;
      if ( Fake_Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Get_Token() ;
          return true ;
        } // if()
        else { // 不是 ')'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Signed_unary_exp() 5 =====") ;
          return false ;
        } // else()
      } // if()
      else { // 不是 Fake_Expression()
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()
      // System.out.println("===== Fake_Signed_unary_exp() 6 =====") ;
      return false ;
    } // else()
  } // Fake_Signed_unary_exp()
    
    private boolean Fake_Unsigned_unary_exp() {
        
    String save_id = "" ;
    if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
      save_id = Return_Token() ; // 暫存此 id 
      Get_Token() ;
      if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
        // 且 不是 Function
        // 那肯定是 Id 未定義
        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( save_id, ID, true ) ;
        } // if()
        // System.out.println("===== Fake_Unsigned_unary_exp() 1 =====") ;
        return false ;
      } // if()

      if ( Get_Now_Token_Tpye() == COMMA 
           || Get_Now_Token_Tpye() == LMP 
           || Get_Now_Token_Tpye() == PP
           || Get_Now_Token_Tpye() == MM
           || Get_Now_Token_Tpye() == LP ) { // 如果下一個 Token 是 ','
        // 或是 '[' // 或 '('
      } // if()
      else { // 不是 ',' 也不是 '['
        // 就要空格
      } // else()

      // 以下為 Function 呼叫 // 暫不處理
      // 以下為可要可不要
      if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
        String save_token = "" ;
        save_token = Return_Token() ;
        Get_Token() ;
        // 以下為可要可不要
        if ( Get_Now_Token_Tpye() == ID
             || Get_Now_Token_Tpye() == PP || Get_Now_Token_Tpye() == MM
             || Get_Now_Token_Tpye() == CONSTANT || Get_Now_Token_Tpye() == ADD
             || Get_Now_Token_Tpye() == SUB || Get_Now_Token_Tpye() == NOT ) {
          // 如果這這幾個 Token
          // 才有可能是 Actual_parameter_list()
          if ( Fake_Actual_parameter_list() ) { // 如果是 Actual_parameter_list()
          } // if()
          else { // 不是 Actual_parameter_list()
            // 不可能進這裡
            // Print("Fake_Unsigned_unary_exp()_Error") ;
            return false ;
          } // else()
        } // if()
        // 以上為可要可不要

        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Get_Token() ;
          if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { 
            // 如果此 id 未定義過
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( save_id, ID, true ) ;
            } // if()
            // System.out.println("===== Fake_Unsigned_unary_exp() 2 =====") ;
            return false ;
          } // if()

          return true ;
        } // if()
        else { // 不是 ')'
          if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
            // 就設定錯誤
            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
          } // if()

          // System.out.println("===== Fake_Unsigned_unary_exp() 3 =====") ;
          return false ;
        } // else()
      } // if()
      // 以下為陣列處理 
      else if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
        Get_Token() ;
        if ( Fake_Expression() ) { // 如果是 Expression()
          if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
            Get_Token() ;
            if ( Get_Now_Token_Tpye() == PP
                 || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
              // 就不要空格
            } // if()
            else {
              Set_My_Now_Func_String( save_id, 1 ) ; // 存當下的 Function
            } // else()

            // 以下為可要可不要
            if ( Get_Now_Token_Tpye() == PP
                 || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
              Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
              Get_Token() ;
              return true ;
            } // if()
            // 以上為可要可不要
            else if ( Get_Now_Token_Tpye() == ADD
                      || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == MUL
                      || Get_Now_Token_Tpye() == DIV
                      || Get_Now_Token_Tpye() == PA ) { // 如果是 '8' 或 '/' 或 '%'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == LS
                      || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == ST
                      || Get_Now_Token_Tpye() == BT
                      || Get_Now_Token_Tpye() == LE
                      || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == EQ
                      || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
              // 先不要讀掉
              return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
              // 先不要讀掉
              return true ;
            } // else if()
            else { // 都不是
              if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
              } // if()

              // System.out.println("===== Fake_Unsigned_unary_exp() 4 =====") ;
              return false ;
            } // else()
          } // if()
          else { // 不是 ']'
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
              // 就設定錯誤
              Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()

            // System.out.println("===== Fake_Unsigned_unary_exp() 5 =====") ;
            return false ;
          } // else()
        } // if()
        else { // 不是 Expression()
          return false ;
        } // else()

      } // else if()
      // 以上為可要可不要
      // 以下為可要可不要
      else if ( Get_Now_Token_Tpye() == PP
                || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
        Get_Token() ;
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == MUL
                || Get_Now_Token_Tpye() == DIV
                || Get_Now_Token_Tpye() == PA ) { // 如果是 '*' 或 '/' 或 '%'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == ADD
                || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == LS
                || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == ST
                || Get_Now_Token_Tpye() == BT
                || Get_Now_Token_Tpye() == LE
                || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == EQ
                || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_AND ) { // 如果是 '&'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SMALL_OR ) { // 如果是 '|'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COMMA ) { // 如果是 ','
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == SC ) { // 如果是 ';'
        // 先不要讀掉
        return true ;
      } // else if()
      else if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
        // 先不要讀掉
        return true ;
      } // else if()
      else { // 都不是

        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
          // 就設定錯誤
          Set_Error( Return_Token(), Return_Token_Type(), false ) ;
        } // if()

        // System.out.println("===== Fake_Unsigned_unary_exp() 6 =====") ;
        return false ;
      } // else()
    } // if()
    else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
      Get_Token() ;
      return true ;
    } // else if()
    else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
      Get_Token() ;
      if ( Fake_Expression() ) { // 如果是 Expression()
        if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
          Get_Token() ;
          return true ;
        } // if()
        else { // 不是 ')'
          return false ;
        } // else()
      } // if()
      else { // 不是 Expression()
        return false ;
      } // else()
    } // else if()
    else { // 都不是
      if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
        // 就設定錯誤
        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
      } // if()

      // System.out.println("===== Fake_Unsigned_unary_exp() 7 =====") ;
      return false ;
    } // else()
  } // Fake_Unsigned_unary_exp()
    
} // class Grammar

class TokenImfor {
    
    public String m_token = "" ; // 原始的 token
    public int m_type = -1 ; // 此 token 的型別
    public boolean m_is_Done = false ;
    public boolean m_is_ListAllVariables = false ; // 如果是呼叫 ListAllVariables
    public boolean m_is_ListAllFunctions = false ; // 如果是呼叫 ListAllFunctions
    public boolean m_is_ListVariable = false ; // 如果是呼叫 ListVariable
    public boolean m_is_ListFunction = false ; // 如果是呼叫 ListFunction
    public boolean m_is_String = false ; // 如果是 String 的 CONSTANT
    public boolean m_is_Num = false ; // 如果是 int or float 的 CONSTANT
    public boolean m_is_Boolean = false ; // 如果是 Boolean 的 CONSTANT
    public boolean m_is_Float = false ; // 此 token 是否為浮點數
    public boolean m_is_Char = false ; // 此 token 是否為字元
    // 當要新增時，記得修改 claa "Grammar" 的 Function "Copy_my_TokenImfor"
    
    public TokenImfor() {
        
  } // TokenImfor()
    
} // class TokenImfor()


class Id {
    
    public String m_id_string = "" ; 
    public float m_id_num = -9487 ; 
    
    // ====== 一般變數 ======
    public Variable[] my_Variable = new Variable[50] ;
    public int m_var_num = 0 ;
    public boolean m_new_def = false ;
    public int m_type = -1 ;
    public String m_array_num = "" ; // [num]
    
    // ====== Function ======
    public boolean m_is_Function = false ; // 判斷此 Id 為 一般變數 或 Function 變數 // 給單一 Id 串 // 非陣列
    public Variable[] my_Func_Variable = new Variable[50] ; // Function 的變數
    public int m_Func_var_num = 0 ;
    public int m_Func_type = -1 ;
    public String m_Function_String = "" ; // 存整個 Function
    
    public Id() {
        
  } // Id()
    
} // class Id

class Variable {
    
    public String m_var = "" ;
    public boolean m_new_def = false ;
    public int m_type = -1 ;
    public String m_array_num = "" ; // [num]
    public float m_value = 0 ;
    public boolean m_bool_value = false ;
    public boolean m_Is_Float = false ;
    public Array[] my_Array = new Array[50] ; // 存陣列
    public boolean m_is_fake = false ; // 看此變數是不是 在 條件是為 false 的地方宣告的
    
    // ====== Function ======
    public boolean m_is_Function = false ; // 判斷此 Id 為 一般變數 或 Function 變數
    public int m_Func_type = -1 ;
    public String m_Function_String = "" ; // 存整個 Function
    
    // ====== 之前的 ======
    public int m_last_type = -1 ;
    public String m_last_array_num = "" ; // [num]
    public String m_last_Function_String = "" ;
    public float m_last_value = 0 ;
    public boolean m_last_bool_value = false ;
    
    // ===== 全部的值 不管型別是什麼 都用字串來表示 =====
    public String m_all_type_value = "" ;
    public String m_all_type_last_value = "" ;
    
    public Variable() {
        
  } // Variable()
    
} // class Variable

class Array {
    
    public boolean m_new_def = false ;
    public boolean m_bool_value = false ;
    public float m_value = 0 ;
    
    // ====== 之前的 ======
    public float m_last_value = 0 ;
    public boolean m_last_bool_value = false ;
    
    // ===== 全部的值 不管型別是什麼 都用字串來表示 =====
    public String m_all_type_value = "" ;
    public String m_all_type_last_value = "" ;
    
    public Array() {
        
  } // Array()
    
} // class Array
