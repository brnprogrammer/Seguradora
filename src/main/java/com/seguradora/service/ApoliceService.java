package com.seguradora.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguradora.model.Apolice;
import com.seguradora.model.ApoliceDTO;
import com.seguradora.model.PrazoVigencia;
import com.seguradora.repository.ApoliceRepository;

@Service
public class ApoliceService {
	private static final Logger log = LoggerFactory.getLogger(ApoliceService.class);

	
	@Autowired
	private ApoliceRepository apoliceRepository;	
	
	
	public void cadastrar(Apolice apolice){
		try {
			apoliceRepository.save(new Apolice(apolice.getInicioVigencia(),  apolice.getValor(), apolice.getCpfCliente(), apolice.getFimVigencia()));	
		} catch (Exception e) {
			log.info("### [ApoliceService.cadastrar] ERRO AO CADASTRAR NOVA APOLICE ###");
			throw e;
		}
		
	}
	
	public ApoliceDTO findById(String id) {
		
		try {
			Optional<Apolice> apolice = apoliceRepository.findById(id);
			ApoliceDTO dtoAux = new ApoliceDTO();
			
			
			if(LocalDate.now().isAfter(apolice.get().getInicioVigencia()) && LocalDate.now().isBefore(apolice.get().getFimVigencia())) {
				dtoAux.setVencimentoApolice(PrazoVigencia.VIGENCIA_EM_ANDAMENTO);
				System.out.println(apolice.get().getFimVigencia().compareTo(LocalDate.now()));
				StringBuilder msg = new StringBuilder();
				msg.append(apolice.get().getFimVigencia().compareTo(LocalDate.now()) + "dias para o vencimento");
				dtoAux.setMsgPrazoVencimento(msg.toString()); 
			}else if(LocalDate.now().isAfter(apolice.get().getFimVigencia())) {
				dtoAux.setVencimentoApolice(PrazoVigencia.VENCIDA);
				StringBuilder msg = new StringBuilder();
				msg.append("Vencida a  " + apolice.get().getFimVigencia().compareTo(LocalDate.now()) +" dias");
				dtoAux.setMsgPrazoVencimento(msg.toString()); 
				
				
			}else {
				dtoAux.setVencimentoApolice(PrazoVigencia.PRAZO_DE_VIGENCIA_NAO_INICIADO);
				StringBuilder msg = new StringBuilder();
				msg.append(apolice.get().getInicioVigencia().compareTo(LocalDate.now()) +" dias para o inicio do prazo de vigencia");
				dtoAux.setMsgPrazoVencimento(msg.toString()); 
			}
			
			dtoAux.setValor(apolice.get().getValor());
			dtoAux.setInicioVigencia(apolice.get().getInicioVigencia());
			dtoAux.setFimVigencia(apolice.get().getFimVigencia());
			
			return dtoAux;
			
		} catch (Exception e) {
			log.info("### [ApoliceService.findById] ERRO AO BUSCAR APOLICE POR ID ###");
			throw e;
		}
		
		
	}
}
