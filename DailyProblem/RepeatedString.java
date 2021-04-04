
public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
    }

    public static long repeatedString(String s, long n) {
        if (s.length() == 1) {
            return n;
        }
        int repeated = 1;
        int index = 1;
        for (int i = 0; i < n; i++) {
            if (index == s.length()) {
                if (s.charAt(index - 1) == s.charAt(0)) {
                    repeated++;
                }
                index = 1;
            }
            if (s.charAt(index) == s.charAt(index - 1)) {
                
                index++;
                repeated++;
            }
        }
        return repeated;
    }
}