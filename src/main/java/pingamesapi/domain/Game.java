package pingamesapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "games")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="game_nome")
	private String nome;

	@Column(name = "game_lancamento", length = 8)
	private String dataLancamento;
	
	@Column(name = "game_preco",precision = 2)
	private double preco;
	
	@Column(name = "game_genero")
	private String genero;

	@Column(name = "game_faixa_etaria")
	private Short faixaEtaria;
	
	@Column(name = "game_descricao", unique = true , length = 150)
	private String descricao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "plataforma_id")
	private Plataforma plataforma;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "empresas_id")
	private Empresa empresa;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "COMPRA_GAMES", joinColumns = @JoinColumn(name = "compras_id"), inverseJoinColumns = @JoinColumn(name = "games_id"))
	private List<Compra> compras = new ArrayList<Compra>();
	
	@ManyToMany
	@JoinTable(name = "BIBLIOTECA_GAMES", joinColumns = @JoinColumn(name = "bibliotecas_id"), inverseJoinColumns = @JoinColumn(name = "games_id"))
	private List<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();

	public Game() {

	}

	public Game(Long id, String nome, String dataLancamento, double preco, String genero, Short faixaEtaria,
			String descricao, Plataforma plataforma, Empresa empresa) {
		this.id = id;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
		this.genero = genero;
		this.faixaEtaria = faixaEtaria;
		this.descricao = descricao;
		this.plataforma = plataforma;
		this.empresa = empresa;
	}

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

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compra) {
		this.compras = compra;
	}

	public List<Biblioteca> getJogos() {
		return bibliotecas;
	}

	public void setJogos(List<Biblioteca> jogos) {
		this.bibliotecas = jogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
