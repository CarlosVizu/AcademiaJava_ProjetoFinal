package ufn.atos.agfgestaodecoletas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonDeliveryRoute 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	Integer id_person;
	
	Integer id_delivery;
	
	Integer id_route;
	
	Integer id_vehicle;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_person() {
		return id_person;
	}

	public void setId_person(Integer id_person) {
		this.id_person = id_person;
	}

	public Integer getId_delivery() {
		return id_delivery;
	}

	public void setId_delivery(Integer id_delivery) {
		this.id_delivery = id_delivery;
	}

	public Integer getId_route() {
		return id_route;
	}

	public void setId_route(Integer id_route) {
		this.id_route = id_route;
	}

	public Integer getId_vehicle() {
		return id_vehicle;
	}

	public void setId_vehicle(Integer id_vehicle) {
		this.id_vehicle = id_vehicle;
	}
	
	
	
	

}
