package br.com.gabriellibano.ecommerce.mapper;

import br.com.gabriellibano.ecommerce.dtos.cliente.ClienteRequestCreateDto;
import br.com.gabriellibano.ecommerce.dtos.cliente.ClienteRequestUpdateDto;
import br.com.gabriellibano.ecommerce.dtos.cliente.ClienteResponseDto;
import br.com.gabriellibano.ecommerce.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper modelMapper;
    public ClienteResponseDto toDto(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseDto.class);
    }
    public Cliente toModel(ClienteRequestCreateDto dto) {
        return modelMapper.map(dto, Cliente.class);
    }
    public Cliente toModel(Long id, ClienteRequestUpdateDto dto) {
        Cliente result = modelMapper.map(dto, Cliente.class);
        result.setId(id);
        return result;
    }

}
