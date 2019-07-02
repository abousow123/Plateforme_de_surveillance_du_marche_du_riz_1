package org.sid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "compte", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Proxy(lazy=false)
public class Compte implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idCompte;
	private String login;
	private String pwd;
	private Role role;
	private Utilisateur utilisateur;
	
	
	//private CompteId id;
		//private Long idUser;
			//private int idRole;
	
//	@Column(name = "id_user", nullable = false)
//	public Long getIdUser() {
//		return idUser;
//	}
//
//	public void setIdUser(Long idUser) {
//		this.idUser = idUser;
//	}
//
//	public int getIdRole() {
//		return idRole;
//	}
//
//	public void setIdRole(int idRole) {
//		this.idRole = idRole;
//	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_compte")
	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	@Column(name = "login", length = 254)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	@Column(name = "pwd", length = 254)
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	

	public Compte() {
	}

//	public Compte(CompteId id, Role role, Utilisateur utilisateur) {
//		this.id = id;
//		this.role = role;
//		this.utilisateur = utilisateur;
//	}

//	@EmbeddedId
//
//	@AttributeOverrides({ @AttributeOverride(name = "idUser", column = @Column(name = "id_user", nullable = false)),
//			@AttributeOverride(name = "idRole", column = @Column(name = "id_role", nullable = false)),
//			@AttributeOverride(name = "idCompte", column = @Column(name = "id_compte")),
//			@AttributeOverride(name = "login", column = @Column(name = "login", length = 254)),
//			@AttributeOverride(name = "pwd", column = @Column(name = "pwd", length = 254)) })

//	public CompteId getId() {
//		return this.id;
//	}
//
//	public void setId(CompteId id) {
//		this.id = id;
//	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
	//@JsonBackReference
	 @JsonIgnoreProperties ( "comptes" ) 
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	//@JsonBackReference
	@JsonIgnoreProperties("comptes")
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}