package br.com.gabriellibano.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gabriellibano.ecommerce.model.Produto;
import br.com.gabriellibano.ecommerce.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
	private final ProdutoRepository produtoRepository = null;

    public List<Produto> list() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {        
        return produtoRepository.save(produto);
    }

    public boolean existsById(Long id) {        
        return produtoRepository.existsById(id);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

   
}
