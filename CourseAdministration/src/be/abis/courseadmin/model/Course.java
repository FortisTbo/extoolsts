package be.abis.courseadmin.model;

import java.io.*;
import java.util.ArrayList;

public class Course {
	private String title;
	private int numberOfDays;
	private double pricePerDay;
	private boolean priorKnowledgeRequired;
	private ArrayList<Instructor> instructors;

	public Course(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeRequired, ArrayList<Instructor> instructors) {
		this.title = title;
		this.numberOfDays = numberOfDays;
		this.pricePerDay = pricePerDay;
		this.priorKnowledgeRequired = priorKnowledgeRequired;
		this.instructors = instructors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public boolean isPriorKnowledgeRequired() {
		return priorKnowledgeRequired;
	}

	public void setPriorKnowledgeRequired(boolean priorKnowledgeRequired) {
		this.priorKnowledgeRequired = priorKnowledgeRequired;
	}
	
	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(ArrayList<Instructor> instructors) {
		this.instructors = instructors;
	}

	public void printInfoInFile() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("courseinfo.txt"));
		out.println(printInfo());
		out.close();
	}
	
	public void printInfoCourseAndInstructors() {
		String line = "Title=" + this.title + " / Number of days=" + this.numberOfDays + " / Price per day=" 
				+ this.pricePerDay + " / Prior knowledge is required=" + this.priorKnowledgeRequired;
	

		System.out.println(line);
		System.out.println("Give by : ");
		for (int i=0; i <instructors.size();i++ ) {
			Instructor instructor = this.instructors.get(i);
			System.out.println("- " + instructor.getFirstName() + " " + instructor.getLastName());
		}
	}
	
	public String printInfo() {
		String line = "Title=" + this.title + " / Number of days=" + this.numberOfDays + " / Price per day="
				+ this.pricePerDay + " / Prior knowledge is required=" + this.priorKnowledgeRequired
				+ " Total price of the course=" +  totalPriceCalculation() + " --> " + getLabel();

		return line;
	}

	public double totalPriceCalculation() {
		double price = this.pricePerDay * this.numberOfDays;
		double vat21;
		if (this.numberOfDays > 3 && this.priorKnowledgeRequired) {
			vat21 = 0.0;
		} else {
			vat21 = price * 0.21;
		}
		return price + vat21;
	}
	
	public String getLabel () {
		String label = "OK";
		double totalPrice = totalPriceCalculation();
		if (totalPrice < 500.0) {
			label = "CHEAP";
		} else if (totalPrice > 1500.0) {
			label = "EXPENSIVE";
		}
		
		return label;
		
	}
}
