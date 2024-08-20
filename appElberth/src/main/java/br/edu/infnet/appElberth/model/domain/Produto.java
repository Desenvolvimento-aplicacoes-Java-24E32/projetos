package br.edu.infnet.appElberth.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "É necessário o preenchimento do campo DESCRICAO.")
	private String descricao;
	
	@Column(unique = true)
	private int codigo;
	
	@Min(value = 5, message = "O PREÇO do produto precisa ser maior ou igual a 5.")
	private float preco;
	private boolean estoque;

	@ManyToOne
	@JoinColumn(name = "idVendedor")
	private Vendedor vendedor;

	@Override
	public String toString() {
		return String.format("%d;%s;%d;%.2f;%s;%s",
				id,
				descricao, 
				codigo, 
				preco, 
				estoque ? "estoque=sim" : "estoque=não",
				vendedor
			);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isEstoque() {
		return estoque;
	}

	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}