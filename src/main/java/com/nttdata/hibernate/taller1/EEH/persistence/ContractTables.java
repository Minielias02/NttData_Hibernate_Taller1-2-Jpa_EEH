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
	private Integer id;
	// Fecha de validez
	private String validityDate;
	// Fecha de expiracion
	private String expirationDate;
	// Precio mensual
	private int monthlyPrice;

	// Customer de constratos
	@ManyToOne
	@JoinColumn
	CustomerTables customer = new CustomerTables();

	// Getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return customer;
	}

	public void setCustomer(CustomerTables customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ContractTables [id=" + id + ", validityDate=" + validityDate + ", expirationDate=" + expirationDate
				+ ", monthlyPrice=" + monthlyPrice + ", customer=" + customer.getName() + " "
				+ customer.getFirstSurname() + " " + customer.getSecondSurname() + "]";
	}

}
