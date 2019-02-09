package pingamesapi.dto;

import java.util.List;

public class PageDTO {
	
	private List<?> listagem;

	private int paginalAtual;
	
	private int paginaFinal;
	
	private int quantidadeDePaginas;
	
	private int proxPagina;
	
	private int paginaAnterior;
	
	private int qtdItens;
	
	public PageDTO () {
		
	}
	
	public PageDTO(List<?> listagem, int paginalAtual, int paginaFinal, int quantidadeDePaginas, int proxPagina,
			int paginaAnterior, int qtdItens) {
		this.listagem = listagem;
		this.paginalAtual = paginalAtual;
		this.paginaFinal = paginaFinal;
		this.quantidadeDePaginas = quantidadeDePaginas;
		this.proxPagina = proxPagina;
		this.paginaAnterior = paginaAnterior;
		this.qtdItens = qtdItens;
	}

	public List<?> getListagem() {
		return listagem;
	}

	public void setListagem(List<?> listagem) {
		this.listagem = listagem;
	}

	public int getPaginalAtual() {
		return paginalAtual;
	}

	public void setPaginalAtual(int paginalAtual) {
		this.paginalAtual = paginalAtual;
	}

	public int getPaginaFinal() {
		return paginaFinal;
	}

	public void setPaginaFinal(int paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	public int getQuantidadeDePaginas() {
		return quantidadeDePaginas;
	}

	public void setQuantidadeDePaginas(int quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public int getProxPagina() {
		return proxPagina;
	}

	public void setProxPagina(int proxPagina) {
		this.proxPagina = proxPagina;
	}

	public int getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(int paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

	public int getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}
}
