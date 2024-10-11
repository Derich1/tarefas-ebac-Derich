package br.com.derich;

import br.com.derich.dao.ClienteDAO;
import br.com.derich.dao.ClienteDAOMock;
import br.com.derich.dao.IClienteDAO;
import br.com.derich.domain.Cliente;
import br.com.derich.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTeste {

    private IClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteDAOTeste(){
        clienteDAO = new ClienteDAOMock();
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
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Derich Rosário");
        clienteDAO.alterar(cliente);
        Assert.assertEquals("Derich Rosário", cliente.getNome());
    }
}
