public class OmgArray {

    public static void main(String[] args) {
        boolean[][] test = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + i + ", " + j + "]");
            }
            System.out.println("");
        }
    }
}
