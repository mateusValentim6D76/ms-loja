package br.com.mv.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.loja.dto.CompraDTO;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private br.com.mv.loja.service.CompraService compraService;

	@RequestMapping(method = RequestMethod.POST)
	public void realizaCompra(@RequestBody CompraDTO compra) {
		compraService.realizaCompra(compra);
	}
}
