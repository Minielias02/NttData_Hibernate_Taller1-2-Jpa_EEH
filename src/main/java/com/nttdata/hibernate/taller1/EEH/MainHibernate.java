package com.nttdata.hibernate.taller1.EEH;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.taller1.EEH.persistence.BossTables;
import com.nttdata.hibernate.taller1.EEH.persistence.ContractTables;
import com.nttdata.hibernate.taller1.EEH.persistence.CustomerTables;
import com.nttdata.hibernate.taller1.EEH.persistence.EnterpriseTables;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoBossService;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoBossServiceImp;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoContractService;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoContractServiceImp;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoCustomerService;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoCustomerServiceImpl;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoEnterpriseService;
import com.nttdata.hibernate.taller1.EEH.services.NttDataDaoEnterpriseServiceImp;

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
		final NttDataDaoEnterpriseService enterpriseService = new NttDataDaoEnterpriseServiceImp(session);
		final NttDataDaoBossService bossService = new NttDataDaoBossServiceImp(session);
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
		contractListCustomer2.add(contract2);

		List<ContractTables> contractListCustomer3 = new ArrayList<ContractTables>();
		contractListCustomer3.add(contract3);
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

		// Creacion de customers en enterprises
		List<CustomerTables> customerListToEnterprise1 = new ArrayList<CustomerTables>();
		customerListToEnterprise1.add(customer1);
		// Creacion de enterprises
		final EnterpriseTables enterprise1 = new EnterpriseTables();
		enterprise1.setName("Unity");
		enterprise1.setNumberOfCountries(20);
		enterprise1.setCustomerList(customerListToEnterprise1);
		enterpriseService.insertNewEnterprise(enterprise1);

		List<CustomerTables> customerListToEnterprise2 = new ArrayList<CustomerTables>();
		customerListToEnterprise2.add(customer2);
		customerListToEnterprise2.add(customer3);
		// Creacion de enterprises
		final EnterpriseTables enterprise2 = new EnterpriseTables();
		enterprise2.setName("Xbox");
		enterprise2.setNumberOfCountries(50);
		enterprise2.setCustomerList(customerListToEnterprise2);
		enterpriseService.insertNewEnterprise(enterprise2);

		// Creacion de enterprises
		final EnterpriseTables enterprise3 = new EnterpriseTables();
		enterprise3.setName("Bethesda");
		enterprise3.setNumberOfCountries(10);
		enterprise3.setCustomerList(null);
		enterpriseService.insertNewEnterprise(enterprise3);

		// Muestro todos los enterprises
		List<EnterpriseTables> enterpriseList = enterpriseService.searchAll();
		System.out.println("*** " + enterpriseList);

		// Añado las enterprise a los customer
		List<EnterpriseTables> enterpiseListToCustomer1 = new ArrayList<EnterpriseTables>();
		enterpiseListToCustomer1.add(enterprise1);
		List<EnterpriseTables> enterpiseListToCustomer2 = new ArrayList<EnterpriseTables>();
		enterpiseListToCustomer2.add(enterprise2);
		List<EnterpriseTables> enterpiseListToCustomer3 = new ArrayList<EnterpriseTables>();
		enterpiseListToCustomer3.add(enterprise2);

		customerService.updateCustomer(customer1);
		customerService.updateCustomer(customer2);
		customerService.updateCustomer(customer3);

		System.out.println("\n" + enterpriseService.searchById(1));

		// Creacion de boss
		final BossTables boss1 = new BossTables();
		boss1.setName("Antonia");
		boss1.setFirstSurname("Sanchez");
		boss1.setMoney(12000000);
		boss1.setEnterpriseRelation(enterprise3);
		bossService.insertNewBoss(boss1);
		
		final BossTables boss2 = new BossTables();
		boss2.setName("Maria");
		boss2.setFirstSurname("Lopez");
		boss2.setMoney(4000000);
		boss2.setEnterpriseRelation(enterprise2);
		bossService.insertNewBoss(boss2);
		
		final BossTables boss3 = new BossTables();
		boss3.setName("Jose");
		boss3.setFirstSurname("Pancho");
		boss3.setMoney(30000000);
		boss3.setEnterpriseRelation(enterprise1);
		bossService.insertNewBoss(boss3);
		
		//Seteo a las empresa un boss y luego las actualizo
		enterprise1.setBossRelation(boss3);
		enterprise2.setBossRelation(boss2);
		enterprise3.setBossRelation(boss1);

		enterpriseService.updateEnterprise(enterprise1);
		enterpriseService.updateEnterprise(enterprise2);
		enterpriseService.updateEnterprise(enterprise3);
		
		// ---------Ejercicio JPA Criteria------------

		System.out.println("\nEstos son los resultados del JPA Criteria: "
				+ customerService.returnAllCustomer(customer1, contract1));

	}
}
