package br.com.derich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.derich.domain.Produto;
import br.com.derich.usecase.BuscarProduto;
import br.com.derich.usecase.CadastroProduto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

public class ProdutoResource {

	private BuscarProduto buscaProduto;
	
	private CadastroProduto cadastroProduto;
	
	@Autowired
	public ProdutoResource(BuscarProduto buscaProduto,
			CadastroProduto cadastroProduto) {
		this.buscaProduto = buscaProduto;
		this.cadastroProduto = cadastroProduto;
	}
	
	@GetMapping
	@Operation(summary = "Busca uma lista paginada de produtos")
	public ResponseEntity<Page<Produto>> buscar(Pageable pageable) {
		return ResponseEntity.ok(buscaProduto.buscar(pageable));
	}
	
	@GetMapping(value = "/{codigo}")
	@Operation(summary = "Busca um produto pelo codigo")
	public ResponseEntity<Produto> buscarPorCodigo(String codigo) {
		return ResponseEntity.ok(buscaProduto.buscarPorCodigo(codigo));
	}
	
	@PostMapping
	@Operation(summary = "Cadastrar um produto")
	public ResponseEntity<Produto> cadastrar(@RequestBody @Valid Produto produto) {
		return ResponseEntity.ok(cadastroProduto.cadastrar(produto));
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um produto")
	public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) {
		return ResponseEntity.ok(cadastroProduto.atualizar(produto));
	}	
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um produto pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
		cadastroProduto.remover(id);
		return ResponseEntity.ok("Removido com sucesso");
	}
}
