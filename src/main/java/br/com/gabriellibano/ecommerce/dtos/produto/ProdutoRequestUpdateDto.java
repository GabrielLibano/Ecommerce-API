package br.com.gabriellibano.ecommerce.dtos.produto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ProdutoRequestUpdateDto {
	private String nome;
	private BigDecimal valor;
}
