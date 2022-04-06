package com.harllan.dio.poo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import lombok.Data;

@Data
public class Dev {

	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
		} else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
	}

	public double calcularTotalXp() {
		return this.conteudosConcluidos .stream() .mapToDouble(Conteudo::calcularXp).sum();
	}
	
	public String obterTextoConteudosInscritos() {
		String conteudoInscrito = String.format("Conteúdos Inscritos de %s: %s", this.getNome(), this.getConteudosInscritos());
		return conteudoInscrito;
	}
	
	public String obterTextoConteudosConcluidos() {
		String conteudoConcluido = String.format("Conteúdos Concluídos de %s: %s", this.getNome(), this.getConteudosConcluidos());
		return conteudoConcluido;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Dev dev = (Dev) o;
		return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos)
				&& Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
	}

}
