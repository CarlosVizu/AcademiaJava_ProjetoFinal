package ufn.atos.agfgestaodecoletas.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Driver")
public class Driver 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false, unique = true)
	private String cnh;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = Vehicle.class)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	
	
	public Driver() {
	}

	public Driver(String name, String cnh) {
		super();
		this.name = name;
		this.cnh = cnh;
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

	
	
	
	
}
