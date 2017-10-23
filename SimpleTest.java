import java.util.*;

public class SimpleTest {

    public static void main(String ... args) {
           String s = "01.0";

           String [] ss = s.split("\\.");

           System.out.println("ss.length = " + ss.length);
           
           System.out.println(Integer.parseInt(ss[0]));
    }
}