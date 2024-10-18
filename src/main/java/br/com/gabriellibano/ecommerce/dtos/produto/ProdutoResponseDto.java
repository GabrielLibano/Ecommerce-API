package br.com.gabriellibano.ecommerce.dtos.produto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponseDto {
	private Long id;
	private String nome;
	private BigDecimal valor;
}