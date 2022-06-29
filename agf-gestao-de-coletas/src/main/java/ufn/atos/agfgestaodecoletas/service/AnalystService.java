package ufn.atos.agfgestaodecoletas.service;

import java.util.List;
import java.util.Optional;

import ufn.atos.agfgestaodecoletas.model.Analyst;

public interface AnalystService 
{
	public List<Analyst>listAll();
	public Optional<Analyst>listId(Integer id);
	public Analyst save(Analyst p);
	public void delete(Integer id);
}
