package hackerrank.joeunho.tech;

import java.util.Stack;

public class JTech1802 {
    public static void main(String[] args) {
        //[{()}]
        //String A = "3+[(5+1)-1]";
        //String A = "3+([5+1])";
        //String A = "3+{(5+1}";
        String A = "3+[{(5+1)-1}+3]";
        System.out.println(solution(A));
    }
    public static boolean solution(String A){
        boolean result = true;
        Stack<String> stack = new Stack<>();
        String[] arr = A.split("");
        String compare = null;

        for(String s : arr){
                if("[".equals(s)){
                    if(!stack.empty()) {
                        String check = stack.peek();
                        if ("{".equals(check) || "(".equals(check)) {
                            result = false;
                            break;
                        }
                    }
                    stack.push(s);
                }
                else if("{".equals(s)){
                    if(!stack.empty()) {
                        String check = stack.peek();
                        if ("(".equals(check)) {
                            result = false;
                            break;
                        }
                    }
                    stack.push(s);
                }
                else if("(".equals(s)){
                    stack.push(s);
                }


            if(")".equals(s) || "}".equals(s) || "]".equals(s)){
                if(!stack.empty()){
                    if(")".equals(s)){
                        compare = "(";
                    }
                    else if("}".equals(s)){
                        compare = "{";
                    }
                    else if("]".equals(s)){
                        compare = "[";
                    }
                    if(stack.peek().equals(compare)){
                        stack.pop();
                    }
                }
            }
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println(stack.toString()+" ");
        if(stack.size()!=0){
            result = false;
        }
        return result;
    }
}
