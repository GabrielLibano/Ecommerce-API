package br.com.gabriellibano.ecommerce.dtos;
import org.modelmapper.ModelMapper;

import br.com.gabriellibano.ecommerce.model.Produto;
public class ProdutoResponseDto {
    private Long id;
	private String nome;
	private static final ModelMapper modelMapper = new ModelMapper();
	
	public ProdutoResponseDto toDto(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDto.class);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}