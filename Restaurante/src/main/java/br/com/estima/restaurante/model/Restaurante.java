package br.com.estima.restaurante.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Restaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long restauranteId;
	@NotNull
	@Size(min = 2, max = 100)
	private String restauranteNome;
	
	public Restaurante() {

	}

	public Restaurante(Long restauranteId, String restauranteNome) {
		this.restauranteId = restauranteId;
		this.restauranteNome = restauranteNome;
	}

	public Long getRestauranteId() {
		return restauranteId;
	}

	public void setRestauranteId(Long restauranteId) {
		this.restauranteId = restauranteId;
	}

	public String getRestauranteNome() {
		return restauranteNome;
	}

	public void setRestauranteNome(String restauranteNome) {
		this.restauranteNome = restauranteNome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((restauranteId == null) ? 0 : restauranteId.hashCode());
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
		Restaurante other = (Restaurante) obj;
		if (restauranteId == null) {
			if (other.restauranteId != null)
				return false;
		} else if (!restauranteId.equals(other.restauranteId))
			return false;
		return true;
	}

}
