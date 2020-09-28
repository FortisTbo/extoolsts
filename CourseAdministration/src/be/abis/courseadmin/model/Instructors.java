package be.abis.courseadmin.model;

import java.util.ArrayList;

public class Instructors {
	private ArrayList<Instructor> instructors = new ArrayList<Instructor> ();

	public Instructors() {
		
	}

	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(ArrayList<Instructor> instructors) {
		this.instructors = instructors;
	}
	
	public void addInstructor (Instructor instructor) {
		this.instructors.add(instructor);
	}
	
	public void printInstructors () {
		for (int i=0; i <instructors.size();i++ ) {
			Instructor instructor = this.instructors.get(i);
			System.out.println("- " + instructor.getFirstName() + " " + instructor.getLastName());
		}
	}
}
