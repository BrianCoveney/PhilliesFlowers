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
		customerRepo.save(new Customer("Brian Coveney", "brian@email.com", "I'd like flowers", "Cork", "0871124459"));
		customerRepo.save(new Customer("Peter Jones", "peter@email.com", "I'd like choclates", "Limerick", "0878122458"));
		customerRepo.save(new Customer("Jessica Foot", "jessica@email.com", "I'd like flowers", "Dublin", "0876152358"));
		
	}
	
	

}
