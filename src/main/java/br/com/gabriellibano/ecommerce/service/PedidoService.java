package br.com.gabriellibano.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriellibano.ecommerce.model.Pedido;
import br.com.gabriellibano.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {

	 @Autowired(required=true)
	 private PedidoRepository pedidoRepository;
	 
	 public List<Pedido> list() {
	        return pedidoRepository.findAll();
	    }

	    public Pedido save(Pedido pedido) {        
	        return pedidoRepository.save(pedido);
	    }

	    public boolean existsById(Long id) {        
	        return pedidoRepository.existsById(id);
	    }

	    public void delete(Long id) {
	    	pedidoRepository.deleteById(id);
	    }

	    public Optional<Pedido> findById(Long id) {
	        return pedidoRepository.findById(id);
	    }
	
}
