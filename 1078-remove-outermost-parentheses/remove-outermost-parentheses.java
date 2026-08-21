class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder st=new StringBuilder();
        int count=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                if(count>0) st.append(c);
                count++;
            }else{
                count--;
                if(count > 0) st.append(c);
            }
        }
        return st.toString();
        
    }
}