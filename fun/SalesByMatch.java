import java.util.*;

public class SalesByMatch {

	static int matches(int n, int[] arr) {
		int index = 0, pair = 0, total = 0;
		int[] arcp = new int[n];
		
		System.arraycopy(arr, 0, arcp, 0, n);
		Arrays.sort(arcp);

		// array for a histogram
		int[] pairs = new int[n];

		for (int i = 0; i < n; i++) {
			pairs[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (arcp[i] == arcp[j]) {
					pairs[pair] += 1;
					index = j;
				}
			}
			pair++;
			if (index > i) {
				i = index;
			}
		}
		for (int i = 0; i < n; i++) {
			total += pairs[i] / 2;
		}
		return total;
	}

	public static void main(String[] args) {
		final var scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(matches(n, arr));
	}
}
