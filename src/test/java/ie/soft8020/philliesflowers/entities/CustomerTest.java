package ie.soft8020.philliesflowers.entities;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import ie.soft8020.philliesflowers.constants.Const;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CustomerTest{
	
	private int id = 1;
	private String name = "someone";
	private String emailAddress = "someone@email.com";
	
			
	@Test
	public void testBuilderWithDefaultValues() {
		Customer customerWithDefaultValues = Customer.builder(id, name, emailAddress)
				.build();
		
		assertThat(Const.ParamsNames.CUSTOMER_COMMENTS, is(customerWithDefaultValues.getComments()));
		assertThat(Const.ParamsNames.CUSTOMER_ADDRESS, is(customerWithDefaultValues.getAddress()));
		assertThat(Const.ParamsNames.CUSTOMER_PHONE_NUMBER, is(customerWithDefaultValues.getPhoneNumber()));		
	}
	
	@Test
    public void testBuilderWithNullOptionalArguments() {
		Customer customerWithNullOptionalArguments = Customer.builder(id, name, emailAddress)
				.withComments(null)
				.withAddress(null)
				.withPhoneNumber(null)
				.build();
		
		assertThat(Const.ParamsNames.CUSTOMER_COMMENTS, is(customerWithNullOptionalArguments.getComments()));
		assertThat(Const.ParamsNames.CUSTOMER_ADDRESS, is(customerWithNullOptionalArguments.getAddress()));
		assertThat(Const.ParamsNames.CUSTOMER_PHONE_NUMBER, is(customerWithNullOptionalArguments.getPhoneNumber()));
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBuilderWithNullRequiredNameParam() {
		Customer.builder(id, null, emailAddress)
				.build();
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBuilderWithNullRequiredEmailAddressParam() {
		Customer.builder(id, name, null)
				.build();
	}

}

