package com.nttdata.hibernate.taller1.EEH.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.nttdata.hibernate.taller1.EEH.persistence.EnterpriseDaoI;
import com.nttdata.hibernate.taller1.EEH.persistence.EnterpriseDaoImp;
import com.nttdata.hibernate.taller1.EEH.persistence.EnterpriseTables;
/**
 * 
 * @author elias
 *
 */
public class NttDataDaoEnterpriseServiceImp implements NttDataDaoEnterpriseService {

	private EnterpriseDaoI enterprise;

	/**
	 * 
	 * @param session
	 */
	public NttDataDaoEnterpriseServiceImp(final Session session) {
		this.enterprise = new EnterpriseDaoImp(session);
	}

	@Override
	public void insertNewEnterprise(EnterpriseTables newEnterprise) {
		if (newEnterprise != null && newEnterprise.getId() == null) {
			// Insercción del nuevo enterprise.
			enterprise.insert(newEnterprise);
		}
	}

	@Override
	public void updateEnterprise(EnterpriseTables updatedEnterprise) {
		// Verificación de nulidad y existencia.
		if (updatedEnterprise != null && updatedEnterprise.getId() != null) {
			// Actualización de enterprise.
			enterprise.update(updatedEnterprise);
		}
	}

	@Override
	public void deleteEnterprise(EnterpriseTables deletedEnterprise) {
		// Verificación de nulidad y existencia.
		if (deletedEnterprise != null && deletedEnterprise.getId() != null) {
			// Eliminación de enterprise.
			enterprise.delete(deletedEnterprise);
		}
	}

	@Override
	public EnterpriseTables searchById(int enterpriseId) {
		// Resultado.
		EnterpriseTables enterpriseT = null;
		// Verificación de nulidad.
		if (enterprise != null) {
			// Obtención de enterprise por ID.
			enterpriseT = enterprise.searchById(enterpriseId);
		}
		return enterpriseT;
	}

	@Override
	public List<EnterpriseTables> searchAll() {
		// Resultado.
		List<EnterpriseTables> enterpriseTables = new ArrayList<EnterpriseTables>();

		// Obtención de partido.
		enterpriseTables = enterprise.searchAll();

		return enterpriseTables;
	}

}
