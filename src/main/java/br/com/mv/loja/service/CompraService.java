package br.com.mv.loja.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mv.loja.dto.CompraDTO;
import br.com.mv.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	private RestTemplate client;

	public void realizaCompra(CompraDTO compra) {

		ResponseEntity<br.com.mv.loja.dto.InfoFornecedorDTO> exchange = client.exchange(
				"http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
				InfoFornecedorDTO.class);

		System.out.println(exchange.getBody().getEndereco());

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
