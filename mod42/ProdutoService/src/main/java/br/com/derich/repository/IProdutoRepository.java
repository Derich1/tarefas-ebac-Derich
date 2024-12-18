package br.com.derich.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.derich.domain.Produto;
import br.com.derich.domain.Produto.Status;

@Repository
public interface IProdutoRepository extends MongoRepository<Produto, String> {

	Optional<Produto> findByCodigo(String codigo);
}
