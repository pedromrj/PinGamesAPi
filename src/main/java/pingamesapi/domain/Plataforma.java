package pingamesapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "plataformas")
public class Plataforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "plataforma", unique = true)
	private String tipo;

	@OneToMany(mappedBy = "plataforma")
	private List<Game> jogos = new ArrayList<Game>();


	public Plataforma() {

	}

	public Plataforma(Long id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Game> getJogos() {
		return jogos;
	}

	public void setJogos(List<Game> jogos) {
		this.jogos = jogos;
	}

	public String getPlataforma() {
		return tipo;
	}

	public void setPlataforma(String plataforma) {
		this.tipo = plataforma;
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
		Plataforma other = (Plataforma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
