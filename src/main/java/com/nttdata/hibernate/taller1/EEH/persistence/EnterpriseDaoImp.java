package com.nttdata.hibernate.taller1.EEH.persistence;

import org.hibernate.Session;

public class EnterpriseDaoImp extends CommonDaoImplement<EnterpriseTables> implements EnterpriseDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public EnterpriseDaoImp(Session session) {
		super(session);
		this.session = session;
	}

	// Getters y setters
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
