
package pl_2;


public class TokenImfor {
    
    public String token = "" ; // 原始的 token
    public int type = -1 ; // 此 token 的型別
    public boolean is_Done = false ;
    public boolean is_ListAllVariables = false ; // 如果是呼叫 ListAllVariables
    public boolean is_ListAllFunctions = false ; // 如果是呼叫 ListAllFunctions
    public boolean is_ListVariable = false ; // 如果是呼叫 ListVariable
    public boolean is_ListFunction = false ; // 如果是呼叫 ListFunction
    public boolean is_String = false ; // 如果是 String 的 CONSTANT
    // 當要新增時，記得修改 claa "Grammar" 的 Function "Copy_my_TokenImfor"
    
    public TokenImfor() {
        
    } // TokenImfor()
    
} // class TokenImfor()
