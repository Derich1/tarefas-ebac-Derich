package br.com.derich;

import br.com.derich.dao.ClienteDAO;
import br.com.derich.dao.IClienteDAO;
import br.com.derich.domain.Cliente;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteTeste {

    @Test
    public void cadastrarTeste() throws Exception {

        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Derich");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertNotNull(clienteBD.getId());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void atualizarTeste() throws Exception {

        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Derich");
        dao.cadastrar(cliente);

        cliente.setNome("Rodrigo");
        cliente.setCodigo("412");
        dao.atualizar(cliente);

        assertEquals(cliente.getCodigo(), "412");
        assertEquals(cliente.getNome(), "Rodrigo");

        List<Cliente> listaCliente = dao.buscarTodos();
        for (Cliente lista : listaCliente){
            dao.excluir(lista);
        }
    }

    @Test
    public void buscarTodos() throws Exception {

        Cliente cliente = new Cliente();
        Cliente cliente1 = new Cliente();
        IClienteDAO clienteDAO = new ClienteDAO();

        cliente.setCodigo("10");
        cliente.setNome("Derich");

        cliente1.setCodigo("11");
        cliente1.setNome("Marcos");

        clienteDAO.cadastrar(cliente);
        clienteDAO.cadastrar(cliente1);

        List<Cliente> listaClientes = clienteDAO.buscarTodos();

        assertEquals(2, listaClientes.size());

        for (Cliente lista : listaClientes){
            clienteDAO.excluir(lista);
        }

        assertEquals(listaClientes.size(), 2);
    }
}

