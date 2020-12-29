package br.argus.agenda.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import br.argus.agenda.entidades.Contato;
import br.argus.agenda.repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorio implements AgendaRepositorio<Contato> {

	private static List<Contato> contatos = new ArrayList<Contato>();

	@Override
	public List<Contato> selecionar() {
		return contatos;
	}

	@Override
	public void inserir(Contato entidade) {
		contatos.add(entidade);
	}

	// Levando em considera��o que a busca ser� feita pelo nome.
	// Provis�rio at� a implementa��o de um Banco de Dados
	@Override
	public void atualizar(Contato entidade) {
		var original = contatos.stream().filter(contato -> contato.getNome().equals(entidade.getNome())).findFirst();
		if (original.isPresent()) {
			original.get().setIdade(entidade.getIdade());
			original.get().setTelefone(entidade.getTelefone());
		}
	}

	@Override
	public void excluir(Contato entidade) {
		contatos.remove(entidade);
	}

}
