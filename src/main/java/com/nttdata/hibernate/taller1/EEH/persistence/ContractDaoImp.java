package com.nttdata.hibernate.taller1.EEH.persistence;

import org.hibernate.Session;

/**
 * 
 * @author elias
 *
 */
public class ContractDaoImp extends CommonDaoImplement<ContractTables> implements ContractDaoI {
	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImp(Session session) {
		super(session);
		this.setSession(session);
	}

	// Getters y setters
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
