package com.nttdata.hibernate.taller1.EEH.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerTables {
	// Id de persona
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// Nombre de la persona
	private String name;
	// Primer apellido
	private String firstSurname;
	// Segundo apellido
	private String secondSurname;
	@Column(name = "dni", unique = true, length = 9, nullable = false)
	private String dni;

	// Contratos de customer
	@OneToMany(mappedBy = "customer")
	List<ContractTables> contracts = new ArrayList<ContractTables>();

	/**
	 * Constructor sin param
	 */
	public CustomerTables() {

		super();
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @param dni
	 */
	public CustomerTables(String name, String firstSurname, String secondSurname, String dni) {
		super();
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.dni = dni;
	}

	// Getters y Setters
	public Integer getId() {
		return id;
	}

	public List<ContractTables> getContracts() {
		return contracts;
	}

	public void setContracts(List<ContractTables> contracts) {
		this.contracts = contracts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getDni() {

		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "CustomerTables [id=" + id + ", name=" + name + ", firstSurname=" + firstSurname + ", secondSurname="
				+ secondSurname + ", dni=" + dni + ", contracts=" + contracts + "]";
	}

}
