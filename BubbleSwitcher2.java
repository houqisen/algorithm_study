import java.util.*;

public class BubbleSwitcher2 {
    public static void main(String ... args) {
        System.out.println(flipLights(3, 2));
    }

    public static int flipLights(int n, int m) {
        Set<String> set = new HashSet<>();
        char[] lights = new char[n];
        Arrays.fill(lights, '1');
        String strLights = new String(lights);
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(strLights);
        
        int i = 1;
        while(i <= m) {
            set.clear();
            int size = queue.size();
            for(int j=0; j<size; j++) {
                String cur = queue.poll();
                
                String s = flipAll(cur);
                if (!set.contains(s)) {
                    queue.add(s);
                    set.add(s);
                }
                
                s = flipEven(cur);
                if (!set.contains(s)) {
                    queue.offer(s);
                    set.add(s);
                }
                
                s = flipOdd(cur);
                if (!set.contains(s)) {
                    queue.offer(s);
                    set.add(s);
                }
                
                s = flipSpec(cur);
                if (!set.contains(s)) {
                    queue.offer(s);
                    set.add(s);
                }
            }
            i++;
        }
        
        return set.size();
    }
    
    private static String flipAll(String lights) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lights.length(); i++) {
            if (lights.charAt(i) == '1')
                sb.append("0");
            else
                sb.append("1");
        }
        return sb.toString();
    }
    
    private static String flipEven(String lights) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lights.length(); i++) {
            if ((i+1)%2 == 0) {
                if (lights.charAt(i) == '1') {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                sb.append(lights.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    private static String flipOdd(String lights) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lights.length(); i++) {
            if (i%2 == 0) {
                if (lights.charAt(i) == '1') {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                sb.append(lights.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    private static String flipSpec(String lights) {
        StringBuilder sb = new StringBuilder();
        int k=0;
        for(int i=0; i<lights.length(); i++) {
            if (3*k+1 == i+1) {
                if (lights.charAt(i) == '1') {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
                k++;
            } else {
                sb.append(lights.charAt(i));
            }
        }
        
        return sb.toString();
    }
}