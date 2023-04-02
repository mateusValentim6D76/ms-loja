package br.com.mv.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mv.loja.client.FornecedorClient;
import br.com.mv.loja.dto.CompraDTO;
import br.com.mv.loja.dto.InfoFornecedorDTO;
import br.com.mv.loja.dto.ItemPedidoDTO;
import br.com.mv.loja.model.Compra;

@Service
public class CompraService {

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired(required = true)
	FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		
	final String estado = compra.getEndereco().getEstado();	
		
	LOG.info("Buscando informações do fornecedor de {}", estado);
	InfoFornecedorDTO info = fornecedorClient.getFindByEstado(compra.getEndereco().getEstado());
	
	LOG.info("Realizando um pedido");
	ItemPedidoDTO infoPedido = fornecedorClient.realizaPedido(compra.getItens());
	
	System.out.println(info.getEndereco());
		
	Compra compraSalva = new Compra();
	compraSalva.setId(infoPedido.getId());
	compraSalva.setTempoDePreparo(infoPedido.getTempoDePreparo());
	compraSalva.setEnderecoDeDestino(compra.getEndereco().toString());
	return compraSalva;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
