package br.com.derich.dao;

import br.com.derich.domain.Produto;

public interface IProdutoDAO {
	 public Produto cadastrar(Produto produto);
	 public void excluir(Produto produto);
}
