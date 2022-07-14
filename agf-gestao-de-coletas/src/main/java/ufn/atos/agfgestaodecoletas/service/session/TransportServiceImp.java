package ufn.atos.agfgestaodecoletas.service.session;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufn.atos.agfgestaodecoletas.model.Transport;
import ufn.atos.agfgestaodecoletas.repository.TransportRepository;
import ufn.atos.agfgestaodecoletas.service.TransportService;

@Service
public class TransportServiceImp implements TransportService
{
	
	@Autowired
	private TransportRepository data;
	
	public List<Transport> listAll(){
		return (List<Transport>)data.findAll();
	}
	
	public Optional<Transport> listId(Integer id){
		return data.findById(id);
	}
	
	public Transport save(Transport p) {
		
		Transport transport = data.save(p);
		return transport;
		
	}
	
	public void delete(Integer id) { 
		data.deleteById(id);
	}
	
	public List<Transport> listActive(){
		return(List<Transport>)data.transportActive();
	}
	
}
