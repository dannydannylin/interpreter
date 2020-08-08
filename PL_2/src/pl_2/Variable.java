
package pl_2;


public class Variable {
    
    public String var = "" ;
    public boolean new_def = false ;
    public int type = -1 ;
    public String array_num = "" ; // [num]
    
    // ====== Function ======
    public boolean is_Function = false ; // 判斷此 Id 為 一般變數 或 Function 變數
    public int Func_type = -1 ;
    public String Function_String = "" ; // 存整個 Function
    
    // ====== 之前的 ======
    public int last_type = -1 ;
    public String last_array_num = "" ; // [num]
    public String last_Function_String = "" ;
    
    public Variable() {
        
    } // Variable()
    
} // class Variable
