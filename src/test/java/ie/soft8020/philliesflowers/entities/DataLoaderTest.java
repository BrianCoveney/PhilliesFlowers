package ie.soft8020.philliesflowers.entities;


import ie.soft8020.philliesflowers.constants.Const;
import ie.soft8020.philliesflowers.repositories.CustomerRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class DataLoaderTest {

    @Autowired
    private CustomerRepo customerRepo;

    private int id = 1;
    private String name = "someone";
    private String emailAddress = "someone@email.com";


    @Test
    public void testRun() {
        Customer customer = Customer.builder(id, name, emailAddress)
                .build();

        customer = customerRepo.save(customer);

        assertThat(Const.ParamsNames.CUSTOMER_COMMENTS, is(customer.getComments()));
        assertThat(Const.ParamsNames.CUSTOMER_ADDRESS, is(customer.getAddress()));
        assertThat(Const.ParamsNames.CUSTOMER_PHONE_NUMBER, is(customer.getPhoneNumber()));
    }


    @Test
    public void testFindAll() {
        customerRepo.save(Customer.builder(100, "Joe", "joe@email.com").withComments("Hello").build());
        customerRepo.save(Customer.builder(101, "Amy", "amy@email.com").withComments("world").build());

        List<Customer> customersSaved = customerRepo.findAll();
        assertThat(customersSaved, notNullValue());

        customerRepo.delete(100);
        customerRepo.delete(101);
    }


    @Test
    public void testFindOne() {
        int id = 103;
        String name = "Moe";
        String email= "moe@email.com";
        customerRepo.save(Customer.builder(id, name, email).withComments("Hello").build());

        Customer customerSaved = customerRepo.findOne(id);

        assertThat(id, is(customerSaved.getId()));
        assertThat(name, is(customerSaved.getName()));
        assertThat(email, is(customerSaved.getEmailAddress()));

        customerRepo.delete(id);
    }


}
