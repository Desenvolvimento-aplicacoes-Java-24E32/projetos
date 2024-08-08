package br.edu.infnet.appElberth.model.domain;

public abstract class Produto {

	private Integer id;

	private String descricao;
	private int codigo;
	private float preco;
	private boolean estoque;

	@Override
	public String toString() {
		return String.format("%d;%s;%d;%.2f;%s",
				id,
				descricao, 
				codigo, 
				preco, 
				estoque ? "estoque=sim" : "estoque=não"
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
}