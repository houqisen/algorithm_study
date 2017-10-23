public class CountPrime {
    public static void main(String ... args) {
        System.out.println(countPrimes(30));
    }

    public static int countPrimes(int n) {
        int count = 1;  // when n = 2
        boolean[] notPrime = new boolean[n];

        // loop odd number only
        for(int i=3; i<n; i+=2) {
            if (notPrime[i] == false) {
                count++;
                for(int j=3; i*j < n; j+=2) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}