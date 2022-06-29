package ufn.atos.agfgestaodecoletas.service.session;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufn.atos.agfgestaodecoletas.model.Driver;
import ufn.atos.agfgestaodecoletas.repository.DriverRepository;
import ufn.atos.agfgestaodecoletas.service.DriverService;

@Service
public class DriverServiceImp implements DriverService
{
	
	@Autowired
	private DriverRepository data;
	
	public List<Driver> listAll(){
		return (List<Driver>)data.findAll();
	}
	
	public Optional<Driver> listId(Integer id){
		return data.findById(id);
	}
	
	public Driver save(Driver p) {
		
		Driver Driver = data.save(p);
		return Driver;
		
	}
	
	public void delete(Integer id) { 
		data.deleteById(id);
	}
	
}

