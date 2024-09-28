package br.com.gabriellibano.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriellibano.ecommerce.model.Produto;
import br.com.gabriellibano.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired(required=true)
    private ProdutoRepository produtoRepository;

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
