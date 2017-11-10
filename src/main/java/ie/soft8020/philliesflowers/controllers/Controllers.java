package ie.soft8020.philliesflowers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ie.soft8020.philliesflowers.entities.Customer;
import ie.soft8020.philliesflowers.repositories.CustomerRepo;

@Controller
public class Controllers {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@GetMapping("/")
	public String doWelcomeWithParams(Model model) {
		return "index";
	}
	
	// An example of using a path variable.
	// localhost:8080/usingParameter?name=Cliona will add Cliona to the welcome
	// localhost:8080/usingParameter uses the default value of To You!
	@GetMapping("/usingParameter")
	public String doWelcomeWithParams(@RequestParam(value="name", defaultValue="To you!")String name, Model model) {
		String sentence = "Welcome " + name;
		model.addAttribute("message", sentence);
		return "parameter";
	}
	
	
	// The repository uses the in-built findAll() method of MongoRepository This
	// returns a list of People This list is added to the model The model is sent to
	// the displayAll.html template.
	@GetMapping("/displayall")
	public String displayAll(Model model) {
		List<Customer> customers = customerRepo.findAll();
		model.addAttribute("people", customers);
		return "displayAll";
	}

	
	@GetMapping("/displayOne/{id}")
	public String showMyDetails(@PathVariable int id, Model model) {
		Customer customer = customerRepo.findOne((int) id);
		model.addAttribute("customer", customer);
		return "displayOne";
	}
	
	
}


















 