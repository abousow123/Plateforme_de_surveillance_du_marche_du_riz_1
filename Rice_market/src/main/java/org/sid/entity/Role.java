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

import org.hibernate.annotations.Proxy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "role", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Proxy(lazy=false)
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idRole;
	private String nomRole;
	private Set<Compte> comptes = new HashSet<Compte>(0);

	public Role() {
	}

	public Role(Long idRole) {
		this.idRole = idRole;
	}

	public Role(Long idRole, String nomRole, Set<Compte> comptes) {
		this.idRole = idRole;
		this.nomRole = nomRole;
		this.comptes = comptes;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_role", unique = true, nullable = false)
	public Long getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	@Column(name = "nom_role", length = 254)
	public String getNomRole() {
		return this.nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
	//@JsonManagedReference
	@JsonIgnoreProperties ( "role" ) 
	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
