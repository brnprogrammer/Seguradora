package com.seguradora.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguradora.model.Apolice;
import com.seguradora.model.ApoliceDTO;
import com.seguradora.model.Cliente;
import com.seguradora.repository.ClienteRepository;
import com.seguradora.service.ApoliceService;

@RestController
@RequestMapping("/apolice")
public class ApoliceController {
	private static final Logger log = LoggerFactory.getLogger(ApoliceController.class);

	@Autowired
	private ApoliceService apoliceService;

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping("/cadastrar")
	public ResponseEntity<Apolice> cadastrar(@RequestBody @Valid Apolice apolice) {
		try {
			Optional<Cliente> cliente = clienteRepository.findByCpf(apolice.getCpfCliente());
			if (cliente.isPresent()) {
				apoliceService.cadastrar(apolice);
				return ResponseEntity.ok().body(apolice);
			}
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			log.info("### [ApoliceController.cadastrar] ERRO AO CADASTRAR APOLICE ###");
			throw e;
		}
		

	}

	@GetMapping("listar/{id}")
	public ResponseEntity<Optional<ApoliceDTO>> listar(@PathVariable(required = true) String id) {
		try {
			Optional<ApoliceDTO> apolice = Optional.ofNullable(apoliceService.findById(id));
			if (apolice.isPresent()) {
				return ResponseEntity.ok().body(apolice);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			log.info("### [ApoliceController.listar] ERRO AO FILTRAR APOLICE POR ID ###");
			throw e;
		}
		
	}

}
