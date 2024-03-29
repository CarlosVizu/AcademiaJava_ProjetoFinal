package ufn.atos.agfgestaodecoletas.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufn.atos.agfgestaodecoletas.model.Delivery;
import ufn.atos.agfgestaodecoletas.model.PersonNatural;
import ufn.atos.agfgestaodecoletas.repository.DeliveryRepository;
import ufn.atos.agfgestaodecoletas.repository.PersonLegalRepository;
import ufn.atos.agfgestaodecoletas.repository.PersonNaturalRepository;
import ufn.atos.agfgestaodecoletas.repository.VehicleRepository;
import ufn.atos.agfgestaodecoletas.service.DeliveryService;
import ufn.atos.agfgestaodecoletas.service.PersonLegalService;
import ufn.atos.agfgestaodecoletas.service.PersonNaturalService;
import ufn.atos.agfgestaodecoletas.service.VehicleService;

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
	@Autowired
	private VehicleService vehicleService;
	
	//Listagem para visualização das coletas, tendo como variável as coletas com diversos status.
	@GetMapping("/list")
	public String listColeta(Model model) {
		List<Delivery> coleta = service.listAll();
		model.addAttribute("coletaList", coleta);
		model.addAttribute("personnatural", pessoaFisicaService.listAll());
		model.addAttribute("personlegal", pessoaJuridicaService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "listcoleta";
	}
	
	//Status da coleta como AGENDADO. 
	@GetMapping("/list/agendado")
	public String listColetaAgendado(Model model) {
		List<Delivery> coleta = service.listActive();
		model.addAttribute("coletaList", coleta);
		model.addAttribute("personnatural", pessoaFisicaService.listAll());
		model.addAttribute("personlegal", pessoaJuridicaService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "listcoleta";
	}
	//Status da coleta como EM ROTA. 
	@GetMapping("/list/rota")
	public String listColetaEmRota(Model model) {
		List<Delivery> coleta = service.listEmRota();
		model.addAttribute("coletaList", coleta);
		model.addAttribute("personnatural", pessoaFisicaService.listAll());
		model.addAttribute("personlegal", pessoaJuridicaService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "listcoleta";
	}
	//Status da coleta como CANCELADO. 
	@GetMapping("/list/cancelado")
	public String listColetaCancelada(Model model) {
		List<Delivery> coleta = service.listCancelado();
		model.addAttribute("coletaList", coleta);
		model.addAttribute("personnatural", pessoaFisicaService.listAll());
		model.addAttribute("personlegal", pessoaJuridicaService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "listcoleta";
	}
	//Status da coleta como ENCERRADO. 
	@GetMapping("/list/encerrada")
	public String listColetaEncerrada(Model model) {
		List<Delivery> coleta = service.listEncerrado();
		model.addAttribute("coletaList", coleta);
		model.addAttribute("personnatural", pessoaFisicaService.listAll());
		model.addAttribute("personlegal", pessoaJuridicaService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "listcoleta";
	}
	
	@GetMapping("/new")
	public String formColeta(Model model) {
		model.addAttribute("delivery", new Delivery());
		model.addAttribute("personnatural", pessoaFisicaService.listAll());
		model.addAttribute("personlegal", pessoaJuridicaService.listAll());
		model.addAttribute("vehicle", vehicleService.listAll());
		
		return "formnewcoleta";
	}
	
	@PostMapping("/new")
	public String saveColeta(Delivery coleta, Model model) {
		coleta.setStatus("AGENDADO");
		int volsize = ((coleta.getAltura() * coleta.getComprimento() * coleta.getLargura()) * coleta.getQtyitems());
		coleta.setVolsize(Float.intBitsToFloat(volsize));
		
		
		service.save(coleta);
		return "redirect:/coletas/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteColeta(Integer id) {
		Delivery delivery = data.getById(id);
		delivery.setStatus("CANCELADO");
		
		data.save(delivery);
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
	public String updateColeta(@RequestParam Integer id, @RequestParam int qtyitems, @RequestParam String description,
			@RequestParam Date date, @RequestParam Time time, @RequestParam String status,
			@RequestParam String closingdescription) {

		Delivery coleta = data.findById(id).get();
		
		coleta.setQtyitems(qtyitems);
		coleta.setDescription(description);
		coleta.setDate(date);
		coleta.setTime(time);
		//coleta.setDaily(daily);
		coleta.setStatus(status);
		coleta.setClosingdescription(closingdescription);
		int volsize = ((coleta.getAltura() * coleta.getComprimento() * coleta.getLargura()) * coleta.getQtyitems());
		coleta.setVolsize(Float.intBitsToFloat(volsize));
		
		data.save(coleta);
		return "redirect:/coletas/list";
	}
	

}
