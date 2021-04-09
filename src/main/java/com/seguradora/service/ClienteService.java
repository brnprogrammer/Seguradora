package com.seguradora.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguradora.model.Cliente;
import com.seguradora.repository.ClienteRepository;

@Service
public class ClienteService {
	private static final Logger log = LoggerFactory.getLogger(ClienteService.class);
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public void cadastrar(Cliente cliente) {
		try {
			clienteRepository.save(new Cliente(cliente.getNome(), cliente.getCpf(), cliente.getCidade(), cliente.getUf()));
		} catch (Exception e) {
			log.info("### [ClienteService.cadastrar] Erro ao cadastrar novo cliente ###");
			throw e;
		}
		
	}
	

}
