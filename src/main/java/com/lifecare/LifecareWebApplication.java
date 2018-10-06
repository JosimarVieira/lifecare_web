package com.lifecare;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lifecare.domain.Cidade;
import com.lifecare.repositories.CidadeRepository;

@SpringBootApplication
public class LifecareWebApplication implements CommandLineRunner{

	@Autowired
	CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LifecareWebApplication.class, args);

	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Cidade c1 = new Cidade(null, "SP", "SP");
		Cidade c2 = new Cidade(null, "RJ", "RJ");
		
		cidadeRepository.save(Arrays.asList(c1, c2));
		
	}
}
