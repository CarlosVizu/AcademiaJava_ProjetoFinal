package ufn.atos.agfgestaodecoletas.service.session;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufn.atos.agfgestaodecoletas.model.Vehicle;
import ufn.atos.agfgestaodecoletas.repository.VehicleRepository;
import ufn.atos.agfgestaodecoletas.service.VehicleService;

@Service
public class VehicleServiceImp implements VehicleService
{
	
	@Autowired
	private VehicleRepository data;
	
	public List<Vehicle> listAll(){
		return (List<Vehicle>)data.findAll();
	}
	
	public Optional<Vehicle> listId(Integer id){
		return data.findById(id);
	}
	
	public Vehicle save(Vehicle p) {
		
		Vehicle Vehicle = data.save(p);
		return Vehicle;
		
	}
	
	public void delete(Integer id) { 
		data.deleteById(id);
	}
	
}

