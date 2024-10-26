package br.com.derich.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.derich.domain.Produto;
import br.com.derich.exception.EntityNotFoundException;
import br.com.derich.repository.IProdutoRepository;

public class BuscarProduto {

	private IProdutoRepository produtoRepository;
	
	@Autowired
	public BuscarProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Page<Produto> buscar(Pageable pageable) {
		return produtoRepository.findAll(pageable);
	}

	public Produto buscarPorCodigo(String codigo) {
		return produtoRepository.findByCodigo(codigo)				
				.orElseThrow(() -> new EntityNotFoundException(Produto.class, "codigo", codigo));
	}
}