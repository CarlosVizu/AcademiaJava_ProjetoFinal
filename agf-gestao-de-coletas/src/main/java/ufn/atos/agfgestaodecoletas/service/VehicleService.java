package ufn.atos.agfgestaodecoletas.service;

import java.util.List;
import java.util.Optional;

import ufn.atos.agfgestaodecoletas.model.Vehicle;

public interface VehicleService 
{
	public List<Vehicle>listAll();
	public Optional<Vehicle>listId(Integer id);
	public Vehicle save(Vehicle p);
	public void delete(Integer id);
}
