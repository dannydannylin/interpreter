
package pl_2;


public class Id {
    
    public String id_string = "" ; 
    public float id_num = -9487 ; 
    
    // ====== 一般變數 ======
    public Variable[] my_Variable = new Variable[50] ;
    public int var_num = 0 ;
    public boolean new_def = false ;
    public int type = -1 ;
    public String array_num = "" ; // [num]
    
    // ====== Function ======
    public boolean is_Function = false ; // 判斷此 Id 為 一般變數 或 Function 變數 // 給單一 Id 串 // 非陣列
    public Variable[] my_Func_Variable = new Variable[50] ; // Function 的變數
    public int Func_var_num = 0 ;
    public int Func_type = -1 ;
    public String Function_String = "" ; // 存整個 Function
    
    public Id() {
        
    } // Id()
    
} // class Id
