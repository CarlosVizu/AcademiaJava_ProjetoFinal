package ufn.atos.agfgestaodecoletas.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufn.atos.agfgestaodecoletas.model.Delivery;
import ufn.atos.agfgestaodecoletas.repository.DeliveryRepository;
import ufn.atos.agfgestaodecoletas.service.DeliveryService;
import ufn.atos.agfgestaodecoletas.service.PersonLegalService;
import ufn.atos.agfgestaodecoletas.service.PersonNaturalService;

@Controller
@RequestMapping(("/coletas"))
public class DeliveryController 
{
	@Autowired
	private DeliveryRepository data;
	@Autowired
	private DeliveryService service;
	@Autowired
	private PersonNaturalService pessoaFisicaService;
	@Autowired
	private PersonLegalService pessoaJuridicaService;
	
	@GetMapping("/list")
	public String listColeta(Model model) {
		List<Delivery> coleta = service.listAll();
		model.addAttribute("coletaList", coleta);
		return "listcoleta";
	}
	
	@GetMapping("/new")
	public String formColeta(Model model) {
		model.addAttribute("coleta", new Delivery());
		model.addAttribute("pessoafisica", pessoaFisicaService.listAll());
		model.addAttribute("pessoajuridica", pessoaJuridicaService.listAll());
		
		return "formnewcoleta";
	}
	
	@PostMapping("/new")
	public String saveColeta(Delivery coleta, Model model) {
		coleta.setStatus("AGENDADO");
		service.save(coleta);
		return "redirect:/coletas/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteColeta(@PathVariable (value="id") Integer id) {
		data.deleteById(id);
		return "redirect:/coletas/list";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdateColeta(@PathVariable (value="id") Integer id, Model model) {
		Delivery coleta = data.getById(id);
		model.addAttribute("coleta", coleta);
		model.addAttribute("pessoafisica", pessoaFisicaService.listAll());
		model.addAttribute("pessoajuridica", pessoaJuridicaService.listAll());
		return "formupdcoleta";
	}
	
	@PostMapping("/update")
	public String updateColeta(@RequestParam Integer id, @RequestParam int qtyitems, @RequestParam String description
			, @RequestParam Float boxsize, @RequestParam Date date, @RequestParam Time time, @RequestParam boolean daily
			, @RequestParam String status ,@RequestParam String closingdescription) {

		Delivery coleta = data.findById(id).get();
		
		coleta.setQtyitems(qtyitems);
		coleta.setDescription(description);
		coleta.setVolsize(boxsize);
		coleta.setDate(date);
		coleta.setTime(time);
		coleta.setDaily(daily);
		coleta.setStatus(status);
		coleta.setClosingdescription(closingdescription);
		

		data.save(coleta);
		return "redirect:/coletas/list";
	}
}
