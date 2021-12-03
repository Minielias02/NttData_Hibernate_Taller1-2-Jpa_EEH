package com.nttdata.hibernate.taller1.EEH.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "boss")
public class BossTables {
	// Id de contrato
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bossId;
	// Nombre del jefe
	private String name;
	// Primer apellido
	private String firstSurname;
	// Dinero que gana el jefe
	private int money;
	
	// Customer de Enterprise
	@OneToOne(fetch= FetchType.LAZY,mappedBy="bossRelation",cascade = CascadeType.ALL)
	EnterpriseTables enterpriseRelation;
	
	/**
	 * Constructor sin parametros
	 */
	public BossTables() {
		super();
	}
	
	/**
	 * Constructor con parametros
	 * @param id
	 * @param name
	 * @param firstSurname
	 * @param money
	 * @param enterpriseRelation
	 */
	public BossTables(Integer id, String name, String firstSurname, int money) {
		super();
		this.bossId = id;
		this.name = name;
		this.firstSurname = firstSurname;
		this.money = money;
	}


	//Getters y setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstSurname() {
		return firstSurname;
	}
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Integer getId() {
		return bossId;
	}
	public void setId(Integer id) {
		this.bossId = id;
	}
	public EnterpriseTables getEnterpriseRelation() {
		return enterpriseRelation;
	}
	public void setEnterpriseRelation(EnterpriseTables enterpriseRelation) {
		this.enterpriseRelation = enterpriseRelation;
	}

	@Override
	public String toString() {
		return "BossTables [id=" + bossId + ", name=" + name + ", firstSurname=" + firstSurname + ", money=" + money
				+ ", enterpriseRelation=" + enterpriseRelation + "]";
	}

}
