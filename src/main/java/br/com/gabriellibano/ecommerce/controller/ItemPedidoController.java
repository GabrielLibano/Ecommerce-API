package br.com.gabriellibano.ecommerce.controller;

import java.util.List;

import br.com.gabriellibano.ecommerce.mapper.ItemPedidoMapper;
import br.com.gabriellibano.ecommerce.mapper.PedidoMapper;
import br.com.gabriellibano.ecommerce.repository.ItemPedidoRepository;
import br.com.gabriellibano.ecommerce.repository.PedidoRepository;
import br.com.gabriellibano.ecommerce.service.PedidoService;
import lombok.RequiredArgsConstructor;
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

import br.com.gabriellibano.ecommerce.dtos.itempedido.ItemPedidoRequestCreateDto;
import br.com.gabriellibano.ecommerce.dtos.itempedido.ItemPedidoRequestUpdateDto;
import br.com.gabriellibano.ecommerce.dtos.itempedido.ItemPedidoResponseDto;
import br.com.gabriellibano.ecommerce.service.ItemPedidoService;

@RestController
@RequestMapping("/itemPedidos")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;
    private final ItemPedidoMapper itemPedidoMapper;
    private final ItemPedidoRepository itemPedidoRepository;

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> list() {
        List<ItemPedidoResponseDto> dtos = itemPedidoService.list()
                .stream()
                .map(e -> itemPedidoMapper.toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> create(@RequestBody ItemPedidoRequestCreateDto dto) {        
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(itemPedidoMapper.toDto(
                        itemPedidoService.save(itemPedidoMapper.toModel(dto)))
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody ItemPedidoRequestUpdateDto dto) {
        if (! itemPedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(itemPedidoMapper.toDto(
                        itemPedidoService.save(itemPedidoMapper.toModel(id, dto)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! itemPedidoService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        itemPedidoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
                        itemPedidoService
                                .findById(id)
                                .map(e -> itemPedidoMapper.toDto(e))
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );

    }

}