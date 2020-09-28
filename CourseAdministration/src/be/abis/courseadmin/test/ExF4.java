package be.abis.courseadmin.test;

import java.util.ArrayList;

import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Instructor;

public class ExF4 {

	public static void main(String[] args) {
		
		
		Instructor instructor1 = new Instructor ("FirstNameInstr1", "LastNameInstr1", 25);
		Instructor instructor2 = new Instructor ("FirstNameInstr2", "LastNameInstr2", 36);
		
		ArrayList<Instructor> instructors = new ArrayList <> ();
		instructors.add(instructor1);
		instructors.add(instructor2);
		
		Course course = new Course ("Java", 15, 150.0, true, instructors);
	
		course.printInfoCourseAndInstructors();
	}

}
