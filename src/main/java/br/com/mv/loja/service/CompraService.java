package br.com.mv.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mv.loja.client.FornecedorClient;
import br.com.mv.loja.dto.CompraDTO;
import br.com.mv.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired(required = true)
	FornecedorClient fornecedorClient;

	public void realizaCompra(CompraDTO compra) {
		
	InfoFornecedorDTO info = fornecedorClient.getFindByEstado(compra.getEndereco().getEstado());
		System.out.println(info.getEndereco());

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
