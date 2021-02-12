package Model;
import java.sql.*;

public class AcessoBaseDeDados {
	//private Connection conexao = null;
	Connection conexao = null;
	Statement stmt = null;
	String arquivoBaseDeDados = "arquivoBaseDeDados.db";
	public AcessoBaseDeDados() {
	    try {
	    	Class.forName("org.sqlite.JDBC");
	    	conexao = DriverManager.getConnection("jdbc:sqlite:" + arquivoBaseDeDados);
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
	    System.out.println("Base de dados foi acessada com sucesso");
	    
	    // Tentar criar statements para esta conexao
	    try {
	    	stmt = conexao.createStatement();
	    } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	    
	    // organizar separado depois, por agora num pacotao so
	    // ver se existe tabela nesta base de dados
	    try {
	        String sql = "CREATE TABLE IF NOT EXISTS clientes " +
	                     "(id INT PRIMARY KEY     NOT NULL," +
	                     " nome           TEXT    NOT NULL, " + 
	                     " idade          INT     NOT NULL, " + 
	                     " endereco       VARCHAR(250), " + 
	                     " telefone       VARCHAR(50))"; 
	        stmt.executeUpdate(sql);
	        stmt.close();
	    } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	    System.out.println("Table created successfully");
        
	    // criar padrao ao menos 1 cliente dentro por testes
	    try {
	    	// primeiro ver se nao existe neste id 1
	    	ResultSet consulta = stmt.executeQuery( "SELECT * FROM clientes WHERE id = 1;" );
	        if ( consulta.next() ) {
	           int id = consulta.getInt("id");
	   	    	System.out.println("cliente de id 1 jah existe na base de dados");
	        } else {
	        	// fazer insert Entaumm
				String sql = "INSERT INTO clientes (id, nome, idade, endereco, telefone) " +
				         "VALUES (1, 'Paula Fernandes', 32, 'Rua Guaira, Guarapuava', '(42) 3622-1212' );"; 
				stmt.executeUpdate(sql);
			    System.out.println("1 cliente adicionado com sucesso");
	        }
			
			stmt.close();
			//conexao.commit();
			// pois 'database in auto-commit mode'
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
	}
	
	public void addClient(Client client){
		System.out.println("Adicionando o(a) cliente " + client.getName());
	}

	public void encerrar() throws SQLException {
		if (conexao.isClosed()) {
			conexao.close();
		}
	}
}
