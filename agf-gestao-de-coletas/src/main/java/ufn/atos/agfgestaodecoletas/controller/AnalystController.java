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

import ufn.atos.agfgestaodecoletas.model.Analyst;
import ufn.atos.agfgestaodecoletas.repository.AnalystRepository;
import ufn.atos.agfgestaodecoletas.service.AnalystService;

@Controller
@RequestMapping(("/analista"))
public class AnalystController 
{
	@Autowired
	private AnalystRepository data;
	
	@Autowired
	private AnalystService service;
	
	@GetMapping("/list")
	public String listAnalista(Model model) {
		List<Analyst> analista = service.listAll();
		model.addAttribute("analistaList", analista);
		return "listanalista";
	}
	
	@GetMapping("/new")
	public String formAnalista(Model model) {
		model.addAttribute("analista", new Analyst());
		return "formnewanalista";
	}
	
	@PostMapping("/new")
	public String saveAnalista(Analyst analista, Model model) {
		service.save(analista);
		return "redirect:/analista/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAnalista(@PathVariable (value="id") Integer id) {
		data.deleteById(id);
		return "redirect:/analista/list";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdateAnalista(@PathVariable (value="id") Integer id, Model model) {
		Analyst analista = data.getById(id);
		model.addAttribute("analista", analista);
		return "formupdanalista";
	}
	
	@PostMapping("/update")
	public String updateAnalista(@RequestParam Integer id,@RequestParam String cpf, @RequestParam String name,
			@RequestParam String role) {
		
		Analyst analista = data.findById(id).get();
		
		analista.setName(name);
		analista.setCpf(cpf);
		analista.setRole(role);

		
		data.save(analista);
		return "redirect:/analista/list";
	}
}
