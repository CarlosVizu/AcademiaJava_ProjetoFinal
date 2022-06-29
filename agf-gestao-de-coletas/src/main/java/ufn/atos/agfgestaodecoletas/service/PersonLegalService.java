package ufn.atos.agfgestaodecoletas.service;

import java.util.List;
import java.util.Optional;

import ufn.atos.agfgestaodecoletas.model.PersonLegal;

public interface PersonLegalService 
{
	public List<PersonLegal>listAll();
	public Optional<PersonLegal>listId(Integer id);
	public PersonLegal save(PersonLegal p);
	public void delete(Integer id);
}
