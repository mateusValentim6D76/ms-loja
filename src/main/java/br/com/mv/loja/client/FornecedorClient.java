package br.com.mv.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.mv.loja.dto.InfoFornecedorDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@GetMapping("/info/{estado}")
	 InfoFornecedorDTO getFindByEstado(@PathVariable String estado);
}
