package calculator;

import java.util.Scanner;

public class GetInput {
	public static String getInput() {
		System.out.println("input : ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
