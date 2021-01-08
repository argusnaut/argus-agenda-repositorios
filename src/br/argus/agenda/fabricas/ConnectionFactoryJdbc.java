package br.argus.agenda.fabricas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryJdbc {

	public static Connection criarConnexao() throws IOException, SQLException {

		InputStream is = ConnectionFactoryJdbc.class.getClassLoader().getResourceAsStream("application.properties");
		if (is == null) {
			throw new FileNotFoundException("O arquivo de configuração do Banco de Dados não foi encontrado.");
		}
		Properties props = new Properties();
		props.load(is);
		Connection conexao = DriverManager.getConnection(props.getProperty("urlConnection"), props.getProperty("userConnection"), props.getProperty("passwordConnection"));
		return conexao;
	}

}
