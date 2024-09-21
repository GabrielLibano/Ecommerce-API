package br.com.gabriellibano.ecommerce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriellibano.ecommerce.dtos.ProdutoRequestCreateDto;
import br.com.gabriellibano.ecommerce.dtos.ProdutoRequestUpdateDto;
import br.com.gabriellibano.ecommerce.dtos.ProdutoResponseDto;
import br.com.gabriellibano.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> list() {
        List<ProdutoResponseDto> dto = produtoService.list()
        		.stream()
        		.map(e -> new ProdutoResponseDto().toDto(e))
        		.toList();
        
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ProdutoResponseDto create(@RequestBody ProdutoRequestCreateDto dto) {
    	return new ProdutoResponseDto().toDto(
        		produtoService.save(dto.toModel()));
    }
    // localhost:8080/produtos/5
    /* body/payload: {
            "id": 5,
            "nome": "Um nome novo"
        }
     */
    @PutMapping("{id}")
    public ProdutoResponseDto update(
                        @PathVariable Long id, 
                        @RequestBody ProdutoRequestUpdateDto dto) {
        if (! produtoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        return new ProdutoResponseDto().toDto(
        		produtoService.save(dto.toModel(id)));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!produtoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        produtoService.delete(id);
    }

    @GetMapping("{id}")
    public ProdutoResponseDto findById(@PathVariable Long id) {
    	
       return produtoService
    		   .findById(id)
    		   .map(e -> new ProdutoResponseDto().toDto(e))
    		   .orElseThrow(() -> new RuntimeException("Id inexistente"));
    }
}

