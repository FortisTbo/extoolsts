package be.abis.exa6.test;

import java.time.LocalDate;

import be.abis.exa6.model.Address;
import be.abis.exa6.model.Company;
import be.abis.exa6.model.Person;

public class ExA6 {

	public static void main(String[] args) {
		Address address = new Address ("street address", "nr address", "zipCode address", "Leuven", "country address", "countryCode address");
		Company company = new Company ("ABIS", address);
		Person person = new Person (1, "Smits", "Ann" , LocalDate.of(1985,5,5),company);
		
		System.out.println(person);
		
		
		Person person2 = new Person (2, "Doe", "John" , LocalDate.of(1966,5,5),null);
		
		System.out.println(person2);


	}

}
