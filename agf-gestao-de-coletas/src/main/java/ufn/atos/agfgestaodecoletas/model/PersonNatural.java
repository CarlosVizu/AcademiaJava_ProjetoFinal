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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PersonNatural")
public class PersonNatural 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String zipcode;
	@Column(nullable = false)
	private String city;
	@Column
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
	@JoinColumn(name = "route_id")
	private Route route;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Delivery> deliveries;
	
	
	public PersonNatural() {
	}
	
	
	
	public PersonNatural(String name, String cpf, String address, String zipcode, String city, String description,
			Route route) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.description = description;
		this.route = route;
	}


	
	


	public Route getRoute() {
		return route;
	}



	public void setRoute(Route route) {
		this.route = route;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
