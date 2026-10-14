package com.naman.upi_mesh_relay;

import com.naman.upi_mesh_relay.dao.AccountDAO;
import com.naman.upi_mesh_relay.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UpiMeshRelayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpiMeshRelayApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
			readAccount(accountDAO);
			queryForAccounts(accountDAO);
			queryByVpa(accountDAO);
		};
	}

	private void readAccount(AccountDAO accountDAO) {
		System.out.println("--- findById ---");

		Account found = accountDAO.findById(1);
		System.out.println("Found: " + found);

		Account missing = accountDAO.findById(999);
		System.out.println("Id 999: " + (missing == null ? "not found" : missing));
	}

	private void queryForAccounts(AccountDAO accountDAO) {
		System.out.println("--- findAll ---");

		List<Account> accounts = accountDAO.findAll();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}

	private void queryByVpa(AccountDAO accountDAO) {
		System.out.println("--- findByVpa ---");

		Account found = accountDAO.findByVpa("meera@upi");
		System.out.println("meera@upi: " + (found == null ? "not found" : found));

		Account missing = accountDAO.findByVpa("nobody@upi");
		System.out.println("nobody@upi: " + (missing == null ? "not found" : missing));
	}
}