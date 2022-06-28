package ufn.atos.agfgestaodecoletas.service.session;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufn.atos.agfgestaodecoletas.model.PersonNatural;
import ufn.atos.agfgestaodecoletas.repository.PersonNaturalRepository;
import ufn.atos.agfgestaodecoletas.service.PersonNaturalService;

@Service
public class PersonNaturalServiceImp implements PersonNaturalService
{
	
	@Autowired
	private PersonNaturalRepository data;
	
	public List<PersonNatural> listAll(){
		return (List<PersonNatural>)data.findAll();
	}
	
	public Optional<PersonNatural> listId(Integer id){
		return data.findById(id);
	}
	
	public PersonNatural save(PersonNatural p) {
		
		PersonNatural person = data.save(p);
		return person;
		
	}
	
	public void delete(Integer id) { 
		data.deleteById(id);
	}
	
}
