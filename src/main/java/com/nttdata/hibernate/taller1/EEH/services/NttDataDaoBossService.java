package com.nttdata.hibernate.taller1.EEH.services;

import java.util.List;

import com.nttdata.hibernate.taller1.EEH.persistence.BossTables;

/**
 * Formación - Hibernate - Taller 1
 * 
 * Interface del servicio de Contract.
 * 
 * @author Elias
 *
 */
public interface NttDataDaoBossService {

	/**
	 * Inserta nuevos boss
	 * 
	 * @param newBoss
	 */
	public void insertNewBoss(final BossTables newBoss);

	/**
	 * Updatea Boss
	 * 
	 * @param updatedBoss
	 */
	public void updateBoss(final BossTables updatedBoss);

	/**
	 * Borra Boss
	 * 
	 * @param deletedBoss
	 */
	public void deleteBoss(final BossTables deletedBoss);

	/**
	 * Busca por Id un Boss
	 * 
	 * @param bossId
	 * @return BossTables
	 */
	public BossTables searchById(final int bossId);

	/**
	 * Muestra todos los boss
	 * 
	 * @return List<BossTables>
	 */
	public List<BossTables> searchAll();
}