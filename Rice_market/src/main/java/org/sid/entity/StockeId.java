package org.sid.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StockeId implements Serializable {
	
	private int idstock ;
	private int idcategories ;
	
	public StockeId() {
		
	}

	public StockeId(int idstock, int idcategories) {
		
		this.idstock = idstock;
		this.idcategories = idcategories;
	}
	@Column(name = "id_stock", nullable = false)
	public int getIdstock() {
		return idstock;
	}

	public void setIdstock(int idstock) {
		this.idstock = idstock;
	}

	@Column(name = "idcategories", nullable = false)
	public int getIdcategories() {
		return idcategories;
	}

	public void setIdcategories(int idcategories) {
		this.idcategories = idcategories;
	}
	
	
	
	
	

}
