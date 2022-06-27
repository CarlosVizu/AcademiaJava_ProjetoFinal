package ufn.atos.agfgestaodecoletas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonNatural 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String zipcode;
	@Column(nullable = false)
	private String city;
	@Column
	private String description;
	
	@Column(nullable = false)
	Integer id_route;
	
	Integer id_delivery;


	
	public PersonNatural() {
	}
	
	

	public PersonNatural(String name, String cpf, String address, String zipcode, String city, String description,
			Integer id_route) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.description = description;
		this.id_route = id_route;
	}
	
	
	
	@Override
	public String toString() {
		return "PersonNatural [id=" + id + ", name=" + name + ", cpf=" + cpf + ", address=" + address + ", zipcode="
				+ zipcode + ", city=" + city + ", description=" + description + ", id_route=" + id_route
				+ ", id_delivery=" + id_delivery + "]";
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
	
	
	
	
}
