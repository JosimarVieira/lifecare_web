package com.lifecare;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lifecare.domain.Cidade;
import com.lifecare.domain.LinhaDeCuidado;
import com.lifecare.domain.Medicamento;
import com.lifecare.domain.Medico;
import com.lifecare.domain.Paciente;
import com.lifecare.domain.Prontuario;
import com.lifecare.domain.Risco;
import com.lifecare.repositories.CidadeRepository;
import com.lifecare.repositories.LinhaDeCuidadoRepository;
import com.lifecare.repositories.MedicamentoRepository;
import com.lifecare.repositories.MedicoRepository;
import com.lifecare.repositories.PacienteRepository;
import com.lifecare.repositories.ProntuarioRepository;
import com.lifecare.repositories.RiscoRepository;

@SpringBootApplication
public class LifecareWebApplication implements CommandLineRunner{

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired 
	MedicamentoRepository medicamentoRepository;
	
	@Autowired
	ProntuarioRepository prontuarioRepository;
	
	@Autowired
	MedicoRepository medicoRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	LinhaDeCuidadoRepository linhaDeCuidadoRepository;
	
	@Autowired 
	RiscoRepository riscoRepository;

	
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
		
		medicamentoRepository.save(Arrays.asList(m1, m2));
		
		Paciente paciente1 = new Paciente(null, "Carlos", 29, "carlos@gmail.com", "123", null, null, null);	
		Paciente paciente2 = new Paciente(null, "Roberto", 40, "roberto@gmail.com", "123", null, null, null);	
		Medico med = new Medico(null, "Rodolfo", 18, "email", "123");
		Medico med1 = new Medico(null, "Rodrigo", 18, "email", "123");
		Prontuario p1 = new Prontuario(null, 500, paciente1);
		LinhaDeCuidado linhaDeCuidado = new LinhaDeCuidado(null, "Ações", "Título", p1);
		Risco risco = new Risco(null, "Alto risco");
		
		med.getEspecialidades().add("Especialidade1");
		med.getPacientes().add(paciente1);
		
		paciente1.setMedico(med);

		p1.getMedicamentos().add(m1);
		p1.getMedicamentos().add(m2);
		
		p1.getLinhasDeCuidado().add(linhaDeCuidado);
		p1.getRiscos().add(risco);
		
		med.setCidade(c1);
		med1.setCidade(c2);
		paciente1.setCidade(c2);
		
		riscoRepository.save(risco);
		medicoRepository.save(med);
		pacienteRepository.save(Arrays.asList(paciente1, paciente2));
		prontuarioRepository.save(p1);
		medicoRepository.save(med1);
		linhaDeCuidadoRepository.save(linhaDeCuidado);
		
	}
}
