package com.nttdata.hibernate.taller1.EEH.services;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

import com.nttdata.hibernate.taller1.EEH.persistence.BossDaoI;
import com.nttdata.hibernate.taller1.EEH.persistence.BossDaoImp;
import com.nttdata.hibernate.taller1.EEH.persistence.BossTables;

/**
 * 
 * @author elias
 *
 */
public class NttDataDaoBossServiceImp implements NttDataDaoBossService {

	private BossDaoI boss;

	/**
	 * Método constructor.
	 */
	public NttDataDaoBossServiceImp(final Session session) {
		this.boss = new BossDaoImp(session);
	}

	@Override
	public void insertNewBoss(BossTables newBoss) {
		if (newBoss != null && newBoss.getId() == null) {
			// Insercción del nuevo boss.
			boss.insert(newBoss);
		}
	}

	@Override
	public void updateBoss(BossTables updatedBoss) {
		// Verificación de nulidad y existencia.
		if (updatedBoss != null && updatedBoss.getId() != null) {
			// Actualización del boss
			boss.update(updatedBoss);
		}
	}

	@Override
	public void deleteBoss(BossTables deletedBoss) {
		// Verificación de nulidad y existencia.
		if (deletedBoss != null && deletedBoss.getId() != null) {
			// Eliminación del boss.
			boss.delete(deletedBoss);
		}

	}

	@Override
	public BossTables searchById(int bossId) {
		// Resultado.
		BossTables bossT = null;
		// Verificación de nulidad.
		if (boss != null) {
			// Obtención de boss por ID.
			bossT = boss.searchById(bossId);
		}
		return bossT;
	}

	@Override
	public List<BossTables> searchAll() {
		// Resultado.
		List<BossTables> bossTables = new ArrayList<BossTables>();

		// Obtención de boss.
		bossTables = boss.searchAll();

		return bossTables;
	}

}
