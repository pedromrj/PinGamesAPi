package pingamesapi.dto.Cadastra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastraGame {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String dataLancamento;
	
	@NotNull
	private double preco;
	
	@NotBlank
	private String genero;
	
	@NotBlank
	private Short faixaEtaria;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private Long plataformaId;
	
	@NotBlank
	private Long empresaId;

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

	public Long getPlataformaId() {
		return plataformaId;
	}

	public void setPlataformaId(Long plataformaId) {
		this.plataformaId = plataformaId;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}
	
	
}
