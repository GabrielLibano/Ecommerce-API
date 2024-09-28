package br.com.gabriellibano.ecommerce.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriellibano.ecommerce.dtos.ProdutoResponseDto;
import br.com.gabriellibano.ecommerce.dtos.pedido.PedidoRequestCreateDto;
import br.com.gabriellibano.ecommerce.dtos.pedido.PedidoRequestUpdateDto;
import br.com.gabriellibano.ecommerce.dtos.pedido.PedidoResponseDto;
import br.com.gabriellibano.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
    private PedidoService pedidoService;
	
	
	@GetMapping
    public ResponseEntity<List<PedidoResponseDto>> list() {
    	List<PedidoResponseDto> dtos = pedidoService.list()
                .stream()
                .map(e -> new PedidoResponseDto().toDto(e))
                .toList();

            return ResponseEntity.ok().body(dtos);
    }
	
	@PostMapping
    public ResponseEntity<PedidoResponseDto> create(@RequestBody PedidoRequestCreateDto dto) {        
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			new PedidoResponseDto().toDto(
        					pedidoService.save(dto.toModel()))
        			);
    }
	
	@PutMapping("{id}")
    public ResponseEntity<PedidoResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody PedidoRequestUpdateDto dto) {
        if (! pedidoService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
        		.body(
        			new PedidoResponseDto().toDto(
        				pedidoService.save(dto.toModel(id)))
        		);
    }
	
	
	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! pedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        pedidoService.delete(id);
    }
	
	@GetMapping("{id}")
    public ResponseEntity<PedidoResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				pedidoService
    					.findById(id)
    					.map(e -> new PedidoResponseDto().toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);

    }

}