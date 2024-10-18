package br.com.derich;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.derich.dao.IProdutoDAO;
import br.com.derich.dao.ProdutoDAO;
import br.com.derich.domain.Produto;

public class ProdutoTeste {

	private IProdutoDAO produtoDAO;
	
	public ProdutoTeste(){
		produtoDAO = new ProdutoDAO();
	}
	
	@Test
	public void cadastrar() {
		Produto produto = new Produto();
		produto.setCodigo("a14");
		produto.setNome("Produto Teste");
		produto.setPreco(8);
		produtoDAO.cadastrar(produto);
		assertNotNull(produto.getNome());
		produtoDAO.excluir(produto);
	}
}
