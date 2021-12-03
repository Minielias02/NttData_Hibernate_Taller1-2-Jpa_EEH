package com.nttdata.hibernate.taller1.EEH.services;

import java.util.List;

import com.nttdata.hibernate.taller1.EEH.persistence.EnterpriseTables;
/**
 * 
 * @author elias
 *
 */
public interface NttDataDaoEnterpriseService {
	/**
	 * Inserta nuevos enterprise
	 * 
	 * @param newEnterprise
	 */
	public void insertNewEnterprise(final EnterpriseTables newEnterprise);

	/**
	 * Updatea enterprise
	 * 
	 * @param updatedEnterprise
	 */
	public void updateEnterprise(final EnterpriseTables updatedEnterprise);

	/**
	 * Borra enterprise
	 * 
	 * @param deletedEnterprise
	 */
	public void deleteEnterprise(final EnterpriseTables deletedEnterprise);

	/**
	 * Busca por Id un enterprise
	 * 
	 * @param enterpriseId
	 * @return EnterpriseTables
	 */
	public EnterpriseTables searchById(final int enterpriseId);

	/**
	 * Muestra todas las enterprise
	 * 
	 * @return List<EnterpriseTables>
	 */
	public List<EnterpriseTables> searchAll();
}
