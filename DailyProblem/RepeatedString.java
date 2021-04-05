import java.util.Arrays;

public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString(
                "ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",
                685118368975L) == 41107102139L);
    }

    public static long repeatedString(String s, long n) {
        if (s.length() == 1 && s.charAt(0) == 'a') {
            return n;
        }
        char c = 'a';
        char[] wordChars = s.toCharArray();
        Arrays.sort(wordChars);
        int charTimes = 0;

        // number of a's in string s and sorted to not be linear
        for (int i = 0; i < wordChars.length; i++) {
            if (c != wordChars[i]) {
                break;
            }
            charTimes++;
        }

        long times = (n / s.length());
        long remaining = n % s.length();
        int extra = 0;

        // count how many a's are left
        if (remaining != 0) {
            // remaining is always less than s.length()
            for (int i = 0; i < remaining; i++) {
                if (c == s.charAt(i)) {
                    extra++;
                }
            }
        }

        return times * charTimes + extra;
    }
}