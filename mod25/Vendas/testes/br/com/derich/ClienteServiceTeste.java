package br.com.derich;

import br.com.derich.domain.Cliente;
import br.com.derich.exceptions.TipoChaveNaoEncontradaException;
import br.com.derich.services.ClienteSerivce;
import br.com.derich.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTeste {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTeste(){
        clienteService = new ClienteSerivce();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(1231231231L);
        cliente.setNome("Derich");
        cliente.setCidade("Jundiaí");
        cliente.setEndereco("Rua hércules malatesta");
        cliente.setEstado("Sp");
        cliente.setTel(1991270791L);
        cliente.setNumero(182);
        clienteService.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteService.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Derich Rosário");
        clienteService.alterar(cliente);
        Assert.assertEquals("Derich Rosário", cliente.getNome());
    }
}
