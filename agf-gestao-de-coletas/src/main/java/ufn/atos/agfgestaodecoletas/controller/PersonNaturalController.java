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
import org.springframework.web.bind.annotation.ResponseBody;

import ufn.atos.agfgestaodecoletas.model.PersonNatural;
import ufn.atos.agfgestaodecoletas.model.Route;
import ufn.atos.agfgestaodecoletas.repository.PersonNaturalRepository;
import ufn.atos.agfgestaodecoletas.service.PersonNaturalService;

@Controller
@RequestMapping(("/clientefisico"))
public class PersonNaturalController 
{
	@Autowired
	private PersonNaturalRepository data;
	
	@Autowired
	private PersonNaturalService service;
	
	@GetMapping("/list")
	public String listPFisica(Model model) {
		List<PersonNatural> persons = service.listAll();
		return "listpessoafisica";
	}
	
	@GetMapping("/new")
	public String formPFisica(Model model) {
		model.addAttribute("personnatural", new PersonNatural());
		return "formnewpessoafisica";
	}
	
	@PostMapping("/new")
	public String savePFisica(PersonNatural person, Model model) {
		service.save(person);
		return "redirect:/clientefisico/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePFisica(@PathVariable (value="id") Integer id) {
		service.delete(id);
		return "redirect:/clientefisico/list";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdatePFisica(@PathVariable (value="id") Integer id, Model model) {
		PersonNatural person = data.getById(id);
		model.addAttribute("personnatural", person);
		return "formupdpessoafisica";
	}
	
	@PostMapping("/update")
	public @ResponseBody String updatePFisica(@RequestParam Integer id,@RequestParam String cpf, @RequestParam String name,
			@RequestParam String address, @RequestParam String zipcode, @RequestParam String city,
			@RequestParam String description, @RequestParam Route route) {
		
		PersonNatural person = data.findById(id).get();
		
		person.setName(name);
		person.setCpf(cpf);
		person.setAddress(address);
		person.setZipcode(zipcode);
		person.setCity(city);
		person.setDescription(description);
		person.setRoute(route);
		
		data.save(person);
		return "redirect:/clientefisico/list";
	}
}
