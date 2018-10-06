package com.lifecare;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lifecare.domain.Cidade;
import com.lifecare.domain.Medicamento;
import com.lifecare.domain.Prontuario;
import com.lifecare.repositories.CidadeRepository;
import com.lifecare.repositories.MedicamentoRepository;
import com.lifecare.repositories.ProntuarioRepository;

@SpringBootApplication
public class LifecareWebApplication implements CommandLineRunner{

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired 
	MedicamentoRepository medicamentoRepository;
	
	@Autowired
	ProntuarioRepository prontuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LifecareWebApplication.class, args);

	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Cidade c1 = new Cidade(null, "SP", "SP");
		Cidade c2 = new Cidade(null, "RJ", "RJ");
		
		cidadeRepository.save(Arrays.asList(c1, c2));
		
		Medicamento m1 = new Medicamento(null, 2, "Rivotril", "tipoTeste", true, "admDeUso");
		Medicamento m2 = new Medicamento(null, 5, "Dipirona", "tipoTeste", true, "admDeUso");
		
		Prontuario p1 = new Prontuario(null, 500, null, null, null);
		Prontuario p2 = new Prontuario(null, 700, null, null, null);
		
		m1.getProntuarios().add(p1);
		m2.getProntuarios().add(p2);
		
		p1.getMedicamentos().add(m1);
		p2.getMedicamentos().add(m2);
		
		medicamentoRepository.save(Arrays.asList(m1, m2));
		prontuarioRepository.save(Arrays.asList(p1, p2));
		
	}
}
