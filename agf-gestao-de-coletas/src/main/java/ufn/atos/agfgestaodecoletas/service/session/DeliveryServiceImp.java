package ufn.atos.agfgestaodecoletas.service.session;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufn.atos.agfgestaodecoletas.model.Delivery;
import ufn.atos.agfgestaodecoletas.repository.DeliveryRepository;
import ufn.atos.agfgestaodecoletas.service.DeliveryService;

@Service
public class DeliveryServiceImp implements DeliveryService
{
	
	@Autowired
	private DeliveryRepository data;
	
	public List<Delivery> listAll(){
		return (List<Delivery>)data.findAll();
	}
	
	public Optional<Delivery> listId(Integer id){
		return data.findById(id);
	}
	
	public Delivery save(Delivery p) {
		
		Delivery Delivery = data.save(p);
		return Delivery;
		
	}
	
	public void delete(Integer id) { 
		data.deleteById(id);
	}
	
}

