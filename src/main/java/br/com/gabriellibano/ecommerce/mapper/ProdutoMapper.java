package br.com.gabriellibano.ecommerce.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gabriellibano.ecommerce.dtos.produto.ProdutoRequestCreateDto;
import br.com.gabriellibano.ecommerce.dtos.produto.ProdutoRequestUpdateDto;
import br.com.gabriellibano.ecommerce.dtos.produto.ProdutoResponseDto;
import br.com.gabriellibano.ecommerce.model.Produto;

@Component
public class ProdutoMapper {    
    
    @Autowired
    private  ModelMapper modelMapper;
    public ProdutoResponseDto toDto(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDto.class);
    }
    public Produto toModel(ProdutoRequestCreateDto dto) {
        return modelMapper.map(dto, Produto.class);
    }
    public Produto toModel(Long id, ProdutoRequestUpdateDto dto) {
        Produto result = modelMapper.map(dto, Produto.class);
        result.setId(id);
        return result;
    }   
}
