package ufn.atos.agfgestaodecoletas.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufn.atos.agfgestaodecoletas.model.Delivery;
import ufn.atos.agfgestaodecoletas.model.Transport;
import ufn.atos.agfgestaodecoletas.model.Vehicle;
import ufn.atos.agfgestaodecoletas.repository.DeliveryRepository;
import ufn.atos.agfgestaodecoletas.repository.TransportRepository;
import ufn.atos.agfgestaodecoletas.repository.VehicleRepository;
import ufn.atos.agfgestaodecoletas.service.DeliveryService;
import ufn.atos.agfgestaodecoletas.service.TransportService;
import ufn.atos.agfgestaodecoletas.service.VehicleService;

@Controller
@RequestMapping("/transporte")
public class TransportController 
{
	@Autowired
	private TransportRepository data;
	@Autowired
	private TransportService service;
	@Autowired
	private DeliveryRepository deliveryData;
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private VehicleRepository vehicleData;
	@Autowired
	private VehicleService vehicleService;
	
	
	@GetMapping("/list")
	public String listTransporte(Model model) {
		List<Transport> transport = service.listAll();
		model.addAttribute("transporteList", transport);
		return "listtransporte";
	}
	
	@GetMapping("/new")
	public String newTransporte(Model model) { 
		model.addAttribute("transporte", new Transport());
		model.addAttribute("coleta", deliveryService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "formnewtransporte";		
	}
	
	@PostMapping("/new")
	public String saveTransporte(Transport transport, Model model) {
		
		service.save(transport);
		return "redirect:/transporte/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTransporte(@PathVariable (value="id") Integer id) {
		data.deleteById(id);
		
		return "redirect:/transporte/list";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdateTransporte(@PathVariable (value="id") Integer id, Model model) {
		Transport transport = data.getById(id);
		model.addAttribute("transporte", transport);
		model.addAttribute("coleta", deliveryService.listAll());
		model.addAttribute("veiculo", vehicleService.listAll());
		return "formupdtransporte";
		
	}
	
	@PostMapping("/update")
	public String updateTransporte(@RequestParam Integer id, @RequestParam Set<Delivery> delivery,
			@RequestParam Vehicle vehicle, @RequestParam Date date, @RequestParam Time time,
			@RequestParam Float volsize, @RequestParam Integer qtyitems) {
		
		Transport transport = data.findById(id).get();
		
		transport.setDelivery(delivery);
		transport.setVehicle(vehicle);
		transport.setDate(date);
		transport.setTime(time);
		transport.setVolsize(volsize);
		transport.setQtyitems(qtyitems);
		
		data.save(transport);
		return "redirect:/transporte/list";
		
	}
	
}
