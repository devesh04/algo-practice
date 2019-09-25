package practice;

import java.util.Stack;

/**
 * Created by devesh on 14/05/19.
 */
public class Parenthesis {

    public static boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.add(s.charAt(i));
            }
            else if(s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(s.charAt(i) == '}' && stack.pop().equals('{') ||
                        s.charAt(i) == ')' && stack.pop().equals('(') ||
                s.charAt(i) == ']' && stack.pop().equals('[')){
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String st[]){
        System.out.println(isCorrect("()"));
        System.out.println(isCorrect("{([asdas]sdasd)sads}"));
        System.out.println(isCorrect("){([asdas]sdasd)sads}"));
        System.out.println(isCorrect(")()"));
        System.out.println(isCorrect("[(aa)]["));
    }
}
