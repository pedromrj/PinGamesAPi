package pingamesapi.dto.Cadastra;

import javax.validation.constraints.NotBlank;

public class CadastraGame {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String dataLancamento;
	
	@NotBlank
	private double preco;
	
	@NotBlank
	private String genero;
	
	@NotBlank
	private Short faixaEtaria;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private Long id_plataforma;
	
	@NotBlank
	private Long id_empresa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Short getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(Short faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId_plataforma() {
		return id_plataforma;
	}

	public void setId_plataforma(Long id_plataforma) {
		this.id_plataforma = id_plataforma;
	}

	public Long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}
	
}