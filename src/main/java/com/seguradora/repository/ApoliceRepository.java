package com.seguradora.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.seguradora.model.Apolice;

public interface ApoliceRepository extends MongoRepository<Apolice, String>{

}
