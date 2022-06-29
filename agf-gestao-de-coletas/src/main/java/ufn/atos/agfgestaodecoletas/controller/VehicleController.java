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

import ufn.atos.agfgestaodecoletas.model.Vehicle;
import ufn.atos.agfgestaodecoletas.repository.VehicleRepository;
import ufn.atos.agfgestaodecoletas.service.VehicleService;

@Controller
@RequestMapping(("/veiculos"))
public class VehicleController 
{
	@Autowired
	private VehicleRepository data;
	
	@Autowired
	private VehicleService service;
	
	@GetMapping("/list")
	public String listRota(Model model) {
		List<Vehicle> vehicle = service.listAll();
		model.addAttribute("veiculoList", vehicle);
		return "listrota";
	}
	
	@GetMapping("/new")
	public String formVeiculo(Model model) {
		model.addAttribute("veiculo", new Vehicle());
		return "formnewveiculo";
	}
	
	@PostMapping("/new")
	public String saveVeiculo(Vehicle veiculo, Model model) {
		service.save(veiculo);
		return "redirect:/veiculos/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteVeiculo(@PathVariable (value="id") Integer id) {
		data.deleteById(id);
		return "redirect:/veiculos/list";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdateRota(@PathVariable (value="id") Integer id, Model model) {
		Vehicle veiculo = data.getById(id);
		model.addAttribute("veiculos", veiculo);
		return "formupdveiculo";
	}
	
	@PostMapping("/update")
	public String updateVeiculo(@RequestParam Integer id, @RequestParam String name, @RequestParam String type,
			@RequestParam Float volsize) {

		Vehicle veiculo = data.findById(id).get();
		
		veiculo.setName(name);
		veiculo.setType(type);
		veiculo.setVolsize(volsize);
		
		
		data.save(veiculo);
		return "redirect:veiculos/list";
	}
}
