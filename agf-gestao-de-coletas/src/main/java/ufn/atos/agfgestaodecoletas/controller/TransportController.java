package ufn.atos.agfgestaodecoletas.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufn.atos.agfgestaodecoletas.model.Delivery;
import ufn.atos.agfgestaodecoletas.model.PersonNatural;
import ufn.atos.agfgestaodecoletas.model.Transport;
import ufn.atos.agfgestaodecoletas.model.Vehicle;
import ufn.atos.agfgestaodecoletas.repository.DeliveryRepository;
import ufn.atos.agfgestaodecoletas.repository.TransportRepository;
import ufn.atos.agfgestaodecoletas.repository.VehicleRepository;
import ufn.atos.agfgestaodecoletas.service.DeliveryService;
import ufn.atos.agfgestaodecoletas.service.PersonNaturalService;
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
	private VehicleService vehicleService;
	@Autowired
	private PersonNaturalService personnaturalService;
	
	
	@GetMapping("/list")
	public String listTransporte(Model model) {
		List<Transport> transport = service.listAll();
		model.addAttribute("transporte", transport);
		model.addAttribute("delivery", deliveryService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "listtransporte";
	}
	
	@GetMapping("/gestao")
	public String gestaoTransporte(Model model) {
		//List<Transport> transport = service.listAll();
		List<Transport> transport = service.listActive();
		
		model.addAttribute("transporte", transport);
		model.addAttribute("personnatural", personnaturalService.listAll());
		model.addAttribute("personlegal", personnaturalService.listAll());
		model.addAttribute("coleta", deliveryService.listActive());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "gestaotransporte";
	}
	
	@GetMapping("/gestao/home")
	public String gestaoHome(Model model) {
		
		return "index";
	}
	
	@GetMapping("/new")
	public String newTransporte(Model model) { 
		model.addAttribute("transport", new Transport());
		model.addAttribute("delivery", deliveryService.listActive());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "formnewtransporte";		
	}
	
	@PostMapping("/new")
	public String saveTransporte(Transport transport, Model model) {
		int qtyitemsvar = 0;
		for (Delivery delivery : transport.getDelivery()) {
			delivery.setStatus("ROTA");
			qtyitemsvar = delivery.getQtyitems() + qtyitemsvar;
			deliveryData.save(delivery);
		}
		transport.setQtyitems(qtyitemsvar);
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
		model.addAttribute("transport", transport);
		model.addAttribute("delivery", deliveryService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		return "formupdtransporte";
		
	}
	
	@PostMapping("/update")
	public String updateTransporte(@RequestParam Integer id, @RequestParam Set<Delivery> delivery,
			@RequestParam Vehicle vehicle, @RequestParam Date date, @RequestParam Time time) {
		
		Transport transport = data.findById(id).get();
		
		transport.setDelivery(delivery);
		transport.setVehicle(vehicle);
		transport.setDate(date);
		transport.setTime(time);
		//transport.setVolsize(volsize);
		//transport.setQtyitems(qtyitems);
		
		data.save(transport);
		return "redirect:/transporte/list";
		
	}
	
}
