package be.abis.courseadmin.test;

import java.io.IOException;
import java.util.ArrayList;

import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Instructor;

public class ExG1 {

	public static void main(String[] args) {

		try {
			Instructor instructor1 = new Instructor("FirstNameInstr1", "LastNameInstr1", "16/08/1978", 23, 2000.0);
			instructor1.printSalaryHistory("salaryhistory1.txt");

			Instructor instructor2 = new Instructor("FirstNameInstr2", "LastNameInstr2", "16/08/1957", 25, 1900.0);
			instructor2.printSalaryHistory("salaryhistory2.txt");

			ArrayList<Instructor> instructors = new ArrayList<>();
			instructors.add(instructor1);
			instructors.add(instructor2);

			Course course = new Course("Java", 15, 150.0, true, instructors);

			course.printInfoCourseAndInstructors();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
