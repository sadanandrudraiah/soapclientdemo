package com.ha.soapclientdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ha.wsclient.CountryClient;

import countries.wsdl.GetCountryResponse;

@SpringBootApplication
public class SoapclientdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapclientdemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				GetCountryResponse response = quoteClient.getCountry("Spain");
				System.err.println(response.getCountry().getCurrency());
			}
		};
		
	}	

}

