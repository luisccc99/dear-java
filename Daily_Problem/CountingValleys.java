public class CountingValleys {

	// return number of valleys traversed of path
	public static int countValleys(int steps, String path) {
		int seaLevel = 0;
		int altitude = 0;
		int valleys = 0;

		for (char step : path.toCharArray()) {
			if (step == 'U') {
				altitude++;
				if (altitude == seaLevel) {
					valleys++;
				}
			} else {
				altitude--;
			}
		}
		return valleys;
	}

	public static void main(String[] args) {
	// U means uphill and D downhill
	System.out.println(countValleys(8, "UDDDUDUU"));
	}
}	
