public class Hourglass {

	public static void main(String[] args) {
		int[][] arr = 
		   {{1,1,1,0,0,0}, 
			{0,1,0,0,0,0},
		   	{1,1,1,0,0,0}, 
			{0,0,2,4,4,0},
			{0,0,0,2,0,0}, 
			{0,0,1,2,4,0}};
		hourglassSum(arr);
	}

	public static int hourglassSum(int[][] arr) {
		int N = 6;
		int colCount = 3;
		int rowCount = 3;
		int rowIndex = 0;
		int colIndex = 0;
		for (int i = 0; i < N; i++) {
			for (int j = colIndex; j < colCount; j++) {
				System.out.print("["+arr[i][j]+"]");
//				System.out.print("[colCount=" + colCount + ", rowCount=" + rowCount +"]");
				if (i == rowCount - 1) {
					if (j == N - 1) {
						rowIndex++;
						rowCount++;
						colCount = 3;
						colIndex = 0;
						System.out.println();
					}
				}
			}
			System.out.println();
			if (i == rowCount - 1) {
				i = rowIndex - 1;
				colCount++;
				colIndex++;
				System.out.println();
			}
		}
		return 0;
	}

}
