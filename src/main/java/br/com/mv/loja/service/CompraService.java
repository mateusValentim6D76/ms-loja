package br.com.mv.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mv.loja.dto.CompraDTO;
import br.com.mv.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired
	private RestTemplate client;

	@Autowired
	private org.springframework.cloud.client.discovery.DiscoveryClient eurekaClient;

	public void realizaCompra(CompraDTO compra) {

		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
				"http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
				InfoFornecedorDTO.class);

		eurekaClient.getInstances("fornecedor").stream().forEach(fornecedor -> {
			System.out.println(fornecedor.getPort());
		});
		
		System.out.println(exchange.getBody().getEndereco());

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
