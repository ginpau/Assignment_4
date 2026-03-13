import java.util.HashMap;
import java.util.LinkedList;

public class BalancedSymbol {

    public static void main(String[] args) {
        BalancedSymbol B = new BalancedSymbol();
        System.out.println(B.isBalanced("{[()]}"));
        System.out.println(B.isBalanced("{[(])}"));
        System.out.println(B.isBalanced("{{[[(()<>)]]}}"));


    }

    public String isBalanced(String s){
        String output = "";
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        map.put('>', '<');
        map.put('?', '¿');

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{' || c == '<' || c == '¿'){
                stack.addFirst(c);
            }else if(c == ')' || c == ']' || c == '}' || c == '>' || c == '?'){
                if(stack.isEmpty()){
                    return output = "NO";
                }

                if(map.get(c).equals(stack.peek())){
                    stack.remove();
                }else{
                    return output = "NO";
                }
            }
        }

        if(stack.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }

    }
}
