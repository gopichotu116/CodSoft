package com.codesoftTask1;

import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		
		randomGenerator rg = new randomGenerator();
		rg.numberGame();
	}
}

class randomGenerator {
	public int generateNumber(int maxNum, int minNum) {
		return (int) (Math.random() * (maxNum - minNum + 1) + minNum);
	}

	public void numberGame() {
		Scanner scn = new Scanner(System.in);
		int totalNoOfAttempts = 0;
		int winCount = 0;

		while (true) {
			
			System.out.println("Enter the minimum number");
			int minNum = scn.nextInt();
			
			System.out.println("Enter the maximum number");
			int maxNum = scn.nextInt();
			
			if (minNum > maxNum) {
				while (true) {
					System.out.println("Your entered a number, which is greater than maximum number");
					System.out.println("Please enter the minimum number");
					minNum = scn.nextInt();
					if (minNum < maxNum) break;
				}
			}
			scn.nextLine();
			
			int correctNum = generateNumber(maxNum, minNum);
			int attempts = 0;

			while (true) {
				System.out.println("Guess a number between " + minNum + " and " + maxNum);
				int guessNum = scn.nextInt();
				if (guessNum > maxNum || guessNum < minNum) {
					while (true) {
						System.out.println("Sorry enterd number is out of range");
						System.out.println("Enter the number between" + maxNum + " and " + minNum);
						guessNum = scn.nextInt();
						if (guessNum <= maxNum && guessNum >= minNum)
							break;
					}
				}
				attempts++;

				if (guessNum > correctNum) {
					System.out.println("Its Greater than actual number");
				} else if (guessNum < correctNum) {
					System.out.println("Its Lower than actual number");
				} else {
					System.out.println("your Guess is Correct");
					winCount++;
					break;
				}
			}

			totalNoOfAttempts += attempts;
			System.out.println("Attempts = " + attempts);
			System.out.println("Wins = " + winCount);

			double winrate = (double) winCount / totalNoOfAttempts * 100;
			System.out.printf("Your winrate is %.2f%%\n", winrate);

			System.out.println("Do you want to play again (yes/no)");
			String playAgain = scn.next();
			if (!playAgain.equalsIgnoreCase("yes")) {
				System.out.println("Thank you for playing this game, I hope you enjoyed the game");
				scn.close();
				System.exit(0);
			}
			scn.nextLine();
		}
	}
}
