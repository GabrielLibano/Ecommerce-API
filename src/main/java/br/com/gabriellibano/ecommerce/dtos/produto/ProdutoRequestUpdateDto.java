package br.com.gabriellibano.ecommerce.dtos.produto;

import java.math.BigDecimal;

public class ProdutoRequestUpdateDto {
	private String nome;
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
