package br.com.gabriellibano.ecommerce.dtos.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import br.com.gabriellibano.ecommerce.model.Pedido;
@Getter
@Setter
public class PedidoRequestCreateDto {
	private Long idCliente;
	private LocalDate dataPedido;
	private String status;
	private String formaPagamento;
	private BigDecimal valorTotal;
}
