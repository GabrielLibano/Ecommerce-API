package br.com.gabriellibano.ecommerce.dtos.itempedido;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import br.com.gabriellibano.ecommerce.model.ItemPedido;
@Getter
@Setter
public class ItemPedidoRequestUpdateDto {
	private Long idPedido;
    private Long idProduto;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
}