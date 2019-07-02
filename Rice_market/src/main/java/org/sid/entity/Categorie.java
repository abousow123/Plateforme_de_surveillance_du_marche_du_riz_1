package org.sid.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "categorie", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categorie implements java.io.Serializable {
	
	private Long idcategorie ;
	private String categorie ;
	private String description ;
	private String photo ;
	private Set<Stocke> stockes = new HashSet<Stocke>(0);
	public Categorie() {
		
	}
	public Categorie(Long idcategorie, String categorie, String description, String photo) {
	
		this.idcategorie = idcategorie;
		this.categorie = categorie;
		this.description = description;
		this.photo = photo;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idcategories", unique = true, nullable = false)
	public Long getIdcategorie() {
		return idcategorie;
	}
	public void setIdcategorie(Long idcategorie) {
		this.idcategorie = idcategorie;
	}
	
	@Column(name = "categorie")
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "photo")
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
	@JsonIgnoreProperties("categorie")
	public Set<Stocke> getStockes() {
		return stockes;
	}
	public void setStockes(Set<Stocke> stockes) {
		this.stockes = stockes;
	}
	

}
