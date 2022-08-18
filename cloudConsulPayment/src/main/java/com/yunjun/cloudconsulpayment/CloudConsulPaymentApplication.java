package com.yunjun.cloudconsulpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsulPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsulPaymentApplication.class, args);
	}

}
