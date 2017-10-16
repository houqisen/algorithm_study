import java.util.Stack;

public class IsValid {
    public static void main(String ... args) {
        String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";

        System.out.println(isValid(code));
    }

    public static boolean isValid(String code) {
        if (code == null) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<code.length(); ) {
            if (i > 0 && stack.isEmpty()) return false;  //before finish scan all code, one tag as start must be there 
            if (code.startsWith("<![CDATA[", i)) {   // You must check this first
                int j = i+9;
                int p = code.indexOf("]]>", j);
                if (p < 0) return false;
                i = p+3;
            } else if (code.startsWith("</", i)) {   // then check this
                int j = i+2;
                int p = code.indexOf(">", j);
                if (p < 0 || p-j > 9 || p==j) return false;
                for(int k=j; k<p; k++) {
                    if (!Character.isUpperCase(code.charAt(k)))
                        return false;
                }
                if (stack.isEmpty() || !code.substring(j, p).equals(stack.pop())) {
                    return false;
                }
                i = ++p;
            } else if (code.startsWith("<", i)) {   // finally, to check the single '<'
                int j = i+1;
                int p = code.indexOf(">", j);
                if (p < 0 || p-j > 9 || p==j) return false;
                for(int k=j; k<p; k++) {
                    if (!Character.isUpperCase(code.charAt(k)))
                        return false;
                }
                stack.push(code.substring(j, p));
                i = ++p;
            }  else {
                i++;
            }
        }
        
        return stack.isEmpty();
    }
}