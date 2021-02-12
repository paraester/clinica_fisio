package Model;

import java.sql.*;
import java.util.ArrayList;

public class AcessoBaseDeDados {
	// private Connection conexao = null;
	private Connection conexao = null;
	private Statement stmt = null;
	private String sql;
	private String arquivoBaseDeDados = "arquivoBaseDeDados.db";
	// arquivo onde salvamos base de dados

	public AcessoBaseDeDados() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection("jdbc:sqlite:" + arquivoBaseDeDados);
		} catch (Exception e) {
			System.out.println("Erro no acesso à Base de dados");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		// Tentar criar statements (declarações) para esta conexao
		try {
			stmt = conexao.createStatement();
		} catch (Exception e) {
			System.out.println("Erro ao criar Tabela arrumado necessária");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		// Virificar se existem as tabelas necessárias nesta base de dados
		// organizar separado depois
		try {
			sql = "CREATE TABLE IF NOT EXISTS clientes " + "(id INT IDENTITY(1,1),"
					+ " nome           VARCHAR(250)    NOT NULL, " + " idade          INT     NOT NULL, "
					+ " endereco       VARCHAR(250), " + " datanascimento       VARCHAR(250), "
					+ " sexo       VARCHAR(250), " + " planosaude       VARCHAR(250), "
					+ " telefone       VARCHAR(250), " + " responsavel       VARCHAR(250), "
					+ " especialidade       VARCHAR(250), " + " datainiciotratamento       VARCHAR(250), "
					+ " datadaavaliacao       VARCHAR(250), " + " medicoresponsavel       VARCHAR(250), "
					+ " qtdesessoesrealizadas       INT , PRIMARY KEY (id))"; // qtdesessoesrealizadas
																				// é
																				// automatica

			// id, nome, idade, endereco, datanascimento, sexo, planosaude,
			// telefone, responsavel, especialidade, datainiciotratamento,
			// datadaavaliacao, medicoresponsavel, qtdesessoesrealizadas,
			// observacaodehoje, medicamento
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE IF NOT EXISTS avaliacao " + "(id   INT  DEFAULT 0,"
					+ " idcliente      INT     NOT NULL, " + " medicoresponsavel         VARCHAR(250), "
					+ " medicamento    VARCHAR(250), " + " observacaodehoje         VARCHAR(350), PRIMARY KEY (id))";

			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			System.out.println("Erro ao criar Tabela clientes e avaliacao necessárias");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		sql = "CREATE TABLE IF NOT EXISTS `arrumado` (  `id` int IDENTITY(1,1),  `nome` varchar(200) DEFAULT NULL,  `rgarrumado` varchar(200) DEFAULT NULL,  PRIMARY KEY (`id`)) ;";
		try {
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("Erro ao criar Tabela arrumado necessária");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public boolean salveCliente(ClientCadastro cliente) {
		int novoId = 0;
		try {
			sql = "SELECT max(id) as ID FROM clientes";
			ResultSet consulta = stmt.executeQuery(sql);
			if (consulta.next()) {
				novoId = consulta.getInt("ID") + 1;
			} else {
				novoId = 1;
			}
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		cliente.setId(novoId);

		sql = "INSERT INTO clientes (id, nome, idade, endereco, datanascimento, sexo, planosaude, telefone, responsavel, especialidade, datainiciotratamento, datadaavaliacao, medicoresponsavel, qtdesessoesrealizadas) VALUES ("
				+ novoId + ", '" + cliente.getNome() + "', '" + cliente.getIdade() + "', '" + cliente.getEndereco()
				+ "', '" + cliente.getDatanascimento() + "', '" + cliente.getSexo() + "', '" + cliente.getPlanosaude()
				+ "', '" + cliente.getTelefone() + "', '" + cliente.getResponsavel() + "', '"
				+ cliente.getEspecialidade() + "', '" + cliente.getDatainiciotratamento() + "', '"
				+ cliente.getDatadaavaliacao() + "', '" + cliente.getMedicoresponsavel() + "', '"
				+ cliente.getQtdesessoesrealizadas() + "');";
		// System.out.println("Tentando rodar SQL: " + sql);
		try {
			// primeiro ver se nao existe neste id 1
			stmt.execute(sql);
			System.out.println("Cliente: " + cliente.getNome() + " Cadastrado na base de dados, com identificador: "
					+ cliente.getId());
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		// salvar avaliacao inicial deste cliente
		salveAvaliacao(cliente);
		return true;
	}

	public void salveAvaliacao(ClientCadastro cliente) {
		int novoId = 0;
		try {
			sql = "SELECT max(id) as ID FROM avaliacao";
			ResultSet consulta = stmt.executeQuery(sql);
			if (consulta.next()) {
				novoId = consulta.getInt("ID") + 1;
			} else {
				novoId = 1;
			}
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		sql = "INSERT INTO avaliacao (id, idcliente, medicoresponsavel, medicamento, observacaodehoje) VALUES ("
				+ novoId + ", '" + +cliente.getId() + "', '" + cliente.getMedicoresponsavel() + "', '"
				+ cliente.getMedicamento() + "', '" + cliente.getObservacaodehoje() + "');";
		try {
			stmt.execute(sql);
			System.out.println("Avaliacao do(a) " + cliente.getNome()
					+ " foi salvo na base de dados, com identificador: " + novoId);
		} catch (Exception e) {
			System.err.println(";;;;" + e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public ClientCadastro getClient(int id) {
		ClientCadastro cliente = new ClientCadastro();
		try {
			ResultSet consulta = stmt.executeQuery("SELECT * FROM clientes WHERE id = " + id + ";");
			if (consulta.next()) {
				// int id = consulta.getInt("id");
				cliente.setId(consulta.getInt("id"));
				cliente.setNome(consulta.getString("nome"));
				cliente.setIdade(consulta.getInt("idade"));
				cliente.setEndereco(consulta.getString("endereco"));
				cliente.setDatanascimento(consulta.getString("datanascimento"));
				cliente.setSexo(consulta.getString("sexo"));
				cliente.setPlanosaude(consulta.getString("planosaude"));
				cliente.setTelefone(consulta.getString("telefone"));
				cliente.setResponsavel(consulta.getString("responsavel"));
				cliente.setEspecialidade(consulta.getString("especialidade"));
				cliente.setDatainiciotratamento(consulta.getString("datainiciotratamento"));
				cliente.setDatadaavaliacao(consulta.getString("datadaavaliacao"));
				cliente.setQtdesessoesrealizadas(consulta.getInt("qtdesessoesrealizadas"));
			}
			stmt.close();
			// conexao.commit();
			// pois 'database in auto-commit mode'
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return cliente;
	}

	public ClientCadastro getClientByName(String inicioNome) {
		ClientCadastro cliente = new ClientCadastro();
		try {
			// Inseguro
			// ResultSet consulta = stmt.executeQuery( "SELECT * FROM clientes
			// WHERE nome like '" + inicioNome + "%';");
			// Livrando-se um pouco de um SqlInjection
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM clientes WHERE nome like ? ;");
			stmt.setString(1, inicioNome + "%");
			ResultSet consulta = stmt.executeQuery();

			if (consulta.next()) {
				// int id = consulta.getInt("id");
				cliente.setId(consulta.getInt("id"));
				cliente.setNome(consulta.getString("nome"));
				cliente.setIdade(consulta.getInt("idade"));
				cliente.setEndereco(consulta.getString("endereco"));
				cliente.setDatanascimento(consulta.getString("datanascimento"));
				cliente.setSexo(consulta.getString("sexo"));
				cliente.setPlanosaude(consulta.getString("planosaude"));
				cliente.setTelefone(consulta.getString("telefone"));
				cliente.setResponsavel(consulta.getString("responsavel"));
				cliente.setEspecialidade(consulta.getString("especialidade"));
				cliente.setDatainiciotratamento(consulta.getString("datainiciotratamento"));
				cliente.setDatadaavaliacao(consulta.getString("datadaavaliacao"));
				cliente.setQtdesessoesrealizadas(consulta.getInt("qtdesessoesrealizadas"));
			}
			stmt.close();
			// conexao.commit();
			// pois 'database in auto-commit mode'
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return cliente;
	}

	public void encerrar() throws SQLException {
		if (conexao.isClosed()) {
			conexao.close();
		}
	}

	public ArrayList<String> getFewClients(String nomeParte) {
		ArrayList<String> algunsClientes = new ArrayList<String>();
		String cliente;
		int limitTexto = 38; // limite de caracteres do nome par ser exibido em
								// menu de opcoes

		try {
			// Inseguro
			// sql = "SELECT nome FROM clientes WHERE nome like '" + nomeParte +
			// "%' ORDER BY nome LIMIT 10;";
			// ResultSet consulta = stmt.executeQuery( sql );
			// Livrando-se um pouco de um SqlInjection
			sql = "SELECT nome FROM clientes WHERE nome LIKE ? ORDER BY nome LIMIT 10;";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nomeParte + "%");
			ResultSet consulta = stmt.executeQuery();

			while (consulta.next()) {
				cliente = consulta.getString("nome");
				if (cliente.length() > limitTexto) {
					cliente = cliente.substring(0, limitTexto);
				}
				algunsClientes.add(cliente);
			}
			stmt.close();
		} catch (Exception e) {
			System.err.println("getFew" + e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return algunsClientes;
	}

	public ArrayList<ArrayList<String>> buscaListaClientes(int chave, String nome, String idade, String sexo,
			String espec, String medico) {
		ArrayList<ArrayList<String>> matrizClientes = new ArrayList<ArrayList<String>>();
		PreparedStatement stmt = null;
		ArrayList<String> tmpLinha;
		String sql;
		if (chave == 1) {
			sql = "SELECT *, avaliacao.medicoresponsavel as medicoresponsavel FROM clientes  LEFT JOIN avaliacao ON clientes.id = avaliacao.idcliente WHERE ";
		} else {
			sql = "SELECT * FROM clientes WHERE ";
		}
		int inome = 0, iidade = 0, isexo = 0, iespec = 0, imedico = 0;
		int qtCampos = 0;

		if (!(nome.equals(""))) {
			if (qtCampos == 0) {
				sql += "nome LIKE ? ";
			} else {
				sql += "AND nome LIKE ? ";
			}
			qtCampos++;
			inome = qtCampos;
		}
		if (!(idade.equals(""))) {
			if (qtCampos == 0) {
				sql += "idade = ? ";
			} else {
				sql += "AND idade = ? ";
			}
			qtCampos++;
			iidade = qtCampos;
		}
		if (!(sexo.equals(""))) {
			if ("Masculino".toLowerCase().contains(sexo.toLowerCase())) {
				sexo = "Masculino";
			} else {
				sexo = "Feminino";
			}
			if (qtCampos == 0) {
				sql += "sexo = ? ";
			} else {
				sql += "AND sexo = ? ";
			}
			qtCampos++;
			isexo = qtCampos;
		}
		if (!(espec.equals(""))) {
			if (qtCampos == 0) {
				sql += "especialidade LIKE ? ";
			} else {
				sql += "AND especialidade LIKE ? ";
			}
			qtCampos++;
			iespec = qtCampos;
		}
		if (!(medico.equals(""))) {
			if (qtCampos == 0) {
				sql += "medicoresponsavel LIKE ? ";
			} else {
				sql += "AND medicoresponsavel LIKE ? ";
			}
			qtCampos++;
			imedico = qtCampos;
		}

		if (inome == 0 && iidade == 0 && isexo == 0 && iespec == 0 && imedico == 0) {
			// buscar 10 primeiro clientes em orde alfabetica
			if (chave == 1) {
				sql = "SELECT *, avaliacao.medicoresponsavel as medicoresponsavel FROM clientes  LEFT JOIN avaliacao ON clientes.id = avaliacao.idcliente ORDER BY nome, avaliacao.id LIMIT 20; ";
			} else {
				sql = "SELECT * FROM clientes ORDER BY nome LIMIT 20; ";
			}

			// sql = "SELECT * FROM clientes ORDER BY nome LIMIT 20;";
		} else {
			// completar sql para buscar pelos campos nao nulos preenchidos pelo
			// usuario
			sql += " ORDER BY nome LIMIT 20;";
		}
		try {
			stmt = conexao.prepareStatement(sql);
		} catch (Exception e) {
			System.err.println("stmt:: " + e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		try {
			if (inome > 0) {
				stmt.setString(inome, "%" + nome + "%");
			}
			if (iidade > 0) {
				stmt.setString(iidade, idade);
			}
			if (isexo > 0) {
				stmt.setString(isexo, sexo);
			}
			if (iespec > 0) {
				stmt.setString(iespec, "%" + espec + "%");
			}
			if (imedico > 0) {
				stmt.setString(imedico, "%" + medico + "%");
			}
		} catch (Exception e) {
			System.err.println("setString:: " + e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		// System.out.println("sql foi " + sql);
		try {
			ResultSet consulta = stmt.executeQuery();
			while (consulta.next()) {
				// na ordem
				// campo id vai primeiro pra uso futuro
				/*
				 * colunas.add("Nome"); colunas.add("Idade");
				 * colunas.add("Telefone"); colunas.add("Nascimento");
				 * colunas.add("Especialidade"); colunas.add("Médico");
				 */
				tmpLinha = new ArrayList<String>();
				tmpLinha.add(consulta.getString("id"));
				tmpLinha.add(consulta.getString("nome"));
				tmpLinha.add(String.valueOf(consulta.getString("idade")));
				if (chave == 0) {
					// clientes
					tmpLinha.add(consulta.getString("telefone"));
					tmpLinha.add(consulta.getString("datanascimento"));
					tmpLinha.add(consulta.getString("especialidade"));
					tmpLinha.add(consulta.getString("medicoresponsavel"));
				} else {
					// dados de clientes e avaliações
					tmpLinha.add(consulta.getString("medicoresponsavel"));
					tmpLinha.add(consulta.getString("medicamento"));
					tmpLinha.add(consulta.getString("observacaodehoje"));
				}
				// System.out.println(" achado nome " +
				// consulta.getString("nome"));

				matrizClientes.add(tmpLinha);

				// idcliente , medicoresponsavel, medicamento , observacaodehoje
				// id, nome, idade, endereco, datanascimento, sexo, planosaude,
				// telefone, responsavel, especialidade, datainiciotratamento,
				// datadaavaliacao, medicoresponsavel, qtdesessoesrealizadas
			}
		} catch (Exception e) {
			System.err.println("tmpLinha:: " + e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return matrizClientes;
	}

}
