import java.util.Scanner;
class SampleSequence {
    public static void main(String[] args) {
        // put your code here
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        boolean ascending = true;
        boolean descending = true;
        
        while (true) {
            int nextNumber = input.nextInt();
            if (nextNumber == 0) {
                break;
            } else if (nextNumber < number) {
                ascending = false;
            } else if (nextNumber > number) {
                descending = false;
            }
            number = nextNumber;
        }  
        System.out.println(ascending || descending);
    }
}