package ie.soft8020.philliesflowers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ie.soft8020.philliesflowers.entities.Customer;

public interface CustomerRepo extends MongoRepository<Customer, Integer> {

}
