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

import ufn.atos.agfgestaodecoletas.model.Driver;
import ufn.atos.agfgestaodecoletas.repository.DriverRepository;
import ufn.atos.agfgestaodecoletas.service.DriverService;
import ufn.atos.agfgestaodecoletas.service.VehicleService;

@Controller
@RequestMapping(("/motoristas"))
public class DriverController 
{
	@Autowired
	private DriverRepository data;
	@Autowired
	private DriverService service;
	@Autowired
	private VehicleService serviceVehicle;
	
	@GetMapping("/list")
	public String listMotorista(Model model) {
		List<Driver> driver = service.listAll();
		model.addAttribute("veiculoList", driver);
		return "listmotorista";
	}
	
	@GetMapping("/new")
	public String formMotorista(Model model) {
		model.addAttribute("motorista", new Driver());
		model.addAttribute("allvehicles", serviceVehicle.listAll());
		return "formnewmotorista";
	}
	
	@PostMapping("/new")
	public String saveMotorista(Driver motorista, Model model) {
		service.save(motorista);
		return "redirect:/motoristas/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMotorista(@PathVariable (value="id") Integer id) {
		data.deleteById(id);
		return "redirect:/motoristas/list";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdateMotorista(@PathVariable (value="id") Integer id, Model model) {
		Driver motorista = data.getById(id);
		model.addAttribute("motorista", motorista);
		model.addAttribute("allvehicles", serviceVehicle.listAll());
		return "formupdmotorista";
	}
	
	@PostMapping("/update")
	public String updateMotorista(@RequestParam Integer id, @RequestParam String name, @RequestParam String cnh) {

		Driver motorista = data.findById(id).get();
		
		motorista.setName(name);
		motorista.setCnh(cnh);

		data.save(motorista);
		return "redirect:/motoristas/list";
	}
}
