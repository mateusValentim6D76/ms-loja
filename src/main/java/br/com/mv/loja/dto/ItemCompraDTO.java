package br.com.mv.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCompraDTO {
	
	private Long id;
	
	private Integer quantidade;
	
}
