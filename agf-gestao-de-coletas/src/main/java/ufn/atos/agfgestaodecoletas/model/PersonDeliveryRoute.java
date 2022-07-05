package ufn.atos.agfgestaodecoletas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "PersonDeliveryRoute")
public class PersonDeliveryRoute 
{
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Delivery.class, cascade = CascadeType.ALL)
	private List<Delivery> Deliveries;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
	@JoinColumn(name = "route_id")
	private Route route;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Vehicle.class)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


*/
}
