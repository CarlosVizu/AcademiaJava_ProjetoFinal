package ufn.atos.agfgestaodecoletas.service;

import java.util.List;
import java.util.Optional;

import ufn.atos.agfgestaodecoletas.model.Route;

public interface RouteService 
{
	public List<Route>listAll();
	public Optional<Route>listId(Integer id);
	public Route save(Route p);
	public void delete(Integer id);
}
