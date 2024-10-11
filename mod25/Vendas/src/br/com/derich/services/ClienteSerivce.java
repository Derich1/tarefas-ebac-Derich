package br.com.derich.services;

import br.com.derich.domain.Cliente;
import br.com.derich.generics.services.GenericService;

public class ClienteSerivce extends GenericService<Cliente> implements IClienteService {

    public ClienteSerivce(){
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse(){
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
