import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a]2[bc]"));
        System.out.println(ds.decodeString("3[a2[c]]"));
        System.out.println(ds.decodeString("2[abc]3[cd]ef"));

    }

    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> kStack = new Stack<>();
        String currentStack = "";
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stringStack.push(currentStack);
                kStack.push(k);
                currentStack = "";
                k = 0;
            } else if (c == ']') {
                int temp = kStack.pop();
                String previous = stringStack.pop();
                currentStack = previous + currentStack.repeat(temp);
            } else {
                currentStack += c;
            }

        }
        return currentStack;

    }

}
