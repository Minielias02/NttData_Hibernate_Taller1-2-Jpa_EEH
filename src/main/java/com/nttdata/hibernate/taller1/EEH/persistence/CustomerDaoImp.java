package com.nttdata.hibernate.taller1.EEH.persistence;

import org.hibernate.Session;

/**
 * 
 * @author elias
 *
 */
public class CustomerDaoImp extends CommonDaoImplement<CustomerTables> implements CustomerDaoI {
	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public CustomerDaoImp(Session session) {
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
