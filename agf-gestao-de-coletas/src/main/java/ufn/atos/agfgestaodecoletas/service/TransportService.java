package ufn.atos.agfgestaodecoletas.service;

import java.util.List;
import java.util.Optional;

import ufn.atos.agfgestaodecoletas.model.Transport;

public interface TransportService 
{
	public List<Transport>listAll();
	public Optional<Transport>listId(Integer id);
	public Transport save(Transport p);
	public void delete(Integer id);
}
