import javax.xml.transform.sax.SAXSource;

public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();

        int[] locations = {3, 4, 5};
        dot.setLocationCells(locations);

        String userGuess = "5";
        String result = dot.checkYourself(userGuess);

        String testResult = "failed";
        if (result.equals("hit")) {
            testResult = "passed";
        }
        System.out.println(testResult);
    }
}
