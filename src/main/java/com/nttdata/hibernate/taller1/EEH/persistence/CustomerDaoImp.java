package com.nttdata.hibernate.taller1.EEH.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

	@Override
	public List<CustomerTables> returnAllCustomer(CustomerTables customer1, ContractTables contract1) {
		// ---------Ejercicio JPA Criteria------------
		// Consulta.
		final CriteriaBuilder jpaCriteriaConsults = session.getCriteriaBuilder();
		final CriteriaQuery<CustomerTables> customerQuerys = jpaCriteriaConsults.createQuery(CustomerTables.class);
		final Root<CustomerTables> rootCustomer = customerQuerys.from(CustomerTables.class);
		final Join<CustomerTables, ContractTables> customerTableJoinContracTable = rootCustomer.join("contracts");

		// Where
		final Predicate pr1 = jpaCriteriaConsults.like(customerTableJoinContracTable.getParent().<String>get("name"),
				customer1.getName());
		final Predicate pr2 = jpaCriteriaConsults.equal(customerTableJoinContracTable.get("contractId"), contract1.getId());

		// Consulta
		customerQuerys.select(rootCustomer).where(jpaCriteriaConsults.and(pr1, pr2));

		// Ordenamos por Dni
		customerQuerys.orderBy(jpaCriteriaConsults.desc(customerTableJoinContracTable.get("contractId")));

		// Ejecución de consulta.
		final List<CustomerTables> results = session.createQuery(customerQuerys).getResultList();
		// Muestra la lista de la consulta

		return results;
	}

}
