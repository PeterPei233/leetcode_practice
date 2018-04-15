class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int stackPos = -1;
     
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i); 
            if (c == ')' || c == '}' || c == ']') {
                if (stackPos == -1 || stack[stackPos] != c) {
                    return false;
                }
                --stackPos;
            } else if (c == '(' || c == '{' || c == '[') {
                ++stackPos;
                stack[stackPos] = (char)((1 + c)|1);
            }
        }
        
        return stackPos == -1;
    }
}