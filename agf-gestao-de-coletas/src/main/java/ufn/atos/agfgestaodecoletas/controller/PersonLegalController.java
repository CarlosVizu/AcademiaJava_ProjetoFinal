package ufn.atos.agfgestaodecoletas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufn.atos.agfgestaodecoletas.model.PersonLegal;
import ufn.atos.agfgestaodecoletas.model.Route;
import ufn.atos.agfgestaodecoletas.repository.PersonLegalRepository;
import ufn.atos.agfgestaodecoletas.service.PersonLegalService;

@Controller
@RequestMapping(("/clientejuridico"))
public class PersonLegalController 
{
	@Autowired
	private PersonLegalRepository data;
	
	@Autowired
	private PersonLegalService service;
	
	@GetMapping("/list")
	public String listPJuridica(Model model) {
		List<PersonLegal> persons = service.listAll();
		model.addAttribute("personList", persons);
		return "listpessoajuridica";
	}
	
	@GetMapping("/new")
	public String formPJuridica(Model model) {
		model.addAttribute("personLegal", new PersonLegal());
		return "formnewpessoajuridica";
	}
	
	@PostMapping("/new")
	public String savePJuridica(PersonLegal person, Model model) {
		service.save(person);
		return "redirect:/clientejuridico/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePJuridica(@PathVariable (value="id") Integer id) {
		data.deleteById(id);
		return "redirect:/clientejuridico/list";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdatePJuridica(@PathVariable (value="id") Integer id, Model model) {
		PersonLegal person = data.getById(id);
		model.addAttribute("personLegal", person);
		return "formupdpessoajuridica";
	}
	
	@PostMapping("/update")
	public String updatePJuridica(@RequestParam Integer id, @RequestParam String cnpj, @RequestParam String email, @RequestParam String name,
			@RequestParam String number, @RequestParam String address, @RequestParam String zipcode,
			@RequestParam String city, @RequestParam String description, @RequestParam Route route) {
		
		PersonLegal person = data.findById(id).get();
		
		
		person.setName(name);
		person.setCnpj(cnpj);
		person.setAddress(address);
		person.setZipcode(zipcode);
		person.setCity(city);
		person.setNumber(number);
		person.setDescription(description);
		person.setRoute(route);
		
		data.save(person);
		return "redirect:/clientejuridico/list";
	}
}
