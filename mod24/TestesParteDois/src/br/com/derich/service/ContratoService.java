package br.com.derich.service;

import br.com.derich.dao.IContratoDao;

public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    public String buscar(){
        contratoDao.buscar();
        return "Buscado com sucesso";
    }

    public String atualizar(){
        contratoDao.atualizar();
        return "Atualizado com sucesso";
    }

    public String excluir(){
        contratoDao.excluir();
        return "Excluído com sucesso";
    }
}
