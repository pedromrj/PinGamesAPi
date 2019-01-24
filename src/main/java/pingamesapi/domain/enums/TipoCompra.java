package pingamesapi.domain.enums;

public enum TipoCompra {
	
	PEDENTE(1, "PENDENTE"),
	QUITADO(2, "QUITADO");
	
	private int cod;
	private String descricao;

	private TipoCompra(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCompra toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCompra x : TipoCompra.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id Invalido: " + cod);
	}
}
