package br.com.gabriellibano.ecommerce.dtos.produto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProdutoRequestCreateDto {
	private String nome;
	private BigDecimal valor;
}
