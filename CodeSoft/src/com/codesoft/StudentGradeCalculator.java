package com.codesoft;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		GradeCalculator g = new GradeCalculator();
		g.studentGradeCalculator();
	}
}

class GradeCalculator {
	public void studentGradeCalculator() {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number of subjects");
		int totalSubjects = scn.nextInt();
		if (totalSubjects > 10 || totalSubjects <= 0) {
			while (true) {
				System.out.println("your entered subject is out of range or invalid number");
				System.out.println("Please enter number of subjects");
				totalSubjects = scn.nextInt();
				if (totalSubjects < 10)
					break;
			}
		}
		int totalMarks = 0;

		for (int i = 0; i < totalSubjects; i++) {
			System.out.println("Enter the Marks obtained in subject " + (i + 1));
			int subjectMarks = scn.nextInt();
			if (subjectMarks >= 101 || subjectMarks <= 0) {
				while (true) {
					System.out.println("your entered subject " + (i + 1) + " subjectMarks is out of range or invalid number");
					System.out.println("Please Enter the Marks obtained in subject " + (i + 1));
					subjectMarks = scn.nextInt();
					if (subjectMarks < 101)
						break;
				}
			}
			totalMarks += subjectMarks;
		}
		int averagePercentage = totalMarks / totalSubjects;

		String Grade = grade(averagePercentage);

		System.out.println("Total subjectMarks :" + totalSubjects * 100);
		System.out.println("Total Marks obtained : " + totalMarks);
		System.out.println("Percentage obtained : " + averagePercentage + "%");
		System.out.println("Grade obtained : " + Grade);

		scn.close();
	}

	public String grade(int averagePercentage) {
		switch (averagePercentage / 10) {
		case 10:
			return "A+";
		case 9:
			return "A";
		case 8:
			return "B+";
		case 7:
			return "B";
		case 6:
			return "C";
		case 5:
			return "D";
		default:
			return "F";
		}
	}
}
