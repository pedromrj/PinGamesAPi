package pingamesapi.dto.Cadastra;

import javax.validation.constraints.NotBlank;

public class CadastraEmpresa {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cnpj;
	
	@NotBlank
	private double faturamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}
}
