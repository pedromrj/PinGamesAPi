package pingamesapi.dto.Cadastra;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import pingamesapi.annotations.CPFValidator;
import pingamesapi.annotations.NotInteiro;

public class CadastraUsuario {

	@NotEmpty
	@Size(min = 4)
	@NotInteiro
	private String nome;

	@NotEmpty
	@Size(min = 11, max = 11, message = "Tamanho deve ser 11")
	@CPFValidator
	private String cpf;

	@NotEmpty
	@Size(min = 8, max = 8, message = "Tamanho deve ser 8")
	private String dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
