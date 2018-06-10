package ie.soft8020.philliesflowers.controllers;

import ie.soft8020.philliesflowers.entities.Customer;
import ie.soft8020.philliesflowers.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Controllers {

	@Autowired
	CustomerRepo customerRepo;

	@GetMapping("/")
	public String doWelcomeWithParams(Model model) {
		return "index";
	}


	// An example of using a path variable.
	// localhost:8081/usingParameter?name=Brian will add Brian to the welcome
	// localhost:8081/usingParameter uses the default value of To You!
	@GetMapping("/usingParameter")
	public String doWelcomeWithParams(@RequestParam(value="name", defaultValue="To You!")String name, Model model) {
		String sentence = "Welcome " + name;
		model.addAttribute("message", sentence);
		return "parameter";
	}


	// The repository uses the in-built findAll() method of MongoRepository This
	// returns a list of People This list is added to the model The model is sent to
	// the displayAll.html template.
	@GetMapping("/displayall")
	public String displayAll(Model model) {
		List<Customer> customer = customerRepo.findAll();
		model.addAttribute("customer", customer);
		return "displayAll";
	}


	// This uses a PathVariable to specify the id being searched for.
	// findOne() is the default method to search for one record using MongoRepository.
	// It returns one record.
	// This record is added to the model.
	// The model is sent to the displayOne.html resolver.
	@GetMapping("/displayOne/{id}")
	public String showMyDetails(@PathVariable int id, Model model) {
		Customer customer = customerRepo.findOne((int) id);
		model.addAttribute("customer", customer);
		return "displayOne";
	}


}


















