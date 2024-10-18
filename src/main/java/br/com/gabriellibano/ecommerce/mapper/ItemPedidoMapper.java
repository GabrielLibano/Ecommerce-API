package br.com.gabriellibano.ecommerce.mapper;

import br.com.gabriellibano.ecommerce.dtos.cliente.ClienteResponseDto;
import br.com.gabriellibano.ecommerce.dtos.itempedido.ItemPedidoRequestCreateDto;
import br.com.gabriellibano.ecommerce.dtos.itempedido.ItemPedidoRequestUpdateDto;
import br.com.gabriellibano.ecommerce.dtos.itempedido.ItemPedidoResponseDto;
import br.com.gabriellibano.ecommerce.model.Cliente;
import br.com.gabriellibano.ecommerce.model.ItemPedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    @Autowired
    private ModelMapper modelMapper;
    public ItemPedidoResponseDto toDto(ItemPedido itemPedido) {
        return modelMapper.map(itemPedido, ItemPedidoResponseDto.class);
    }
    public ItemPedido toModel(ItemPedidoRequestCreateDto dto) {
        return modelMapper.map(dto, ItemPedido.class);
    }
    public ItemPedido toModel(Long id, ItemPedidoRequestUpdateDto dto) {
        ItemPedido result = modelMapper.map(dto, ItemPedido.class);
        result.setId(id);
        return result;
    }
}
