
import java.util.*;
import java.util.Scanner;

public class Evaluate {
	
    public static void main(String[] args) {
	final var operators = new Stack<String>();
	final var operands = new Stack<Double>();
	final Scanner scanner = new Scanner(System.in);
	String val = scanner.next();
	while (!val.isEmpty()) {
	    if (isOperator(val)){
	        operators.push(val);
	    } else if (")".equals(val)){
		System.out.println("pop operands and operator and perform specific operation");
	    } else {
		operands.push(Double.parseDouble(val));
	    }
	    val = scanner.next();
	}
	for (String op : operators) {
	    System.out.println(op);
	}
	for (Double opr : operands) {
	    System.out.println(opr);
	}
	scanner.close();
    }

    private static boolean isOperator(String operator) {
	String[] validOperators = {"+", "-", "*", "/"};
	for (String op : validOperators) {
	    if (op.equals(operator)) {
		return true;
	    }
	}
	return false;
    }
}
