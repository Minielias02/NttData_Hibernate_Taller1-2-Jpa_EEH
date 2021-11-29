package com.nttdata.hibernate.taller1.EEH.services;

import java.util.List;

import com.nttdata.hibernate.taller1.EEH.persistence.ContractTables;
import com.nttdata.hibernate.taller1.EEH.persistence.CustomerTables;

/**
 * Formación - Hibernate - Taller 1
 * 
 * Interface del servicio de Contract.
 * 
 * @author Elias
 *
 */
public interface NttDataDaoContractService {


	/**
	 * Inserta nuevos contratcs
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final ContractTables newContract);

	/**
	 * Updatea contract
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final ContractTables updatedContract);

	/**
	 * Borra contract
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final ContractTables deletedContract);

	/**
	 * Busca por Id un customer
	 * 
	 * @param customerId
	 * @return CustomerTables
	 */
	public ContractTables searchById(final int ContractId);

	/**
	 * Muestra todos los customers
	 * 
	 * @return List<CustomerTables>
	 */
	public List<ContractTables> searchAll();
	
	/**
	 * Busca contracts por customer
	 * 
	 * @param ContractCustomer
	 * @return ContractTable
	 */
	public ContractTables searchByCustomer(final CustomerTables ContractCustomer);

	
	
}
