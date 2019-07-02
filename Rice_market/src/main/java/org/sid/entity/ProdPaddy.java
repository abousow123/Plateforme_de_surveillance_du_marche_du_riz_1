package org.sid.entity;

import java.io.Serializable;

public class ProdPaddy implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Producteurs producteurs;
	private Deposerpaddy deposerpaddy;
	public ProdPaddy() {
		// TODO Auto-generated constructor stub
	}
	public void setDeposerpaddy(Deposerpaddy deposerpaddy) {
		this.deposerpaddy = deposerpaddy;
	}
	public void setProducteurs(Producteurs producteurs) {
		this.producteurs = producteurs;
	}
	public Deposerpaddy getDeposerpaddy() {
		return deposerpaddy;
	}
	public Producteurs getProducteurs() {
		return producteurs;
	}
}
