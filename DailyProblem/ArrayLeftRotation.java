import java.util.Scanner;

/**
 * A left rotation on an array shifts each of 
 * the array's elements 1 unit to the left.
 * e.g. if 3 left rotations are perfomed on [1, 2, 3, 4, 5]
 * the array would become [4, 5, 1, 2, 3]
 */
public class ArrayLeftRotation {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		final int timesToRotate = sc.nextInt();
		final int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(n);
		System.out.println(timesToRotate);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	/**
	 * @param arr array to rotate
	 * @param d number of times to shift elements on arr
	 * @return rotated array
	 */
	public static int[] rotLeft(int[] arr, int d) {
		for (int i = 0; i < d; i++) {

		}
		return null;
	}
}
