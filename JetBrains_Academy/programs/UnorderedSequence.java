import java.util.Scanner;
public class UnorderedSequence {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number = scanner.nextInt();
        
        int greatestNum = number;
        int lowestNum = number;

        int givenNumebers = 0;

        int ascending = 1;
        int descending = 1;

        boolean ordered = false;

        while (number != 0) {

            number = scanner.nextInt();  

            givenNumebers++;

            if (number == 0) { break; }        

            if (number >= greatestNum) { 
                greatestNum = number;
                ascending++;
            }
            if (number <= lowestNum) {
                lowestNum = number;
                descending++;
            }
            if (greatestNum == lowestNum) {
                descending++;
                ascending++;            
            }
            

        }

        if (descending >= givenNumebers || ascending >= givenNumebers) { ordered = true; }

        System.out.println(ordered);


    }
}