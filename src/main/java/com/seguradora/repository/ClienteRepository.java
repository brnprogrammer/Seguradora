package com.seguradora.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.seguradora.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
	

	Optional<Cliente> findByCpf(String cpf);
	
}
