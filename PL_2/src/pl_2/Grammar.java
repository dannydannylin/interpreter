
package pl_2;

import java.util.Scanner;


public class Grammar {
    
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
    
    private TokenImfor[] my_TokenImfor = new TokenImfor[600] ; // 輸入的 TokenImfor 陣列
    private Id[] my_Glo_Or_Loc_Id = new Id[600] ; // Id 陣列
    int my_Glo_Or_Loc_Id_length = 0 ; // Id 陣列 的 長度 ( 第幾層 {} )
    private boolean[] my_Glo_Or_Loc_Already_Ini = new boolean[40] ;
    
    private Id[] my_Now_Id = new Id[50] ; // 當下輸入的 id ( 對付印定義 )
    int my_Now_Id_Num = 0 ;
    
    int Done_num = 0 ;
    int ListAllVariables_num = 0 ;
    int ListAllFunctions_num = 0 ;
    int ListVariable_num = 0 ;
    int ListFunction_num = 0 ;
    
    String ListVariable_Id = "" ;
    String ListFunction_Id = "" ;
    
    String error_token = "" ; // 紀錄第一個出現的錯誤
    int error_token_type = -1 ;
    boolean error_token_already_set = false ; // 是否已經紀錄過第一個出現的錯誤
    boolean error_token_no_id = false ; // 第一個錯誤是不是 未定義 的 id
    boolean inside_the_LBP = false ; // 在 '{' 裡面
    
    int Id_type = -1 ; // 此 變數的型別
    
    boolean is_function = false ; // 此變數是否為 Funciton 變數
    String my_now_func_String = "" ; // 存當下的 Function
    
    int my_TokenImfor_num = -1 ; // TokenImfor 陣列 的 index
    int my_TokenImfor_length = -1 ; // TokenImfor 陣列 的 長度
    
    int my_line = 0 ; // 第幾行
    
    boolean check_next_token_RBP = false ; // 判斷下一個 token 是不是 '{'
    
    int last_token_type = -1 ;
    String last_token = "" ;
    
    String array_number = "" ;
    
    int compound_enter = 0 ; //
    
    private Variable[] my_Golbal_Variable = new Variable[100] ;
    int my_Golbal_Variable_num = 0 ;
    private Variable[] my_Local_Variable = new Variable[100] ;
    
    Scanner cin ;
    
    public Grammar() {
        cin = new Scanner( System.in ) ;
        boolean breakk = false ;
        
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
    
    private void Set_Check_Next_Token_RBP( boolean set ) {
        check_next_token_RBP = set ;
    } // Set_Check_Next_Token_RBP()
    
    private boolean Get_Check_Next_Token_RBP() {
        return check_next_token_RBP ;
    } // Get_Check_Next_Token_RBP()
    
    private void Add_Compound_Enter( int add ) {
        compound_enter = compound_enter + add ;
    } // Add_Compound_Enter()
    
    private int Get_Compound_Enter() {
        return compound_enter ;
    } // Get_Compound_Enter()
    
    private void Set_Is_Function( boolean set ) {
        is_function = set ;
    } // Set_Is_Function()
    
    private boolean Get_Is_Function() {
        return is_function ;
    } // Get_Is_Function()
    
    private void Print_Statement() {
        System.out.println( "Statement executed ..." ) ;
    } // Print_Statement()
    
    private void Print_Definition() {
        
        boolean breakk = false ;
        
        for ( int i = 0 ; !breakk && i < Get_My_Now_Index() ; i++ ) { 
            
            if ( my_Now_Id[i].new_def ) { // 如果是 重新定義
                
                if ( my_Now_Id[i].is_Function ) { // 如果是 Function
                    System.out.println( "New definition of " +  my_Now_Id[i].id_string + "() entered ..." ) ;
                    // 是 Function 必定只印一次
                    // 因為一次只能定義一個 Funciton
                    breakk = true ;
                } // if()
                else { // 不是 Function
                    System.out.println( "New definition of " +  my_Now_Id[i].id_string + " entered ..." ) ;
                } // else()
                
            } // if()
            else { // 第一次定義
                
                if ( my_Now_Id[i].is_Function ) { // 如果是 Function
                    System.out.println( "Definition of " +  my_Now_Id[i].id_string + "() entered ..." ) ;
                    // 是 Function 必定只印一次
                    // 因為一次只能定義一個 Funciton
                    breakk = true ;
                } // if()
                else { // 不是 Function
                    System.out.println( "Definition of " +  my_Now_Id[i].id_string + " entered ..." ) ;
                } // else()
                
            } // else()
            
        } // for()
        
    } // Print_Definition()
    
    private void Reverse_My_Now_Id() {
        
        for ( int i = 0 ; i < Get_My_Now_Index() - 1 ; i++ ) {
            /*String temp = "" ;
            temp = my_Now_Id[i].id_string ;
            my_Now_Id[i].id_string = my_Now_Id[Get_My_Now_Index() - 1].id_string ;
            my_Now_Id[Get_My_Now_Index() - 1].id_string = temp ;*/
            
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
        
    } // Print_Error()
    
    private void Print_Error( String token, int token_type, boolean no_id ) {
        
        int line = -1 ;
        line = Get_Line() ;
        
        if ( token_type == NON ) { // 不是定義的 token
            Print( "line " + line + " : Unrecognized token with first char : '" + token + "'" ) ;
        } //  if()
        else if ( !no_id ) { // 不是預期的 token
            Print( "line " + line + " : Unexpected token : '" + token + "'" ) ;
        } // else if()
        else {
            if ( no_id ) { // 文法正確，但 token 不存在
                Print( "line " + line + " : Undefined identifier : '" + token + "'" ) ;
            } // if()
            else {
                Print( "Print_Error Error" ) ;
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
            else if ( my_TokenImfor[i].type == ENTER ) { // 如果是 換行
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
        
        
        for ( int i = 0 ; i <= Glo_Or_Loc ; i++ ) { // 找此 {} 外面有宣告過的變數 
            // 找本身自己 {} 內 宣告的變數
            if ( my_Glo_Or_Loc_Already_Ini[i] ) { // 如果有初始化過
                
                //if ( is_function ) { // 如果是 Function 變數 
                    
                    for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].Func_var_num ; j++ ) {
                        if ( my_Glo_Or_Loc_Id[i].my_Func_Variable[j] != null
                             && id.equals( my_Glo_Or_Loc_Id[i].my_Func_Variable[j].var ) ) { // 如果是出現過的 id
                            
                            return true ;
                        } // if()
                    } // for()
                    
                //} // if()
                //else { // 不是 Function 變數
                    // 是一般變數
                    
                    for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].var_num ; j++ ) {
                        
                        if ( id.equals( my_Glo_Or_Loc_Id[i].my_Variable[j].var ) ) { // 如果是出現過的 id
                            
                            return true ;
                        } // if()
                    } // for()
                    
                //} // else()
                
            } // if()
        } // for()
        
        return false ;
    } // Same_Id()
    
    private void Set_New_Definition( String id, int Glo_Or_Loc, int type, String array_num ) {
        
        boolean breakk = false ;
        
        for ( int i = 0 ; !breakk && i <= Glo_Or_Loc ; i++ ) { // 找此 {} 外面有宣告過的變數 
            // 找本身自己 {} 內 宣告的變數
            if ( my_Glo_Or_Loc_Already_Ini[i] ) { // 如果有初始化過
                for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].var_num ; j++ ) {
                    if ( id.equals( my_Glo_Or_Loc_Id[i].my_Variable[j].var ) ) { // 如果是出現過的 id
                        // ===== 紀錄之前的 ======
                        my_Glo_Or_Loc_Id[i].my_Variable[j].last_type = my_Glo_Or_Loc_Id[i].my_Variable[j].type ;
                        my_Glo_Or_Loc_Id[i].my_Variable[j].last_array_num = my_Glo_Or_Loc_Id[i].my_Variable[j].array_num ;
                        // ===== 重新定義 =====
                        my_Glo_Or_Loc_Id[i].my_Variable[j].new_def = true ; // 重新定義
                        my_Glo_Or_Loc_Id[i].my_Variable[j].type = type ;
                        my_Glo_Or_Loc_Id[i].my_Variable[j].array_num = array_num ;
                        breakk = true ;
                    } // if()
                } // for()
                
                for ( int j = 0 ; j < my_Glo_Or_Loc_Id[i].Func_var_num ; j++ ) {
                    if ( id.equals( my_Glo_Or_Loc_Id[i].my_Func_Variable[j].var ) ) { // 如果是出現過的 id
                        // ===== 紀錄之前的 ======
                        my_Glo_Or_Loc_Id[i].my_Func_Variable[j].last_type = my_Glo_Or_Loc_Id[i].my_Func_Variable[j].type ;
                        my_Glo_Or_Loc_Id[i].my_Func_Variable[j].last_array_num = my_Glo_Or_Loc_Id[i].my_Func_Variable[j].array_num ;
                        my_Glo_Or_Loc_Id[i].my_Func_Variable[j].last_Function_String = my_Glo_Or_Loc_Id[i].my_Func_Variable[j].Function_String ;
                        // ===== 重新定義 =====
                        my_Glo_Or_Loc_Id[i].my_Func_Variable[j].new_def = true ; // 重新定義
                        my_Glo_Or_Loc_Id[i].my_Func_Variable[j].type = type ;
                        my_Glo_Or_Loc_Id[i].my_Func_Variable[j].array_num = array_num ;
                        my_Glo_Or_Loc_Id[i].my_Func_Variable[j].Function_String = Get_My_Now_Func_String() ;
                        breakk = true ;
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
            for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].var_num ; i++ ) {
                Variable my_Variable = new Variable() ; // 初始化它
                tempId.my_Variable[i] = my_Variable ; // 初始化它
                tempId.my_Variable[i].var = my_Glo_Or_Loc_Id[0].my_Variable[i].var ;
            } // for()
            
            for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].var_num ; i++ ) {
                for ( int j = 0 ; j < my_Glo_Or_Loc_Id[0].var_num - 1 - i ; j++ ) {
                    if ( tempId.my_Variable[j].var.compareTo( tempId.my_Variable[j+1].var ) > 0 ) {
                        String tmp = tempId.my_Variable[j].var ;
                        tempId.my_Variable[j].var = tempId.my_Variable[j+1].var ;
                        tempId.my_Variable[j+1].var = tmp ;
                    } // if()
                } // for()
            } // for()
                
            
            
