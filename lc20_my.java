class Solution {
    public boolean isValid(String s) {
        Stack<Integer> sk1 = new Stack<>();
        Stack<Integer> sk2 = new Stack<>();
        Stack<Integer> sk3 = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur == '(') {sk1.push(i); continue;}
            if(cur==')') {
                if(sk1.isEmpty()) return false;
                else if(!sk2.isEmpty()&&(sk2.peek()>sk1.peek())) return false;
                else if(!sk3.isEmpty()&&sk3.peek()>sk1.peek()) return false;
                else{
                sk1.pop();
                continue;
                }
            }
            if(cur =='[') {sk2.push(i);continue;}
            if(cur ==']') {
                if(sk2.isEmpty()) return false;
                else if(!sk1.isEmpty()&&(sk1.peek()>sk2.peek())) return false;
                else if(!sk3.isEmpty()&&sk3.peek()>sk2.peek()) return false;
                else{
                sk2.pop();
                continue;
                }
            }
            if(cur == '{'){sk3.push(i);continue;}
            if(cur=='}'){
                if(sk3.isEmpty()) return false;
                else if(!sk1.isEmpty()&&(sk1.peek()>sk3.peek())) return false;
                else if(!sk2.isEmpty()&&sk2.peek()>sk3.peek()) return false;
                else{
                sk3.pop();
                continue;
                }
            }
        }
        if(sk1.isEmpty()&&sk2.isEmpty()&&sk3.isEmpty()) return true;
        else return false;
    }
}