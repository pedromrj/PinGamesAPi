package pingamesapi.dto.Cadastra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import pingamesapi.annotations.CNPJValidator;

public class CadastraEmpresa {
	
	@NotBlank
	private String nomeEmpresa;
	
	@NotBlank
	@CNPJValidator
	private String cnpjEmpresa;
	
	@NotNull
	private double faturamento;

	public String getNome() {
		return nomeEmpresa;
	}

	public void setNome(String nome) {
		this.nomeEmpresa = nome;
	}

	public String getCnpj() {
		return cnpjEmpresa;
	}

	public void setCnpj(String cnpj) {
		this.cnpjEmpresa = cnpj;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}
}
