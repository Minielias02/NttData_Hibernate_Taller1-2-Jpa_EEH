package com.nttdata.hibernate.taller1.EEH.persistence;

import org.hibernate.Session;

public class BossDaoImp extends CommonDaoImplement<BossTables> implements BossDaoI {
	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public BossDaoImp(Session session) {
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
