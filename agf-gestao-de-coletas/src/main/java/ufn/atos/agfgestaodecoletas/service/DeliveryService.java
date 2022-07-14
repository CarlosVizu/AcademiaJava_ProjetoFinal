package ufn.atos.agfgestaodecoletas.service;

import java.util.List;
import java.util.Optional;

import ufn.atos.agfgestaodecoletas.model.Delivery;

public interface DeliveryService 
{
	public List<Delivery>listAll();
	public Optional<Delivery>listId(Integer id);
	public Delivery save(Delivery p);
	public void delete(Integer id);
	public List<Delivery>listActive();
	public List<Delivery>listEmRota();
	public List<Delivery>listEncerrado();
	public List<Delivery>listCancelado();
}
