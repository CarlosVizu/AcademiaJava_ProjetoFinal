package ufn.atos.agfgestaodecoletas.service;

import java.util.List;
import java.util.Optional;

import ufn.atos.agfgestaodecoletas.model.Driver;

public interface DriverService 
{
	public List<Driver>listAll();
	public Optional<Driver>listId(Integer id);
	public Driver save(Driver p);
	public void delete(Integer id);
}
