package br.com.gabriellibano.ecommerce.dtos.cliente;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import br.com.gabriellibano.ecommerce.model.Cliente;
@Getter
@Setter
public class ClienteResponseDto {
	private Long id;
	private String nome;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
}
