package be.abis.exa6.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import be.abis.exa6.model.Address;
import be.abis.exa6.model.Company;
import be.abis.exa6.model.Person;

public class ExA6 {

	public static void main(String[] args) {
		Address address = new Address ("street address", "nr address", "zipCode address", "Leuven", "country address", "countryCode address");
		Company company = new Company ("ABIS", address);
		Person person = new Person (1, "Smits", "Ann" , LocalDate.of(1985,5,5),company);
		
		System.out.println(person);
		
		
		Person person2 = new Person (2, "Doe", "John" , LocalDate.of(1966,5,5));
		
		System.out.println(person2);

		ArrayList <Person> persons = new ArrayList <> ();
		persons.add(person);
		persons.add(person2);
		
		try {
			printPersony (persons);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printPersony(ArrayList <Person> persons) throws IOException {
		
		BufferedWriter bw = Files.newBufferedWriter(Paths.get("personinfo.txt"));
		
		String nextStr = ", ";
		for (int i = 0 ; i < persons.size(); i++) {
			Person person =  persons.get(i);
			bw.write(person + nextStr);
			if  (i ==  persons.size()-2) {
				nextStr = "\n";
			}
		}
		bw.close();
		
	}

}
