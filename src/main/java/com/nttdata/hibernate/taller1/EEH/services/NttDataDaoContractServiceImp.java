package com.nttdata.hibernate.taller1.EEH.services;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

import com.nttdata.hibernate.taller1.EEH.persistence.ContractDaoI;
import com.nttdata.hibernate.taller1.EEH.persistence.ContractDaoImp;
import com.nttdata.hibernate.taller1.EEH.persistence.ContractTables;
import com.nttdata.hibernate.taller1.EEH.persistence.CustomerTables;

/**
 * 
 * @author elias
 *
 */
public class NttDataDaoContractServiceImp implements NttDataDaoContractService {

	private ContractDaoI contract;

	/**
	 * Método constructor.
	 */
	public NttDataDaoContractServiceImp(final Session session) {
		this.contract = new ContractDaoImp(session);
	}

	@Override
	public void insertNewContract(ContractTables newContract) {
		if (newContract != null && newContract.getId() == null) {

			// Insercción del nuevo cliente.
			contract.insert(newContract);
		}

	}

	@Override
	public void updateContract(ContractTables updatedContract) {
		// Verificación de nulidad y existencia.
		if (updatedContract != null && updatedContract.getId() != null) {
			// Actualización del partido.
			contract.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(ContractTables deletedContract) {
		// Verificación de nulidad y existencia.
		if (deletedContract != null && deletedContract.getId() != null) {
			// Eliminación del cliente.
			contract.delete(deletedContract);
		}

	}

	@Override
	public ContractTables searchById(int ContractId) {
		// Resultado.
		ContractTables contractT = null;
		// Verificación de nulidad.
		if (contract != null) {
			// Obtención de cliente por ID.
			contractT = contract.searchById(ContractId);
		}
		return contractT;
	}

	@Override
	public List<ContractTables> searchAll() {
		// Resultado.
		List<ContractTables> contractTables = new ArrayList<ContractTables>();

		// Obtención de partido.
		contractTables = contract.searchAll();

		return contractTables;
	}

	@Override
	public ContractTables searchByCustomer(CustomerTables ContractCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

}