            for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].var_num ; i++ ) {
                
                if ( !tempId.my_Variable[i].var.equals( "" ) ) {
                    System.out.println( tempId.my_Variable[i].var ) ;
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
            for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].Func_var_num ; i++ ) {
                Variable my_Variable = new Variable() ; // 初始化它
                tempId.my_Func_Variable[i] = my_Variable ; // 初始化它
                tempId.my_Func_Variable[i].var = my_Glo_Or_Loc_Id[0].my_Func_Variable[i].var ;
            } // for()
            
            for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].Func_var_num ; i++ ) {
                for ( int j = 0 ; j < my_Glo_Or_Loc_Id[0].Func_var_num - 1 - i ; j++ ) {
                    if ( tempId.my_Func_Variable[j].var.compareTo( tempId.my_Func_Variable[j+1].var ) > 0 ) {
                        String tmp = tempId.my_Func_Variable[j].var ;
                        tempId.my_Func_Variable[j].var = tempId.my_Func_Variable[j+1].var ;
                        tempId.my_Func_Variable[j+1].var = tmp ;
                    } // if()
                } // for()
            } // for()
                
            for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].Func_var_num ; i++ ) {
                System.out.println( tempId.my_Func_Variable[i].var + "()" ) ;
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
        for ( int i = 0 ; !breakk && i < my_Glo_Or_Loc_Id[0].var_num ; i++ ) {
            
            // 如果是要印的 Id
            if ( my_Glo_Or_Loc_Id[0].my_Variable[i].var.equals( Get_ListVariable_Id() ) ) {
                
                String type = "" ;
                type = Change_Type_Num_To_Real_Type( my_Glo_Or_Loc_Id[0].my_Variable[i].type ) ;
                
                System.out.print( type + " " ) ;
               
                System.out.print( my_Glo_Or_Loc_Id[0].my_Variable[i].var ) ;
                
                // 如果有陣列
                if ( !my_Glo_Or_Loc_Id[0].my_Variable[i].array_num.equals( "" ) ) {
                    System.out.println( "[ " + my_Glo_Or_Loc_Id[0].my_Variable[i].array_num + " ] ;" ) ;
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
                           && i < my_Glo_Or_Loc_Id[0].Func_var_num ; i++ ) {
            
            // 如果是要印的 Id
            if ( my_Glo_Or_Loc_Id[0].my_Func_Variable[i].var.equals( Get_ListFunction_Id() ) ) {
                
                System.out.print( my_Glo_Or_Loc_Id[0].my_Func_Variable[i].Function_String ) ;
                breakk = true ;
            } // if()
        } // for()
        
    } // Print_ListFunction()
    
    private String Change_Type_Num_To_Real_Type( int type ) {
        
        if ( type == 48 ) {
            return "int" ;
        } // if()
        else if ( type == 49 ) {
            return "float" ;
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
        Done_num = Done_num + num ;
    } // Set_Done()
    
    private void Set_Done_Zeor() {
        Done_num = 0 ;
    } // Set_Done_Zeor()
    
    private void Set_Id_Type( int type ) {
        Id_type = type ;
    } // Set_Id_Type()
    
    private int Get_Id_Type() {
        return Id_type ;
    } // Get_Id_Type()
    
    private void Set_ListAllVariables( int num ) {
        ListAllVariables_num = ListAllVariables_num + num ;
    } // Set_ListAllVariables()
    
    private void Set_ListAllFunctions( int num ) {
        ListAllFunctions_num = ListAllFunctions_num + num ;
    } // Set_ListAllFunctions()
    
    private void Set_ListVariable( int num ) {
        ListVariable_num = ListVariable_num + num ;
    } // Set_ListVariable()
    
    private void Set_ListFunction( int num ) {
        ListFunction_num = ListFunction_num + num ;
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
        return Done_num ;
    } // Return_Done_Num()
    
    private int Return_ListAllVariables_Num() {
        return ListAllVariables_num ;
    } // Return_ListAllVariables_Num()
    
    private int Return_ListAllFunctions_Num() {
        return ListAllFunctions_num ;
    } // Return_ListAllFunctions_Num()
    
    private int Return_ListVariable_Num() {
        return ListVariable_num ;
    } // Return_ListVariable_Num()
    
    private int Return_ListFunction_Num() {
        return ListFunction_num ;
    } // Return_ListFunction_Num()
    
    private String Return_Token() {
        return my_TokenImfor[my_TokenImfor_num].token ;
    } // Return_Token()
    
    private boolean Return_Is_String() {
        return my_TokenImfor[my_TokenImfor_num].is_String ;
    } // Return_Is_String()
    
    private int Return_Token_Type() {
        return my_TokenImfor[my_TokenImfor_num].type ;
    } // Return_Token()
    
    private boolean Return_Token_Is_Done() {
        return my_TokenImfor[my_TokenImfor_num].is_Done ;
    } // Return_Token_Is_Done()
    
    private boolean Return_Token_Is_ListAllVariables() {
        return my_TokenImfor[my_TokenImfor_num].is_ListAllVariables ;
    } // Return_Token_Is_ListAllVariables()
    
    private boolean Return_Token_Is_ListAllFunctions() {
        return my_TokenImfor[my_TokenImfor_num].is_ListAllFunctions ;
    } // Return_Token_Is_ListAllFunctions()
    
    private boolean Return_Token_Is_ListVariable() {
        return my_TokenImfor[my_TokenImfor_num].is_ListVariable ;
    } // Return_Token_Is_ListVariable()
    
    private boolean Return_Token_Is_ListFunction() {
        return my_TokenImfor[my_TokenImfor_num].is_ListFunction ;
    } // Return_Token_Is_ListFunction()
    
    private void Set_ListVariable_Id( String id ) {
        ListVariable_Id = id ;
    } // Set_ListVariable_Id()
    
    private void Set_ListFunction_Id( String id ) {
        ListFunction_Id = id ;
    } // Set_ListFunction_Id()
    
    private String Get_ListVariable_Id() {
        return ListVariable_Id ;
    } // Get_ListVariable_Id()
    
    private String Get_ListFunction_Id() {
        return ListFunction_Id ;
    } // Get_ListFunction_Id()
    
    private void Save_My_Now_Id( String id, boolean new_or_not, int type, boolean is_Function ) {
        
        my_Now_Id[Get_My_Now_Index()] = new Id() ;
        
        my_Now_Id[Get_My_Now_Index()].id_string = id ;
        my_Now_Id[Get_My_Now_Index()].type = type ;
        my_Now_Id[Get_My_Now_Index()].is_Function = is_Function ;
        
        if ( new_or_not ) {
            my_Now_Id[Get_My_Now_Index()].new_def = true ;
        } // if()
        
        Add_My_Now_Id_Num() ;
        
    } // Save_My_Now_Id()
    
    private void ReSet_My_Now_Id() {
        
        for ( int i = 0 ; i < Get_My_Now_Index() ; i++ ) {
            my_Now_Id[Get_My_Now_Index()].id_string = "" ;
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
    
    private void Print( Object o ) {
        System.out.println( ">" + o );
    } // Print()
    
    private void Initialization() {
        
        if ( Enough_Token() )
            my_line = 1 ;
        else
            my_line = 0 ;
        
        Done_num = 0 ;
        ListAllVariables_num = 0 ;
        ListAllFunctions_num = 0 ;
        ListVariable_num = 0 ;
        ListFunction_num = 0 ;
        error_token = "" ; // 紀錄第一個出現的錯誤
        error_token_type = -1 ;
        error_token_already_set = false ; // 是否已經紀錄過第一個出現的錯誤
        error_token_no_id = false ; // 第一個錯誤是不是 未定義 的 id
        inside_the_LBP = false ;
        ListVariable_Id = "" ;
        ListFunction_Id = "" ;
        my_Now_Id_Num = 0 ;
        is_function = false ;
        my_now_func_String = "" ;
        ReSet_My_Now_Id() ;
        compound_enter = 0 ;
        check_next_token_RBP = false ;
        array_number = "" ;
        
    } // Initialization()
    
    private void Set_My_Now_Func_String( String set, int space ) {
        my_now_func_String = my_now_func_String + set ;
        // 存空格
        for ( int j = 0 ; j < space ; j++ ) {
            my_now_func_String = my_now_func_String + " " ;
        } // for
    } // Set_My_Now_Func_String
    
    private String Get_My_Now_Func_String() {
        return my_now_func_String ;
    } // Get_My_Now_Func_String
    
    private int Get_Last_Token_Type() {
        return last_token_type ;
    } // Get_Last_Token_Type()
    
    private String Get_Last_Token() {
        return last_token ;
    } // Get_Last_Token()
    
    private void Save_Last_Token_Type( int type ) {
         last_token_type = type ;
    } // Save_Last_Token_Type()
    
    private void Save_Last_Token( String token ) {
         last_token = token ;
    } // Save_Last_Token()
    
    private void Get_Token() {
        Save_Last_Token_Type( Return_Token_Type() ) ;
        Save_Last_Token( Return_Token() ) ;
        my_TokenImfor_num++ ;
    } // Get_Token()
    
    private void Copy_my_TokenImfor( Token myToken ) {
        
        for ( int i = 0 ; i < 600 ; i++ ) {
            my_TokenImfor[i] = new TokenImfor() ;
        } // for()
        
        for ( int i = 0 ; i <= myToken.my_TokenImfor_num ; i++ ) {
            my_TokenImfor[i].token = myToken.my_TokenImfor[i].token ;
            my_TokenImfor[i].type = myToken.my_TokenImfor[i].type ;
            my_TokenImfor[i].is_Done = myToken.my_TokenImfor[i].is_Done ;
            my_TokenImfor[i].is_ListAllVariables = myToken.my_TokenImfor[i].is_ListAllVariables ;
            my_TokenImfor[i].is_ListAllFunctions = myToken.my_TokenImfor[i].is_ListAllFunctions ;
            my_TokenImfor[i].is_ListVariable = myToken.my_TokenImfor[i].is_ListVariable ;
            my_TokenImfor[i].is_ListFunction = myToken.my_TokenImfor[i].is_ListFunction ;
            my_TokenImfor[i].is_String = myToken.my_TokenImfor[i].is_String ;
        } // for()
    } // Copy_my_TokenImfor()
    
    private void Read_Input() {
        
        my_TokenImfor_num = 0 ; // 初始化
        String buffer = "" ;
        buffer = cin.nextLine() + '\n' ;
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
        } // esle()
    } // Enough_Token()
    
    private int Get_Now_Token_Tpye() {
        
        if ( Enough_Token() ) { // 如果 Token 夠多
            
            if ( Get_Check_Next_Token_RBP() ) {
                if ( my_TokenImfor[my_TokenImfor_num].type != RBP ) { // 如果"不"是 '{'
                    Set_My_Now_Func_String( "", 2 ) ; // 空 2 格
                    Set_Check_Next_Token_RBP( false ) ;
                } // if()
            } // if()
            
            return my_TokenImfor[my_TokenImfor_num].type ;
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
                if ( my_TokenImfor[my_TokenImfor_num].type != RBP ) { // 如果"不"是 '{'
                    Set_My_Now_Func_String( "", 2 ) ; // 空 2 格
                    Set_Check_Next_Token_RBP( false ) ;
                } // if()
            } // if()
            
            return my_TokenImfor[my_TokenImfor_num].type ; 
        } // else()
        
    } // Get_Now_Token_Tpye()
    
    private void Set_Error_Token( String token ) {
        error_token = token ;
    } // Set_Error_Token()
    
    private void Set_Error_Type( int type ) {
        error_token_type = type ;
    } // Set_Error_Type()
    
    private void Set_Error_Token_No_Id( boolean no_id ) {
        error_token_no_id = no_id ;
    } // Set_Error_Token_No_Id()
    
    private void Set_Error_Token_Already_Set( boolean set ) {
        error_token_already_set = set ;
    } // Set_Error_Token_Already_Set()
    
    private boolean Get_Error_Token_Already_Set() {
        return error_token_already_set ;
    } // Get_Error_Token_Already_Set()
    
    private String Get_Error_Token() {
        return error_token ;
    } // Get_Error_Token()
    
    private int Get_Error_Type() {
        return error_token_type ;
    } // Get_Error_Token()
    
    private boolean Get_Error_Token_No_Id() {
        return error_token_no_id ;
    } // Get_Error_Token()
    
    private void Set_Inside_The_LBP( boolean set ) {
        inside_the_LBP = set ;
    } // Set_Inside_The_LBP()
    
    private boolean Get_Inside_The_LBP() {
        return inside_the_LBP ;
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
            //my_Glo_Or_Loc_Already_Ini[which] = false ;
            
        } // if()
        else {
            System.out.println( "There is NO need to Ini ---> Ini_Set_New_ID_Error !!! " ) ;
        } // else()
        
    } // Ini_Set_New_ID()
    
    private void Undo_Variable( Variable[] my, int my_num ) {
        
        
        int count = 0 ;
        // 要 -1 是因為 [0] 沒有存東西 ( 重 1 開始 )
        
        for ( int j = 0 ; j < my_num ; j++ ) {
            
            for ( int i = 0 ; i < my_Glo_Or_Loc_Id[0].var_num ; i++ ) {
                // 如果是此 id
                if ( my[j].var.equals( my_Glo_Or_Loc_Id[0].my_Variable[i].var ) ) {

                    if ( my_Glo_Or_Loc_Id[0].my_Variable[i].new_def ) { // 如果已經有重新定義過
                        // 表示定義了不只一次
                        my_Glo_Or_Loc_Id[0].my_Variable[i].type = my_Glo_Or_Loc_Id[0].my_Variable[i].last_type ;
                        my_Glo_Or_Loc_Id[0].my_Variable[i].array_num = my_Glo_Or_Loc_Id[0].my_Variable[i].last_array_num ;

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
        
        
        
        my_Glo_Or_Loc_Id[0].var_num = my_Glo_Or_Loc_Id[0].var_num - count ;
        
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
            
            if ( is_Function ) { // 如果是 Function
                
                my_Glo_Or_Loc_Id[which].my_Func_Variable[0].var = save_id ; // 存 id
                my_Glo_Or_Loc_Id[which].my_Func_Variable[0].Func_type = type ; // 存 型別
                my_Glo_Or_Loc_Id[which].my_Func_Variable[0].is_Function = is_Function ; // 存 是否為 Function
                my_Glo_Or_Loc_Id[which].my_Func_Variable[0].Function_String = Get_My_Now_Func_String() ; // 存 Function
                my_Glo_Or_Loc_Id[which].my_Func_Variable[0].last_Function_String = Get_My_Now_Func_String() ; // 存 Function
                my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過
                
            } // if()
            else { // 不是 Function
                
                my_Glo_Or_Loc_Id[which].my_Variable[0].var = save_id ; // 存 id
                my_Glo_Or_Loc_Id[which].my_Variable[0].type = type ; // 存 型別
                my_Glo_Or_Loc_Id[which].my_Variable[0].is_Function = is_Function ; // 存 是否為 Function
                my_Glo_Or_Loc_Id[which].my_Variable[0].array_num = array_num ;
                // ==== 也記錄在 last 裡面
                my_Glo_Or_Loc_Id[which].my_Variable[0].last_type = type ; // 存 型別
                my_Glo_Or_Loc_Id[which].my_Variable[0].last_array_num = array_num ;
                my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過
                
            } // else()
            
        } // if()
        else { // 有初始化過
            
            if ( is_Function ) { // 如果是 Function
                
                int varnum = my_Glo_Or_Loc_Id[which].Func_var_num ;
                my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].var = save_id ; // 存 id
                my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].Func_type = type ; // 存 型別
                my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].is_Function = is_Function ; // 存 是否為 Function
                my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].Function_String = Get_My_Now_Func_String() ; // 存 Function
                my_Glo_Or_Loc_Id[which].my_Func_Variable[varnum].last_Function_String = Get_My_Now_Func_String() ; // 存 Function
                my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過
                
            } // if()
            else { // 不是 Function
                
                int varnum = my_Glo_Or_Loc_Id[which].var_num ;
                my_Glo_Or_Loc_Id[which].my_Variable[varnum].var = save_id ; // 存 id
                my_Glo_Or_Loc_Id[which].my_Variable[varnum].type = type ; // 存 型別
                my_Glo_Or_Loc_Id[which].my_Variable[varnum].is_Function = is_Function ; // 存 是否為 Function
                my_Glo_Or_Loc_Id[which].my_Variable[varnum].array_num = array_num ;
                // ==== 也記錄在 last 裡面
                my_Glo_Or_Loc_Id[which].my_Variable[varnum].last_type = type ; // 存 型別
                my_Glo_Or_Loc_Id[which].my_Variable[varnum].last_array_num = array_num ;
                my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過
                
            } // else()
            
        } // else()
        
    } // Set_New_ID()
    
    private void Set_New_ID_Array_Num( int which, String num ) {
        
        if ( !my_Glo_Or_Loc_Already_Ini[which] ) { // 如果沒初始化過
            Id myid = new Id() ; // 初始化它
            my_Glo_Or_Loc_Id[which] = myid ; // 初始化它
            Variable myVariable1 = new Variable() ;
            my_Glo_Or_Loc_Id[which].my_Variable[0] = myVariable1 ; // 初始化它
            my_Glo_Or_Loc_Id[which].my_Variable[0].array_num = num ;
            my_Glo_Or_Loc_Already_Ini[which] = true ; // 此 {} 以初始化過
        } // if()
        else { // 初始化過了 
            int varnum = my_Glo_Or_Loc_Id[which].var_num ;
            my_Glo_Or_Loc_Id[which].my_Variable[varnum].array_num = num ;
            // var_num 不 ++
            // 因為一定是先進這裡
            // 再去 Set_New_ID
        } // else()
        
        
        
    } // Set_New_ID_Array_Num()
    
    private void Var_Num_Add( int which ) {
        
        my_Glo_Or_Loc_Id[which].var_num++ ; // index + 1
                
        // 已經第一次初始化了
        // 其他就不是從 0 開始了
        int varnum = my_Glo_Or_Loc_Id[which].var_num ;
        Variable myVariable2 = new Variable() ;
        my_Glo_Or_Loc_Id[which].my_Variable[varnum] = myVariable2 ; // 初始化它
        
        
    } // Var_Num_Add()
    
    private void Func_Var_Num_Add( int which ) {
        
        my_Glo_Or_Loc_Id[which].Func_var_num++ ; // index + 1
        int varnum = -1 ;
        // 初始化下一個
        varnum = my_Glo_Or_Loc_Id[which].Func_var_num ;
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
            
            System.out.print( "> " ) ;
            
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
            
            if ( !Return_Done() ) { // 如果不是 Done();
                Print_Statement() ;
            } // if()
            
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
                
                System.out.println("===== Definition() 1 =====") ;
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
                
                if ( Function_definition_or_declarators( save_id, type ) ) { // 如果 Function_definition_or_declarators()
                    
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
                
                System.out.println("===== Definition() 2 =====") ;
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
        else if ( Get_Now_Token_Tpye() == FLOAT ) { // 如果是 float
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
            
            return false ;
        } // else()
        
        
    } // Function_definition_or_declarators()
    
    private boolean Rest_of_declarators( String id, int type ) {
        
        
        Variable[] save_Variable = new Variable[30] ; // 存 在這裡定義的 Id
        int save_Variable_num = 0 ;
        
        // 初始化 
        for ( int j = 0 ; j < 30 ; j++ ) {
            Variable ini = new Variable() ;
            save_Variable[j] = ini ;
        } // for()
        
        save_Variable[save_Variable_num].var = id ;
        
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
                        // 重新定義
                        Set_New_Definition( id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;
                        
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
                        
                        // 存所以的變數
                        Set_New_ID( id, Get_My_Glo_Or_Loc_Id_Length(), type, Get_Is_Function(), array_num ) ;
                        // 變數++
                        Func_Or_Var_Num_Add( Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ;
                        
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
                
                    System.out.println("===== Rest_of_declarators() 1 =====") ;
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
                
                // 重新定義
                Set_New_Definition( id, Get_My_Glo_Or_Loc_Id_Length(), type, "" ) ;
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
                    
                    save_Variable[save_Variable_num].var = save_id ;
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
                                
                                if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { 
                                    // 以下兩個都需要更新所有的狀態 ( type... )
                                    // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
                                    if ( !Get_Is_Function() ) {
                                        Save_My_Now_Id( save_id, true, type, Get_Is_Function() ) ;
                                    } // if()
                                    
                                    // 重新定義
                                    Set_New_Definition( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, array_num ) ;
                                    // 不需要變數++ ( 因為是重新定義 )
                                } // if()
                                else { // 新定義
                                     // 存印定義
                                    if ( !Get_Is_Function() ) {
                                         Save_My_Now_Id( save_id, false, type, Get_Is_Function() ) ;
                                    } // if()
                                    
                                     // 存所以的變數
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
                
                                System.out.println("===== Rest_of_declarators() 2 =====") ;
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
                
                            System.out.println("===== Rest_of_declarators() 3 =====") ;
                            return false ;
                        } // else()
                    } // if()
                    else { // 沒有 array
                        if ( Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果是 出現過的 id
                            // 以下兩個都需要更新所有的狀態 ( type... )
                            // Set ( 當下的 Id ) 重新定義為 true ( 印定義 )
                            if ( !Get_Is_Function() ) {
                                Save_My_Now_Id( save_id, true, type, Get_Is_Function() ) ;
                            } // if()
                            
                            // 重新定義
                            Set_New_Definition( save_id, Get_My_Glo_Or_Loc_Id_Length(), type, "" ) ;
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
                
                    System.out.println("===== Rest_of_declarators() 4 =====") ;
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
                
            System.out.println("===== Rest_of_declarators() 6 =====") ;
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
                
            } // else if()
            else { // 都不是
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                } // if()
                
                System.out.println("===== Function_definition_without_ID() 1 =====") ;
                return false ;
            } // else()
            
        } // if()
        else { // 不是 '('
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
                
            System.out.println("===== Function_definition_without_ID() 2 =====") ;
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
            if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
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
                
                            System.out.println("===== Formal_parameter_list() 1 =====") ;
                            return false ;
                        } // else()
                        
                    } // if()
                    else { // 不是 Constant
                        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                            // 就設定錯誤
                            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                        } // if()
                
                        System.out.println("===== Formal_parameter_list() 2 =====") ;
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
                
                System.out.println("===== Formal_parameter_list() 3 =====") ;
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
                   if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
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
                
                                   System.out.println("===== Formal_parameter_list() 4 =====") ;
                                   return false ;
                                } // else()

                            } // if()
                            else { // 不是 Constant
                                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                                    // 就設定錯誤
                                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                                } // if()
                
                               System.out.println("===== Formal_parameter_list() 5 =====") ;
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
                
                        System.out.println("===== Formal_parameter_list() 6 =====") ;
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
                    
                    System.out.println("===== Formal_parameter_list() 7 =====") ;
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
                
               System.out.println("===== Formal_parameter_list() 8 =====") ;
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
                Print( "Class_Grammar --> Function_Compound_statement !!!" ) ;
                return false ;
            } // else()
            
        } // if()
        else { // 不是 '{'
            
            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                // 就設定錯誤
                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
            } // if()
                
            System.out.println("===== Compound_statement() 1 =====") ;
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
                
                System.out.println("===== Declaration() 1 =====") ;
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
                
                    System.out.println("===== Statement() 2 =====") ;
                    return false ;
                } // else()
            } // else if()
            else { // 都不是
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                } // if()
                
                System.out.println("===== Statement() 3 =====") ;
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
                    if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
                        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                        Get_Token() ;
                        
                        if ( Statement() ) { // 如果是 Statement()
                            
                            // 以下為可要可不要
                            if ( Get_Now_Token_Tpye() == ELSE ) { // 如果是 else
                                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                                Get_Token() ;
                                
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
                
                        System.out.println("===== Statement() 5 =====") ;
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
                
                System.out.println("===== Statement() 6 =====") ;
                return false ;
            } // else()
            
        } // else if()
        else if ( Get_Now_Token_Tpye() == WHILE ) { // 如果是 while
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                
                if ( Expression() ) { // 如果是 Expression()
                    if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
                        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                        Get_Token() ;
                        
                        if ( Statement() ) { // 如果是 Statement()
                            return true ;
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
                
                        System.out.println("===== Statement() 7 =====") ;
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
                
                System.out.println("===== Statement() 8 =====") ;
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
                
                                    System.out.println("===== Statement() 9 =====") ;
                                    return false ;
                                } // else()

                            } // if()
                            else { // 不是 ')'
                                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                                    // 就設定錯誤
                                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                                } // if()
                
                                System.out.println("===== Statement() 10 =====") ;
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
                
                        System.out.println("====== Statement() 11 =====") ;
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

                    System.out.println("===== Statement() 12 =====") ;
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
            
            System.out.println("===== Statement() 13 =====") ;
            return false ;
        } // else()
        
    } // Statement()
    
    private boolean Expression() {
        
        if ( Basic_expression() ) { // 如果是 Basic_expression()
            
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
                
                    System.out.println("===== Expression() 1 =====") ;
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
        
        if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
            
            // 判斷有沒有遇到特殊指令
            Set_Which_Done_List_Var_Func( Return_Token_Is_Done(), Return_Token_Is_ListAllVariables(),
                                          Return_Token_Is_ListAllFunctions(), Return_Token_Is_ListVariable(),
                                          Return_Token_Is_ListFunction() ) ;
            
            save_id = Return_Token() ; // 暫存此 id
            
            Get_Token() ;
            
            if ( Return_Done_Num() != 1 
                 && !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
                 // 且不是 Done();
                 
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( save_id, ID, true ) ;
                    
                } // if()
                
                System.out.println("===== Basic_expression() 1 =====") ;
                
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
            
            
            if ( Rest_of_Identifier_started_basic_exp() ) { // 如果是 Rest_of_Identifier_started_basic_exp()
                return true ;
            } // if()
            else { // 不是 Rest_of_Identifier_started_basic_exp()
                return false ;
            } // else()
            
        } // if()
        else if ( Get_Now_Token_Tpye() == PP 
                  || Get_Now_Token_Tpye() == MM ) { // 如果是 ++ 或 --
            
            Set_My_Now_Func_String( Return_Token(), 0 ) ; // 存當下的 Function
            
            Get_Token() ;
            
            if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
                
                save_id = Return_Token() ; // 暫存此 id
                
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                
                if ( Return_Done_Num() != 1 
                     && !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
                    // 且不是 Done();
                    
                    if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                        // 就設定錯誤
                        Set_Error( save_id, ID, true ) ;
                    } // if()
                    
                    System.out.println("===== Basic_expression() 2 =====") ;
                    

                    return false ;
                } // if()
                
               
                if ( Rest_of_PPMM_Identifier_started_basic_exp() ) { // 如果是 Rest_of_PPMM_Identifier_started_basic_exp()
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
                
                System.out.println("===== Basic_expression() 3 =====") ; 
                return false ;
            } // else()
            
        } // else if
        
        else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
            
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
            
            if ( Romce_and_romloe() ) { // 如果是 Romce_and_romloe()
                
                return true ;
            } // if()
            else { // 不是 Romce_and_romloe()
                
                return false ;
            } // else()
        } // else if()
        else if ( Get_Now_Token_Tpye() == LP ) { // 如果是 '('
            
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            
            
            Get_Token() ;
            
            if ( Expression() ) { // 如果是 Expression()
                
                if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;
                    
                    if ( Romce_and_romloe() ) { // 如果是 Romce_and_romloe()
                        
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
                    
                    Print("===== Basic_expression() 4 =====") ;
                    return false ;
                } // else()
                
            } // if()
            else { // 不是 Expression()
                
                return false ;
            } // else()
            
        } // else if()
        else if ( Sign() ) { // 如果是 sign()
            
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
                    
                } // else if()
                else { // 不是 sign()
                    breakk = true ;
                } // else()
                
            } // for()
            
            if ( Signed_unary_exp() ) { // 如果是 Signed_unary_exp()
                
                if ( Romce_and_romloe() ) { // 如果是 Romce_and_romloe()
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
    
    private boolean Rest_of_Identifier_started_basic_exp() {
        
        
        // 以下為可要可不要
        if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            if ( Expression() ) { // 如果是 Expression()
                
                if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;
                } // if()
                else { // 不是 ']'
                    if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                        // 就設定錯誤
                        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                    } // if()
                    
                    System.out.println("===== Rest_of_Identifier_started_basic_exp() 1 =====") ;
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
            Get_Token() ;
            
            if ( Romce_and_romloe() ) { // 如果是 Romce_and_romloe()
                return true ;
            } // if()
            else { // 不是 Romce_and_romloe()
                return false ;
            } // else()
        } // else if()
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
                
                if ( Romce_and_romloe() ) { // 如果是 Romce_and_romloe()
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
                
                System.out.println("===== Rest_of_Identifier_started_basic_exp() 2 =====") ;
                return false ;
            } // else()
            
        } // else if()
        else if ( Assignment_operator() ) { // 如果是 Assignment_operator()
            
            if ( Basic_expression() ) { // 如果是 Basic_expression()
                return true ;
            } // if()
            else { // 不是 Expression()
                return false ;
            } // else()
            
        } // else if()
        else if ( Romce_and_romloe() ) { // 如果是 Romce_and_romloe()
            return true ;
        } // else if()
        else { // 都不是
            // 不用印錯誤 // Romce_and_romloe() 已經印過
            return false ;
        } // else()
        
    } // Rest_of_Identifier_started_basic_exp()
    
    private boolean Rest_of_PPMM_Identifier_started_basic_exp() {
        
        // 以下為可要可不要
        if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            if ( Expression() ) { // 如果是 Expression()
                
                if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;
                } // if()
                else { // 不是 ']'
                    if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                        // 就設定錯誤
                        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                    } // if()
                    
                    System.out.println("===== Rest_of_PPMM_Identifier_started_basic_exp() 1 =====") ;
                    return false ;
                } // else()
            } // if()
            else { // 不是 Expression()
                return false ;
            } // else()
            
        } // if()
        // 以上為可要可不要
        
        if ( Romce_and_romloe() ) { // 如果是 Romce_and_romloe()
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
            
            return true ;
        } // if()
        else if ( Get_Now_Token_Tpye() == SUB ) { // 如果是 '-'
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == NOT ) { // 如果是 '!'
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
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
                
                System.out.println("===== Sign() 1 =====") ;
                
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
                    
                    System.out.println("===== Actual_parameter_list() 1 =====") ;
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
    
    private boolean Assignment_operator() {
        
        if ( Get_Now_Token_Tpye() == equ ) { // 如果是 '='
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            return true ;
        } // if()
        else if ( Get_Now_Token_Tpye() == TE ) { // 如果是 '*='
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == DE ) { // 如果是 '/='
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == RE ) { // 如果是 '%='
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == PE ) { // 如果是 '+='
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            return true ;
        } // else if()
        else if ( Get_Now_Token_Tpye() == ME ) { // 如果是 '-='
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            return true ;
        } // else if()
        else { // 都不是
            // ==================== 這裡不用印錯誤 !? ======================================================
            return false ;
        } // else()
        
    } // Assignment_operator()
    
    private boolean Romce_and_romloe() {
        
        if ( Rest_of_maybe_logical_OR_exp() ) { // 如果是 Rest_of_maybe_logical_OR_exp()
            
            // 以下為可要可不要
            if ( Get_Now_Token_Tpye() == QUESTION ) { // 如果是 '?'
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                
                if ( Basic_expression() ) { // 如果是 Basic_expression()
                    
                    if ( Get_Now_Token_Tpye() == COLON ) { // 如果是 ':'
                        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                        Get_Token() ;
                        
                        if ( Basic_expression() ) { // 如果是 Basic_expression()
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
                        
                        System.out.println("===== Romce_and_romloe() 1 =====") ;
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
                    
                    System.out.println("===== Romce_and_romloe() 2 =====") ;
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
                
                System.out.println("===== Romce_and_romloe() 3 =====") ;
                return false ;
            } // else()
        } // if()
        else { // 不是 Rest_of_maybe_logical_OR_exp()
            return false ;
        } // else()
        
    } // Romce_and_romloe()
    
    private boolean Rest_of_maybe_logical_OR_exp() {
        
        if ( Rest_of_maybe_logical_AND_exp() ) { // 如果是 Rest_of_maybe_logical_AND_exp()
            
            boolean breakk = false ;
            
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == OR ) { // 如果是 OR
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;
                    
                    if ( Maybe_logical_AND_exp() ) { // 如果是 Maybe_logical_AND_exp()
                        
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
                    
                    System.out.println("===== Rest_of_maybe_logical_OR_exp() 1 =====") ;
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
            
            boolean breakk = false ;
            
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;
                    
                    if ( Maybe_bit_OR_exp() ) { // 如果是 Maybe_bit_OR_exp()
                        
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
                    
                    System.out.println("===== Maybe_logical_AND_exp() 1 =====") ;
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
    
    private boolean Rest_of_maybe_logical_AND_exp() {
        
        if ( Rest_of_maybe_bit_OR_exp() ) { // 如果是 Rest_of_maybe_bit_OR_exp()
            
            boolean breakk = false ;
            
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == AND ) { // 如果是 AND
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;
                    
                    if ( Maybe_bit_OR_exp() ) { // 如果是 Maybe_bit_OR_exp()
                        
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
                    
                    System.out.println("===== Rest_of_maybe_logical_AND_exp() 1 =====") ;
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
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_bit_ex_OR_exp() ) { // 如果是 Maybe_bit_ex_OR_exp()

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
                    
                    System.out.println("===== Maybe_bit_OR_exp() 1 =====") ;
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
    
    private boolean Rest_of_maybe_bit_OR_exp() {
        
        if ( Rest_of_maybe_bit_ex_OR_exp() ) { // 如果是 Rest_of_maybe_bit_ex_OR_exp()
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_bit_ex_OR_exp() ) { // 如果是 Maybe_bit_ex_OR_exp()

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
                    
                    System.out.println("===== Rest_of_maybe_bit_OR_exp() =====") ;
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
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_bit_AND_exp() ) { // 如果是 Maybe_bit_AND_exp()

                    } // if()
                    else { // 不是 Maybe_bit_AND_exp()
                        return false ;
                    } // else()

                } // if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Maybe_bit_ex_OR_exp 1 =====") ;
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
    
    private boolean Rest_of_maybe_bit_ex_OR_exp() {
        
        
        if ( Rest_of_maybe_bit_AND_exp() ) { // 如果是 Rest_of_maybe_bit_AND_exp()
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == POW ) { // 如果是 '^'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_bit_AND_exp() ) { // 如果是 Maybe_bit_AND_exp()

                    } // if()
                    else { // 不是 Maybe_bit_AND_exp()
                        return false ;
                    } // else()

                } // if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Rest_of_maybe_bit_ex_OR_exp() 1 =====") ;
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
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_equality_exp() ) { // 如果是 Maybe_equality_exp()

                    } // if()
                    else { // 不是 Maybe_equality_exp()
                        return false ;
                    } // else()

                } // if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Maybe_bit_AND_exp() 1 =====") ;
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
    
    private boolean Rest_of_maybe_bit_AND_exp() {
        
        if ( Rest_of_maybe_equality_exp() ) { // 如果是 Rest_of_maybe_equality_exp()
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_equality_exp() ) { // 如果是 Maybe_equality_exp()

                    } // if()
                    else { // 不是 Maybe_equality_exp()
                        return false ;
                    } // else()

                } // if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Rest_of_maybe_bit_AND_exp() 1 =====") ;
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
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == EQ
                     || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_relational_exp() ) { // 如果是 Maybe_relational_exp()

                    } // if()
                    else { // 不是 Maybe_relational_exp()
                        return false ;
                    } // else()

                } // if()
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    breakk = true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    System.out.println("===== Maybe_equality_exp() 1 =====") ;
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
    
    private boolean Rest_of_maybe_equality_exp() {
        
        if ( Rest_of_maybe_relational_exp() ) { // 如果是 Rest_of_maybe_relational_exp()
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == EQ
                     || Get_Now_Token_Tpye() == NEQ ) { // 如果是 '==' 或 '!='
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_relational_exp() ) { // 如果是 Maybe_relational_exp()

                    } // if()
                    else { // 不是 Maybe_relational_exp()
                        return false ;
                    } // else()

                } // if()
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    breakk = true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Rest_of_maybe_equality_exp() 1 =====") ;
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
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == ST
                     || Get_Now_Token_Tpye() == BT
                     || Get_Now_Token_Tpye() == LE
                     || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_shift_exp() ) { // 如果是 Maybe_shift_exp()

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
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    breakk = true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Maybe_relational_exp() 1 =====") ;
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
    
    private boolean Rest_of_maybe_relational_exp() {
        
        if ( Rest_of_maybe_shift_exp() ) { // 如果是 Rest_of_maybe_shift_exp()
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == ST
                     || Get_Now_Token_Tpye() == BT
                     || Get_Now_Token_Tpye() == LE
                     || Get_Now_Token_Tpye() == GE ) { // 如果是 '>' 或 '<' 或 '>= 或 '<='
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_shift_exp() ) { // 如果是 Maybe_shift_exp()

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
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    breakk = true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Rest_of_maybe_relational_exp() 1 =====") ;
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
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == LS
                     || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_additive_exp() ) { // 如果是 Maybe_additive_exp()

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
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    breakk = true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Maybe_shift_exp() 1 =====") ;
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
    
    private boolean Rest_of_maybe_shift_exp() {
        
        if ( Rest_of_maybe_additive_exp() ) { // 如果是 Rest_of_maybe_additive_exp()
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == LS
                     || Get_Now_Token_Tpye() == RS ) { // 如果是 '>>' 或 '<<'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;
                    
                    if ( Maybe_additive_exp() ) { // 如果是 Maybe_additive_exp()
                        
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
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    breakk = true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    System.out.println("===== Rest_of_maybe_shift_exp() 1 =====") ;
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
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == ADD
                     || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Maybe_mult_exp() ) { // 如果是 Maybe_mult_exp()

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
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    breakk = true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    Print("Maybe_additive_exp() 1") ;
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
    
    private boolean Rest_of_maybe_additive_exp() {
        
        if ( Rest_of_maybe_mult_exp() ) { // 如果是 Rest_of_maybe_mult_exp()
            
            boolean breakk = false ;
            for ( ; !breakk ; ) {
                
                if ( Get_Now_Token_Tpye() == ADD
                     || Get_Now_Token_Tpye() == SUB ) { // 如果是 '+' 或 '-'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;
                    
                    if ( Maybe_mult_exp() ) { // 如果是 Maybe_mult_exp()
                        
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
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    breakk = true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
            
            if ( Rest_of_maybe_mult_exp() ) { // 如果是 Rest_of_maybe_mult_exp()
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
    
    private boolean Rest_of_maybe_mult_exp() {
        
        boolean breakk = false ;
        
        
        // 以下的 for 可以不要進
        for ( ; !breakk ; ) {
            
            if ( Get_Now_Token_Tpye() == MUL
                 || Get_Now_Token_Tpye() == DIV
                 || Get_Now_Token_Tpye() == PA ) { // 如果是 '*' 或 '/' 或 '%'
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                
                if ( Unary_exp() ) { // 如果是 Unary_exp()
                    
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
            else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                // 先不要讀掉
                breakk = true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
            Print("Rest_of_maybe_mult_exp() Error") ;
            return false ;
        } // else()
        
    } // Rest_of_maybe_mult_exp()
    
    private boolean Unary_exp() {
        
        String save_id = "" ;
        
        if ( Get_Now_Token_Tpye() == PP
             || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
            Get_Token() ;
            
            if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
                
                save_id = Return_Token() ; // 暫存此 id 
                
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                
                if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
                    
                    if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                        // 就設定錯誤
                        Set_Error( save_id, ID, true ) ;
                    } // if()
                    
                    System.out.println("===== Unary_exp() 1 =====") ;

                    return false ;
                } // if()
                
                // 以下為可要可不要
                
                if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                    Get_Token() ;

                    if ( Expression() ) { // 如果是 Expression()

                        if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
                            Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                            Get_Token() ;
                            
                            return true ;
                        } // if()
                        else { // 不是 ']'
                            if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                                // 就設定錯誤
                                Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                            } // if()
                            
                            System.out.println("===== Unary_exp() 2 =====") ;
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
                else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                    // 先不要讀掉
                    return true ;
                } // else if()
                else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                    
                    return false ;
                } // else()
            } // if()
            else { // 不是 id
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                } // if()
                
                System.out.println("===== Unary_exp() 3 =====") ;
                return false ;
            } // else()
            
        } // if()
        else if ( Get_Now_Token_Tpye() == ID 
                  || Get_Now_Token_Tpye() == CONSTANT
                  || Get_Now_Token_Tpye() == LP ) { // 如果是 ID 或是 constant 或是 '('
            
            // 先不要拿
            if ( Unsigned_unary_exp() ) { // 如果是 Unsigned_unary_exp()
                return true ;
            } // if()
            else { // 不是 Unsigned_unary_exp()
                
                return false ;
            } // else()
            
        } // else if()
        else if ( Sign() ) { // 如果是 sign()
            
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
                    
                } // else if()
                else { // 不是 sign()
                    breakk = true ;
                } // else()
                
            } // for()
            
            if ( Signed_unary_exp() ) { // 如果是 Signed_unary_exp()
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
        
        if ( Get_Now_Token_Tpye() == ID ) { // 如果是 id
            
            save_id = Return_Token() ; // 暫存此 id 
            
            Get_Token() ;
            
            if ( !Same_Id( save_id, Get_My_Glo_Or_Loc_Id_Length(), Get_Is_Function() ) ) { // 如果此 id 未定義過
                
                if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                    // 就設定錯誤
                    Set_Error( save_id, ID, true ) ;
                } // if()
                
                System.out.println("===== Signed_unary_exp() 1 =====") ;
                
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
                    
                    System.out.println("===== Signed_unary_exp() 2 =====") ;
                    return false ;
                } // else()
            } // if()
            else if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;

                if ( Expression() ) { // 如果是 Expression()

                    if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
                        Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                        Get_Token() ;
                        return true ;
                    } // if()
                    else { // 不是 ']'
                        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                            // 就設定錯誤
                            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                        } // if()
                        
                        System.out.println("===== Signed_unary_exp() 3 =====") ;
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
            else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                // 先不要讀掉
                return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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

            System.out.println("===== Signed_unary_exp() 4 =====") ;
                
                return false ;
            } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
            
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
                    Get_Token() ;
                    
                    return true ;
                } // if()
                else { // 不是 ')'
                    if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                        // 就設定錯誤
                        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                    } // if()
                    
                    System.out.println("===== Signed_unary_exp() 5 =====") ;
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
            
            System.out.println("===== Signed_unary_exp() 6 =====") ;
            return false ;
        } // else()
    } // Signed_unary_exp()
    
    private boolean Unsigned_unary_exp() {
        
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
                
                System.out.println("===== Unsigned_unary_exp() 1 =====") ;
                
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
                        Print("Unsigned_unary_exp()_Error") ;
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

                        System.out.println("===== Unsigned_unary_exp() 2 =====") ;

                        return false ;
                    } // if()
                    
                    return true ;
                } // if()
                else { // 不是 ')'
                    if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                        // 就設定錯誤
                        Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                    } // if()
                    
                    System.out.println("===== Unsigned_unary_exp() 3 =====") ;
                    return false ;
                } // else()
            } // if()
            else if ( Get_Now_Token_Tpye() == LMP ) { // 如果是 '['
                Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
                Get_Token() ;
                
                if ( Expression() ) { // 如果是 Expression()
                    
                    if ( Get_Now_Token_Tpye() == RMP ) { // 如果是 ']'
                        save_id = Return_Token() ;
                        
                        Get_Token() ;
                        
                        if ( Get_Now_Token_Tpye() == PP
                             || Get_Now_Token_Tpye() == MM ) { // 如果是 '++' 或 '--'
                            // 就不要空格
                            Set_My_Now_Func_String( save_id, 0 ) ; // 存當下的 Function
                            
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
                        else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                            // 先不要讀掉
                            return true ;
                        } // else if()
                        else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                            
                            System.out.println("===== Unsigned_unary_exp() 4 =====") ;
                            return false ;
                        } // else()
                        
                    } // if()
                    else { // 不是 ']'
                        if ( !Get_Error_Token_Already_Set() ) { // 如果沒設定過錯誤
                            // 就設定錯誤
                            Set_Error( Return_Token(), Return_Token_Type(), false ) ;
                        } // if()
                        
                        System.out.println("===== Unsigned_unary_exp() 5 =====") ;
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
            else if ( Get_Now_Token_Tpye() == and ) { // 如果是 '&'
                // 先不要讀掉
                return true ;
            } // else if()
            else if ( Get_Now_Token_Tpye() == or ) { // 如果是 '|'
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
                
                System.out.println("===== Unsigned_unary_exp() 6 =====") ;
                return false ;
            } // else()
        } // if()
        else if ( Get_Now_Token_Tpye() == CONSTANT ) { // 如果是 Constant
            
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
            
            if ( Expression() ) { // 如果是 Expression()
                
                if ( Get_Now_Token_Tpye() == RP ) { // 如果是 ')'
                    Set_My_Now_Func_String( Return_Token(), 1 ) ; // 存當下的 Function
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
            
            System.out.println("===== Unsigned_unary_exp() 7 =====") ;
            return false ;
        } // else()
    } // Unsigned_unary_exp()
    
} // class Grammar
