package ufn.atos.agfgestaodecoletas.service.session;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufn.atos.agfgestaodecoletas.model.Route;
import ufn.atos.agfgestaodecoletas.repository.RouteRepository;
import ufn.atos.agfgestaodecoletas.service.RouteService;

@Service
public class RouteServiceImp implements RouteService
{
	
	@Autowired
	private RouteRepository data;
	
	public List<Route> listAll(){
		return (List<Route>)data.findAll();
	}
	
	public Optional<Route> listId(Integer id){
		return data.findById(id);
	}
	
	public Route save(Route p) {
		
		Route route = data.save(p);
		return route;
		
	}
	
	public void delete(Integer id) { 
		data.deleteById(id);
	}
	
}
