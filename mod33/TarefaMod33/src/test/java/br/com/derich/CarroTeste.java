package br.com.derich;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.derich.dao.AcessorioDAO;
import br.com.derich.dao.CarroDAO;
import br.com.derich.dao.IAcessorioDAO;
import br.com.derich.dao.ICarroDAO;
import br.com.derich.dao.IMarcaDAO;
import br.com.derich.dao.MarcaDAO;
import br.com.derich.domain.Acessorio;
import br.com.derich.domain.Carro;
import br.com.derich.domain.Marca;

public class CarroTeste {

private ICarroDAO carroDAO;
private IMarcaDAO marcaDAO;
private IAcessorioDAO acessorioDAO;
	
	public CarroTeste() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
		acessorioDAO = new AcessorioDAO();
	}

	@Test
	public void cadastrar() {
		Carro carro = new Carro();
		Marca marca = new Marca();
		Acessorio acessorio = new Acessorio();
		
		marca.setNome("Honda");
		marca = marcaDAO.cadastrar(marca);
		
		carro.setAno(2024);
		carro.setNome("Civic");
		carro.setMarca(marca);
		carro = carroDAO.cadastrar(carro);
		
		acessorio.setCodigo("A1");
		acessorio.setNome("Vidro fumê");
		acessorio.setPreco(300);
		acessorio = acessorioDAO.cadastrar(acessorio);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
		
		assertNotNull(marca);
		assertNotNull(marca.getId());
		
		assertNotNull(acessorio);
		assertNotNull(acessorio.getId());
	}
}
