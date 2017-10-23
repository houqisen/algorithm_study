public class GCD {
    public static void main(String ... args) {
        int x = 13, y = 11;
        System.out.println("x=" + x + ", y=" + y + ", gcd=" + gcd(x, y));
    }

    private static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x%y);
    }
}