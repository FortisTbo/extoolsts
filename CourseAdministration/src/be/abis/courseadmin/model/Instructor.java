package be.abis.courseadmin.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Instructor {
	private String firstName;
	private String lastName;
	private String birthDate;
	private int startAge;
	private double startSalary;

	public Instructor(String firstName, String lastName, String birthDate, int startAge, double startSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setBirthDate(birthDate);
		this.startAge = startAge;
		this.startSalary = startSalary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate birthDate = LocalDate.parse(getBirthDate(), formatter);
		LocalDate currentDate = LocalDate.now();
		  
		return Period.between(birthDate, currentDate).getYears();
	}

	public double getStartSalary() {
		return startSalary;
	}

	public void setStartSalary(double startSalary) {
		this.startSalary = startSalary;
	}

	public int getStartAge() {
		return startAge;
	}

	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}

	public void printSalaryHistory(String outputFile) throws IOException {
		int seniority = 0;
		double salary = startSalary;
		int age = getAge();
		BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputFile));
		for (int loopAge = startAge; loopAge <= age; loopAge += 5) {
			if (loopAge != startAge) {
				salary = salary * 1.03;
			}

			bw.write("Salary of " + firstName + " at " + loopAge + " is " + salary + ".\n");
			System.out.println("Salary of " + firstName + " at " + loopAge + " is " + salary + ".\n");
			if (seniority < 35) {
				seniority += 5;
			} else {
				bw.write("Maximum salary reached.");
				System.out.println("Maximum salary reached.");
				break;
			}
		}
		bw.close();
		System.out.println(outputFile + " created");
	}

	public void printSalaryHistory() throws IOException {
		printSalaryHistory("salaryhistory.txt");
	}

	public String toString() {
		
		return firstName + " " + lastName + " (" +  getAge() +")";
	}
}
