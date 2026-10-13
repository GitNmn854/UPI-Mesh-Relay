package com.naman.upi_mesh_relay;

import com.naman.upi_mesh_relay.dao.AccountDAO;
import com.naman.upi_mesh_relay.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class UpiMeshRelayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpiMeshRelayApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> createAccount(accountDAO);
	}

	private void createAccount(AccountDAO accountDAO) {
		Account account = new Account("naman@upi", "Naman", new BigDecimal("1000.00"));

		System.out.println("Saving account...");
		accountDAO.save(account);
		System.out.println("Saved. Generated id: " + account.getId());
	}
}