package main;

import java.util.Scanner;

public class Runner {

	/**
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter your desired number:");
		String inputString = reader.next();
		reader.close();
		
		StateData data = new StateData(inputString);
		
	}
}
