package br.com.estima.restaurante.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Prato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pratoId;
	@ManyToOne
	@JoinColumn(name = "restaurante_id", nullable = false)
	private Restaurante restaurante;
	@NotNull
	@Size(min = 2, max = 100)
	private String pratoNome;
	private Double pratoPreco;

	public Prato() {

	}

	public Prato(Long pratoId, Restaurante restaurante, String pratoNome, Double pratoPreco) {
		this.pratoId = pratoId;
		this.restaurante = restaurante;
		this.pratoNome = pratoNome;
		this.pratoPreco = pratoPreco;
	}

	public Long getPratoId() {
		return pratoId;
	}

	public void setPratoId(Long pratoId) {
		this.pratoId = pratoId;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public String getPratoNome() {
		return pratoNome;
	}

	public void setPratoNome(String pratoNome) {
		this.pratoNome = pratoNome;
	}

	public Double getPratoPreco() {
		return pratoPreco;
	}

	public void setPratoPreco(Double pratoPreco) {
		this.pratoPreco = pratoPreco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pratoId == null) ? 0 : pratoId.hashCode());
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
		Prato other = (Prato) obj;
		if (pratoId == null) {
			if (other.pratoId != null)
				return false;
		} else if (!pratoId.equals(other.pratoId))
			return false;
		return true;
	}

}
