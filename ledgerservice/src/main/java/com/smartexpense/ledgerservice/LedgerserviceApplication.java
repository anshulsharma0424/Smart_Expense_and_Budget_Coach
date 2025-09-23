package com.smartexpense.ledgerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LedgerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LedgerserviceApplication.class, args);
	}

}
