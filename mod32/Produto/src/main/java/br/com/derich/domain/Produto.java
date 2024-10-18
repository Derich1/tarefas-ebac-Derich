package br.com.derich.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_seq")
	@SequenceGenerator(name="produto_seq", sequenceName="sq_produto", initialValue = 1, allocationSize = 1)
	private Long id;
	
    @Column(name = "Nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "Preco", nullable = false)
    private Integer preco;

    @Column(name = "Codigo", nullable = false, unique = true)
    private String codigo;

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
}


