package ufn.atos.agfgestaodecoletas.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personnatural")
public class PersonNatural 
{
	//Classe de pessoa física, possível melhoria será implementar herança entre os clientes (PersonNatural.class & PersonLegal.class)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String number;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private String zipcode;
	@Column
	private String description;
	
	@ManyToOne
	private Route route;
	
	
//	@JoinTable(name = "personnatural_delivery", joinColumns = {
//	 @JoinColumn(name = "personnatural_id", referencedColumnName = "id", nullable
//	 = false, updatable = false) }, inverseJoinColumns = {
//	 @JoinColumn(name = "delivery_id", referencedColumnName = "id") })
	@ManyToMany(mappedBy = "personnatural", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<Delivery> delivery = new HashSet<>();

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


	
	
	
	public Set<Delivery> getDelivery() {
		return delivery;
	}

	public void setDelivery(Set<Delivery> delivery) {
		this.delivery = delivery;
	}

	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public Set<Delivery> getDeliveries() {
		return delivery;
	}



	public void setDeliveries(Set<Delivery> deliveries) {
		this.delivery = deliveries;
	}

	
	
}
