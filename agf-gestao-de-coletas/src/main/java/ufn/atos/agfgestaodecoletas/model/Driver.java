package ufn.atos.agfgestaodecoletas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Driver 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String cnh;
	
	@Column
	Integer id_vehicle;
	
	
	
	public Driver() {
	}

	public Driver(String name, String cnh, Integer id_vehicle) {
		super();
		this.name = name;
		this.cnh = cnh;
		this.id_vehicle = id_vehicle;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", cnh=" + cnh + ", id_vehicle=" + id_vehicle + "]";
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

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Integer getId_vehicle() {
		return id_vehicle;
	}

	public void setId_vehicle(Integer id_vehicle) {
		this.id_vehicle = id_vehicle;
	}
	
	
	
	
	
	
}
