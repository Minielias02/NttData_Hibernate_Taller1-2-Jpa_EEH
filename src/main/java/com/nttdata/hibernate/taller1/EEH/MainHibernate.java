package com.nttdata.hibernate.taller1.EEH;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.hibernate.taller1.EEH.persistence.ContractTables;
import com.nttdata.hibernate.taller1.EEH.persistence.CustomerTables;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoContractService;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoContractServiceImp;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoCustomerService;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoCustomerServiceImpl;

/**
 * 
 * @author elias
 *
 */
public class MainHibernate {
	/**
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		final Session session = EntityManagerUtil.getSessionFactory().openSession();
		// Inicialización de servicios.
		final NttDataDaoCustomerService customerService = new NttDataDaoCustomerServiceImpl(session);
		final NttDataDaoContractService contractService = new NttDataDaoContractServiceImp(session);
		// Creo las variables de tipo Date
		Date dateExpiration;
		Date dateValidation;

		// Creacion de customers
		final CustomerTables customer1 = new CustomerTables();
		customer1.setName("Elias");
		customer1.setFirstSurname("Espinosa");
		customer1.setSecondSurname("Hornillo");
		customer1.setDni("00000000E");
		customerService.insertNewCustomer(customer1);

		final CustomerTables customer2 = new CustomerTables();
		customer2.setName("Juan");
		customer2.setFirstSurname("Exilio");
		customer2.setSecondSurname("Urbano");
		customer2.setDni("00000000I");
		customerService.insertNewCustomer(customer2);

		final CustomerTables customer3 = new CustomerTables("Pedro", "Sanchez", "Ajolote", "00000000U");
		customerService.insertNewCustomer(customer3);
		// Muestro todos los customers
		List<CustomerTables> customerList = customerService.searchAll();
		System.out.println("*** " + customerList);

		customerService.updateCustomer(customer1);
		customerService.updateCustomer(customer2);
		customerService.updateCustomer(customer3);
		// Borra un customer
		// customerService.deleteCustomer(customer3);
		System.out.println("\n" + customerService.searchById(1));

		// -----------Ejercicio 2------------------
		// Este atributo da formato a una fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

		// Creacion de contrato
		final ContractTables contract1 = new ContractTables();
		// Les doy a las variables de tipo Date un nuevo formato
		dateExpiration = dateFormat.parse("20-08-2012");
		dateValidation = dateFormat.parse("15-10-2010");
		// Las paso a string las fechas
		contract1.setValidityDate(dateFormat.format(dateValidation));
		contract1.setExpirationDate(dateFormat.format(dateExpiration));
		contract1.setMonthlyPrice(1000);
		contract1.setCustomer(customer1);

		final ContractTables contract2 = new ContractTables();
		dateExpiration = dateFormat.parse("20-08-2022");
		dateValidation = dateFormat.parse("15-10-2020");

		contract2.setValidityDate(dateFormat.format(dateValidation));
		contract2.setExpirationDate(dateFormat.format(dateExpiration));
		contract2.setMonthlyPrice(2000);
		contract2.setCustomer(customer2);

		final ContractTables contract3 = new ContractTables();
		dateExpiration = dateFormat.parse("20-08-2032");
		dateValidation = dateFormat.parse("15-10-2030");

		contract3.setValidityDate(dateFormat.format(dateValidation));
		contract3.setExpirationDate(dateFormat.format(dateExpiration));
		contract3.setMonthlyPrice(3000);
		contract3.setCustomer(customer3);

		final ContractTables contract4 = new ContractTables();
		dateExpiration = dateFormat.parse("20-08-2042");
		dateValidation = dateFormat.parse("15-10-2040");

		contract4.setValidityDate(dateFormat.format(dateValidation));
		contract4.setExpirationDate(dateFormat.format(dateExpiration));
		contract4.setMonthlyPrice(4000);
		contract4.setCustomer(customer3);

		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);
		contractService.insertNewContract(contract3);
		contractService.insertNewContract(contract4);

		System.out.println("\n" + contractService.searchAll());

		// Creo las listas de contratos para añadir contratos a acada customer
		List<ContractTables> contractListCustomer1 = new ArrayList<ContractTables>();
		contractListCustomer1.add(contract1);

		List<ContractTables> contractListCustomer2 = new ArrayList<ContractTables>();
		contractListCustomer1.add(contract2);

		List<ContractTables> contractListCustomer3 = new ArrayList<ContractTables>();
		contractListCustomer1.add(contract3);
		contractListCustomer3.add(contract4);

		// Añado los contratos a los customers
		customer1.setContracts(contractListCustomer1);
		customer2.setContracts(contractListCustomer2);
		customer3.setContracts(contractListCustomer3);

		// Updateo los customers
		customerService.updateCustomer(customer1);
		customerService.updateCustomer(customer2);
		customerService.updateCustomer(customer3);

		System.out.println("\n*** " + customerList);

		// ---------Ejercicio JPA Criteria------------
		// Consulta.
		final CriteriaBuilder jpaCriteriaConsults = session.getCriteriaBuilder();
		final CriteriaQuery<CustomerTables> customerQuerys = jpaCriteriaConsults.createQuery(CustomerTables.class);
		final Root<CustomerTables> rootCustomer = customerQuerys.from(CustomerTables.class);
		final Join<CustomerTables, ContractTables> customerTableJoinContracTable = rootCustomer.join("contracts");

		// Where
		final Predicate pr1 = jpaCriteriaConsults.like(customerTableJoinContracTable.getParent().<String>get("name"),
				customer1.getName());
		final Predicate pr2 = jpaCriteriaConsults.equal(customerTableJoinContracTable.get("id"), contract1.getId());

		// Consulta
		customerQuerys.select(rootCustomer).where(jpaCriteriaConsults.and(pr1, pr2));

		// Ordenamos por Dni
		customerQuerys.orderBy(jpaCriteriaConsults.desc(customerTableJoinContracTable.get("id")));

		// Ejecución de consulta.
		final List<CustomerTables> results = session.createQuery(customerQuerys).getResultList();
		// Muestra la lista de la consulta
		System.out.println("\nEstos son los resultados del JPA Criteria: " + results);

	}
}
