package com.redsocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class RedSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedSocialApplication.class, args);
	}

}
