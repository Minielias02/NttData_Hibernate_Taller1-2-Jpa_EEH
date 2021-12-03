package com.nttdata.hibernate.taller1.EEH.persistence;

import java.util.List;

/**
 * 
 * @author elias
 *
 */
public interface CustomerDaoI extends CommonDaoI<CustomerTables> {

	public List<CustomerTables> returnAllCustomer(CustomerTables customer, ContractTables contract);
}
