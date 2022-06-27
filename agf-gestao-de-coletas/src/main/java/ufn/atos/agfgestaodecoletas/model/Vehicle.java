package ufn.atos.agfgestaodecoletas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private Float volsize;
	
	Integer id_delivery;
	
	Integer id_driver;

	
	
	
	
	
	
	public Vehicle() {

	}

	public Vehicle(String name, String type, Float volsize, Integer id_driver) {
		super();
		this.name = name;
		this.type = type;
		this.volsize = volsize;
		this.id_driver = id_driver;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", type=" + type + ", volsize=" + volsize + ", id_delivery="
				+ id_delivery + ", id_driver=" + id_driver + "]";
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

	public Integer getId_delivery() {
		return id_delivery;
	}

	public void setId_delivery(Integer id_delivery) {
		this.id_delivery = id_delivery;
	}

	public Integer getId_driver() {
		return id_driver;
	}

	public void setId_driver(Integer id_driver) {
		this.id_driver = id_driver;
	}
	
	
	
	
	
}
