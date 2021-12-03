package com.nttdata.hibernate.taller1.EEH.services;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import com.nttdata.hibernate.taller1.EEH.persistence.CustomerTables;
import com.nttdata.hibernate.taller1.EEH.persistence.ContractTables;
import com.nttdata.hibernate.taller1.EEH.persistence.CustomerDaoI;
import com.nttdata.hibernate.taller1.EEH.persistence.CustomerDaoImp;

/**
 * Formación - Hibernate - Taller1
 * 
 * Implementación del servicio de partidos.
 * 
 * @author Elias
 *
 */
public class NttDataDaoCustomerServiceImpl implements NttDataDaoCustomerService {

	private CustomerDaoI customer;

	/**
	 * Método constructor.
	 */
	public NttDataDaoCustomerServiceImpl(final Session session) {
		this.customer = new CustomerDaoImp(session);
	}

	@Override
	public void insertNewCustomer(CustomerTables newCustomer) {
		if (newCustomer != null && newCustomer.getId() == null) {

			// Insercción del nuevo cliente.
			customer.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(CustomerTables updatedCustomer) {
		// Verificación de nulidad y existencia.
		if (updatedCustomer != null && updatedCustomer.getId() != null) {
			// Actualización del partido.
			customer.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(CustomerTables deletedCustomer) {
		// Verificación de nulidad y existencia.
		if (deletedCustomer != null && deletedCustomer.getId() != null) {
			// Eliminación del cliente.
			customer.delete(deletedCustomer);
		}

	}

	@Override
	public CustomerTables searchById(int customerId) {
		// Resultado.
		CustomerTables customerT = null;
		// Verificación de nulidad.
		if (customer != null) {
			// Obtención de cliente por ID.
			customerT = customer.searchById(customerId);
		}
		return customerT;
	}

	@Override
	public List<CustomerTables> searchAll() {
		// Resultado.
		List<CustomerTables> customerList = new ArrayList<CustomerTables>();

		// Obtención de partido.
		customerList = customer.searchAll();

		return customerList;
	}

	@Override
	public List<CustomerTables> returnAllCustomer(CustomerTables customer, ContractTables contract) {
		List<CustomerTables> customerList = new ArrayList<CustomerTables>();
		if (customer != null&& contract!=null) {
			customerList=this.customer.returnAllCustomer(customer, contract);
		}
		return customerList;
	}
}
