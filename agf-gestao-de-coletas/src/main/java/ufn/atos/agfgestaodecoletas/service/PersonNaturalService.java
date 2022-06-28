package ufn.atos.agfgestaodecoletas.service;

import java.util.List;
import java.util.Optional;

import ufn.atos.agfgestaodecoletas.model.PersonNatural;

public interface PersonNaturalService 
{
	public List<PersonNatural>listAll();
	public Optional<PersonNatural>listId(Integer id);
	public PersonNatural save(PersonNatural p);
	public void delete(Integer id);
}
