package ie.soft8020.philliesflowers.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.soft8020.philliesflowers.repositories.CustomerRepo;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public void run(ApplicationArguments arg0) throws Exception {

		customerRepo.save(Customer.builder(1, "Brian Coveney", "brian@email.com")
				.withComments("I'd like flowers")
				.withAddress("Cork") 
				.withPhoneNumber("0872254586")
				.build());
		
		customerRepo.save(Customer.builder(2, "Peter Jones", "peter@email.com")
				.withComments("I'd like choclates")
				.withAddress("Limerick") 
				.withPhoneNumber("0872212386")
				.build());
		
		customerRepo.save(Customer.builder(3, "Jessica Footy", "jessica@email.com")
				.withComments("I'd like flowers and choclates")
				.withAddress("Dublin") 
				.withPhoneNumber("0873456586")
				.build());
	}
	
}
