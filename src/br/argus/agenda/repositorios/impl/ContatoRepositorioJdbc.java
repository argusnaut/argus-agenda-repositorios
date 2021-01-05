package br.argus.agenda.repositorios.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.argus.agenda.entidades.Contato;
import br.argus.agenda.repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorioJdbc implements AgendaRepositorio<Contato> {

	@Override
	public List<Contato> selecionar() throws SQLException {
		Connection conexao = null;
		List<Contato> contatos = new ArrayList<Contato>();
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/argus_jdbc", "argusnaut", "root123");
			Statement comando = conexao.createStatement();
			ResultSet rs = comando.executeQuery("SELECT * FROM contatos");
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contatos.add(contato);
			}
		} finally {
			if (conexao != null) {
				conexao.close();
			}
		}
		return contatos;
	}

	@Override
	public void inserir(Contato entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Contato entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Contato entidade) {
		// TODO Auto-generated method stub

	}

}
