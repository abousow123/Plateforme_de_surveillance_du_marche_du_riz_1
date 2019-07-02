package org.sid.entity;
// Generated 1 f�vr. 2019 17:48:23 by Hibernate Tools 3.5.0.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * StockLocal generated by hbm2java
 */
@Entity
@Table(name = "stock_local", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StockLocal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idStock;
	private UsineTransformation usineTransformation;
	private Annes annes;
	private BigDecimal quatite;
	private BigDecimal quantite;
	private String lieuStock;
	private BigDecimal seuilMax;
	private BigDecimal seuilMin;
	private Set<CommandeLocal> commandeLocals = new HashSet<CommandeLocal>(0);
	private Set<Stocke> stockes = new HashSet<Stocke>(0);

	public StockLocal() {
	}

	public StockLocal(Long idStock, UsineTransformation usineTransformation, Annes annes) {
		this.idStock = idStock;
		this.usineTransformation = usineTransformation;
		this.annes = annes;
	}

	public StockLocal(Long idStock, UsineTransformation usineTransformation, Annes annes, BigDecimal quatite,
			BigDecimal quantite, String lieuStock, BigDecimal seuilMax, BigDecimal seuilMin, Set<CommandeLocal> commandeLocals) {
		this.idStock = idStock;
		this.usineTransformation = usineTransformation;
		this.annes = annes;
		this.quatite = quatite;
		this.quantite = quantite;
		this.lieuStock = lieuStock;
		this.seuilMax = seuilMax;
		this.seuilMin = seuilMin;
		this.commandeLocals = commandeLocals;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_stock", unique = true, nullable = false)
	public Long getIdStock() {
		return this.idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usine")
	@JsonIgnoreProperties({"stockLocals","usineTransformation.departement.stockImportations"})
	public UsineTransformation getUsineTransformation() {
		return this.usineTransformation;
	}

	public void setUsineTransformation(UsineTransformation usineTransformation) {
		this.usineTransformation = usineTransformation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_annees")
	@JsonIgnoreProperties({"stockLocals","stockImportations"})
	public Annes getAnnes() {
		return this.annes;
	}

	public void setAnnes(Annes annes) {
		this.annes = annes;
	}

	@Column(name = "quatite", precision = 131089, scale = 0)
	public BigDecimal getQuatite() {
		return this.quatite;
	}

	public void setQuatite(BigDecimal quatite) {
		this.quatite = quatite;
	}

	@Column(name = "quantite", precision = 131089, scale = 0)
	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	@Column(name = "lieu_stock", length = 254)
	public String getLieuStock() {
		return this.lieuStock;
	}

	public void setLieuStock(String lieuStock) {
		this.lieuStock = lieuStock;
	}

	@Column(name = "seuil_max", precision = 131089, scale = 0)
	public BigDecimal getSeuilMax() {
		return this.seuilMax;
	}

	public void setSeuilMax(BigDecimal seuilMax) {
		this.seuilMax = seuilMax;
	}

	@Column(name = "seuil_min", precision = 131089, scale = 0)
	public BigDecimal getSeuilMin() {
		return this.seuilMin;
	}

	public void setSeuilMin(BigDecimal seuilMin) {
		this.seuilMin = seuilMin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockLocal")
	@JsonIgnoreProperties("stockLocal")
	public Set<CommandeLocal> getCommandeLocals() {
		return this.commandeLocals;
	}

	public void setCommandeLocals(Set<CommandeLocal> commandeLocals) {
		this.commandeLocals = commandeLocals;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "stockLocal")
	@JsonIgnoreProperties("stockLocal")
	public Set<Stocke> getStockes() {
		return stockes;
	}

	public void setStockes(Set<Stocke> stockes) {
		this.stockes = stockes;
	}

}
