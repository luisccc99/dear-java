public class Hourglass {

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		System.out.println(hourglassSum(arr));
	}

	public static int hourglassSum(int[][] arr) {
		int N = 6;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < N - 2; j++) {
				// sum of an hourglass
				int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (maxSum < sum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
}
