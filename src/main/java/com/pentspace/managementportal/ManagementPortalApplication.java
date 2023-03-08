package com.pentspace.managementportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementPortalApplication.class, args);
	}

}
