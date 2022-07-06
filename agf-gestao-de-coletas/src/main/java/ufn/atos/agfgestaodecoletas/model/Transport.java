package ufn.atos.agfgestaodecoletas.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transport")
public class Transport 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(mappedBy = "transport", fetch = FetchType.LAZY)
	private Set<Delivery> delivery = new HashSet<>();

	@ManyToOne
	private Vehicle vehicle;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private Time time;
	
	@Column
	private Float volsize;
	
	@Column
	private Integer qtyitems;

	
	
	
	
	public Transport() {
	}

	public Set<Delivery> getDelivery() {
		return delivery;
	}

	public void setDelivery(Set<Delivery> delivery) {
		this.delivery = delivery;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Float getVolsize() {
		return volsize;
	}

	public void setVolsize(Float volsize) {
		this.volsize = volsize;
	}

	public Integer getQtyitems() {
		return qtyitems;
	}

	public void setQtyitems(Integer qtyitems) {
		this.qtyitems = qtyitems;
	}

	
	
}
