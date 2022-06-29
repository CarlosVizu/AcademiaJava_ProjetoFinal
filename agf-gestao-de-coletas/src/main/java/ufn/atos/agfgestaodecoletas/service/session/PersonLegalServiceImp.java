package ufn.atos.agfgestaodecoletas.service.session;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufn.atos.agfgestaodecoletas.model.PersonLegal;
import ufn.atos.agfgestaodecoletas.repository.PersonLegalRepository;
import ufn.atos.agfgestaodecoletas.service.PersonLegalService;

@Service
public class PersonLegalServiceImp implements PersonLegalService
{
	
	@Autowired
	private PersonLegalRepository data;
	
	public List<PersonLegal> listAll(){
		return (List<PersonLegal>)data.findAll();
	}
	
	public Optional<PersonLegal> listId(Integer id){
		return data.findById(id);
	}
	
	public PersonLegal save(PersonLegal p) {
		
		PersonLegal person = data.save(p);
		return person;
		
	}
	
	public void delete(Integer id) { 
		data.deleteById(id);
	}
	
}
