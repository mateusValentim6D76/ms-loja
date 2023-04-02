package br.com.mv.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mv.loja.dto.InfoFornecedorDTO;
import br.com.mv.loja.dto.ItemCompraDTO;
import br.com.mv.loja.dto.ItemPedidoDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@RequestMapping(method = RequestMethod.GET, value = "/info/{estado}")
	 InfoFornecedorDTO getFindByEstado(@PathVariable String estado);
	
	@RequestMapping(method = RequestMethod.POST, value = "/pedido")
	ItemPedidoDTO realizaPedido(List<ItemCompraDTO> itens);
}
