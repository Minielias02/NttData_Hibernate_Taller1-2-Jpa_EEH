package com.nttdata.hibernate.taller1.EEH.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class ContractTables {
	// Id de contrato
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contractId;
	// Fecha de validez
	private String validityDate;
	// Fecha de expiracion
	private String expirationDate;
	// Precio mensual
	private int monthlyPrice;

	// Customer de constratos
	@ManyToOne
	@JoinColumn
	CustomerTables customerRelation;

	/**
	 * Constructor sin parametros
	 */
	public ContractTables() {
		super();
	}

	/**
	 * Constructor con parametros
	 * 
	 * @param id
	 * @param validityDate
	 * @param expirationDate
	 * @param monthlyPrice
	 * @param customerRelation
	 */
	public ContractTables(Integer id, String validityDate, String expirationDate, int monthlyPrice) {
		super();
		this.contractId = id;
		this.validityDate = validityDate;
		this.expirationDate = expirationDate;
		this.monthlyPrice = monthlyPrice;
	}

	// Getters y setters
	public Integer getId() {
		return contractId;
	}

	public void setId(Integer id) {
		this.contractId = id;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}

	public int getMonthlyPrice() {
		return monthlyPrice;
	}

	public void setMonthlyPrice(int monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	public CustomerTables getCustomer() {
		return customerRelation;
	}

	public void setCustomer(CustomerTables customer) {
		this.customerRelation = customer;
	}

	@Override
	public String toString() {
		return "ContractTables [id=" + contractId + ", validityDate=" + validityDate + ", expirationDate=" + expirationDate
				+ ", monthlyPrice=" + monthlyPrice + ", customer=" + customerRelation.getName() + " "
				+ customerRelation.getFirstSurname() + " " + customerRelation.getSecondSurname() + "]";
	}

}
