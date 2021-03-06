package be.abis.courseadmin.test;

import java.io.IOException;
import java.util.ArrayList;

import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Instructor;

public class ExF4 {

	public static void main(String[] args) {

		try {
			Instructor instructor1 = new Instructor("FirstNameInstr1", "LastNameInstr1", "16/08/2016", 23, 2000.0);
			instructor1.printSalaryHistory();

			Instructor instructor2 = new Instructor("FirstNameInstr2", "LastNameInstr2", "16/08/2016", 25, 1900.0);
			instructor2.printSalaryHistory();

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
