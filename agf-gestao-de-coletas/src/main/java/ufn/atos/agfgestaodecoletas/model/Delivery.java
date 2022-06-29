package ufn.atos.agfgestaodecoletas.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery")
public class Delivery 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private int qtyitems;
	
	@Column
	private String description;
	
	@Column
	private String closingdescription;
	
	@Column(nullable = false)
	private Float boxsize;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private Time time;
	
	@Column(nullable = false)
	private boolean daily = false;
	
	@Column(nullable = false)
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PersonNatural.class)
	@JoinColumn(name = "personnatural_id")
	private PersonNatural personNatural;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PersonLegal.class)
	@JoinColumn(name = "personlegal_id")
	private PersonLegal personLegal;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = PersonDeliveryRoute.class)
	private PersonDeliveryRoute personDeliveryRoute;
	
	
	
	public Delivery() {

	}

	public Delivery(int qtyitems, String description, Float boxsize, Date date, Time time, String status) {
		super();
		this.qtyitems = qtyitems;
		this.description = description;
		this.boxsize = boxsize;
		this.date = date;
		this.time = time;
		this.status = status;
	}


	
	
	@Override
	public String toString() {
		return "Delivery [id=" + id + ", qtyitems=" + qtyitems + ", description=" + description + ", boxsize=" + boxsize
				+ ", date=" + date + ", time=" + time + ", status=" + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQtyitems() {
		return qtyitems;
	}

	public void setQtyitems(int qtyitems) {
		this.qtyitems = qtyitems;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getBoxsize() {
		return boxsize;
	}

	public void setBoxsize(Float boxsize) {
		this.boxsize = boxsize;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getClosingdescription() {
		return closingdescription;
	}

	public void setClosingdescription(String closingdescription) {
		this.closingdescription = closingdescription;
	}

	public boolean isDaily() {
		return daily;
	}

	public void setDaily(boolean daily) {
		this.daily = daily;
	}
	
	
	
	
}
