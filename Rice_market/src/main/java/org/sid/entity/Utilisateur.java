package org.sid.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

import org.hibernate.annotations.Proxy;

//import org.sid.entity.AgentGouv;
//import org.sid.entity.Compte;
//import org.sid.entity.Distributeurs;
//import org.sid.entity.Importateurs;
//import org.sid.entity.Producteurs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "utilisateur", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Proxy(lazy=false)
public class Utilisateur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idUser;
	private String nom;
	private String prenom;
	private String email;
	private BigDecimal telephone;
	private String adresse;
	private BigDecimal bp;
	private Set<Importateurs> importateurses = new HashSet<Importateurs>(0);
	private Set<Producteurs> producteurses = new HashSet<Producteurs>(0);
	private Set<Distributeurs> distributeurses = new HashSet<Distributeurs>(0);
	private Set<AgentGouv> agentGouvs = new HashSet<AgentGouv>(0);
	private Set<Compte> comptes = new HashSet<Compte>(0);

	public Utilisateur() {
	}

	public Utilisateur(Long idUser) {
		this.idUser = idUser;
	}

//	public Utilisateur(Long idUser, String nom, String prenom, String email, BigDecimal telephone, String adresse,
//			BigDecimal bp, Set<Importateurs> importateurses, Set<Producteurs> producteurses, Set<Distributeurs> distributeurses, Set<AgentGouv> agentGouvs, Set<Compte> comptes) {
//		this.idUser = idUser;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.email = email;
//		this.telephone = telephone;
//		this.adresse = adresse;
//		this.bp = bp;
//		this.importateurses = importateurses;
//		this.producteurses = producteurses;
//		this.distributeurses = distributeurses;
//		this.agentGouvs = agentGouvs;
//		this.comptes = comptes;
//	}

	public Utilisateur(Long idUser, String nom, String prenom, String email, BigDecimal telephone, String adresse,
			BigDecimal bp,Set<Compte> comptes) {
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.bp = bp;
		this.comptes = comptes;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	@Column(name = "id_user", unique = true, nullable = false)
	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Column(name = "nom", length = 254)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", length = 254)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "email", length = 254)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telephone", precision = 131089, scale = 0)
	public BigDecimal getTelephone() {
		return this.telephone;
	}

	public void setTelephone(BigDecimal telephone) {
		this.telephone = telephone;
	}

	@Column(name = "adresse", length = 254)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "bp", precision = 131089, scale = 0)
	public BigDecimal getBp() {
		return this.bp;
	}

	public void setBp(BigDecimal bp) {
		this.bp = bp;
	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
//	public Set<Importateurs> getImportateurses() {
//		return this.importateurses;
//	}
//
//	public void setImportateurses(Set<Importateurs> importateurses) {
//		this.importateurses = importateurses;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
//	public Set<Producteurs> getProducteurses() {
//		return this.producteurses;
//	}
//
//	public void setProducteurses(Set<Producteurs> producteurses) {
//		this.producteurses = producteurses;
//	}
//
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
	@JsonIgnoreProperties("utilisateur")
	public Set<Distributeurs> getDistributeurses() {
		return this.distributeurses;
	}

	public void setDistributeurses(Set<Distributeurs> distributeurses) {
		this.distributeurses = distributeurses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
	@JsonIgnoreProperties("utilisateur")
	public Set<AgentGouv> getAgentGouvs() {
		return this.agentGouvs;
	}

	public void setAgentGouvs(Set<AgentGouv> agentGouvs) {
		this.agentGouvs = agentGouvs;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
	//@JsonManagedReference
	@JsonIgnoreProperties("utilisateur")
	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	

}
