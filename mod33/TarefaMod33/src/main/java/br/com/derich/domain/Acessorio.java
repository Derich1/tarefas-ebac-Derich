package br.com.derich.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "tb_acessorio")
public class Acessorio {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acessorios_seq")
	@SequenceGenerator(name="acessorios_seq", sequenceName="sq_acessorios", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "Nome", nullable = false, unique = true)
	private String nome;
	
	@Column(name = "Preco", nullable = false)
	private Integer preco;
	
	@Column(name = "Codigo", nullable = false)
	private String codigo;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "TB_ACESSORIO_CARRO", 
        joinColumns = { @JoinColumn(name = "id_acessorio_fk") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_carro_fk") }
    )
	private List<Carro> carros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
}
