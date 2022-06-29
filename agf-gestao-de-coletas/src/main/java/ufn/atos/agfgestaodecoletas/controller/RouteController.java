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

import ufn.atos.agfgestaodecoletas.model.Route;
import ufn.atos.agfgestaodecoletas.repository.RouteRepository;
import ufn.atos.agfgestaodecoletas.service.RouteService;

@Controller
@RequestMapping(("/rotas"))
public class RouteController 
{
	@Autowired
	private RouteRepository data;
	
	@Autowired
	private RouteService service;
	
	@GetMapping("/list")
	public String listRota(Model model) {
		List<Route> Rota = service.listAll();
		model.addAttribute("rotaList", Rota);
		return "listrota";
	}
	
	@GetMapping("/new")
	public String formRota(Model model) {
		model.addAttribute("Rota", new Route());
		return "formnewrota";
	}
	
	@PostMapping("/new")
	public String saveRota(Route Rota, Model model) {
		service.save(Rota);
		return "redirect:/rotas/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRota(@PathVariable (value="id") Integer id) {
		data.deleteById(id);
		return "redirect:/rotas/list";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdateRota(@PathVariable (value="id") Integer id, Model model) {
		Route Rota = data.getById(id);
		model.addAttribute("Rota", Rota);
		return "formupdrota";
	}
	
	@PostMapping("/update")
	public String updateRota(@RequestParam Integer id,@RequestParam String name, @RequestParam String description) {
		
		Route rota = data.findById(id).get();
		
		rota.setName(name);
		rota.setDescription(description);

		
		data.save(rota);
		return "redirect:rotas/list";
	}
}
