package com.nttdata.hibernate.taller1.EEH.services;

import java.util.List;

import com.nttdata.hibernate.taller1.EEH.persistence.CustomerTables;

/**
 * Formación - Hibernate - Taller 1
 * 
 * Interface del servicio de Customer.
 * 
 * @author Elias
 *
 */
public interface NttDataDaoCustomerService {

	/**
	 * Inserta nuevos customers
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final CustomerTables newCustomer);

	/**
	 * Updatea customer
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final CustomerTables updatedCustomer);

	/**
	 * Borra customer
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final CustomerTables deletedCustomer);

	/**
	 * Busca por Id un customer
	 * 
	 * @param customerId
	 * @return CustomerTables
	 */
	public CustomerTables searchById(final int customerId);

	/**
	 * Muestra todos los customers
	 * 
	 * @return List<CustomerTables>
	 */
	public List<CustomerTables> searchAll();

}
