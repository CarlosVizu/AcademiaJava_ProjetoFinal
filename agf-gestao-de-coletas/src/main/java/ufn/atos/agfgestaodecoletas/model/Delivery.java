package ufn.atos.agfgestaodecoletas.model;

import java.sql.Time;
import java.util.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "delivery")
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
	
	@Column
	private Float volsize;
	
	@Column
	private int altura;
	
	@Column
	private int largura;
	
	@Column
	private int comprimento;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date date;
	
	@Column(nullable = false)
	private Time time;
	
	@Column(nullable = false)
	private boolean daily = false;
	
	@Column(nullable = false)
	private String status;
	
	
//	@ManyToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "personnatural_delivery", joinColumns = {
			 @JoinColumn(name = "delivery_id", referencedColumnName = "id", nullable
			 = false, updatable = false) }, inverseJoinColumns = {
			 @JoinColumn(name = "personnatural_id", referencedColumnName = "id") })
			@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<PersonNatural> personnatural = new HashSet<>();
	
	@ManyToMany(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Set<PersonLegal> personlegal = new HashSet<>();
	
	@ManyToMany(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Set<Transport> transport = new HashSet<>();
	
	
	public Delivery() {

	}

	
	
	
	public Set<PersonNatural> getPersonnatural() {
		return personnatural;
	}




	public void setPersonnatural(Set<PersonNatural> personnatural) {
		this.personnatural = personnatural;
	}




	public Set<PersonLegal> getPersonlegal() {
		return personlegal;
	}




	public void setPersonlegal(Set<PersonLegal> personlegal) {
		this.personlegal = personlegal;
	}




	public Set<Transport> getTransport() {
		return transport;
	}




	public void setTransport(Set<Transport> transport) {
		this.transport = transport;
	}




	public Float getVolsize() {
		return volsize;
	}

	public void setVolsize(Float volsize) {
		this.volsize = volsize;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
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
