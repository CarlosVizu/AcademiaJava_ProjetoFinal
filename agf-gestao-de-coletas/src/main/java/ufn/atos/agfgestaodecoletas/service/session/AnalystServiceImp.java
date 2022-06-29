package ufn.atos.agfgestaodecoletas.service.session;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufn.atos.agfgestaodecoletas.model.Analyst;
import ufn.atos.agfgestaodecoletas.repository.AnalystRepository;
import ufn.atos.agfgestaodecoletas.service.AnalystService;

@Service
public class AnalystServiceImp implements AnalystService
{
	
	@Autowired
	private AnalystRepository data;
	
	public List<Analyst> listAll(){
		return (List<Analyst>)data.findAll();
	}
	
	public Optional<Analyst> listId(Integer id){
		return data.findById(id);
	}
	
	public Analyst save(Analyst p) {
		
		Analyst person = data.save(p);
		return person;
		
	}
	
	public void delete(Integer id) { 
		data.deleteById(id);
	}
	
}
