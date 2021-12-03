package com.nttdata.hibernate.taller1.EEH.persistence;

/**
 * 
 * @author elias
 *
 */
public interface ContractDaoI extends CommonDaoI<ContractTables> {

	public Integer searchByCustomer(CustomerTables ContractCustomer);
}
