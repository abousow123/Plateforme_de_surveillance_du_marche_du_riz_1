package org.sid.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "stocke", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stocke implements Serializable{
	
	
	private StockeId id ;
	
	private double quantite ;
	private StockLocal stockLocal ;
	private Categorie categorie ;

	public Stocke() {
		
	}

	public Stocke(StockeId id, double quantite) {
		
		this.id = id;
		this.quantite = quantite;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idstock", column = @Column(name = "id_stock", nullable = false)),
			@AttributeOverride(name = "idcategories", column = @Column(name = "idcategories", nullable = false)) })
	public StockeId getId() {
		return id;
	}

	public void setId(StockeId id) {
		this.id = id;
	}

	@Column(name = "quantite")
	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_stock", insertable = false, updatable = false)
	@JsonIgnoreProperties({"stockes"})
	public StockLocal getStockLocal() {
		return stockLocal;
	}

	public void setStockLocal(StockLocal stockLocal) {
		this.stockLocal = stockLocal;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcategories", insertable = false, updatable = false)
	@JsonIgnoreProperties({"stockes"})
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	
	
	
	
	

}
