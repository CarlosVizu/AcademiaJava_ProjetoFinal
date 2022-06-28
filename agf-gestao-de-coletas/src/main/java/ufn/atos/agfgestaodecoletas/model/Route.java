package ufn.atos.agfgestaodecoletas.model;

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
@Table(name = "Route")
public class Route 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = PersonNatural.class)
	@JoinColumn(name = "personnatural_id")
	private PersonNatural personNatural;
	
	@ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL, targetEntity = PersonLegal.class)
	@JoinColumn(name = "personlegal_id")
	private PersonLegal personLegal;
	
	/*
	 * @OneToMany(mappedBy = "persondeliveryroute", fetch = FetchType.LAZY, cascade
	 * = CascadeType.ALL, targetEntity = PersonDeliveryRoute.class) private
	 * PersonDeliveryRoute personDeliveryRoute;
	 */
	

	public Route() {
	}

	public Route(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
}
