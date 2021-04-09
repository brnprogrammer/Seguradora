package com.seguradora.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguradora.model.Cliente;
import com.seguradora.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	private static final Logger log = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	private ClienteService clienteService;;
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente){
		try {
			clienteService.cadastrar(cliente);
			return ResponseEntity.ok().body(cliente);
		} catch (Exception e) {
			log.info("### [ClienteController.cadastrar] erro ao cadastrar novo cliente ###");
			throw e;
		}
		
	}
	
}
