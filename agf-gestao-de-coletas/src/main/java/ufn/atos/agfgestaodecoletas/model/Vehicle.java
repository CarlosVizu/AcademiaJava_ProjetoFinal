package ufn.atos.agfgestaodecoletas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class Vehicle 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private Float volsize;
	
	
	@OneToOne(mappedBy = "vehicle", targetEntity = Driver.class)
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PersonDeliveryRoute> personDeliveryRoute;
	
	
	
	
	public Vehicle() {

	}

	public Vehicle(String name, String type, Float volsize) {
		super();
		this.name = name;
		this.type = type;
		this.volsize = volsize;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getVolsize() {
		return volsize;
	}

	public void setVolsize(Float volsize) {
		this.volsize = volsize;
	}

	
}
