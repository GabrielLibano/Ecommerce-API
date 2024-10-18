package br.com.gabriellibano.ecommerce.mapper;

import br.com.gabriellibano.ecommerce.dtos.pedido.PedidoRequestCreateDto;
import br.com.gabriellibano.ecommerce.dtos.pedido.PedidoRequestUpdateDto;
import br.com.gabriellibano.ecommerce.dtos.pedido.PedidoResponseDto;
import br.com.gabriellibano.ecommerce.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    @Autowired
    private ModelMapper modelMapper;
    public PedidoResponseDto toDto(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResponseDto.class);
    }
    public Pedido toModel(PedidoRequestCreateDto dto) {
        return modelMapper.map(dto, Pedido.class);
    }
    public Pedido toModel(Long id, PedidoRequestUpdateDto dto) {
        Pedido result = modelMapper.map(dto, Pedido.class);
        result.setId(id);
        return result;
    }
}
