package br.com.derich.resources;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.derich.domain.Cliente;
import br.com.derich.usecase.BuscarCliente;
import br.com.derich.usecase.CadastroCliente;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResources {

	private BuscarCliente buscarCliente;
	private CadastroCliente cadastroCliente;
	
	@Autowired
	public ClienteResources(BuscarCliente buscarCliente, 
			CadastroCliente cadastroCliente) {
		this.buscarCliente = buscarCliente;
		this.cadastroCliente = cadastroCliente;
	}
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> buscar(Pageable pageable) {
		return ResponseEntity.ok(buscarCliente.buscar(pageable));
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca um cliente pelo id")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscarCliente.buscarPorId(id));
	}
	
	@GetMapping(value = "isCadastrado/{id}")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscarCliente.isCadastrado(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um cliente")
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.atualizar(cliente));
	}	
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um cliente pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
		cadastroCliente.remover(id);
		return ResponseEntity.ok("Removido com sucesso");
	}
}
