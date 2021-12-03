package com.nttdata.hibernate.taller1.EEH.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enterprise")
public class EnterpriseTables {
	// Id de contrato
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enterpriseId;
	// Nombre de la empresa
	private String name;
	// Numero de paises en los que tiene sedes
	private int numberOfCountries;

	// Customer de Enterprise
	@ManyToMany
	@JoinColumn
	List<CustomerTables> customerList = new ArrayList<CustomerTables>();
	
	@OneToOne
	@JoinColumn(name= "bossId", referencedColumnName = "bossId")
	BossTables bossRelation;

	/**
	 * Constructor vacio
	 */
	public EnterpriseTables() {
		super();
	}

	/**
	 * Constructor con parametros
	 * 
	 * @param id
	 * @param name
	 * @param numberOfCountries
	 * @param customerList
	 */
	public EnterpriseTables(Integer id, String name, int numberOfCountries, List<CustomerTables> customerList) {
		super();
		this.enterpriseId = id;
		this.name = name;
		this.numberOfCountries = numberOfCountries;
		this.customerList = customerList;
	}

	// Getters y setters
	public Integer getId() {
		return enterpriseId;
	}

	public void setId(Integer id) {
		this.enterpriseId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfCountries() {
		return numberOfCountries;
	}

	public void setNumberOfCountries(int numberOfCountries) {
		this.numberOfCountries = numberOfCountries;
	}

	public List<CustomerTables> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerTables> customerList) {
		this.customerList = customerList;
	}
	
	public BossTables getBossRelation() {
		return bossRelation;
	}

	public void setBossRelation(BossTables bossRelation) {
		this.bossRelation = bossRelation;
	}

	@Override
	public String toString() {
		return "EnterpriseTables [id=" + enterpriseId + ", name=" + name + ", numberOfCountries=" + numberOfCountries
				+ ", customerList=" + customerList + "]";
	}

}
